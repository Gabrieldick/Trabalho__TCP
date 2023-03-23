package Func_musica;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControlaSomTest {
	private ControlaSom objeto = new ControlaSom();
	
	@Test
	public void test_DobraVolume() {
		//Seta volume em 60, dobra e testa, depois excede o máximo e testa caso limite
		objeto.setVolume(60);
		objeto.DobraVolume();
		assertEquals(120, objeto.getVolume());
		objeto.DobraVolume();
		assertNotEquals(240,objeto.getVolume());
	}
	@Test
	public void test_VolumeToString() {
		//Testa se o programa passa a string de forma adequada à JFugue
		objeto.setVolume(60);
		assertEquals(":CON(7, 60) ", objeto.VolumeToString());
	}
	@Test
	public void test_VerificaInstrumento(){
		//Testa exceder o limite dos instrumentos
        objeto.AlteraInstrumento(590);
        objeto.VerificaInstrumento();
        assertEquals(0,objeto.getID_Instrumento());
    }
	
	@Test
	public void test_InstrumentoToString(){
		//Testa se o programa passa a string de forma adequada à JFugue
        objeto.AlteraInstrumento(8);
        objeto.VerificaInstrumento();
        assertEquals("I8 ", objeto.InstrumentoToString());
    }
	
	@Test
	public void test_IncrementaOitava(){
		//Testa o set de oitava padrão, e incrementa até exceder o caso limite
        objeto.OitavaToPadrao();
        assertEquals(5, objeto.getOitavaAtual());
        objeto.IncrementaOitava();
        objeto.IncrementaOitava();
        objeto.IncrementaOitava();
        objeto.IncrementaOitava();
        objeto.IncrementaOitava();
        assertEquals(5, objeto.getOitavaAtual());
    }
	
	
}
