package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @author dkorolev
 *         Date: 4/12/2019
 *         Time: 2:32 PM
 */
public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball 2\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball 2\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball 2\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }


    @Test
    //escape is needed only when we have spaces in name
    public void jsonAssert_strictFalse_noEscape() throws JSONException {
        String expectedResponse = "{id:1,name:\"Ball 2\"}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}