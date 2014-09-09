package edu.newpaltz.cs.CS352.HW1;

import java.util.*;
class RandomStringGeneratorOther
{        
    private ArrayList<Range> RangeAL;    
    public RandomStringGeneratorOther()
    {
    	RangeAL = new ArrayList<Range>();
    }
    
    public void addRange(char begin, char end)
    {
        Range RangeToAdd = new Range(begin, end);
        System.out.println("Made it to after object construction");
        RangeAL.add(RangeToAdd);
    }
    
    private int next;
    public int nextString()
    {        
        for (int i = 0; i < RangeAL.size(); i++)
        {
             getRangeIndex(i);                        
        }
        return next;
        
    }
    public String nextString(String phrase)
    {
        return null;
    }
    
    private int getRangeIndex(int place)
    {
        int index;
        index = RangeAL.indexOf(place);
        return index;
    }
}