public class Appointment {
    private String id;
    private String dateTime;
    private String reason;
    private Doctor doctor;
    private Patient patient;

    public Appointment (String id, String dateTime, String reason, Doctor doctor, Patient patient){
        this.id = id;
        this.dateTime = dateTime;
        this. reason = reason;
        this.doctor = doctor;
        this.patient = patient;
    }
    public String getId(){
        return id;
    }
    public String getDateTime(){
        return dateTime;
    }
    public String getReason(){
        return reason;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public Patient getPatient(){
        return patient;
    }
    @Override
    public String toString(){
        return id + "," + dateTime + "," + reason + "," + doctor.getId() + "," + patient.getId();
    }
}
//hola como estas
// estos son los cambios
//ha ya me doy cuenta
// a ver si ya se deja