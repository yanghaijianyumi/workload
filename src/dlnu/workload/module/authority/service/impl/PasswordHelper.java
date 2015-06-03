package dlnu.workload.module.authority.service.impl;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import dlnu.workload.module.common.model.User;

/**
 * 密码生成盐工具
 * 
 * @author weber 2015.4.19
 *
 */
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void setRandomNumberGenerator(
			RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public void encryptPassword(User user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();

		user.setPassword(newPassword);
	}
}