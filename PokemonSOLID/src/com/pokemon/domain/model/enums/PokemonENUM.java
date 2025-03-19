package com.pokemon.domain.model.enums;

public enum PokemonENUM {

    BULBASAUR("BULBASAUR", 45, 49, 49, 65, "Folha navalha") {
        @Override
        public PokemonENUM evolucao() {
            return IVYSAUR;
        }
    },
    IVYSAUR("IVYSAUR", 60, 62, 63, 80, "Vine Whip") {
        @Override
        public PokemonENUM evolucao() {
            return VENUSAUR;
        }
    },
    VENUSAUR("VENUSAUR", 80, 82, 83, 100, "Solarbeam") {
        @Override
        public PokemonENUM evolucao() {
            return null;
        }
    },

    CHARMANDER("CHARMANDER", 39, 52, 43, 60, "Ember") {
        @Override
        public PokemonENUM evolucao() {
            return CHARMELEON;
        }
    },
    CHARMELEON("CHARMELEON", 58, 64, 58, 80, "Flamethrower") {
        @Override
        public PokemonENUM evolucao() {
            return CHARIZARD;
        }
    },
    CHARIZARD("CHARIZARD", 78, 84, 78, 120, "Fire Blast") {
        @Override
        public PokemonENUM evolucao() {
            return null;
        }
    },

    SQUIRTLE("SQUIRTLE", 44, 48, 65, 50, "Water Gun") {
        @Override
        public PokemonENUM evolucao() {
            return WARTORTLE;
        }
    },
    WARTORTLE("WARTORTLE", 59, 63, 80, 65, "Bite") {
        @Override
        public PokemonENUM evolucao() {
            return BLASTOISE;
        }
    },
    BLASTOISE("BLASTOISE", 79, 83, 100, 85, "Hydro Pump") {
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