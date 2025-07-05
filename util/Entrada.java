package util;

import java.util.Scanner;

public class Entrada {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Entrada() {
        // Construtor privado impede criação de instâncias externas
    }

    public static Scanner getScanner() {
        return SCANNER;
    }
}
