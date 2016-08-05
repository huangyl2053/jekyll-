package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TujishoHakkoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TujishoHakkoMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseibi")
    private TextBoxDate txtSakuseibi;
    @JsonProperty("txtTorikeshibi")
    private TextBoxDate txtTorikeshibi;
    @JsonProperty("lblTorikeshiNintei")
    private Label lblTorikeshiNintei;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtYukoKigen2")
    private TextBoxDateRange txtYukoKigen2;
    @JsonProperty("txtIdoJiyu")
    private TextBox txtIdoJiyu;
    @JsonProperty("btnCopyTorikeshiRiyu")
    private Button btnCopyTorikeshiRiyu;
    @JsonProperty("txtTorikeshiRiyu")
    private TextBoxMultiLine txtTorikeshiRiyu;
    @JsonProperty("txtHihokenshashoTeishutuKigen")
    private TextBoxDate txtHihokenshashoTeishutuKigen;
    @JsonProperty("ccdBunshoBango")
    private BunshoBangoInputDiv ccdBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseibi
     * @return txtSakuseibi
     */
    @JsonProperty("txtSakuseibi")
    public TextBoxDate getTxtSakuseibi() {
        return txtSakuseibi;
    }

    /*
     * settxtSakuseibi
     * @param txtSakuseibi txtSakuseibi
     */
    @JsonProperty("txtSakuseibi")
    public void setTxtSakuseibi(TextBoxDate txtSakuseibi) {
        this.txtSakuseibi = txtSakuseibi;
    }

    /*
     * gettxtTorikeshibi
     * @return txtTorikeshibi
     */
    @JsonProperty("txtTorikeshibi")
    public TextBoxDate getTxtTorikeshibi() {
        return txtTorikeshibi;
    }

    /*
     * settxtTorikeshibi
     * @param txtTorikeshibi txtTorikeshibi
     */
    @JsonProperty("txtTorikeshibi")
    public void setTxtTorikeshibi(TextBoxDate txtTorikeshibi) {
        this.txtTorikeshibi = txtTorikeshibi;
    }

    /*
     * getlblTorikeshiNintei
     * @return lblTorikeshiNintei
     */
    @JsonProperty("lblTorikeshiNintei")
    public Label getLblTorikeshiNintei() {
        return lblTorikeshiNintei;
    }

    /*
     * setlblTorikeshiNintei
     * @param lblTorikeshiNintei lblTorikeshiNintei
     */
    @JsonProperty("lblTorikeshiNintei")
    public void setLblTorikeshiNintei(Label lblTorikeshiNintei) {
        this.lblTorikeshiNintei = lblTorikeshiNintei;
    }

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
     * gettxtYukoKigen2
     * @return txtYukoKigen2
     */
    @JsonProperty("txtYukoKigen2")
    public TextBoxDateRange getTxtYukoKigen2() {
        return txtYukoKigen2;
    }

    /*
     * settxtYukoKigen2
     * @param txtYukoKigen2 txtYukoKigen2
     */
    @JsonProperty("txtYukoKigen2")
    public void setTxtYukoKigen2(TextBoxDateRange txtYukoKigen2) {
        this.txtYukoKigen2 = txtYukoKigen2;
    }

    /*
     * gettxtIdoJiyu
     * @return txtIdoJiyu
     */
    @JsonProperty("txtIdoJiyu")
    public TextBox getTxtIdoJiyu() {
        return txtIdoJiyu;
    }

    /*
     * settxtIdoJiyu
     * @param txtIdoJiyu txtIdoJiyu
     */
    @JsonProperty("txtIdoJiyu")
    public void setTxtIdoJiyu(TextBox txtIdoJiyu) {
        this.txtIdoJiyu = txtIdoJiyu;
    }

    /*
     * getbtnCopyTorikeshiRiyu
     * @return btnCopyTorikeshiRiyu
     */
    @JsonProperty("btnCopyTorikeshiRiyu")
    public Button getBtnCopyTorikeshiRiyu() {
        return btnCopyTorikeshiRiyu;
    }

    /*
     * setbtnCopyTorikeshiRiyu
     * @param btnCopyTorikeshiRiyu btnCopyTorikeshiRiyu
     */
    @JsonProperty("btnCopyTorikeshiRiyu")
    public void setBtnCopyTorikeshiRiyu(Button btnCopyTorikeshiRiyu) {
        this.btnCopyTorikeshiRiyu = btnCopyTorikeshiRiyu;
    }

    /*
     * gettxtTorikeshiRiyu
     * @return txtTorikeshiRiyu
     */
    @JsonProperty("txtTorikeshiRiyu")
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return txtTorikeshiRiyu;
    }

    /*
     * settxtTorikeshiRiyu
     * @param txtTorikeshiRiyu txtTorikeshiRiyu
     */
    @JsonProperty("txtTorikeshiRiyu")
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.txtTorikeshiRiyu = txtTorikeshiRiyu;
    }

    /*
     * gettxtHihokenshashoTeishutuKigen
     * @return txtHihokenshashoTeishutuKigen
     */
    @JsonProperty("txtHihokenshashoTeishutuKigen")
    public TextBoxDate getTxtHihokenshashoTeishutuKigen() {
        return txtHihokenshashoTeishutuKigen;
    }

    /*
     * settxtHihokenshashoTeishutuKigen
     * @param txtHihokenshashoTeishutuKigen txtHihokenshashoTeishutuKigen
     */
    @JsonProperty("txtHihokenshashoTeishutuKigen")
    public void setTxtHihokenshashoTeishutuKigen(TextBoxDate txtHihokenshashoTeishutuKigen) {
        this.txtHihokenshashoTeishutuKigen = txtHihokenshashoTeishutuKigen;
    }

    /*
     * getccdBunshoBango
     * @return ccdBunshoBango
     */
    @JsonProperty("ccdBunshoBango")
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return ccdBunshoBango;
    }

    // </editor-fold>
}
