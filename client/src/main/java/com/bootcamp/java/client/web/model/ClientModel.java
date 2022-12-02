package com.bootcamp.java.client.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    @JsonIgnore
    private String id;

    @NotBlank(message="Identity Number cannot be null or empty")
    //@JsonProperty("DNI")
    private String identityNumber;

    @NotBlank(message="Name cannot be null or empty")
    private String name;

    @NotBlank(message="LastName cannot be null or empty")
    private String lastName;

    @NotBlank(message="BusinessName cannot be null or empty")
    private String businessName;

    @NotBlank(message="Email cannot be null or empty")
    private String email;

    @NotBlank(message="PhoneNumber cannot be null or empty")
    //@JsonProperty("NUmeroDeTelefono")
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message="Type cannot be null or empty")
    private String type;
}
