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
    public DropDownList getDdlKeikakuSakuseiKubun() {
        return this.getPanelKihon().getPanelKyotaku().getDdlKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void  setDdlKeikakuSakuseiKubun(DropDownList ddlKeikakuSakuseiKubun) {
        this.getPanelKihon().getPanelKyotaku().setDdlKeikakuSakuseiKubun(ddlKeikakuSakuseiKubun);
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
    public Button getBtnSearch() {
        return this.getPanelKihon().getPanelKyotaku().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPanelKihon().getPanelKyotaku().setBtnSearch(btnSearch);
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

    // </editor-fold>
}
