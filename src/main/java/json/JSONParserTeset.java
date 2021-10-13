//
//  package json;
//  
//  import java.io.FileReader;
//  
//  import org.json.simple.JSONArray; import org.json.simple.JSONObject; import
//  org.json.simple.parser.JSONParser;
//  
//  
//  .json파일을 JSONArray나 JSONObject로 변환 JSON파서 -
//  JSONParser(json-simple.jar라이브러리내에서)
//  
//  public class JSONParserTeset { public static void main(String[] args) throws
//  Exception{ //1. JSONParser를 생성 JSONParser parser = new JSONParser(); //2.
//  json파싱하기 JSONObject root = (JSONObject)parser.parse( new
//  FileReader("src/json/mydata.json"));
//  
//  //3. JSONObject에서 데이터 읽기 String name = (String)root.get("name"); String age =
//  (String)root.get("age"); System.out.println("name:"+name);
//  System.out.println("age:"+age);
//  
//  //4. JSONArray에서 데이터읽기 JSONArray subjectlist =
//  (JSONArray)root.get("subject");
//  
//  
//  for (int i = 0; i <subjectlist.size(); i++) { String subject =
//  (String)subjectlist.get(i); System.out.println("Subject:"+subject); }
//  
//  } 
// }
//  
//  
//  
//  
//  
//  
//  
//  
//  
// /