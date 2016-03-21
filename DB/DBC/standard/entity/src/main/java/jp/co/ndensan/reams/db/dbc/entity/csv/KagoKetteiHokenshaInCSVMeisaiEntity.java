/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KagoKetteiTsuchishoJyohoHokenshabunCSVMeisaiEntityのcsv項目定義クラスです
 */
public class KagoKetteiHokenshaInCSVMeisaiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "事業所番号")
    private RString jigyoshoNo;
    @CsvField(order = 40, name = "事業所名")
    private RString jigyoshoName;
    @CsvField(order = 50, name = "被保険者番号")
    private RString hiHokenshaNo;
    @CsvField(order = 60, name = "被保険者氏名")
    private RString hiHokenshaSimei;
    @CsvField(order = 70, name = "サービス提供年月")
    private RString serviceTeikyoYM;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString serviceShuruiCode;
    @CsvField(order = 90, name = "サービス種類名")
    private RString serviceShuruiName;
    @CsvField(order = 100, name = "過誤申立事由コード")
    private RString kagomoushitateJiyuCode;
    @CsvField(order = 110, name = "過誤申立事由")
    private RString kagomoushitateJiyu;
    @CsvField(order = 120, name = "単位数")
    private RString tanisu;
    @CsvField(order = 130, name = "保険者負担額")
    private RString hokenshaFutangaku;

    /**
     * コンストラクタです。
     */
    public KagoKetteiHokenshaInCSVMeisaiEntity() {

    }

    /**
     * getKokanShikibetsuNo
     *
     * @return kokanShikibetsuNo
     */
    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * setKokanShikibetsuNo
     *
     * @param kokanShikibetsuNo RString
     */
    public void setKokanShikibetsuNo(RString kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * getChouhyouCodeShubetsu
     *
     * @return chouhyouCodeShubetsu
     */
    public RString getChouhyouCodeShubetsu() {
        return chouhyouCodeShubetsu;
    }

    /**
     * setChouhyouCodeShubetsu
     *
     * @param chouhyouCodeShubetsu RString
     */
    public void setChouhyouCodeShubetsu(RString chouhyouCodeShubetsu) {
        this.chouhyouCodeShubetsu = chouhyouCodeShubetsu;
    }

    /**
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public RString getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo RString
     */
    public void setJigyoshoNo(RString jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getJigyoshoName
     *
     * @return jigyoshoName
     */
    public RString getJigyoshoName() {
        return jigyoshoName;
    }

    /**
     * setJigyoshoName
     *
     * @param jigyoshoName RString
     */
    public void setJigyoshoName(RString jigyoshoName) {
        this.jigyoshoName = jigyoshoName;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public RString getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo RString
     */
    public void setHiHokenshaNo(RString hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getHiHokenshaSimei
     *
     * @return hiHokenshaSimei
     */
    public RString getHiHokenshaSimei() {
        return hiHokenshaSimei;
    }

    /**
     * setHiHokenshaSimei
     *
     * @param hiHokenshaSimei RString
     */
    public void setHiHokenshaSimei(RString hiHokenshaSimei) {
        this.hiHokenshaSimei = hiHokenshaSimei;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public RString getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM RString
     */
    public void setServiceTeikyoYM(RString serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode RString
     */
    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceShuruiName
     *
     * @return serviceShuruiName
     */
    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    /**
     * setServiceShuruiName
     *
     * @param serviceShuruiName RString
     */
    public void setServiceShuruiName(RString serviceShuruiName) {
        this.serviceShuruiName = serviceShuruiName;
    }

    /**
     * getKagomoushitateJiyuCode
     *
     * @return kagomoushitateJiyuCode
     */
    public RString getKagomoushitateJiyuCode() {
        return kagomoushitateJiyuCode;
    }

    /**
     * setKagomoushitateJiyuCode
     *
     * @param kagomoushitateJiyuCode RString
     */
    public void setKagomoushitateJiyuCode(RString kagomoushitateJiyuCode) {
        this.kagomoushitateJiyuCode = kagomoushitateJiyuCode;
    }

    /**
     * getKagomoushitateJiyu
     *
     * @return kagomoushitateJiyu
     */
    public RString getKagomoushitateJiyu() {
        return kagomoushitateJiyu;
    }

    /**
     * setKagomoushitateJiyu
     *
     * @param kagomoushitateJiyu RString
     */
    public void setKagomoushitateJiyu(RString kagomoushitateJiyu) {
        this.kagomoushitateJiyu = kagomoushitateJiyu;
    }

    /**
     * getTanisu
     *
     * @return tanisu
     */
    public RString getTanisu() {
        return tanisu;
    }

    /**
     * setTanisu
     *
     * @param tanisu RString
     */
    public void setTanisu(RString tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * getHokenshaFutangaku
     *
     * @return hokenshaFutangaku
     */
    public RString getHokenshaFutangaku() {
        return hokenshaFutangaku;
    }

    /**
     * setHokenshaFutangaku
     *
     * @param hokenshaFutangaku RString
     */
    public void setHokenshaFutangaku(RString hokenshaFutangaku) {
        this.hokenshaFutangaku = hokenshaFutangaku;
    }
}
