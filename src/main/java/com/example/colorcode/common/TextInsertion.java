package com.example.colorcode.common;

import com.example.colorcode.parsing.Scope;

public class TextInsertion {
    public int getIndex() {
        return auto_Index;
    }

    public void setIndex(int value) {
        auto_Index = value;
    }

    private int auto_Index;

    public String getText() {
        return auto_Text;
    }

    public void setText(String value) {
        auto_Text = value;
    }

    private String auto_Text;

    public Scope getScope() {
        return auto_Scope;
    }

    public void setScope(Scope value) {
        auto_Scope = value;
    }

    private Scope auto_Scope;
}
