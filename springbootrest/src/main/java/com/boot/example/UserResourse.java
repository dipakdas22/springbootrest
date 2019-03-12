package com.boot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.example.entity.User;
import com.boot.example.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//Run project with 'Spring Boot App'
//Test the api working :: try with http://localhost:8080/users/103 in post man
//In chrome run http://localhost:8080/swagger-ui.html -> Expand operations -> Try it out

@RestController
@Api(value = "/")
public class UserResourse {
	
	@Autowired
	private UsersService userService;
	
	 /*** Retrieve all Users ***/
	@GetMapping("users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	/*** Retrieve a single Users ***/
	@ApiOperation(value = "Get user by ID")
	@GetMapping("users/{id}") 
	//@RequestMapping(method=RequestMethod.GET, value="users/{id}")
	public User getSingleUser(@PathVariable String id){
		return userService.getUser(Integer.parseInt(id));
	}
	
	/*** Create a single User ***/
	@PostMapping("/users")
	//@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
	
	 /*** Update a User ***/
    @RequestMapping(value="/users", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateUser(@RequestBody User user)
    {
    		userService.updateUser(user);
    }
    
    /*** Delete a User ***/
    @ApiOperation(value = "Delete users by ID")
    @RequestMapping(value="/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id)
    {
    		 userService.deleteUser(id);
    		return "{status:deleted}";
    }
	
}
