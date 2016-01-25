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
 * panelKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKihonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKyotaku")
    private panelKyotakuDiv panelKyotaku;
    @JsonProperty("hlFour")
    private HorizontalLine hlFour;
    @JsonProperty("panelServiceKikan")
    private panelServiceKikanDiv panelServiceKikan;
    @JsonProperty("panelShisetuNyutaisyoInfo")
    private panelShisetuNyutaisyoInfoDiv panelShisetuNyutaisyoInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKyotaku
     * @return panelKyotaku
     */
    @JsonProperty("panelKyotaku")
    public panelKyotakuDiv getPanelKyotaku() {
        return panelKyotaku;
    }

    /*
     * setpanelKyotaku
     * @param panelKyotaku panelKyotaku
     */
    @JsonProperty("panelKyotaku")
    public void setPanelKyotaku(panelKyotakuDiv panelKyotaku) {
        this.panelKyotaku = panelKyotaku;
    }

    /*
     * gethlFour
     * @return hlFour
     */
    @JsonProperty("hlFour")
    public HorizontalLine getHlFour() {
        return hlFour;
    }

    /*
     * sethlFour
     * @param hlFour hlFour
     */
    @JsonProperty("hlFour")
    public void setHlFour(HorizontalLine hlFour) {
        this.hlFour = hlFour;
    }

    /*
     * getpanelServiceKikan
     * @return panelServiceKikan
     */
    @JsonProperty("panelServiceKikan")
    public panelServiceKikanDiv getPanelServiceKikan() {
        return panelServiceKikan;
    }

    /*
     * setpanelServiceKikan
     * @param panelServiceKikan panelServiceKikan
     */
    @JsonProperty("panelServiceKikan")
    public void setPanelServiceKikan(panelServiceKikanDiv panelServiceKikan) {
        this.panelServiceKikan = panelServiceKikan;
    }

    /*
     * getpanelShisetuNyutaisyoInfo
     * @return panelShisetuNyutaisyoInfo
     */
    @JsonProperty("panelShisetuNyutaisyoInfo")
    public panelShisetuNyutaisyoInfoDiv getPanelShisetuNyutaisyoInfo() {
        return panelShisetuNyutaisyoInfo;
    }

    /*
     * setpanelShisetuNyutaisyoInfo
     * @param panelShisetuNyutaisyoInfo panelShisetuNyutaisyoInfo
     */
    @JsonProperty("panelShisetuNyutaisyoInfo")
    public void setPanelShisetuNyutaisyoInfo(panelShisetuNyutaisyoInfoDiv panelShisetuNyutaisyoInfo) {
        this.panelShisetuNyutaisyoInfo = panelShisetuNyutaisyoInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKeikakuSakuseiKubun() {
        return this.getPanelKyotaku().getTxtKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void  setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.getPanelKyotaku().setTxtKeikakuSakuseiKubun(txtKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkKyusochi() {
        return this.getPanelKyotaku().getChkKyusochi();
    }

    @JsonIgnore
    public void  setChkKyusochi(CheckBoxList chkKyusochi) {
        this.getPanelKyotaku().setChkKyusochi(chkKyusochi);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyosha() {
        return this.getPanelKyotaku().getTxtJigyosha();
    }

    @JsonIgnore
    public void  setTxtJigyosha(TextBoxCode txtJigyosha) {
        this.getPanelKyotaku().setTxtJigyosha(txtJigyosha);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getPanelKyotaku().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getPanelKyotaku().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuritsu() {
        return this.getPanelKyotaku().getTxtHokenKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtHokenKyufuritsu(TextBoxNum txtHokenKyufuritsu) {
        this.getPanelKyotaku().setTxtHokenKyufuritsu(txtHokenKyufuritsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtServiceKikan() {
        return this.getPanelServiceKikan().getTxtServiceKikan();
    }

    @JsonIgnore
    public void  setTxtServiceKikan(TextBoxDateRange txtServiceKikan) {
        this.getPanelServiceKikan().setTxtServiceKikan(txtServiceKikan);
    }

    @JsonIgnore
    public TextBox getTxtCyushiRiyu() {
        return this.getPanelServiceKikan().getTxtCyushiRiyu();
    }

    @JsonIgnore
    public void  setTxtCyushiRiyu(TextBox txtCyushiRiyu) {
        this.getPanelServiceKikan().setTxtCyushiRiyu(txtCyushiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyushoYMD() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD();
    }

    @JsonIgnore
    public void  setTxtNyushoYMD(TextBoxDate txtNyushoYMD) {
        this.getPanelShisetuNyutaisyoInfo().setTxtNyushoYMD(txtNyushoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtNyushoJitsuNissu() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu();
    }

    @JsonIgnore
    public void  setTxtNyushoJitsuNissu(TextBoxNum txtNyushoJitsuNissu) {
        this.getPanelShisetuNyutaisyoInfo().setTxtNyushoJitsuNissu(txtNyushoJitsuNissu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoYMD() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD();
    }

    @JsonIgnore
    public void  setTxtTaishoYMD(TextBoxDate txtTaishoYMD) {
        this.getPanelShisetuNyutaisyoInfo().setTxtTaishoYMD(txtTaishoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtGaigakuNissu() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu();
    }

    @JsonIgnore
    public void  setTxtGaigakuNissu(TextBoxNum txtGaigakuNissu) {
        this.getPanelShisetuNyutaisyoInfo().setTxtGaigakuNissu(txtGaigakuNissu);
    }

    @JsonIgnore
    public TextBox getTxtNyushoMaeState() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtNyushoMaeState();
    }

    @JsonIgnore
    public void  setTxtNyushoMaeState(TextBox txtNyushoMaeState) {
        this.getPanelShisetuNyutaisyoInfo().setTxtNyushoMaeState(txtNyushoMaeState);
    }

    @JsonIgnore
    public TextBox getTxtTaishoMaeState() {
        return this.getPanelShisetuNyutaisyoInfo().getTxtTaishoMaeState();
    }

    @JsonIgnore
    public void  setTxtTaishoMaeState(TextBox txtTaishoMaeState) {
        this.getPanelShisetuNyutaisyoInfo().setTxtTaishoMaeState(txtTaishoMaeState);
    }

    // </editor-fold>
}
