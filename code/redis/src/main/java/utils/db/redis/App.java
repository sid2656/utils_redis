package utils.db.redis;

import java.io.Serializable;

import utils.db.redis.main.RedisProductor;
import utils.db.redis.main.RedisUtil;

/**
 * Hello world!
 *
 */
@SuppressWarnings("serial")
public class App implements Serializable{
	class User implements Serializable{
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	public static void main(String[] args) {
		RedisUtil instance = RedisProductor.getRedis();
		
//		for (int i = 100000; i < 102000; i++) {
//			System.out.println(i);
//			instance.save("key"+i, "我就测试一下"+i);
//		}
		System.out.println("insert done!");
		System.out.println(instance.get("key100100"));
//		saveObject(instance);
	}
	private static void saveObject(RedisUtil instance) {
		App a = new App();
		User user = a.new User();
		user.setAge(13);
		user.setName("我叫张三2");
		instance.saveObject("user2", user);
		System.out.println(((App.User)instance.getObject("user2",a.new User())).getAge());
		System.out.println(((App.User)instance.getObject("user2",a.new User())).getName());
	}
}
