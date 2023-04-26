package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	
	@Test
	public void testCreatePokedexWithNullMetadataProvider() {
	  IPokemonFactory pokemonFactoryMock = Mockito.mock(IPokemonFactory.class);
	  IPokedexFactory pokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
	  
	  // configure the mock to throw IllegalArgumentException
	  Mockito.when(pokedexFactoryMock.createPokedex(null, pokemonFactoryMock)).thenThrow(IllegalArgumentException.class);
	  
	  // verify that the expected exception is thrown
	  assertThrows(IllegalArgumentException.class, () -> {
	    pokedexFactoryMock.createPokedex(null, pokemonFactoryMock);
	  });
	}



	    // Vérifier que la fonction createPokedex() retourne bien une instance de type IPokedex
	@Test
	public void testCreatePokedex() {
	  IPokemonMetadataProvider metadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
	  IPokemonFactory pokemonFactoryMock = Mockito.mock(IPokemonFactory.class);
	  IPokedexFactory pokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
	  IPokedex pokedexMock = Mockito.mock(IPokedex.class);

	  Mockito.when(pokedexFactoryMock.createPokedex(metadataProviderMock, pokemonFactoryMock)).thenReturn(pokedexMock);

	  IPokedex pokedex = pokedexFactoryMock.createPokedex(metadataProviderMock, pokemonFactoryMock);

	  assertNotNull(pokedex);
	  assertTrue(pokedex instanceof IPokedex);
	}


}
