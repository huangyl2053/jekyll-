package jp.co.ndensan.reams.db.dbe.divcontroller.entity.kaigoNinteiKekka;
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
    @JsonProperty("txtShinseibi")
    private TextBoxFlexibleDate txtShinseibi;
    @JsonProperty("txtShinseiKubunShinsei")
    private TextBox txtShinseiKubunShinsei;
    @JsonProperty("txtShinseiKubunHorei")
    private TextBox txtShinseiKubunHorei;
    @JsonProperty("txtShinsaJun")
    private TextBox txtShinsaJun;
    @JsonProperty("ddlNinteiKubun")
    private DropDownList ddlNinteiKubun;
    @JsonProperty("txtIchijiHanteiKekka")
    private TextBox txtIchijiHanteiKekka;
    @JsonProperty("ddlTokuteiShippei")
    private DropDownList ddlTokuteiShippei;
    @JsonProperty("txtNinteibi")
    private TextBoxFlexibleDate txtNinteibi;
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("ddlJotaiZo")
    private DropDownList ddlJotaiZo;
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
    @JsonProperty("txtShinseibi")
    public TextBoxFlexibleDate getTxtShinseibi() {
        return txtShinseibi;
    }

    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxFlexibleDate txtShinseibi) {
        this.txtShinseibi=txtShinseibi;
    }

    @JsonProperty("txtShinseiKubunShinsei")
    public TextBox getTxtShinseiKubunShinsei() {
        return txtShinseiKubunShinsei;
    }

    @JsonProperty("txtShinseiKubunShinsei")
    public void setTxtShinseiKubunShinsei(TextBox txtShinseiKubunShinsei) {
        this.txtShinseiKubunShinsei=txtShinseiKubunShinsei;
    }

    @JsonProperty("txtShinseiKubunHorei")
    public TextBox getTxtShinseiKubunHorei() {
        return txtShinseiKubunHorei;
    }

    @JsonProperty("txtShinseiKubunHorei")
    public void setTxtShinseiKubunHorei(TextBox txtShinseiKubunHorei) {
        this.txtShinseiKubunHorei=txtShinseiKubunHorei;
    }

    @JsonProperty("txtShinsaJun")
    public TextBox getTxtShinsaJun() {
        return txtShinsaJun;
    }

    @JsonProperty("txtShinsaJun")
    public void setTxtShinsaJun(TextBox txtShinsaJun) {
        this.txtShinsaJun=txtShinsaJun;
    }

    @JsonProperty("ddlNinteiKubun")
    public DropDownList getDdlNinteiKubun() {
        return ddlNinteiKubun;
    }

    @JsonProperty("ddlNinteiKubun")
    public void setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.ddlNinteiKubun=ddlNinteiKubun;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka=txtIchijiHanteiKekka;
    }

    @JsonProperty("ddlTokuteiShippei")
    public DropDownList getDdlTokuteiShippei() {
        return ddlTokuteiShippei;
    }

    @JsonProperty("ddlTokuteiShippei")
    public void setDdlTokuteiShippei(DropDownList ddlTokuteiShippei) {
        this.ddlTokuteiShippei=ddlTokuteiShippei;
    }

    @JsonProperty("txtNinteibi")
    public TextBoxFlexibleDate getTxtNinteibi() {
        return txtNinteibi;
    }

    @JsonProperty("txtNinteibi")
    public void setTxtNinteibi(TextBoxFlexibleDate txtNinteibi) {
        this.txtNinteibi=txtNinteibi;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka=ddlNijiHanteiKekka;
    }

    @JsonProperty("ddlJotaiZo")
    public DropDownList getDdlJotaiZo() {
        return ddlJotaiZo;
    }

    @JsonProperty("ddlJotaiZo")
    public void setDdlJotaiZo(DropDownList ddlJotaiZo) {
        this.ddlJotaiZo=ddlJotaiZo;
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
