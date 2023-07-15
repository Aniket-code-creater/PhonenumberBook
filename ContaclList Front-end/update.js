document.getElementById('updateContactForm').addEventListener('submit', function(event) {
    event.preventDefault();
  
    // Get form values
    const contactId = document.getElementById('updateContactId').value;
    const updatedFirstName = document.getElementById('updatedFirstName').value;
    const updatedLastName = document.getElementById('updatedLastName').value;
    const updatedEmail = document.getElementById('updatedEmail').value;
    const updatedPhoneNumbers = document.getElementById('updatedPhoneNumbers').value.split(',');
  
    // Create updated contact object
    const updatedContact = {
      id: contactId,
      firstName: updatedFirstName,
      lastName: updatedLastName,
      email: updatedEmail,
      phoneNumbers: updatedPhoneNumbers
    };
  
    // Send a PUT request to update the contact
    
    fetch(`http://localhost:8080/contacts/update/${contactId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(updatedContact)
    })
    .then(response => response.json())
    .then(data => {
      console.log('Contact updated:', data);
     
    })
    .catch(error => {
      console.error('Error updating contact:', error);
      
    });
  });