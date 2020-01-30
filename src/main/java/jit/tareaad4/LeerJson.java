package jit.tareaad4;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LeerJson {

    private static final String rutaJsonProvincias = System.getProperty("user.dir") + "\\Provincias.json";
    private static final String rutaJsonConfig = System.getProperty("user.dir") + "\\config.json";

    public static void leerJsonProvincias() {

        //leemos el json
        Gson gson = new Gson();
        java.lang.reflect.Type tipoProvincias = new TypeToken<ArrayList<Provincia>>() {
        }.getType();

        // serializamos el archivo en un array de objetos provincia
        if (new File(rutaJsonProvincias).exists()) {

            ArrayList<Provincia> provincias = gson.fromJson(leerString(new File(rutaJsonProvincias)), tipoProvincias);

            // introducimos las provincias en la BD
            Transaction tran = null;
            try {
                //Collemos a sesión de Hibernate
                Session session = HibernateUtil.getSesionFactory().openSession();

                //Comenzamos unha transacción
                tran = session.beginTransaction();

                for (Provincia e : provincias) {
                    session.saveOrUpdate(e);
                }

                //Facemos un commit da transacción
                tran.commit();

            } catch (HibernateException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }

    }

    public static LinkedTreeMap leerdbConnection() {
        Gson gson = new Gson();
        LinkedTreeMap configuracion = null;
        if (new File(rutaJsonConfig).exists()) {
            Map jsonJavaRootObject = gson.fromJson(leerString(new File(rutaJsonConfig)), Map.class);
            configuracion = (LinkedTreeMap) jsonJavaRootObject.get("dbConnection");
        }
        return configuracion;
    }

    public static LinkedTreeMap leerhibernate() {
        Gson gson = new Gson();
        LinkedTreeMap configuracion = null;
        if (new File(rutaJsonConfig).exists()) {
            Map jsonJavaRootObject = gson.fromJson(leerString(new File(rutaJsonConfig)), Map.class);
            configuracion = (LinkedTreeMap) jsonJavaRootObject.get("hibernate");
        }
        return configuracion;
    }
    

    public static String leerString(File archivo) {
        String entrada = "";
        try {
            InputStream stream = new FileInputStream(archivo);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

            int caracter;
            while ((caracter = reader.read()) != -1) {
                entrada += (char) caracter;
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero");
        }
        return entrada;
    }
}
