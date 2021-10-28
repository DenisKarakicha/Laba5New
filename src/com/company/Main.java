package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Countries countries = new Countries();

    //
    public static void main(String[] args) throws IOException {

        countries.add(new Country("Ukraine", "Kiev", "Eurasia", 41723998, 603549));
        countries.add(new Country("Russia", "Moscow", "Eurasia", 146171015, 17125191));
        countries.add(new Country("Egypt", " Cairo", "Africa", 210000000, 923768));
        countries.add(new Country("Nigeria", "Abuja", "Africa", 102333440, 1001450));
        countries.add(new Country("Fiji", "Dry", "Australia", 935974, 18274));

        menu();
    }

    public static void menu() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("1)Вывод информации о странах" +
                "\n2)Поиск по названию столицы" +
                "\n3)Поиск по занимаемой площади" +
                "\n4)Удаление записи у которой численисть меньше заданой" +
                "\n5)Сортировка по названию страны" +
                "\n6)Загрузить данные в файл" +
                "\n7)Загрузить данные из файла" +
                "\n8)Загрузить данные (сериализация)" +
                "\n9)Выгрузить данные (дериализация)" +
                "\n10)Загрузка резервной копии" +
                "\n11)Выход");
        System.out.print("Выберете пункт меню:");
        int menuNumber = scan.nextInt();
        scan.nextLine();
        while (true) {
            if (menuNumber < 0 || menuNumber > 11) {
                System.out.print("Выберете СУЩЕСТВУЮЩИЙ пункт меню: ");
                menuNumber = scan.nextInt();
            } else {
                break;
            }
        }
        switch (menuNumber) {
            case 1:
                System.out.println(countries);
                menu();
                break;
            case 2:
                System.out.println("Введите название столицы:");
                String capital = scan.nextLine();
                countries.searchCapital(capital);
                break;
            case 3:
                System.out.println("Введите значение площади которое хотите найти:");
                int area = scan.nextInt();
                countries.searchArea(area);
                break;
            case 4:
                System.out.println("Введите численость которую хотите удалить:");
                int countPopulation = scan.nextInt();
                countries.removePopulation(countPopulation);
            case 5:
                countries.sorting();
                System.out.println(countries);
                break;
            case 6:
                System.out.println("Введите путь к файлу:");
                String inFileName = scan.nextLine();
                countries.saveFile(inFileName);
                System.out.println("Файл успешно сохранён!");
                menu();
                break;
            case 7:
                System.out.println("Введите путь к файлу:");
                String outFileName = scan.nextLine();
                countries.loadFile(outFileName);
                System.out.println("Файл успешно загружен!");
                menu();
                break;
            case 8:
                System.out.println("Введите путь к файлу:");
                String serializeOutFileName = scan.nextLine();
                //countries.serializeSaveFile(serializeOutFileName);
                countries.saveJacksonSerializeSaveFile(serializeOutFileName);
                menu();
                break;
            case 9:
                System.out.println("Введите путь к файлу:");
                String deSerializeOutFileName = scan.nextLine();
                //countries.deSerializeLoadFile(deSerializeOutFileName);
                countries.loadJacksonDeSerialize(deSerializeOutFileName);
                menu();
                break;
            case 10:
                String outSecretNameFile = "reserve.txt";
                countries.loadFile(outSecretNameFile);
                menu();
                break;
            case 11:
                String inSecretNameFile = "reserve.txt";
                countries.saveFile(inSecretNameFile);
                break;
        }


    }


}





















