Step-by-Step Approach:
Fork and Clone the Repository:

Fork the repository from the given URL.
Clone it to your local machine.
Install Required Libraries:

Ensure pandas and sqlite3 are installed.
Run pip install pandas if necessary.
Read Data from Spreadsheets:

Use pandas.read_excel() to read each spreadsheet.
Connect to the SQLite Database:

Use sqlite3 to establish a connection.
Munge and Prepare the Data:

Process spreadsheet 0 and insert it directly.
Merge spreadsheets 1 and 2 on shipping identifier to combine data.
Extract required fields for inserting into the Shipment and other relevant tables.
Insert Data into the Database:

Use cursor.executemany() with parameterized queries to insert data efficiently.
Sample Python Script:
Here's a simplified script template to illustrate how you might start this process:

Populate Sqlite Db
Notes:
Modify the INSERT INTO SQL statements to match your actual table schema.
Ensure the data types and column names in spreadsheet_0, spreadsheet_1, and spreadsheet_2 align with your database schema.
code:- 

import pandas as pd
import sqlite3

# Connect to SQLite database
db_connection = sqlite3.connect('walmart.db')
cursor = db_connection.cursor()

# Read spreadsheets
spreadsheet_0 = pd.read_excel('spreadsheet_0.xlsx')
spreadsheet_1 = pd.read_excel('spreadsheet_1.xlsx')
spreadsheet_2 = pd.read_excel('spreadsheet_2.xlsx')

# Insert data from spreadsheet 0 directly
for _, row in spreadsheet_0.iterrows():
    cursor.execute('''INSERT INTO TableName_0 (column1, column2, ...) VALUES (?, ?, ...)''',
                   (row['column1'], row['column2'], ...))

# Combine spreadsheets 1 and 2 based on the shipping identifier
merged_df = pd.merge(spreadsheet_1, spreadsheet_2, on='shipping_identifier')

# Process each row for the Shipment table
for _, row in merged_df.iterrows():
    cursor.execute('''INSERT INTO Shipment (shipment_id, origin_id, destination_id, product_id, quantity) 
                      VALUES (1, 2, 3, 4, 5)''',
                   (row['shipment_id'], row['origin_id'], row['destination_id'], row['product_id'], row['quantity']))

# Commit changes and close the connection
db_connection.commit()
db_connection.close()

print("Data has been successfully inserted into the database.")
