package com.pokemon.domain.strategy;

import com.pokemon.domain.model.Pokemon;

public interface ItemStrategy {
    String getNome();

    boolean usar(Pokemon pokemon);
}