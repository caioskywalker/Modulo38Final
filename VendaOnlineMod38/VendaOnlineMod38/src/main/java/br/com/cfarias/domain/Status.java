package br.com.cfarias.domain;

public enum Status {
	
	INICIADA, CONCLUIDA, CANCELADA;
	
	public static Status getByName(String Value) {
		for(Status status :  Status.values()) {
			if(status.name().equals(Value)) {
				return status;
			}
		}
		return null;
	}
	
	
	
}
