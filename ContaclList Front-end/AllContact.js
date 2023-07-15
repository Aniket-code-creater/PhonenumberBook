// Retrieve all contacts and display them
const contactsList = document.getElementById('contacts');


fetch('http://localhost:8080/contacts/allcontacts')
  .then(response => response.json())
  .then(data => {
    const contactsList = document.getElementById('contacts');
    data.forEach(contact => {
      const listItem = document.createElement('li');
      listItem.textContent = `${contact.firstName} ${contact.lastName} (${contact.email}): ${contact.phoneNumbers.join(', ')}`;
      contactsList.appendChild(listItem);
    });
  })
  .catch(error => {
    console.error('Error retrieving contacts:', error);
    
  });