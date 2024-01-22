public class IllegalPasswordException extends Exception
{
    public IllegalPasswordException(String password)
    {
        System.out.println("Illegales Password");
        System.out.println("'"+password +"' ist nicht erlaubt");
    }
}
