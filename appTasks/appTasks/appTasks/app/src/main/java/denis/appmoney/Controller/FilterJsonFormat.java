package denis.appmoney.Controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FilterJsonFormat {
    public void filterJson (String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);

        for(int i = 0; i<jsonArray.length(); i++){
            JSONObject object = (JSONObject) jsonArray.get(i);
//            List<> arrayList = new ArrayList<>();

        }

    }
}
