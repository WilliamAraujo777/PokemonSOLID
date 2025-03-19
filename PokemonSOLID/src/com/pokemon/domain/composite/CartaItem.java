package com.pokemon.domain.composite;

import com.pokemon.domain.composite.enums.ItemENUM;

public class CartaItem implements ItemComponent {
    private ItemENUM item;

    public CartaItem(ItemENUM item) {
        this.item = item;
    }

    @Override
    public void exibir() {
        System.out.println("Carta de Item: " + item.getNome());
    }
}
