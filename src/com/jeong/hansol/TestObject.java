package com.jeong.hansol;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;


@SuppressWarnings("serial")
public class TestObject implements Serializable {
	private String theString;
	private int theInt;
	private Date theDate;
	
	public TestObject(String aString, int anInt, Date aDate) {
		theString = aString;
		theInt = anInt;
		theDate = aDate;
	}
	
	public TestObject(HashMap aMapRepresentation){
		this.theString = (String)aMapRepresentation.get("theString");
		//dates are stored as timestamp strings.
		String stampString = (String)aMapRepresentation.get("theDate");
		Timestamp aStamp = Timestamp.valueOf(stampString);
		this.theDate = aStamp;
		//numbers are stored as longs or doubles.
		Long asLong = (Long)aMapRepresentation.get("theInt");
		this.theInt = asLong.intValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TestObject)) return false;

		TestObject that = (TestObject) o;

		if (theInt != that.theInt) return false;
		if (theString != null ? !theString.equals(that.theString) : that.theString != null) return false;
		return !(theDate != null ? !theDate.equals(that.theDate) : that.theDate != null);

	}

	@Override
	public int hashCode() {
		int result = theString != null ? theString.hashCode() : 0;
		result = 31 * result + theInt;
		result = 31 * result + (theDate != null ? theDate.hashCode() : 0);
		return result;
	}
}
