/**
 * Project Name:main
 * File Name:MongodbCollectionManagerUtil.java
 * Package Name:com.hdsx.taxi.driver.cq.Collection
 * Date:2014年4月9日下午12:49:55
 * Copyright (c) 2014, sid Jenkins All Rights Reserved.
 * 
 *
*/

package utils.db.redis.main;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import utils.db.redis.init.InitRedis;
import utils.db.redis.utils.SerializeUtil;

/**
 * 
 * ClassName: RedisUtil date: 2015年8月26日 上午10:47:58
 *
 * @author sid
 */
class RedisSingleUtil extends RedisUtil {

	private static JedisPool pool = null;

	private volatile static RedisSingleUtil singleton = null;

	public static RedisSingleUtil getInstance() {
		if (singleton == null) {
			synchronized (RedisSingleUtil.class) {
				if (singleton == null) {
					singleton = new RedisSingleUtil();
				}
			}
			singleton = new RedisSingleUtil();
		}
		return singleton;
	}

	private RedisSingleUtil() {
		initPools();
	}

	private void initPools(){
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(InitRedis.REDIS_TOTAL);
			config.setMaxIdle(InitRedis.REDIS_IDLE);
			config.setMaxWaitMillis(InitRedis.REDIS_WAIT);
			config.setTestOnBorrow(InitRedis.REDIS_BORROW);
			config.setTestOnReturn(InitRedis.REDIS_RETURN);
			pool = new JedisPool(config, InitRedis.SERVER_HOST, InitRedis.SERVER_PORT);
		}
	}

	/**
	 * 
	 * save:(在指定表集合中). 
	 *
	 * @author sid
	 * @param key
	 * @param value
	 * @return
	 */
	public void save(String key, String value) {
		Jedis jedis = pool.getResource();
		try{
			// 存数据
			jedis.set(key, value);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
	}


	/**
	 * 
	 * remove:(清除对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public void remove(String key) {
		Jedis jedis = pool.getResource();
		try{
			// 删数据
			jedis.del(key);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
	}

	/**
	 * 
	 * get:(获取对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public String get(String key) {
		Jedis jedis = pool.getResource();
		try{
			// 取数据
			return jedis.get(key);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
		return null;
	}

	/**
	 * 
	 * setex(写入缓存)
	 * @param key 
	 * @param seconds 过期时间 单位秒
	 * @param value
	 * @exception
	 * @since  1.0.0
	 */
	public void setex(String key, int seconds,String value){
		Jedis jedis = null;
		try{
			jedis = pool.getResource();
			jedis.setex(key.getBytes(InitRedis.CHARSET), seconds, value.getBytes(InitRedis.CHARSET));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
	}

	/**
	 * 
	 * saveObject:(在指定表集合中). 
	 *
	 * @author sid
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> void saveObject(String key, T value) {
		Jedis jedis = pool.getResource();
		try{
			jedis.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
	}

	/**
	 * 
	 * remove:(清除对象).
	 *
	 * @author sid
	 * @param key
	 * @return
	 */
	public void removeObject(String key) {
		Jedis jedis = pool.getResource();
		try{
			jedis.del(SerializeUtil.serialize(key));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
	}

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
	public <T> T getObject(String key,T object) {
		Jedis jedis = pool.getResource();
		try{
			// 取数据
			byte[] bs = jedis.get(SerializeUtil.serialize(key));
			object = SerializeUtil.unserialize(bs);
			return object;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pool.returnResource(jedis);
		}
		return null;
	}
}
