package com.pokemon.domain.model;
import com.pokemon.domain.composite.ItemComponent;

public class Jogador {
    String nome;
    Pokemon pokemon;
    private ItemComponent cartas;

    public Jogador(String nome, Pokemon pokemon, ItemComponent cartas) {
        this.nome = nome;
        this.pokemon = pokemon;
        this.cartas = cartas;
    }

    public void exibirCartas() {
        System.out.println("Jogador: " + nome);
        System.out.println("Pokémon Ativo: " + pokemon.getNome());
        cartas.exibir();
    }

    public void setCartas(ItemComponent cartas) {
        this.cartas = cartas;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getNome() {
        return nome;
    }

}
