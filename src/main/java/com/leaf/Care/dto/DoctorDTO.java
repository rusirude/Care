package com.leaf.Care.dto;

import java.util.Objects;

/**
 * @author : Rusiru on 21-Jul-19.
 */
public class DoctorDTO {

    private Long id;
    private String name;
    private String contactNo;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoctorDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", contactNo='").append(contactNo).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDTO doctorDTO = (DoctorDTO) o;
        return Objects.equals(id, doctorDTO.id) &&
                Objects.equals(name, doctorDTO.name) &&
                Objects.equals(contactNo, doctorDTO.contactNo) &&
                Objects.equals(email, doctorDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactNo, email);
    }
}
