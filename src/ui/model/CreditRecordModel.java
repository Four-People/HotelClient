package ui.model;

import javafx.beans.property.SimpleStringProperty;

public class CreditRecordModel {

	private final SimpleStringProperty time;
	private final SimpleStringProperty orderid;
	private final SimpleStringProperty action;
	private final SimpleStringProperty change;
	private final SimpleStringProperty result;
	
	public CreditRecordModel(String record){
		record = record.replace('，', ',');
		String[] records = record.split(",");
		time = new SimpleStringProperty(records[0].split("'")[1]);
		orderid = new SimpleStringProperty(records[1]);
		action = new SimpleStringProperty(records[2]);
		change = new SimpleStringProperty(records[3]);
		result = new SimpleStringProperty(records[4]);
	}
	
	public SimpleStringProperty timeProperty(){
		return time;
	}
	
	public SimpleStringProperty orderidProperty(){
		return orderid;
	}
	
	public SimpleStringProperty actionProperty(){
		return action;
	}
	
	public SimpleStringProperty changeProperty(){
		return change;
	}
	
	public SimpleStringProperty resultProperty(){
		return result;
	}
}
