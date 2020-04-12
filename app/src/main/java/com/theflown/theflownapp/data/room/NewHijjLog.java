package com.theflown.theflownapp.data.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "newhijjlog_table")
public class NewHijjLog {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    //Pressure
    @ColumnInfo(name = "MMFIn")
    private float MMFIn;

    @ColumnInfo(name = "MMFOut")
    private float MMFOut;

    @ColumnInfo(name = "bagIn")
    private float bagIn;

    @ColumnInfo(name = "bagOut")
    private float bagOut;

    @ColumnInfo(name = "cartridgeIn")
    private float cartridgeIn;

    @ColumnInfo(name = "cartridgeOut")
    private float cartridgeOut;

    @ColumnInfo(name = "RO1stIn")
    private float RO1stIn;

    @ColumnInfo(name = "RO1stOut")
    private float RO1stOut;

    @ColumnInfo(name = "RO2ndIn")
    private float RO2ndIn;

    @ColumnInfo(name = "RO2ndOut")
    private float RO2ndOut;

    @ColumnInfo(name = "PXBackPressure")
    private float PXBackPressure;


    //Flow
    @ColumnInfo(name = "feedFlow")
    private float feedFlow;

    @ColumnInfo(name = "HPPFeed")
    private float HPPFeed;

    @ColumnInfo(name = "PXFeed")
    private float PXFeed;

    @ColumnInfo(name = "feed1stpass")
    private float feed1stpass;

    @ColumnInfo(name = "feed2ndpass")
    private float feed2ndpass;

    @ColumnInfo(name = "product1stpass")
    private float product1stpass;

    @ColumnInfo(name = "product2ndpass")
    private float product2ndpass;


    //volt & amps
    @ColumnInfo(name = "voltage")
    private float voltage;

    @ColumnInfo(name = "wellpump1")
    private float wellpump1;

    @ColumnInfo(name = "wellpump2")
    private float wellpump2;

    @ColumnInfo(name = "wellpump3")
    private float wellpump3;

    @ColumnInfo(name = "wellpump4")
    private float wellpump4;

    @ColumnInfo(name = "wellpump5")
    private float wellpump5;

    @ColumnInfo(name = "filtratedPump")
    private float filtratedPump;

    @ColumnInfo(name = "HPP1")
    private float HPP1;

    @ColumnInfo(name = "HPP2")
    private float HPP2;

    @ColumnInfo(name = "HPP3")
    private float HPP3;

    @ColumnInfo(name = "BoosterPump")
    private float boosterPump;

    @ColumnInfo(name = "HPP2ndPass")
    private float HPP2ndPass;

    @ColumnInfo(name = "productPump")
    private float productPump;

    //Lap map
    @ColumnInfo(name = "feedConductivity")
    private float feedCond;

    @ColumnInfo(name = "productConductivity1")
    private float productCond1;

    @ColumnInfo(name = "productConductivity2")
    private float productCond2;

    @ColumnInfo(name = "finalCond")
    private float finalCond;

    @ColumnInfo(name = "productPH")
    private float productPH;

    @ColumnInfo(name = "feedPH")
    private float feedPH;

    @ColumnInfo(name = "feedORP")
    private float feedORP;

    @ColumnInfo(name = "feedTemp")
    private float feedTemp;

    @ColumnInfo(name = "productChlorine")
    private float productChlorine;


    public NewHijjLog(float MMFIn, float MMFOut, float bagIn, float bagOut, float cartridgeIn, float cartridgeOut, float RO1stIn, float RO1stOut, float RO2ndIn, float RO2ndOut, float PXBackPressure, float feedFlow, float HPPFeed, float PXFeed, float feed1stpass, float feed2ndpass, float product1stpass, float product2ndpass, float voltage, float wellpump1, float wellpump2, float wellpump3, float wellpump4, float wellpump5, float filtratedPump, float HPP1, float HPP2, float HPP3, float boosterPump, float HPP2ndPass, float productPump, float feedCond, float productCond1, float productCond2, float finalCond, float productPH, float feedPH, float feedORP, float feedTemp, float productChlorine) {
        this.MMFIn = MMFIn;
        this.MMFOut = MMFOut;
        this.bagIn = bagIn;
        this.bagOut = bagOut;
        this.cartridgeIn = cartridgeIn;
        this.cartridgeOut = cartridgeOut;
        this.RO1stIn = RO1stIn;
        this.RO1stOut = RO1stOut;
        this.RO2ndIn = RO2ndIn;
        this.RO2ndOut = RO2ndOut;
        this.PXBackPressure = PXBackPressure;
        this.feedFlow = feedFlow;
        this.HPPFeed = HPPFeed;
        this.PXFeed = PXFeed;
        this.feed1stpass = feed1stpass;
        this.feed2ndpass = feed2ndpass;
        this.product1stpass = product1stpass;
        this.product2ndpass = product2ndpass;
        this.voltage = voltage;
        this.wellpump1 = wellpump1;
        this.wellpump2 = wellpump2;
        this.wellpump3 = wellpump3;
        this.wellpump4 = wellpump4;
        this.wellpump5 = wellpump5;
        this.filtratedPump = filtratedPump;
        this.HPP1 = HPP1;
        this.HPP2 = HPP2;
        this.HPP3 = HPP3;
        this.boosterPump = boosterPump;
        this.HPP2ndPass = HPP2ndPass;
        this.productPump = productPump;
        this.feedCond = feedCond;
        this.productCond1 = productCond1;
        this.productCond2 = productCond2;
        this.finalCond = finalCond;
        this.productPH = productPH;
        this.feedPH = feedPH;
        this.feedORP = feedORP;
        this.feedTemp = feedTemp;
        this.productChlorine = productChlorine;
    }

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
