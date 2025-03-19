package com.pokemon.domain.composite;

import java.util.ArrayList;
import java.util.List;

public class DeckItems implements ItemComponent{
    private List<ItemComponent> cartas = new ArrayList<>();

    public void adicionarCarta(ItemComponent carta) {
        cartas.add(carta);
    }

    public void removerCarta(ItemComponent carta) {
        cartas.remove(carta);
    }

    @Override
    public void exibir() {
        System.out.println("Deck contém:");
        for (ItemComponent carta : cartas) {
            carta.exibir();
        }
    }
}
