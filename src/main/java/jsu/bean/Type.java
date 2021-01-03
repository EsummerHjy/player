package jsu.bean;

public class Type {
    private Integer typeId;
    private Integer typeName;

    public Type() {
    }

    public Type(Integer typeId, Integer typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeName() {
        return typeName;
    }

    public void setTypeName(Integer typeName) {
        this.typeName = typeName;
    }
}
