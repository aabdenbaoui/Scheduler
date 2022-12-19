package org.example;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY;

    public static Weekday fromString(String s){
        switch(s.toLowerCase()){
            case "monday":
            case "m":
                return MONDAY;
            case "tuesday":
            case "t":
                return TUESDAY;
            case "wednesday":
            case "w":
                return WEDNESDAY;
            case "thursday":
            case "r":
                return THURSDAY;
            case "friday":
            case "f":
                return FRIDAY;
            default:
                throw new IllegalArgumentException();
        }

    }
    public String toShortName(){
        String shortName = null;
        switch (this){
            case MONDAY -> shortName = "M";
            case TUESDAY -> shortName = "T";
            case WEDNESDAY -> shortName = "W";
            case THURSDAY -> shortName = "R";
            case FRIDAY -> shortName = "F";
        }
        return shortName;
    }

    private String convertWeekdayToLowerCase(){
        String weekdayString = null;
        switch(this){
            case MONDAY -> weekdayString = "Monday";
            case TUESDAY -> weekdayString = "Tuesday";
            case WEDNESDAY -> weekdayString = "Wednesday";
            case THURSDAY -> weekdayString = "Thursday";
            case FRIDAY -> weekdayString = "Friday";
        }
        return weekdayString;
    }
    @Override
    public String toString() {
        return convertWeekdayToLowerCase();
    }
}
