package com.payactive.common;

import com.payactive.models.Credentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCommon {
    public static List<Credentials> credentialsList = new ArrayList<>();

    public static class FILTER {
        public static Map<String, String> CARD_HOLDER_FILTER_DATA = new HashMap<>();

        public static Map<String, String> LOAD_HISTORY_FILTER_DATA = new HashMap<>();
    }
}
