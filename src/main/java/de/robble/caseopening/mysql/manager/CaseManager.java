package de.robble.caseopening.mysql.manager;

import de.robble.caseopening.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CaseManager {
    private UUID uuid;
    private int CASE1;
    private int CASE2;
    private int CASE3;
    private Main main;
    private String playername;
    public CaseManager(UUID uuid, Main main) throws SQLException {
        this.uuid = uuid;
        this.main = main;

        ResultSet resultSet = null;

        // PreparedStatement statement = main.getDatabaseManager().getConnection().prepareStatement("SELECT DATABASENAME FROM `tablename` WHERE UUID = ?;");
        PreparedStatement statement = main.getDatabaseManager().getConnection().prepareStatement("SELECT CASE1, CASE2, CASE3, PLAYERNAME FROM `case-opening` WHERE UUID = ?;");
        statement.setString(1, uuid.toString());
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            CASE1 = resultSet.getInt("CASE1");
            CASE2 = resultSet.getInt("CASE2");
            CASE3 = resultSet.getInt("CASE3");
            playername = resultSet.getString("PLAYERNAME");
        }else {
            CASE1 = 0;
            CASE2 = 0;
            CASE3 = 0;
            PreparedStatement statement1 = main.getDatabaseManager().getConnection().prepareStatement("INSERT INTO `case-opening` (UUID, PLAYERNAME ,CASE1, CASE2, CASE3) VALUES (" +
                    "'" + uuid + "'," +
                    "'" + playername + "'," +
                    "" + CASE1 + ");" +
                    "" + CASE2 + ");" +
                    "" + CASE3 + ");");


            statement1.executeUpdate();
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getCASE1() {
        return CASE1;
    }

    public void setCASE1(int CASE1) {
        this.CASE1 = CASE1;
    }

    public int getCASE2() {
        return CASE2;
    }

    public void setCASE2(int CASE2) {
        this.CASE2 = CASE2;
    }

    public int getCASE3() {
        return CASE3;
    }

    public void setCASE3(int CASE3) {
        this.CASE3 = CASE3;
    }

}
