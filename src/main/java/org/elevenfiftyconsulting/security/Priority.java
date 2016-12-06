package org.elevenfiftyconsulting.security;

public enum Priority {
	PRIORITYONE(1, "Grab it now!"), PRIORITYTWO(2, "Need it soon"), PRIORITYTHREE(3, "It can wait");
	
	private final String displayText;
	
	private final Integer num;
	

	Priority(Integer num, String displayText) {
		this.num = num;
		this.displayText = displayText;
	}

	public Integer getNum() {
		return num;
	}
	
	public String getDisplayText() {
		return displayText;
	}

}
