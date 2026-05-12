package org.example;

import java.util.Scanner;

public class Calculadora {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Escolha entre 'basicas' ou 'sair': ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
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
                    System.out.println("Digite apenas numeros validos");
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
