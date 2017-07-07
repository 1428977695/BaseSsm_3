package com.hbst.basessm_1.util.baseUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class BaiDuApiUtil {

	/**将地理位置转成百度经纬度<p>
	 * @param address	地址<p>
	 * @return 返回结果包含键值对 status、statusStr、lng、lat<p>
	 * 形如：Key = status, Value = 0
		Key = statusStr, Value = 正常
		Key = lng, Value = 114.09373
		Key = lat, Value = 22.554081
	 */
	public static Map<String, String> getLocation(String address) {
		Map<String, String> result = new HashMap<String, String>();
		URL myURL = null;
		URLConnection httpsConn = null;
		InputStreamReader insr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			address = java.net.URLEncoder.encode(address, "UTF-8");
			final String  ak = "IsDHopjTHTsa7y3RUe24eN9vYEG7m9Qn";// 密钥
			String url = String.format("http://api.map.baidu.com/geocoder/v2/?address=%s&output=json&ak=%s", address, ak);
			myURL = new URL(url);
			httpsConn = (URLConnection) myURL.openConnection();// 不需要代理
			if (httpsConn != null) {
				insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
				br = new BufferedReader(insr);
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			}
			//解析返回结果
			JSONObject jsonI = JSONObject.fromObject(sb.toString());
			result.put("status", jsonI.get("status").toString());
			if ("0".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "正常");
				JSONObject jsonII = JSONObject.fromObject(jsonI.get("result"));
				JSONObject jsonIII = JSONObject.fromObject(jsonII.get("location"));
				result.put("lng", jsonIII.get("lng").toString());
				result.put("lat", jsonIII.get("lat").toString());
			} else if ("1".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "服务器内部错误");
			} else if ("2".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "请求参数非法");
			} else if ("3".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "权限校验失败");
			} else if ("4".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "配额校验失败");
			} else if ("5".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "ak不存在或者非法");
			} else if ("101".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "服务禁用");
			} else if ("102".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "不通过白名单或者安全码不对");
			}else if (jsonI.get("status").toString().length()>=3 && jsonI.get("status").toString().indexOf("2")>=0) {
				result.put("statusStr", "无权限");
			}else if (jsonI.get("status").toString().length()>=3 && jsonI.get("status").toString().indexOf("3")>=0) {
				result.put("statusStr", "配额错误");
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (insr != null) {
				try {
					insr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

/**
 * 将百度经纬度转成地理位置<p>
 * @param lat 百度纬度<p>
 * @param lng 百度经度<p>
 * @return 返回结果包含键值对 status、statusStr、city<p>
 * Key = status, Value = 0
Key = statusStr, Value = 正常
Key = city, Value = 北京市
 */
	
	public static Map<String, String> getLngLatByLocation(String lat,String lng) {
		Map<String, String> result = new HashMap<String, String>();
		URL myURL = null;
		URLConnection httpsConn = null;
		InputStreamReader insr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			final String  ak = "IsDHopjTHTsa7y3RUe24eN9vYEG7m9Qn";// 密钥
			String url = String.format("http://api.map.baidu.com/geocoder/v2/?location="+lat+","+lng+"&output=json&pois=1&ak=%s",ak);
			myURL = new URL(url);
			httpsConn = (URLConnection) myURL.openConnection();// 不需要代理
			if (httpsConn != null) {
				insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
				br = new BufferedReader(insr);
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			}
			//解析返回结果
			JSONObject jsonI = JSONObject.fromObject(sb.toString());
			result.put("status", jsonI.get("status").toString());
			if ("0".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "正常");
				JSONObject jsonII = JSONObject.fromObject(jsonI.get("result"));
				JSONObject jsonIII = JSONObject.fromObject(jsonII.get("addressComponent"));
				result.put("city", jsonIII.get("city").toString());
			} else if ("1".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "服务器内部错误");
			} else if ("2".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "请求参数非法");
			} else if ("3".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "权限校验失败");
			} else if ("4".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "配额校验失败");
			} else if ("5".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "ak不存在或者非法");
			} else if ("101".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "服务禁用");
			} else if ("102".equals(jsonI.get("status").toString())) {
				result.put("statusStr", "不通过白名单或者安全码不对");
			}else if (jsonI.get("status").toString().length()>=3 && jsonI.get("status").toString().indexOf("2")>=0) {
				result.put("statusStr", "无权限");
			}else if (jsonI.get("status").toString().length()>=3 && jsonI.get("status").toString().indexOf("3")>=0) {
				result.put("statusStr", "配额错误");
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (insr != null) {
				try {
					insr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Map<String, String> result = BaiDuApiUtil.getLocation("广东省深圳市福田区群星广场A座2216室");
		if(!result.isEmpty()){
			for (Map.Entry<String, String> entry : result.entrySet()) {  
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
			} 
		}else{
			System.out.println("请求失败");
		}
		
		Map<String, String> result2  =BaiDuApiUtil.getLngLatByLocation("22.554083", "114.09373");
		if(!result2.isEmpty()){
			for (Map.Entry<String, String> entry : result2.entrySet()) {  
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
			} 
		}else{
			System.out.println("请求失败");
		}
		
	}
 	
}
