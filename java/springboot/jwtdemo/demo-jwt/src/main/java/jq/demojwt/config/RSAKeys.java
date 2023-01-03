package jq.demojwt.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rsa")
public class RSAKeys {
	private RSAPrivateKey privateKey;
	private RSAPublicKey publicKey;

	public RSAPrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public RSAPublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(RSAPublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public RSAKeys() {

	}

	public RSAKeys(RSAPrivateKey privateKey, RSAPublicKey publicKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

}
