package Utils;

public class Email {
    public String email;
    
   public Email(String incoming)
    {
        this.email=incoming;
    }
    
    public Email getEmail()
    {
        return this;
    }




    @Override
    public String toString() {
        
        // Change this to fit implementation
        return new String(this.email);
    }
}
