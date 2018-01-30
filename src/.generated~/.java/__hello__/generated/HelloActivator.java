package __hello__.generated;

import ej.wadapps.management.ActivitiesList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleActivator;

@SuppressWarnings("all")
public class HelloActivator implements BundleActivator {

	com.microej.demo.hello.HelloActivity com__microej__demo__hello__HelloActivity;

	@Override
	public void initialize() {
		this.com__microej__demo__hello__HelloActivity = new com.microej.demo.hello.HelloActivity();
	}

	@Override
	public void link() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.add(this.com__microej__demo__hello__HelloActivity);

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.remove(this.com__microej__demo__hello__HelloActivity);

	}

}