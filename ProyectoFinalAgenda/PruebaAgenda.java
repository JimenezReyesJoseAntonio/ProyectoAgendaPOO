
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class PruebaAgenda
{

    public static String  menu(){
        String strmenu = "";
        strmenu += "******MENU PRINCIPAL******" + "\n";
        strmenu += "1: Agregar contacto" + "\n";
        strmenu += "2: Eliminar contacto" + "\n";
        strmenu += "3: Buscar un contacto" + "\n";
        strmenu += "4: Mostrar Todos Los Contactos"+"\n";
        strmenu += "5: Cambiar numero de un contacto"+"\n";
        strmenu += "6: Salir "; 

        return strmenu;

    }

    public static void main(String []args){

        Scanner entrada = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean salir = true;
        try{

            while(salir){
                System.out.println();
                System.out.println(menu());
                
                int opc = entrada.nextInt();

                switch(opc){

                    case 1:
                    Contacto contacto;
                    String nombre, telefonoPersonal, telefonoCasa,telefonoTrabajo, correoElectronico,domicilio;
                    JOptionPane.showMessageDialog(null, "No se puede quedar un campo vacio en su lugar escriba un (no)");
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre ");
                    telefonoPersonal = JOptionPane.showInputDialog(null, "Ingrese su numero de telefono personal");
                    
                    telefonoCasa = JOptionPane.showInputDialog(null, "Ingrese su numero de telefono de casa");
                    
                    telefonoTrabajo = JOptionPane.showInputDialog(null, "Ingrese su numero de telefono del trabajo");
                    
                    correoElectronico = JOptionPane.showInputDialog(null, "Ingrese su correo electronico");
                    domicilio = JOptionPane.showInputDialog(null, "Ingrese su domicilio ");
                    contacto = new Contacto(nombre,telefonoPersonal, telefonoCasa,telefonoTrabajo, correoElectronico,domicilio);
                    agenda.agregarContacto(contacto);

                    break;

                    //Eliminar Contacto Por Medio Del Nombre
                    case 2:
                    String deleteContact;
                    deleteContact = JOptionPane.showInputDialog(null, "Ingrese el contacto a eliminar");
                    agenda.eliminarContacto(deleteContact);
                    break;

                    //Buscar un contacto por medio del nombre
                    case 3:
                    String buscarContacto ;
                    buscarContacto = JOptionPane.showInputDialog(null, "Ingrese el contacto a buscar");
                    agenda.buscar(buscarContacto);
                    break;

                    //Mostrar o imprimir todos los contactos
                    case 4:                       
                    agenda.mostrarContactos();
                    break;

                    case 5:
                    String cambio;
                    cambio = JOptionPane.showInputDialog(null, "Ingrese el contacto a buscar");
                    agenda.cambiarNumero(cambio);
                    
                    break;
                    
                    case 6:
                    salir = false;
                    break;
                    
                    default:
                    System.out.println("Opcion no valida pruebe de nuevo");
                }

            }

        }catch(NumberFormatException ex){
            System.err.println(ex);
        }catch(InputMismatchException er){
            System.out.println("No se permiten letras");
            entrada = new Scanner(System.in);
        }catch(Exception c){
            System.err.println(c);
        }

    }
}
