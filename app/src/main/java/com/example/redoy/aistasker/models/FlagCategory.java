package com.example.redoy.aistasker.models;

import com.example.redoy.aistasker.R;

public enum FlagCategory {
    SPAM(R.string.flag_type_spam, "spam"),
    RUDE(R.string.flag_type_rude_or_offensive, "rude"),
    BREACH(R.string.flag_type_breach_of_marketplace_rules, "breach_of_rules"),
    OTHER(R.string.flag_type_other, "other");
    
    private String jsonKey;
    private int titleId;

    private FlagCategory(int i, String str) {
        this.titleId = i;
        this.jsonKey = str;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public String getJsonKey() {
        return this.jsonKey;
    }
}
