package com.pokemon.domain.model;

import com.pokemon.domain.model.enums.PokemonENUM;

public class Pokemon {

    private int hp, ataque, defesa, ataqueEspecial, contadorAtaques;
    private String nome;
    private PokemonENUM pokemonAtivo;
    private boolean buffAtivo;
    private int buffDefesa, buffAtaque;

    public Pokemon(PokemonENUM pkm){
        this.pokemonAtivo = pkm;
        atualizaAtributos();
        contadorAtaques = 0;
        buffAtivo = false;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaqueEspecial(){
        return ataqueEspecial;
    }

    public boolean ativarBuffAtaque(int buff) {
        if (!buffAtivo) {
            this.buffAtaque = buff;
            this.buffAtivo = true;
            System.out.println(nome + " usou Atack Potion! O Ataque aumentou em +" + buff + " até ele atacar.");
            return true;
        }
        return false;
    }

    public boolean ativarBuffDefesa(int buff) {
        if (!buffAtivo) {
            this.buffDefesa = buff;
            this.buffAtivo = true;
            System.out.println(nome + " usou Defense Potion! A defesa aumentou em +" + buff + " até ser atacado.");
            return true;
        }
        return false;
    }

    public void ataqueBasico(Pokemon adversario){
        int dano = getAtaqueComBuffs() - adversario.getDefesaComBuffs();
        if (dano > 0) {
            System.out.println(this.getNome() + " atacou com ataque básico. Dano: " + dano);
            adversario.receberDano(dano);
        }

        contadorAtaques++;

        if (buffAtivo) {
            buffAtivo = false;
            System.out.println(nome + " perdeu o bônus de ataque!");
        }
    }

    public int getAtaqueComBuffs() {
        return buffAtivo ? ataque + buffAtaque : ataque;
    }

    public int getDefesaComBuffs() {
        return buffAtivo ? defesa + buffDefesa : defesa;
    }

    public void ataqueEspecial(Pokemon adversario){
        if(contadorAtaques < 4){
            System.out.println(getNome() + " Tentou usar especial, mas falhou!" );
            return;
        }
        adversario.receberDano(this.getAtaqueEspecial() - adversario.getDefesa());
        System.out.println(this.getNome() + " atacou com " + this.pokemonAtivo.getNomeEspecial() + " Dano: " + this.getAtaqueEspecial());
        contadorAtaques -= 4;
    }

    public String contadorEspecial() {
        if (contadorAtaques >= 4) {
            return nome + ": Contador de ataques = " + contadorAtaques + ". Ataque especial disponível!";
        } else {
            return nome + ": Contador de ataques = " + contadorAtaques + ". " +
                    (4 - contadorAtaques) + " ataques restantes para liberar o ataque especial.";
        }
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) {
            this.hp = 0;
        }
        if (buffAtivo) {
            buffAtivo = false;
            System.out.println(nome + " perdeu o bônus de defesa!");
        }
        System.out.println(this.getNome() + " recebeu " + dano + " de dano. HP restante: " + this.hp);
    }

    public boolean evoluir() {
        if (pokemonAtivo.evolucao() != null) {
            this.pokemonAtivo = pokemonAtivo.evolucao();
            atualizaAtributos();
            System.out.println("O Pokémon evoluiu para " + getNome());
            return true;
        }
        System.out.println("O Pokémon " + getNome() + " não pode mais evoluir");
        return false;
    }

    public boolean curar(int cura){

        if(this.hp <= 0){
            System.out.println("Pokémon desmaiado");
            return false;
        }

        if(cura + getHp() > this.pokemonAtivo.getHp()){
            this.hp = pokemonAtivo.getHp();
        }else{
            this.hp += cura;
        }
        return true;


    }

    private void atualizaAtributos(){
        this.hp     = pokemonAtivo.getHp();
        this.ataque = pokemonAtivo.getAtaque();
        this.defesa = pokemonAtivo.getDefesa();
        this.nome   = pokemonAtivo.getNome();
        this.ataqueEspecial = pokemonAtivo.getAtaqueEspecial();
    }
    @Override
    public String toString() {
        return String.format("Pokémon: %s\nHP: %d\nAtaque: %d - Defesa: %d\nAtaque Especial: %d - Habilidade Especial: %s",
                nome, hp, ataque, defesa, ataqueEspecial, pokemonAtivo.getNomeEspecial());
    }



}
