package com.pokemon.domain.composite;

import com.pokemon.domain.model.Pokemon;

public interface ItemComponent {
    boolean usar(Pokemon pokemon, String nomeItem);
    void exibir();
    String getNome();
}
