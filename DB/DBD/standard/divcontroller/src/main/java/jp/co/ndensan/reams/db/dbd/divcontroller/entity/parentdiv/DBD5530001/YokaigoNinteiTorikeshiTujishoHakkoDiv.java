package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * YokaigoNinteiTorikeshiTujishoHakko のクラスファイル
 *
 * @author 自動生成
 */
public class YokaigoNinteiTorikeshiTujishoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TujishoHakkoJoken")
    private TujishoHakkoJokenDiv TujishoHakkoJoken;
    @JsonProperty("TujishoHakkoMeisai")
    private TujishoHakkoMeisaiDiv TujishoHakkoMeisai;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTujishoHakkoJoken
     * @return TujishoHakkoJoken
     */
    @JsonProperty("TujishoHakkoJoken")
    public TujishoHakkoJokenDiv getTujishoHakkoJoken() {
        return TujishoHakkoJoken;
    }

    /*
     * setTujishoHakkoJoken
     * @param TujishoHakkoJoken TujishoHakkoJoken
     */
    @JsonProperty("TujishoHakkoJoken")
    public void setTujishoHakkoJoken(TujishoHakkoJokenDiv TujishoHakkoJoken) {
        this.TujishoHakkoJoken = TujishoHakkoJoken;
    }

    /*
     * getTujishoHakkoMeisai
     * @return TujishoHakkoMeisai
     */
    @JsonProperty("TujishoHakkoMeisai")
    public TujishoHakkoMeisaiDiv getTujishoHakkoMeisai() {
        return TujishoHakkoMeisai;
    }

    /*
     * setTujishoHakkoMeisai
     * @param TujishoHakkoMeisai TujishoHakkoMeisai
     */
    @JsonProperty("TujishoHakkoMeisai")
    public void setTujishoHakkoMeisai(TujishoHakkoMeisaiDiv TujishoHakkoMeisai) {
        this.TujishoHakkoMeisai = TujishoHakkoMeisai;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return this.getTujishoHakkoJoken().getCcdKaigoNinteiAtenaInfo();
    }

    @JsonIgnore
    public IKaigoninteiShikakuInfoDiv getCcdKaigoninteiShikakuInfo() {
        return this.getTujishoHakkoJoken().getCcdKaigoninteiShikakuInfo();
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseibi() {
        return this.getTujishoHakkoMeisai().getTxtSakuseibi();
    }

    @JsonIgnore
    public void setTxtSakuseibi(TextBoxDate txtSakuseibi) {
        this.getTujishoHakkoMeisai().setTxtSakuseibi(txtSakuseibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorikeshibi() {
        return this.getTujishoHakkoMeisai().getTxtTorikeshibi();
    }

    @JsonIgnore
    public void setTxtTorikeshibi(TextBoxDate txtTorikeshibi) {
        this.getTujishoHakkoMeisai().setTxtTorikeshibi(txtTorikeshibi);
    }

    @JsonIgnore
    public Label getLblTorikeshiNintei() {
        return this.getTujishoHakkoMeisai().getLblTorikeshiNintei();
    }

    @JsonIgnore
    public void setLblTorikeshiNintei(Label lblTorikeshiNintei) {
        this.getTujishoHakkoMeisai().setLblTorikeshiNintei(lblTorikeshiNintei);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getTujishoHakkoMeisai().getTxtYokaigodo();
    }

    @JsonIgnore
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getTujishoHakkoMeisai().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukoKigen2() {
        return this.getTujishoHakkoMeisai().getTxtYukoKigen2();
    }

    @JsonIgnore
    public void setTxtYukoKigen2(TextBoxDateRange txtYukoKigen2) {
        this.getTujishoHakkoMeisai().setTxtYukoKigen2(txtYukoKigen2);
    }

    @JsonIgnore
    public TextBox getTxtIdoJiyu() {
        return this.getTujishoHakkoMeisai().getTxtIdoJiyu();
    }

    @JsonIgnore
    public void setTxtIdoJiyu(TextBox txtIdoJiyu) {
        this.getTujishoHakkoMeisai().setTxtIdoJiyu(txtIdoJiyu);
    }

    @JsonIgnore
    public Button getBtnCopyTorikeshiRiyu() {
        return this.getTujishoHakkoMeisai().getBtnCopyTorikeshiRiyu();
    }

    @JsonIgnore
    public void setBtnCopyTorikeshiRiyu(Button btnCopyTorikeshiRiyu) {
        this.getTujishoHakkoMeisai().setBtnCopyTorikeshiRiyu(btnCopyTorikeshiRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return this.getTujishoHakkoMeisai().getTxtTorikeshiRiyu();
    }

    @JsonIgnore
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.getTujishoHakkoMeisai().setTxtTorikeshiRiyu(txtTorikeshiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtHihokenshashoTeishutuKigen() {
        return this.getTujishoHakkoMeisai().getTxtHihokenshashoTeishutuKigen();
    }

    @JsonIgnore
    public void setTxtHihokenshashoTeishutuKigen(TextBoxDate txtHihokenshashoTeishutuKigen) {
        this.getTujishoHakkoMeisai().setTxtHihokenshashoTeishutuKigen(txtHihokenshashoTeishutuKigen);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getTujishoHakkoMeisai().getCcdBunshoBango();
    }

    // </editor-fold>
}
