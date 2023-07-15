# ContactList
#### This is a Contacts Application that allows you to manage contacts like the one in your phone. It provides functionality to create, update, search, and delete contacts. The backend is implemented using Spring Boot and the frontend is implemented using HTML, CSS, and JavaScript.
## Features
#### Able to input first name, last name, email, and multiple phone numbers.
#### Able to search contacts by name.
#### Able to search contacts by phone number.
#### Able to update first name, last name, email, and phone numbers.
#### Able to add more phone numbers or delete existing ones.


## Backend APIs
The following backend APIs are provided:

### 1. POST /contacts/createcontact - Create a contact.
### 2. GET /contacts/findById/{id} - Get a contact by contact ID.
### 3. GET /contacts/search/name/{firstname} - Search contacts by first name.
### 4. GET /contacts/search/number/{phoneNumber} - Search contacts by phone number.
### 5. GET /contacts/allcontacts - Get all contacts.
### 6. POST /contacts/update/{id} - Update a contact by contact ID.
### 7. POST /contacts/add/newnumber/{id} - Add a new phone number to an existing contact.
### 8. DELETE /contacts/delete/one/number/{id} - Delete a specific phone number from a contact.
### 9. DELETE /contacts/delete/contact/{id} - Delete a contact by contact ID.
