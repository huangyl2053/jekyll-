/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KyufuKanrihyoHeaderEntityのcsv項目定義クラスです
 *
 * @author N2810 久保 里史
 */
public class KyufuKanrihyoCSVHeaderEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString recordShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString recordNo;
    @CsvField(order = 30, name = "ボリューム連番")
    private RString volumeRenban;
    @CsvField(order = 40, name = "レコード件数")
    private RString recordKensu;
    @CsvField(order = 50, name = "データ種別")
    private RString dataShubetsu;
    @CsvField(order = 60, name = "福祉事務所特定番号")
    private RString fukushijimushoTokuteiNo;
    @CsvField(order = 70, name = "保険者番号")
    private RString hokenshaNo;
    @CsvField(order = 80, name = "事業者番号")
    private RString jigyoshoNo;
    @CsvField(order = 90, name = "都道府県番号")
    private RString todofukenNo;
    @CsvField(order = 100, name = "媒体区分")
    private RString baitaiKubun;
    @CsvField(order = 110, name = "処理対象年月")
    private RString shoriTaishoYM;
    @CsvField(order = 120, name = "ファイル管理番号")
    private RString fileKanriNo;

    public KyufuKanrihyoCSVHeaderEntity() {
    }

    /**
     * getrecordShubetsu
     *
     * @return recordShubetsu
     */
    public RString getRecordShubetsu() {
        return recordShubetsu;
    }

    /**
     * getrecordNo
     *
     * @return recordNo
     */
    public RString getRecordNo() {
        return recordNo;
    }

    /**
     * getvolumeRenban
     *
     * @return volumeRenban
     */
    public RString getVolumeRenban() {
        return volumeRenban;
    }

    /**
     * getrecordKensu
     *
     * @return recordKensu
     */
    public RString getRecordKensu() {
        return recordKensu;
    }

    /**
     * getdataShubetsu
     *
     * @return dataShubetsu
     */
    public RString getDataShubetsu() {
        return dataShubetsu;
    }

    /**
     * getfukushijimushoTokuteiNo
     *
     * @return fukushijimushoTokuteiNo
     */
    public RString getFukushijimushoTokuteiNo() {
        return fukushijimushoTokuteiNo;
    }

    /**
     * gethokenshaNo
     *
     * @return hokenshaNo
     */
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * getjigyoshoNo
     *
     * @return jigyoshoNo
     */
    public RString getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * gettodofukenNo
     *
     * @return todofukenNo
     */
    public RString getTodofukenNo() {
        return todofukenNo;
    }

    /**
     * getbaitaiKubun
     *
     * @return baitaiKubun
     */
    public RString getBaitaiKubun() {
        return baitaiKubun;
    }

    /**
     * getshoriTaishoYM
     *
     * @return shoriTaishoYM
     */
    public RString getShoritaishoYM() {
        return shoriTaishoYM;
    }

    /**
     * getfileKanriNo
     *
     * @return fileKanriNo
     */
    public RString getFilekanriNo() {
        return fileKanriNo;
    }

    /**
     * setrecordShubetsu
     *
     * @param recordShubetsu
     */
    public void setRecordShubetsu(RString recordShubetsu) {
        this.recordShubetsu = recordShubetsu;
    }

    /**
     * setrecordNo
     *
     * @param recordNo
     */
    public void setRecordNo(RString recordNo) {
        this.recordNo = recordNo;
    }

    /**
     * setvolumeRenban
     *
     * @param volumeRenban
     */
    public void setVolumeRenban(RString volumeRenban) {
        this.volumeRenban = volumeRenban;
    }

    /**
     * setrecordKensu
     *
     * @param recordKensu
     */
    public void setRecordKensu(RString recordKensu) {
        this.recordKensu = recordKensu;
    }

    /**
     * setdataShubetsu
     *
     * @param dataShubetsu
     */
    public void setDataShubetsu(RString dataShubetsu) {
        this.dataShubetsu = dataShubetsu;
    }

    /**
     * setfukushijimushoTokuteiNo
     *
     * @param fukushijimushoTokuteiNo
     */
    public void setFukushijimushoTokuteiNo(RString fukushijimushoTokuteiNo) {
        this.fukushijimushoTokuteiNo = fukushijimushoTokuteiNo;
    }

    /**
     * sethokenshaNo
     *
     * @param hokenshaNo
     */
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * setjigyoshoNo
     *
     * @param jigyoshoNo
     */
    public void setJigyoshoNo(RString jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * settodofukenNo
     *
     * @param todofukenNo
     */
    public void setTodofukenNo(RString todofukenNo) {
        this.todofukenNo = todofukenNo;
    }

    /**
     * setbaitaiKubun
     *
     * @param baitaiKubun
     */
    public void setBaitaiKubun(RString baitaiKubun) {
        this.baitaiKubun = baitaiKubun;
    }

    /**
     * setshoriTaishoYM
     *
     * @param shoriTaishoYM
     */
    public void setShoritaishoYM(RString shoriTaishoYM) {
        this.shoriTaishoYM = shoriTaishoYM;
    }

    /**
     * setfileKanriNo
     *
     * @param fileKanriNo
     */
    public void setFilekanriNo(RString fileKanriNo) {
        this.fileKanriNo = fileKanriNo;
    }

}
