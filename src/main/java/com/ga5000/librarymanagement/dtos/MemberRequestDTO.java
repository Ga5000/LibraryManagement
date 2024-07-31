package com.ga5000.librarymanagement.dtos;

import java.util.Date;

public record MemberRequestDTO(String firstName, String lastName, Date dateOfBirth, String address, String phoneNumber,
                               String email) {}
