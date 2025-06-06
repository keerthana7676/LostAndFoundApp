package com.example.found;

public class LostItem {
    String itemName, location, description, contact, itemType;

    public LostItem(String itemName, String location, String description, String contact, String itemType) {
        this.itemName = itemName;
        this.location = location;
        this.description = description;
        this.contact = contact;
        this.itemType = itemType;
    }

    // You can also add getters if needed
    public String getItemName() { return itemName; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getContact() { return contact; }
    public String getItemType() { return itemType; }
}
