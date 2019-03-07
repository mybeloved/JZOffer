import java.util.Date;

/**
 * @program: JZOffer
 * @description:
 * @author: whx
 * @create: 2018-11-12 11:03
 **/
public class T_Separator {
    char[] sep_candidates = {':', ' ', '-', ',', ';'};
    char sep_service;

    public static void main(String[] args) {
        new T_Separator().runTestCases();
    }

    void runTestCases() {
        //Fixture: bulid a tagList
        if (sep_candidates.length == 0) throw new MyException("异常！");
        final String aTag = "__A_TAG_";
        String tList = "^";
        int i = 0;
        while (i < sep_candidates.length)
            tList += aTag + sep_candidates[i++];
        tList += aTag;
        System.out.println(tList);
        //Run the test
        A_Separator a = new A_Separator();
        a.posts_add("FAKE.URL", "", tList, new Date());
        //Verify the results
        System.out.println(tList.replaceAll(aTag,""));
    }

    /**
     * 自定义异常类(继承运行时异常)
     *
     * @author AlanLee
     * @version 2016/11/26
     */
    public class MyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        /**
         * 错误编码
         */
        private String errorCode;

        /**
         * 消息是否为属性文件中的Key
         */
        private boolean propertiesKey = true;

        /**
         * 构造一个基本异常.
         *
         * @param message 信息描述
         */
        public MyException(String message) {
            super(message);
        }

        /**
         * 构造一个基本异常.
         *
         * @param errorCode 错误编码
         * @param message   信息描述
         */
        public MyException(String errorCode, String message) {
            this(errorCode, message, true);
        }

        /**
         * 构造一个基本异常.
         *
         * @param errorCode 错误编码
         * @param message   信息描述
         */
        public MyException(String errorCode, String message, Throwable cause) {
            this(errorCode, message, cause, true);
        }

        /**
         * 构造一个基本异常.
         *
         * @param errorCode     错误编码
         * @param message       信息描述
         * @param propertiesKey 消息是否为属性文件中的Key
         */
        public MyException(String errorCode, String message, boolean propertiesKey) {
            super(message);
            this.setErrorCode(errorCode);
            this.setPropertiesKey(propertiesKey);
        }

        /**
         * 构造一个基本异常.
         *
         * @param errorCode 错误编码
         * @param message   信息描述
         */
        public MyException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
            super(message, cause);
            this.setErrorCode(errorCode);
            this.setPropertiesKey(propertiesKey);
        }

        /**
         * 构造一个基本异常.
         *
         * @param message 信息描述
         * @param cause   根异常类（可以存入任何异常）
         */
        public MyException(String message, Throwable cause) {
            super(message, cause);
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public boolean isPropertiesKey() {
            return propertiesKey;
        }

        public void setPropertiesKey(boolean propertiesKey) {
            this.propertiesKey = propertiesKey;
        }

    }
}
