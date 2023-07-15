document.getElementById('deleteContactForm').addEventListener('submit', function(event) {
    event.preventDefault();
  
    // Get form value
    const contactId = document.getElementById('deleteContactId').value;
  
    // Send a DELETE request to delete the contact
    fetch(`http://localhost:8080/contacts/detele/contact/${contactId}`, {
      method: 'DELETE'
    })
    .then(response => response.json())
    .then(data => {
      console.log('Contact deleted:', data);
      // Handle success
    })
    .catch(error => {
      console.error('Error deleting contact:', error);
    
    });
  });