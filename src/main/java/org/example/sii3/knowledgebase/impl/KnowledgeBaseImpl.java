package org.example.sii3.knowledgebase.impl;

import lombok.Builder;
import org.example.sii3.entity.Hero;
import org.example.sii3.entity.Item;
import org.example.sii3.entity.Role;
import org.example.sii3.entity.Team;
import org.example.sii3.knowledgebase.KnowledgeBase;

import java.util.List;
import java.util.Map;

/**
 * База знаний
 * @author danya
 */

@Builder
public class KnowledgeBaseImpl implements KnowledgeBase {

    private final Map<String, Hero> heroes;

    public KnowledgeBaseImpl(Map<String, Hero> coll) {
        heroes = coll;
        init();
    }

    private void init() {
        Team dire = new Team("dire");
        Team radiant = new Team("radiant");

        Role role1 = new Role(1);
        Role role2 = new Role(2);
        Role role3 = new Role(3);
        Role role4 = new Role(4);
        Role role5 = new Role(5);
        Role role6 = new Role(6);

        Item morbidMask = new Item("morbid-mask", 900);
        Item blinkDagger = new Item("blink-dagger", 2250);
        Item handOfMidas = new Item("hand-of-midas", 2200);
        Item bladeMail = new Item("blade-mail", 2100);
        Item daedalus = new Item("daedalus", 5100);
        Item satanic = new Item("satanic", 5050);
        Item blackKingBar = new Item("black-king-bar", 4050);
        Item monkeyKingBar = new Item("monkey-king-bar", 4900);
        Item abyssalBlade = new Item("abyssal-blade", 6250);
        Item assaultCuirass = new Item("assault-cuirass", 5125);

        Hero razor = new Hero("razor", dire, role1, null, List.of(morbidMask, blackKingBar, abyssalBlade, monkeyKingBar, assaultCuirass), List.of(assaultCuirass));
        Hero task = new Hero("task", radiant, role5, razor, List.of(bladeMail, handOfMidas, daedalus, satanic), List.of(blackKingBar));
        Hero ursa = new Hero("ursa", dire, role6, task, List.of(morbidMask, abyssalBlade, blinkDagger), List.of(satanic));
        Hero invoker = new Hero("invoker", dire, role3, ursa, List.of(handOfMidas, blackKingBar), List.of(monkeyKingBar, blackKingBar));
        Hero clinkz = new Hero("clinkz", dire, role4, invoker, List.of(daedalus, monkeyKingBar), List.of(bladeMail));
        Hero antimage = new Hero("anti-mage", dire, role5, clinkz, List.of(assaultCuirass, blinkDagger, satanic, bladeMail), List.of(bladeMail));
        Hero clockwerk = new Hero("clockwerk", radiant, role1, antimage, List.of(bladeMail, blackKingBar, monkeyKingBar), List.of(blackKingBar));
        Hero luna = new Hero("luna", radiant, role1, clockwerk, List.of(satanic, daedalus, handOfMidas, assaultCuirass), List.of(handOfMidas));
        Hero lina = new Hero("lina", radiant, role3, luna, List.of(daedalus, monkeyKingBar, blinkDagger, morbidMask), List.of(bladeMail));
        Hero bloodseeker = new Hero("bloodseeker", radiant, role2, lina, List.of(blackKingBar, assaultCuirass, abyssalBlade), List.of(abyssalBlade));
        razor.setDangerHero(bloodseeker);

        heroes.put("razor", razor);
        heroes.put("task", task);
        heroes.put("invoker", invoker);
        heroes.put("clinkz", clinkz);
        heroes.put("anti-mage", antimage);
        heroes.put("clockwerk", clockwerk);
        heroes.put("ursa", ursa);
        heroes.put("luna", luna);
        heroes.put("lina", lina);
        heroes.put("bloodseeker", bloodseeker);
    }

    @Override
    public Map<String, Hero> getKnowledgeBase() {
        return heroes;
    }
}
