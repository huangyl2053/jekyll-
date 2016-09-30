package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SougouZigyouTaishouShousai のクラスファイル 
 * 
 * @author 自動生成
 */
public class SougouZigyouTaishouShousaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtymfromto")
    private TextBoxDateRange txtymfromto;
    @JsonProperty("txtChekkurisutoZisshibi")
    private TextBoxDate txtChekkurisutoZisshibi;
    @JsonProperty("txtKetteibi")
    private TextBoxDate txtKetteibi;
    @JsonProperty("Line1")
    private HorizontalLine Line1;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("hiddenModel")
    private RString hiddenModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtymfromto
     * @return txtymfromto
     */
    @JsonProperty("txtymfromto")
    public TextBoxDateRange getTxtymfromto() {
        return txtymfromto;
    }

    /*
     * settxtymfromto
     * @param txtymfromto txtymfromto
     */
    @JsonProperty("txtymfromto")
    public void setTxtymfromto(TextBoxDateRange txtymfromto) {
        this.txtymfromto = txtymfromto;
    }

    /*
     * gettxtChekkurisutoZisshibi
     * @return txtChekkurisutoZisshibi
     */
    @JsonProperty("txtChekkurisutoZisshibi")
    public TextBoxDate getTxtChekkurisutoZisshibi() {
        return txtChekkurisutoZisshibi;
    }

    /*
     * settxtChekkurisutoZisshibi
     * @param txtChekkurisutoZisshibi txtChekkurisutoZisshibi
     */
    @JsonProperty("txtChekkurisutoZisshibi")
    public void setTxtChekkurisutoZisshibi(TextBoxDate txtChekkurisutoZisshibi) {
        this.txtChekkurisutoZisshibi = txtChekkurisutoZisshibi;
    }

    /*
     * gettxtKetteibi
     * @return txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public TextBoxDate getTxtKetteibi() {
        return txtKetteibi;
    }

    /*
     * settxtKetteibi
     * @param txtKetteibi txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public void setTxtKetteibi(TextBoxDate txtKetteibi) {
        this.txtKetteibi = txtKetteibi;
    }

    /*
     * getLine1
     * @return Line1
     */
    @JsonProperty("Line1")
    public HorizontalLine getLine1() {
        return Line1;
    }

    /*
     * setLine1
     * @param Line1 Line1
     */
    @JsonProperty("Line1")
    public void setLine1(HorizontalLine Line1) {
        this.Line1 = Line1;
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

    /*
     * gethiddenModel
     * @return hiddenModel
     */
    @JsonProperty("hiddenModel")
    public RString getHiddenModel() {
        return hiddenModel;
    }

    /*
     * sethiddenModel
     * @param hiddenModel hiddenModel
     */
    @JsonProperty("hiddenModel")
    public void setHiddenModel(RString hiddenModel) {
        this.hiddenModel = hiddenModel;
    }

    // </editor-fold>
}
