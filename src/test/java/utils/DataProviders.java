package utils;

import dto.UserDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Julia", "Smith", "some@mail.com", "password123"});
        list.add(new Object[]{"Julia1", "Smith", "some@mail.com", "password456"});
        list.add(new Object[]{"Julia2", "Smith", "some@mail.com", "password789"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDataCSVFile() {
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/userData.csv")));
            line = reader.readLine();

            while(line != null) {
                String [] split = line.split(",");
                list.add(new Object[]{new UserDTO().setFirstName(split[0]).setLastName(split[1])
                        .setEmail(split[3]).setPassword(split[4]) });
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
