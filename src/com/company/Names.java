package com.company;

import java.io.Serializable;
import java.util.*;

/**
 * Created by hansoljeong on 2015. 10. 12..
 */


public class Names implements Serializable {
    private static final long serialVersionUID = 7618592603957575653L;
    private String Movie;
    private String Age;
    private String ReleaseDate;


    public Names(String theMovie, String theAge, String theReleaseDate) {
        Movie = theMovie;
        Age = theAge;
        ReleaseDate = theReleaseDate;
    }

    public Names(HashMap aMap){
        this.Movie = (String)aMap.get("Movie");
        this.Age = (String)aMap.get("Age");
        this.ReleaseDate = (String)aMap.get("ReleaseDate");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Names names = (Names) o;

        if (Movie != null ? !Movie.equals(names.Movie) : names.Movie != null) return false;
        if (Age != null ? !Age.equals(names.Age) : names.Age != null) return false;
        return !(ReleaseDate != null ? !ReleaseDate.equals(names.ReleaseDate) : names.ReleaseDate != null);

    }

    @Override
    public int hashCode() {
        int result = Movie != null ? Movie.hashCode() : 0;
        result = 31 * result + (Age != null ? Age.hashCode() : 0);
        result = 31 * result + (ReleaseDate != null ? ReleaseDate.hashCode() : 0);
        return result;
    }
}
