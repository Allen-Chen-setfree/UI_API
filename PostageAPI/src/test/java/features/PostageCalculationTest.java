package features;

import common.RestAPI;
import common.Utilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.tools4j.spockito.Spockito;
import org.json.JSONObject;

import java.util.ArrayList;


@RunWith(Spockito.class)
public class PostageCalculationTest {

    private RestAPI restAPI;
    private Utilities tool;

    @Before
    public void setup() {
        restAPI = new RestAPI();
        tool = new Utilities();
    }



    @Spockito.Unroll({
            "|     address    |   postcode  |",
            "|================|=============|",
            "|  north sydney  |    2055     |",
            "| east Melbourne |    3002     |",
            "|----------------|-------------|"
    })
    @Spockito.Name("[{row}]: address={address}, postcode={postcode}")
    @Test
    public void postcode_retrieval(final String address, final String postcode) {

        String code = tool.address_to_postcode(address);
        Assert.assertEquals(postcode, code);

    }

    @Spockito.Unroll({
            "|       from      |        to       | length(cm) | width(cm) | height(cm)| weight(kg)| extra_cover($) |",
            "|=================|=================|============|===========|===========|===========|================|",
            "|   north sydney  |  east Melbourne |    30      |     30    |     30    |     5     |      200       |",
            "|  east Melbourne |   north sydney  |    30      |     30    |     30    |     5     |      200       |",
            "|-----------------|-----------------|------------|-----------|-----------|-----------|----------------|"
    })
    @Spockito.Name("[{row}]: from={from}, to={to}, length={length(cm)}, width={width(cm)}, height={height(cm)}, weight={weight(kg)}, extra={extra_cover($)}")
    @Test
    public void calculate_postage_by_postcodes_and_service (String from, String to, String lenghth, String width, String height, String weight, String extra_cover) {
        ArrayList<String> services_code;

        String from_postcode = tool.address_to_postcode(from);
        String to_postcode = tool.address_to_postcode(to);

        String route_parameters = "from_postcode=" + from_postcode + "&to_postcode=" + to_postcode +
                                  "&length=" + lenghth + "&width="+ width + "&height=" + height + "&weight=" + weight;
        String service_route = "postage/parcel/domestic/service.json?"+ route_parameters;
        JSONObject service_resp = new JSONObject(restAPI.GetCall(service_route));
        services_code = tool.fetch_serviceCodes(service_resp);

        for (int i=0; i < services_code.size(); i+=3) {
            String service_code =  services_code.get(i);
            String option_code  = services_code.get(i+1);
            String suboption_code = services_code.get(i+2);
            String calculation_route = "postage/parcel/domestic/calculate.json?"+ route_parameters +
                                       "&service_code=" + service_code + "&option_code=" + option_code +
                                       "&suboption_code=" + (suboption_code.equals("") ? suboption_code : (suboption_code + "&extra_cover=" + extra_cover));

            String cost = (new JSONObject(restAPI.GetCall(calculation_route))).getJSONObject("postage_result").getString("total_cost");

            System.out.println(service_code + " " + option_code + " " + (suboption_code.equals("")?suboption_code:suboption_code+"($"+extra_cover+")"));
            System.out.println("$"+cost);
        }


    }







}