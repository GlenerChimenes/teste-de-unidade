package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

	@Test
	public  void deveEntederLancesEmOrdemCrescente() {
		// parte 1: cenário
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		
		// parte 2: Ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// parte 3: Validação
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
}
