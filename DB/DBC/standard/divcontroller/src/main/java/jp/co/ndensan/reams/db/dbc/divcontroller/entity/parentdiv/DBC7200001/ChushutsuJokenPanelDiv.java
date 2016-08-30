package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("chkSakujyoDataChushutsu")
    private CheckBoxList chkSakujyoDataChushutsu;
    @JsonProperty("DetaShubetsu")
    private DetaShubetsuDiv DetaShubetsu;
    @JsonProperty("ChushutsuKubun")
    private ChushutsuKubunDiv ChushutsuKubun;
    @JsonProperty("txtSinseibi")
    private TextBoxDateRange txtSinseibi;
    @JsonProperty("txtKetteibi")
    private TextBoxDateRange txtKetteibi;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * getchkSakujyoDataChushutsu
     * @return chkSakujyoDataChushutsu
     */
    @JsonProperty("chkSakujyoDataChushutsu")
    public CheckBoxList getChkSakujyoDataChushutsu() {
        return chkSakujyoDataChushutsu;
    }

    /*
     * setchkSakujyoDataChushutsu
     * @param chkSakujyoDataChushutsu chkSakujyoDataChushutsu
     */
    @JsonProperty("chkSakujyoDataChushutsu")
    public void setChkSakujyoDataChushutsu(CheckBoxList chkSakujyoDataChushutsu) {
        this.chkSakujyoDataChushutsu = chkSakujyoDataChushutsu;
    }

    /*
     * getDetaShubetsu
     * @return DetaShubetsu
     */
    @JsonProperty("DetaShubetsu")
    public DetaShubetsuDiv getDetaShubetsu() {
        return DetaShubetsu;
    }

    /*
     * setDetaShubetsu
     * @param DetaShubetsu DetaShubetsu
     */
    @JsonProperty("DetaShubetsu")
    public void setDetaShubetsu(DetaShubetsuDiv DetaShubetsu) {
        this.DetaShubetsu = DetaShubetsu;
    }

    /*
     * getChushutsuKubun
     * @return ChushutsuKubun
     */
    @JsonProperty("ChushutsuKubun")
    public ChushutsuKubunDiv getChushutsuKubun() {
        return ChushutsuKubun;
    }

    /*
     * setChushutsuKubun
     * @param ChushutsuKubun ChushutsuKubun
     */
    @JsonProperty("ChushutsuKubun")
    public void setChushutsuKubun(ChushutsuKubunDiv ChushutsuKubun) {
        this.ChushutsuKubun = ChushutsuKubun;
    }

    /*
     * gettxtSinseibi
     * @return txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public TextBoxDateRange getTxtSinseibi() {
        return txtSinseibi;
    }

    /*
     * settxtSinseibi
     * @param txtSinseibi txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public void setTxtSinseibi(TextBoxDateRange txtSinseibi) {
        this.txtSinseibi = txtSinseibi;
    }

    /*
     * gettxtKetteibi
     * @return txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public TextBoxDateRange getTxtKetteibi() {
        return txtKetteibi;
    }

    /*
     * settxtKetteibi
     * @param txtKetteibi txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public void setTxtKetteibi(TextBoxDateRange txtKetteibi) {
        this.txtKetteibi = txtKetteibi;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadDetaShubetsu() {
        return this.getDetaShubetsu().getRadDetaShubetsu();
    }

    @JsonIgnore
    public void  setRadDetaShubetsu(RadioButton radDetaShubetsu) {
        this.getDetaShubetsu().setRadDetaShubetsu(radDetaShubetsu);
    }

    @JsonIgnore
    public Space getYohaku1() {
        return this.getChushutsuKubun().getYohaku1();
    }

    @JsonIgnore
    public void  setYohaku1(Space Yohaku1) {
        this.getChushutsuKubun().setYohaku1(Yohaku1);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKubun() {
        return this.getChushutsuKubun().getRadChushutsuKubun();
    }

    @JsonIgnore
    public void  setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.getChushutsuKubun().setRadChushutsuKubun(radChushutsuKubun);
    }

    @JsonIgnore
    public KijyunbiDiv getKijyunbi() {
        return this.getChushutsuKubun().getKijyunbi();
    }

    @JsonIgnore
    public void  setKijyunbi(KijyunbiDiv Kijyunbi) {
        this.getChushutsuKubun().setKijyunbi(Kijyunbi);
    }

    @JsonIgnore
    public Space getYohaku2() {
        return this.getChushutsuKubun().getKijyunbi().getYohaku2();
    }

    @JsonIgnore
    public void  setYohaku2(Space Yohaku2) {
        this.getChushutsuKubun().getKijyunbi().setYohaku2(Yohaku2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunnNengetsu() {
        return this.getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu();
    }

    @JsonIgnore
    public void  setTxtKijyunnNengetsu(TextBoxDate txtKijyunnNengetsu) {
        this.getChushutsuKubun().getKijyunbi().setTxtKijyunnNengetsu(txtKijyunnNengetsu);
    }

    // </editor-fold>
}
