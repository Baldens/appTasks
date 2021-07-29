package denis.appmoney.Controller;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GetData {

    public static String readFileFromAssets(Context context, String filename) {

        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try {
            reader = new BufferedReader(new InputStreamReader(
                    context.getAssets().open(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            Log.e("File", "Файл не был найден: " + e.getMessage());
        } catch (Exception e) {
            Log.e("File", "Файл не был найден: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    Log.e("File", "Файл не был найден: " + e.getMessage());
                }
            }
        }
        return null;
    }








}
