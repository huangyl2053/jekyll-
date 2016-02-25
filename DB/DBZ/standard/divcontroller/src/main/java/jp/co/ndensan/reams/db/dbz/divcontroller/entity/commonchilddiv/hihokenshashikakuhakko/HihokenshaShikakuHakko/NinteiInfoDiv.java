package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYMD")
    private TextBoxDate txtNinteiYMD;
    @JsonProperty("txtNinteiYukoFromYMD")
    private TextBoxDate txtNinteiYukoFromYMD;
    @JsonProperty("lblKara1")
    private Label lblKara1;
    @JsonProperty("txtNinteiYukoToYMD")
    private TextBoxDate txtNinteiYukoToYMD;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("chkSeidoitsuseiShogai")
    private CheckBoxList chkSeidoitsuseiShogai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYokaigodo
     * @return txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    /*
     * settxtYokaigodo
     * @param txtYokaigodo txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo = txtYokaigodo;
    }

    /*
     * gettxtNinteiYMD
     * @return txtNinteiYMD
     */
    @JsonProperty("txtNinteiYMD")
    public TextBoxDate getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    /*
     * settxtNinteiYMD
     * @param txtNinteiYMD txtNinteiYMD
     */
    @JsonProperty("txtNinteiYMD")
    public void setTxtNinteiYMD(TextBoxDate txtNinteiYMD) {
        this.txtNinteiYMD = txtNinteiYMD;
    }

    /*
     * gettxtNinteiYukoFromYMD
     * @return txtNinteiYukoFromYMD
     */
    @JsonProperty("txtNinteiYukoFromYMD")
    public TextBoxDate getTxtNinteiYukoFromYMD() {
        return txtNinteiYukoFromYMD;
    }

    /*
     * settxtNinteiYukoFromYMD
     * @param txtNinteiYukoFromYMD txtNinteiYukoFromYMD
     */
    @JsonProperty("txtNinteiYukoFromYMD")
    public void setTxtNinteiYukoFromYMD(TextBoxDate txtNinteiYukoFromYMD) {
        this.txtNinteiYukoFromYMD = txtNinteiYukoFromYMD;
    }

    /*
     * getlblKara1
     * @return lblKara1
     */
    @JsonProperty("lblKara1")
    public Label getLblKara1() {
        return lblKara1;
    }

    /*
     * setlblKara1
     * @param lblKara1 lblKara1
     */
    @JsonProperty("lblKara1")
    public void setLblKara1(Label lblKara1) {
        this.lblKara1 = lblKara1;
    }

    /*
     * gettxtNinteiYukoToYMD
     * @return txtNinteiYukoToYMD
     */
    @JsonProperty("txtNinteiYukoToYMD")
    public TextBoxDate getTxtNinteiYukoToYMD() {
        return txtNinteiYukoToYMD;
    }

    /*
     * settxtNinteiYukoToYMD
     * @param txtNinteiYukoToYMD txtNinteiYukoToYMD
     */
    @JsonProperty("txtNinteiYukoToYMD")
    public void setTxtNinteiYukoToYMD(TextBoxDate txtNinteiYukoToYMD) {
        this.txtNinteiYukoToYMD = txtNinteiYukoToYMD;
    }

    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getchkSeidoitsuseiShogai
     * @return chkSeidoitsuseiShogai
     */
    @JsonProperty("chkSeidoitsuseiShogai")
    public CheckBoxList getChkSeidoitsuseiShogai() {
        return chkSeidoitsuseiShogai;
    }

    /*
     * setchkSeidoitsuseiShogai
     * @param chkSeidoitsuseiShogai chkSeidoitsuseiShogai
     */
    @JsonProperty("chkSeidoitsuseiShogai")
    public void setChkSeidoitsuseiShogai(CheckBoxList chkSeidoitsuseiShogai) {
        this.chkSeidoitsuseiShogai = chkSeidoitsuseiShogai;
    }

    // </editor-fold>
}
