/**
 * 
 */
package com.abcinstitute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcinstitute.Database.AddressDao;
import com.abcinstitute.beans.Address;

/**
 * @author pras_khanal
 *
 */
@Service("addressService")
public class AddressService{
	
	private AddressDao addressDao;
	
	@Autowired
	public void setAddressDao(AddressDao addressDao){
		this.addressDao=addressDao;
	}

	/* (non-Javadoc)
	 * @see com.app.service.AddressService#getAddress(int)
	 */
	public Address getAddress(int userId) {
		return addressDao.getAddress(userId);
	}

	/* (non-Javadoc)
	 * @see com.app.service.AddressService#saveAddress(com.app.beans.Address, int)
	 */
	public void saveAddress(Address address, int userId) {
       addressDao.addAddress(address, userId);
	}

	/* (non-Javadoc)
	 * @see com.app.service.AddressService#editUserAddress(com.app.beans.Address, int)
	 */
	public void editUserAddress(Address address, int userId) {
		addressDao.editUserAddress(address, userId);

	}

}
