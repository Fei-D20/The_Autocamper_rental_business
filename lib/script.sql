create DB_AutocamperRental
go

use DB_AutocamperRental

create table tbl_Admin
(
    fld_AdminID       int not null
        constraint tbl_Admin_pk
            primary key nonclustered,
    fld_AdminPassword int
)
go

create table tbl_Bank
(
    fld_BankID   int not null
        primary key,
    fld_BankName varchar(25)
)
go

create table tbl_BookingReservation
(
    fld_OrderID      int not null
        primary key,
    fld_CamperID     int
        references tbl_CAMPER (fld_CamperID),
    fld_OrderingDate date
)
go

create table tbl_CamperType
(
    fld_CamperType        varchar(30) not null
        primary key,
    fld_NumberOfBeds      int,
    fld_HeatingFacility   int,
    fld_SpaceAvailable    int,
    fld_KitchenFacilities varchar(100)
)
go

create table tbl_Client
(
    fld_ClientID                       int         not null
        primary key,
    fld_Name                           varchar(30) not null,
    fld_Address                        varchar(80) not null,
    fld_EmailAddress                   varchar(30) not null,
    fld_PhoneNo                        int         not null,
    fld_DriveLicenseNo                 int,
    fld_DriverFullDrivingLicenseStatue varchar(10),
    fld_CoDriverName                   int,
    fld_CoDriverLicenseNo              int,
    fld_RentalTimes                    int,
    fld_BankID                         int
        references tbl_Bank,
    fld_AccountNo                      int
)
go

create table tbl_Insurance
(
    fld_InsuranceID       int not null
        primary key,
    fld_InsuranceType     varchar(30),
    fld_InsuranceCovering varchar(100)
)
go

create table tbl_Invoice
(
    fld_InvoiceID      int not null
        primary key,
    fld_InvoiceDueDate date,
    fld_Amount         int
)
go

create table tbl_PriceCategory
(
    fld_CategoryID            int not null
        primary key,
    fld_CategoryType          varchar(30),
    fld_CategoryPrice         decimal,
    fld_CategorySeasonalPrice decimal
)
go

create table tbl_Camper
(
    fld_CamperID           int not null
        primary key,
    fld_CamperType         varchar(30)
        references tbl_CamperType,
    fld_CategoryID         int
        references tbl_PriceCategory,
    fld_FullTankStatus     varchar(10),
    fld_CamperRegisterYear date
)
go

create table tbl_Rental
(
    fld_RentalID              int not null
        primary key,
    fld_RentalAmount          decimal(10),
    fld_RentalPeriodStartDate date,
    fld_RentalPeriodEndDate   date,
    fld_Deposit               decimal(10),
    fld_DepositStatue         varchar(30),
    fld_Remaining             decimal(10),
    fld_RemainingStatue       varchar(30)
)
go

create table tbl_Payment
(
    fld_PaymentID_          int not null
        primary key,
    fld_OrderID             int
        references tbl_BookingReservation,
    fld_ClientID            int
        references tbl_CLIENT (fld_ClientID),
    fld_RentalID            int
        references tbl_Rental,
    fld_InsuranceID         int
        references tbl_Insurance,
    fld_InvoiceID           int
        references tbl_Invoice,
    fld_PaymentOvertimeDate date,
    fld_PaymentCancelDate   date
)
go


