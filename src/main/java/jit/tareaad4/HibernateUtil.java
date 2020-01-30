package jit.tareaad4;

import java.util.Properties;
import static jit.tareaad4.LeerJson.leerdbConnection;
import static jit.tareaad4.LeerJson.leerhibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    //Este método devolve a sesión para poder facer operacións coa base de datos
    public static SessionFactory getSesionFactory() {

        //Se a sesion non se configurou, creamolo
        if (sessionFactory == null) {
            try {
                Configuration conf = new Configuration();

                //Engadimos as propiedades
                Properties settings = new Properties();

                //Indicamos o conector da base de datos que vamos a usar
                settings.put(Environment.DRIVER, leerhibernate().get("driver"));

                //Indicamos a localización da base de datos que vamos a utilizar
                settings.put(Environment.URL, "jdbc:mysql://" + leerdbConnection().get("address") + ":" + leerdbConnection().get("port") + "/" + leerdbConnection().get("name"));

                //Indicamos o usuario da base de datos con cal nos vamos conectar e o seu contrasinal
                settings.put(Environment.USER, leerdbConnection().get("user"));
                settings.put(Environment.PASS, leerdbConnection().get("password"));

                //Indicamos o dialecto que ten que usar Hibernate 
                settings.put(Environment.DIALECT, leerhibernate().get("dialect"));

                //Indicamos que se as táboas todas se borren e se volvan crear
                settings.put(Environment.HBM2DDL_AUTO, leerhibernate().get("HBM2DDL_AUTO"));

                //Indicamos que se mostre as operacións SQL que Hibernate leva a cabo
                settings.put(Environment.SHOW_SQL,leerhibernate().get("SHOW_SQL"));

                conf.setProperties(settings);

                //Engaidmos aquelas clases nas que queremos facer persistencia
                conf.addAnnotatedClass(Provincia.class);
                conf.addAnnotatedClass(Tenda.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
                sessionFactory = conf.buildSessionFactory(serviceRegistry);

            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
