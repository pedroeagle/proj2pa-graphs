package controller;

public class Pair{
    private Integer first;
    private Integer second;

    public Pair(Integer first, Integer second) {
        super();
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            return 
            ((  this.first == otherPair.first ||
                ( this.first != null && otherPair.first != null &&
                  this.first.equals(otherPair.first))) &&
             (  this.second == otherPair.second ||
                ( this.second != null && otherPair.second != null &&
                  this.second.equals(otherPair.second))) );
        }

        return false;
    }
    
    public int compareTo(Object other) {       
        //compare pair
    	if (other instanceof Pair) {
            Pair otherPair = (Pair) other; 
            if(this.first == otherPair.first) {
            	if(this.second < otherPair.second) {
            		return -1;
            	}
            	else if(this.second > otherPair.second) {
            		return 1;
            	}
            	else {
            		return 0;
            	}
            }
            else {
            	if(this.first < otherPair.first) {
            		return -1;
            	}
            	else if(this.first > otherPair.first) {
            		return 1;
            	}
            	else {
            		return 0;
            	}
            }
        }
    	return -2;
    }

    public String toString()
    { 
           return "(" + first + ", " + second + ")"; 
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
}