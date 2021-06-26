package demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUser {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		
		ObjectMapper mapper = new ObjectMapper();
		User u1 = new User("123","naveen");
		List<User> userList = new ArrayList<User>();
		userList.add(u1);		
		
		Data data = new Data();
		data.setAllUserData(userList);
		
		AllData allData = new AllData();
		allData.setData(data);
		
		mapper.writeValue(new File("./user.json"), allData);
		
		//Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(allData);
        System.out.println(jsonInString);
        
        //Convert object to JSON string and pretty print
        jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allData);
        System.out.println(jsonInString);
	}

}
