/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.model;

/**
 *
 * @author admin!
 */
public class ChiDoan {
    private String id;
    private String ten_chi_doan;
    private String mo_ta;
   public ChiDoan(){
       
   }

    public ChiDoan(String id, String ten_chi_doan, String mo_ta) {
        this.id = id;
        this.ten_chi_doan = ten_chi_doan;
        this.mo_ta = mo_ta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen_chi_doan() {
        return ten_chi_doan;
    }

    public void setTen_chi_doan(String ten_chi_doan) {
        this.ten_chi_doan = ten_chi_doan;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    @Override
    public String toString() {
        return "ChiDoan{" + "id=" + id + ", ten_chi_doan=" + ten_chi_doan + ", mo_ta=" + mo_ta + '}';
    }
   
}
