package com.pokemon.domain.model;

import com.pokemon.domain.composite.*;
import com.pokemon.domain.factory.ItemFactory;
import com.pokemon.domain.strategy.ItemStrategy;

public class Jogador {
    private String nome;
    private Pokemon pokemon;
    private DeckItens itens;

    public Jogador(String nome, Pokemon pokemon) {
        this.nome = nome;
        this.pokemon = pokemon;
        this.itens = new DeckItens(); // Inicializa um deck vazio por padrão
    }

    public void exibirItens() {
        if (itens.getItens().isEmpty()) {
            System.out.println(nome + " não possui itens.");
        } else {
            System.out.println("Itens de " + nome + ":");
            itens.exibir();
        }
    }

    public boolean usarItem(String nomeItem) {
        if (itens.getItens().isEmpty()) {
            System.out.println(nome + " não tem itens para usar!");
            return false;
        }

        return itens.usar(pokemon, nomeItem);
    }

    public void adicionarItem(String tipo) {
        ItemStrategy item = ItemFactory.criarItem(tipo);
        CartaItem cartaItem = new CartaItem(item);
        itens.adicionarItem(cartaItem);
    }

    public void removerItem(String nomeItem) {
        itens.removerItem(nomeItem);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getNome() {
        return nome;
    }
}
