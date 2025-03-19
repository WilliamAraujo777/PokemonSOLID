package com.pokemon.domain.model.enums;

public enum PokemonENUM {

    BULBASAUR("BULBASAUR", 150, 49, 9, 65, "Folha navalha") {
        @Override
        public PokemonENUM evolucao() {
            return IVYSAUR;
        }
    },
    IVYSAUR("IVYSAUR", 200, 62, 12, 80, "Vine Whip") {
        @Override
        public PokemonENUM evolucao() {
            return VENUSAUR;
        }
    },
    VENUSAUR("VENUSAUR", 300, 82, 16, 100, "Solarbeam") {
        @Override
        public PokemonENUM evolucao() {
            return null;
        }
    },

    CHARMANDER("CHARMANDER", 150, 52, 9, 60, "Ember") {
        @Override
        public PokemonENUM evolucao() {
            return CHARMELEON;
        }
    },
    CHARMELEON("CHARMELEON", 200, 64, 12, 80, "Flamethrower") {
        @Override
        public PokemonENUM evolucao() {
            return CHARIZARD;
        }
    },
    CHARIZARD("CHARIZARD", 300, 84, 16, 120, "Fire Blast") {
        @Override
        public PokemonENUM evolucao() {
            return null;
        }
    },

    SQUIRTLE("SQUIRTLE", 150, 48, 9, 50, "Water Gun") {
        @Override
        public PokemonENUM evolucao() {
            return WARTORTLE;
        }
    },
    WARTORTLE("WARTORTLE", 200, 63, 12, 65, "Bite") {
        @Override
        public PokemonENUM evolucao() {
            return BLASTOISE;
        }
    },
    BLASTOISE("BLASTOISE", 300, 83, 16, 85, "Hydro Pump") {
        @Override
        public PokemonENUM evolucao() {
            return null;
        }
    };

    private final String nome;
    private final int hp;
    private final int ataque;
    private final int defesa;
    private final int ataqueEspecial;
    private final String nomeEspecial;

    PokemonENUM(String nome, int hp, int ataque, int defesa, int ataqueEspecial, String nomeEspecial) {
        this.nome = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.ataqueEspecial = ataqueEspecial;
        this.nomeEspecial = nomeEspecial;
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
    public int getAtaqueEspecial() {return ataqueEspecial;}
    public String getNome(){ return nome; }
    public String getNomeEspecial() {return nomeEspecial;}

    public abstract PokemonENUM evolucao();
}