package epam.training.task2.solution.service;

import java.util.HashMap;

public class Parser {
    public static String[] getParamsByLine(String line) {
        String[] params = null;
        line = line.replaceAll("\\s+", "");
        String[] arr = line.split(":");
        if (arr.length == 2) {
            String paramsAll = arr[1];
            params = paramsAll.split(",");
        }
        return params;
    }

    public static HashMap<String, String> parseParamsLine(String line) {
        HashMap<String, String> result = new HashMap<String, String>();
        String[] params = getParamsByLine(line);
        if (params != null) {
            for (String keyval : params) {
                String[] inputParams = keyval.split("=");
                if (inputParams.length == 2) {
                    String paramName = String.valueOf(inputParams[0]).toLowerCase();
                    String paramVal = String.valueOf(inputParams[1]);
                    result.put(paramName, paramVal);
                }
            }
        }
        return result;
    }

    public static String getProductName(String line) {
        String productName = "";
        line = line.replaceAll("\\s+", "");
        String[] arr = line.split(":");
        if (arr.length == 2) {
            productName = arr[0].replaceAll("\\s+", "");
        }
        return productName;
    }
}
