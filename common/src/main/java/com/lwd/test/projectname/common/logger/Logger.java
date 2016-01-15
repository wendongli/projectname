package com.lwd.test.projectname.common.logger;

public interface Logger {

    /**
     * Case insensitive String constant used to retrieve the name of the root
     * logger.
     * 
     * @since 1.3
     */
    public static final String ROOT_LOGGER_NAME = "ROOT";

    /**
     * 日志输出范围标识，用于方便跟踪日志
     * 
     */
    public static abstract class Scope {

        String scope;

        public Scope(String scope) {
            this.scope = scope + " >> ";
        }

    }

    /**
     * HTTP请求范围日志
     * 
     * @author zhipeng.qzp
     */
    public static class HTTP extends Scope {

        /** 请求默认日志标识 */
        public static final HTTP DEFAULT = new HTTP("DEFAULT");

        /** 请求参数错误 */
        public static final HTTP REQUEST_PARAMATER_WRONG = new HTTP("REQUEST_PARAMATER_WRONG");

        /** 请求类型错误 */
        public static final HTTP REQUEST_METHOD_WRONG = new HTTP("REQUEST_METHOD_WRONG");

        /** 请求权限校验日志 */
        public static final HTTP REQUEST_AUTH_PROCESS = new HTTP("REQUEST_AUTH_PROCESS");

        /** 请求回复结果信息 */
        public static final HTTP REQUEST_ANSWER_RESULT = new HTTP("REQUEST_ANSWER_RESULT");

        /** 请求处理请求异常 */
        public static final HTTP REQUEST_PROCESS_EXCEPTION = new HTTP("REQUEST_PROCESS_EXCEPTION");

        public HTTP(String scope) {
            super(HTTP.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * 远程调用日志
     * 
     */
    public static class REMOTE extends Scope {

        /** 默认日志标识 */
        public static final REMOTE DEFAULT = new REMOTE("DEFAULT");

        public REMOTE(String scope) {
            super(REMOTE.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * HSF远程调用日志
     * 
     */
    public static class HSF extends Scope {

        /** HSF默认日志标识 */
        public static final HSF DEFAULT = new HSF("DEFAULT");

        /** 虾米音乐 */
        public static final HSF XIAMI_MUSIC = new HSF("XIAMI_MUSIC");

        /** 弹幕评论提交 */
        public static final HSF BARRAGE_POST_COMMENT = new HSF("BARRAGE_POST_COMMENT");

        /** 添加用户搜索行为 */
        public static final HSF LOG_SEARCH_ACTION = new HSF("LOG_SEARCH_ACTION");

        /** 添加语音语义识别结果 */
        public static final HSF LOG_VOICE_IDENTIFY = new HSF("LOG_VOICE_IDENTIFY");

        public HSF(String scope) {
            super(HSF.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * tair缓存调用处理日志
     * 
     */
    public static class TAIR extends Scope {

        /** TAIR默认日志标识 */
        public static final TAIR DEFAULT = new TAIR("DEFAULT");

        /** TAIR init日志标识 */
        public static final TAIR INIT = new TAIR("INIT");

        /** TAIR get日志标识 */
        public static final TAIR GET = new TAIR("GET");

        /** TAIR put日志标识 */
        public static final TAIR PUT = new TAIR("PUT");

        /** TAIR incr日志标识 */
        public static final TAIR INCR = new TAIR("INCR");

        /** TAIR UPDATE日志标识 */
        public static final TAIR UPDATE = new TAIR("UPDATE");

        /** TAIR DELETE日志标识 */
        public static final TAIR DELETE = new TAIR("DELETE");

        public TAIR(String scope) {
            super(TAIR.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * 业务逻辑日志标识
     * 
     */
    public static class BIZ extends Scope {

        /** 业务逻辑默认日志标识 */
        public static final BIZ DEFAULT = new BIZ("DEFAULT");

        /** 查询聚合首页 */
        public static final BIZ QUERY_INDEX = new BIZ("QUERY_INDEX");

        /** 淘宝商品 */
        public static final BIZ QUERY_ITEM_LIST = new BIZ("QUERY_ITEM_LIST");

        /** 应用列表 */
        public static final BIZ QUERY_APP_LIST = new BIZ("QUERY_APP_LIST");

        /** 音乐列表 */
        public static final BIZ QUERY_MUSIC_LIST = new BIZ("QUERY_MUSIC_LIST");

        /** 节目列表 */
        public static final BIZ QUERY_PROGRAM_LIST = new BIZ("QUERY_PROGRAM_LIST");

        /** 弹幕评论 */
        public static final BIZ BARRAGE_COMMENT = new BIZ("BARRAGE_COMMENT");

        /** 搜索行为日志 */
        public static final BIZ LOG_SEARCH_ACTION = new BIZ("LOG_SEARCH_ACTION");

        /** 语音识别日志 */
        public static final BIZ LOG_VOICE_IDENTIFY = new BIZ("LOG_VOICE_IDENTIFY");

        /** 帮助文档列表 */
        public static final BIZ QUERY_HELP_DOC_LIST = new BIZ("QUERY_HELP_DOC_LIST");

        public BIZ(String scope) {
            super(BIZ.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * 接口日志
     * 
     */
    public static class API extends Scope {

        /** 业务逻辑默认日志标识 */
        public static final API DEFAULT = new API("DEFAULT");

        /** 超时日志 */
        public static final API TIMEOUT = new API("TIMEOUT");

        /** 支付日志 */
        public static final API PAY = new API("PAY");

        /** 接口日志 */
        public static final API OPENAPI = new API("OPENAPI");

        /** 回调处理接口日志 */
        public static final API NOTIFY = new API("NOTIFY");

        public API(String scope) {
            super(API.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * controller action层日常
     * 
     */
    public static class ACTION extends Scope {

        public static final ACTION DEFAULT = new ACTION("DEFAULT");

        public static final ACTION LOGIN = new ACTION("LOGIN");

        public ACTION(String scope) {
            super(ACTION.class.getSimpleName() + "_" + scope);
        }

    }

    /**
     * 数据库处理层日志
     * 
     */
    public static class DAL extends Scope {

        /** 数据库处理层默认日志标识 */
        public static final DAL DEFAULT = new DAL("DEFAULT");

        public DAL(String scope) {
            super(DAL.class.getSimpleName() + "_" + scope);
        }

    }

    public void debug(Scope scope, String message);

    public void debug(Scope scope, String pattern, Object... paras);

    public void info(String message);

    public void info(Scope scope, String message);

    public void info(Scope scope, String pattern, Object... paras);

    public void warn(Scope scope, String message);

    public void warn(Scope scope, String pattern, Object... paras);

    public void warn(Scope scope, Throwable e, String pattern, Object... paras);

    public void warn(Scope scope, Throwable e, String message);

    public void error(Scope scope, String message);

    public void error(Scope scope, String pattern, Object... paras);

    public void error(Scope scope, Throwable e, String pattern, Object... paras);

    public void error(Scope scope, Throwable e, String message);

}
