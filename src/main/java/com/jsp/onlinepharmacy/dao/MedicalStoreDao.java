package com.jsp.onlinepharmacy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacy.dto.MedicalStoreDto;
import com.jsp.onlinepharmacy.entity.MedicalStore;
import com.jsp.onlinepharmacy.repository.MedicalStoreRepo;

@Repository
public class MedicalStoreDao {
	@Autowired
	private MedicalStoreRepo repo;

	public MedicalStore saveMedicalStore(MedicalStore medicalStore) {
		
		return repo.save(medicalStore);
	}

	public MedicalStore updateMedicalStore(int storeId, MedicalStore medicalStore) {
		//  medicalstore=name,managername ,address
		Optional<MedicalStore> optional=repo.findById(storeId);
		if (optional.isPresent()){
			MedicalStore oldMedicalStore=optional.get();
			
			// medicalStore=id, name, managername, address
			medicalStore.setStoreId(storeId);
			
			//  medicalstore=id,name,managername ,address
			medicalStore.setAdmin(oldMedicalStore.getAdmin());
			medicalStore.setAddress(oldMedicalStore.getAddress());
			return repo.save(medicalStore);
		}
		return null;
	}

	public MedicalStore getMedicalStoreById(int storeId) {
		
		 if (repo.findById(storeId).isPresent()){
			return repo.findById(storeId).get();
		}
		 return null;
	}

	public MedicalStore deleteMedicalStoreById(int storeId) {
		Optional<MedicalStore> optional=repo.findById(storeId);
		if(optional.isPresent()) {
			MedicalStore store=optional.get();
			repo.delete(store);
			return store;
		}
		return null;
	}

}
