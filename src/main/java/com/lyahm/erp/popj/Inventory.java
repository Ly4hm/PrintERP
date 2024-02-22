package com.lyahm.erp.popj;


@SuppressWarnings("unused")
public class Inventory {

    private Integer material_id;
    private String material_name;
    private String specification;
    private long quantity;

    public Inventory() {
    }

    public Inventory(Integer material_id, String material_name, String specification, long quantity) {
        this.material_id = material_id;
        this.material_name = material_name;
        this.specification = specification;
        this.quantity = quantity;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }


    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}
