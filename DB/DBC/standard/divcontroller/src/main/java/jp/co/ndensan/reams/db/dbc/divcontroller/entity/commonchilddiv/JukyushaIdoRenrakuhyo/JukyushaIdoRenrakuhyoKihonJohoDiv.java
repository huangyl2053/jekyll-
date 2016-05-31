package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoKihonJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKihonJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIdoYMD")
    private TextBoxFlexibleDate txtIdoYMD;
    @JsonProperty("radIdoKubun")
    private RadioButton radIdoKubun;
    @JsonProperty("ddlJukyushaIdoJiyu")
    private DropDownList ddlJukyushaIdoJiyu;
    @JsonProperty("txtHiHokenshaNo")
    private TextBoxCode txtHiHokenshaNo;
    @JsonProperty("txtHiHokenshaNameKana")
    private TextBoxKana txtHiHokenshaNameKana;
    @JsonProperty("txtUmareYMD")
    private TextBoxFlexibleDate txtUmareYMD;
    @JsonProperty("radSeibetsu")
    private RadioButton radSeibetsu;
    @JsonProperty("txtShikakuShutokuYMD")
    private TextBoxFlexibleDate txtShikakuShutokuYMD;
    @JsonProperty("txtShikakuSoshitsuYMD")
    private TextBoxFlexibleDate txtShikakuSoshitsuYMD;
    @JsonProperty("txtShoKisaiHokenshaNo")
    private TextBoxCode txtShoKisaiHokenshaNo;
    @JsonProperty("txtKoikiHokenshaNo")
    private TextBoxCode txtKoikiHokenshaNo;
    @JsonProperty("txtSofuYM")
    private TextBoxFlexibleDate txtSofuYM;
    @JsonProperty("lin2")
    private HorizontalLine lin2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIdoYMD
     * @return txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public TextBoxFlexibleDate getTxtIdoYMD() {
        return txtIdoYMD;
    }

    /*
     * settxtIdoYMD
     * @param txtIdoYMD txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public void setTxtIdoYMD(TextBoxFlexibleDate txtIdoYMD) {
        this.txtIdoYMD = txtIdoYMD;
    }

    /*
     * getradIdoKubun
     * @return radIdoKubun
     */
    @JsonProperty("radIdoKubun")
    public RadioButton getRadIdoKubun() {
        return radIdoKubun;
    }

    /*
     * setradIdoKubun
     * @param radIdoKubun radIdoKubun
     */
    @JsonProperty("radIdoKubun")
    public void setRadIdoKubun(RadioButton radIdoKubun) {
        this.radIdoKubun = radIdoKubun;
    }

    /*
     * getddlJukyushaIdoJiyu
     * @return ddlJukyushaIdoJiyu
     */
    @JsonProperty("ddlJukyushaIdoJiyu")
    public DropDownList getDdlJukyushaIdoJiyu() {
        return ddlJukyushaIdoJiyu;
    }

    /*
     * setddlJukyushaIdoJiyu
     * @param ddlJukyushaIdoJiyu ddlJukyushaIdoJiyu
     */
    @JsonProperty("ddlJukyushaIdoJiyu")
    public void setDdlJukyushaIdoJiyu(DropDownList ddlJukyushaIdoJiyu) {
        this.ddlJukyushaIdoJiyu = ddlJukyushaIdoJiyu;
    }

    /*
     * gettxtHiHokenshaNo
     * @return txtHiHokenshaNo
     */
    @JsonProperty("txtHiHokenshaNo")
    public TextBoxCode getTxtHiHokenshaNo() {
        return txtHiHokenshaNo;
    }

    /*
     * settxtHiHokenshaNo
     * @param txtHiHokenshaNo txtHiHokenshaNo
     */
    @JsonProperty("txtHiHokenshaNo")
    public void setTxtHiHokenshaNo(TextBoxCode txtHiHokenshaNo) {
        this.txtHiHokenshaNo = txtHiHokenshaNo;
    }

    /*
     * gettxtHiHokenshaNameKana
     * @return txtHiHokenshaNameKana
     */
    @JsonProperty("txtHiHokenshaNameKana")
    public TextBoxKana getTxtHiHokenshaNameKana() {
        return txtHiHokenshaNameKana;
    }

    /*
     * settxtHiHokenshaNameKana
     * @param txtHiHokenshaNameKana txtHiHokenshaNameKana
     */
    @JsonProperty("txtHiHokenshaNameKana")
    public void setTxtHiHokenshaNameKana(TextBoxKana txtHiHokenshaNameKana) {
        this.txtHiHokenshaNameKana = txtHiHokenshaNameKana;
    }

    /*
     * gettxtUmareYMD
     * @return txtUmareYMD
     */
    @JsonProperty("txtUmareYMD")
    public TextBoxFlexibleDate getTxtUmareYMD() {
        return txtUmareYMD;
    }

    /*
     * settxtUmareYMD
     * @param txtUmareYMD txtUmareYMD
     */
    @JsonProperty("txtUmareYMD")
    public void setTxtUmareYMD(TextBoxFlexibleDate txtUmareYMD) {
        this.txtUmareYMD = txtUmareYMD;
    }

    /*
     * getradSeibetsu
     * @return radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public RadioButton getRadSeibetsu() {
        return radSeibetsu;
    }

    /*
     * setradSeibetsu
     * @param radSeibetsu radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public void setRadSeibetsu(RadioButton radSeibetsu) {
        this.radSeibetsu = radSeibetsu;
    }

    /*
     * gettxtShikakuShutokuYMD
     * @return txtShikakuShutokuYMD
     */
    @JsonProperty("txtShikakuShutokuYMD")
    public TextBoxFlexibleDate getTxtShikakuShutokuYMD() {
        return txtShikakuShutokuYMD;
    }

    /*
     * settxtShikakuShutokuYMD
     * @param txtShikakuShutokuYMD txtShikakuShutokuYMD
     */
    @JsonProperty("txtShikakuShutokuYMD")
    public void setTxtShikakuShutokuYMD(TextBoxFlexibleDate txtShikakuShutokuYMD) {
        this.txtShikakuShutokuYMD = txtShikakuShutokuYMD;
    }

    /*
     * gettxtShikakuSoshitsuYMD
     * @return txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public TextBoxFlexibleDate getTxtShikakuSoshitsuYMD() {
        return txtShikakuSoshitsuYMD;
    }

    /*
     * settxtShikakuSoshitsuYMD
     * @param txtShikakuSoshitsuYMD txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public void setTxtShikakuSoshitsuYMD(TextBoxFlexibleDate txtShikakuSoshitsuYMD) {
        this.txtShikakuSoshitsuYMD = txtShikakuSoshitsuYMD;
    }

    /*
     * gettxtShoKisaiHokenshaNo
     * @return txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public TextBoxCode getTxtShoKisaiHokenshaNo() {
        return txtShoKisaiHokenshaNo;
    }

    /*
     * settxtShoKisaiHokenshaNo
     * @param txtShoKisaiHokenshaNo txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public void setTxtShoKisaiHokenshaNo(TextBoxCode txtShoKisaiHokenshaNo) {
        this.txtShoKisaiHokenshaNo = txtShoKisaiHokenshaNo;
    }

    /*
     * gettxtKoikiHokenshaNo
     * @return txtKoikiHokenshaNo
     */
    @JsonProperty("txtKoikiHokenshaNo")
    public TextBoxCode getTxtKoikiHokenshaNo() {
        return txtKoikiHokenshaNo;
    }

    /*
     * settxtKoikiHokenshaNo
     * @param txtKoikiHokenshaNo txtKoikiHokenshaNo
     */
    @JsonProperty("txtKoikiHokenshaNo")
    public void setTxtKoikiHokenshaNo(TextBoxCode txtKoikiHokenshaNo) {
        this.txtKoikiHokenshaNo = txtKoikiHokenshaNo;
    }

    /*
     * gettxtSofuYM
     * @return txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public TextBoxFlexibleDate getTxtSofuYM() {
        return txtSofuYM;
    }

    /*
     * settxtSofuYM
     * @param txtSofuYM txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxFlexibleDate txtSofuYM) {
        this.txtSofuYM = txtSofuYM;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    // </editor-fold>
}
