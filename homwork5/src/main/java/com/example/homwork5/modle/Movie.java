package com.example.homwork5.modle;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.tomcat.jni.Time;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;
import java.security.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Movie {
    @Id
    @NotNull(message = "id required")
    //@Size(min = 3)
    @Min(3)
    @Column(unique = true)
    private Integer id;

    @NotEmpty(message = "name is required")
    @Size(min = 2)
    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = "( Drama | Action | Comedy )")
    private String genre;

    @NotEmpty(message = "rating is require")
    @Digits(integer = 5,fraction = 0)
    @Positive
    @Range(min = 1,max =5 ,message = "must be between 1 - 5")
    private String rating;

    @NotNull(message = "duration is required")
    @Digits(integer = 5,fraction = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern= "mmm")
    @Min(60)
    private Integer duration;

    @NotNull(message = "launchDate is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date launchDate ;

}
