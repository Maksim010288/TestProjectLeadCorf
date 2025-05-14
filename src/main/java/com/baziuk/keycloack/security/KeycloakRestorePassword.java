package com.baziuk.keycloack.security;

import jakarta.mail.Quota;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KeycloakRestorePassword {
    public static void main(String[] args) {
        // Параметри доступу
        String serverUrl = "http://localhost:8084"; // або ваш Keycloak URL
        String realm = "keycloak_realm";
        String clientId = "keycloak_client";
        String adminUsername = "admin";
        String adminPassword = "admin";

        // Користувач, якому треба скинути пароль
        String userEmail = "mysik.bazyk@gmail.com";

        // Ініціалізація Keycloak admin client
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(adminUsername)
                .password(adminPassword)
                .clientId(clientId)
                .build();

        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        // Знайти користувача за email
        List<UserRepresentation> users = usersResource.search(null, null, null, userEmail, 0, 1);
        if (users.isEmpty()) {
            System.out.println("Користувача не знайдено.");
            return;
        }

//        String userId = users.get(0).getId();
//
//        // Відправити email для скидання пароля
//        try {
//            usersResource.get(userId).executeActionsEmail(List.of("UPDATE_PASSWORD"));
//        }catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }
    }
}
