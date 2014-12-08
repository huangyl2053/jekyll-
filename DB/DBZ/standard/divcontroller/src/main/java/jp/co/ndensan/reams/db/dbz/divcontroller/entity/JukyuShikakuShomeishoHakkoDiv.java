package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IJukyuShikakuShomeishoHakkoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyuShikakuShomeishoHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyuShikakuShomeishoHakkoDiv extends Panel implements IJukyuShikakuShomeishoHakkoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("txtIdoYoteiDate")
    private TextBoxFlexibleDate txtIdoYoteiDate;
    @JsonProperty("txtYokaigoJotai")
    private TextBox txtYokaigoJotai;
    @JsonProperty("txtNinteiYukoKikan")
    private TextBoxDateRange txtNinteiYukoKikan;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("lblNinteiShinsakaiIken")
    private Label lblNinteiShinsakaiIken;
    @JsonProperty("txtNinteiShinsakaiIken")
    private TextBoxMultiLine txtNinteiShinsakaiIken;
    @JsonProperty("lblBiko")
    private Label lblBiko;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;
    @JsonProperty("chkJushoHihyoji")
    private CheckBoxList chkJushoHihyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("txtIdoYoteiDate")
    public TextBoxFlexibleDate getTxtIdoYoteiDate() {
        return txtIdoYoteiDate;
    }

    @JsonProperty("txtIdoYoteiDate")
    public void setTxtIdoYoteiDate(TextBoxFlexibleDate txtIdoYoteiDate) {
        this.txtIdoYoteiDate=txtIdoYoteiDate;
    }

    @JsonProperty("txtYokaigoJotai")
    public TextBox getTxtYokaigoJotai() {
        return txtYokaigoJotai;
    }

    @JsonProperty("txtYokaigoJotai")
    public void setTxtYokaigoJotai(TextBox txtYokaigoJotai) {
        this.txtYokaigoJotai=txtYokaigoJotai;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public TextBoxDateRange getTxtNinteiYukoKikan() {
        return txtNinteiYukoKikan;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public void setTxtNinteiYukoKikan(TextBoxDateRange txtNinteiYukoKikan) {
        this.txtNinteiYukoKikan=txtNinteiYukoKikan;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("lblNinteiShinsakaiIken")
    public Label getLblNinteiShinsakaiIken() {
        return lblNinteiShinsakaiIken;
    }

    @JsonProperty("lblNinteiShinsakaiIken")
    public void setLblNinteiShinsakaiIken(Label lblNinteiShinsakaiIken) {
        this.lblNinteiShinsakaiIken=lblNinteiShinsakaiIken;
    }

    @JsonProperty("txtNinteiShinsakaiIken")
    public TextBoxMultiLine getTxtNinteiShinsakaiIken() {
        return txtNinteiShinsakaiIken;
    }

    @JsonProperty("txtNinteiShinsakaiIken")
    public void setTxtNinteiShinsakaiIken(TextBoxMultiLine txtNinteiShinsakaiIken) {
        this.txtNinteiShinsakaiIken=txtNinteiShinsakaiIken;
    }

    @JsonProperty("lblBiko")
    public Label getLblBiko() {
        return lblBiko;
    }

    @JsonProperty("lblBiko")
    public void setLblBiko(Label lblBiko) {
        this.lblBiko=lblBiko;
    }

    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko=txtBiko;
    }

    @JsonProperty("chkJushoHihyoji")
    public CheckBoxList getChkJushoHihyoji() {
        return chkJushoHihyoji;
    }

    @JsonProperty("chkJushoHihyoji")
    public void setChkJushoHihyoji(CheckBoxList chkJushoHihyoji) {
        this.chkJushoHihyoji=chkJushoHihyoji;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
