package com.example.colorcode.common;

import com.aspose.ms.System.Collections.Generic.IGenericList;
import com.aspose.ms.System.Comparison;

public class ExtensionMethods {
    public static <T> void sortStable(IGenericList<T> list, Comparison<T> comparison) {
        Guard.argNotNull(list, "list");

        int count = list.size();

        for (int j = 1; j < count; j++) {
            T key = list.get_Item(j);

            int i = j - 1;
            for (; i >= 0 && comparison.invoke(list.get_Item(i), key) > 0; i--) {
                list.set_Item(i + 1, list.get_Item(i));
            }

            list.set_Item(i + 1, key);
        }
    }
}
