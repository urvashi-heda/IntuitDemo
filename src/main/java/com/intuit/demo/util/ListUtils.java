package com.intuit.demo.util;

import java.util.Collection;

/**
 * Collections utility class
 * @author Urvashi Heda
 */
public class ListUtils {

    /**
     * @param collection to be checked for content
     * @return is the collection empty or not
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }
}
