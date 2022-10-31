// Copyright (c) Microsoft Corporation.  All rights reserved.

package com.example.colorcode.compilation;

//import com.aspose.ms.System.Text.RegularExpressions.Regex;
//import com.aspose.ms.System.Collections.Generic.IGenericList;


import com.aspose.note.system.collections.Generic.IGenericList;
import com.example.colorcode.common.Guard;


public class CompiledLanguage
{

	//JAVA-added public wrapper for internalized ctor
	public CompiledLanguage(String id,
                            String name,java.util.regex.Pattern regex,
                            IGenericList<String> captures)
	{
		this(id, name, Regex.fromJava(regex), captures);
	}

	//JAVA: ctor is internalized
	CompiledLanguage(String id,
                            String name,
                            Regex regex,IGenericList<String> captures)
    {
        Guard.argNotNullAndNotEmpty(id, "id");
        Guard.argNotNullAndNotEmpty(name, "name");
        Guard.argNotNull(regex, "regex");
        Guard.argNotNullAndNotEmpty(captures, "captures");
        
        setId(id);
        setName(name);
        setRegexInternal(regex);
        setCaptures(captures);
    }

    public final IGenericList<String> getCaptures(){ return auto_Captures; }
    public final void setCaptures(IGenericList<String> value){ auto_Captures = value; }
    private IGenericList<String> auto_Captures;
    public final String getId(){ return auto_Id; }
    public final void setId(String value){ auto_Id = value; }
    private String auto_Id;
    public final String getName(){ return auto_Name; }
    public final void setName(String value){ auto_Name = value; }
    private String auto_Name;
	//JAVA-added public wrapper for internalized property accessor
	public final java.util.regex.Pattern getRegex() { return Regex.toJava(getRegexInternal()); }
    //JAVA: property accessor is internalized
	Regex getRegexInternal(){ return auto_Regex; }
	//JAVA-added public wrapper for internalized property accessor
	public final void setRegex(java.util.regex.Pattern value) { setRegexInternal(Regex.fromJava(value)); }
    //JAVA: property accessor is internalized
	void setRegexInternal(Regex value){ auto_Regex = value; }
    private Regex auto_Regex;

    public /*override*/ String toString()
    {
        return getName();
    }
}
