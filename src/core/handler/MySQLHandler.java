	/**
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	/**
	 *
	 * @author troeder
	 */

package core.handler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import core.bricks.Config;


public class MySQLHandler {

	/**
	 * MySql get Config
	 * MySql create Connection
	 * MySql create Statement
	 * MySql Discconnect
	 * MySql teonnect
	 * MySql rest Connection
	 */
	    
	    private Config config;
	    private Connection connection;
	    private Statement statement;
	    private PreparedStatement preparedStatement;
	    private ResultSet resultSet;
	    private ArrayList<String[]> result;
	    private String[] arrayOfString;
	    private int arrayOfStringSize;
	    private boolean dbConnection = false;
	    
    /**
     * Constructor
     */
	    public MySQLHandler() {
	        config = new Config();
	        sqlCreateStatement(sqlConnect());
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Fehler bei MySQL-JDBC-Bridge" + e);
	        }
	    }
	    
	//==============================================================================
	//  Method: sqlConnect():
	//  Gets Server-/Accessdata, create connection and returns usable statement.
	//------------------------------------------------------------------------------
	    public Connection sqlConnect() {
	        try {
	            String url = "jdbc:mysql://" + config.getSqlHost() + "/" + config.getSqlDB();
	            this.connection = DriverManager.getConnection(url, config.getSqlUser(), config.getSqlPass());
	        } catch (SQLException ex) {
	            Logger.getLogger(MySQLHandler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return connection;
	    }
	    
	    public Statement sqlCreateStatement(Connection connection) {
	        try {
	            this.statement = connection.createStatement();
	        } catch (SQLException ex) {
	            Logger.getLogger(MySQLHandler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return statement;
	    }
	    /*
	    public PreparedStatement prepareStatement() {
	        try {
	            preparedStatement = connection.prepareStatement
	                ("UPDATE EMPLOYEES SET SALARY = ? WHERE ID = ?");
	        } catch (SQLException ex) {
	            Logger.getLogger(SqlClient.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return preparedStatement;
	    }*/
	//==============================================================================
	//  Method: sqlExecuteQuery():
	//  gets Server-/Accessdata, create connection and returns usable statement
	//------------------------------------------------------------------------------
	    public ArrayList<String[]> sqlExecuteQuery(String sqlQuery) {
	        try {
	            result = new ArrayList<>();
	            resultSet = this.statement.executeQuery(sqlQuery);
	            int columns = resultSet.getMetaData().getColumnCount();
	            // Transform ResultSet --> ArrayList
	            while (resultSet.next()) {
	                String[] str = new String[columns];
	                for (int k = 1; k <= columns; k++) {
	                    str[k - 1] = resultSet.getString(k);
	                    //System.out.println(str[k-1]);
	                }
	                
	                result.add(str);
	            }
	            
	            int rows = result.size();
	            arrayOfStringSize = columns * rows;
	        } catch (SQLException e) {
	            System.out.println("Fehler bei Tabellenabfrage: " + e);
	        }
	        return result;
	    }
	    
	 
	//==============================================================================
	//  Method: sqlArrayListToStringArray(ArrayList list):
	//  Transform an ArrayList to an Array of Strings and returns it.
	//------------------------------------------------------------------------------    
	    public String[] sqlArrayListToStringArray(ArrayList list) {
	        arrayOfString = new String[arrayOfStringSize];
	        int count = 0;
	        for (Iterator iter = list.iterator(); iter.hasNext();) {
	            String[] str = (String[]) iter.next();
	            for (String strElement : str) {
	                arrayOfString[count] = strElement;
	                count++;
	            }
	        }
	        return arrayOfString;
	    }
	   
	//==============================================================================
	//  Method: sqlDisconnect():
	//  Close given Statement and Connection.
	//------------------------------------------------------------------------------ 
	    public void sqlDisconnect (Statement statement, Connection connection){
	        try {
	            this.statement.close();
	            this.connection.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(MySQLHandler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	//==============================================================================
	//  Method: sqlFullReadFlow():
	//  The whole Reading flow for sql: connect, create statement, send query,
	//  transform ResultSet --> ArrayList and ArrayList --> String[]
	//------------------------------------------------------------------------------     
	    public String[] sqlFullReadFlow
	        (String sqlHost, String sqlDB, String sqlUser, String sqlPass, String sqlQuery) throws SQLException {
	            connection = sqlConnect();
	            statement = sqlCreateStatement(connection);
	            result = sqlExecuteQuery(sqlQuery);
	            arrayOfString = sqlArrayListToStringArray(result);
	            return arrayOfString;
	    }
	        
	    public void conCheck() {
	        try {
	            if (connection == null || connection.isClosed() || statement == null || statement.isClosed()) {
	                sqlCreateStatement(sqlConnect());
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(MySQLHandler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public void sqlInsertQuery(String sqlQuery) {
	    	try {
				this.statement.executeUpdate(sqlQuery);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	    public void sqlDeleteQuery(String brandName) {
	    	String selectSQL = "DELETE FROM pro_brands WHERE brands_name = ?";
	    	try {
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, brandName);
				preparedStatement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		public Statement getStatement() {
			return statement;
		}

		public void setStatement(Statement statement) {
			this.statement = statement;
		}

		public boolean isDbConnection() {
			return dbConnection;
		}

		public void setDbConnection(boolean dbConnection) {
			this.dbConnection = dbConnection;
		}

			
}
