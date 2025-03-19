package com.pokemon.domain;

import com.pokemon.domain.model.Jogador;
import com.pokemon.domain.model.Pokemon;
import com.pokemon.domain.model.enums.PokemonENUM;
import com.pokemon.domain.singleton.Batalha;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon(PokemonENUM.SQUIRTLE);
        Pokemon charmander = new Pokemon(PokemonENUM.CHARMANDER);

        Jogador jogador1 = new Jogador("Ash", pikachu);
        Jogador jogador2 = new Jogador("Gary", charmander);


        Batalha batalha = Batalha.iniciarBatalha(jogador1, jogador2);

        batalha.iniciar();
    }
}