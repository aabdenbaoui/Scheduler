package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class WeekdayTest {
    @Test
    public void testingFromString(){
        //testing mondays
        Assertions.assertEquals(Weekday.MONDAY, Weekday.fromString("monday"));
        Assertions.assertEquals(Weekday.MONDAY, Weekday.fromString("MONDAY"));
        Assertions.assertEquals(Weekday.MONDAY, Weekday.fromString("MonDay"));
        Assertions.assertEquals(Weekday.MONDAY, Weekday.fromString("m"));
        Assertions.assertEquals(Weekday.MONDAY, Weekday.fromString("M"));
        Assertions.assertNotEquals(Weekday.MONDAY,Weekday.fromString("t"));
        //testing tuesdays:
        Assertions.assertEquals(Weekday.TUESDAY, Weekday.fromString("tuesday"));
        Assertions.assertEquals(Weekday.TUESDAY, Weekday.fromString("TUESDAY"));
        Assertions.assertEquals(Weekday.TUESDAY, Weekday.fromString("TuesDaY"));
        Assertions.assertEquals(Weekday.TUESDAY, Weekday.fromString("t"));
        Assertions.assertEquals(Weekday.TUESDAY, Weekday.fromString("T"));
        Assertions.assertNotEquals(Weekday.TUESDAY,Weekday.fromString("w"));
        //testing wednesday
        Assertions.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("wednesday"));
        Assertions.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("WEDNESDAY"));
        Assertions.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("WeDnESdAY"));
        Assertions.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("w"));
        Assertions.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("W"));
        Assertions.assertNotEquals(Weekday.WEDNESDAY,Weekday.fromString("R"));
        //testing thursday
        Assertions.assertEquals(Weekday.THURSDAY, Weekday.fromString("thursday"));
        Assertions.assertEquals(Weekday.THURSDAY, Weekday.fromString("THURSDAY"));
        Assertions.assertEquals(Weekday.THURSDAY, Weekday.fromString("ThUrsDay"));
        Assertions.assertEquals(Weekday.THURSDAY, Weekday.fromString("r"));
        Assertions.assertEquals(Weekday.THURSDAY, Weekday.fromString("R"));
        Assertions.assertNotEquals(Weekday.THURSDAY,Weekday.fromString("f"));
        //testing friday
        Assertions.assertEquals(Weekday.FRIDAY, Weekday.fromString("friday"));
        Assertions.assertEquals(Weekday.FRIDAY, Weekday.fromString("FRIDAY"));
        Assertions.assertEquals(Weekday.FRIDAY, Weekday.fromString("FriDaY"));
        Assertions.assertEquals(Weekday.FRIDAY, Weekday.fromString("f"));
        Assertions.assertEquals(Weekday.FRIDAY, Weekday.fromString("F"));
        Assertions.assertNotEquals(Weekday.FRIDAY,Weekday.fromString("m"));
        //testing throw new Illigal Argument
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Weekday.fromString("GGAN");
            }
        });
    }
    @Test
     public void testShortNameAndToString(){
        Weekday weekdayMonday = Weekday.fromString("m");
        Weekday weekdayTuesday = Weekday.fromString("t");
        Weekday weekdayWednesday = Weekday.fromString("w");
        Weekday weekdayTHURSDAY = Weekday.fromString("r");
        Weekday weekdayFriday = Weekday.fromString("f");

        Assertions.assertEquals(weekdayMonday.toShortName(), "M");
        Assertions.assertEquals(weekdayTuesday.toShortName(), "T");
        Assertions.assertEquals(weekdayWednesday.toShortName(), "W");
        Assertions.assertEquals(weekdayTHURSDAY.toShortName(), "R");
        Assertions.assertEquals(weekdayFriday.toShortName(), "F");
        Assertions.assertNotEquals(weekdayFriday.toShortName(), "G");

        //test toString

        Assertions.assertEquals("Monday", weekdayMonday.toString());
        Assertions.assertEquals("Tuesday", weekdayTuesday.toString());
        Assertions.assertEquals("Wednesday", weekdayWednesday.toString());
        Assertions.assertEquals("Thursday", weekdayTHURSDAY.toString());
        Assertions.assertEquals("Friday", weekdayFriday.toString());
        Assertions.assertNotEquals("Garbage", weekdayMonday.toString());


    }

}