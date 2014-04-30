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
    private TextBoxDate txtShinseibi;
    @JsonProperty("lblShinseiKubunShinsei")
    private Label lblShinseiKubunShinsei;
    @JsonProperty("txtShinseiKubunShinsei")
    private TextBox txtShinseiKubunShinsei;
    @JsonProperty("lblShinseiKubunHorei")
    private Label lblShinseiKubunHorei;
    @JsonProperty("txtShinseiKubunHorei")
    private TextBox txtShinseiKubunHorei;
    @JsonProperty("lblNinteiKubun")
    private Label lblNinteiKubun;
    @JsonProperty("ddlNinteiKubun")
    private DropDownList ddlNinteiKubun;
    @JsonProperty("lblIchijiHanteiKekka")
    private Label lblIchijiHanteiKekka;
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
    @JsonProperty("lblNijihanteiKekka")
    private Label lblNijihanteiKekka;
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("lblJotaiZo")
    private Label lblJotaiZo;
    @JsonProperty("ddlJotaiZo")
    private DropDownList ddlJotaiZo;
    @JsonProperty("lblNinteiYukoKikan")
    private Label lblNinteiYukoKikan;
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
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;

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
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
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

    @JsonProperty("lblShinseiKubunHorei")
    public Label getLblShinseiKubunHorei() {
        return lblShinseiKubunHorei;
    }

    @JsonProperty("lblShinseiKubunHorei")
    public void setLblShinseiKubunHorei(Label lblShinseiKubunHorei) {
        this.lblShinseiKubunHorei=lblShinseiKubunHorei;
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

    @JsonProperty("lblIchijiHanteiKekka")
    public Label getLblIchijiHanteiKekka() {
        return lblIchijiHanteiKekka;
    }

    @JsonProperty("lblIchijiHanteiKekka")
    public void setLblIchijiHanteiKekka(Label lblIchijiHanteiKekka) {
        this.lblIchijiHanteiKekka=lblIchijiHanteiKekka;
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

    @JsonProperty("lblNijihanteiKekka")
    public Label getLblNijihanteiKekka() {
        return lblNijihanteiKekka;
    }

    @JsonProperty("lblNijihanteiKekka")
    public void setLblNijihanteiKekka(Label lblNijihanteiKekka) {
        this.lblNijihanteiKekka=lblNijihanteiKekka;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka=ddlNijiHanteiKekka;
    }

    @JsonProperty("lblJotaiZo")
    public Label getLblJotaiZo() {
        return lblJotaiZo;
    }

    @JsonProperty("lblJotaiZo")
    public void setLblJotaiZo(Label lblJotaiZo) {
        this.lblJotaiZo=lblJotaiZo;
    }

    @JsonProperty("ddlJotaiZo")
    public DropDownList getDdlJotaiZo() {
        return ddlJotaiZo;
    }

    @JsonProperty("ddlJotaiZo")
    public void setDdlJotaiZo(DropDownList ddlJotaiZo) {
        this.ddlJotaiZo=ddlJotaiZo;
    }

    @JsonProperty("lblNinteiYukoKikan")
    public Label getLblNinteiYukoKikan() {
        return lblNinteiYukoKikan;
    }

    @JsonProperty("lblNinteiYukoKikan")
    public void setLblNinteiYukoKikan(Label lblNinteiYukoKikan) {
        this.lblNinteiYukoKikan=lblNinteiYukoKikan;
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

    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

}
