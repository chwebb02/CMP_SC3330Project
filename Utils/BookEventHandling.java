package Utils;


public class BookEventHandling 
{
        private CheckedOutMedia checkedoutmedia;



    public void LateEmail()
        {
            if(checkedoutmedia.isLate() == true)
            {
                //create email reminder/event
            }
        }

        public void WarningEmail()
        {
            if(checkedoutmedia.Warning() == true)
            {
                //create email reminder/event
            }
        }
        
        public void DateEmail()
        {
            if(checkedoutmedia.dueDateCheck() == true)
            {
                //create email reminder/event
            }
        }

        public void PhyscialLetter()
        {
            if(checkedoutmedia.LetterWarning() == true)
            {
                // create email reminder/event
            }
        }

        

        
}
