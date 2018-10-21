package com.company.pokemons;

import com.company.moves.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Numel extends Pokemon {
    public Numel(String name, int level){
        super(name,level);
        setStats(60,60,40,65,45,35);
        setType(Type.FIRE, Type.GROUND);
        setMove(new Flamethrower(), new Rest(), new WillOWisp());
    }
}
