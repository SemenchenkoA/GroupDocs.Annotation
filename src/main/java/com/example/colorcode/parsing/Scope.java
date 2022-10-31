// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.parsing;

//import com.aspose.ms.System.Collections.Generic.List;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.InvalidOperationException;


import com.aspose.note.system.collections.Generic.IGenericList;
import com.aspose.note.system.collections.Generic.List;
import com.aspose.note.system.exceptions.InvalidOperationException;
import com.example.colorcode.common.Guard;

public class Scope
{
    public Scope(String name,
                 int index,
                 int length)
    {
        Guard.argNotNullAndNotEmpty(name, "name");
        
        setName(name);
        setIndex(index);
        setLength(length);
        setChildren(new List<Scope>());
    }

    public final IGenericList<Scope> getChildren(){ return auto_Children; }
    public final void setChildren(IGenericList<Scope> value){ auto_Children = value; }
    private IGenericList<Scope> auto_Children;
    public final int getIndex(){ return auto_Index; }
    public final void setIndex(int value){ auto_Index = value; }
    private int auto_Index;
    public final int getLength(){ return auto_Length; }
    public final void setLength(int value){ auto_Length = value; }
    private int auto_Length;
    public final Scope getParent(){ return auto_Parent; }
    public final void setParent(Scope value){ auto_Parent = value; }
    private Scope auto_Parent;
    public final String getName(){ return auto_Name; }
    public final void setName(String value){ auto_Name = value; }
    private String auto_Name;

    public final void addChild(Scope childScope)
    {
        if (childScope.getParent() != null)
            throw new InvalidOperationException("The child scope already has a parent.");

        childScope.setParent(this);

        getChildren().addItem(childScope);
    }
}
