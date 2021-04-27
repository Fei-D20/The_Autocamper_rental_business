Class: D20
Semester: 2. semester
Time period (work): Week 17 – 18 , 2021 Subjects: System development (UP), Databases and Programming
Important milestones:
This assignment handed out: Friday April 23rd
Report hand-in: Friday May 7thAt 15.00.
Presentation/Oral Feedback: Tuesday/Thursday May 11/13(20 min per group).





# The Case

- the administration of their auto camper rental business

# Requirements for your solution

1. The main purpose of the project is to get some training within these areas:
   - Organizing your work activities according to Unified Process.
   - Object modeling (object design)
   - Database modeling, JDBC, stored procedures.
2. Our main goal should NOT be to make a complete system – by doing it the ”quick-and-dirty” way.
3. The system development method must be UP with documentation in UML.
4. The database used in the project must be SQL Server.
5. We expect these artifacts to be present and explained in the report:
   - Use Cases (only one fully dressed).
   - Domain Model.
   - Data Model (ERD)
   - Data Dictionary. 
   - SSDs : At least one Sequence-diagram.
   - The Architecture (layered) in a diagram.
   - The (final) Design Class Diagram.
6. Also explain how patterns are applied shortly – for example GRASP, Singleton, Dao, Strategy but always discuss a pattern together with a code example from with-in the project!
7. The programming language must be Java – here it is important that you have ”waterproof” consistency between your UML artifacts (documentations behind the code) and the Java code itself.
8. Furthermore: The UI should be simple JavaFX, and at least two methods must be Unit-tested.



# Hand-ins:

- You must use moodle to hand in the report (approx. 10 pages)

- source code (also database queries, stored procedures etc.)

- UP artefacts.

  > See the document: guidelines for report writing.pdf

- Finally, you must prepare and make a short presentation (PowerPoint) of the designed solution – this must be ready for the 11th of May.





# Time scheduel

| Monday(26th) | 27th            | 28th | 29th                          | 30th | 1st         | 2nd  | 3rd  | 4th         | 5th  |
| ------------ | --------------- | ---- | ----------------------------- | ---- | ----------- | ---- | ---- | ----------- | ---- |
| Vision       | Data Dictionary |      | SSDs                          | DCD  | Coding part |      |      | Report part |      |
| Use case     | ERD             |      | Architecture(tommy’s week 09) |      |             |      |      |             |      |
|              |                 |      |                               |      |             |      |      |             |      |





# Unify process

| Inception               | Elaboration       | Construction          | Transition |
| ----------------------- | ----------------- | --------------------- | ---------- |
| Feasibility study       |                   | Program the functions | Test       |
| - Decision Stop or Go   | Refile the vision | Create a user         | Deploy     |
| - Estimations           | Core architecture |                       |            |
| - vision                | Use case          |                       |            |
| - Environment           |                   |                       |            |
| - choose language :java |                   |                       |            |



#### Feasibility study 可行性研究

* Decision Stop or Go
* Estimations 预估 ( how many resourse we have )
* Vision ( a short sentance to say what we are building / a pic for the programming , functional word , becareful do not use the contents which you can never finish it. )
* Environment 
* Programming laugage choice









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



