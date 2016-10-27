package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * dvKogakuService のクラスファイル
 *
 * @reamsid_L DBC-5040-010 chenyadong
 */
public class dvKogakuServiceDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKogakuServiceTeikyoYM")
    private TextBoxDateRange txtKogakuServiceTeikyoYM;
    @JsonProperty("txtKogakuShinseiDate")
    private TextBoxDateRange txtKogakuShinseiDate;
    @JsonProperty("ddlKogakuShoriJokyo")
    private DropDownList ddlKogakuShoriJokyo;
    @JsonProperty("txtKogakuHokenshaKetteiDate")
    private TextBoxDateRange txtKogakuHokenshaKetteiDate;
    @JsonProperty("ddlKogakuShinsaHoho")
    private DropDownList ddlKogakuShinsaHoho;
    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    private TextBoxDateRange txtKogakuKokuhorenKetteiYM;
    @JsonProperty("ddlKogakuSanteiKijun")
    private DropDownList ddlKogakuSanteiKijun;
    @JsonProperty("txtKogakuTaishoshaUketoriYM")
    private TextBoxDateRange txtKogakuTaishoshaUketoriYM;
    @JsonProperty("radKogakuKokuhorenFuicchi")
    private RadioButton radKogakuKokuhorenFuicchi;
    @JsonProperty("txtKogakuKokuhorenSofuYM")
    private TextBoxDateRange txtKogakuKokuhorenSofuYM;
    @JsonProperty("radKogakuTaishosha")
    private RadioButton radKogakuTaishosha;
    @JsonProperty("txtKogakuKetteiJohoUketoriYM")
    private TextBoxDateRange txtKogakuKetteiJohoUketoriYM;
    @JsonProperty("radKogakuShinseiKubun")
    private RadioButton radKogakuShinseiKubun;
    @JsonProperty("lblKogakuShiharai")
    private Label lblKogakuShiharai;
    @JsonProperty("radKogakuShiharaisaki")
    private RadioButton radKogakuShiharaisaki;
    @JsonProperty("lblKogakuKetteiGaku")
    private Label lblKogakuKetteiGaku;
    @JsonProperty("txtShinsaNengetsu")
    private TextBoxDate txtShinsaNengetsu;
    @JsonProperty("ccdKogakuKinyuKikan")
    private KinyuKikanInputDiv ccdKogakuKinyuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKogakuServiceTeikyoYM
     * @return txtKogakuServiceTeikyoYM
     */
    @JsonProperty("txtKogakuServiceTeikyoYM")
    public TextBoxDateRange getTxtKogakuServiceTeikyoYM() {
        return txtKogakuServiceTeikyoYM;
    }

    /*
     * settxtKogakuServiceTeikyoYM
     * @param txtKogakuServiceTeikyoYM txtKogakuServiceTeikyoYM
     */
    @JsonProperty("txtKogakuServiceTeikyoYM")
    public void setTxtKogakuServiceTeikyoYM(TextBoxDateRange txtKogakuServiceTeikyoYM) {
        this.txtKogakuServiceTeikyoYM = txtKogakuServiceTeikyoYM;
    }

    /*
     * gettxtKogakuShinseiDate
     * @return txtKogakuShinseiDate
     */
    @JsonProperty("txtKogakuShinseiDate")
    public TextBoxDateRange getTxtKogakuShinseiDate() {
        return txtKogakuShinseiDate;
    }

    /*
     * settxtKogakuShinseiDate
     * @param txtKogakuShinseiDate txtKogakuShinseiDate
     */
    @JsonProperty("txtKogakuShinseiDate")
    public void setTxtKogakuShinseiDate(TextBoxDateRange txtKogakuShinseiDate) {
        this.txtKogakuShinseiDate = txtKogakuShinseiDate;
    }

    /*
     * getddlKogakuShoriJokyo
     * @return ddlKogakuShoriJokyo
     */
    @JsonProperty("ddlKogakuShoriJokyo")
    public DropDownList getDdlKogakuShoriJokyo() {
        return ddlKogakuShoriJokyo;
    }

    /*
     * setddlKogakuShoriJokyo
     * @param ddlKogakuShoriJokyo ddlKogakuShoriJokyo
     */
    @JsonProperty("ddlKogakuShoriJokyo")
    public void setDdlKogakuShoriJokyo(DropDownList ddlKogakuShoriJokyo) {
        this.ddlKogakuShoriJokyo = ddlKogakuShoriJokyo;
    }

    /*
     * gettxtKogakuHokenshaKetteiDate
     * @return txtKogakuHokenshaKetteiDate
     */
    @JsonProperty("txtKogakuHokenshaKetteiDate")
    public TextBoxDateRange getTxtKogakuHokenshaKetteiDate() {
        return txtKogakuHokenshaKetteiDate;
    }

    /*
     * settxtKogakuHokenshaKetteiDate
     * @param txtKogakuHokenshaKetteiDate txtKogakuHokenshaKetteiDate
     */
    @JsonProperty("txtKogakuHokenshaKetteiDate")
    public void setTxtKogakuHokenshaKetteiDate(TextBoxDateRange txtKogakuHokenshaKetteiDate) {
        this.txtKogakuHokenshaKetteiDate = txtKogakuHokenshaKetteiDate;
    }

    /*
     * getddlKogakuShinsaHoho
     * @return ddlKogakuShinsaHoho
     */
    @JsonProperty("ddlKogakuShinsaHoho")
    public DropDownList getDdlKogakuShinsaHoho() {
        return ddlKogakuShinsaHoho;
    }

    /*
     * setddlKogakuShinsaHoho
     * @param ddlKogakuShinsaHoho ddlKogakuShinsaHoho
     */
    @JsonProperty("ddlKogakuShinsaHoho")
    public void setDdlKogakuShinsaHoho(DropDownList ddlKogakuShinsaHoho) {
        this.ddlKogakuShinsaHoho = ddlKogakuShinsaHoho;
    }

    /*
     * gettxtKogakuKokuhorenKetteiYM
     * @return txtKogakuKokuhorenKetteiYM
     */
    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    public TextBoxDateRange getTxtKogakuKokuhorenKetteiYM() {
        return txtKogakuKokuhorenKetteiYM;
    }

    /*
     * settxtKogakuKokuhorenKetteiYM
     * @param txtKogakuKokuhorenKetteiYM txtKogakuKokuhorenKetteiYM
     */
    @JsonProperty("txtKogakuKokuhorenKetteiYM")
    public void setTxtKogakuKokuhorenKetteiYM(TextBoxDateRange txtKogakuKokuhorenKetteiYM) {
        this.txtKogakuKokuhorenKetteiYM = txtKogakuKokuhorenKetteiYM;
    }

    /*
     * getddlKogakuSanteiKijun
     * @return ddlKogakuSanteiKijun
     */
    @JsonProperty("ddlKogakuSanteiKijun")
    public DropDownList getDdlKogakuSanteiKijun() {
        return ddlKogakuSanteiKijun;
    }

    /*
     * setddlKogakuSanteiKijun
     * @param ddlKogakuSanteiKijun ddlKogakuSanteiKijun
     */
    @JsonProperty("ddlKogakuSanteiKijun")
    public void setDdlKogakuSanteiKijun(DropDownList ddlKogakuSanteiKijun) {
        this.ddlKogakuSanteiKijun = ddlKogakuSanteiKijun;
    }

    /*
     * gettxtKogakuTaishoshaUketoriYM
     * @return txtKogakuTaishoshaUketoriYM
     */
    @JsonProperty("txtKogakuTaishoshaUketoriYM")
    public TextBoxDateRange getTxtKogakuTaishoshaUketoriYM() {
        return txtKogakuTaishoshaUketoriYM;
    }

    /*
     * settxtKogakuTaishoshaUketoriYM
     * @param txtKogakuTaishoshaUketoriYM txtKogakuTaishoshaUketoriYM
     */
    @JsonProperty("txtKogakuTaishoshaUketoriYM")
    public void setTxtKogakuTaishoshaUketoriYM(TextBoxDateRange txtKogakuTaishoshaUketoriYM) {
        this.txtKogakuTaishoshaUketoriYM = txtKogakuTaishoshaUketoriYM;
    }

    /*
     * getradKogakuKokuhorenFuicchi
     * @return radKogakuKokuhorenFuicchi
     */
    @JsonProperty("radKogakuKokuhorenFuicchi")
    public RadioButton getRadKogakuKokuhorenFuicchi() {
        return radKogakuKokuhorenFuicchi;
    }

    /*
     * setradKogakuKokuhorenFuicchi
     * @param radKogakuKokuhorenFuicchi radKogakuKokuhorenFuicchi
     */
    @JsonProperty("radKogakuKokuhorenFuicchi")
    public void setRadKogakuKokuhorenFuicchi(RadioButton radKogakuKokuhorenFuicchi) {
        this.radKogakuKokuhorenFuicchi = radKogakuKokuhorenFuicchi;
    }

    /*
     * gettxtKogakuKokuhorenSofuYM
     * @return txtKogakuKokuhorenSofuYM
     */
    @JsonProperty("txtKogakuKokuhorenSofuYM")
    public TextBoxDateRange getTxtKogakuKokuhorenSofuYM() {
        return txtKogakuKokuhorenSofuYM;
    }

    /*
     * settxtKogakuKokuhorenSofuYM
     * @param txtKogakuKokuhorenSofuYM txtKogakuKokuhorenSofuYM
     */
    @JsonProperty("txtKogakuKokuhorenSofuYM")
    public void setTxtKogakuKokuhorenSofuYM(TextBoxDateRange txtKogakuKokuhorenSofuYM) {
        this.txtKogakuKokuhorenSofuYM = txtKogakuKokuhorenSofuYM;
    }

    /*
     * getradKogakuTaishosha
     * @return radKogakuTaishosha
     */
    @JsonProperty("radKogakuTaishosha")
    public RadioButton getRadKogakuTaishosha() {
        return radKogakuTaishosha;
    }

    /*
     * setradKogakuTaishosha
     * @param radKogakuTaishosha radKogakuTaishosha
     */
    @JsonProperty("radKogakuTaishosha")
    public void setRadKogakuTaishosha(RadioButton radKogakuTaishosha) {
        this.radKogakuTaishosha = radKogakuTaishosha;
    }

    /*
     * gettxtKogakuKetteiJohoUketoriYM
     * @return txtKogakuKetteiJohoUketoriYM
     */
    @JsonProperty("txtKogakuKetteiJohoUketoriYM")
    public TextBoxDateRange getTxtKogakuKetteiJohoUketoriYM() {
        return txtKogakuKetteiJohoUketoriYM;
    }

    /*
     * settxtKogakuKetteiJohoUketoriYM
     * @param txtKogakuKetteiJohoUketoriYM txtKogakuKetteiJohoUketoriYM
     */
    @JsonProperty("txtKogakuKetteiJohoUketoriYM")
    public void setTxtKogakuKetteiJohoUketoriYM(TextBoxDateRange txtKogakuKetteiJohoUketoriYM) {
        this.txtKogakuKetteiJohoUketoriYM = txtKogakuKetteiJohoUketoriYM;
    }

    /*
     * getradKogakuShinseiKubun
     * @return radKogakuShinseiKubun
     */
    @JsonProperty("radKogakuShinseiKubun")
    public RadioButton getRadKogakuShinseiKubun() {
        return radKogakuShinseiKubun;
    }

    /*
     * setradKogakuShinseiKubun
     * @param radKogakuShinseiKubun radKogakuShinseiKubun
     */
    @JsonProperty("radKogakuShinseiKubun")
    public void setRadKogakuShinseiKubun(RadioButton radKogakuShinseiKubun) {
        this.radKogakuShinseiKubun = radKogakuShinseiKubun;
    }

    /*
     * getlblKogakuShiharai
     * @return lblKogakuShiharai
     */
    @JsonProperty("lblKogakuShiharai")
    public Label getLblKogakuShiharai() {
        return lblKogakuShiharai;
    }

    /*
     * setlblKogakuShiharai
     * @param lblKogakuShiharai lblKogakuShiharai
     */
    @JsonProperty("lblKogakuShiharai")
    public void setLblKogakuShiharai(Label lblKogakuShiharai) {
        this.lblKogakuShiharai = lblKogakuShiharai;
    }

    /*
     * getradKogakuShiharaisaki
     * @return radKogakuShiharaisaki
     */
    @JsonProperty("radKogakuShiharaisaki")
    public RadioButton getRadKogakuShiharaisaki() {
        return radKogakuShiharaisaki;
    }

    /*
     * setradKogakuShiharaisaki
     * @param radKogakuShiharaisaki radKogakuShiharaisaki
     */
    @JsonProperty("radKogakuShiharaisaki")
    public void setRadKogakuShiharaisaki(RadioButton radKogakuShiharaisaki) {
        this.radKogakuShiharaisaki = radKogakuShiharaisaki;
    }

    /*
     * getlblKogakuKetteiGaku
     * @return lblKogakuKetteiGaku
     */
    @JsonProperty("lblKogakuKetteiGaku")
    public Label getLblKogakuKetteiGaku() {
        return lblKogakuKetteiGaku;
    }

    /*
     * setlblKogakuKetteiGaku
     * @param lblKogakuKetteiGaku lblKogakuKetteiGaku
     */
    @JsonProperty("lblKogakuKetteiGaku")
    public void setLblKogakuKetteiGaku(Label lblKogakuKetteiGaku) {
        this.lblKogakuKetteiGaku = lblKogakuKetteiGaku;
    }

    /*
     * gettxtShinsaNengetsu
     * @return txtShinsaNengetsu
     */
    @JsonProperty("txtShinsaNengetsu")
    public TextBoxDate getTxtShinsaNengetsu() {
        return txtShinsaNengetsu;
    }

    /*
     * settxtShinsaNengetsu
     * @param txtShinsaNengetsu txtShinsaNengetsu
     */
    @JsonProperty("txtShinsaNengetsu")
    public void setTxtShinsaNengetsu(TextBoxDate txtShinsaNengetsu) {
        this.txtShinsaNengetsu = txtShinsaNengetsu;
    }

    /*
     * getccdKogakuKinyuKikan
     * @return ccdKogakuKinyuKikan
     */
    @JsonProperty("ccdKogakuKinyuKikan")
    public IKinyuKikanInputDiv getCcdKogakuKinyuKikan() {
        return ccdKogakuKinyuKikan;
    }

    // </editor-fold>
}
