import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                
        
        System.out.println("\n\t\tHola Bienvenido al sistema de salud. Por favor ingrese su usuario y contrasenia:\n");
        Scanner scanner = new Scanner (System.in);
        System.out.print("Usuario:\n");  
        String usuario = scanner.next();
        System.out.print("Contrasenia:\n");  
        String contrasenia = scanner.next();
        scanner.close();

        System.out.println("Su usuario es: " + usuario);
        System.out.println("Su contrasenia es: " + contrasenia);
        
        AppointmentManager manager = new AppointmentManager();
        Usuarios usuario1 = new Usuarios("Isaac", "12345678");
        Usuarios usuario2 = new Usuarios("Caleb", "87654321");
        manager.addUsuario (usuario1);
        manager.addUsuario(usuario2);

        // Registro de nuevos doctores
        Doctor doctor1 = new Doctor("D-01", "Dr. Horacio Padilla", "Pediatra");
        Doctor doctor2 = new Doctor("D-02", "Dr. Victor Maciel", "Gastroenterologo");
        manager.addDoctor(doctor1);
        manager.addDoctor(doctor2);

        // Registrar nuevos pacientes
        Patient patient1 = new Patient("P-01", "Reyna Ponce");
        Patient patient2 = new Patient("P-02", "Carmen Alvarez");
        manager.addPatient(patient1);
        manager.addPatient(patient2);

        // Crear las citas citas
        Appointment appointment1 = new Appointment("A001", "2023-06-17 10:00", "Cita mensual", doctor1, patient1);
        Appointment appointment2 = new Appointment("A002", "2023-06-18 15:30", "Revisión tratamiento", doctor2, patient2);
        manager.createAppointment(appointment1);
        manager.createAppointment(appointment2);

        // Guardar los datos en archivos
        manager.saveData("doctors.csv", "patients.csv", "appointments.csv", "usuarios.csv");

        // Cargar los datos desde los archivos
        manager.loadData("doctors.csv", "patients.csv", "appointments.csv", "usuarios.csv");
    }
}