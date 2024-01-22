import java.util.Scanner;

public class PasswortabfrageRestriktiv {
    public static void main(String[] args) {

        PasswortabfrageRestriktiv pwdSetter = new PasswortabfrageRestriktiv();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Password eingeben");
        String password = sc.nextLine();

        try 
        {
            String myPassword = pwdSetter.setPassword(password);
            if (!myPassword.equals("")) System.out.println("New Password ist '"+ myPassword+"'");
        } 
        catch (IllegalPasswordException e) 
        {   
            e.printStackTrace();
        }
        
        sc.close();
    }

    public String setPassword(String password) throws IllegalPasswordException
    {
        if (password.equals("Love")|| password.equals("God") || password.equals("Root"))
        {
            throw new IllegalPasswordException(password);
        }
        return password;
    }

}
