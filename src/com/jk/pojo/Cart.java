package com.jk.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xwj157
 * @create 2020-08-15 15:54
 */
public class Cart {
//    private Integer totalCount;
//    private Double totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if(item == null){
            items.put(cartItem.getId(),cartItem);
        }else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice() * ( new Double( item.getCount() ) ) );
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice() * ( new Double( cartItem.getCount() ) ) );
        }
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry :items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public Double getTotalPrice() {
        Double totalPrice = new Double(0);
        for(Map.Entry<Integer,CartItem> entry :items.entrySet()){
            totalPrice += entry.getValue().getTotalPrice();
        }
        return totalPrice;
    }


    public Map<Integer,CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer,CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


}
