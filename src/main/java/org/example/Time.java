package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time implements Cloneable, Comparable<Time> {
    private  int hour;
    private int minute;
    private boolean PM;


    public Time(int hour, int minute, boolean PM){
        this.hour = hour;
        this.minute = minute;
        this.PM = PM;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isPM() {
        return PM;
    }


    public static Time fromString(String input) {
        int hour = 0;
        int min = 0;

        if ((input.length() != 7 && input.length() != 8)){
            throw new IllegalArgumentException("wrong input check length or space before PM");
        }
        if(!Character.isWhitespace(input.charAt(input.length() - 3))){
            throw new IllegalArgumentException("wrong input check length or space before PM");
        }

        if(!input.contains(":")){
            throw new IllegalArgumentException("input doesn't have :");
        }
        int indexOfColon = input.indexOf(":");
        int indexOfSpace = input.indexOf(" ");

        String minStr = input.substring(indexOfColon + 1, indexOfSpace);
        String hourStr = input.substring(0, indexOfColon);

        if (isInteger(hourStr)) {
            if (Integer.parseInt(hourStr) >= 1 && Integer.parseInt(hourStr) <= 12) {
                hour = Integer.parseInt(hourStr);
            }
        } else {
            throw new IllegalArgumentException("Wrong input at hour side");
        }
        if (isInteger(minStr)) {
            if (Integer.parseInt(minStr) >= 0 && Integer.parseInt(minStr) <= 59) {
                min = Integer.parseInt(minStr);
            }
        } else {
            throw new IllegalArgumentException("Wrong input at min side");
        }
        String pmStr = input.substring(indexOfSpace + 1);
        boolean pM;
        if (pmStr.equals("PM")) {
            pM = true;
        } else if (pmStr.equals("AM")) {
            pM = false;
        } else {
            throw new IllegalArgumentException("wrong input  for PM/AM");
        }

     return new Time(hour, min, pM);
    }
    public Time clone(){
        try{
            Time copy = (Time) super.clone();
            return copy;
        }catch (CloneNotSupportedException e){
             return null;
        }

    }
    private static  boolean isInteger(String str){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Time time){
        return (this.PM == time.PM && this.minute == time.minute && this.hour == time.hour) ? true : false;
    }

    private String isPmToString(){
        if(this.PM == true){
            return "PM";
        }else{
            return "AM";
        }
    }
    private String formatMinuteString(){
       return Integer.toString(this.minute).length() == 1 ? "0" + this.minute : Integer.toString(this.minute);
    }
    private String formatHourString(){
        return Integer.toString(this.hour).length() == 1 ? "0" + this.hour : Integer.toString(this.hour);
    }
    @Override
    public String toString(){
        return formatHourString() + ":" + formatMinuteString() + " " + isPmToString();
    }

    @Override
    public int compareTo(Time time) {
        if((time.PM == true && this.PM == true) || (time.PM == false && this.PM == false)){
            if(time.hour == this.hour) {
                if (time.minute == this.minute) {
                    return 0;
                } else if (time.minute < this.minute) {
                    return 1;
                    //time.minute > this.minute
                } else {
                    return -1;
                }
            }else if (time.hour == 12 && this.hour != 12){
                return 1;
            } else if(time.hour != 12 && this.hour == 12){
                return -1;
            }else if(time.hour < this.hour){
                  return 1;
            //  time.hour > this.hour
            }else{
                return -1;
            }
        }else if (time.PM == true && this.PM == false){
               return -1;
        //time.pm == false && this.pm == true
        }else{
               return 1;
        }
    }
}


