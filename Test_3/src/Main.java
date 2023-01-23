import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;


public class Main {

    public static void main(String[] args) {

        //создаем testPar valuesPar для парсинга
        JSONParser testsPar = new JSONParser();
        JSONParser valuesPar = new JSONParser();
        // читаем "tests.json" "values.json"
        try(FileReader testsR = new FileReader("tests.json");
            FileReader valuesR = new FileReader("values.json")){

            JSONObject testsObj = (JSONObject) testsPar.parse(testsR);
            JSONObject valuesObj = (JSONObject) valuesPar.parse(valuesR);

            JSONArray testsArray = (JSONArray) testsObj.get("tests");
            JSONArray valuesArry = (JSONArray) valuesObj.get("values");
            //рекурсивный перебор всех tests
            recursionFun(testsArray,
                    valuesArry );
            // cсоздание "report.json"
            try (FileWriter out = new FileWriter("report.json")){
                out.write(testsObj.toJSONString());
            }

        } catch ( Exception e) {
            System.out.println("ERROR" + e.toString());
        };
    }

    protected static void recursionFun(JSONArray test, JSONArray valuesArry ) {
        for (Object elTests: test) {
            JSONObject testObjJSON = (JSONObject) elTests;

            for (Object elValues : valuesArry) {
                JSONObject objVal;
                objVal = (JSONObject) elValues;

                Long valuesId = (Long) objVal.get("id");
                String valueValues = (String) objVal.get("value");

                if (valuesId == testObjJSON.get("id")) {
                    testObjJSON.put("value", valueValues);
                    break;
                }

            }
            if (testObjJSON.get("values") != null) {
                // если есть values начинаем перебор на уровне ниже
                JSONArray test2 = (JSONArray) testObjJSON.get("values");
                recursionFun(test2, valuesArry );

            }
        }
    }
}

