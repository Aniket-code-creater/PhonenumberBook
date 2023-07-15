document.getElementById('createContactForm').addEventListener('submit', function(event) {
    event.preventDefault();
  
    // Get form values
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const phoneNumbers = document.getElementById('phoneNumbers').value.split(',');
  
    // Create contact object
    const contact = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      phone_numbers: phoneNumbers
    };
  
    // Send a POST request to create a contact
    
    fetch('http://localhost:8080/contacts/createcontact', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(contact)
    })
    .then(response => response.json())
    .then(data => {
        alert(
            "Contact Created successfully"
        )
      console.log('Contact created:', data);
      
    })
    .catch(error => {
        alert(
            "Contact Number already Present in the list"
        )
      console.error('Error creating contact:', error);
     
    });
  });