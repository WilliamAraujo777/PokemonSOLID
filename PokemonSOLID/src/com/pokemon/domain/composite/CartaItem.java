package com.pokemon.domain.composite;

import com.pokemon.domain.model.Pokemon;
import com.pokemon.domain.strategy.ItemStrategy;

public class CartaItem implements ItemComponent {
    private ItemStrategy itemStrategy;

    public CartaItem(ItemStrategy itemStrategy) {
        this.itemStrategy = itemStrategy;
    }

    @Override
    public String getNome() {
        return itemStrategy.getNome();
    }

    @Override
    public boolean usar(Pokemon pokemon, String nomeItem) {
        return itemStrategy.usar(pokemon);
    }

    @Override
    public void exibir() {
        System.out.println("Carta de Item: " + itemStrategy.getNome());
    }
}
