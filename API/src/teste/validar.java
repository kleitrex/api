package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class validar {

    public static void main(String[] args) {
        // Exemplo de data de vencimento do cartão no formato "MM/yyyy"
        String dataVencimentoStr = "09/2024";

        if (isDataVencimentoValida(dataVencimentoStr)) {
            System.out.println("Data de vencimento é válida.");
        } else {
            System.out.println("Data de vencimento está vencida.");
        }
    }

    
}