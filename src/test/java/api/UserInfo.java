package api;

public class UserInfo {
    public int id;
    public String firstName;
    public String secondName;
    public int age;
    public String sex;
    public double money;


    public UserInfo(int id, String firstName, String secondName, int age, String sex, double money) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getMoney() {
        return money;
    }
}
