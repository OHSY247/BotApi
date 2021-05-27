package github.botapi.main.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "main.tb_test")
public class MainTestDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "key")
    private String key;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

}
