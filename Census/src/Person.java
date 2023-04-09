public class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education educat;
    public Person(String mname,String family,int age,Sex sex,Education educat){
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.educat = educat;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducat() {
        return educat;
    }
    @Override
    public String toString(){
         return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + educat +
                '}';
    }
}
