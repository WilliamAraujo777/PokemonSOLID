package com.pokemon.domain.singleton;

import com.pokemon.domain.facade.GerenciadorDeItensFacade;
import com.pokemon.domain.facade.GerenciadorJogadoresFacade;
import com.pokemon.domain.model.Jogador;
import com.pokemon.domain.strategy.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private static Batalha instancia; // Única instância da batalha
    private Jogador jogador1,jogador2;
    private boolean finalizada;

    private GerenciadorDeItensFacade gerenciadorItens = new GerenciadorDeItensFacade();

    private Scanner scanner = new Scanner(System.in);

    private Batalha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.finalizada = false;
    }

    public static Batalha iniciarBatalha(Jogador jogador1, Jogador jogador2) {
        if (instancia == null) {
            GerenciadorJogadoresFacade ger = new GerenciadorJogadoresFacade();
            instancia = new Batalha(ger.criarJogador(1), ger.criarJogador(2));
        } else {
            System.out.println("Já existe uma batalha em andamento!");
        }
        return instancia;
    }

    public static void resetarBatalha() {
        instancia = null;
    }

    public void iniciar() {
        if (finalizada) {
            System.out.println("Essa batalha já terminou!");
            return;
        }

        List<ItemStrategy> opcoesItens = List.of(new HpPotion(), new RareCandy(), new AttackPotion(), new DefensePotion());

        gerenciadorItens.distribuirItensIniciais(jogador1, opcoesItens);
        gerenciadorItens.distribuirItensIniciais(jogador2, opcoesItens);

        System.out.println("Iniciando batalha entre " + jogador1.getNome() + " e " + jogador2.getNome() + "!");

        while (!finalizada) {
            turno(jogador1, jogador2);
            if (verificarVencedor()) break;

            turno(jogador2, jogador1);
            if (verificarVencedor()) break;

            gerenciadorItens.avancarTurno();
            gerenciadorItens.verificarDistribuicaoDeItem(jogador1, opcoesItens);
            gerenciadorItens.verificarDistribuicaoDeItem(jogador2, opcoesItens);
        }

        resetarBatalha();
    }


    private void turno(Jogador atacante, Jogador defensor) {
        System.out.println("\n══════════════════════════════");
        System.out.println("🌟 ESTADO ATUAL DOS POKÉMON 🌟");
        System.out.println("══════════════════════════════\n");

        System.out.println("🔵 " + atacante.getNome() + " - Pokémon Ativo:");
        System.out.println(atacante.getPokemon());
        System.out.println(atacante.getPokemon().contadorEspecial());

        System.out.println("\n🔽 VS 🔽\n");

        System.out.println("🔴 " + defensor.getNome() + " - Pokémon Adversário:");
        System.out.println(defensor.getPokemon());
        System.out.println(defensor.getPokemon().contadorEspecial());

        System.out.println("\n══════════════════════════════");
        System.out.println("🎮 Turno de " + atacante.getNome() + "!");
        System.out.println("══════════════════════════════\n");

        System.out.println("🎒 Itens disponíveis:");
        atacante.exibirItens();

        boolean passarTurno = false;

        while (!passarTurno) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1️⃣ - Ataque Básico ⚔️");
            System.out.println("2️⃣ - Ataque Especial 🌟");
            System.out.println("3️⃣ - Usar Item 🎒");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    atacante.getPokemon().ataqueBasico(defensor.getPokemon());
                    passarTurno = true;
                    break;
                case 2:
                    atacante.getPokemon().ataqueEspecial(defensor.getPokemon());
                    passarTurno = true;
                    break;
                case 3:
                    System.out.println("Digite o nome do item que deseja usar:");
                    String nomeItem = scanner.next();
                    if (atacante.usarItem(nomeItem)) {
                        atacante.removerItem(nomeItem);
                        System.out.println("Item " + nomeItem + " usado e removido do deck!");
                    } else {
                        System.out.println("Não foi possível usar o item.");
                    }
                    passarTurno = true;
                    break;
                default:
                    System.out.println("Opção inválida! Perdeu a vez.");
                    passarTurno = true;
            }
        }
    }


    private boolean verificarVencedor() {
        if (jogador1.getPokemon().getHp() <= 0) {
            System.out.println("\nBatalha encerrada! " + jogador2.getNome() + " venceu!");
            finalizada = true;
            return true;
        } else if (jogador2.getPokemon().getHp() <= 0) {
            System.out.println("\nBatalha encerrada! " + jogador1.getNome() + " venceu!");
            finalizada = true;
            return true;
        }
        return false;
    }
}
