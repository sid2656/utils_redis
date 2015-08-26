/**
 * Project Name:redis
 * File Name:RedisProductor.java
 * Package Name:utils.db.redis.main
 * Date:2015年8月26日下午3:08:39
 * Copyright (c) 2015, sid Jenkins All Rights Reserved.
 * 
 *
*/

package utils.db.redis.main;

import utils.db.redis.init.InitRedis;
import utils.utils.DataTypeUtil;

/**
 * ClassName:RedisProductor
 * Date:     2015年8月26日 下午3:08:39 
 * @author   sid
 * @see 	 
 */
public class RedisProductor {

	/**
	 * 
	 * getRedis:(根据配置文件来选择加载方式).
	 *
	 * @author sid
	 * @return
	 */
	public static RedisUtil getRedis(){
		if (DataTypeUtil.isNotEmpty(InitRedis.SERVER_HOSTS)) {
			return RedisShardsUtil.getInstance();
		}else{
			return RedisSingleUtil.getInstance();
		}
	}
}

