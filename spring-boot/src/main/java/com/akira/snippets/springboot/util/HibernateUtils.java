package com.akira.snippets.springboot.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUtils {
    public static Class<?> getEffectiveClass(Object o) {
        return o instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
    }
}
