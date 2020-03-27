package Hash;

import java.io.*;

/**
 * @author 微信公众号：Java技术栈
 */
public class TransientTest {

    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setUsername("Java技术栈");
        user.setId("javastack");

        System.out.println("\n序列化之前");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("d:/user.txt"));
        os.writeObject(user);
        os.flush();
        os.close();

        user.setId("sssssss");

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("d:/user.txt"));
        user = (User) is.readObject();
        is.close();

        System.out.println("\n序列化之后");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

    }
}

/**
 * @author 微信公众号：Java技术栈
 */
class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private transient String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
