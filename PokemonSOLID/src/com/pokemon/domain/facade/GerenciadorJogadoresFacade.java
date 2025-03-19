package com.pokemon.domain.facade;

import com.pokemon.domain.model.Jogador;
import com.pokemon.domain.model.Pokemon;
import com.pokemon.domain.composite.DeckItens;
import com.pokemon.domain.model.enums.PokemonENUM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GerenciadorJogadoresFacade {
    private Scanner scanner = new Scanner(System.in);

    public Jogador criarJogador(int numeroJogador) {
        System.out.println("\nJogador " + numeroJogador + ", digite seu nome:");
        String nome = scanner.nextLine();

        // Filtra apenas os Pokémon de estágio "Básico"
        List<PokemonENUM> opcoesBasicas = Arrays.stream(PokemonENUM.values())
                .filter(p -> p.getEstagio().equalsIgnoreCase("Básico"))
                .toList();

        System.out.println("\nEscolha seu Pokémon:");

        for (int i = 0; i < opcoesBasicas.size(); i++) {
            System.out.println((i + 1) + " - " + opcoesBasicas.get(i).getNome());
        }

        PokemonENUM escolha = null;
        while (escolha == null) {
            try {
                System.out.print("\nDigite o número correspondente ao Pokémon: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                if (opcao >= 1 && opcao <= opcoesBasicas.size()) {
                    escolha = opcoesBasicas.get(opcao - 1);
                } else {
                    System.out.println("Opção inválida! Escolha um número da lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        Pokemon pokemonEscolhido = new Pokemon(escolha);
        DeckItens deckItens = new DeckItens();

        System.out.println(nome + " escolheu " + escolha.getNome() + "!\n");

        return new Jogador(nome, pokemonEscolhido);
    }
}