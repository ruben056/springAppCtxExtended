package be.rd.services.events;

import org.springframework.context.ApplicationListener;

public class PowderEventListener implements
		ApplicationListener<PowderEvent> {

	@Override
	public void onApplicationEvent(PowderEvent event) {
		System.out.println("Received event : " + event.getMsg());
	}

}
