package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class IPokemonFactoryTest {
	  
	 @Test
	    void testCreatePokemon() {
	        IPokemonFactory factory =  Mockito.mock(IPokemonFactory.class);
	        Pokemon pokemon = factory.createPokemon(25, 1500, 100, 2000, 5);
	        Assertions.assertEquals(25, pokemon.getIndex());
	        Assertions.assertEquals(1500, pokemon.getCp());
	        Assertions.assertEquals(100, pokemon.getHp());
	        Assertions.assertEquals(2000, pokemon.getDust());
	        Assertions.assertEquals(5, pokemon.getCandy());
	    }
	    
	    @Test
	    void testCreatePokemonWithNegativeValues() {
	        IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            factory.createPokemon(-1, -500, -50, -100, -2);
	        });
	    }
	    
	    @Test
	    void testCreatePokemonWithZeroValues() {
	        IPokemonFactory factory =Mockito.mock(IPokemonFactory.class);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            factory.createPokemon(0, 0, 0, 0, 0);
	        });
	    }
	    
	}



