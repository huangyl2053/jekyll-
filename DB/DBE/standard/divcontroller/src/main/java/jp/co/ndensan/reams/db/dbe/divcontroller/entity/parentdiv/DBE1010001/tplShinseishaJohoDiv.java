package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinseishaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinseishaJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-14_20-51-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJohoAtenaMeisho")
    private TextBoxAtenaMeisho txtJohoAtenaMeisho;
    @JsonProperty("txtJohoAtenaKanaMeisho")
    private TextBoxAtenaKanaMeisho txtJohoAtenaKanaMeisho;
    @JsonProperty("txtJohoBirthday")
    private TextBoxDate txtJohoBirthday;
    @JsonProperty("radJohoSeibetsu")
    private RadioButton radJohoSeibetsu;
    @JsonProperty("txtJohoYubinNo")
    private TextBoxYubinNo txtJohoYubinNo;
    @JsonProperty("txtJohoJusho")
    private TextBoxJusho txtJohoJusho;
    @JsonProperty("txtJohoTelNo")
    private TextBoxTelNo txtJohoTelNo;
    @JsonProperty("txtJohoNenrei")
    private TextBox txtJohoNenrei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJohoAtenaMeisho
     * @return txtJohoAtenaMeisho
     */
    @JsonProperty("txtJohoAtenaMeisho")
    public TextBoxAtenaMeisho getTxtJohoAtenaMeisho() {
        return txtJohoAtenaMeisho;
    }

    /*
     * settxtJohoAtenaMeisho
     * @param txtJohoAtenaMeisho txtJohoAtenaMeisho
     */
    @JsonProperty("txtJohoAtenaMeisho")
    public void setTxtJohoAtenaMeisho(TextBoxAtenaMeisho txtJohoAtenaMeisho) {
        this.txtJohoAtenaMeisho = txtJohoAtenaMeisho;
    }

    /*
     * gettxtJohoAtenaKanaMeisho
     * @return txtJohoAtenaKanaMeisho
     */
    @JsonProperty("txtJohoAtenaKanaMeisho")
    public TextBoxAtenaKanaMeisho getTxtJohoAtenaKanaMeisho() {
        return txtJohoAtenaKanaMeisho;
    }

    /*
     * settxtJohoAtenaKanaMeisho
     * @param txtJohoAtenaKanaMeisho txtJohoAtenaKanaMeisho
     */
    @JsonProperty("txtJohoAtenaKanaMeisho")
    public void setTxtJohoAtenaKanaMeisho(TextBoxAtenaKanaMeisho txtJohoAtenaKanaMeisho) {
        this.txtJohoAtenaKanaMeisho = txtJohoAtenaKanaMeisho;
    }

    /*
     * gettxtJohoBirthday
     * @return txtJohoBirthday
     */
    @JsonProperty("txtJohoBirthday")
    public TextBoxDate getTxtJohoBirthday() {
        return txtJohoBirthday;
    }

    /*
     * settxtJohoBirthday
     * @param txtJohoBirthday txtJohoBirthday
     */
    @JsonProperty("txtJohoBirthday")
    public void setTxtJohoBirthday(TextBoxDate txtJohoBirthday) {
        this.txtJohoBirthday = txtJohoBirthday;
    }

    /*
     * getradJohoSeibetsu
     * @return radJohoSeibetsu
     */
    @JsonProperty("radJohoSeibetsu")
    public RadioButton getRadJohoSeibetsu() {
        return radJohoSeibetsu;
    }

    /*
     * setradJohoSeibetsu
     * @param radJohoSeibetsu radJohoSeibetsu
     */
    @JsonProperty("radJohoSeibetsu")
    public void setRadJohoSeibetsu(RadioButton radJohoSeibetsu) {
        this.radJohoSeibetsu = radJohoSeibetsu;
    }

    /*
     * gettxtJohoYubinNo
     * @return txtJohoYubinNo
     */
    @JsonProperty("txtJohoYubinNo")
    public TextBoxYubinNo getTxtJohoYubinNo() {
        return txtJohoYubinNo;
    }

    /*
     * settxtJohoYubinNo
     * @param txtJohoYubinNo txtJohoYubinNo
     */
    @JsonProperty("txtJohoYubinNo")
    public void setTxtJohoYubinNo(TextBoxYubinNo txtJohoYubinNo) {
        this.txtJohoYubinNo = txtJohoYubinNo;
    }

    /*
     * gettxtJohoJusho
     * @return txtJohoJusho
     */
    @JsonProperty("txtJohoJusho")
    public TextBoxJusho getTxtJohoJusho() {
        return txtJohoJusho;
    }

    /*
     * settxtJohoJusho
     * @param txtJohoJusho txtJohoJusho
     */
    @JsonProperty("txtJohoJusho")
    public void setTxtJohoJusho(TextBoxJusho txtJohoJusho) {
        this.txtJohoJusho = txtJohoJusho;
    }

    /*
     * gettxtJohoTelNo
     * @return txtJohoTelNo
     */
    @JsonProperty("txtJohoTelNo")
    public TextBoxTelNo getTxtJohoTelNo() {
        return txtJohoTelNo;
    }

    /*
     * settxtJohoTelNo
     * @param txtJohoTelNo txtJohoTelNo
     */
    @JsonProperty("txtJohoTelNo")
    public void setTxtJohoTelNo(TextBoxTelNo txtJohoTelNo) {
        this.txtJohoTelNo = txtJohoTelNo;
    }

    /*
     * gettxtJohoNenrei
     * @return txtJohoNenrei
     */
    @JsonProperty("txtJohoNenrei")
    public TextBox getTxtJohoNenrei() {
        return txtJohoNenrei;
    }

    /*
     * settxtJohoNenrei
     * @param txtJohoNenrei txtJohoNenrei
     */
    @JsonProperty("txtJohoNenrei")
    public void setTxtJohoNenrei(TextBox txtJohoNenrei) {
        this.txtJohoNenrei = txtJohoNenrei;
    }

    // </editor-fold>
}
