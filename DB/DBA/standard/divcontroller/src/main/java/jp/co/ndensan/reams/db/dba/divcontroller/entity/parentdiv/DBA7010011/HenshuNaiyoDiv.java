package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * HenshuNaiyo のクラスファイル
 *
 * @author 自動生成
 */
public class HenshuNaiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnJushoSentaku")
    private Button btnJushoSentaku;
    @JsonProperty("txtCode")
    private TextBox txtCode;
    @JsonProperty("txtBanchi")
    private TextBox txtBanchi;
    @JsonProperty("lblPost")
    private Label lblPost;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJushoOne")
    private TextBox txtJushoOne;
    @JsonProperty("txtYakushoMeiOne")
    private TextBox txtYakushoMeiOne;
    @JsonProperty("txtJushoTwo")
    private TextBox txtJushoTwo;
    @JsonProperty("txtYakushoMeiTwo")
    private TextBox txtYakushoMeiTwo;
    @JsonProperty("txtOnchu")
    private TextBox txtOnchu;
    @JsonProperty("txtTantokamei")
    private TextBox txtTantokamei;
    @JsonProperty("txtSam")
    private TextBox txtSam;
    @JsonProperty("chkTenNyuGonai")
    private CheckBoxList chkTenNyuGonai;
    @JsonProperty("btnZenkaiBango")
    private Button btnZenkaiBango;
    @JsonProperty("txtBunshoBango")
    private TextBoxCode txtBunshoBango;
    @JsonProperty("btnJidoFuban")
    private Button btnJidoFuban;
    @JsonProperty("ccdPrintContentsSetting")
    private PrintContentsSettingDiv ccdPrintContentsSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnJushoSentaku")
    public Button getBtnJushoSentaku() {
        return btnJushoSentaku;
    }

    @JsonProperty("btnJushoSentaku")
    public void setBtnJushoSentaku(Button btnJushoSentaku) {
        this.btnJushoSentaku = btnJushoSentaku;
    }

    @JsonProperty("txtCode")
    public TextBox getTxtCode() {
        return txtCode;
    }

    @JsonProperty("txtCode")
    public void setTxtCode(TextBox txtCode) {
        this.txtCode = txtCode;
    }

    @JsonProperty("txtBanchi")
    public TextBox getTxtBanchi() {
        return txtBanchi;
    }

    @JsonProperty("txtBanchi")
    public void setTxtBanchi(TextBox txtBanchi) {
        this.txtBanchi = txtBanchi;
    }

    @JsonProperty("lblPost")
    public Label getLblPost() {
        return lblPost;
    }

    @JsonProperty("lblPost")
    public void setLblPost(Label lblPost) {
        this.lblPost = lblPost;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    @JsonProperty("txtJushoOne")
    public TextBox getTxtJushoOne() {
        return txtJushoOne;
    }

    @JsonProperty("txtJushoOne")
    public void setTxtJushoOne(TextBox txtJushoOne) {
        this.txtJushoOne = txtJushoOne;
    }

    @JsonProperty("txtYakushoMeiOne")
    public TextBox getTxtYakushoMeiOne() {
        return txtYakushoMeiOne;
    }

    @JsonProperty("txtYakushoMeiOne")
    public void setTxtYakushoMeiOne(TextBox txtYakushoMeiOne) {
        this.txtYakushoMeiOne = txtYakushoMeiOne;
    }

    @JsonProperty("txtJushoTwo")
    public TextBox getTxtJushoTwo() {
        return txtJushoTwo;
    }

    @JsonProperty("txtJushoTwo")
    public void setTxtJushoTwo(TextBox txtJushoTwo) {
        this.txtJushoTwo = txtJushoTwo;
    }

    @JsonProperty("txtYakushoMeiTwo")
    public TextBox getTxtYakushoMeiTwo() {
        return txtYakushoMeiTwo;
    }

    @JsonProperty("txtYakushoMeiTwo")
    public void setTxtYakushoMeiTwo(TextBox txtYakushoMeiTwo) {
        this.txtYakushoMeiTwo = txtYakushoMeiTwo;
    }

    @JsonProperty("txtOnchu")
    public TextBox getTxtOnchu() {
        return txtOnchu;
    }

    @JsonProperty("txtOnchu")
    public void setTxtOnchu(TextBox txtOnchu) {
        this.txtOnchu = txtOnchu;
    }

    @JsonProperty("txtTantokamei")
    public TextBox getTxtTantokamei() {
        return txtTantokamei;
    }

    @JsonProperty("txtTantokamei")
    public void setTxtTantokamei(TextBox txtTantokamei) {
        this.txtTantokamei = txtTantokamei;
    }

    @JsonProperty("txtSam")
    public TextBox getTxtSam() {
        return txtSam;
    }

    @JsonProperty("txtSam")
    public void setTxtSam(TextBox txtSam) {
        this.txtSam = txtSam;
    }

    @JsonProperty("chkTenNyuGonai")
    public CheckBoxList getChkTenNyuGonai() {
        return chkTenNyuGonai;
    }

    @JsonProperty("chkTenNyuGonai")
    public void setChkTenNyuGonai(CheckBoxList chkTenNyuGonai) {
        this.chkTenNyuGonai = chkTenNyuGonai;
    }

    @JsonProperty("btnZenkaiBango")
    public Button getBtnZenkaiBango() {
        return btnZenkaiBango;
    }

    @JsonProperty("btnZenkaiBango")
    public void setBtnZenkaiBango(Button btnZenkaiBango) {
        this.btnZenkaiBango = btnZenkaiBango;
    }

    @JsonProperty("txtBunshoBango")
    public TextBoxCode getTxtBunshoBango() {
        return txtBunshoBango;
    }

    @JsonProperty("txtBunshoBango")
    public void setTxtBunshoBango(TextBoxCode txtBunshoBango) {
        this.txtBunshoBango = txtBunshoBango;
    }

    @JsonProperty("btnJidoFuban")
    public Button getBtnJidoFuban() {
        return btnJidoFuban;
    }

    @JsonProperty("btnJidoFuban")
    public void setBtnJidoFuban(Button btnJidoFuban) {
        this.btnJidoFuban = btnJidoFuban;
    }

    @JsonProperty("ccdPrintContentsSetting")
    public IPrintContentsSettingDiv getCcdPrintContentsSetting() {
        return ccdPrintContentsSetting;
    }

}
