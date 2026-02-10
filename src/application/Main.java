package application;

import model.entities.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        try {
            //passando o caminho para fazer leitura dos itens do arquivo
            System.out.println("Enter file path: ");
            String inputFilePath = sc.nextLine();
            Path filePath = Paths.get(inputFilePath);

            List<String> itemsList = Files.readAllLines(filePath);

            //transformando cada linha do arquivo em um produto
            for(String line : itemsList) {
                String[] fields = line.split("\\s*,\\s*");

                if(fields.length != 3) {
                    System.out.println("invalid line: " + line);
                    continue;
                }

                String name = fields[0];
                try {
                    double price = Double.parseDouble(fields[1]);
                    int quantity = Integer.parseInt(fields[2]);

                    products.add(new Product(name, price, quantity));
                }

                catch (NumberFormatException e) {
                    System.out.println("unexpected format in line: " + line);
                }
            }

            System.out.println();
            System.out.println("Enter directories path: ");
            String inputDirectoriesPath = sc.nextLine();

            //criação e junção do caminhos
            Path directoriesPath = Paths.get(inputDirectoriesPath);
            Path complementPath = Paths.get("out/summary.csv");
            Path finalPath = directoriesPath.resolve(complementPath);

            //criação do diretório e arquivo
            Files.createDirectories(finalPath.getParent());
            System.out.println("Directories and csv file created");

            //transformando os produtos em String para o arquivo CSV
            List<String> summaryLines = new ArrayList<>();
            summaryLines.add("Name,Subtotal");

            for(Product product : products) {
                summaryLines.add(product.getName() + "," + String.format("%.2f", product.subtotal()));
            }

            //passando os produtos para o arquivo CSV
            Files.write(finalPath,
                    summaryLines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}