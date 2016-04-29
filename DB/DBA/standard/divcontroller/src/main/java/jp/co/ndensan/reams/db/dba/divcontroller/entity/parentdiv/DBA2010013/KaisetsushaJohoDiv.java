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
 * KaisetsushaJoho のクラスファイル 
 * 
 * 
 */
public class KaisetsushaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaisetsushaName")
    private TextBox txtKaisetsushaName;
    @JsonProperty("txtKaisetsushaNameKana")
    private TextBox txtKaisetsushaNameKana;
    @JsonProperty("txtKaisetsushaKaisetsuYMD")
    private TextBoxFlexibleDate txtKaisetsushaKaisetsuYMD;
    @JsonProperty("txtKaisetsushaHeisaYMD")
    private TextBoxFlexibleDate txtKaisetsushaHeisaYMD;
    @JsonProperty("txtKaisetsushaYubinNo")
    private TextBoxYubinNo txtKaisetsushaYubinNo;
    @JsonProperty("txtKaisetsushaTelNo")
    private TextBox txtKaisetsushaTelNo;
    @JsonProperty("txtKaisetsushaFaxNo")
    private TextBox txtKaisetsushaFaxNo;
    @JsonProperty("txtKaisetsushaJusho")
    private TextBox txtKaisetsushaJusho;
    @JsonProperty("txtKaisetsushaJushoKana")
    private TextBox txtKaisetsushaJushoKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKaisetsushaName
     * @return txtKaisetsushaName
     */
    @JsonProperty("txtKaisetsushaName")
    public TextBox getTxtKaisetsushaName() {
        return txtKaisetsushaName;
    }

    /*
     * settxtKaisetsushaName
     * @param txtKaisetsushaName txtKaisetsushaName
     */
    @JsonProperty("txtKaisetsushaName")
    public void setTxtKaisetsushaName(TextBox txtKaisetsushaName) {
        this.txtKaisetsushaName = txtKaisetsushaName;
    }

    /*
     * gettxtKaisetsushaNameKana
     * @return txtKaisetsushaNameKana
     */
    @JsonProperty("txtKaisetsushaNameKana")
    public TextBox getTxtKaisetsushaNameKana() {
        return txtKaisetsushaNameKana;
    }

    /*
     * settxtKaisetsushaNameKana
     * @param txtKaisetsushaNameKana txtKaisetsushaNameKana
     */
    @JsonProperty("txtKaisetsushaNameKana")
    public void setTxtKaisetsushaNameKana(TextBox txtKaisetsushaNameKana) {
        this.txtKaisetsushaNameKana = txtKaisetsushaNameKana;
    }

    /*
     * gettxtKaisetsushaKaisetsuYMD
     * @return txtKaisetsushaKaisetsuYMD
     */
    @JsonProperty("txtKaisetsushaKaisetsuYMD")
    public TextBoxFlexibleDate getTxtKaisetsushaKaisetsuYMD() {
        return txtKaisetsushaKaisetsuYMD;
    }

    /*
     * settxtKaisetsushaKaisetsuYMD
     * @param txtKaisetsushaKaisetsuYMD txtKaisetsushaKaisetsuYMD
     */
    @JsonProperty("txtKaisetsushaKaisetsuYMD")
    public void setTxtKaisetsushaKaisetsuYMD(TextBoxFlexibleDate txtKaisetsushaKaisetsuYMD) {
        this.txtKaisetsushaKaisetsuYMD = txtKaisetsushaKaisetsuYMD;
    }

    /*
     * gettxtKaisetsushaHeisaYMD
     * @return txtKaisetsushaHeisaYMD
     */
    @JsonProperty("txtKaisetsushaHeisaYMD")
    public TextBoxFlexibleDate getTxtKaisetsushaHeisaYMD() {
        return txtKaisetsushaHeisaYMD;
    }

    /*
     * settxtKaisetsushaHeisaYMD
     * @param txtKaisetsushaHeisaYMD txtKaisetsushaHeisaYMD
     */
    @JsonProperty("txtKaisetsushaHeisaYMD")
    public void setTxtKaisetsushaHeisaYMD(TextBoxFlexibleDate txtKaisetsushaHeisaYMD) {
        this.txtKaisetsushaHeisaYMD = txtKaisetsushaHeisaYMD;
    }

    /*
     * gettxtKaisetsushaYubinNo
     * @return txtKaisetsushaYubinNo
     */
    @JsonProperty("txtKaisetsushaYubinNo")
    public TextBoxYubinNo getTxtKaisetsushaYubinNo() {
        return txtKaisetsushaYubinNo;
    }

    /*
     * settxtKaisetsushaYubinNo
     * @param txtKaisetsushaYubinNo txtKaisetsushaYubinNo
     */
    @JsonProperty("txtKaisetsushaYubinNo")
    public void setTxtKaisetsushaYubinNo(TextBoxYubinNo txtKaisetsushaYubinNo) {
        this.txtKaisetsushaYubinNo = txtKaisetsushaYubinNo;
    }

    /*
     * gettxtKaisetsushaTelNo
     * @return txtKaisetsushaTelNo
     */
    @JsonProperty("txtKaisetsushaTelNo")
    public TextBox getTxtKaisetsushaTelNo() {
        return txtKaisetsushaTelNo;
    }

    /*
     * settxtKaisetsushaTelNo
     * @param txtKaisetsushaTelNo txtKaisetsushaTelNo
     */
    @JsonProperty("txtKaisetsushaTelNo")
    public void setTxtKaisetsushaTelNo(TextBox txtKaisetsushaTelNo) {
        this.txtKaisetsushaTelNo = txtKaisetsushaTelNo;
    }

    /*
     * gettxtKaisetsushaFaxNo
     * @return txtKaisetsushaFaxNo
     */
    @JsonProperty("txtKaisetsushaFaxNo")
    public TextBox getTxtKaisetsushaFaxNo() {
        return txtKaisetsushaFaxNo;
    }

    /*
     * settxtKaisetsushaFaxNo
     * @param txtKaisetsushaFaxNo txtKaisetsushaFaxNo
     */
    @JsonProperty("txtKaisetsushaFaxNo")
    public void setTxtKaisetsushaFaxNo(TextBox txtKaisetsushaFaxNo) {
        this.txtKaisetsushaFaxNo = txtKaisetsushaFaxNo;
    }

    /*
     * gettxtKaisetsushaJusho
     * @return txtKaisetsushaJusho
     */
    @JsonProperty("txtKaisetsushaJusho")
    public TextBox getTxtKaisetsushaJusho() {
        return txtKaisetsushaJusho;
    }

    /*
     * settxtKaisetsushaJusho
     * @param txtKaisetsushaJusho txtKaisetsushaJusho
     */
    @JsonProperty("txtKaisetsushaJusho")
    public void setTxtKaisetsushaJusho(TextBox txtKaisetsushaJusho) {
        this.txtKaisetsushaJusho = txtKaisetsushaJusho;
    }

    /*
     * gettxtKaisetsushaJushoKana
     * @return txtKaisetsushaJushoKana
     */
    @JsonProperty("txtKaisetsushaJushoKana")
    public TextBox getTxtKaisetsushaJushoKana() {
        return txtKaisetsushaJushoKana;
    }

    /*
     * settxtKaisetsushaJushoKana
     * @param txtKaisetsushaJushoKana txtKaisetsushaJushoKana
     */
    @JsonProperty("txtKaisetsushaJushoKana")
    public void setTxtKaisetsushaJushoKana(TextBox txtKaisetsushaJushoKana) {
        this.txtKaisetsushaJushoKana = txtKaisetsushaJushoKana;
    }

    // </editor-fold>
}
