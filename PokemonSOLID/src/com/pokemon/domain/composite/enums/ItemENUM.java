package com.pokemon.domain.composite.enums;

public enum ItemENUM {
    HP_POTION("Poção de Vida", "hp", 20),
    ATTACK_POTION("Poção de Ataque", "ataque", 10),
    DEFENSE_POTION("Poção de Defesa", "defesa", 10),
    RARE_CANDY("Rare Candy", "evoluir", 0); // Novo item para evolução

    private final String nome;
    private final String tipo;
    private final int valor;

    ItemENUM(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
}

