The application is a point-of-sale tool for a store. It helps with renting out tools.

1. **Controller:** Simple with one API which has Jakarta Valid option at the API definition and it has one Service Call to process the Rental Reservation.
    The Post API is defined in such a way that the payload is validated at the entity and appropriate errors would be thrown at the input parsing itself.
2. **Exception Handler:** There is a Global Exception Handler which handles errors and returns the nicely formatted errors. 
3. **Entities:** There are four Entities, each one has its purpose.
   
     a. Tools: Entity for available Tools
   
     b. ToolType: The ToolType entity specifies the daily rental charge, and the days for which the daily rental charge applies.

     c. Request: Request entity for receiving input PayLoad from point-of-sale UI. It has validation built in it.  

     d. Response: Rensponses entity returns back to the caller
5. **Service:** It has most of the heavy lifting and acts as the orchestrator for the reservation. It makes necessary utils class calls and get the job done.
6. **Utils:** There are four Utils, each one with its own purpose

     a. DateOperations: Responsible for most of the date related operations. This is a bit complex to figure out charge days weekday / weekend / holiday configurations.

     b. PrintOperations: Response for printing formatted response in the console.

     c. ToolsCache: This creates a one time cache of all the Tools available for renting and this could make the DB calls when necessary. 

     d. ToolTypeCache: This creates a one time cache for all the Tool Type based pricing and its respective configurations. This could make the DB calls when necessary as well. 
