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
        Time time01 = Time.fromString("12:03 PM");
        Time time02 = Time.fromString("12:03 PM");
        Time time03 = Time.fromString("00:03 AM");
        Time time04 = Time.fromString("0:56 AM");
        Time time05 = Time.fromString("05:56 AM");
        System.out.println(time01);
        System.out.println(time02);
        System.out.println(time03);
        System.out.println(time04);
        System.out.println(time05);


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
}