package org.example.sii3.executor.impl;

import lombok.Builder;
import org.example.sii3.entity.Hero;
import org.example.sii3.entity.Item;
import org.example.sii3.executor.Executor;
import org.example.sii3.knowledgebase.KnowledgeBase;
import org.example.sii3.utils.Request;

import java.util.NoSuchElementException;

/**
 * Выполнитель запросов, здесь происходит обращение в базе знаний, на основе которой строятся рекомендации
 * @author danya
 */

@Builder
public class ExecutorImpl implements Executor {

    private final KnowledgeBase knowledgeBase;

    public ExecutorImpl(
            KnowledgeBase knowledgeBase
    ) {
        this.knowledgeBase = knowledgeBase;
    }

    @Override
    public void execute(Request request) {
        switch (request.getReqType()) {
            case WHO_COUNTERPICK -> whoCounterpick(request);
            case WHAT_COUNTERPICK -> whatCounterpick(request);
            case BEST_ROLE -> bestRole(request);
            case WHAT_BUY -> whatBuy(request);
        }
    }


    private void whoCounterpick(Request request) {
        try {
            Hero hero = knowledgeBase.getKnowledgeBase().get(request.getFirstParam());
            System.out.println("героя " + hero.getName() + " контрит " + hero.getDangerHero().getName());
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("герой не найден");
        }
    }

    private void whatCounterpick(Request request) {
        try {
            Hero hero = knowledgeBase.getKnowledgeBase().get(request.getFirstParam());
            StringBuilder sb = new StringBuilder();
            sb.append("героя ").append(hero.getName()).append(" контрит ");
            for (Item item : hero.getDangerItems()) {
                sb.append(item.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb);
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("герой не найден");
        }
    }

    private void bestRole(Request request) {
        try {
            Hero hero = knowledgeBase.getKnowledgeBase().get(request.getFirstParam());
            System.out.println("лучшая роль героя " + hero.getName() + " - " + hero.getRole().getNumberRole());
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("герой не найден");
        }
    }

    private void whatBuy(Request request) {
        try {
            Hero hero = knowledgeBase.getKnowledgeBase().get(request.getFirstParam());
            StringBuilder sb = new StringBuilder();

            if (request.getSecondParam() == null) {
                sb.append("на героя ").append(hero.getName()).append(" купите ");
                for (Item item : hero.getItems()) {
                    sb.append(item.getName()).append(", ");
                }
            } else {
                int money = Integer.parseInt(request.getSecondParam());
                sb.append("за ").append(request.getSecondParam()).append(" на героя ").append(hero.getName()).append(" купите ");
                for (Item item : hero.getItems()) {
                    money -= item.getPrice();
                    if (money > 0) {
                        sb.append(item.getName()).append(", ");
                    }
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb);
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("герой не найден");
        }
    }
}
