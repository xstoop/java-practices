package april.abstracts;

abstract class Person {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract void work();
}
