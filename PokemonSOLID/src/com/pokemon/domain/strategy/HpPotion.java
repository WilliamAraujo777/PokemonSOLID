package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public class HpPotion implements ItemStrategy {
    @Override
    public String getNome() {
        return "HpPotion";
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        return pokemon.curar(40);
    }
}