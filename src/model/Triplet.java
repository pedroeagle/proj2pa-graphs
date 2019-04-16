package model;

import java.util.Comparator;

public class Triplet{
    private Integer first;
    private Integer second;
    private Integer third;

    public Triplet(Integer first, Integer second, Integer third) {
        super();
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean equals(Object other) {
        if (other instanceof Triplet) {
            Triplet otherTriplet = (Triplet) other;
            return 
            ((  this.getFirst() == otherTriplet.getFirst() ||
                ( this.getFirst() != null && otherTriplet.getFirst() != null &&
                  this.getFirst().equals(otherTriplet.getFirst()))) &&
             (  this.getSecond() == otherTriplet.getSecond() ||
                ( this.getSecond() != null && otherTriplet.getSecond() != null &&
                  this.getSecond().equals(otherTriplet.getSecond()))) ) &&
            (  this.getThird() == otherTriplet.getThird() ||
            ( this.getThird() != null && otherTriplet.getThird() != null &&
              this.getThird().equals(otherTriplet.getThird())));
        }

        return false;
    }

    public String toString()
    { 
           return "(" + first + ", " + second + ", " + third + ")"; 
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }
    
    public Integer getThird() {
        return third;
    }

    public void setThird(Integer third) {
        this.third = third;
    }
}

class TripletComparator implements Comparator<Triplet>{ 
    
    // Overriding compare()method of Comparator  
                // for descending order of cgpa 
    public int compare(Triplet t1, Triplet t2) {
    	if(t1.getFirst() == t2.getFirst()) {
          	if(t1.getSecond() == t2.getSecond()) {
           		if(t1.getThird() < t2.getThird()) {         	
	            	return -1;
	            }
	           	else if(t1.getThird() > t2.getThird()) {
	           		return 1;
	           	}
	           	else {
	           		return 0;
	           	}
           	}
           	else{
           		if(t1.getSecond() < t2.getSecond()) {
           	
	           		return -1;
	           	}
            	else if(t1.getSecond() > t2.getSecond()) {
	            	return 1;
	            }
	           	else {
	           		return 0;
	           	}
           	}
           }
           else {
           	if(t1.getFirst() < t2.getFirst()) {
           		return -1;
           	}
           	else if(t1.getFirst() > t2.getFirst()) {
           		return 1;
           	}
           	else {
           		return 0;
           	}
        }
    }
}