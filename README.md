# Activité Pratique de synthèse (Contrôle) - Yassine LAMBARKI

- [x] Créer le micro-service customer-service qui permet de gérer les client
- [x] Créer le micro-service inventory-service qui permet de gérer les produits
- [x] Créer la Gateway Spring cloud Gateway
- [x] Configuration statique du système de routage
- [x] Créer l'annuaire Eureka Discrovery Service
- [x] Faire une configuration dynamique des routes de la gateway
- [x] Créer le service de facturation Billing-Service en utilisant Open Feign
- [x] Créer un client Web Angular (Clients, Produits, Factures)
- [x] Déployer le serveur keycloak :
- [x] Créer un Realm
- [x] Créer un client à sécuriser
- [x] Créer des utilisateurs
- [x] Créer des rôles
- [x] Affecter les rôles aux utilisateurs
- [x] Tester les différents modes d'authentification avec Postman en montrant les contenus de Access-Token, Refresh Token
- [x] Sécuriser les micro-services et le frontend angular en déployant les adaptateurs Keycloak 
- [x] Ajouter des Fonctionnalités supplémentaires de votre choix
- [x] Livrable : Un Repository Github contenant :
- [x] Le code sources de l'ensemble des micro-services et du frontend
- [x] Le rapport montrant les différentes étapes dans le fichier README.MD


### PRODUCT-SERVICE
````````
http://localhost:8888/PRODUCT-SERVICE/products
````````

![products](/images/products.jpg)


### CUSTOMER-SERVICE
````````
http://localhost:8888/CUSTOMER-SERVICE/customers
````````

![products](/images/customers.jpg)

### ORDER-SERVICE
````````
http://localhost:8888/ORDER-SERVICE/orders
````````
![orders](/images/orders-spring.jpg)




### Eureka
````````
http://localhost:8761/
````````

![products](/images/eureka.jpg)


### Billing-service
````````
http://localhost:8888/BILLING-SERVICE/fullBill/1
````````

![billing-service](/images/BILLING-SERVICE.jpg)


### Full-order
````````
http://localhost:8888/ORDER-SERVICE/fullOrder/1
````````

![full-order](/images/fullorder-spring.jpg)

### Full-customer
````````
http://localhost:8888/CUSTOMER-SERVICE/customers?projection=fullCustomer
````````
![full-customer](/images/fullcustomer-spring.jpg)

### Search Order By Customer Id
````````
http://localhost:8888/ORDER-SERVICE/orders/search/byCustomerId?customerId=1&projection=fullOrder
````````
![full-customer](/images/search%20order%20by%20customerid.jpg)


### Full Product
````````
http://localhost:8888/PRODUCT-SERVICE/products?projection=fullProduct
````````
![full-product](/images/fullProduct.jpg)


### Partie front end Angular 👉 [link](https://github.com/softengyas/controle/tree/angular_front_end_project)
````````
http://localhost:4200/
````````

### Products
 ````````
 http://localhost:4200/products
````````
![products](/images/angular-products.jpg)



### Customers
 ````````
 http://localhost:4200/customers
````````
![products](/images/customers-angular.jpg)


### Order Details
 ````````
http://localhost:4200/order-details/5
````````
![order-details](/images/order-details-angular.jpg)

### keycloak 


### ✔start dev
 ````````
http://localhost:8080/
````````
![keycloak](/images/keycloak.jpg)

![keycloak-admin](/images/admin_kc.jpg)


### ✔Realm (invoice-realm)
 ````````
http://localhost:8080/admin/master/console/#/invoice-realm
````````
![keycloak-admin](/images/realm.jpg)

### ✔client à sécuriser (invoice-client) 

````````
http://localhost:8080/admin/master/console/#/invoice-realm/clients
````````
![keycloak-clt](/images/client-sec-kc.jpg)


### ✔Créer des utilisateurs(user1/yassine)

````````
http://localhost:8080/admin/master/console/#/invoice-realm/users
````````
![keycloak-clt](/images/users-kc.jpg)

### ✔Créer des Roles(USER/ADMIN)

````````
http://localhost:8080/admin/master/console/#/invoice-realm/roles
````````
![keycloak-clt](/images/ROLES-KC.jpg)

### ✔Affecter les rôles aux utilisateurs(USER/ADMIN)

````````
http://localhost:8080/admin/master/console/#/invoice-realm/users/XXXXXXX-d07c-4e88-b479-b2439c3c8c48/role-mapping
````````
![keycloak-ADMIN](/images/USERADMINROLE-KC.jpg)
![keycloak-USER](/images/ROLEUSER-KC.jpg)


### ✔Tester les différents modes d'authentification avec Postman en montrant les contenus

#### ✅openid-configuration
````````
http://localhost:8080/realms/invoice-realm/.well-known/openid-configuration
````````

![keycloak-OPENID](/images/OPENID-KC.jpg)

#### ✅Postman (POST)

````````
http://localhost:8080/realms/invoice-realm/protocol/openid-connect/token
````````

![keycloak-postman](/images/postman-kc.jpg)

![keycloak-accessToken](/images/accesstoken-kc.jpg)

![keycloak-jwt](/images/jwt.png)

















