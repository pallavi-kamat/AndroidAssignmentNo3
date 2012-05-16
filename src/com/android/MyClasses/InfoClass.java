package com.android.MyClasses;

public class InfoClass {
	String iName;
	String iEmialId;
	int iAge;
	String iGender;
	
	public InfoClass() {
		super();
	}

	public InfoClass(String iName, String iEmialId, int iAge, String iGender) {
		super();
		this.iName = iName;
		this.iEmialId = iEmialId;
		this.iAge = iAge;
		this.iGender = iGender;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiEmialId() {
		return iEmialId;
	}

	public void setiEmialId(String iEmialId) {
		this.iEmialId = iEmialId;
	}

	public int getiAge() {
		return iAge;
	}

	public void setiAge(int iAge) {
		this.iAge = iAge;
	}

	public String getiGender() {
		return iGender;
	}

	public void setiGender(String iGender) {
		this.iGender = iGender;
	}

	@Override
	public String toString() {
		return "\n"+"Name: " + iName +"\n\n"+"Emial Id: " + iEmialId
				+"\n\n"+"Age: "+iAge+"\n\n"+"Gender: "+iGender;
	}
	
	
}
