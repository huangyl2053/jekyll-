package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiyoboJohoShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijiyoboJohoShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKikanYMD")
    private TextBoxDateRange txtTekiyoKikanYMD;
    @JsonProperty("txtChosaJisshiYMD")
    private TextBoxDate txtChosaJisshiYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKikanYMD
     * @return txtTekiyoKikanYMD
     */
    @JsonProperty("txtTekiyoKikanYMD")
    public TextBoxDateRange getTxtTekiyoKikanYMD() {
        return txtTekiyoKikanYMD;
    }

    /*
     * settxtTekiyoKikanYMD
     * @param txtTekiyoKikanYMD txtTekiyoKikanYMD
     */
    @JsonProperty("txtTekiyoKikanYMD")
    public void setTxtTekiyoKikanYMD(TextBoxDateRange txtTekiyoKikanYMD) {
        this.txtTekiyoKikanYMD = txtTekiyoKikanYMD;
    }

    /*
     * gettxtChosaJisshiYMD
     * @return txtChosaJisshiYMD
     */
    @JsonProperty("txtChosaJisshiYMD")
    public TextBoxDate getTxtChosaJisshiYMD() {
        return txtChosaJisshiYMD;
    }

    /*
     * settxtChosaJisshiYMD
     * @param txtChosaJisshiYMD txtChosaJisshiYMD
     */
    @JsonProperty("txtChosaJisshiYMD")
    public void setTxtChosaJisshiYMD(TextBoxDate txtChosaJisshiYMD) {
        this.txtChosaJisshiYMD = txtChosaJisshiYMD;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    // </editor-fold>
}
