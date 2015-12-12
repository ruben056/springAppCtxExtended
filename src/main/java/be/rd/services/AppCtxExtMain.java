package be.rd.services;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import be.rd.services.events.PowderEvent;

public class AppCtxExtMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("app-context.xml");
		
		internationalisation(appCtx);
		eventListeners(appCtx);
		accessingResources(appCtx);		
		
		appCtx.close();
	}

	private static void internationalisation(
			ClassPathXmlApplicationContext appCtx) {
		System.out.println(System.lineSeparator());
		System.out.println("internationalisation:");
		System.out.println(Locale.ENGLISH + " : " + appCtx.getMessage("msg", null, Locale.ENGLISH));
		System.out.println(Locale.GERMAN + " : " + appCtx.getMessage("msg", null, Locale.GERMAN));
	}

	private static void eventListeners(ClassPathXmlApplicationContext appCtx) {
		System.out.println(System.lineSeparator());
		System.out.println("eventListeners:");
		appCtx.publishEvent(new PowderEvent(appCtx, "Powder coming soon!!!"));
	}
	
	private static void accessingResources(ClassPathXmlApplicationContext appCtx) {
		System.out.println(System.lineSeparator());
		System.out.println("accessingResources:");

		try {
//			String[] resourceLocators = new String[]{"file:///d:/temp/test.txt", "classpath:test.txt","http://www.google.co.uk"};
			String[] resourceLocators = new String[]{"classpath:test.txt","http://www.google.co.uk"};
			for (String resourceLocator : resourceLocators) {
				Resource res = appCtx.getResource(resourceLocator);	
				System.out.println(res.getClass());
				System.out.println(res.getURL().getContent());
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
