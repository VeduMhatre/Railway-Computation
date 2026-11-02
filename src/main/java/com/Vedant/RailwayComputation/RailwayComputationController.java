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
		return service.calculatePlatformLength(speed, trainlength, time, speedUnit, timeUnit);
	}

	@PostMapping("/relativespeed")
	public String calculateRelativeSpeed(@RequestParam double speedtrain1, @RequestParam double speedtrain2, @RequestParam String direction, @RequestParam String speedUnit){
		return service.calculateRelativeSpeed(speedtrain1, speedtrain2, direction, speedUnit);
	}
	
	@PostMapping("/traincrossingtime")
	public String calculateTrainCrossingTime(@RequestParam double trainlength1, @RequestParam double trainlength2, @RequestParam double speedtrain1, @RequestParam double speedtrain2, @RequestParam String direction, @RequestParam String speedUnit){
		return service.calculateTrainCrossingTime(trainlength1, trainlength2, speedtrain1, speedtrain2, direction, speedUnit);
	}

	@PostMapping("/oppositetrainmeet")
	public String calculateMeetingSpeedRatio(@RequestParam double time1AfterMeeting, @RequestParam double time2AfterMeeting){
		return service.calculateMeetingSpeedRatio(time1AfterMeeting, time2AfterMeeting);
	}


	@PostMapping("/trainspeed")
	public String calculateTrainSpeed(@RequestParam double trainLength, @RequestParam double time, @RequestParam double personSpeed, @RequestParam String speedUnit, @RequestParam String timeUnit, @RequestParam String direction){
		return service.calculateTrainSpeed(trainLength, time, personSpeed, speedUnit, timeUnit, direction);
	}


}