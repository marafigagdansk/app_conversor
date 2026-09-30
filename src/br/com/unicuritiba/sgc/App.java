package br.com.unicuritiba.sgc;

import java.util.Locale;
import java.util.Scanner;
import br.com.unicuritiba.sgc.models.ConversorBitcoin;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ConversorBitcoin conversor = new ConversorBitcoin();

        System.out.println("=================================================");
        System.out.println("        CONVERSOR DE BITCOIN PARA REAIS (BRL)    ");
        System.out.println("=================================================");
        System.out.printf("Cotação Fixa do Bitcoin: %s%n", 
                ConversorBitcoin.formatarReais(conversor.getCotacaoBtcEmBrl()));
        System.out.println("-------------------------------------------------");
        
        System.out.print("Digite a quantidade de Bitcoin (BTC) para converter: ");
        double btc = scanner.nextDouble();

        double valorEmReais = conversor.converterBtcParaBrl(btc);

        System.out.println("=================================================");
        System.out.printf("Valor inserido : %.8f BTC%n", btc);
        System.out.printf("Cotação fixa   : %s%n", ConversorBitcoin.formatarReais(conversor.getCotacaoBtcEmBrl()));
        System.out.printf("Total em Reais : %s%n", ConversorBitcoin.formatarReais(valorEmReais));
        System.out.println("=================================================");

        scanner.close();
    }
}