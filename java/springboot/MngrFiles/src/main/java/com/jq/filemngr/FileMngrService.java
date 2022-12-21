package com.jq.filemngr;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class FileMngrService {

	@Autowired
	AmazonS3 s3;

	private final String BUCKET_NAME = "BUCKET_NAME";

	public void upload(String fileName, InputStream inputStream) throws AmazonServiceException {
		s3.putObject(BUCKET_NAME, fileName, inputStream, new ObjectMetadata());
	}

	public String getContent(String file) throws Exception {
		byte[] contentBytes = getContentBytes(file);

		InputStream io = new ByteArrayInputStream(contentBytes);
		Reader reader = new BufferedReader(new InputStreamReader(io));

		StringBuilder sb = new StringBuilder();

		int c = 0;
		while ((c = reader.read()) != -1) {
			sb.append((char) c);
		}
		return sb.toString();
	}

	private byte[] getContentBytes(String file) throws Exception {

		S3Object bucketObject = s3.getObject(BUCKET_NAME, file);
		S3ObjectInputStream contentObject = bucketObject.getObjectContent();
		return IOUtils.toByteArray(contentObject);
	}
}