package com.pokemon.domain.factory;

import com.pokemon.domain.strategy.*;

public class ItemFactory {

    public static ItemStrategy criarItem(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "attackpotion"   -> new AttackPotion();
            case "defensepotion"   -> new DefensePotion();
            case "hppotion"    -> new HpPotion();
            case "rarecandy"  -> new RareCandy();
            default -> throw new IllegalArgumentException("Tipo de item desconhecido: " + tipo);
        };
    }

}
