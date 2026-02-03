package ec.ecu.ups.icc.employees.core.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active", nullable = false, length = 1)
    private Character Active = 'S';

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getIsActive() {
        return Active;
    }

    public void setIsActive(Character Active) {
        this.Active = Active;
    }


}
