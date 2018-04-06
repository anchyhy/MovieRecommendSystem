package com.lzs.util;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Long> {  
	  
    Map<Long, Double> base;  
    public ValueComparator(Map<Long, Double> base) {  
        this.base = base;  
    }  
  
    // Note: this comparator imposes orderings that are inconsistent with equals.      
    public int compare(Long a, Long b) {  
        if (base.get(a) >= base.get(b)) {  
            return -1;  
        } else {  
            return 1;  
        } // returning 0 would merge keys  
    }


}  

