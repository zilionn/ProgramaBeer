package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerBeer {

	public ControllerBeer() {
		super();
	}
	
	public void lerArquivo(String arquivo) {
        try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                exibe(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibe(String linha) {
        String[] elementos = linha.split("\"id\":");

        for (int i = 1; i < elementos.length; i++) {
            String[] campos = elementos[i].split("\",");

            String nameBeer = "";
            String tagline = "";
            String firstBrewed = "";
            String description = "";
            

            
            for (String campo : campos) {
                if (campo.contains("\"name\":")) {
                    nameBeer = extrairValor(campo); 
                } else if (campo.contains("\"tagline\":")) {
                    tagline = extrairValor(campo);
                } else if (campo.contains("\"first_brewed\":")) {
                    firstBrewed = extrairValor(campo);
                } else if (campo.contains("\"description\":")) {
                    description = extrairValor(campo);
                    break;
                }
            }
            
            System.out.println("Name: " + nameBeer);
            System.out.println("Tagline: " + tagline);
            System.out.println("First Brewed: " + firstBrewed);
            System.out.println("Description: " + description);
            System.out.println("-----------------------------------------");
            }
        }

    private String extrairValor(String campo) {
    	String[] vet = campo.split("\":");
    	String name = vet[1];
        return name.replace("\"", "").trim();
    }
}