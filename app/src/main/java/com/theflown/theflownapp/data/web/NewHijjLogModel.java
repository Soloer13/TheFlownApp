package com.theflown.theflownapp.data.web;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewHijjLogModel {

    @SerializedName("id")
    @Expose
    private int id;

    //Pressure
    @SerializedName("MMFIn")
    @Expose
    private float MMFIn;

    @SerializedName("MMFOut")
    @Expose
    private float MMFOut;

    @SerializedName("bagIn")
    @Expose
    private float bagIn;

    @SerializedName("bagOut")
    @Expose
    private float bagOut;

    @SerializedName("cartridgeIn")
    @Expose
    private float cartridgeIn;

    @SerializedName("cartridgeOut")
    @Expose
    private float cartridgeOut;

    @SerializedName("RO1stIn")
    @Expose
    private float RO1stIn;

    @SerializedName("RO1stOut")
    @Expose
    private float RO1stOut;

    @SerializedName("RO2ndIn")
    @Expose
    private float RO2ndIn;

    @SerializedName("RO2ndOut")
    @Expose
    private float RO2ndOut;

    @SerializedName("PXBackPressure")
    @Expose
    private float PXBackPressure;


    //Flow
    @SerializedName("feedFlow")
    @Expose
    private float feedFlow;

    @SerializedName("HPPFeed")
    @Expose
    private float HPPFeed;

    @SerializedName("PXFeed")
    @Expose
    private float PXFeed;

    @SerializedName("feed1stpass")
    @Expose
    private float feed1stpass;

    @SerializedName("feed2ndpass")
    @Expose
    private float feed2ndpass;

    @SerializedName("product1stpass")
    @Expose
    private float product1stpass;

    @SerializedName("product2ndpass")
    @Expose
    private float product2ndpass;


    //volt & amps
    @SerializedName("voltage")
    @Expose
    private float voltage;

    @SerializedName("wellpump1")
    @Expose
    private float wellpump1;

    @SerializedName("wellpump2")
    @Expose
    private float wellpump2;

    @SerializedName("wellpump3")
    @Expose
    private float wellpump3;

    @SerializedName("wellpump4")
    @Expose
    private float wellpump4;

    @SerializedName("wellpump5")
    @Expose
    private float wellpump5;

    @SerializedName("filtratedPump")
    @Expose
    private float filtratedPump;

    @SerializedName("HPP1")
    @Expose
    private float HPP1;

    @SerializedName("HPP2")
    @Expose
    private float HPP2;

    @SerializedName("HPP3")
    @Expose
    private float HPP3;

    @SerializedName("BoosterPump")
    @Expose
    private float boosterPump;

    @SerializedName("HPP2ndPass")
    @Expose
    private float HPP2ndPass;

    @SerializedName("productPump")
    @Expose
    private float productPump;

    //Lap map
    @SerializedName("feedConductivity")
    @Expose
    private float feedCond;

    @SerializedName("productConductivity1")
    @Expose
    private float productCond1;

    @SerializedName("productConductivity2")
    @Expose
    private float productCond2;

    @SerializedName("finalCond")
    @Expose
    private float finalCond;

    @SerializedName("productPH")
    @Expose
    private float productPH;

    @SerializedName("feedPH")
    @Expose
    private float feedPH;

    @SerializedName("feedORP")
    @Expose
    private float feedORP;

    @SerializedName("feedTemp")
    @Expose
    private float feedTemp;

    @SerializedName("productChlorine")
    @Expose
    private float productChlorine;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMMFIn() {
        return MMFIn;
    }

    public void setMMFIn(float MMFIn) {
        this.MMFIn = MMFIn;
    }

    public float getMMFOut() {
        return MMFOut;
    }

    public void setMMFOut(float MMFOut) {
        this.MMFOut = MMFOut;
    }

    public float getBagIn() {
        return bagIn;
    }

    public void setBagIn(float bagIn) {
        this.bagIn = bagIn;
    }

    public float getBagOut() {
        return bagOut;
    }

    public void setBagOut(float bagOut) {
        this.bagOut = bagOut;
    }

    public float getCartridgeIn() {
        return cartridgeIn;
    }

    public void setCartridgeIn(float cartridgeIn) {
        this.cartridgeIn = cartridgeIn;
    }

    public float getCartridgeOut() {
        return cartridgeOut;
    }

    public void setCartridgeOut(float cartridgeOut) {
        this.cartridgeOut = cartridgeOut;
    }

    public float getRO1stIn() {
        return RO1stIn;
    }

    public void setRO1stIn(float RO1stIn) {
        this.RO1stIn = RO1stIn;
    }

    public float getRO1stOut() {
        return RO1stOut;
    }

    public void setRO1stOut(float RO1stOut) {
        this.RO1stOut = RO1stOut;
    }

    public float getRO2ndIn() {
        return RO2ndIn;
    }

    public void setRO2ndIn(float RO2ndIn) {
        this.RO2ndIn = RO2ndIn;
    }

    public float getRO2ndOut() {
        return RO2ndOut;
    }

    public void setRO2ndOut(float RO2ndOut) {
        this.RO2ndOut = RO2ndOut;
    }

    public float getPXBackPressure() {
        return PXBackPressure;
    }

    public void setPXBackPressure(float PXBackPressure) {
        this.PXBackPressure = PXBackPressure;
    }

    public float getFeedFlow() {
        return feedFlow;
    }

    public void setFeedFlow(float feedFlow) {
        this.feedFlow = feedFlow;
    }

    public float getHPPFeed() {
        return HPPFeed;
    }

    public void setHPPFeed(float HPPFeed) {
        this.HPPFeed = HPPFeed;
    }

    public float getPXFeed() {
        return PXFeed;
    }

    public void setPXFeed(float PXFeed) {
        this.PXFeed = PXFeed;
    }

    public float getFeed1stpass() {
        return feed1stpass;
    }

    public void setFeed1stpass(float feed1stpass) {
        this.feed1stpass = feed1stpass;
    }

    public float getFeed2ndpass() {
        return feed2ndpass;
    }

    public void setFeed2ndpass(float feed2ndpass) {
        this.feed2ndpass = feed2ndpass;
    }

    public float getProduct1stpass() {
        return product1stpass;
    }

    public void setProduct1stpass(float product1stpass) {
        this.product1stpass = product1stpass;
    }

    public float getProduct2ndpass() {
        return product2ndpass;
    }

    public void setProduct2ndpass(float product2ndpass) {
        this.product2ndpass = product2ndpass;
    }

    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public float getWellpump1() {
        return wellpump1;
    }

    public void setWellpump1(float wellpump1) {
        this.wellpump1 = wellpump1;
    }

    public float getWellpump2() {
        return wellpump2;
    }

    public void setWellpump2(float wellpump2) {
        this.wellpump2 = wellpump2;
    }

    public float getWellpump3() {
        return wellpump3;
    }

    public void setWellpump3(float wellpump3) {
        this.wellpump3 = wellpump3;
    }

    public float getWellpump4() {
        return wellpump4;
    }

    public void setWellpump4(float wellpump4) {
        this.wellpump4 = wellpump4;
    }

    public float getWellpump5() {
        return wellpump5;
    }

    public void setWellpump5(float wellpump5) {
        this.wellpump5 = wellpump5;
    }

    public float getFiltratedPump() {
        return filtratedPump;
    }

    public void setFiltratedPump(float filtratedPump) {
        this.filtratedPump = filtratedPump;
    }

    public float getHPP1() {
        return HPP1;
    }

    public void setHPP1(float HPP1) {
        this.HPP1 = HPP1;
    }

    public float getHPP2() {
        return HPP2;
    }

    public void setHPP2(float HPP2) {
        this.HPP2 = HPP2;
    }

    public float getHPP3() {
        return HPP3;
    }

    public void setHPP3(float HPP3) {
        this.HPP3 = HPP3;
    }

    public float getBoosterPump() {
        return boosterPump;
    }

    public void setBoosterPump(float boosterPump) {
        this.boosterPump = boosterPump;
    }

    public float getHPP2ndPass() {
        return HPP2ndPass;
    }

    public void setHPP2ndPass(float HPP2ndPass) {
        this.HPP2ndPass = HPP2ndPass;
    }

    public float getProductPump() {
        return productPump;
    }

    public void setProductPump(float productPump) {
        this.productPump = productPump;
    }

    public float getFeedCond() {
        return feedCond;
    }

    public void setFeedCond(float feedCond) {
        this.feedCond = feedCond;
    }

    public float getProductCond1() {
        return productCond1;
    }

    public void setProductCond1(float productCond1) {
        this.productCond1 = productCond1;
    }

    public float getProductCond2() {
        return productCond2;
    }

    public void setProductCond2(float productCond2) {
        this.productCond2 = productCond2;
    }

    public float getFinalCond() {
        return finalCond;
    }

    public void setFinalCond(float finalCond) {
        this.finalCond = finalCond;
    }

    public float getProductPH() {
        return productPH;
    }

    public void setProductPH(float productPH) {
        this.productPH = productPH;
    }

    public float getFeedPH() {
        return feedPH;
    }

    public void setFeedPH(float feedPH) {
        this.feedPH = feedPH;
    }

    public float getFeedORP() {
        return feedORP;
    }

    public void setFeedORP(float feedORP) {
        this.feedORP = feedORP;
    }

    public float getFeedTemp() {
        return feedTemp;
    }

    public void setFeedTemp(float feedTemp) {
        this.feedTemp = feedTemp;
    }

    public float getProductChlorine() {
        return productChlorine;
    }

    public void setProductChlorine(float productChlorine) {
        this.productChlorine = productChlorine;
    }
}
