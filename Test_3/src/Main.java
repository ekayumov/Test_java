import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;


public class Main {

    public static void main(String[] args) {

        //создаем testPar для парсинга
        JSONParser testsPar = new JSONParser();
        JSONParser valuesPar = new JSONParser();
        // читаем "tests.json"
        try(FileReader testsR = new FileReader("tests.json");
        FileReader valuesR = new FileReader("values.json")){

           JSONObject testsObj = (JSONObject) testsPar.parse(testsR);
           JSONObject valuesObj = (JSONObject) valuesPar.parse(valuesR);

           JSONArray testsarray = (JSONArray) testsObj.get("tests");
           JSONArray valuesarry = (JSONArray) valuesObj.get("values");
            //рекурсивный перебор всех tests
            recursionFun(testsarray, valuesarry );

            try (FileWriter out = new FileWriter("report.json")){
                out.write(testsObj.toJSONString());
            }

        } catch ( Exception e) {
            System.out.println("ERROR" + e.toString());
        };
    }

    protected static void recursionFun(JSONArray test, JSONArray valuesarry ) {
        for (Object elTests: test) {
            JSONObject testObjJSON = (JSONObject) elTests;

            for (Object elValues : valuesarry) {
                JSONObject obval = (JSONObject) elValues;

                Long valuesId = (Long) obval.get("id");
                String valueValues = (String) obval.get("value");

                if (valuesId == testObjJSON.get("id")) {
                    testObjJSON.put("value", valueValues);
                    break;
                }

            }
            if (testObjJSON.get("values") != null) {
                // если есть values начинаем перебор на уровне ниже
                JSONArray test2 = (JSONArray) testObjJSON.get("values");
                recursionFun(test2, valuesarry );

            }
        }
    }
}



