package com.abcinstitute.service;
/**
 * 
 *//*
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Database.AddressDao;
import com.app.beans.Address;

*//**
 * @author pras_khanal
 *
 *//*
@Service("addressService")
public class AdressServiceImpl implements AddressService {
	
	private AddressDao addressDao;
	
	@Autowired
	public void setAddressDao(AddressDao addressDao){
		this.addressDao=addressDao;
	}

	 (non-Javadoc)
	 * @see com.app.service.AddressService#getAddress(int)
	 
	@Override
	public Address getAddress(int userId) {
		return addressDao.getAddress(userId);
	}

	 (non-Javadoc)
	 * @see com.app.service.AddressService#saveAddress(com.app.beans.Address, int)
	 
	@Override
	public void saveAddress(Address address, int userId) {
       addressDao.addAddress(address, userId);
	}

	 (non-Javadoc)
	 * @see com.app.service.AddressService#editUserAddress(com.app.beans.Address, int)
	 
	@Override
	public void editUserAddress(Address address, int userId) {
		addressDao.editUserAddress(address, userId);

	}

}
*/