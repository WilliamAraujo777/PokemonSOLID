package com.pokemon.domain.singleton;

import com.pokemon.domain.model.Jogador;

import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private static Batalha instancia; // Única instância da batalha
    private Jogador jogador1;
    private Jogador jogador2;
    private boolean finalizada;
    private Scanner scanner = new Scanner(System.in);

    private Batalha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.finalizada = false;
    }

    public static Batalha iniciarBatalha(Jogador jogador1, Jogador jogador2) {
        if (instancia == null) {
            instancia = new Batalha(jogador1, jogador2);
        } else {
            System.out.println("⚠️ Já existe uma batalha em andamento!");
        }
        return instancia;
    }

    public static void resetarBatalha() {
        instancia = null;
    }

    public void iniciar() {
        if (finalizada) {
            System.out.println("⚠️ Essa batalha já terminou!");
            return;
        }

        System.out.println("Iniciando batalha entre " + jogador1.getNome() + " e " + jogador2.getNome() + "!");

        while (!finalizada) {
            turno(jogador1, jogador2);
            if (verificarVencedor()) break;

            turno(jogador2, jogador1);
            if (verificarVencedor()) break;
        }

        resetarBatalha();
    }

    private void turno(Jogador atacante, Jogador defensor) {
        System.out.println("\nEstado Atual dos Pokémon:");
        System.out.println(atacante.getPokemon());
        System.out.println(atacante.getPokemon().contadorEspecial());
        System.out.println("\n🔽 VS 🔽\n");
        System.out.println(defensor.getPokemon());
        System.out.println(defensor.getPokemon().contadorEspecial());

        System.out.println("\nTurno de " + atacante.getNome() + "!");

        int escolha = scanner.nextInt();

        boolean passarTurno = false;

        while(!passarTurno){
            switch(escolha){
                case 1:
                    atacante.getPokemon().ataqueBasico(defensor.getPokemon());
                    passarTurno = true;
                    break;
                case 2:
                    atacante.getPokemon().ataqueEspecial(defensor.getPokemon());
                    passarTurno = true;
                    break;
                case 3:
                    //usarItem(atacante);
                    passarTurno = true;
                    break;
                default:
                    System.out.println("Opção inválida! Perdeu a vez.");
            }
        }
    }

    private boolean verificarVencedor() {
        if (finalizada) {
            System.out.println("\nBatalha encerrada! " + (jogador1.getPokemon().getHp() <= 0 ? jogador2.getNome() : jogador1.getNome()) + " venceu!");
            return true;
        }
        return false;
    }
}
