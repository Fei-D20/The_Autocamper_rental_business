

# UI 

This is the part of UI class diagram , it show the main logic about the design of UI class and the connection with the controller class. 

Following the relationship we can also identify about how the method invoke the next level page to reach different purpose.

At the end of the relation chain the UI controller will require the database JDBC read and write the data. 





```mermaid
classDiagram
%% This is the entry of the program
class applicationMain{
    +main(String[ ])$ void
    +start(Stage) void
}

applicationMain ..> UI_FrontPage : depentdency

%% package UI
%% package consoleUI
class UI_FrontPage{
	+showFrontPage(Pane)$ Pane
}
%% package ClientUI
class UI_ClientFrontPage{
	+clientFrontPage(Pane)$Pane
}

UI_FrontPage ..> Controller_FrontPage : depentdency
Controller_FrontPage ..> UI_ClientFrontPage : dependency

class Controller_FrontPage{
    +gotoClientFrontPage(Pane)EventHandler~MouseEven~
    +gotoFrontPage(Pane pane)EventHandler~MouseEvent~
}

UI_ClientFrontPage ..> Controller_ClientRegister : dependency

class Controller_ClientRegister{

	+gotoClientRegister(Pane)EventHandler~MouseEvent~
	+gotoclientFrontPage(Pane)EventHandler~MouseEvent~
	+ClientRegister(Client)EventHandler~MouseEvent~

	+clientRegisterName()ChangeListener~String~
	+clientRegisterPassWord()ChangeListener~String~
	+clientRegisterAddress()ChangeListener~String~
	+clientRegisterEmail()ChangeListener~String~
	+clientRegisterPhoneNo()ChangeListener~String~
}

Controller_ClientRegister ..> UI_ClientRegister : dependency

class UI_ClientRegister{
	+clientRegisterPage(Pane)$GridPane
	
}

Controller_ClientRegister ..> RegisterClient

class RegisterClient{
-Client newClient
+getNewClient()$ Client
+setNewClientID()$
}

RegisterClient --o ClientDaoImpl : aggregation
RegisterClient --* Client : composition













```







### Database.User

The database class diagram show about the user package contain. ( which also not the all class, just a part for example )

The connectionUtil include connect database and close database method. 

CRUD containing the create update delete and select method. 

Dao implement class use DAO patten to separate the query and the perparestatement to make the data safety.



```mermaid
classDiagram
%% this is the database class diagram
%% package JDBC
class ConnectionUtil
class CRUD

ConnectionUtil <.. CRUD : depentdency
%% package Dao
class Dao{
<<Interface>>
}

CRUD <.. Dao : depentdency

%% package User
class AdminDao{
<<interface>>
}
class ClientDao{
<<interface>>
}
class AdminDaoImpl
class ClientDaoImpl

Dao <|-- AdminDao : inheritance
Dao <|-- ClientDao : inheritance

AdminDao <|.. AdminDaoImpl : realization
ClientDao <|.. ClientDaoImpl : realization

%% package RalativeOutSide
class BankDao{
<<interface>>
}
class BankDaoImpl

Dao <|-- BankDao : inheritance
BankDao <|.. BankDaoImpl : realization

```





# Domain

The domain part is finishing on the UML design 

This class diagram show the part of relationship between different package and class. 

And the each of package class diagram is following. 

```mermaid
classDiagram
%% package domain.user

class User

class Admin
class Client


User <|-- Admin : inheritance
User <|-- Client : inheritance


%%-------------------------------------

class Reservation

class Rental

Reservation <-- Rental : association


class Camper

class Week

class Tank

class Mile

Mile *-- Camper : composition
Tank *-- Camper : composition

Camper <.. Reservation : dependency

class FuelMissing

class MileFee

class PriceCategories{
	<<enum>>
}

class Season{
	<<enum>>
}

%%------------------------------

class CamperFee

Camper <-- CamperFee

FuelMissing *-- CamperFee : composition

MileFee *-- CamperFee : composition
Mile <-- MileFee : dependence
Week <.. CamperFee : dependency
Week <-- Reservation
PriceCategories o-- CamperFee : aggregation
PriceCategories <-- Reservation
Season <.. CamperFee : dependency
season <-- Reservation



%%------------------------------


class Discount


class Insurance

%%------------------------------

class Payment


CamperFee *-- Payment : composition
Discount *-- Payment : composition
Insurance *-- Payment : composition

%%------------------------------

class Diposit


class Remaining


Payment <.. Diposit
Payment <.. Remaining

class Invoice

Diposit <-- Invoice
Remaining <-- Invoice


%%----------------------

class Bank

class PostSystem


```







### Domain.User

```mermaid
classDiagram
%% package domain.user
class IF_User{
    <<interface>>
    +login()boolean
    +logout()boolean
    +register()User
    +modifyInfo()User
    +reserve()Reservation
    +cancelReservation()void
    +getPayment()Payment
    +getInvoice()Invoice
    +extendReservation()reservation
}

class IF_Admin{
<<interface>>
}

class IF_Client{
<<interface>>
}

IF_User <|-- IF_Admin : inheritance
IF_User <|.. User : realization
IF_User <|-- IF_Client : inheritance

class Admin{
	-int daminID
	-int adminPassword
}
class Client{
	-int clientID;
    -int password;
    -String name;
    -String address;
    -String email;
    -int phoneNo;
    -int driveLicenseNo;
    -boolean driverFullDrivingLicenseStatue;
    -boolean coDriverExist;
    -String coDriverName;
    -int coDriverLicenseNo;
    -int bankID;
    -int accountNo;
}


IF_Admin <|.. Admin : realization
IF_Client <|.. Client : realization

User <|-- Admin : inheritance
User <|-- Client : inheritance


```

### Domain.RelativeOutSide

```mermaid
classDiagram
class Bank{
	-int bankID
	-int BankName
}
class IF_PostSystem{
	<<interface>>
	+getDeliveryDate()Date
	+getCost()double
	+getAddress()String
	+getPostType()String
}
class PostSystem

IF_PostSystem <|.. PostSystem : realization

```

### Domain.Product

```mermaid
classDiagram
class IF_Reservation{
	<<interface>>
}

class Reservation

IF_Reservation <|.. Reservation : realization

class IF_Rental{
	<<interface>>
}

class Rental

IF_Rental <|.. Rental : realization

Reservation <-- Rental : association

class IF_Camper{
	<<interface>>
}

class Camper

IF_Camper <|.. Camper : realization

class IF_Tank{
	<<interface>>
}

class Tank

IF_Tank <|.. Tank : realization

class IF_Mile{
	<<interface>>
}

class Mile

IF_Mile <|.. Mile

Mile *-- Camper : composition
Tank *-- Camper : composition

Camper <.. Reservation : dependency

```

### Domin.Payment

```mermaid
classDiagram

class IF_FuelMissing{
	<<interface>>
}

class FuelMissing

IF_FuelMissing <|.. FuelMissing : realization

class IF_MileFee{
	<<interface>>
}

class MileFee

IF_MileFee <|.. MileFee : realization

class IF_Week{
	<<interface>>
}

class Week

IF_Week <|.. Week : realization

class PriceCategories{
	<<enum>>
}

class Season{
	<<enum>>
}

%%------------------------------

class IF_CamperFee{
	<<interface>>
}

class CamperFee

IF_CamperFee <|.. CamperFee : realization

FuelMissing *-- CamperFee : composition
MileFee *-- CamperFee : composition
Week <.. CamperFee : dependency
PriceCategories o-- CamperFee : aggregation
Season <.. CamperFee : dependency

%%------------------------------

class IF_Discount{
	<<interface>>
}

class Discount

IF_Discount <|.. Discount : realization

class IF_Insurance{
	<<interface>>
}

class Insurance

IF_Insurance <|.. Insurance : realization

class IF_Diposit{
	<<interface>>
}

%%------------------------------

class IF_Payment{
	<<interface>>
}

class Payment

IF_Payment <|.. Payment : realization

CamperFee *-- Payment : composition
Discount *-- Payment : composition
Insurance *-- Payment : composition

%%------------------------------

class Diposit

IF_Diposit <|.. Diposit : realization

class IF_Remaining{
	<<interface>>
}

class Remaining

IF_Remaining <|.. Remaining : realization

Payment <.. Diposit
Payment <.. Remaining

class Invoice

Diposit <-- Invoice
Remaining <-- Invoice
```