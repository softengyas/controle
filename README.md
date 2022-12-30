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


### products
````````
http://localhost:8888/PRODUCT-SERVICE/products
````````

![products](/images/products.jpg)


### Customers
````````
http://localhost:8888/CUSTOMER-SERVICE/customers
````````

### Orders
````````
http://localhost:8888/ORDER-SERVICE/orders
````````


![products](/images/customers.jpg)


### Eureka
````````
http://localhost:8761/
````````

![products](/images/eureka.jpg)


### Customer-service
````
http://localhost:8888/CUSTOMER-SERVICE/customers
````

![customer-service](images/customer-service.png)


### Billing-service
````````
http://localhost:8888/BILLING-SERVICE/fullBill/1
````````

![billing-service](/images/BILLING-SERVICE.jpg)


### Order-service

````````
http://localhost:8888/ORDER-SERVICE/fullOrder/1
````````

![order-service](/images/order-service.png)




### Partie front end Angular 👉 
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








