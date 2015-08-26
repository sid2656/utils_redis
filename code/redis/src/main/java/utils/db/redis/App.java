package utils.db.redis;

import utils.db.redis.main.RedisProductor;
import utils.db.redis.main.RedisUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		RedisUtil instance = RedisProductor.getRedis();
		
		instance.save("key", "我就测试一下");
		System.out.println(instance.get("key"));
	}
}
