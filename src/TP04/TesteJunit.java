package TP04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteJunit {
   Despesa despesa=new Despesa();
   Abastecimento abastecimento=new Abastecimento();
   Manutencao manutencao=new Manutencao();

    @Test
    public void verificarAbastecimento(){
           assertEquals(true,abastecimento.ValidarAbastecimento("20032001", "500", "1000", "gasolina"));
    }
    @Test
    public void verificarDespesa(){
        assertEquals(true, despesa.ValidarDepesa("19031990", "600", "230", "seguro"));

    }
    @Test
    public void verificarManutencao(){
        assertEquals(true, manutencao.ValidarManutencao("12042017", "767", "567", "Motor"));

    }
}
