package github.botapi.destiny2.model;

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
@Table(name = "main.DestinyHistoricalStatsDefinition")
public class DestinyHistoricalStatsDefinitionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "key", nullable = false)
    private String key;

    @Column(name = "json")
    private byte[] json = null;

}
