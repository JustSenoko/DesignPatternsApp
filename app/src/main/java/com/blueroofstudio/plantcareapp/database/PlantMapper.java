package com.blueroofstudio.plantcareapp.database;


import com.blueroofstudio.plantcareapp.models.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantMapper {
    private final Connection connection;

    public PlantMapper(Connection connection) {
        this.connection = connection;
    }

    public Plant findById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT ID, NAME FROM PLANTS WHERE ID = ?");
        statement.setInt(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Plant(id, resultSet.getString(2));
            }
        }
        return null;
    }

    public void insert(Plant plant) {
        //TODO
    }

    public void update(Plant plant) {
        //TODO
    }

    public void delete(Plant plant) {
        //TODO
    }
}

