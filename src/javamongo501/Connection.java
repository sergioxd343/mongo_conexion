package javamongo501;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.net.UnknownHostException;

public class Connection {
    private final DB database;
    private final DBCollection collection;

    public Connection() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDB("Actividades501");
        collection = database.getCollection("Actividades501");
        System.out.println("Conexión exitosa");
    }

    public boolean insertar(String accion) {
        BasicDBObject document = new BasicDBObject();
        document.put("accion", accion);
        collection.insert(document);
        return true;
    }

    public void mostrar() {
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject document = cursor.next();
            String accion = (String) document.get("accion");
            System.out.println("Acción: " + accion);
        }
    }

    public boolean actualizar(String accionVieja, String accionNueva) {
        BasicDBObject documentoViejo = new BasicDBObject();
        documentoViejo.put("accion", accionVieja);

        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);

        DBObject documentoActualizado = collection.findAndModify(documentoViejo, documentoNuevo);
        return documentoActualizado != null;
    }

    public boolean eliminar(String accion) {
        BasicDBObject documento = new BasicDBObject();
        documento.put("accion", accion);

        DBObject documentoEliminado = collection.findAndRemove(documento);
        return documentoEliminado != null;
    }

    public void cerrarConexion() {
        database.getMongo().close();
    }
}
