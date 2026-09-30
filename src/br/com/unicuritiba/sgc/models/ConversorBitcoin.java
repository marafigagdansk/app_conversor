package br.com.unicuritiba.sgc.models;

import java.text.NumberFormat;
import java.util.Locale;

public class ConversorBitcoin {

    public static final double COTACAO_FIXA = 434702.00;

    private double cotacaoBtcEmBrl;

    // Construtor com cotação padrão fixa em R$ 434.702,00
    public ConversorBitcoin() {
        this.cotacaoBtcEmBrl = COTACAO_FIXA;
    }

    public ConversorBitcoin(double cotacaoBtcEmBrl) {
        if (cotacaoBtcEmBrl <= 0) {
            throw new IllegalArgumentException("A cotação do Bitcoin deve ser maior que zero.");
        }
        this.cotacaoBtcEmBrl = cotacaoBtcEmBrl;
    }

    public double getCotacaoBtcEmBrl() {
        return cotacaoBtcEmBrl;
    }

    public void setCotacaoBtcEmBrl(double cotacaoBtcEmBrl) {
        if (cotacaoBtcEmBrl <= 0) {
            throw new IllegalArgumentException("A cotação do Bitcoin deve ser maior que zero.");
        }
        this.cotacaoBtcEmBrl = cotacaoBtcEmBrl;
    }

    /**
     * Converte uma quantidade de Bitcoin (BTC) para Reais (BRL)
     * @param bitcoin Quantidade de Bitcoin
     * @return Valor correspondente em Reais
     */
    public double converterBtcParaBrl(double bitcoin) {
        if (bitcoin < 0) {
            throw new IllegalArgumentException("O valor em Bitcoin não pode ser negativo.");
        }
        return bitcoin * this.cotacaoBtcEmBrl;
    }

    /**
     * Formata o valor numérico para a moeda brasileira (R$)
     * @param valor Valor em reais
     * @return String formatada (ex: R$ 434.702,00)
     */
    public static String formatarReais(double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
    }
}
