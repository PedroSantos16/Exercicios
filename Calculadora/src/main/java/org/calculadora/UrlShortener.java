package org.calculadora;

import java.util.Random;

public class UrlShortener {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TAMANHO_CODIGO = 6;
    private static final String DOMINIO = "https://short.ly/";

    public static String encurtar(String urlOriginal) {
        if (urlOriginal == null || urlOriginal.isBlank()) {
            throw new IllegalArgumentException("A URL não pode estar vazia.");
        }

        if (!urlOriginal.startsWith("http://") && !urlOriginal.startsWith("https://")) {
            throw new IllegalArgumentException("URL inválida. Use http:// ou https://");
        }

        StringBuilder codigo = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < TAMANHO_CODIGO; i++) {
            int indice = random.nextInt(CARACTERES.length());
            codigo.append(CARACTERES.charAt(indice));
        }
        return DOMINIO + codigo;
    }
}
