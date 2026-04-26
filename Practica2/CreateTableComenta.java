package series;

import java.sql.*;

public class CreateTableComenta implements DataBaseTask {
    public void run(Connection conn, String data) throws SeriesException {
        try (Statement stmt = conn.createStatement();){
            String sql = "CREATE TABLE comenta (" +
                         "id_usuario INT, " +
                         "id_serie INT, " +
                         "fecha DATE, " +
                         "texto TEXT, " +
                         "PRIMARY KEY (id_usuario, id_serie, fecha), " +
                         "FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario), " +
                         "FOREIGN KEY (id_serie) REFERENCES serie(id_serie)" +
                         ")";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            throw new SeriesException(e, "CreateTableComenta");
        } 
    }
}
