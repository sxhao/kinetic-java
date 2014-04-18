/** Do NOT modify or remove this copyright and confidentiality notice!
 *
 * Copyright (c) 2001 - $Date: 2012/06/27 $ Seagate Technology, LLC.
 *
 * The code contained herein is CONFIDENTIAL to Seagate Technology, LLC.
 * Portions are also trade secret. Any use, duplication, derivation, distribution
 * or disclosure of this code, for any reason, not expressly authorized is
 * prohibited. All other rights are expressly reserved by Seagate Technology, LLC.
 */
package kinetic.admin;

/**
 * Kinetic drive utilization information container.
 * 
 */
public class Utilization {
	// device name
	private String name;

	// device utility
	private float utility;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getUtility() {
		return utility;
	}

	public void setUtility(float utility) {
		this.utility = utility;
	}


}
