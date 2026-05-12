package org.example;

import java.util.Scanner;

public class Calculadora {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Escolha entre 'basicas' 'media' 'area' 'temperatura' 'juros' ou 'sair': ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            if (entrada.toLowerCase().startsWith("juros")) {
                String[] parts = entrada.trim().split("\\s+");

                if (parts.length != 5) {
                    System.out.println("Uso correto: JSimples C i t");
                    System.out.println("Uso correto: JComposto C i t");
                    continue;
                }

                String tipo = parts[1].toLowerCase();
                double capital;
                double taxa;
                double tempo;

                try {
                    capital = Double.parseDouble(parts[2]);
                    taxa = Double.parseDouble(parts[3]);
                    tempo = Double.parseDouble(parts[4]);
                }catch (NumberFormatException e){
                    System.out.println("Digite apenas números validos");
                    continue;
                }

                double juros;
                double montante;

                switch (tipo) {
                    case "simples":
                        juros = capital * taxa * tempo;
                        montante = capital +juros;
                        System.out.printf("Juros Simples: %.2f%n",juros);
                        System.out.printf("Montante: %.2f%n", montante);
                        break;

                    case "composto":
                        montante = capital * Math.pow(1 + taxa, tempo);
                        juros = montante - capital;
                        System.out.printf("Juros Compostos: %.2f%n",juros);
                        System.out.printf("Montante: %.2f%n", montante);
                        break;

                    default:
                        System.out.println("Tipo invalido. \n Use 'simples' ou 'composto'.");
                        continue;
                }
                continue;
            }

            if (entrada.toLowerCase().startsWith("temperatura")) {
                String[] parts = entrada.trim().split("\\s+");

                if (parts.length != 4) {
                    System.out.println("Uso correto: converter em c 100");
                    System.out.println("Uso correto: converter em f 30");
                    continue;
                }

                String graus = parts[2].toLowerCase();
                double valor;
                double resultado;

                try {
                    valor = Double.parseDouble(parts[3]);
                }catch (NumberFormatException e){
                    System.out.println("Digite apenas números validos");
                    continue;
                }

                switch (graus) {
                    //Celsius para Fahrenheit
                    case "c":
                        resultado = (valor * 9 / 5) + 32;
                        System.out.printf("Fahrenheit: %.2f%n", resultado);
                        break;

                    //Fahrenheit para Celsius
                    case "f":
                        resultado = (valor - 32) * 5 / 9;
                        System.out.printf("Celsius: %.2f%n", resultado);
                        break;

                    default:
                    System.out.println("Use 'c' para Celsius ou 'f' Fahrenheit.");
                    continue;
                }
                continue;
            }

            if (entrada.toLowerCase().startsWith("area")) {
                String[] parts = entrada.trim().split("\\s+");

                if (parts.length < 3) {
                    System.out.println("Uso correto: ");
                    System.out.println("Area retângulo 1 2");
                    System.out.println("Area circulo 1");
                    System.out.println("Area triangulo 1 2");
                    continue;
                }

                String figuras = parts[1].toLowerCase();
                double resultado = 0;

                try {
                    switch (figuras) {
                        case "retangulo":
                            if (parts.length != 4) {
                                System.out.println("Uso correto: area retangulo base altura");
                                continue;
                            }
                            double baseRetangulo = Double.parseDouble(parts[2]);
                            double alturaRetangulo = Double.parseDouble(parts[3]);

                            resultado = baseRetangulo * alturaRetangulo;
                            break;

                        case "circulo":
                            if (parts.length != 3) {
                                System.out.println("Uso correto: area circulo raio");
                                continue;
                            }
                            double raio = Double.parseDouble(parts[2]);
                            resultado = Math.PI * raio * raio;
                            break;

                        case "triangulo":
                            if (parts.length != 4) {
                                System.out.println("Uso correto: area triangulo base altura");
                                continue;
                            }
                            double baseTriangulo = Double.parseDouble(parts[2]);
                            double alturatriangulo = Double.parseDouble(parts[3]);

                            resultado = (baseTriangulo * alturatriangulo) / 2.0;
                            break;

                        default:
                            System.out.println("Figura invalida");
                            System.out.println("Figuras disponíveis: retangulo, circulo, triangulo");
                            continue;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite apenas números validos");
                    continue;
                }
                System.out.printf("Area: %.3f%n", resultado);
                continue;
            }

            if (entrada.toLowerCase().startsWith("media")) {
                String[] parts = entrada.trim().split("\\s+");
                if (parts.length < 2) {
                    System.out.println("Uso Correto deve ser: media 1 2 3");
                    continue;
                }

                double soma = 0;
                boolean erro = false;

                for (int i = 1; i < parts.length; i++) {
                    try {
                        soma += Double.parseDouble(parts[i]);
                    }catch (NumberFormatException e) {
                        System.out.println("Valor invalido: " +parts[i]);
                        erro = true;
                        break;
                    }
                }
                 if (erro) {
                     continue;
                 }

                 double media = soma / (parts.length - 1);
                 System.out.println("Media aritimetica: " + media);
                 continue;
            }

            if (entrada.toLowerCase().startsWith("basicas")) {
                String[] parts = entrada.trim().split("\\s+");
                if (parts.length != 4) {
                    System.out.println("Uso correto deve ser: basicas 10 + 5");
                    continue;
                }

                double a;
                double b;

                try {
                    a = Double.parseDouble(parts[1]);
                    b = Double.parseDouble(parts[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números validos");
                    continue;
                }

                String operator = parts[2];
                double resultado = 0;

                switch (operator) {
                    case "+":
                        resultado = a + b;
                        break;
                    case "-":
                        resultado = a - b;
                        break;
                    case "*":
                        resultado = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            System.out.println("Erro: divisão por zero não pode ser realizada.");
                        }
                        resultado = a / b;
                        break;
                    default:
                        System.out.println("Operador invalido.");
                        continue;
                }
                System.out.println("Resultado: " + resultado);
                continue;
            }
            scanner.close();
        }
    }
}
