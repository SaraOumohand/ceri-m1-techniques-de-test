package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class IPokemonTrainerFactoryTest {

	 @Test
	  public void testCreateTrainer() {
	    IPokemonTrainerFactory pokemonTrainer = Mockito.mock(IPokemonTrainerFactory.class);
	    IPokedexFactory pokedex = Mockito.mock(IPokedexFactory.class);
	    // Test with valid parameters
	    PokemonTrainer trainer = pokemonTrainer.createTrainer("Ash Ketchum", Team.MYSTIC, pokedex);
	    Assertions.assertEquals("Ash Ketchum", trainer.getName());
	    Assertions.assertEquals(Team.MYSTIC, trainer.getTeam());
	    Assertions.assertNotNull(trainer.getPokedex());

	    // Test with null name
	    Assertions.assertThrows(IllegalArgumentException.class,
	        () -> pokemonTrainer.createTrainer(null, Team.VALOR, pokedex));

	    // Test with null team
	    Assertions.assertThrows(IllegalArgumentException.class,
	        () -> pokemonTrainer.createTrainer("Misty", null, pokedex));

	    // Test with null pokedexFactory
	    Assertions.assertThrows(IllegalArgumentException.class,
	        () -> pokemonTrainer.createTrainer("Brock", Team.INSTINCT, null));
	  }
	

	}
