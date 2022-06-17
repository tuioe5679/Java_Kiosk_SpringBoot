package httpAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

public class RestApi {
	
	private static HttpURLConnection myConnet; 
	private final static String localhostURL = "http://localhost:8080/";
	private static String index ="";
	private static BufferedReader br;
	private static StringBuilder sb;
	private static BufferedWriter bw;
	private static String line;
	
	public static String MemberDAO(String url,Vector<String> memberV) {
		try {
			URL SpringApi = new URL(localhostURL+url);
			String url_spilt[] = url.split("/");
			String Method = null;
			
			Method = setMethod(url_spilt[1],SpringApi);
			
			switch(Method) {
				case "GET":
					br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
					sb = new StringBuilder();
					line = null;
					
					while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
						sb.append(line);
					}
					JSONArray array = new JSONArray(sb.toString());
					for(int i=0;i<array.length();i++) {
						JSONObject obj = array.getJSONObject(i); // json���� ���� (������ȭ)
						index = (String) obj.get("id") + "," + (String) obj.get("pwd");
					}
					break;
				case "POST":
					JSONObject obj = new JSONObject();
					
					obj.put("id", memberV.get(0));
					obj.put("pwd", memberV.get(1));
					obj.put("name", memberV.get(2));
					obj.put("totalmoney",memberV.get(3));
					
					bw = new BufferedWriter(new OutputStreamWriter(myConnet.getOutputStream(),"UTF-8"));
					bw.write(obj.toString());
					bw.flush();
					bw.close();
					
					br = new BufferedReader(new InputStreamReader(myConnet.getInputStream()));
					sb = new StringBuilder();
					line = null;
					
					while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
						sb.append(line);
					}
					break;
				case "DELETE":
					br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
					break;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return index;
	}
	
	public static JSONArray productDAO(String url,Vector<String> data) {
		JSONArray array = null;
		try {
			URL SpringApi = new URL(localhostURL+url);
			String url_spilt[] = url.split("/");
			String Method;
			
			System.out.println(url_spilt[1]);
			Method = setMethod(url_spilt[1],SpringApi);
			
			switch(Method) {
			case "GET":
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
				sb = new StringBuilder();
				line = null;
				
				while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
					sb.append(line);
				}
				array = new JSONArray(sb.toString());
				break;
			case "POST":
				JSONObject obj = new JSONObject();
				
				obj.put("id", data.get(0));
				obj.put("name", data.get(1));
				obj.put("price", data.get(2));
				obj.put("image",data.get(3));
				
				bw = new BufferedWriter(new OutputStreamWriter(myConnet.getOutputStream(),"UTF-8"));
				bw.write(obj.toString());
				bw.flush();
				bw.close();
				
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream()));
				sb = new StringBuilder();
				line = null;
				
				while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
					sb.append(line);
				}
				index = sb.toString();
				break;
			case "DELETE":
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public static JSONArray ordersDAO(String url,Vector<String> data) {
		JSONArray array = null;
		try {
			URL SpringApi = new URL(localhostURL+url);
			String url_spilt[] = url.split("/");
			String Method;
			
			Method = setMethod(url_spilt[0],SpringApi);
			
			switch(Method) {
			case "GET":
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
				sb = new StringBuilder();
				line = null;
				
				while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
					sb.append(line);
				}
				array = new JSONArray(sb.toString());
				break;
			case "POST":
				JSONObject obj = new JSONObject();
				
				obj.put("ordernum",data.get(0));
				obj.put("name", data.get(1));
				obj.put("price", data.get(2));
				obj.put("count",data.get(3));
				
				bw = new BufferedWriter(new OutputStreamWriter(myConnet.getOutputStream(),"UTF-8"));
				bw.write(obj.toString());
				bw.flush();
				bw.close();
				
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream()));
				sb = new StringBuilder();
				line = null;
				
				while((line = br.readLine()) != null) { // ���� �� ���� �� ���� �ݺ�
					sb.append(line);
				}
				index = sb.toString();
				break;
			case "DELETE":
				br = new BufferedReader(new InputStreamReader(myConnet.getInputStream(),"UTF-8"));
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public static String setMethod(String Method,URL SpringApi) throws IOException {
		
		String method = "";
		switch(Method) {
		case "all":
			method = "GET";
			break;
		case "post":
			method = "POST";
			break;
		case "delete":
			method = "DELETE";
			break;
		default:
			method = "GET";
			break;
		}
		
		myConnet = (HttpURLConnection) SpringApi.openConnection();
		myConnet.setRequestMethod(method);
		myConnet.setRequestProperty("Content-Type", "application/json"); // header Content-Type ����
		myConnet.setRequestProperty("auth", "myAuth"); // header�� auth ����
		myConnet.setDoOutput(true); // �����κ��� �޴� ���� �ִٸ� true
		myConnet.setDoInput(true);
		return method;
	}
}
