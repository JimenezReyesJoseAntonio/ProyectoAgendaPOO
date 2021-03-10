
import java.io.*;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.Scanner;
public class Agenda
{
    //agregar contacto recibe un objeto de tipo contacto en el parametro
    Scanner entrada = new Scanner(System.in);
    public void agregarContacto(Contacto contacto){
        try{
            File f = new File("agendaContactos.txt");
            FileWriter w;
            BufferedWriter bw;
            if(f.exists() && f.length() != 0){
                w = new FileWriter(f,true);
                bw = new BufferedWriter(w);
                bw.newLine();
                bw.write(contacto.nombre+"%"+contacto.telefonoPersonal+"%"+
                    contacto.telefonoCasa+"%"+contacto.telefonoTrabajo+"%"+contacto.correoElectronico+"%"+contacto.direccion);
            }else{
                w = new FileWriter(f);
                bw = new BufferedWriter(w);
                bw.write(contacto.nombre+"%"+contacto.telefonoPersonal+"%"+
                    contacto.telefonoCasa+"%"+contacto.telefonoTrabajo+"%"+contacto.correoElectronico+"%"+contacto.direccion);
            }
 
            bw.close();
            w.close();

        }catch(Exception e ){
            System.err.print("Error al agregar a la persona");

        }

    }
 
    public void eliminarContacto(String nombreContacto){
        File f = new File("agendaContactos.txt");
        try{
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int numLineas = 0;
                while((linea = br.readLine()) != null){
                    numLineas++;
                }
                String contactos[] = new String[numLineas];
                br.close();
                fr.close();
                br = new BufferedReader(fr = new FileReader(f));
                int i = 0;
                while((linea = br.readLine()) != null){
                    contactos[i] = linea;
                    i++;
                }
                br.close();
                fr.close();
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                boolean bandera = false;
                boolean primeraL = true;
                for(int j=0; j < contactos.length; j++){
                    String l [] = contactos[j].split("%");
                    if(l[0].equals(nombreContacto)){
                        bandera = true;
                        System.out.println("Contacto Eliminado");
                    } else{
                        if(primeraL == true){
                            bw.write(contactos[j]);
                            primeraL = false;
                        } else{
                            bw.newLine();
                            bw.write(contactos[j]);
                        }
                    }
                }
                if(bandera == false){
                    System.out.println("No se encontró el contacto");
                }
                bw.close();
                fw.close();
                if(numLineas == 1 && bandera == true){
                    f.delete();
                }

            } else{
                System.out.println("No hay contactos existentes.");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void buscar(String nombreContacto){
        try{
            File f = new File("agendaContactos.txt");
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                boolean aux = false;
                while((linea = br.readLine()) != null){
                    String contacto [] = linea.split("%");
                    if(contacto[0].equals(nombreContacto)){
                        aux = true;
                        Contacto c = new Contacto (contacto[0],contacto[1],
                                contacto[2],contacto[3],contacto[4],contacto[5]);
                        System.out.println("Persona encontrada: ");
                        System.out.print(c.toString());
                        System.out.println();
                    }
                }
                if(aux == false){
                    System.out.println("contacto no existente");
                }
            }else{
                System.out.println("Aun no hay una agenda");
            }
        } catch(Exception e){

            System.err.print("Error al buscar el contacto");
        } 
    }
 
    public void mostrarContactos(){
        try{
            File f = new File("agendaContactos.txt");
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea = br.readLine()) != null){
                    String[] contacto = linea.split("%");
                    Contacto c = new Contacto(contacto[0],contacto[1],
                            contacto[2],contacto[3],contacto[4],contacto[5]);
                    System.out.println(c.toString());
                    System.out.println("--------------------");
                }
            } else{
                System.out.println("Agenda Vacía");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void cambiarNumero(String cambiarContacto){
        try{
            File f = new File("agendaContactos.txt");
            FileWriter esc;
            BufferedWriter bu;
            if(f.exists()){
                FileReader ra = new FileReader(f);
                BufferedReader be = new BufferedReader(ra);
                esc = new FileWriter(f,true);
                bu = new BufferedWriter(esc);
                String linea;
                boolean aux = false;

                System.out.println("ingresa el anterior numero para confirmar ");
                String numero = entrada.nextLine();
                String numeroNuevo;
                while((linea = be.readLine()) !=null){
                    String[] contacto = linea.split("%");

                    if(contacto[1].equals(numero)){
                        System.out.println("Ingrese el numero numero");
                        numeroNuevo = entrada.nextLine();

                        contacto[1] = numeroNuevo;
                        bu.write(contacto[1]);
                    }else if(contacto[2].equals(numero)){
                        System.out.println("Ingrese el numero numero");
                        numeroNuevo = entrada.nextLine();

                        contacto[2] = numeroNuevo;
                        bu.write(contacto[2]);
                    }else if(contacto[3].equals(numero)){
                        System.out.println("Ingrese el numero numero");
                        numeroNuevo = entrada.nextLine();

                        contacto[3] = numeroNuevo;
                        bu.write(contacto[3]);
                    }

                }
               esc.close();
               bu.close();
               be.close();
            }else{System.out.println("agenda vacia");}        
        }catch(Exception e){
            System.err.println("Error inesperado"+e);
        }

    }
}