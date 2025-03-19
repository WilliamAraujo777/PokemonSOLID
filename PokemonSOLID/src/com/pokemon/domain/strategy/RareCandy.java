package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public class RareCandy implements ItemStrategy {
    @Override
    public void usar(Pokemon pokemon) {
        if (pokemon.evoluir()) {
            System.out.println("✨ " + pokemon.getNome() + " evoluiu!");
        } else {
            System.out.println("⚠ " + pokemon.getNome() + " já está na forma final!");
        }
    }
}