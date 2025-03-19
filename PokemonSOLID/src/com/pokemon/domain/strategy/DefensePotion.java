package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public class DefensePotion implements ItemStrategy{
    @Override
    public String getNome() {
        return "DefensePotion";
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        return pokemon.ativarBuffDefesa(20);
    }
}
