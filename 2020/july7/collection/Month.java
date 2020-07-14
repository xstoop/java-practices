package july7.collection;

import java.util.Objects;

public class Month {
    protected String name;

    protected int days;

    public Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    /**
     * 覆写equals方法，修改两个对象比较时是否相等的判定
     * @param  o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return days == month.days &&
                Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, days);
    }
}
