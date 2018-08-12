package com.practise.invoice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ItemList {
   private Set<String> medicalItemList=new HashSet<String>(){
       {
           add("headache pills");
           add("bandage");
       }
   };

    public Set<String> getMedicalItemList() {
        return medicalItemList;
    }

    public void setMedicalItemList(Set<String> medicalItemList) {
        this.medicalItemList = medicalItemList;
    }
}
