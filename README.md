# NashTech_Assignment1
NashTech - The Rookie Program - Assignment 1 - Nguyễn Phạm Thanh Vy

[NOTE] localhost port: 8081
- get all users: GET http://localhost:8081/api/employees
- get user by ID: GET http://localhost:8081/api/employees/{userID}
- get user by email: GET http://localhost:8081/api/employees/email/{userEmail}
- create new user: POST http://localhost:8081/api/employees
                      body: {
                              "name": "Employee name", 
                              "email": "employee_email@gmail.com",
                              "role": "Employee role"
                            }
- delete user by ID: DELETE http://localhost:8081/api/employees/{userID}
- update user information: PUT http://localhost:8081/api/employees/{userID}?name={newname}&email={newemail}&role={newrole}  (optional)
