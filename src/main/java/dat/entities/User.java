package dat.entities;

public class User
{
    private int id;
    private String fname;
    private String lname;
    private String pw;

    public User(int id, String fname, String lname, String pw)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    public String getPw()
    {
        return pw;
    }
}
