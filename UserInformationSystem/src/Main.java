public class Main {
    public static void main(String[] args) {
    UserInfo user1 = new UserInfo("Shahad",20,"shahadthy15@gmail.com", true);
    UserInfo user2 = new UserInfo("Ali",21,"ali453@icloud.com",false);
    UserInfo user3 = new UserInfo("Raghad",18,"rbeast24@gmail.com",true);

    user1.displayInfo();
    user2.displayInfo();
    user3.displayInfo();

    user1.setEmail("s.harthy@icloud.com");
    System.out.println(user1.getEmail());
    user2.setName("Qais");
    System.out.println(user2.getName());
    user3.setAge(20);
    System.out.println(user3.getAge());
    }
}
