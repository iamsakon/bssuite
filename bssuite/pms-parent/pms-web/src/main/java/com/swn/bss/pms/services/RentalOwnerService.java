/**
 * 
 */
package com.swn.bss.pms.services;

import com.swn.bss.pms.entity.RentalOwnerDomain;
import java.util.List;

/**
 * @author MrMai
 *
 */
public interface RentalOwnerService {

	/**
	 * 
	 * @param rentalOwnerDomain
	 * @return
	 */
	public RentalOwnerDomain saveRentalOwner(RentalOwnerDomain rentalOwnerDomain);

	/**
	 * 
	 * @param rentalOwnerDomain
	 * @return
	 */
	public RentalOwnerDomain updateRentalOwner(
			RentalOwnerDomain rentalOwnerDomain);

	/**
	 * 
	 * @param oid
	 * @return
	 */
	public boolean deleteRentalOwner(long oid);

	/**
	 * 
	 * @param oid
	 * @return
	 */
	public RentalOwnerDomain findRentalOwner(Long oid);

	/**
	 * 
	 * @return
	 */
	public long countActiveRentalOwner();

	/**
	 * 
	 * @return
	 */
	public List<RentalOwnerDomain> findActiveRentalOwner();

	/**
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<RentalOwnerDomain> findRentalOwner(int firstResult,
			int maxResults);

	/**
	 * 
	 * @param domain
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<RentalOwnerDomain> findRentalOwner(RentalOwnerDomain domain,
			int firstResult, int maxResult);
}
