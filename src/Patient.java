public class Patient {
    private String id;
    private String fullName;

    public Patient(String id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }
    public String getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    @Override
    public String toString(){
        return id + "," + fullName;
    }
}
