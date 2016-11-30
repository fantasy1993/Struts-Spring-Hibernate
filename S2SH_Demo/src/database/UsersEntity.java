package database;

/**
 * Created by zhuxinquan on 16-11-30.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "USERS", schema = "test", catalog = "")
public class UsersEntity {
    private String id;
    private String userName;
    private String uPassword;
    private String uEmail;

    @javax.persistence.Id
    @javax.persistence.Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "user_name", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "u_password", nullable = false, length = 32)
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "u_email", nullable = true, length = 100)
    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (uPassword != null ? !uPassword.equals(that.uPassword) : that.uPassword != null) return false;
        if (uEmail != null ? !uEmail.equals(that.uEmail) : that.uEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (uPassword != null ? uPassword.hashCode() : 0);
        result = 31 * result + (uEmail != null ? uEmail.hashCode() : 0);
        return result;
    }
}
