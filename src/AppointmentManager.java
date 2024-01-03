import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class AppointmentManager {
    private List<Doctor> doctors;
    private List<Usuarios>usuarios;
    private List<Patient> patients;
    private List<Appointment> appointments;
    private Map<String, String> admon;

    public AppointmentManager(){
        usuarios = new ArrayList<>();
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        admon = new HashMap<>();
    }
    public void addUsuario (Usuarios usuario){
        usuarios.add(usuario);
    }
    public void addDoctor (Doctor doctor){
        doctors.add(doctor);
    }
    public void addPatient (Patient patient){
        patients.add(patient);
    }
    public void createAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    public void addAdmin(String username, String password){
        admon.put(username, password);
    }
    public boolean authenticate(String username, String password){
        return admon.containsKey(username) && admon.get(username).equals(password);
    }

    public void saveData(String doctorsFile, String patientsFile, String appointmentsFile, String usuariosFile){
        try {

            FileWriter writer = new FileWriter(usuariosFile);
            for (Usuarios usuario : usuarios) {
                writer.write(usuario.toString() + "\n"); 
            }
            writer.close();

            writer = new FileWriter(doctorsFile);
            for (Doctor doctor : doctors) {
                writer.write(doctor.toString() + "\n");
            }
            writer.close();

            writer = new FileWriter(patientsFile);
            for (Patient patient : patients) {
                writer.write(patient.toString() + "\n");
            }
            writer.close();
            
            writer = new FileWriter(appointmentsFile);
            for (Appointment appointment : appointments) {
                writer.write(appointment.toString() + "\n");
                
            }
            writer.close();

            System.out.println("Datos guardados correctamente.");
            

        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    public void loadData(String doctorsFile, String patientsFile, String appointmentsFile, String usuariosFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(doctorsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Doctor doctor = new Doctor(fields[0], fields[1], fields[2]);
                doctors.add(doctor);
            }
            reader.close();

            reader = new BufferedReader(new FileReader(usuariosFile));
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Usuarios usuario = new Usuarios(fields[0], fields[1]);
                usuarios.add(usuario);
            }
            reader.close();

            reader = new BufferedReader(new FileReader(patientsFile));
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Patient patient = new Patient(fields[0], fields[1]);
                patients.add(patient);
            }
            reader.close();

            reader = new BufferedReader(new FileReader(appointmentsFile));
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String appointmentId = fields[0];
                String dateTime = fields[1];
                String reason = fields[2];
                String doctorId = fields[3];
                String patientId = fields[4];

                Doctor doctor = findDoctorById(doctorId);
                Patient patient = findPatientById(patientId);

                if (doctor != null && patient != null) {
                    Appointment appointment = new Appointment(appointmentId, dateTime, reason, doctor, patient);
                    appointments.add(appointment);
                }
            }
            reader.close();

            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    private Doctor findDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    private Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }
}
