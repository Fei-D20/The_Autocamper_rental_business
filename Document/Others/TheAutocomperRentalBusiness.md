# State Diagram

```mermaid
stateDiagram-V2
[*] --> Front_Page
Front_Page --> Client : choose User
    Client --> Registe_Page : choose new User
    	Registe_Page --> Conferm_Registe : input info
    		Conferm_Registe --> Camper_Page
    		
    Client --> Login_Page : choose have a count
		Login_Page --> Camper_Page

Front_Page --> administrator : choose Administrator
	administrator --> input_Client_Info : if this is new Client
		input_Client_Info --> Camper_Page
    administrator --> choose_Client : if this is excist Client
    	choose_Client --> Camper_Page
    	
Camper_Page --> Rental_Date_Page : choose the Camper
    Rental_Date_Page --> Insurance_Page : choose the rental date (base on weekly)
        Rental_Date_Page --> Camper_Page : if the rental date is not avaliable and Client doesn't want to change the date

Insurance_Page --> Invoice_Page : calculate the payment

Invoice_Page --> Payment_Method : confirm invoice

Payment_Method --> Send_Confirm_Mail : confirmPaymentMethod

Send_Confirm_Mail --> Send_Deposit_Recive : ClientPayDeposit
	Send_Confirm_Mail --> order_cancel_and_deposit_is_lost : if rental is canceled for some reason(      )    
	Send_Confirm_Mail --> Send_Reminder_Massage : if the Client didn't pay Deposit 10% in 2 week
		Send_Reminder_Massage --> order_cancel_and_deposit_is_lost : if the Client still didn't pay after reminder 5 days
		
Send_Deposit_Recive --> Send_Remaining_Recive : ClientPayRemaining
	Send_Deposit_Recive --> The_doc_did_say_what_to_do : if the client not pay the remaining in 8 weeks
	
Send_Remaining_Recive --> Client_Take_The_Comper : diliver the key
Client_Take_The_Comper --> Client_Return_The_Comper
	Client_Take_The_Comper --> Extend_Rental : the Client want more time
    	Extend_Rental --> Client_Return_The_Comper
Client_Return_The_Comper --> cheack_comper : how many mileage and full tank
	cheack_comper --> fuel_fee : if it is not full tank  
	cheack_comper --> mile_fee : first 1000km free and above it is 10 cents per km and 
fuel_fee --> send_payment 
mile_fee --> send_payment
send_payment --> [*] : if the Client not pay this then suit them

```





# Dao

The basic idea about ado patten is separate the database access and the control method for guarantee the data security. 

So following the concept, we make four part of syntax to make sure about it. 

1. Database access part : 

   1. Connection class : to make the connection between JVM and Database( SQL Server ) used by JDBC.
   2. CRUD method to access data. 

2. Dao Interface : 

   To make the comment interface to implement the comment database object, to ensure the database control method. 

   Separate the database access and data operation.

3. Object Dao interface : 

   Specific Object Dao interface extend the comment Dao interface separate the different database/table operation. 

4. Object Dao implement : implement the day interface . Override the specific method. Access the specific data. 

## 1. Database access part

### Connection Class

```java
public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("The connection is successful : \n" + connection);
        return connection;

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("the connection has been closed ! ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConAndPS(Connection connection, Statement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConPSAndRS(Connection connection, Statement preparedStatement, ResultSet resultSet) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
```

### Test method

```java
@Test
    public void testGetconnection() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        ConnectionUtil.closeConnection(connection);

    }


```



### CRUD Class

```java
public class CRUD {

    public static void update(String sql, Object... args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConAndPS(connection, preparedStatement);
        }
    }

    public static void getInstance(String sql, Object args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, args);

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 0; i < columnCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + "\t");
            }
            System.out.println();

            if (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(resultSet.getObject(i + 1) + "    |    ");
                }
                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConPSAndRS(connection, preparedStatement, resultSet);
        }
    }

    public static void getTable(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(resultSet.getString(i + 1) + "      |      ");
                }
                System.out.println();
            }

            resultSet.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConPSAndRS(connection, preparedStatement, resultSet);
        }

    }
```

### Test method

```java
@Test
    public void testUpdate() {
        try {
            String sql = "update tbl_Bank set fld_BankName = ? where fld_BankID = ? ";
            update(sql, "DanskBank", 1);
            System.out.println("update finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        try {
            String sql = " delete from tbl_Bank where fld_BankID = ? ";
            update(sql, 1);
            System.out.println("delete finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetInstance() {
        String sql = "select fld_BankID, fld_BankName from tbl_Bank where fld_BankID = ?";
        getInstance(sql, 1);
    }

    @Test
    public void testGetTable() {
        String sql = "select * from tbl_Bank";
        getTable(sql);
    }
```





## 2. The Base Dao Interface

```java
public interface Dao<T> {
    public void add(T t);

    public void update(T t);

    public void delete(int id);

    public void getInstance(int id);

    public void getAll();
}
```





## 3. The Client Dao interface

```java
public interface ClientDao extends Dao<Client> {
}
```





## 4. The Client Dao implement

```java
public class ClientDaoImpl implements ClientDao {

    @Test
    public void testAdd() {
        Client client = new Client();
        client.setClientID(3);
        client.setName("Fei Gu3");
        client.setAddress("Odense3");
        client.setEmail("feix0033@easv365.dk2");
        client.setPhoneNo(12345678);

        add(client);
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setClientID(001);
        client.setName("Fei Gu update ");
        client.setAddress("Odense update");
        client.setEmail("feix0033@easv365.dk update");
        client.setPhoneNo(87654321);

        update(client);

    }

    @Test
    public void testDelete() {
        delete(1);

    }

    @Test
    public void testGetInstance() {
        getInstance(1);
    }

    @Test
    public void testGetAll() {
        getAll();
    }


    @Override
    public void add(Client client) {

        try {
            String sql = "insert into tbl_Client (fld_ClientID, fld_Name, fld_Address, fld_EmailAddress, fld_PhoneNo) values (?,?,?,?,?)";

            int clientID = client.getClientID();
            String name = client.getName();
            String address = client.getAddress();
            String email = client.getEmail();
            int phoneNo = client.getPhoneNo();

            CRUD.update(sql, clientID, name, address, email, phoneNo);
            System.out.println("Add database table Client successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        try {
            String sql = "update tbl_Client set fld_Name = ? , fld_Address = ?, fld_EmailAddress = ? , fld_PhoneNo = ? where fld_ClientID = ?";

            int clientID = client.getClientID();
            String name = client.getName();
            String address = client.getAddress();
            String email = client.getEmail();
            int phoneNo = client.getPhoneNo();

            CRUD.update(sql, name, address, email, phoneNo, clientID);
            System.out.println("Update database table Client is successful! ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from tbl_Client where fld_ClientID = ?";
            CRUD.update(sql, id);
            System.out.println("Delete database table Client is successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInstance(int id) {
        String sql = "select fld_ClientID, fld_Name, fld_Address, fld_EmailAddress, fld_PhoneNo from tbl_Client where fld_ClientID = ?";
        CRUD.getInstance(sql, id);
    }

    @Override
    public void getAll() {
        String sql = "select * from tbl_Client";
        CRUD.getTable(sql);
    }

}

```









# Singleton

The singleton patten make sure each time when we need the Object and its method. We only make “One” object. 

Right here we use the patten for make sure when we get a new value from the UI input.  We can just change the same one object but not create a new object. 

```java
public class RegisterClient {
    private static Client newClient = new Client();

    private RegisterClient() {
    }


    public static Client getNewClient() {
        return newClient;
    }

    public static void setNewClientID() {
        /* use hashCode() method to set the ClientID : 
         * this is a simple and unique way to identify the customer 
         * but there is a not easy way to find the specific user so
         * I should make a searching method to find the ClientID.
         */
        newClient.setClientID(newClient.hashCode());
    }

}
```

