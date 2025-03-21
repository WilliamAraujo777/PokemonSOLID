package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public class RareCandy implements ItemStrategy {
    @Override
    public String getNome() {
        return "RareCandy";
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        return pokemon.evoluir();
    }
}