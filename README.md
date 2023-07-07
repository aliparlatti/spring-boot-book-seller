# Spring Boot Book Seller

### Sign-Up

/api/authentication/sign-up

**JSON**
{
"name":"user",
"username":"user",
"password":"user"
}

### Sign-In

/api/authentication/sign-in

**JSON**
{
"username":"user",
"password":"user"
}

### Make-Admin

PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey1234!