package generics;

/**
 * @author xstoop
 */
public class Pair<T, V> {

    private T first;

    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    /**
     * 静态方法返回类型前需要加一个<T, V>
     *
     * @param first  T
     * @param second V
     * @param <T>    T
     * @param <V>    V
     * @return Pair<T, V>
     */
    public static <T, V> Pair<T, V> create(T first, V second) {
        return new Pair<T, V>(first, second);
    }
}
