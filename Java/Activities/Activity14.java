package Activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14{
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\IpsitaBose\\Desktop\\Java Activities\\fst-m1-java\\src\\Sample\\newFile.txt");
        boolean fStatus = file.createNewFile();
        if(fStatus) {
            System.out.println("File created successfully!");
        } else {
            System.out.println("File already exists at this path.");
        }

        File fileutil = FileUtils.getFile("C:\\Users\\IpsitaBose\\Desktop\\Java Activities\\fst-m1-java\\src\\Sample\\newFile.txt");
        System.out.println("Content of file: \n"+ FileUtils.readFileToString(fileutil, "UTF8"));

        File newDir = new File("resources");
        FileUtils.copyFileToDirectory(file, newDir);

        File newFile = FileUtils.getFile(newDir, "newFile.txt");
        String fileContent = FileUtils.readFileToString(newFile, "UTF-8");
        System.out.println("File content is: \n" + fileContent);
    }
    
}