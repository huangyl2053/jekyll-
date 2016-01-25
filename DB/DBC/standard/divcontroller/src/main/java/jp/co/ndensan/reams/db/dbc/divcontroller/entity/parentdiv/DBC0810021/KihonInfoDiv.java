package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KihonInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelTwo")
    private panelTwoDiv panelTwo;
    @JsonProperty("panelKihon")
    private panelKihonDiv panelKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelTwo
     * @return panelTwo
     */
    @JsonProperty("panelTwo")
    public panelTwoDiv getPanelTwo() {
        return panelTwo;
    }

    /*
     * setpanelTwo
     * @param panelTwo panelTwo
     */
    @JsonProperty("panelTwo")
    public void setPanelTwo(panelTwoDiv panelTwo) {
        this.panelTwo = panelTwo;
    }

    /*
     * getpanelKihon
     * @return panelKihon
     */
    @JsonProperty("panelKihon")
    public panelKihonDiv getPanelKihon() {
        return panelKihon;
    }

    /*
     * setpanelKihon
     * @param panelKihon panelKihon
     */
    @JsonProperty("panelKihon")
    public void setPanelKihon(panelKihonDiv panelKihon) {
        this.panelKihon = panelKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public panelKyotakuDiv getPanelKyotaku() {
        return this.getPanelKihon().getPanelKyotaku();
    }

    @JsonIgnore
    public void  setPanelKyotaku(panelKyotakuDiv panelKyotaku) {
        this.getPanelKihon().setPanelKyotaku(panelKyotaku);
    }

    @JsonIgnore
    public TextBox getTxtKeikakuSakuseiKubun() {
        return this.getPanelKihon().getPanelKyotaku().getTxtKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void  setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.getPanelKihon().getPanelKyotaku().setTxtKeikakuSakuseiKubun(txtKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkKyusochi() {
        return this.getPanelKihon().getPanelKyotaku().getChkKyusochi();
    }

    @JsonIgnore
    public void  setChkKyusochi(CheckBoxList chkKyusochi) {
        this.getPanelKihon().getPanelKyotaku().setChkKyusochi(chkKyusochi);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyosha() {
        return this.getPanelKihon().getPanelKyotaku().getTxtJigyosha();
    }

    @JsonIgnore
    public void  setTxtJigyosha(TextBoxCode txtJigyosha) {
        this.getPanelKihon().getPanelKyotaku().setTxtJigyosha(txtJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getPanelKihon().getPanelKyotaku().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getPanelKihon().getPanelKyotaku().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuritsu() {
        return this.getPanelKihon().getPanelKyotaku().getTxtHokenKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtHokenKyufuritsu(TextBoxNum txtHokenKyufuritsu) {
        this.getPanelKihon().getPanelKyotaku().setTxtHokenKyufuritsu(txtHokenKyufuritsu);
    }

    @JsonIgnore
    public HorizontalLine getHlFour() {
        return this.getPanelKihon().getHlFour();
    }

    @JsonIgnore
    public void  setHlFour(HorizontalLine hlFour) {
        this.getPanelKihon().setHlFour(hlFour);
    }

    @JsonIgnore
    public panelServiceKikanDiv getPanelServiceKikan() {
        return this.getPanelKihon().getPanelServiceKikan();
    }

    @JsonIgnore
    public void  setPanelServiceKikan(panelServiceKikanDiv panelServiceKikan) {
        this.getPanelKihon().setPanelServiceKikan(panelServiceKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtServiceKikan() {
        return this.getPanelKihon().getPanelServiceKikan().getTxtServiceKikan();
    }

    @JsonIgnore
    public void  setTxtServiceKikan(TextBoxDateRange txtServiceKikan) {
        this.getPanelKihon().getPanelServiceKikan().setTxtServiceKikan(txtServiceKikan);
    }

    @JsonIgnore
    public TextBox getTxtCyushiRiyu() {
        return this.getPanelKihon().getPanelServiceKikan().getTxtCyushiRiyu();
    }

    @JsonIgnore
    public void  setTxtCyushiRiyu(TextBox txtCyushiRiyu) {
        this.getPanelKihon().getPanelServiceKikan().setTxtCyushiRiyu(txtCyushiRiyu);
    }

    @JsonIgnore
    public panelShisetuNyutaisyoInfoDiv getPanelShisetuNyutaisyoInfo() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo();
    }

    @JsonIgnore
    public void  setPanelShisetuNyutaisyoInfo(panelShisetuNyutaisyoInfoDiv panelShisetuNyutaisyoInfo) {
        this.getPanelKihon().setPanelShisetuNyutaisyoInfo(panelShisetuNyutaisyoInfo);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyushoYMD() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD();
    }

    @JsonIgnore
    public void  setTxtNyushoYMD(TextBoxDate txtNyushoYMD) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtNyushoYMD(txtNyushoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtNyushoJitsuNissu() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu();
    }

    @JsonIgnore
    public void  setTxtNyushoJitsuNissu(TextBoxNum txtNyushoJitsuNissu) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtNyushoJitsuNissu(txtNyushoJitsuNissu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoYMD() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtTaishoYMD(TextBoxDate txtTaishoYMD) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtTaishoYMD(txtTaishoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtGaigakuNissu() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu();
    }

    @JsonIgnore
    public void  setTxtGaigakuNissu(TextBoxNum txtGaigakuNissu) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtGaigakuNissu(txtGaigakuNissu);
    }

    @JsonIgnore
    public TextBox getTxtNyushoMaeState() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoMaeState();
    }

    @JsonIgnore
    public void  setTxtNyushoMaeState(TextBox txtNyushoMaeState) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtNyushoMaeState(txtNyushoMaeState);
    }

    @JsonIgnore
    public TextBox getTxtTaishoMaeState() {
        return this.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoMaeState();
    }

    @JsonIgnore
    public void  setTxtTaishoMaeState(TextBox txtTaishoMaeState) {
        this.getPanelKihon().getPanelShisetuNyutaisyoInfo().setTxtTaishoMaeState(txtTaishoMaeState);
    }

    // </editor-fold>
}
