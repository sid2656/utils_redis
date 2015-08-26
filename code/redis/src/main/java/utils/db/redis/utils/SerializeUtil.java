/**
 * Project Name:redis
 * File Name:s.java
 * Package Name:utils.db.redis.utils
 * Date:2015年8月26日上午11:52:56
 * Copyright (c) 2015, sid Jenkins All Rights Reserved.
 * 
 *
*/

package utils.db.redis.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ClassName:SerializeUtil Date: 2015年8月26日 上午11:52:56
 * 
 * @author sid
 * @see
 */

public class SerializeUtil {

	/**
	 * 
	 * serialize:(序列化对象).
	 *
	 * @author sid
	 * @param object
	 * @return
	 */
	public static <T> byte[] serialize(T object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * unserialize:(反序列化).
	 *
	 * @author sid
	 * @param bytes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (T)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}