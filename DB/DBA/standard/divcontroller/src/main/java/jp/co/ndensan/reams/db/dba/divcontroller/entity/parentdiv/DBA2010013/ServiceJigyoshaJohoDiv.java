package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceJigyoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceJigyoshaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYukoKaishiYMD")
    private TextBoxFlexibleDate txtYukoKaishiYMD;
    @JsonProperty("txtYukoShuryoYMD")
    private TextBoxFlexibleDate txtYukoShuryoYMD;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtJigyoshaNameKana")
    private TextBox txtJigyoshaNameKana;
    @JsonProperty("txtJigyoKaishiYMD")
    private TextBoxFlexibleDate txtJigyoKaishiYMD;
    @JsonProperty("txtJigyoKyushuYMD")
    private TextBoxFlexibleDate txtJigyoKyushuYMD;
    @JsonProperty("txtJigyoSaikaiYMD")
    private TextBoxFlexibleDate txtJigyoSaikaiYMD;
    @JsonProperty("txtJigyoHaishiYMD")
    private TextBoxFlexibleDate txtJigyoHaishiYMD;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBox txtFaxNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtJushoKana")
    private TextBox txtJushoKana;
    @JsonProperty("txtShozaiShichoson")
    private TextBox txtShozaiShichoson;
    @JsonProperty("txtServiceTiiki")
    private TextBox txtServiceTiiki;
    @JsonProperty("txtShozokuNum")
    private TextBoxNum txtShozokuNum;
    @JsonProperty("txtRiyoshaNum")
    private TextBoxNum txtRiyoshaNum;
    @JsonProperty("txtBedNum")
    private TextBoxNum txtBedNum;
    @JsonProperty("txtAtesakininName")
    private TextBox txtAtesakininName;
    @JsonProperty("txtAtesakininNameKana")
    private TextBox txtAtesakininNameKana;
    @JsonProperty("txtAtesakiBusho")
    private TextBox txtAtesakiBusho;
    @JsonProperty("ddlHojinShubetsu")
    private DropDownList ddlHojinShubetsu;
    @JsonProperty("ddlShiteiKijungaitoKubun")
    private DropDownList ddlShiteiKijungaitoKubun;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYukoKaishiYMD
     * @return txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public TextBoxFlexibleDate getTxtYukoKaishiYMD() {
        return txtYukoKaishiYMD;
    }

    /*
     * settxtYukoKaishiYMD
     * @param txtYukoKaishiYMD txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public void setTxtYukoKaishiYMD(TextBoxFlexibleDate txtYukoKaishiYMD) {
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
    }

    /*
     * gettxtYukoShuryoYMD
     * @return txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public TextBoxFlexibleDate getTxtYukoShuryoYMD() {
        return txtYukoShuryoYMD;
    }

    /*
     * settxtYukoShuryoYMD
     * @param txtYukoShuryoYMD txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public void setTxtYukoShuryoYMD(TextBoxFlexibleDate txtYukoShuryoYMD) {
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtJigyoshaNameKana
     * @return txtJigyoshaNameKana
     */
    @JsonProperty("txtJigyoshaNameKana")
    public TextBox getTxtJigyoshaNameKana() {
        return txtJigyoshaNameKana;
    }

    /*
     * settxtJigyoshaNameKana
     * @param txtJigyoshaNameKana txtJigyoshaNameKana
     */
    @JsonProperty("txtJigyoshaNameKana")
    public void setTxtJigyoshaNameKana(TextBox txtJigyoshaNameKana) {
        this.txtJigyoshaNameKana = txtJigyoshaNameKana;
    }

    /*
     * gettxtJigyoKaishiYMD
     * @return txtJigyoKaishiYMD
     */
    @JsonProperty("txtJigyoKaishiYMD")
    public TextBoxFlexibleDate getTxtJigyoKaishiYMD() {
        return txtJigyoKaishiYMD;
    }

    /*
     * settxtJigyoKaishiYMD
     * @param txtJigyoKaishiYMD txtJigyoKaishiYMD
     */
    @JsonProperty("txtJigyoKaishiYMD")
    public void setTxtJigyoKaishiYMD(TextBoxFlexibleDate txtJigyoKaishiYMD) {
        this.txtJigyoKaishiYMD = txtJigyoKaishiYMD;
    }

    /*
     * gettxtJigyoKyushuYMD
     * @return txtJigyoKyushuYMD
     */
    @JsonProperty("txtJigyoKyushuYMD")
    public TextBoxFlexibleDate getTxtJigyoKyushuYMD() {
        return txtJigyoKyushuYMD;
    }

    /*
     * settxtJigyoKyushuYMD
     * @param txtJigyoKyushuYMD txtJigyoKyushuYMD
     */
    @JsonProperty("txtJigyoKyushuYMD")
    public void setTxtJigyoKyushuYMD(TextBoxFlexibleDate txtJigyoKyushuYMD) {
        this.txtJigyoKyushuYMD = txtJigyoKyushuYMD;
    }

    /*
     * gettxtJigyoSaikaiYMD
     * @return txtJigyoSaikaiYMD
     */
    @JsonProperty("txtJigyoSaikaiYMD")
    public TextBoxFlexibleDate getTxtJigyoSaikaiYMD() {
        return txtJigyoSaikaiYMD;
    }

    /*
     * settxtJigyoSaikaiYMD
     * @param txtJigyoSaikaiYMD txtJigyoSaikaiYMD
     */
    @JsonProperty("txtJigyoSaikaiYMD")
    public void setTxtJigyoSaikaiYMD(TextBoxFlexibleDate txtJigyoSaikaiYMD) {
        this.txtJigyoSaikaiYMD = txtJigyoSaikaiYMD;
    }

    /*
     * gettxtJigyoHaishiYMD
     * @return txtJigyoHaishiYMD
     */
    @JsonProperty("txtJigyoHaishiYMD")
    public TextBoxFlexibleDate getTxtJigyoHaishiYMD() {
        return txtJigyoHaishiYMD;
    }

    /*
     * settxtJigyoHaishiYMD
     * @param txtJigyoHaishiYMD txtJigyoHaishiYMD
     */
    @JsonProperty("txtJigyoHaishiYMD")
    public void setTxtJigyoHaishiYMD(TextBoxFlexibleDate txtJigyoHaishiYMD) {
        this.txtJigyoHaishiYMD = txtJigyoHaishiYMD;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBox getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBox txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtJushoKana
     * @return txtJushoKana
     */
    @JsonProperty("txtJushoKana")
    public TextBox getTxtJushoKana() {
        return txtJushoKana;
    }

    /*
     * settxtJushoKana
     * @param txtJushoKana txtJushoKana
     */
    @JsonProperty("txtJushoKana")
    public void setTxtJushoKana(TextBox txtJushoKana) {
        this.txtJushoKana = txtJushoKana;
    }

    /*
     * gettxtShozaiShichoson
     * @return txtShozaiShichoson
     */
    @JsonProperty("txtShozaiShichoson")
    public TextBox getTxtShozaiShichoson() {
        return txtShozaiShichoson;
    }

    /*
     * settxtShozaiShichoson
     * @param txtShozaiShichoson txtShozaiShichoson
     */
    @JsonProperty("txtShozaiShichoson")
    public void setTxtShozaiShichoson(TextBox txtShozaiShichoson) {
        this.txtShozaiShichoson = txtShozaiShichoson;
    }

    /*
     * gettxtServiceTiiki
     * @return txtServiceTiiki
     */
    @JsonProperty("txtServiceTiiki")
    public TextBox getTxtServiceTiiki() {
        return txtServiceTiiki;
    }

    /*
     * settxtServiceTiiki
     * @param txtServiceTiiki txtServiceTiiki
     */
    @JsonProperty("txtServiceTiiki")
    public void setTxtServiceTiiki(TextBox txtServiceTiiki) {
        this.txtServiceTiiki = txtServiceTiiki;
    }

    /*
     * gettxtShozokuNum
     * @return txtShozokuNum
     */
    @JsonProperty("txtShozokuNum")
    public TextBoxNum getTxtShozokuNum() {
        return txtShozokuNum;
    }

    /*
     * settxtShozokuNum
     * @param txtShozokuNum txtShozokuNum
     */
    @JsonProperty("txtShozokuNum")
    public void setTxtShozokuNum(TextBoxNum txtShozokuNum) {
        this.txtShozokuNum = txtShozokuNum;
    }

    /*
     * gettxtRiyoshaNum
     * @return txtRiyoshaNum
     */
    @JsonProperty("txtRiyoshaNum")
    public TextBoxNum getTxtRiyoshaNum() {
        return txtRiyoshaNum;
    }

    /*
     * settxtRiyoshaNum
     * @param txtRiyoshaNum txtRiyoshaNum
     */
    @JsonProperty("txtRiyoshaNum")
    public void setTxtRiyoshaNum(TextBoxNum txtRiyoshaNum) {
        this.txtRiyoshaNum = txtRiyoshaNum;
    }

    /*
     * gettxtBedNum
     * @return txtBedNum
     */
    @JsonProperty("txtBedNum")
    public TextBoxNum getTxtBedNum() {
        return txtBedNum;
    }

    /*
     * settxtBedNum
     * @param txtBedNum txtBedNum
     */
    @JsonProperty("txtBedNum")
    public void setTxtBedNum(TextBoxNum txtBedNum) {
        this.txtBedNum = txtBedNum;
    }

    /*
     * gettxtAtesakininName
     * @return txtAtesakininName
     */
    @JsonProperty("txtAtesakininName")
    public TextBox getTxtAtesakininName() {
        return txtAtesakininName;
    }

    /*
     * settxtAtesakininName
     * @param txtAtesakininName txtAtesakininName
     */
    @JsonProperty("txtAtesakininName")
    public void setTxtAtesakininName(TextBox txtAtesakininName) {
        this.txtAtesakininName = txtAtesakininName;
    }

    /*
     * gettxtAtesakininNameKana
     * @return txtAtesakininNameKana
     */
    @JsonProperty("txtAtesakininNameKana")
    public TextBox getTxtAtesakininNameKana() {
        return txtAtesakininNameKana;
    }

    /*
     * settxtAtesakininNameKana
     * @param txtAtesakininNameKana txtAtesakininNameKana
     */
    @JsonProperty("txtAtesakininNameKana")
    public void setTxtAtesakininNameKana(TextBox txtAtesakininNameKana) {
        this.txtAtesakininNameKana = txtAtesakininNameKana;
    }

    /*
     * gettxtAtesakiBusho
     * @return txtAtesakiBusho
     */
    @JsonProperty("txtAtesakiBusho")
    public TextBox getTxtAtesakiBusho() {
        return txtAtesakiBusho;
    }

    /*
     * settxtAtesakiBusho
     * @param txtAtesakiBusho txtAtesakiBusho
     */
    @JsonProperty("txtAtesakiBusho")
    public void setTxtAtesakiBusho(TextBox txtAtesakiBusho) {
        this.txtAtesakiBusho = txtAtesakiBusho;
    }

    /*
     * getddlHojinShubetsu
     * @return ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public DropDownList getDdlHojinShubetsu() {
        return ddlHojinShubetsu;
    }

    /*
     * setddlHojinShubetsu
     * @param ddlHojinShubetsu ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public void setDdlHojinShubetsu(DropDownList ddlHojinShubetsu) {
        this.ddlHojinShubetsu = ddlHojinShubetsu;
    }

    /*
     * getddlShiteiKijungaitoKubun
     * @return ddlShiteiKijungaitoKubun
     */
    @JsonProperty("ddlShiteiKijungaitoKubun")
    public DropDownList getDdlShiteiKijungaitoKubun() {
        return ddlShiteiKijungaitoKubun;
    }

    /*
     * setddlShiteiKijungaitoKubun
     * @param ddlShiteiKijungaitoKubun ddlShiteiKijungaitoKubun
     */
    @JsonProperty("ddlShiteiKijungaitoKubun")
    public void setDdlShiteiKijungaitoKubun(DropDownList ddlShiteiKijungaitoKubun) {
        this.ddlShiteiKijungaitoKubun = ddlShiteiKijungaitoKubun;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    // </editor-fold>
}
