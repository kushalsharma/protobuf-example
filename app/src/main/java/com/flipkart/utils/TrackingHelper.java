/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2016 Flipkart Internet Pvt. Ltd.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.flipkart.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class TrackingHelper {

    public static JSONObject getProductPageViewEvent(String listingId, String productId, String requestId) {
        try {
            if (requestId == null) requestId = "";
            JSONObject jsonEvent = new JSONObject();
            jsonEvent.put("event", "PRODUCT_VIEW");

            JSONArray jsonArray = new JSONArray();
            for(int idx = 0 ; idx < 5; idx++)
            {
                JSONObject dataJson = new JSONObject();
                dataJson.put("listingId", listingId);
                dataJson.put("productId", productId);
                dataJson.put("requestId", requestId);
                dataJson.put("timestamp", System.currentTimeMillis());
                jsonArray.put(dataJson);
            }


            jsonEvent.put("data", jsonArray);
            return jsonEvent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
