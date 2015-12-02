/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 介護事業者施設オブジェクトの項目定義クラスです。
 */
public class ServiceJigyoshaInputGuideRelateEntity implements IDbAccessable {

    private KaigoJigyoshaNo jigyoshaNo;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaKanaMeisho jigyoshaNameKana;
    private RString jigyoshaKanaAddress;
    private TelNo telNo;
    private RString serviceShuruiCode;
    private RString serviceShuruiRyakusho;
    private boolean isDeleted;
    private AtenaKanaMeisho jigyoshaKanaMeisho;
    private RString jigyoshaKanaJusho;
    private RString kannaiKangaiKubun;
    private RString jigyoshaShubetsu;
    private RString jigyoshaJusho;
    private FlexibleDate yukoKaishiYMDFrom;
    private FlexibleDate yukoKaishiYMDTo;
    private YubinNo yubinNo;

    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    public void setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    public void setJigyoshaKanaAddress(RString jigyoshaKanaAddress) {
        this.jigyoshaKanaAddress = jigyoshaKanaAddress;
    }

    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    public void setServiceShuruiRyakusho(RString serviceShuruiRyakusho) {
        this.serviceShuruiRyakusho = serviceShuruiRyakusho;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setJigyoshaKanaMeisho(AtenaKanaMeisho jigyoshaKanaMeisho) {
        this.jigyoshaKanaMeisho = jigyoshaKanaMeisho;
    }

    public void setJigyoshaKanaJusho(RString jigyoshaKanaJusho) {
        this.jigyoshaKanaJusho = jigyoshaKanaJusho;
    }

    public void setKannaiKangaiKubun(RString kannaiKangaiKubun) {
        this.kannaiKangaiKubun = kannaiKangaiKubun;
    }

    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    public void setJigyoshaJusho(RString jigyoshaJusho) {
        this.jigyoshaJusho = jigyoshaJusho;
    }

    public void setYukoKaishiYMDFrom(FlexibleDate yukoKaishiYMDFrom) {
        this.yukoKaishiYMDFrom = yukoKaishiYMDFrom;
    }

    public void setYukoKaishiYMDTo(FlexibleDate yukoKaishiYMDTo) {
        this.yukoKaishiYMDTo = yukoKaishiYMDTo;
    }

    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    public RString getJigyoshaKanaAddress() {
        return jigyoshaKanaAddress;
    }

    public TelNo getTelNo() {
        return telNo;
    }

    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    public RString getServiceShuruiRyakusho() {
        return serviceShuruiRyakusho;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public AtenaKanaMeisho getJigyoshaKanaMeisho() {
        return jigyoshaKanaMeisho;
    }

    public RString getJigyoshaKanaJusho() {
        return jigyoshaKanaJusho;
    }

    public RString getKannaiKangaiKubun() {
        return kannaiKangaiKubun;
    }

    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    public RString getJigyoshaJusho() {
        return jigyoshaJusho;
    }

    public FlexibleDate getYukoKaishiYMDFrom() {
        return yukoKaishiYMDFrom;
    }

    public FlexibleDate getYukoKaishiYMDTo() {
        return yukoKaishiYMDTo;
    }

    public YubinNo getYubinNo() {
        return yubinNo;
    }
}
