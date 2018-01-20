package Bean;

/**
 * Created by sendo on 2017/2/7.
 */
public class Enumssss {



    public enum LoginStatus {
        RUNNING("4");
        // 定义私有变量
        private String value;

        private LoginStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
