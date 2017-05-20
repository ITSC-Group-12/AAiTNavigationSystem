package Navi.controller;

import Navi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import Navi.repository.UserDao;

/**
 * Created by Blen on 5/6/2017.
 */
@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/registerUser")
    @ResponseBody
    public String registerUser(@RequestParam(value = "deviceId")String deviceId,
            @RequestParam(value = "firstName")String firstName,
                                          @RequestParam(value = "lastName")String lastName
    )
    {
        try{
            User user = new User(deviceId,firstName,lastName);
            userDao.save(user);
            return "Successfully Registered :)";
        }catch (Exception e){
            return new ResponseEntity<Object>("Internal Error " + e.getMessage(), HttpStatus.valueOf(500)).toString();
        }

    }
    @RequestMapping(value = "/checkPerson")
    public String login(@RequestParam(value = "firstName")String firstName,
                        @RequestParam(value = "lastName")String lastName){
        try{
            return userDao.findUserByFirstNameAndLastName(firstName,lastName).toString();

        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Object>("Internal Error", HttpStatus.valueOf(500)).toString();
        }

    }
    @RequestMapping(value = "/check")
    public String login(@RequestParam(value = "deviceId")String deviceId
                        ){
        try{
            return userDao.findByDeviceId(deviceId).toString();

        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Object>("Internal Error", HttpStatus.valueOf(500)).toString();
        }

    }

}
