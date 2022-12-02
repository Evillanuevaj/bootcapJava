package com.bootcamp.java.client.domain;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//genera get y set
@Builder//
@ToString//permite generar to String
@EqualsAndHashCode(of = {"identityNumber"})//permite comparacion
@AllArgsConstructor//constructor vacio con todas las propiedades
@NoArgsConstructor//
@Document(value = "client")

public class Client {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)//valores unicos
    private String identityNumber;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String businessName;
    @NotNull
    @Indexed(unique = true)
    private String email;
    @NotNull
    @Indexed(unique = true)
    private String phoneNumber;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private String type;
}
