package com.pokemon.domain.composite;

import com.pokemon.domain.model.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class DeckItens implements ItemComponent {
    private List<ItemComponent> itens = new ArrayList<>();

    public void adicionarItem(ItemComponent item) {
        itens.add(item);
    }

    public List<ItemComponent> getItens() {
        return itens;
    }

    public void removerItem(String nomeItem) {
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nomeItem));
    }

    public boolean usar(Pokemon pokemon, String nomeItem) {
        for (ItemComponent item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return item.usar(pokemon, nomeItem);

            }
        }
        return false;
    }

    @Override
    public void exibir() {
        System.out.println("Deck de Itens:");
        for (ItemComponent item : itens) {
            item.exibir();
        }
    }

    @Override
    public String getNome() {
        return "Deck de Itens";
    }
}
