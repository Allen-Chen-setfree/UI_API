package common;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Utilities {

    private RestAPI restAPI = new RestAPI();


    public ArrayList<String> fetch_serviceCodes(JSONObject service_resp) {
        JSONObject service;
        String service_code, option_code;
        ArrayList<String> services_code = new ArrayList<String>();

        JSONArray services = service_resp.getJSONObject("services").getJSONArray("service");
        for(int i=0; i < services.length(); i++) {
            service = services.getJSONObject(i);
            service_code = service.getString("code");
            services_code.add(service_code);
            services_code.add("");
            services_code.add("");
            if (service.has("options")){
                JSONArray options = service.getJSONObject("options").getJSONArray("option");
                JSONObject option;
                for (int j=0; j < options.length(); j++) {
                    option = options.getJSONObject(j);
                    option_code = option.getString("code");
                    services_code.add(service_code);
                    services_code.add(option_code);
                    services_code.add("");
                    if (option.has("suboptions")) {
                        JSONObject suboption = option.getJSONObject("suboptions").getJSONObject("option");
                        services_code.add(service_code);
                        services_code.add(option_code);
                        services_code.add(suboption.getString("code"));

                    }
                }
            }
        }
        return services_code;
    }


    public String address_to_postcode (String address) {
        String route = "postcode/search.json?q=" + address;
        JSONObject jsonObject = new JSONObject(restAPI.GetCall(route));
        return String.valueOf(jsonObject.getJSONObject("localities").getJSONArray("locality").getJSONObject(0).getNumber("postcode"));
    }
}
