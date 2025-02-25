package project;

public interface Operations {
    void listFilesInDirectory(String[] args); //ls - распечатать список файлов текущего каталога. Если добавлен ключ -i,
    // то должна быть более подробная информация о файлах: имя – размер – дата последнего изменения

    void changeDirectory (String[] path);//cd [path] – переход в указанную поддиректорию. cd .. – переход в родительский каталог.
    void createDirectory(String[] newDirectoryName); //mkdir [name] – создание новой директории с указанным именем
    void deleteFileOrDirectory(String[] filename); // rm [filename] – удаление указанного файла или директории (* возможность удаления не пустого каталога)
    void renameFileOrDirectory(String[] args);//mv [source] [destination] – переименовать/перенести файл или директорию
    void copyFile(String[] args); //cp [source] [destination] – скопировать файл
    //Для mv, cp выдавать предупреждение что указанный файл в точке назначения уже существует. Добавить ключ -f чтобы принудительно переписывать файл в точке назначения
    void fileInfo(String[] fileName); //finfo [filename] – получить подробную информацию о файле
    void findFile(String[] fileName); //find [filename] – найти файл с указанным именем в текущем каталоге или любом его подкаталоге
    String help();





}
