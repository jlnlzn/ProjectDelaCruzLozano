package julian.lozano.com.projectdelacruzlozano;

public class ContactDetails {
    String cID;
    String cName;
    String cEmail;
    String pNumber;

    public ContactDetails() {}

    public ContactDetails(String cID, String cName, String cEmail, String pNumber) {
        this.cID = cID;
        this.cName = cName;
        this.cEmail = cEmail;
        this.pNumber = pNumber;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }



    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }


}
