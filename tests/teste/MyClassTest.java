package teste;

import model.Pacote;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {
    @Test
    //Teste positivo
    public void testePositivo() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'N',2.0);
        assertEquals(4.0,  pct.calcularFrete(), 0);
    }
    @Test
    //Teste negativo
    public void testeNegativo() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'N',-2.0);
        assertEquals(4.0,  pct.calcularFrete(), 0);
    }
    @Test
    //Teste valores limites
    public void testeValoresLimites() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'N',-2.0);
        assertEquals(4.0,  pct.calcularFrete(), 0);
    }
}