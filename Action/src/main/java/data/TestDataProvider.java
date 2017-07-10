package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;


public class TestDataProvider {
	
	private static final String PATH_TO_DATA_FILES = "src/test/resources/";
	
	@DataProvider
    public static Iterator<String[]> loadUserDataFromFile() {
		List<String[]> userData = new ArrayList<>();
		try (FileReader reader = new FileReader(PATH_TO_DATA_FILES + "message.txt")) {
			int i;
			String print = "";
			while ((i = reader.read()) != -1) {					
				print = print + (char)i;										
			}
			String[] printArray = print.split("\n");
			for(String str: printArray) {
				userData.add(str.split(";"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userData.iterator();
	}
}
