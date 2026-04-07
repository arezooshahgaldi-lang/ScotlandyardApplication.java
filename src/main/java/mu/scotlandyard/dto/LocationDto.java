package mu.scotlandyard.dto;

import mu.scotlandyard.enoms.LocationType;

public class LocationDto {
    private Integer id;
    private String name;
    private LocationType type;

    public LocationDto(Integer id, String name,LocationType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }
}
