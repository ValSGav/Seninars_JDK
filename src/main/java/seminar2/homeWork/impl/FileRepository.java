package seminar2.homeWork.impl;

import seminar2.homeWork.ChatException;
import seminar2.homeWork.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRepository implements Repository {

    String fileName;

    public FileRepository(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()) {
            try (FileWriter fv = new FileWriter(fileName);){
                 fv.write("");
            } catch (IOException e) {
                throw new ChatException(e.getMessage());
            }
        }
    }

    @Override
    public void saveMessageHistory(String messages) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(messages);
        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    @Override
    public String getMessageHistory() {
        String messageHistory = "";
        try (FileReader fr = new FileReader(fileName)) {
            int i;
            do {
                i = fr.read();
                messageHistory = messageHistory.concat(Character.toString((char) i));
            } while (i != -1);

            return messageHistory;

        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }
}
