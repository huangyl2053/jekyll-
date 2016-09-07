package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KetteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKettaiKubun")
    private RadioButton ddlKettaiKubun;
    @JsonProperty("txtKettaiYmd")
    private TextBoxFlexibleDate txtKettaiYmd;
    @JsonProperty("txtTekiyoYmd")
    private TextBoxFlexibleDate txtTekiyoYmd;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("ddlHobetsuKubun")
    private DropDownList ddlHobetsuKubun;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("txtKohiFutanshaNo")
    private TextBox txtKohiFutanshaNo;
    @JsonProperty("txtKohiJyukyshaNo")
    private TextBoxCode txtKohiJyukyshaNo;
    @JsonProperty("txtKohiJyukyushaNoCheckDigit")
    private TextBoxCode txtKohiJyukyushaNoCheckDigit;
    @JsonProperty("btnOpenHiShoninRiyu")
    private ButtonDialog btnOpenHiShoninRiyu;
    @JsonProperty("txtHiShoninRiyu")
    private TextBoxMultiLine txtHiShoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKettaiKubun
     * @return ddlKettaiKubun
     */
    @JsonProperty("ddlKettaiKubun")
    public RadioButton getDdlKettaiKubun() {
        return ddlKettaiKubun;
    }

    /*
     * setddlKettaiKubun
     * @param ddlKettaiKubun ddlKettaiKubun
     */
    @JsonProperty("ddlKettaiKubun")
    public void setDdlKettaiKubun(RadioButton ddlKettaiKubun) {
        this.ddlKettaiKubun = ddlKettaiKubun;
    }

    /*
     * gettxtKettaiYmd
     * @return txtKettaiYmd
     */
    @JsonProperty("txtKettaiYmd")
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return txtKettaiYmd;
    }

    /*
     * settxtKettaiYmd
     * @param txtKettaiYmd txtKettaiYmd
     */
    @JsonProperty("txtKettaiYmd")
    public void setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.txtKettaiYmd = txtKettaiYmd;
    }

    /*
     * gettxtTekiyoYmd
     * @return txtTekiyoYmd
     */
    @JsonProperty("txtTekiyoYmd")
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return txtTekiyoYmd;
    }

    /*
     * settxtTekiyoYmd
     * @param txtTekiyoYmd txtTekiyoYmd
     */
    @JsonProperty("txtTekiyoYmd")
    public void setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.txtTekiyoYmd = txtTekiyoYmd;
    }

    /*
     * gettxtYukoKigen
     * @return txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    /*
     * settxtYukoKigen
     * @param txtYukoKigen txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen = txtYukoKigen;
    }

    /*
     * getddlHobetsuKubun
     * @return ddlHobetsuKubun
     */
    @JsonProperty("ddlHobetsuKubun")
    public DropDownList getDdlHobetsuKubun() {
        return ddlHobetsuKubun;
    }

    /*
     * setddlHobetsuKubun
     * @param ddlHobetsuKubun ddlHobetsuKubun
     */
    @JsonProperty("ddlHobetsuKubun")
    public void setDdlHobetsuKubun(DropDownList ddlHobetsuKubun) {
        this.ddlHobetsuKubun = ddlHobetsuKubun;
    }

    /*
     * gettxtKyufuRitsu
     * @return txtKyufuRitsu
     */
    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    /*
     * settxtKyufuRitsu
     * @param txtKyufuRitsu txtKyufuRitsu
     */
    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu = txtKyufuRitsu;
    }

    /*
     * gettxtKohiFutanshaNo
     * @return txtKohiFutanshaNo
     */
    @JsonProperty("txtKohiFutanshaNo")
    public TextBox getTxtKohiFutanshaNo() {
        return txtKohiFutanshaNo;
    }

    /*
     * settxtKohiFutanshaNo
     * @param txtKohiFutanshaNo txtKohiFutanshaNo
     */
    @JsonProperty("txtKohiFutanshaNo")
    public void setTxtKohiFutanshaNo(TextBox txtKohiFutanshaNo) {
        this.txtKohiFutanshaNo = txtKohiFutanshaNo;
    }

    /*
     * gettxtKohiJyukyshaNo
     * @return txtKohiJyukyshaNo
     */
    @JsonProperty("txtKohiJyukyshaNo")
    public TextBoxCode getTxtKohiJyukyshaNo() {
        return txtKohiJyukyshaNo;
    }

    /*
     * settxtKohiJyukyshaNo
     * @param txtKohiJyukyshaNo txtKohiJyukyshaNo
     */
    @JsonProperty("txtKohiJyukyshaNo")
    public void setTxtKohiJyukyshaNo(TextBoxCode txtKohiJyukyshaNo) {
        this.txtKohiJyukyshaNo = txtKohiJyukyshaNo;
    }

    /*
     * gettxtKohiJyukyushaNoCheckDigit
     * @return txtKohiJyukyushaNoCheckDigit
     */
    @JsonProperty("txtKohiJyukyushaNoCheckDigit")
    public TextBoxCode getTxtKohiJyukyushaNoCheckDigit() {
        return txtKohiJyukyushaNoCheckDigit;
    }

    /*
     * settxtKohiJyukyushaNoCheckDigit
     * @param txtKohiJyukyushaNoCheckDigit txtKohiJyukyushaNoCheckDigit
     */
    @JsonProperty("txtKohiJyukyushaNoCheckDigit")
    public void setTxtKohiJyukyushaNoCheckDigit(TextBoxCode txtKohiJyukyushaNoCheckDigit) {
        this.txtKohiJyukyushaNoCheckDigit = txtKohiJyukyushaNoCheckDigit;
    }

    /*
     * getbtnOpenHiShoninRiyu
     * @return btnOpenHiShoninRiyu
     */
    @JsonProperty("btnOpenHiShoninRiyu")
    public ButtonDialog getBtnOpenHiShoninRiyu() {
        return btnOpenHiShoninRiyu;
    }

    /*
     * setbtnOpenHiShoninRiyu
     * @param btnOpenHiShoninRiyu btnOpenHiShoninRiyu
     */
    @JsonProperty("btnOpenHiShoninRiyu")
    public void setBtnOpenHiShoninRiyu(ButtonDialog btnOpenHiShoninRiyu) {
        this.btnOpenHiShoninRiyu = btnOpenHiShoninRiyu;
    }

    /*
     * gettxtHiShoninRiyu
     * @return txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return txtHiShoninRiyu;
    }

    /*
     * settxtHiShoninRiyu
     * @param txtHiShoninRiyu txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public void setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.txtHiShoninRiyu = txtHiShoninRiyu;
    }

    // </editor-fold>
}
