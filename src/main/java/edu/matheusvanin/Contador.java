package edu.matheusvanin;

import java.util.Scanner;

public class Contador {

    private static final String MENSAGEM_PRIMEIRO_NUMERO = "Digite o primeiro número inteiro";
    private static final String MENSAGEM_SEGUNDO_NUMERO = "Digite o segundo número inteiro";
    private static final String MENSAGEM_ERRO_NUMERO = "O valor fornecido não é um número inteiro, tente novamente";

    /**
     * Método principal, solicita dois números inteiros ao usuário e exibe uma contagem para a diferença entre eles
     *
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int parametroUm = solicitarInteiro(scanner, MENSAGEM_PRIMEIRO_NUMERO);
            int parametroDois = solicitarInteiro(scanner, MENSAGEM_SEGUNDO_NUMERO);

            try {
                contar(parametroUm, parametroDois);
            } catch (ParametrosInvalidosException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * Solicitar um número inteiro ao usuário
     *
     * @param scanner  Scanner para leitura da entrada do usuário
     * @param mensagem Mensagem a ser exibida ao usuário
     * @return Número inteiro fornecido pelo usuário
     */
    private static int solicitarInteiro(Scanner scanner, String mensagem) {
        String entradaUsuario = "";
        do {
            System.out.println(mensagem);
            entradaUsuario = scanner.nextLine();
            try {
                return Integer.parseInt(entradaUsuario);
            } catch (NumberFormatException e) {
                System.out.println(MENSAGEM_ERRO_NUMERO);
            }
        } while (true);
    }

    /**
     * Contar a diferença entre dois números inteiros
     *
     * @param parametroUm   Primeiro número inteiro
     * @param parametroDois Segundo número inteiro
     * @throws ParametrosInvalidosException Se o segundo número for menor que o primeiro
     */
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}