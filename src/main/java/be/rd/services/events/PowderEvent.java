package be.rd.services.events;

import org.springframework.context.ApplicationEvent;

public class PowderEvent extends ApplicationEvent {

	private String msg;
	
	public PowderEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
