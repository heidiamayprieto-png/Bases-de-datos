package series;

import java.sql.*;

public class CreateTableValora implements DataBaseTask {
    public void run(Connection conn, String data) throws SeriesException {
        try (Statement stmt = conn.createStatement()){
            String sql = "CREATE TABLE valora (" +
                         "id_usuario INT, " +
                         "id_serie INT, " +
                         "n_temporada INT, " +
                         "n_orden INT, " +
                         "fecha DATE, " +
                         "valor INT, " +
                         "PRIMARY KEY (id_usuario, id_serie, n_temporada, n_orden, fecha), " +
                         "FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario), " +
                         "FOREIGN KEY (id_serie, n_temporada, n_orden) " +
                         "REFERENCES capitulo(id_serie, n_temporada, n_orden)" +
                         ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            throw new SeriesException(e, "CreateTableValora");
        }
    }
}

