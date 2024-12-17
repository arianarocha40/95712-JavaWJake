// Name: Ariana Rocha
// Andrew ID: afrocha
// JAVA HW 2

package com.example;
import java.util.Comparator;

public class TypeSorter implements Comparator<Citation> {
    @Override
    public int compare(Citation c1, Citation c2) {
        return c1.getTypeOfOffense().compareToIgnoreCase(c2.getTypeOfOffense());
    }
}
