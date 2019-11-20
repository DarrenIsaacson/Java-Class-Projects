package Elevation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceDB {
    private static final String DB_CONNECTION_URL = "jdbc:sqlite:places.sqlite";

    private static final String NAME_COL = "name";
    private static final String ELEV_COL = "elevation";

    static final String OK = "ok";
    static final String DUPLICATE = "Duplicate place name";

    static final int SQLITE_DUPLICATE_PRIMARY_KEY_CODE = 19;

    PlaceDB(){
        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
             Statement statement = conn.createStatement()) {


                String createTableSQL = "CREATE TABLE IF NOT EXISTS places" +
                        "(name TEXT PRIMARY KEY, elev DOUBLE)";
                statement.executeUpdate(createTableSQL);

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);

        }
    }
    public List<Place> fetchAllRecords(){
        List<Place> allRecords = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
        Statement statement = conn.createStatement()){

            String selectAllSQL = "SELECT * FROM places";
            ResultSet rsAll = statement.executeQuery(selectAllSQL);

            while(rsAll.next()){
                String name = rsAll.getString(NAME_COL);
                double elevation = rsAll.getDouble(ELEV_COL);
                Place placeRecord = new Place(name, elevation);
                allRecords.add(placeRecord);

            }

            return allRecords;

        }catch(SQLException sqle){
            throw new RuntimeException(sqle);

        }


    }
    public String addRecord(Place place){

        String addPlace = "INSERT INTO places VALUE(?,?)";

        try(Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
        PreparedStatement addPlacePs = conn.prepareStatement(addPlace)){

            addPlacePs.setString(1,place.getName());
            addPlacePs.setDouble(2, place.getElevation());

            return OK;

        } catch (SQLException sqle){
            if(sqle.getErrorCode() == SQLITE_DUPLICATE_PRIMARY_KEY_CODE){
                return DUPLICATE;
            } else {
                throw new RuntimeException(sqle);
            }
        }

    }
}
