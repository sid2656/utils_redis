/**
 * Project Name:redis
 * File Name:RedisUtil.java
 * Package Name:utils.db.redis.main
 * Date:2015年8月26日下午2:55:20
 * Copyright (c) 2015, sid Jenkins All Rights Reserved.
 * 
 *
*/

package utils.db.redis.main;

/**
 * ClassName:RedisUtil
 * Reason:	 抽象类；作为分片和单机的父类
 * Date:     2015年8月26日 下午2:55:20 
 * @author   sid
 * @see 	 
 */
public abstract class RedisUtil {

	/**
	 * 
	 * save:(在指定表集合中). 
	 *
	 * @author sid
	 * @param key
	 * @param value
	 * @return
	 */
	public abstract void save(String key, String value);


	/**
	 * 
	 * remove:(清除对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public abstract void remove(String key);

	/**
	 * 
	 * get:(获取对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public abstract String get(String key);

	/**
	 * 
	 * setex(写入缓存)
	 * @param key 
	 * @param seconds 过期时间 单位秒
	 * @param value
	 * @exception
	 * @since  1.0.0
	 */
	public abstract void setex(String key, int seconds,String value);

	/**
	 * 
	 * saveObject:(在指定表集合中). 
	 *
	 * @author sid
	 * @param key
	 * @param value
	 * @return
	 */
	public abstract <T> void saveObject(String key, T value);

	/**
	 * 
	 * remove:(清除对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public abstract void removeObject(String key);

	/**
	 * 
	 * get:(获取对象).
	 *
	 * @author sid
	 * @param databasename
	 * @param collectionname
	 * @param map
	 * @param bean
	 * @return
	 */
	public abstract <T> T getObject(String key,T object);
}

