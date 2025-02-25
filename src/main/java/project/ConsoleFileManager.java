package project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ConsoleFileManager implements Operations {
    private static File currentDirectory = new File(System.getProperty("user.dir"));
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ConsoleFileManager consoleFileManager = new ConsoleFileManager();
        while (true) {
            System.out.println("Введите команду:");
            System.out.print(consoleFileManager.currentDirectory.getAbsolutePath() + "\\");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ");
            String commands = parts[0];
            String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

            try {
                switch (commands) {
                    case "help":
                        System.out.println(consoleFileManager.help());
                        continue;
                    case "ls":
                        consoleFileManager.listFilesInDirectory(arguments);
                        continue;
                    case "cd":
                        consoleFileManager.changeDirectory(arguments);
                        continue;
                    case "mkdir":
                        consoleFileManager.createDirectory(arguments);
                        continue;
                    case "rmdir":
                        consoleFileManager.deleteFileOrDirectory(arguments);
                        continue;
                    case "mv":
                        consoleFileManager.renameFileOrDirectory(arguments);
                        continue;
                    case "cp":
                        consoleFileManager.copyFile(arguments);
                        continue;
                    case "finfo":
                        consoleFileManager.fileInfo(arguments);
                        continue;
                    case "find":
                        consoleFileManager.findFile(arguments);
                        continue;
                    case "exit":
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неизвестная команда " + commands + "\nДля справки нажмите /help");

                }
            } catch (
                    IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }
        }
    }


    @Override
    public void listFilesInDirectory(String[] args) {
        File[] files = currentDirectory.listFiles();

        boolean argument = Arrays.asList(args).contains("-i");
        if (argument) {
            System.out.printf("%-40s %10s %10s%n", "Имя", "Размер", "Дата последнего изменения");
        }
        if (files.length == 0) {
            System.out.println("Директория пуста");
        }
        for (File file : files) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                fileName += "[DIR]";
            }
            if (argument) {
                System.out.printf("%-40s %10s %10s%n", fileName, file.length(), DATE_FORMAT.format(new Date(file.lastModified())));
            } else {
                System.out.println(fileName);
            }
        }
    }

    @Override
    public void changeDirectory(String[] args) {
        if (args.length == 0) {
            System.out.println("Некорректный аргумент для команды 'cd'");
            return;
        }
        String newDirectoryPath = args[0];
        File newDirectoryName;
        if ("..".equals(newDirectoryPath)) {
            newDirectoryName = currentDirectory.getParentFile();
            if (newDirectoryName == null) {
                System.out.println("Вы уже находитесь в корневом каталоге");
                return;
            } }else {
                newDirectoryName = new File(currentDirectory,newDirectoryPath);
                if (!newDirectoryName.exists()) {
                    System.out.println("Путь к директории некорректен. Пожалуйста, проверьте вводные данные");
                    return;
                }
            }
        if (newDirectoryName.isDirectory()) {
            currentDirectory = newDirectoryName;
        } else {
            System.out.println("Указанный путь не является директорией");
        }

    }


    @Override
    public void createDirectory(String[] args) {
        if (args.length == 0) {
            System.out.println("введите имя директории для ее создания");
            return;
        }
        String newDirectoryName = args[0];
        File newDirectory = new File(currentDirectory, newDirectoryName);


        if (newDirectory.exists()) {
            System.out.println("Директория " + newDirectoryName + " уже существует");
        } else if (newDirectory.mkdirs()) {
            System.out.println("Директория " + newDirectoryName + " успешно создана");
        } else {
            System.out.println("Не удалось создать директорию");
        }

    }

    @Override
    public void deleteFileOrDirectory(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите файл или папку для удаления в текущей директории");
            return;
        }
        File source = new File(currentDirectory, args[0]);
        if (!source.exists()) {
            System.out.println("Файл или директория не найдены");
            return;
        }

        deleteRecursive(source);
        System.out.println(source.getName() + " успешно удален(а)");
    }

    private boolean deleteRecursive(File object) {
        if (object.isDirectory()) {
            File[] files = object.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteRecursive(file);
                }
            }
        }

        return object.delete();
    }


    @Override
    public void renameFileOrDirectory(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите текущее имя и новое имя файла" + "\\" + "папки в текущей директории");
            return;
        }

        boolean force = Arrays.asList(args).contains("-f");
        String source = args[0];
        String destinationPath = args[1];


        File sourceFile = new File(currentDirectory, source);
        File destinationFile = new File(destinationPath);
        if (destinationFile.isDirectory()) {
            String fileName = sourceFile.getName();
            destinationFile = new File(destinationPath, fileName);
        } else {
            destinationFile = new File(destinationPath);
        }
        if (!sourceFile.exists()) {
            System.out.println("Источник не найден");
            return;
        }
        if (destinationFile.exists() && !force) {
            System.out.println("Файл или директория назначения уже существует.  Используйте -f для перезаписи");


        }
        try {
            Path sourcePath = sourceFile.toPath();
            Path destPath = destinationFile.toPath();

            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успешно перемещен в: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Не удалось переместить файл");
        }
    }

    @Override
    public void copyFile(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите текущее имя и новое имя файла в текущей директории");
            return;
        }
        String sourceName = args[0];
        String destName = args[1];
        boolean force = Arrays.asList(args).contains("-f");
        File source = new File(sourceName);
        File destination = new File(destName);

        if (destination.isDirectory()) {
            String fileName = source.getName();
            destination = new File(destName, fileName);
        } else {
            destination = new File(destName);
        }
        if (!source.exists()) {
            System.out.println("Файл с таким именем не найден");
        }
        if (destination.exists() && !force) {
            System.out.println("Файл назначения уже существует.  Используйте -f для перезаписи.");
            return;
        }
        try {
            Path sourcePath = source.toPath();
            Path destinyPath = destination.toPath();
            Files.copy(sourcePath, destinyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успешно скопирован в " + destinyPath);
        } catch (Exception e) {
            System.out.println("Упс.. Что-то пошло не так");
        }
    }

    @Override
    public void fileInfo(String[] fileName) {

        if (fileName.length ==0) {
            System.out.println("Укажите имя файла для получения информации");
            return;
        }
        File file = new File(currentDirectory, fileName[0]);
        if(!file.exists()) {
            System.out.println("Файл не найден" + fileName[0]);
            return;
        }
        try {
            Path path = file.toPath();
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("Имя: " + file.getName());
            System.out.println("Тип: " + (file.isDirectory() ? "Директория" : "Файл"));
            System.out.println("Размер: " + attributes.size() + " байт");
            System.out.println("Дата создания: " + DATE_FORMAT.format(new Date(attributes.creationTime().toMillis())));
            System.out.println("Дата последнего изменения: " + DATE_FORMAT.format(new Date(file.lastModified())));

        } catch (IOException e) {
            System.out.println("Не удалось получить информацию о файле: " + e.getMessage());
        }
        }





    @Override
    public void findFile(String[] fileName) {

        boolean found = searchFile(currentDirectory, fileName[0]);
        if (!found) {
            System.out.println("Файл не найден в дереве каталогов");
        }
    }

    private boolean searchFile(File directory, String targetName) {
        File[] files = directory.listFiles();
        if (files == null) return false;

        boolean found = false;
        for (File file : files) {
            if (file.isDirectory()) {
                found |= searchFile(file, targetName);
            } else if (file.getName().equalsIgnoreCase(targetName)) {
                System.out.println("Найден: " + file.getAbsolutePath());
                found = true;
            }
        }
        return found;
    }


    @Override
    public String help() {
        return
                """
                        ls - выводит список файлов и папок в текущей директории
                        Если добавлен ключ - i, выводится более подробная информация о файлах.
                        cd [path] – переход в указанную поддиректорию. 
                        cd .. – переход в родительский каталог.
                        mkdir [name] – создание новой директории с указанным именем
                        rm [filename] – удаление указанного файла или директории (* возможность удаления не пустого каталога)
                        mv [source] [destination] – переименовать/перенести файл или директорию
                        Ключ -f позволяет принудительно переписывать файл в точке назначения
                        cp [source] [destination] – скопировать файл
                        Ключ -f позволяет принудительно переписывать файл в точке назначения
                        finfo [filename] – получить подробную информацию о файле
                        find [filename] – найти файл с указанным именем в текущем каталоге или любом его подкаталоге
                        """;

    }
}
