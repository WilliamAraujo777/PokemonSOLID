package com.pokemon.domain.model;

import com.pokemon.domain.model.enums.PokemonENUM;

public class Pokemon {

    private int hp, ataque, defesa, ataqueEspecial, contadorAtaques;
    private String nome;
    private PokemonENUM pokemonAtivo;

    public Pokemon(PokemonENUM pkm){
        this.pokemonAtivo = pkm;
        atualizaAtributos();
        contadorAtaques = 0;
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

    public void ataqueBasico(Pokemon adversario){
        adversario.receberDano(this.getAtaque() - adversario.getDefesa());
        System.out.println(this.getNome() + " atacou com ataque básico. Dano: " + this.getAtaque());
        contadorAtaques++;
    }

    public void ataqueEspecial(Pokemon adversario){
        if(contadorAtaques < 4){
            System.out.println("Tentou usar especial, mas falhou!" + getNome());
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
        System.out.println(this.getNome() + " recebeu " + dano + " de dano. HP restante: " + this.hp);
    }

    public boolean evoluir() {
        if (pokemonAtivo.evolucao() != null) {
            this.pokemonAtivo = pokemonAtivo.evolucao();
            atualizaAtributos();
            return true;
        }
        return false;
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
        return String.format("Pokémon: %s\nHP: %d\nAtaque: %d\nDefesa: %d\nAtaque Especial: %d\nHabilidade Especial: %s",
                nome, hp, ataque, defesa, ataqueEspecial, pokemonAtivo.getNomeEspecial());
    }



}
