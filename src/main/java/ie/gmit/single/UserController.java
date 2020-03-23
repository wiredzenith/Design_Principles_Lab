package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity

        //Store used by controller
        private Store store = new Store();

        //Create a new user
        public String createUser(String userJson) throws IOException {
                ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);
            ValidateUser vUser = new ValidateUser();

            if(!vUser.isValidUser(user)) {
                return "ERROR";
            }

            store.store(user);

            return "SUCCESS";
        }

        //Validates the user object



 }

