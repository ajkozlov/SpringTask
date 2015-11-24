package ru.av.entities;


public class BasketItem {
    private Item item;
    private Integer count;

    public BasketItem(Item item) {
        this.item = item;
        this.count = 1;
    }

    public BasketItem(Item item, Integer count) {
        this.item = item;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public Double getSum(){
        return Math.round(this.item.getPrice() * this.count * 100d)/100d;
    }

    public boolean itemEquals(Item item){
        return this.item.getId().equals(item.getId());
    }

    public void addCount(){
        if(this.item.getQuantity() > this.count) {
            this.count++;
        }
    }

    public String getItemTitle(){
        return item.getTitle();
    }

    public Item getItem() {
        return item;
    }
}
