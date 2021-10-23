package com.aku.projectassignment.data.local;

import androidx.annotation.NonNull;

import com.aku.projectassignment.data.model.Province;

import java.util.ArrayList;

public class Constants {

    @NonNull
    public static String province[] = {"Select Province",
            "Sindh","Punjab", "Khyber Pakhtunkhwa","Baluchistan"};

    @NonNull
    public static String district[] = {"Select District", "Karachi","Lahore"};

    @NonNull
    public static String tehsil[] = {"Select Tehsil",
            "Haidri",
            "Sakhi Hassan",
            "Buffer Zone",
            "Ayesha Manzil",
            "Azizabad",
            "Karimabad",
            "Liaqat Abad",
            "Paposh Nagar",
            "Nazimabad",
            "Ravi",
            "Shalamar",
            "Wahga",
            "Aziz Bhatti",
            "Data Gunj Buksh",
            "Gulberg",
            "Samanabad",
            "Iqbal",
            "Nishtar",
    };

    @NonNull
    public static String education[] = {"What is your education",
            "No Education",
            "Primary School",
            "Secondary School",
            "Matric/O Levels",
            "Intermediate/A-Levels",
            "Bachelor's Degree",
            "Master's Degree",
            "Ph.D. or higher",
    };

    @NonNull
    public static String gender[] = {"Gender -- All",
            "Male",
            "Female",
    };

    @NonNull
    public static String martialStatus[] = {"Marital Status --  All",
            "Unmarried",
            "Married",
            "Divorced",
            "Widow",

    };

    @NonNull
    public static String occupation[] = {"What is you occupation",
            "Student",
            "Housewife",
            "Trader",
            "Business",
            "Self-employed",
            "Formal employee",
            "NGO employee",
            "Seasonal worker",
            "Unemployed",
            "Retired",
    };

    @NonNull
    public static int tehsil_codes[] = {0, 11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29};


}
