------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE : Stanley’s Storage
VERSION or DATE: Final Version
AUTHORS: Ajar Duishembieva

PURPOSE OF PROJECT: 
1.1. Stanley’s Storage offers storage units to rent. Locations are dotted around the Northwest. Write supplier code to help Stanley manage his locations, customers, and storage units.
1.2 Storage Locations
Stanley’s Storage locations are identified by a unique name that has two upper-case letters indicating the state, followed by two digits representing the location number within the state, followed by the city name. Examples are “WA23Issaquah” and “OR02Ashland”. Each location is identical in layout, having 12 rows, each with 20 storage units.
1.3 Storage Units
Units are one of three types: standard, humidity controlled, and temperature controlled. Attributes of interest include the unit’s width, length, and height, and the unit’s standard price. Rented units have a customer associated with them2 as well as a price at which they were rented (which may be different from the standard price).
1.4 Customers
Each location manages its own list of customers. Start with room for 100 customers3. For each customer Stanley’s maintains a name, phone number, and account balance.

2 Client Code Requirements
Client code must be able to…
2.1 Storage Locations
• Retrieve the storage location’s designation
• Retrieve a storage unit4 by index
• Add a customer to the list; retrieve a customer by index; retrieve a count of customers
• Retrieve an array of storage units rented to a specified customer. Retrieve an array of all empty (unrented) storage units, or empty units of a specified type5
• Charge monthly rent (charge customers for each unit they are renting, increasing their balance)

2.2 Storage Units
• Retrieve each attribute. Price retrieved should be rented or standard price, whichever is applicable
• Retrieve the rental start date6
• Retrieve the customer associated with the unit7
• Rent the unit to a specified customer, on a specified date
• Release the unit (make it “unrented”)
2.3 Customers
• Retrieve each attribute; update the customer’s name or phone number
• Charge the customer a specified amount, or credit them a specified amount

3 Design Documentation
Before you code, create appropriate design documentation and obtain feedback. Update designs per feedback, then use them during the rest of the development process and submit them as part of your project. For OOP projects, this will always include UML Class Diagram(s) and UML Object Diagrams; on some projects, additional documentation will be required. Recommended tool: Violet, which creates both diagram types (and others).

4 Code Implementation
4.1 Building Blocks You’ll Need
• Classes and objects
• “Has a” relationships
• Arrays (2D)8
• Enumerated types
4.2 Preconditions
Establish preconditions for the following cases, throwing appropriate exceptions (with helpful and informative messages) when the preconditions are violated:
• Storage location designations must fit the specified pattern discussed above.
• Storage unit lengths and widths are always multiples of four; heights, multiples of two. Dimensions must be positive numbers greater than zero.
• Customer charges and credits must be non-negative.
• Add other preconditions that make sense and are critical to the proper operation of the objects. Consider, for example, important strings that shouldn’t be null or empty, and object references that shouldn’t be null.
• You should not throw exceptions in cases where parameter values would cause runtime errors that would be clearly understandable to client coders, e.g., array out of bounds.

4.3 Other Requirements
• Store all storage units a single, regular (rectangular) 2D array.
• Create all storage units, and fill in their attributes, when the storage location is created; don’t postpone unit creation. Make the sizes and prices whatever you want, for now.
• Unless you’re doing something special, you should create no static methods or variables. Static constants are fine, if you need them.
• Use no class-level public variables. Class-level public constants are okay.
• Use method exposure (public and private) wisely; expose what Client code needs, hide internal-use methods. There’s a third access modifier (protected), but you should never use it in this course.
• This is supplier code; no main method is part of the model. But do create one to show off the project’s capabilities, however (e.g., far-reaching navigation and toString results).
• Create an enumerated type for storing the unit type.
• Write a toString method for each class. Include all data helpful in describing the object’s state. For containers, include the contained, as well, and ensure the resulting strings look good when displayed.
• Within the created classes, do not converse with the user; there should be no input or output. It is okay for methods to return strings that will be used from client code, however, and to include exception messages which will be seen if client code breaks the rules and misuses your class. Main can converse with the user, of course.

4.4 Style
Follow the Course Style Guide, which is linked in the Reference section of the Modules list in Canvas.
5 Testing
Create a JUnit test class for each production class. Ensure that each method and all state is fully tested. This must include constructors, accessors, mutators, and preconditions. You do not need to test UI-heavy methods like toString and similar.
Don’t overload test methods. Test a few related methods together, perhaps (like the full constructor and related accessors); this way, failure reports can pinpoint what failed. Test one precondition (for one method) at a time; the first triggered exception bails out of the method, so subsequent tests are untested.

User Instructions:

1. Download the repository files (project) from the download section 
2. Import it in Intellij or any other Java IDE
3. Run the application




