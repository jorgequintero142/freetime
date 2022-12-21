package readS3;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

/**
 * this class is used for expose as a Lambda function
 * to-do: add some validations and a better management
 * of the exceptions
 *  
 * @author jorgequintero142@gmail.com
 *
 */
public class ReaderS3 {

	private AmazonS3 s3;

	/**
	 * this method receives a parameter with the name of the file to read from S3
	 * @param file
	 * @return
	 */
	public String handler(String file) {
		s3 = this.getS3();
		try {

			byte[] contentBytes = getContentBytes(file);

			InputStream io = new ByteArrayInputStream(contentBytes);
			Reader reader = new BufferedReader(new InputStreamReader(io));

			StringBuilder sb = new StringBuilder();
			sb.append("Contenido: ");
			int c = 0;
			while ((c = reader.read()) != -1) {
				sb.append((char) c);
			}
			return sb.toString();

		} catch (Exception e) {
			return "Error :" + e.getMessage();
		}
	}

	/**
	 * With the name of the file, gets the object from S3
	 * and extracts it the bytes
	 * @param file
	 * @return an array of bytes from file in S3
	 * @throws Exception
	 */
	private byte[] getContentBytes(String file) throws Exception {

		S3Object bucketObject = s3.getObject("YOUR_BUCKET_NAME", file);
		S3ObjectInputStream contentObject = bucketObject.getObjectContent();
		return IOUtils.toByteArray(contentObject);
	}

	/**
	 * get an AmazonS3 intance usign credetials
	 * to-do: try using context to avoid use of credentials. 
	 * in the current way it looks like a type of boilerplate code
	 * @return
	 */
	private AmazonS3 getS3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials("accessKey",
				"secretKey");
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}
}
