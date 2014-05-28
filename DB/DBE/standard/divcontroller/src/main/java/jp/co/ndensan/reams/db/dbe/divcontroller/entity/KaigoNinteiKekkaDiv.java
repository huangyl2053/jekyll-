package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoNinteiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinseibi")
    private Label lblShinseibi;
    @JsonProperty("txtShinseibi")
    private TextBoxFlexibleDate txtShinseibi;
    @JsonProperty("lblShinseiKubunShinsei")
    private Label lblShinseiKubunShinsei;
    @JsonProperty("txtShinseiKubunShinsei")
    private TextBox txtShinseiKubunShinsei;
    @JsonProperty("lblShinseiKubun")
    private Label lblShinseiKubun;
    @JsonProperty("txtShinseiKubunHorei")
    private TextBox txtShinseiKubunHorei;
    @JsonProperty("lblNinteiKubun")
    private Label lblNinteiKubun;
    @JsonProperty("ddlNinteiKubun")
    private DropDownList ddlNinteiKubun;
    @JsonProperty("lblIchijiHantei")
    private Label lblIchijiHantei;
    @JsonProperty("txtIchijiHanteiKekka")
    private TextBox txtIchijiHanteiKekka;
    @JsonProperty("lblTokuteiShippei")
    private Label lblTokuteiShippei;
    @JsonProperty("ddlTokuteiShippei")
    private DropDownList ddlTokuteiShippei;
    @JsonProperty("lblNinteibi")
    private Label lblNinteibi;
    @JsonProperty("txtNinteibi")
    private TextBoxFlexibleDate txtNinteibi;
    @JsonProperty("lblNijiHantei")
    private Label lblNijiHantei;
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("lblJotaizoRei")
    private Label lblJotaizoRei;
    @JsonProperty("ddlJotaiZo")
    private DropDownList ddlJotaiZo;
    @JsonProperty("lblNinteiKikan")
    private Label lblNinteiKikan;
    @JsonProperty("txtNinteiYukoKikanStart")
    private TextBoxFlexibleDate txtNinteiYukoKikanStart;
    @JsonProperty("lblKara3")
    private Label lblKara3;
    @JsonProperty("txtNinteiYukoKikanEnd")
    private TextBoxFlexibleDate txtNinteiYukoKikanEnd;
    @JsonProperty("ddlNinteiYukoTsukisu")
    private DropDownList ddlNinteiYukoTsukisu;
    @JsonProperty("lblShinsakaiIken")
    private Label lblShinsakaiIken;
    @JsonProperty("btnShinsaIkenTeikei")
    private ButtonDialog btnShinsaIkenTeikei;
    @JsonProperty("lblShinsakaiMemo")
    private Label lblShinsakaiMemo;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("txtShinsakaiMemo")
    private TextBoxMultiLine txtShinsakaiMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseibi")
    public Label getLblShinseibi() {
        return lblShinseibi;
    }

    @JsonProperty("lblShinseibi")
    public void setLblShinseibi(Label lblShinseibi) {
        this.lblShinseibi=lblShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public TextBoxFlexibleDate getTxtShinseibi() {
        return txtShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxFlexibleDate txtShinseibi) {
        this.txtShinseibi=txtShinseibi;
    }

    @JsonProperty("lblShinseiKubunShinsei")
    public Label getLblShinseiKubunShinsei() {
        return lblShinseiKubunShinsei;
    }

    @JsonProperty("lblShinseiKubunShinsei")
    public void setLblShinseiKubunShinsei(Label lblShinseiKubunShinsei) {
        this.lblShinseiKubunShinsei=lblShinseiKubunShinsei;
    }

    @JsonProperty("txtShinseiKubunShinsei")
    public TextBox getTxtShinseiKubunShinsei() {
        return txtShinseiKubunShinsei;
    }

    @JsonProperty("txtShinseiKubunShinsei")
    public void setTxtShinseiKubunShinsei(TextBox txtShinseiKubunShinsei) {
        this.txtShinseiKubunShinsei=txtShinseiKubunShinsei;
    }

    @JsonProperty("lblShinseiKubun")
    public Label getLblShinseiKubun() {
        return lblShinseiKubun;
    }

    @JsonProperty("lblShinseiKubun")
    public void setLblShinseiKubun(Label lblShinseiKubun) {
        this.lblShinseiKubun=lblShinseiKubun;
    }

    @JsonProperty("txtShinseiKubunHorei")
    public TextBox getTxtShinseiKubunHorei() {
        return txtShinseiKubunHorei;
    }

    @JsonProperty("txtShinseiKubunHorei")
    public void setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.txtShinseiKubunHorei=txtShinseiKubunHorei;
    }

    @JsonProperty("lblNinteiKubun")
    public Label getLblNinteiKubun() {
        return lblNinteiKubun;
    }

    @JsonProperty("lblNinteiKubun")
    public void setLblNinteiKubun(Label lblNinteiKubun) {
        this.lblNinteiKubun=lblNinteiKubun;
    }

    @JsonProperty("ddlNinteiKubun")
    public DropDownList getDdlNinteiKubun() {
        return ddlNinteiKubun;
    }

    @JsonProperty("ddlNinteiKubun")
    public void setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.ddlNinteiKubun=ddlNinteiKubun;
    }

    @JsonProperty("lblIchijiHantei")
    public Label getLblIchijiHantei() {
        return lblIchijiHantei;
    }

    @JsonProperty("lblIchijiHantei")
    public void setLblIchijiHantei(Label lblIchijiHantei) {
        this.lblIchijiHantei=lblIchijiHantei;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka=txtIchijiHanteiKekka;
    }

    @JsonProperty("lblTokuteiShippei")
    public Label getLblTokuteiShippei() {
        return lblTokuteiShippei;
    }

    @JsonProperty("lblTokuteiShippei")
    public void setLblTokuteiShippei(Label lblTokuteiShippei) {
        this.lblTokuteiShippei=lblTokuteiShippei;
    }

    @JsonProperty("ddlTokuteiShippei")
    public DropDownList getDdlTokuteiShippei() {
        return ddlTokuteiShippei;
    }

    @JsonProperty("ddlTokuteiShippei")
    public void setDdlTokuteiShippei(DropDownList ddlTokuteiShippei) {
        this.ddlTokuteiShippei=ddlTokuteiShippei;
    }

    @JsonProperty("lblNinteibi")
    public Label getLblNinteibi() {
        return lblNinteibi;
    }

    @JsonProperty("lblNinteibi")
    public void setLblNinteibi(Label lblNinteibi) {
        this.lblNinteibi=lblNinteibi;
    }

    @JsonProperty("txtNinteibi")
    public TextBoxFlexibleDate getTxtNinteibi() {
        return txtNinteibi;
    }

    @JsonProperty("txtNinteibi")
    public void setTxtNinteibi(TextBoxFlexibleDate txtNinteibi) {
        this.txtNinteibi=txtNinteibi;
    }

    @JsonProperty("lblNijiHantei")
    public Label getLblNijiHantei() {
        return lblNijiHantei;
    }

    @JsonProperty("lblNijiHantei")
    public void setLblNijiHantei(Label lblNijiHantei) {
        this.lblNijiHantei=lblNijiHantei;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka=ddlNijiHanteiKekka;
    }

    @JsonProperty("lblJotaizoRei")
    public Label getLblJotaizoRei() {
        return lblJotaizoRei;
    }

    @JsonProperty("lblJotaizoRei")
    public void setLblJotaizoRei(Label lblJotaizoRei) {
        this.lblJotaizoRei=lblJotaizoRei;
    }

    @JsonProperty("ddlJotaiZo")
    public DropDownList getDdlJotaiZo() {
        return ddlJotaiZo;
    }

    @JsonProperty("ddlJotaiZo")
    public void setDdlJotaiZo(DropDownList ddlJotaiZo) {
        this.ddlJotaiZo=ddlJotaiZo;
    }

    @JsonProperty("lblNinteiKikan")
    public Label getLblNinteiKikan() {
        return lblNinteiKikan;
    }

    @JsonProperty("lblNinteiKikan")
    public void setLblNinteiKikan(Label lblNinteiKikan) {
        this.lblNinteiKikan=lblNinteiKikan;
    }

    @JsonProperty("txtNinteiYukoKikanStart")
    public TextBoxFlexibleDate getTxtNinteiYukoKikanStart() {
        return txtNinteiYukoKikanStart;
    }

    @JsonProperty("txtNinteiYukoKikanStart")
    public void setTxtNinteiYukoKikanStart(TextBoxFlexibleDate txtNinteiYukoKikanStart) {
        this.txtNinteiYukoKikanStart=txtNinteiYukoKikanStart;
    }

    @JsonProperty("lblKara3")
    public Label getLblKara3() {
        return lblKara3;
    }

    @JsonProperty("lblKara3")
    public void setLblKara3(Label lblKara3) {
        this.lblKara3=lblKara3;
    }

    @JsonProperty("txtNinteiYukoKikanEnd")
    public TextBoxFlexibleDate getTxtNinteiYukoKikanEnd() {
        return txtNinteiYukoKikanEnd;
    }

    @JsonProperty("txtNinteiYukoKikanEnd")
    public void setTxtNinteiYukoKikanEnd(TextBoxFlexibleDate txtNinteiYukoKikanEnd) {
        this.txtNinteiYukoKikanEnd=txtNinteiYukoKikanEnd;
    }

    @JsonProperty("ddlNinteiYukoTsukisu")
    public DropDownList getDdlNinteiYukoTsukisu() {
        return ddlNinteiYukoTsukisu;
    }

    @JsonProperty("ddlNinteiYukoTsukisu")
    public void setDdlNinteiYukoTsukisu(DropDownList ddlNinteiYukoTsukisu) {
        this.ddlNinteiYukoTsukisu=ddlNinteiYukoTsukisu;
    }

    @JsonProperty("lblShinsakaiIken")
    public Label getLblShinsakaiIken() {
        return lblShinsakaiIken;
    }

    @JsonProperty("lblShinsakaiIken")
    public void setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.lblShinsakaiIken=lblShinsakaiIken;
    }

    @JsonProperty("btnShinsaIkenTeikei")
    public ButtonDialog getBtnShinsaIkenTeikei() {
        return btnShinsaIkenTeikei;
    }

    @JsonProperty("btnShinsaIkenTeikei")
    public void setBtnShinsaIkenTeikei(ButtonDialog btnShinsaIkenTeikei) {
        this.btnShinsaIkenTeikei=btnShinsaIkenTeikei;
    }

    @JsonProperty("lblShinsakaiMemo")
    public Label getLblShinsakaiMemo() {
        return lblShinsakaiMemo;
    }

    @JsonProperty("lblShinsakaiMemo")
    public void setLblShinsakaiMemo(Label lblShinsakaiMemo) {
        this.lblShinsakaiMemo=lblShinsakaiMemo;
    }

    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiMemo")
    public TextBoxMultiLine getTxtShinsakaiMemo() {
        return txtShinsakaiMemo;
    }

    @JsonProperty("txtShinsakaiMemo")
    public void setTxtShinsakaiMemo(TextBoxMultiLine txtShinsakaiMemo) {
        this.txtShinsakaiMemo=txtShinsakaiMemo;
    }

}
