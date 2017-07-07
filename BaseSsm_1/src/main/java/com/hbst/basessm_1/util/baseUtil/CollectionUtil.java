package com.hbst.basessm_1.util.baseUtil;

import java.util.Collection;

public class CollectionUtil {
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection){
		return collection == null || collection.isEmpty() || collection.size() <= 0;
	}
}
