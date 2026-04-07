Software requirements: \
Windows 10/11, \
JDK 17 or higher, \
Maven 3.9.9 or higher

After cloning the repository, run the Run.cmd file, witch will start the Spring-boot plugin.

The database (SQLite) is represented by the storage.db, if it is deleted before start, the application will automatically recreate it, but will be empty.

The application uses the default port: 8080 \
Endpoints:
http://localhost:8080/Library/Books: \
GET endpoint: Responds with the list of books in JSON format. \
POST endpoint: Requires JSON body { id, name } and stores it in the database. \
http://localhost:8080/Library/Borrower: \
GET endpoint: Requires JSON body with only one ID { id }, and responds with the data of the person if present in the database. \
POST endpoint: Requires JSON body { id, name, age } and stores it in the database. \
http://localhost:8080/Library/Borrowing:
GET endpoint: Requires JSON body with only one person's ID { id } and responds with the list of books the person borrowed.\
POST endpoint: Requires JSON body { bookId, borrowerId } and stores it in the database. This represents the borrowed books.\
