package com.example.hs.hardware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hs.hardware.Model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@RestController
public class UserController {
    @PostMapping("/user")
	public User save(User user) {
    	Firestore fireStoreDatabase = FirestoreClient.getFirestore();
    	String userId = fireStoreDatabase.collection("User").document().getId().toString();
    	user.setId(userId);
    	//String id = ""+System.currentTimeMillis();
    	fireStoreDatabase.collection("User").document(userId).set(user); 
    	
    	DocumentReference documentRef = fireStoreDatabase.collection("User").document(userId);
    			
    	CollectionReference subCollection = documentRef.collection("friend-list"); 		
    	HashMap<String,String> hm = new HashMap<>();
    	hm.put("f1", "Sonu");
    	hm.put("f2", "Monu");
    	hm.put("f3", "Tonu");
    	hm.put("f4", "Nanu");
    	hm.put("f5", "Anu");
    	subCollection.document().set(hm);
    	return user;
    }
    
    public User getUserById(int id) {
    	return null;
    }
   
    @GetMapping("/users")
    public List<User> getUserList() throws InterruptedException, ExecutionException{
    	List<User> userList = new ArrayList();
    	Firestore fireStoreDatabase = FirestoreClient.getFirestore();
    	ApiFuture<QuerySnapshot> apiFuture = fireStoreDatabase.collection("User").get();
    	QuerySnapshot querySnapshot = apiFuture.get();
    	List<QueryDocumentSnapshot> documentSnapshotList = querySnapshot.getDocuments(); 
    	for(QueryDocumentSnapshot document : documentSnapshotList) {
    		User user = document.toObject(User.class);
    		userList.add(user);
    	}
    	return userList;
    }
    
    public User updateUser(User user) {
    
    	return null;
    }
}
