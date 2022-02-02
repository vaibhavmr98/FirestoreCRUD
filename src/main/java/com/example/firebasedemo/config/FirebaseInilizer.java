package com.example.firebasedemo.config;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import lombok.extern.java.Log;

@Log
@Service
public class FirebaseInilizer {

	@PostConstruct
	public void initialize() throws IOException {

		GoogleCredentials googleCredentials = GoogleCredentials.fromStream(FileUtils.openInputStream(
				ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "serviceaccount.json")));
		FirebaseOptions firebaseOptions = FirebaseOptions.builder().setCredentials(googleCredentials).build();
		log.info("====================================");

		FirebaseApp.initializeApp(firebaseOptions);
	}

}
