package com.pokemon.domain.facade;

import com.pokemon.domain.model.Jogador;
import com.pokemon.domain.composite.CartaItem;
import com.pokemon.domain.strategy.ItemStrategy;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeItensFacade {
    private static final int ITENS_INICIAIS = 5;
    private static final int TURNOS_PARA_NOVO_ITEM = 5;
    private int turnoAtual = 1;
    private Scanner scanner = new Scanner(System.in);

    public void distribuirItensIniciais(Jogador jogador, List<ItemStrategy> opcoesItens) {
        System.out.println("Jogador " + jogador.getNome() + ", escolha " + ITENS_INICIAIS + " itens para começar:");
        selecionarItens(jogador, opcoesItens, ITENS_INICIAIS);
    }

    public void verificarDistribuicaoDeItem(Jogador jogador, List<ItemStrategy> opcoesItens) {
        if (turnoAtual % TURNOS_PARA_NOVO_ITEM == 0) {
            System.out.println("Turno " + turnoAtual + ": " + jogador.getNome() + " pode escolher um novo item.");
            selecionarItens(jogador, opcoesItens, 1);
        }
    }

    private void selecionarItens(Jogador jogador, List<ItemStrategy> opcoesItens, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Escolha um item:");
            for (int j = 0; j < opcoesItens.size(); j++) {
                System.out.println((j + 1) + " - " + opcoesItens.get(j).getNome());
            }

            int escolha = scanner.nextInt() - 1;

            if (escolha >= 0 && escolha < opcoesItens.size()) {
                String tipoItem = opcoesItens.get(escolha).getNome();
                jogador.adicionarItem(tipoItem);
                System.out.println("Item " + tipoItem + " adicionado!");
            } else {
                System.out.println("Escolha inválida, tente novamente.");
                i--; // Repete a iteração atual
            }
        }
    }

    public void avancarTurno() {
        turnoAtual++;
    }


}
