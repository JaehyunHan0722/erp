// package json;
//  
//  import java.io.FileWriter;
//  
//  import org.json.simple.JSONArray; import org.json.simple.JSONObject;
//  
//  //json객체를 생성하는 연습
//  
//  {} : JSON객체 - JSONObject [] : JSON배열 - JSONArray
//  
//  public class JSONMaker {
//  
//  @SuppressWarnings("unchecked") public static void main(String[] args) throws
//  Exception{ JSONObject myjson = new JSONObject(); myjson.put("name", "장동건");
//  myjson.put("age", "25");
//  
//  JSONArray subjectlist = new JSONArray(); subjectlist.add("자바");
//  subjectlist.add("하둡"); subjectlist.add("시큐어코딩");
//  
//  //위에서 작성한 JSONArray를 JSONObject에 추가하기 myjson.put("subject",subjectlist);
//  
//  //json파일을 생성 - 파일io FileWriter fw = new FileWriter("src/json/mydata.json");
//  // JSONObject를 텍스트로 변환하여 FileWriter에 전달
//  System.out.println(myjson.toJSONString());
//  
//  fw.write(myjson.toJSONString()); fw.flush(); fw.close();
//  
//  }
//  
// }
