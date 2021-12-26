package com.hradmin.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import com.hradmin.exception.UtilsException;

import lombok.extern.log4j.Log4j2;

/**
 * @author Muntaseem Bijapure
 *
 */
@Log4j2
public class ApplicationUtils {

	/**
	 * Converts the Entity class to DTO
	 * 
	 * @param <T>
	 * @param src
	 * @param supplier
	 * @return
	 */
	public static <T> T entityToDto(Object src, Supplier<T> supplier) {
		try {
			T dest = supplier.get();
			BeanUtils.copyProperties(src, dest);
			return dest;
		} catch (BeansException e) {
			log.error("Exception occured from entity to dto" + e);
			throw new UtilsException("EWCOETD-001 : Error while converting entity to dto");
		}
	}

	/**
	 * Checks if string is null or empty
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isObjectNull(Object obj) {
		if (obj instanceof Map<?, ?>) {
			return ((Map<?, ?>) obj).isEmpty();
		}
		if (obj instanceof List<?>) {
			return ((List<?>) obj).isEmpty();
		}
		if (obj instanceof Set<?>) {
			return ((Set<?>) obj).isEmpty();
		}
		return obj == null;
	}

}
