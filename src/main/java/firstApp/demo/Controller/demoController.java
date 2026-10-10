package firstApp.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import firstApp.demo.Service.Student;
import firstApp.demo.donner.districts;
import firstApp.demo.donner.districtsDto;
import firstApp.demo.donner.donner;
import firstApp.demo.donner.donnerDao;
import firstApp.demo.Service.*;


@RestController
public class demoController {
	@Autowired
	service service;
	districts man;
	@GetMapping("/home")
	public String home() {
		return "HelloWorld";
	}
	

	
	@GetMapping("/districts")
	public List<districtsDto> getMandals(@RequestParam(required=false) Integer id){
		List<districtsDto> list=service.getMand(id);
		return list;
	}
	
	@GetMapping("/donners/{id}")
	public donner getStudents(@PathVariable int id){
		return service.viewDonner(id);
	}
	
	@GetMapping("donnersList")
	public List<donnerDao> getDonnersListByDist(@RequestParam(required=false) String dist,
												@RequestParam(required=false) String mandal,
												@RequestParam(required=false) Integer grp,
												@RequestParam(required=false) Integer id){
		return service.getDonner(dist,mandal,grp,id);
	}
	
	
	
	@PostMapping("/donners")
	public String createDonner(@RequestBody donner body) {
		return service.createDonner(body);
	}
	
}
