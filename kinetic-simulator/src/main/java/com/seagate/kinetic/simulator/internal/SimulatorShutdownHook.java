/** Do NOT modify or remove this copyright and confidentiality notice!
 *
 * Copyright (c) 2001 - $Date: 2012/06/27 $ Seagate Technology, LLC.
 *
 * The code contained herein is CONFIDENTIAL to Seagate Technology, LLC.
 * Portions are also trade secret. Any use, duplication, derivation, distribution
 * or disclosure of this code, for any reason, not expressly authorized is
 * prohibited. All other rights are expressly reserved by Seagate Technology, LLC.
 */
package com.seagate.kinetic.simulator.internal;

import kinetic.simulator.SimulatorConfiguration;

import com.seagate.kinetic.simulator.io.provider.nio.NioSharedResourceManager;

/**
 * 
 * Simulator shutdown hook.
 * 
 * @author chiaming
 * 
 */
public class SimulatorShutdownHook extends Thread {

	ThreadPoolService tpService = null;

	public SimulatorShutdownHook(ThreadPoolService tpService) {
		this.tpService = tpService;
	}

	@Override
	public void run() {

		if (SimulatorConfiguration.getNioResourceSharing()) {
			NioSharedResourceManager.close();
		}
		// System.out.println("shutdown hook executed ...");
	}

}
