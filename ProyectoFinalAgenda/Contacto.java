


public class Contacto 
{
    public String nombre;
    public String direccion;
    public String telefonoCasa;
    public String telefonoTrabajo;
    public String telefonoPersonal;
    public String correoElectronico;
    
    public Contacto(String nombre,String telefonoPersonal,String telefonoCasa,String telefonoTrabajo, String direccion, String correoElectronico){
        this.nombre  = nombre;
        this.telefonoPersonal = telefonoPersonal;
        this.telefonoCasa = telefonoCasa;
        this.telefonoTrabajo = telefonoTrabajo;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public String getNombre(){
        return nombre;
    }

    public void setTelefonoPersonal(String telefonoPersonal){
        this.telefonoPersonal = telefonoPersonal; 
    }

    public String getTelefonoPersonal(){
        return telefonoPersonal;
    }
    
    public void setTelefonoCasa(String telefonoPersonal){
        this.telefonoCasa = telefonoCasa; 
    }

    public String getTelefonoCasa(){
        return telefonoCasa;
    }
    
    public void setTelefonoTrabajo(String telefonoPersonal){
        this.telefonoTrabajo = telefonoTrabajo; 
    }

    public String getTelefonoTrabajo(){
        return telefonoTrabajo;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion; 
    }

    public String getDireccion(){
        return direccion;
    }

    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico; 
    }

    public String getCorreoElectronico(){
        return correoElectronico;
    }

    public String toString(){
        String str = "Nombre : " + getNombre() + "\n";
        str += "Numero telefonico personal: " + getTelefonoPersonal() + "\n";  
        str += "Numero telefonico casa: " + getTelefonoCasa() + "\n";  
        str += "Numero telefonico trabajo: " + getTelefonoTrabajo() + "\n";  
        str += "Correo electronico: " + getCorreoElectronico() + "\n";
        str += "Direccion: " + getDireccion();
        return str;
    }

   
}
