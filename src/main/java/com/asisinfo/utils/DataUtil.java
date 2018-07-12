package com.asisinfo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
/**
 * 数据
 */
public class DataUtil {
	/**
	 * 使用md5算法进行加密
	 */
	public static String md5(String src){
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			byte[] bytes = src.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] targ = md.digest(bytes);
			for(byte b: targ){
				buffer.append(chars[(b >> 4) & 0x0F]);
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	/**
	 * 深度复制,复制的整个对象图
	 */
	public static Serializable deeplyCopy(Serializable src){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(src);
			oos.close();
			baos.close();
			
			byte[] bytes = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Serializable copy = (Serializable) ois.readObject();
			ois.close();
			bais.close();
			return copy ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	/**
	 * @param filterBean 用于赋值的实体类
	 * @param targetBean 需要待赋值的实体类
	 * 描述：反射实体类赋值target
	 */
	public static void toBean(Object filterBean,Class targetClass ,Object targetBean) throws Exception{
		Class filterClass = Class.forName(filterBean.getClass().getName());
		Field[] fields1 = filterClass.getDeclaredFields();
		Field[] fields2 = targetClass.getDeclaredFields();
		DataUtil commonUtils = new DataUtil();
		for (Field f1 : fields1) {
			Object value = commonUtils.invokeGetMethod(filterBean ,f1.getName(),null);
			for (Field f2 : fields2) {
				if(f1.getName().equals(f2.getName())){
					Object[] obj = new Object[1];
					obj[0] = value;
					commonUtils.invokeSetMethod(targetBean, f2.getName(), obj);
				}
			}
		}

	}

	/**
	 * 执行某个Field的getField方法
	 * @param filterBean 类
	 * @param fieldName 类的属性名称
	 * @param args 参数，默认为null
	 * @return
	 */
	private Object invokeGetMethod(Object filterBean, String fieldName, Object[] args)
	{
		String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
		Method method = null;
		try
		{
			method = Class.forName(filterBean.getClass().getName()).getDeclaredMethod("get" + methodName);
			return method.invoke(filterBean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 执行某个Field的setField方法
	 * @param targetBean 类
	 * @param fieldName 类的属性名称
	 * @param args 参数，默认为null
	 * @return
	 */
	private Object invokeSetMethod(Object targetBean, String fieldName, Object[] args)
	{
		String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
		Method method = null;
		try
		{
			Class[] parameterTypes = new Class[1];
			Class targetClass = Class.forName(targetBean.getClass().getName());
			Field field = targetClass.getDeclaredField(fieldName);
			parameterTypes[0] = field.getType();
			method = targetClass.getDeclaredMethod("set" + methodName,parameterTypes);
			return method.invoke(targetBean,args);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}


}
