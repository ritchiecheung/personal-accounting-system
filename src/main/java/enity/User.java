package enity;

/**
 * @author : Ritchie Zhang
 * @date : 2020/6/23 0023
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class User {
    private  int id;
    private String username;
    private String account;
    private String password;
    private String name;
    private int amount;
    private int state;
    private int end;

    public User(){
        super();
    }
    public User(String account,String password,String username){
        this.account = account;
        this.password = password;
        this.username =  username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }




}
