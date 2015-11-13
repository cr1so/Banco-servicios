package com.fpmislata.banco.persistencia.dao.impl.jdbc;

import com.fpmislata.banco.negocio.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import com.mysql.jdbc.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        try {
            EntidadBancaria entidadBancaria = new EntidadBancaria();
            String sql = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?";

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));
                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());
                entidadBancaria.setFechaCreacion(utilDate);
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));

                if (resultSet.next()) {
                    throw new RuntimeException("Hay mas de una fila " + sql);
                }

            } else {
                entidadBancaria = null;
            }

            connectionFactory.close(connection);

            return entidadBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {

        String sql = "INSERT INTO entidadbancaria(nombre, codigoEntidad, fechaCreacion, direccion, cif) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted == 0) {
                throw new RuntimeException("no se ha insertado nada " + rowsInserted);
            } else if (rowsInserted != 1) {
                throw new RuntimeException("Demasiadas o pocas filas insertadas " + rowsInserted);
            }

            int idEntidadBancaria;
            
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            idEntidadBancaria = resultSet.getInt(1);
                
            entidadBancaria = this.get(idEntidadBancaria);
            
            connectionFactory.close(connection);
            
            return entidadBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {

        try {
            String sql = "UPDATE entidadbancaria SET nombre = ?, codigoEntidad = ?, direccion = ?, cif = ?  WHERE idEntidadBancaria = ?";

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(5, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setString(3, entidadBancaria.getDireccion());
            preparedStatement.setString(4, entidadBancaria.getCif());

            int rowsChanged = preparedStatement.executeUpdate();

            connectionFactory.close(connection);

            if (rowsChanged == 0) {
                throw new RuntimeException("no se ha cambiado nada " + rowsChanged);
            } else if (rowsChanged == 1) {
                return entidadBancaria;
            } else if (rowsChanged > 1) {
                throw new RuntimeException("Demasiadas filas cambiadas " + rowsChanged);
            } else {
                throw new RuntimeException("Soy un paranoico " + rowsChanged);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int idEntidadBancaria) {

        try {

            String sql = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idEntidadBancaria);

            int rowsDelete = preparedStatement.executeUpdate();

            connectionFactory.close(connection);

            if (rowsDelete == 0) {
                return false;
            } else if (rowsDelete == 1) {
                return true;
            } else if (rowsDelete > 1) {
                throw new RuntimeException("Demasiadas filas borradas " + rowsDelete);
            } else {
                throw new RuntimeException("Soy un paranoico " + rowsDelete);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {

        try {
            String sql = "SELECT * FROM entidadbancaria";

            List<EntidadBancaria> listaEntidadBancaria = new ArrayList<>();

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));

                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());
                entidadBancaria.setFechaCreacion(utilDate);

                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));

                listaEntidadBancaria.add(entidadBancaria);

            }

            connectionFactory.close(connection);

            return listaEntidadBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        try {
            String sql = "SELECT * FROM entidadbancaria WHERE nombre = ?";

            List<EntidadBancaria> listaEntidadBancaria = new ArrayList<>();

            Connection connection = connectionFactory.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nombre);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getInt("codigoEntidad"));
                java.util.Date utilDate = new java.util.Date(resultSet.getDate("fechaCreacion").getTime());
                entidadBancaria.setFechaCreacion(utilDate);
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));

                listaEntidadBancaria.add(entidadBancaria);

            }

            connectionFactory.close(connection);
            return listaEntidadBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
