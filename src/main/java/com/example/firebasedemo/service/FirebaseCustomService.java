package com.example.firebasedemo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.firebasedemo.pojo.SalesVo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseCustomService {

	public static final String COL_NAME = "sales";

	// Create Sales
	public String saveSalesDetails(SalesVo salesVo) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
				.document(String.valueOf(salesVo.getSalesid())).set(salesVo);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	// get Sales
	public SalesVo getSalesDetails(long salesid) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(String.valueOf(salesid));
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		SalesVo salesVo = null;

		if (document.exists()) {
			salesVo = document.toObject(SalesVo.class);
			return salesVo;
		} else {
			return null;
		}
	}

	public String updateSalesDetails(SalesVo salesVo) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME)
				.document(String.valueOf(salesVo.getSalesid())).set(salesVo);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}

	public String deleteSales(long salesId) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(String.valueOf(salesId))
				.delete();
		return "Document with Sales ID " + salesId + " has been deleted";
	}

}
