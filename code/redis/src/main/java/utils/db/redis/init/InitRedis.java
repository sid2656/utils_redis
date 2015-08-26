package utils.db.redis.init;

import utils.utils.PropertiesUtil;



public class InitRedis {
	
	/**
	 * 系统根目录
	 */
	public static final String ROOT_PATH = System.getProperty("user.dir");
	
	/**
	 * 配置文件地址
	 */
	private static final String CONFIG="db.properties";
	public static final String CHARSET="utf-8";
	public static final String SERVER_HOST =PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.ip");
	public static final int SERVER_PORT = Integer.parseInt(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.port"));
	public static final String SERVER_HOSTS =PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.ips");
	public static final String SERVER_PORTS = PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.ports");
	public static final String DATABASE_INFO =PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("database.info");
	
	/**
	 * 配置redis连接池
	 */
	public static final int REDIS_TOTAL = Integer.parseInt(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.pool.maxtotal"));
	public static final int REDIS_IDLE = Integer.parseInt(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.pool.maxIdle"));
	public static final long REDIS_WAIT = Long.parseLong(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.pool.maxWait"));
	public static final boolean REDIS_BORROW = Boolean.parseBoolean(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.pool.testOnBorrow"));
	public static final boolean REDIS_RETURN = Boolean.parseBoolean(PropertiesUtil.getProperties(CONFIG, CHARSET).getProperty("redis.pool.testOnReturn"));
	
}
