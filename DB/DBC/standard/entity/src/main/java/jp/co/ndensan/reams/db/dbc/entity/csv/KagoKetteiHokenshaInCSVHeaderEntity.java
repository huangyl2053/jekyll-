/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KagoKetteiTsuchishoJyohoHokenshabunCSVHeaderEntityのcsv項目定義クラスです
 */
public class KagoKetteiHokenshaInCSVHeaderEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString kokanShikibetsuNo;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString chouhyouCodeShubetsu;
    @CsvField(order = 30, name = "取扱年月")
    private RString toriatsukaiYM;
    @CsvField(order = 40, name = "証記載保険者番号")
    private RString shokisaiHokenshaNo;
    @CsvField(order = 50, name = "証記載保険者名")
    private RString shokisaiHokenshaNa;
    @CsvField(order = 60, name = "作成年月日")
    private RString sakuseiYMD;
    @CsvField(order = 70, name = "頁 ")
    private RString page;
    @CsvField(order = 80, name = "国保連合会名")
    private RString kokukoRengoukaiNa;

    /**
     * コンストラクタです。
     */
    public KagoKetteiHokenshaInCSVHeaderEntity() {

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
     * getToriatsukaiYM
     *
     * @return toriatsukaiYM
     */
    public RString getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * setToriatsukaiYM
     *
     * @param toriatsukaiYM RString
     */
    public void setToriatsukaiYM(RString toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo RString
     */
    public void setShokisaiHokenshaNo(RString shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getShokisaiHokenshaNa
     *
     * @return shokisaiHokenshaNa
     */
    public RString getShokisaiHokenshaNa() {
        return shokisaiHokenshaNa;
    }

    /**
     * setShokisaiHokenshaNa
     *
     * @param shokisaiHokenshaNa RString
     */
    public void setShokisaiHokenshaNa(RString shokisaiHokenshaNa) {
        this.shokisaiHokenshaNa = shokisaiHokenshaNa;
    }

    /**
     * getSakuseiYMD
     *
     * @return sakuseiYMD
     */
    public RString getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * setSakuseiYMD
     *
     * @param sakuseiYMD RString
     */
    public void setSakuseiYMD(RString sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
    }

    /**
     * getPage
     *
     * @return page
     */
    public RString getPage() {
        return page;
    }

    /**
     * setPage
     *
     * @param page RString
     */
    public void setPage(RString page) {
        this.page = page;
    }

    /**
     * getKokukoRengoukaiNa
     *
     * @return kokukoRengoukaiNa
     */
    public RString getKokukoRengoukaiNa() {
        return kokukoRengoukaiNa;
    }

    /**
     * setKokukoRengoukaiNa
     *
     * @param kokukoRengoukaiNa RString
     */
    public void setKokukoRengoukaiNa(RString kokukoRengoukaiNa) {
        this.kokukoRengoukaiNa = kokukoRengoukaiNa;
    }

}
