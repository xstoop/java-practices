package march3;

/**
 * @author xstoop
 */
public class JavaBasicDataType {
    public static void main(String[] args) {
        JavaBasicDataType javaBasicDataType = new JavaBasicDataType();
        javaBasicDataType.charAndString();
        javaBasicDataType.array();
    }

    private void charAndString() {
        /** 字符 **/
        // 字符是值类型；字符使用单引号；java的字符总是使用unicode表示字符，因此大小是2个字节
        char ch = 'A';
        // 直接将字符赋值给int，可以获取字符的unicode编码
        int chInt = ch;
        System.out.println(chInt);
        // 可以使用转义符\\u+unicode编码表示一个字符
        char ch1 = '\u0041';
        char ch2 = '\u4e2d';
        System.out.println(ch1);
        System.out.println(ch2);

        // 字符串
        // 字符串与字符不同，字符串是引用类型，使用双引号
        String s = "";
        String s2 = "seqasdasdas字符串";
        // 使用转义符转义双引号
        String s3 = "asdas\"asdaas";
        // 使用unicode编码
        String s4 = "ABC \u4e2d\u6587";

        // 使用+连接字符串，使用+连接其他数据类型时会将其他数据类型自动转为字符串
        String s5 = s2 + " " + s3 + "!!";
        int i = 1234;
        String s6 = s5 + i;


        // java13可以使用"""asdasd"""来表示多行字符串

        // 字符串的内容是不可以变化的，因为字符串是引用类型，字符串的变量中存放的其实是字符串内容的内存地址

        // 字符串设置为null时表示不指向任何字符串，空字符串也是一个字符串对象
        String s7 = null;

        // 获取长度
        String s8 = "123124As发送asdas";
        System.out.println(s8.length());
    }

    private void array() {
        // 数组类型
        // 数组是引用类型，但数组元素可以是值类型或者引用类型
        // 声明数组需要指定数组大小，数组创建后大小就不可以改变
        // 所有元素初始化为默认值，整型为0，浮点型为0.0，布尔型为false
        int[] intArray1 = new int[5];
        // 也可以在声明数组时就指定初始化元素，这样就不必写数组大小
        int[] intArray2 = {1, 2, 3, 4, 5};

        // 使用索引访问数组，索引从0开始，
        System.out.println(intArray1[0]);
        System.out.println(intArray2[3]);
        // 获取数组大小
        System.out.println(intArray2.length);

        // 字符串数组:存放引用类型
        String[] stringArray = {"ABC", "DEF", "GHI"};
        String s = stringArray[1];
        stringArray[1] = "Cat";

        // s的输出是DEF
        System.out.println(s);

        // System.out.println(stringArray[31]); 所以超出范围将会报错
    }
}
