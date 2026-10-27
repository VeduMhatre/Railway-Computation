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





	public String calculateTrainLength(double speed, double trainlength, double time, String speedUnit, String timeUnit){
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
			msg = "Length Of Platform is " + platformlength + " metres";
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
			if(direction.equalsIgnoreCase("opposite")){
				double relativespeed = s1+s2;
				msg = "Relative speed of two trains moving in opposite direction  is: " + Math.abs(relativespeed) + " km/h";
			}	
			
		}
		catch(Exception e){
			msg = "platform Length Issue " + e;
		}
		return msg;
	}


}