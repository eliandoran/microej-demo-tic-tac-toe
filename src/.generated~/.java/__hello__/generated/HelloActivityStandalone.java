package __hello__.generated;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleRegistry;
import ej.wadapps.management.ActivitiesScheduler;
import ej.wadapps.management.ActivitiesList;
import ej.wadapps.app.Activity;
import ej.wadapps.registry.SharedRegistryFactory;

@SuppressWarnings("all")
public class HelloActivityStandalone {

	public static void main(String[] args) {
		SharedRegistryFactory.getSharedRegistry().register(BundleRegistry.class, new WadappsRegistry());

		// Start entry point.
		new HelloEntryPoint().start();

		// Show HelloActivity	
		ActivitiesScheduler activitiesScheduler = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesScheduler.class);
		ActivitiesList activitiesList = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		Activity[] activities = activitiesList.getActivities();
		for (Activity activity : activities) {
			if(activity instanceof com.microej.demo.hello.HelloActivity) {
				activitiesScheduler.show(activity);
				break;
			}
		}
	}

}