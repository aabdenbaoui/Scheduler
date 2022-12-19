package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    public void testIsInteger(){
        String time01 = "12:03 PM";//will pass
        String time02 = "1:03 PM";//will pass
        String time03 = "12:05 AM";//will pass
        String time04 = "5:03 AM";//will pass
        Throwable exception01 = assertThrows(IllegalArgumentException.class, () -> Time.fromString(time03));
        assertEquals("Time can't contain 12 and AM simultaneously. If the time is AM choose 00", exception01.getMessage());
    }
    @Test
    public void testEquals(){
        Time time00 = Time.fromString("11:59 PM");
        Time time01 = Time.fromString("12:03 AM");
        Time time02 = Time.fromString("8:17 AM");
        Time time03 = Time.fromString("11:59 AM");
        Time time04 = Time.fromString("12:00 PM");
        Time time05 = Time.fromString("8:17 PM");
        Time time06 = Time.fromString("11:59 PM");


//        System.out.println(time01);
//        System.out.println(time02);
//        System.out.println(time03);
//        System.out.println(time04);
//        System.out.println(time05);
//        Time time06 = time01.clone();
//        Assertions.assertEquals(time01.toString(), time06.toString());
        Assertions.assertEquals(time01.compareTo(time02),  -1);
        //should be -1 because time01 is before time03
        Assertions.assertEquals(time02.compareTo(time03), -1);
        Assertions.assertEquals(time03.compareTo(time04), -1);
        Assertions.assertEquals(time04.compareTo(time05), -1);
        Assertions.assertEquals(time05.compareTo(time06), -1);
        Assertions.assertEquals(time06.compareTo(time01), 1);
        Assertions.assertEquals(time05.compareTo(time02), 1);
        Assertions.assertEquals(time05.compareTo(time01), 1);
        Assertions.assertEquals(time00.compareTo(time06), 0);



//        Assertions.assertEquals(time02.compareTo(time03), -1);




//        assertEquals(time01.toString(), time02.toString());
//        assertEquals(time01.toString(), time03.toString());
//
//        assertFalse(time01.equals(time03));
//        assertTrue(time01.equals(time02));
//        assertFalse(time01.equals(time03));
//        assertTrue(time04.equals(time05));
//        assertTrue(time01.isPM());
//        assertFalse(time05.isPM());
    }
    @Test
    public void testShift(){
        Time time02 = Time.fromString("12:22 AM");
        time02.shift(1444);
        assertEquals(time02.toString(),"12:26 PM");
        Throwable exception01 = assertThrows(IllegalArgumentException.class, () -> time02.shift(-5));
        assertEquals("The minutes can't be negative", exception01.getMessage());
    }

}