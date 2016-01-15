package com.lwd.test.projectname.biz.bo;

import com.lwd.test.projectname.client.common.AbstractEntity;

/**
 * 
 * @author wendong.lwd
 * 
 */
public final class CacheKeyBo extends AbstractEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -373486439275132732L;

    /**
     * 缓存的key和过期有效时间结构体
     * 
     */
    public final static class KeyAndExpire extends AbstractEntity {

        /**
         * 
         */
        private static final long serialVersionUID = -213856085048723115L;

        /** 缓存key */
        public String key;

        /** 缓存有效时间，单位：秒 */
        public int expire;

        public KeyAndExpire(String key, int expire) {
            this.key = key;
            this.expire = expire;
        }

        /**
         * 动态追加参数生成key
         * 
         * @param appendKey
         * @return {@link #key} + appendKey
         */
        public String append(Object appendKey) {
            return new StringBuilder(key).append(appendKey).toString();
        }

        public String toString() {
            return key;
        }
    }

}
