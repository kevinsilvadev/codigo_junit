package teste;

import model.Pacote;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {

    @Test
    //Teste positivo A
    public void testePositivoA() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'N',2.0);
        assertEquals(4.0,  pct.calcularFrete(), 0);
    }

    @Test
    //Teste positivo B
    public void testePositivoB() throws IllegalAccessException {
        Pacote pct =  new Pacote(' ', 'A', ' ',5.0);
        assertEquals(15.0,  pct.calcularFrete(), 0);
    }

    @Test
    //Teste positivo C
    public void testePositivoC() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', 'E',21.0);
        assertEquals(42.0,  pct.calcularFrete(), 0);
    }
    @Test
    //Teste negativo - Peso
    public void testeNegativoA() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'A', 'N',-1);
        assertEquals(-1,  pct.calcularFrete(),0);
    }

    @Test
    //Teste negativo - Destino
    public void testeNegativoB() throws IllegalAccessException {
        Pacote pct =  new Pacote('A', 'A', 'N',18.0);
        assertEquals(-2,  pct.calcularFrete(),0);
    }

    @Test
    //Teste negativo - Tipo do Transporte
    public void testeNegativoC() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'G', 'E',15.0);
        assertEquals(-3,  pct.calcularFrete(),0);
    }

    @Test
    //Teste negativo - Tipo da Entrega
    public void testeNegativoD() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', '0',10.0);
        assertEquals(-4,  pct.calcularFrete(),0);
    }

    @Test
    //Teste Limite - Transporte Aereo com pacote ate 2Kg
    public void testeLimiteA() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'A', 'N',2.0);
        assertEquals(6,  pct.calcularFrete(),0);
    }

    @Test
    //Teste Limite - Transporte Aereo com pacote entre 2Kg e 20Kg - Peso 2.1
    public void testeLimiteB() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'A', 'E',2.1);
        assertEquals(6.3,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Aereo com pacote maior que 2Kg e menor que 20Kg - Peso 19.9
    public void testeLimiteC() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'A', 'E',19.9);
        assertEquals(59.7,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Aereo com pacote maior que 20Kg - Peso 20
    public void testeLimiteD() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'A', 'E',20);
        assertEquals(60,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terreste, Entrega Normal
    public void testeLimiteE() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'N',1);
        assertEquals(2,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terrestre, Entrega Expressa, Destino Local
    public void testeLimiteF() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'E',20);
        assertEquals(40,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terrestre, Entrega Expressa, Destino Fora, Peso maior que 20
    public void testeLimiteG() throws IllegalAccessException {
        Pacote pct =  new Pacote('L', 'S', 'E',25);
        assertEquals(50,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terrestre, Entrega Expressa, Destino Fora, Peso menor que 20 e maior que 2 - Peso 19.9
    public void testeLimiteH() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', 'E',19.9);
        assertEquals(59.7,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terrestre, Entrega Expressa, Destino Fora, Peso menor que 20 e maior que 2 - Peso 2.1
    public void testeLimiteI() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', 'E',2.1);
        assertEquals(6.3,  pct.calcularFrete(),0.1);
    }

    @Test
    //Teste Limite - Transporte Terrestre, Entrega Expressa, Destino Fora, Peso menor que 2
    public void testeLimiteJ() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', 'E',1.9);
        assertEquals(5.7,  pct.calcularFrete(),0.1);
    }

    @Test
    //Erro - Ao colocar peso 0, o frete é calculado normalmente
    public void erroA() throws IllegalAccessException {
        Pacote pct =  new Pacote('F', 'S', 'E',0);
        assertEquals(-1,  pct.calcularFrete(),0.1);
    }

    @Test
    //Erro - Ao colocar caracter em branco na entrega e no destino,
    // caso a entrega seja pela superfície, o frete é calculado normalmente.
    public void erroB() throws IllegalAccessException {
        Pacote pct =  new Pacote(' ', 'S', ' ',1.9);
        assertEquals(-3,  pct.calcularFrete(),0.1);
    }
}