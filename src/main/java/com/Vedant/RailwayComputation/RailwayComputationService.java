package com.Vedant.RailwayComputation;

import org.springframework.stereotype.*;

@Service
public class RailwayComputationService {

	public String calculateTrainLength(double speed, double time, String speedUnit, String timeUnit){
		String msg = "";
		try{
			if(speed <= 0 || time <= 0){
				return "Both Speed and time cannot be less than or equal to zero";
			}
			double speedInMps;
			if(speedUnit.equalsIgnoreCase("km/h")){
				speedInMps = speed * 5.0 / 18.0;
			}
			else if(speedUnit.equalsIgnoreCase("m/s")) {
				speedInMps = speed;
			}
			else{
				return "Invalid speed unit. Use km/h or m/s";
			}

			double timeInSeconds;
			if(timeUnit.equalsIgnoreCase("minutes")){
				timeInSeconds = time * 60.0;
			}
			else if(timeUnit.equalsIgnoreCase("seconds")) {
				timeInSeconds = time;
			}
			else if(timeUnit.equalsIgnoreCase("hour")) {
				timeInSeconds = time * 3600.0;
			}
			else{
				return "Invalid time unit. Use minute or seconds or hour";
			}
			
	
			double length = speedInMps * timeInSeconds;
			msg = "Length Of Train is " + length + " metres";
		}
		catch(Exception e){
			msg = "Train Length Issue " + e;
		}
		return msg;
	}





	public String calculatePlatformLength(double speed, double trainlength, double time, String speedUnit, String timeUnit){
		String msg = "";
		try{
			if(speed <= 0 || time <= 0 || trainlength <=0){
				return "Speed, Time & length of Train cannot be less than or equal to zero";
			}
			double speedInMps;
			if(speedUnit.equalsIgnoreCase("km/h")){
				speedInMps = speed * 5.0 / 18.0;
			}
			else if(speedUnit.equalsIgnoreCase("m/s")) {
				speedInMps = speed;
			}
			else{
				return "Invalid speed unit. Use km/h or m/s";
			}

			double timeInSeconds;
			if(timeUnit.equalsIgnoreCase("minutes")){
				timeInSeconds = time * 60.0;
			}
			else if(timeUnit.equalsIgnoreCase("seconds")) {
				timeInSeconds = time;
			}
			else if(timeUnit.equalsIgnoreCase("hour")) {
				timeInSeconds = time * 3600.0;
			}
			else{
				return "Invalid time unit. Use minute or seconds or hour";
			}
			
			double platformlength = (speedInMps * timeInSeconds)-trainlength;
			if (platformlength <= 0) {
    				return "Invalid inputs: platform length must be greater than zero.";
			}
			else{
				msg = "Length Of Platform is " + platformlength + " metres";
			}
			
		}
		catch(Exception e){
			msg = "platform Length Issue " + e;
		}
		return msg;
	}
	
	public String calculateRelativeSpeed(double speedtrain1, double speedtrain2, String direction, String speedUnit){
		String msg = "";
		try{
			if(speedtrain1 <= 0 || speedtrain2 <= 0){
				return "Speed of both trains cannot be less than or equal to zero";
			}
			double s1;
			double s2;

			if(speedUnit.equalsIgnoreCase("km/h")){
				s1 = speedtrain1;
				s2 = speedtrain2;
			}
			else if(speedUnit.equalsIgnoreCase("m/s")) {
				s1 = speedtrain1 * 18.0 / 5.0;
				s2 = speedtrain2 * 18.0 / 5.0;
			}
			else{
				return "Invalid speed unit. Use km/h or m/s";
			}
			
			if(direction.equalsIgnoreCase("same")){
				double relativespeed = Math.abs(s1-s2);
				msg = "Relative speed of two trains moving in same direction  is: " + relativespeed + " km/h";
			}
			else if(direction.equalsIgnoreCase("opposite")){
				double relativespeed = s1+s2;
				msg = "Relative speed of two trains moving in opposite direction  is: " + Math.abs(relativespeed) + " km/h";
			}	
			else {
    				return "Invalid direction. Use 'same' or 'opposite'.";
			}
		}
		catch(Exception e){
			msg = "Relative speed Issue " + e;
		}
		return msg;
	}


	public String calculateTrainCrossingTime(double trainlength1, double trainlength2, double speedtrain1, double speedtrain2, String direction, String speedUnit){
		try {
			if (trainlength1 <= 0 || trainlength2 <= 0) {
				return "Train lengths must be greater than zero.";
			}
			if (speedtrain1 <= 0 || speedtrain2 <= 0) {
				return "Speed of both trains cannot be less than or equal to zero";
			}
			double s1;
			double s2;

			if (speedUnit.equalsIgnoreCase("km/h")) {
				s1 = speedtrain1 * 5.0 / 18.0;
				s2 = speedtrain2 * 5.0 / 18.0;
			} else if (speedUnit.equalsIgnoreCase("m/s")) {
				s1 = speedtrain1; 
				s2 = speedtrain2;
			} else {
				return "Invalid speed unit. Use km/h or m/s";
			}
	
			double relativeSpeed;
			
			if (direction.equalsIgnoreCase("same")) {
				if (s1 == s2) {
					return "Overtaking is not possible because both trains are moving in the same direction at the same speed.";
				}
				relativeSpeed = Math.abs(s1 - s2);
			} else if (direction.equalsIgnoreCase("opposite")) {
				relativeSpeed = s1 + s2;
			} else {
				return "Invalid direction. Use 'same' or 'opposite'.";
			}

			double totalLength = trainlength1 + trainlength2;
			double crossingTime = totalLength / relativeSpeed;
			
			return String.format("Crossing time: %.2f seconds (Relative Speed: %.2f m/s, Total Length: %.2f meters)", 
					crossingTime, relativeSpeed, totalLength);
		}
		catch(Exception e){
			return "Crossing Time Calculation Issue: " + e.getMessage();
		}
	}


	public String calculateMeetingSpeedRatio(double time1AfterMeeting, double time2AfterMeeting){
		try{
			if (time1AfterMeeting <= 0 || time2AfterMeeting <= 0) {
            			return "Time values after meeting must be greater than zero.";
        		}
			double v1 = Math.sqrt(time2AfterMeeting);
    			double v2 = Math.sqrt(time1AfterMeeting);

			return String.format("Speed ratio (v1 : v2): %.2f : %.2f",v1, v2);
		}
		catch(Exception e){
			return "Calculation Issue: " + e.getMessage();
		}
		
	}


	public String calculateTrainSpeed(double trainLength, double time, double personSpeed, String speedUnit, String timeUnit, String direction){
		try{
		if(trainLength<=0 || time <= 0 || personSpeed <0){
			 return "Train length and time must be positive; person speed cannot be negative.";
		}
		
		double personSpeedMps;
		if (speedUnit.equalsIgnoreCase("km/h")) {
        		personSpeedMps = personSpeed * 5.0 / 18.0;
   		} else if (speedUnit.equalsIgnoreCase("m/s")) {
        		personSpeedMps = personSpeed;
    		} else {
        		return "Invalid speed unit. Use km/h or m/s.";
    		}


		double timeInSeconds;

    		if (timeUnit.equalsIgnoreCase("seconds")) {
        		timeInSeconds = time;
    		} else if (timeUnit.equalsIgnoreCase("minutes")) {
        		timeInSeconds = time * 60.0;
    		} else if (timeUnit.equalsIgnoreCase("hour") || timeUnit.equalsIgnoreCase("hours")) {
        		timeInSeconds = time * 3600.0;
    		} else {
        		return "Invalid time unit.";
    		}

		double relativeSpeed = trainLength / timeInSeconds;
   		double trainSpeedMps;

    		if (direction.equalsIgnoreCase("same")) {
        		trainSpeedMps = relativeSpeed + personSpeedMps;
    		} else if (direction.equalsIgnoreCase("opposite")) {
        		trainSpeedMps = relativeSpeed - personSpeedMps;
    		} else {
        		return "Invalid direction. Use same or opposite.";
    		}

    		if (trainSpeedMps <= 0) {
        		return "The given values do not produce a positive train speed.";
    		}

    		double trainSpeedKmph = trainSpeedMps * 18.0 / 5.0;

	    	return String.format("Train speed: %.2f km/h", trainSpeedKmph);
		}
		catch(Exception e){
			return "Train Speed Issue: " + e.getMessage();
		}


	}


}