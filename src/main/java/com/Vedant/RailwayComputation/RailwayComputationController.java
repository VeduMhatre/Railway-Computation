package com.Vedant.RailwayComputation;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class RailwayComputationController {
	
	private RailwayComputationService service;
	
	public RailwayComputationController(RailwayComputationService service) {
		this.service=service;
	}
	
	@PostMapping("/trainlength")
	public String calculateTrainLength(@RequestParam double speed, @RequestParam double time, @RequestParam String speedUnit, @RequestParam String timeUnit){
		return service.calculateTrainLength(speed, time, speedUnit, timeUnit);
	}

	@PostMapping("/platformlength")
	public String calculatePlatformLength(@RequestParam double speed, @RequestParam double trainlength, @RequestParam double time, @RequestParam String speedUnit, @RequestParam String timeUnit){
		return service.calculateTrainLength(speed, trainlength, time, speedUnit, timeUnit);
	}

	@PostMapping("/relativespeed")
	public String calculateRelativeSoeed(@RequestParam double speedtrain1, @RequestParam double speedtrain2, @RequestParam String direction, @RequestParam String speedUnit){
		return service.calculateRelativeSpeed(speedtrain1, speedtrain2, direction, speedUnit);
	}
	

}