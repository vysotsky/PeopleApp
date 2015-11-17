package com.asclav.people.bus;


import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Vlad on 11/17/15.
 */
public class BusProvider {

	private static volatile Bus instance;

	private BusProvider() {
	}

	public static Bus bus() {
		Bus localInstance = instance;
		if (localInstance == null) {
			synchronized (Bus.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new Bus(ThreadEnforcer.ANY);
				}
			}
		}
		return localInstance;
	}

}
