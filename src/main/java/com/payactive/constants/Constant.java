package com.payactive.constants;

import java.util.Map;

public class Constant {
   public static Map<String, Integer> CARD_HOLDER_FILTER_MAP = Map.of(
            "EmployeeName", 1,
            "EmployeeId", 2,
            "Department", 3,
            "CardStatus", 7,
            "CardType", 8
    );

    public static Map<String, Integer> LOAD_HISTORY_FILTER_MAP = Map.of(
            "EmployeeName", 2,
            "EmployeeId", 3,
            "Department", 4,
            "Last4Digits", 5
    );

 public static Map<String, Integer> CARD_HOLDER_FILTER_MAP_COMPILE = Map.of(
         "EmployeeName", 1,
         "EmployeeId", 2,
         "CardStatus", 7,
         "CardType", 8
 );

    public static final String EMPLOYEE_NAME_FILTER = "EmployeeName";
    public static final String EMPLOYEE_ID_FILTER = "EmployeeId";
    public static final String DEPARTMENT_FILTER = "Department";
    public static final String CARD_STATUS_FILTER = "CardStatus";
    public static final String CARD_TYPE_FILTER = "CardType";
    public static final String LAST_4_DIGITS_FILTER = "Last4Digits";
}
