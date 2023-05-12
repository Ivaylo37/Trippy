# The project includes the following key functionalities:

1. Creating Users: Users can be created in the system, and each user is unique based on their username.

2. Creating Businesses: Businesses can be created in the system, and each business is unique based on its name and the city it is located in.

3. Leaving Reviews: Users can leave reviews for specific businesses. A user can leave multiple reviews for different businesses, but only one review per user is allowed for each business.

4. Showing Users: The system provides the capability to retrieve user information. Users can be displayed in different ways:
- All Users: Retrieves information about all users in the system.
- By Email: Retrieves user information based on their email address.
- By Username: Retrieves user information based on their username.
- By ID: Retrieves user information based on their unique identifier.

5. Showing Businesses: The system allows retrieval of business information. Businesses can be displayed in different ways:
- All Businesses: Retrieves information about all businesses in the system.
- By Type: Retrieves businesses based on their type (e.g., restaurant, retail, etc.).
- By City: Retrieves businesses based on the city they are located in.
- By Rating: Retrieves businesses based on their rating (e.g., highest rated businesses).

6. Showing Reviews: The system provides the functionality to display all reviews available in the system. Reviews can be displayed in the following ways:

- All Reviews: Retrieves information about all reviews in the system.
- By ID: Retrieves review information based on its unique identifier.

7. Editing Business Contact Info: The system allows editing of business contact information, such as email or phone number. This functionality enables businesses to update their contact details as needed.

# Technologies Used
The project is built using the following technologies:

Programming Language: Java
Database: PostgreSQL
Frameworks/Libraries: Spring

# Setup and Usage
To set up and run the project locally, follow these steps:

Clone the repository: git clone https://github.com/Ivaylo37/trippy.git.
Install any required dependencies specified in the project.
Configure the database connection and credentials in the project's configuration files.
You can find the queries used to create the tables in the DBsetup file.
Build and run the project according to the provided instructions.

### Not implemented
1.The rating that is shown for the business, must be /10  
2.Only the author to be able to edit the review  
3.24% test coverage  