package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PnlTotalRegister のクラスファイル
 *
 * @author 自動生成
 */
public class PnlTotalRegisterDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlKeyakuJigyosya")
    private PnlKeyakuJigyosyaDiv PnlKeyakuJigyosya;
    @JsonProperty("PnlHakoubi")
    private PnlHakoubiDiv PnlHakoubi;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlKeyakuJigyosya
     * @return PnlKeyakuJigyosya
     */
    @JsonProperty("PnlKeyakuJigyosya")
    public PnlKeyakuJigyosyaDiv getPnlKeyakuJigyosya() {
        return PnlKeyakuJigyosya;
    }

    /*
     * setPnlKeyakuJigyosya
     * @param PnlKeyakuJigyosya PnlKeyakuJigyosya
     */
    @JsonProperty("PnlKeyakuJigyosya")
    public void setPnlKeyakuJigyosya(PnlKeyakuJigyosyaDiv PnlKeyakuJigyosya) {
        this.PnlKeyakuJigyosya = PnlKeyakuJigyosya;
    }

    /*
     * getPnlHakoubi
     * @return PnlHakoubi
     */
    @JsonProperty("PnlHakoubi")
    public PnlHakoubiDiv getPnlHakoubi() {
        return PnlHakoubi;
    }

    /*
     * setPnlHakoubi
     * @param PnlHakoubi PnlHakoubi
     */
    @JsonProperty("PnlHakoubi")
    public void setPnlHakoubi(PnlHakoubiDiv PnlHakoubi) {
        this.PnlHakoubi = PnlHakoubi;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnCopy() {
        return this.getPnlKeyakuJigyosya().getBtnCopy();
    }

    @JsonIgnore
    public void setBtnCopy(Button btnCopy) {
        this.getPnlKeyakuJigyosya().setBtnCopy(btnCopy);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyosyakeiyakuNo() {
        return this.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo();
    }

    @JsonIgnore
    public void setTxtJigyosyakeiyakuNo(TextBoxCode txtJigyosyakeiyakuNo) {
        this.getPnlKeyakuJigyosya().setTxtJigyosyakeiyakuNo(txtJigyosyakeiyakuNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKeyakubi() {
        return this.getPnlKeyakuJigyosya().getTxtKeyakubi();
    }

    @JsonIgnore
    public void setTxtKeyakubi(TextBoxDateRange txtKeyakubi) {
        this.getPnlKeyakuJigyosya().setTxtKeyakubi(txtKeyakubi);
    }

    @JsonIgnore
    public DropDownList getDdlKeyakusyurui() {
        return this.getPnlKeyakuJigyosya().getDdlKeyakusyurui();
    }

    @JsonIgnore
    public void setDdlKeyakusyurui(DropDownList ddlKeyakusyurui) {
        this.getPnlKeyakuJigyosya().setDdlKeyakusyurui(ddlKeyakusyurui);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtKeyakuJigyosyaMeisyo() {
        return this.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo();
    }

    @JsonIgnore
    public void setTxtKeyakuJigyosyaMeisyo(TextBoxAtenaMeisho txtKeyakuJigyosyaMeisyo) {
        this.getPnlKeyakuJigyosya().setTxtKeyakuJigyosyaMeisyo(txtKeyakuJigyosyaMeisyo);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtKeyakuJigyosyaMeisyoKana() {
        return this.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana();
    }

    @JsonIgnore
    public void setTxtKeyakuJigyosyaMeisyoKana(TextBoxAtenaKanaMeisho txtKeyakuJigyosyaMeisyoKana) {
        this.getPnlKeyakuJigyosya().setTxtKeyakuJigyosyaMeisyoKana(txtKeyakuJigyosyaMeisyoKana);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtJigyosyaYubinNo() {
        return this.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo();
    }

    @JsonIgnore
    public void setTxtJigyosyaYubinNo(TextBoxYubinNo txtJigyosyaYubinNo) {
        this.getPnlKeyakuJigyosya().setTxtJigyosyaYubinNo(txtJigyosyaYubinNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJigyosyaTel() {
        return this.getPnlKeyakuJigyosya().getTxtJigyosyaTel();
    }

    @JsonIgnore
    public void setTxtJigyosyaTel(TextBoxTelNo txtJigyosyaTel) {
        this.getPnlKeyakuJigyosya().setTxtJigyosyaTel(txtJigyosyaTel);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtJigyosyaFax() {
        return this.getPnlKeyakuJigyosya().getTxtJigyosyaFax();
    }

    @JsonIgnore
    public void setTxtJigyosyaFax(TextBoxTelNo txtJigyosyaFax) {
        this.getPnlKeyakuJigyosya().setTxtJigyosyaFax(txtJigyosyaFax);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJigyosyaJyusyo() {
        return this.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo();
    }

    @JsonIgnore
    public void setTxtJigyosyaJyusyo(TextBoxJusho txtJigyosyaJyusyo) {
        this.getPnlKeyakuJigyosya().setTxtJigyosyaJyusyo(txtJigyosyaJyusyo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtSofusakiYubin() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiYubin();
    }

    @JsonIgnore
    public void setTxtSofusakiYubin(TextBoxYubinNo txtSofusakiYubin) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiYubin(txtSofusakiYubin);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtSofusakiJigyosya() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya();
    }

    @JsonIgnore
    public void setTxtSofusakiJigyosya(TextBoxAtenaMeisho txtSofusakiJigyosya) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiJigyosya(txtSofusakiJigyosya);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtSofusakiJigyosyaKana() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana();
    }

    @JsonIgnore
    public void setTxtSofusakiJigyosyaKana(TextBoxAtenaKanaMeisho txtSofusakiJigyosyaKana) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiJigyosyaKana(txtSofusakiJigyosyaKana);
    }

    @JsonIgnore
    public TextBoxJusho getTxtSofusakiJyusyo() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo();
    }

    @JsonIgnore
    public void setTxtSofusakiJyusyo(TextBoxJusho txtSofusakiJyusyo) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiJyusyo(txtSofusakiJyusyo);
    }

    @JsonIgnore
    public TextBox getTxtSofusakiBusyo() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiBusyo();
    }

    @JsonIgnore
    public void setTxtSofusakiBusyo(TextBox txtSofusakiBusyo) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiBusyo(txtSofusakiBusyo);
    }

    @JsonIgnore
    public DropDownList getDdlSofusakiKouzasyubetu() {
        return this.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu();
    }

    @JsonIgnore
    public void setDdlSofusakiKouzasyubetu(DropDownList ddlSofusakiKouzasyubetu) {
        this.getPnlKeyakuJigyosya().setDdlSofusakiKouzasyubetu(ddlSofusakiKouzasyubetu);
    }

    @JsonIgnore
    public TextBox getTxtSofusakiKouzabango() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango();
    }

    @JsonIgnore
    public void setTxtSofusakiKouzabango(TextBox txtSofusakiKouzabango) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiKouzabango(txtSofusakiKouzabango);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtSofusakiKouzaMeiginin() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin();
    }

    @JsonIgnore
    public void setTxtSofusakiKouzaMeiginin(TextBoxAtenaMeisho txtSofusakiKouzaMeiginin) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiKouzaMeiginin(txtSofusakiKouzaMeiginin);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtSofusakiKouzaMeigininKana() {
        return this.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana();
    }

    @JsonIgnore
    public void setTxtSofusakiKouzaMeigininKana(TextBoxAtenaKanaMeisho txtSofusakiKouzaMeigininKana) {
        this.getPnlKeyakuJigyosya().setTxtSofusakiKouzaMeigininKana(txtSofusakiKouzaMeigininKana);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKinyukikan() {
        return this.getPnlKeyakuJigyosya().getCcdKinyukikan();
    }

    // </editor-fold>
}
