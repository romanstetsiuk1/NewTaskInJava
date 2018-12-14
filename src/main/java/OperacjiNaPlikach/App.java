package OperacjiNaPlikach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {

//        ListByFiles();
//
//        informationAboutFiles();
//
//        readFromFile();
//
//        addContentToFile();
//
//        searchAmidFiles();

        String startSearch = "D:\\My_program\\JAVA";        //Where I want make my search
        Path searchPath = Paths.get(startSearch);

        int maxDeep = 20;                          //how many deep I want search

        String resultFileName = "D:\\My_program\\JAVA\\Programowanie_II\\result.txt";
        Path resultFilePath = Paths.get(resultFileName);

//        create map where key-its name of file with path, value-its first file line
        Map<String, String> lines = new HashMap<>();
        List<String> linesToWrite = new ArrayList<>();

        Files.walk(searchPath, maxDeep)
                .filter(Files::isRegularFile)       //filter by just files,no for folders
                .filter(f -> f.toString().endsWith(".txt"))       //filter by files with end ".txt"
                .forEach(f -> {
                    try {
                        String fileName = f.toString();         //get name of file
                        String firstLine = Files.lines(f).findFirst().orElse("");   //get first line in file
                        lines.put(fileName, firstLine);     //add file name and first line to map
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        lines.forEach((fileName, firsLine) -> linesToWrite.add(String.format("%s - %s", fileName, firsLine)));

        //add result to new file
        Files.write(resultFilePath, linesToWrite);

    }

    private static void searchAmidFiles() throws IOException {
        Path path = Paths.get("D:\\My_program\\JAVA");
        Files.walk(path, 2)
                .filter(p -> p.toString().endsWith(".iml"))
                .forEach(System.out::println);
    }

    private static void addContentToFile() throws IOException {
        List<String> content = Arrays.asList("Line 1", "Line 2", "Boom-boom");
        Path path = Paths.get("D:\\My_program\\JAVA\\Programowanie_II\\test2.txt");
        Files.write(path, content);
        Files.write(path, content, StandardOpenOption.APPEND);
    }

    private static void readFromFile() throws IOException {
        Path path = Paths.get("D:\\My_program\\JAVA\\Programowanie_II\\test.txt");
        Files.lines(path).forEach(System.out::println);
    }

    private static void informationAboutFiles() throws IOException {
        Path path = Paths.get("D:\\SDA\\DONE---Zadanie 1.pdf");
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("creation time: " + attributes.creationTime());
        System.out.println("last access time: " + attributes.lastAccessTime());
        System.out.println("last modified time: " + attributes.lastModifiedTime());
        System.out.println("size: " + attributes.size());
    }

    private static void ListByFiles() throws IOException {
        Path path = Paths.get("D:\\Books");
        Files.list(path).forEach(System.out::println);
    }

}
