// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.common;


import com.example.colorcode.Scope;

public class TextInsertion
{
    public /*virtual*/ int getIndex(){ return auto_Index; }
    public /*virtual*/ void setIndex(int value){ auto_Index = value; }
    private int auto_Index;
    public /*virtual*/ String getText(){ return auto_Text; }
    public /*virtual*/ void setText(String value){ auto_Text = value; }
    private String auto_Text;
    public /*virtual*/ Scope getScope(){ return auto_Scope; }
    public /*virtual*/ void setScope(Scope value){ auto_Scope = value; }
    private Scope auto_Scope;
}
