package april4.abstracts;

abstract class Person {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void work();
}
