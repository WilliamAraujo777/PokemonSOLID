package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public class AttackPotion implements ItemStrategy {
    @Override
    public String getNome() {
        return "AttackPotion";
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        return pokemon.ativarBuffAtaque(20);
    }
}