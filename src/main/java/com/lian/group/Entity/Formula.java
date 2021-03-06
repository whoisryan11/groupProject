package com.lian.group.Entity;

import javax.persistence.*;

@Entity
@Table(name = "formula")
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cost_code")
    private Integer costCode;

    @Column(name = "item_id")
    private Integer itemId;

    //changed the mysql type varchar(45) to enumerable/tinyint
    @Column(name = "editable")
    private boolean editable;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "project_id")
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostCode() {
        return costCode;
    }

    public void setCostCode(Integer costCode) {
        this.costCode = costCode;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Formula() {
    }

    public Formula(Integer costCode, Integer itemId, boolean editable) {
        this.costCode = costCode;
        this.itemId = itemId;
        this.editable = editable;
    }
}
