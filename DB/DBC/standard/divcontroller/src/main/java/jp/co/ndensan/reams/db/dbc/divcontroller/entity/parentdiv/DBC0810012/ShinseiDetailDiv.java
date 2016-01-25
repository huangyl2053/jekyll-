package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelUp")
    private panelUpDiv panelUp;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("pnlShinsei")
    private pnlShinseiDiv pnlShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelUp
     * @return panelUp
     */
    @JsonProperty("panelUp")
    public panelUpDiv getPanelUp() {
        return panelUp;
    }

    /*
     * setpanelUp
     * @param panelUp panelUp
     */
    @JsonProperty("panelUp")
    public void setPanelUp(panelUpDiv panelUp) {
        this.panelUp = panelUp;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpnlShinsei
     * @return pnlShinsei
     */
    @JsonProperty("pnlShinsei")
    public pnlShinseiDiv getPnlShinsei() {
        return pnlShinsei;
    }

    /*
     * setpnlShinsei
     * @param pnlShinsei pnlShinsei
     */
    @JsonProperty("pnlShinsei")
    public void setPnlShinsei(pnlShinseiDiv pnlShinsei) {
        this.pnlShinsei = pnlShinsei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getPnlShinsei().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getPnlShinsei().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getPnlShinsei().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getPnlShinsei().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public RadioButton getRdoShinseisyaKubun() {
        return this.getPnlShinsei().getRdoShinseisyaKubun();
    }

    @JsonIgnore
    public void  setRdoShinseisyaKubun(RadioButton rdoShinseisyaKubun) {
        this.getPnlShinsei().setRdoShinseisyaKubun(rdoShinseisyaKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtKisaiHokensyaBango() {
        return this.getPnlShinsei().getTxtKisaiHokensyaBango();
    }

    @JsonIgnore
    public void  setTxtKisaiHokensyaBango(TextBoxCode txtKisaiHokensyaBango) {
        this.getPnlShinsei().setTxtKisaiHokensyaBango(txtKisaiHokensyaBango);
    }

    @JsonIgnore
    public CheckBoxList getChkKokuhorenSaiso() {
        return this.getPnlShinsei().getChkKokuhorenSaiso();
    }

    @JsonIgnore
    public void  setChkKokuhorenSaiso(CheckBoxList chkKokuhorenSaiso) {
        this.getPnlShinsei().setChkKokuhorenSaiso(chkKokuhorenSaiso);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeikana() {
        return this.getPnlShinsei().getTxtShimeikana();
    }

    @JsonIgnore
    public void  setTxtShimeikana(TextBoxKana txtShimeikana) {
        this.getPnlShinsei().setTxtShimeikana(txtShimeikana);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getPnlShinsei().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getPnlShinsei().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getPnlShinsei().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getPnlShinsei().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMulShinseiRiyu() {
        return this.getPnlShinsei().getTxtMulShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtMulShinseiRiyu(TextBoxMultiLine txtMulShinseiRiyu) {
        this.getPnlShinsei().setTxtMulShinseiRiyu(txtMulShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxNum getTxtNumShiharaKingakuGk() {
        return this.getPnlShinsei().getTxtNumShiharaKingakuGk();
    }

    @JsonIgnore
    public void  setTxtNumShiharaKingakuGk(TextBoxNum txtNumShiharaKingakuGk) {
        this.getPnlShinsei().setTxtNumShiharaKingakuGk(txtNumShiharaKingakuGk);
    }

    @JsonIgnore
    public TextBoxNum getTxtNumHokentaisyoHiyouGaku() {
        return this.getPnlShinsei().getTxtNumHokentaisyoHiyouGaku();
    }

    @JsonIgnore
    public void  setTxtNumHokentaisyoHiyouGaku(TextBoxNum txtNumHokentaisyoHiyouGaku) {
        this.getPnlShinsei().setTxtNumHokentaisyoHiyouGaku(txtNumHokentaisyoHiyouGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNumHokenKyufuGaku() {
        return this.getPnlShinsei().getTxtNumHokenKyufuGaku();
    }

    @JsonIgnore
    public void  setTxtNumHokenKyufuGaku(TextBoxNum txtNumHokenKyufuGaku) {
        this.getPnlShinsei().setTxtNumHokenKyufuGaku(txtNumHokenKyufuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNumRiyoshaFutanGaku() {
        return this.getPnlShinsei().getTxtNumRiyoshaFutanGaku();
    }

    @JsonIgnore
    public void  setTxtNumRiyoshaFutanGaku(TextBoxNum txtNumRiyoshaFutanGaku) {
        this.getPnlShinsei().setTxtNumRiyoshaFutanGaku(txtNumRiyoshaFutanGaku);
    }

    // </editor-fold>
}
