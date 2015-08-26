/**
 * Project Name:mongo
 * File Name:MongoCondition.java
 * Package Name:com.hdsx.taxi.mongo
 * Date:2014年12月2日上午9:01:10
 * Copyright (c) 2014, sid Jenkins All Rights Reserved.
 * 
 *
*/

package utils.db.redis.main;

/**
 * ClassName:MongoCondition
 * Date:     2014年12月2日 上午9:01:10 
 * @author   sid
 * @see 	 
 */
public enum RedisCondition {

	OR("or", "$or"), 
	IN("in", "$in"), 
	GT(">", "$gt"), 
	LT("<", "$lt"), 
	GTE(">=", "$gte"),
	LTE("<=", "$lte"),
	NE("!=、<>", "$ne"),
	NIN("not in", "$nin"),
	ALL("all", "$all"),
	NOT("反匹配(1.3.3及以上版本)", "$not"),  
	REGEX("like", "$regex");
    // 成员变量  
    private String name;  
    private String val;
    // 构造方法  
    private RedisCondition(String name, String val) {
		this.name = name;
		this.val = val;
	}
    // get set 方法  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public static RedisCondition getByName(String name) {
        for (RedisCondition c : RedisCondition.values()) {  
            if (c.getName().equals(name)) {  
                return c;  
            }  
        }  
        return null;  
	}
	public static RedisCondition getByVal(String val) {
        for (RedisCondition c : RedisCondition.values()) {  
            if (c.getVal().equals(val)) {  
                return c;  
            }  
        }  
        return null;  
	}  
}

