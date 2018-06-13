package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest extends Main {
    @Test
    public void sortByStrings() throws Exception {
        assertEquals(Main.sortByStrings("weather","therapyw"), "theeraw");
    }

    @Test
    public void sortByStringsNullCheck() throws Exception {
        assertEquals(Main.sortByStrings(null,null), "");
    }

    @Test
    public void sortByStringsEmptyCheck() throws Exception {
        assertEquals(Main.sortByStrings("",""), "");
    }


    @Test
    public void decodeString() throws Exception {
        assertEquals(Main.decodeString("2[b3[a]]"), "baaabaaa");
    }

    @Test
    public void decodeStringNullCheck() throws Exception {
        assertEquals(Main.decodeString(null), "");
    }

    @Test
    public void decodeStringEmptyCheck() throws Exception {
        assertEquals(Main.decodeString(""), "");
    }

    @Test
    public void changePossibilities() throws Exception {
        assertEquals(Main.changePossibilities(4, new int[]{1,2,3}), 4);
    }

    @Test
    public void changePossibilitiesNoPossibilities() throws Exception {
        assertEquals(Main.changePossibilities(4, new int[]{3}), 0);
    }

    @Test
    public void changePossibilitiesZeroAmount() throws Exception {
        assertEquals(Main.changePossibilities(0, new int[]{0,1,2,3}), 0);
    }

}