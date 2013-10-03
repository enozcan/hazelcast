package com.hazelcast.security.permission;

import static com.hazelcast.security.SecurityConstants.*; 

public class ExecutorServicePermission extends InstancePermission {
	
	private final static int EXECUTE 		= 0x4;
	
	private final static int ALL 			= CREATE | DESTROY | EXECUTE;

	public ExecutorServicePermission(String name, String... actions) {
		super(name, actions);
	}

	protected int initMask(String[] actions) {
		int mask = NONE;
		for (int i = 0; i < actions.length; i++) {
			if(SecurityConstants.ACTION_ALL.equals(actions[i])) {
				return ALL;
			}
			
			if(SecurityConstants.ACTION_CREATE.equals(actions[i])) {
				mask |= CREATE;
			} else if(SecurityConstants.ACTION_EXECUTE.equals(actions[i])) {
				mask |= EXECUTE;
			} else if(SecurityConstants.ACTION_DESTROY.equals(actions[i])) {
				mask |= DESTROY;
			}
		}
		return mask;
	}
}
