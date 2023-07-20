# Java War Management System

This GitHub repository contains a Java project for a Inventory Management System. The system is designed to help Inventory managers efficiently manage their inventory and streamline various processes related to inventory management. It consists of multiple JFrames that are combined to form a comprehensive Inventory management solution.

## Features

- **Import Product Management**: The system allows users to manage invoices for incoming stock. Users can create, edit, and delete invoices, providing a clear overview of stock inflow.
- **Product Categories**: With this feature, users can categorize different types of products stored in the Inventory, making it easier to manage and locate items.
- **Inventory Statistics**: The system provides comprehensive statistics and reports on the Inventory's inventory, enabling managers to make data-driven decisions.

## Database

All data for the Java Inventory Management System is stored in a relational database. The database schema is defined in the accompanying SQL file (`DataBase.sql`), which can be imported to set up the required database structure.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Integrated Development Environment (IDE) like Eclipse or IntelliJ
- MySQL Database Server



## How to Use

1. **Clone the Repository**: Begin by cloning this repository to your local machine using the following command:

    `git clone https://github.com/your-username/Inventory-management.git`

2. Database Setup: Import the DataBase.sql file into your MySQL database to set up the necessary tables and data.

3. Open in IDE: Import the project into your preferred IDE (Eclipse, IntelliJ, etc.) as a Java project.

4. Configure Database Connection: In the DatabaseConfig.java file, update the database connection details to match your MySQL credentials.

5. Run the Application: Locate the main Java file (Main.java) and run it to start the Inventory Management System.

## Contribute
Contributions to the project are always welcome! If you find any issues or have ideas for improvements, feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments
We would like to thank all the contributors and developers who have contributed to the development of this Inventory Management System.
