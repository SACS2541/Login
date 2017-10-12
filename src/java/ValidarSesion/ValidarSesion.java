package ValidarSesion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import BD.BD;
import java.sql.SQLException;
/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class ValidarSesion {
    private Statement _state;
    private ResultSet _result;
    private Connection _con;
    private BD _bd;
    
    public ValidarSesion(){
        this._state = null;
        this._result = null;
        this._con = null;
        this._bd = new BD();
    }
    
    public boolean Validar(String usu, String pass) throws SQLException{
        boolean valido = false;
        _con = _bd.Conectar();
        
        _state = _con.createStatement();
        
        _result = _state.executeQuery("select usuario, contraseña from usuarios");
        
        while(_result.next()){
            if(usu.equals(_result.getString("usuario")) && pass.equals(_result.getString("contraseña"))){
                valido = true;
            }
        }
        
        _bd.Cerrar();
        return valido;
    }
}