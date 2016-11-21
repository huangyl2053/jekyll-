package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShikyugakuKeisanKekkaTorokuRenrakuhyo のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTsuchiYMD")
    private TextBoxDate txtTsuchiYMD;
    @JsonProperty("RenrakuhyoHakkoshaPanel")
    private RenrakuhyoHakkoshaPanelDiv RenrakuhyoHakkoshaPanel;
    @JsonProperty("ToiawasesakiPanel")
    private ToiawasesakiPanelDiv ToiawasesakiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTsuchiYMD
     * @return txtTsuchiYMD
     */
    @JsonProperty("txtTsuchiYMD")
    public TextBoxDate getTxtTsuchiYMD() {
        return txtTsuchiYMD;
    }

    /*
     * settxtTsuchiYMD
     * @param txtTsuchiYMD txtTsuchiYMD
     */
    @JsonProperty("txtTsuchiYMD")
    public void setTxtTsuchiYMD(TextBoxDate txtTsuchiYMD) {
        this.txtTsuchiYMD = txtTsuchiYMD;
    }

    /*
     * getRenrakuhyoHakkoshaPanel
     * @return RenrakuhyoHakkoshaPanel
     */
    @JsonProperty("RenrakuhyoHakkoshaPanel")
    public RenrakuhyoHakkoshaPanelDiv getRenrakuhyoHakkoshaPanel() {
        return RenrakuhyoHakkoshaPanel;
    }

    /*
     * setRenrakuhyoHakkoshaPanel
     * @param RenrakuhyoHakkoshaPanel RenrakuhyoHakkoshaPanel
     */
    @JsonProperty("RenrakuhyoHakkoshaPanel")
    public void setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanelDiv RenrakuhyoHakkoshaPanel) {
        this.RenrakuhyoHakkoshaPanel = RenrakuhyoHakkoshaPanel;
    }

    /*
     * getToiawasesakiPanel
     * @return ToiawasesakiPanel
     */
    @JsonProperty("ToiawasesakiPanel")
    public ToiawasesakiPanelDiv getToiawasesakiPanel() {
        return ToiawasesakiPanel;
    }

    /*
     * setToiawasesakiPanel
     * @param ToiawasesakiPanel ToiawasesakiPanel
     */
    @JsonProperty("ToiawasesakiPanel")
    public void setToiawasesakiPanel(ToiawasesakiPanelDiv ToiawasesakiPanel) {
        this.ToiawasesakiPanel = ToiawasesakiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaMei() {
        return this.getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaMei();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaMei(TextBox txtRenrakuhyoHakkoshaMei) {
        this.getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaMei(txtRenrakuhyoHakkoshaMei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtRenrakuhyoHakkoshaYubinNo() {
        return this.getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaYubinNo(TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo) {
        this.getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaYubinNo(txtRenrakuhyoHakkoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaJusho() {
        return this.getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaJusho(TextBox txtRenrakuhyoHakkoshaJusho) {
        this.getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaJusho(txtRenrakuhyoHakkoshaJusho);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho1() {
        return this.getToiawasesakiPanel().getTxtToiawasesakiMeisho1();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho1(TextBox txtToiawasesakiMeisho1) {
        this.getToiawasesakiPanel().setTxtToiawasesakiMeisho1(txtToiawasesakiMeisho1);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtToiawasesakiYobinNo() {
        return this.getToiawasesakiPanel().getTxtToiawasesakiYobinNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiYobinNo(TextBoxYubinNo txtToiawasesakiYobinNo) {
        this.getToiawasesakiPanel().setTxtToiawasesakiYobinNo(txtToiawasesakiYobinNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho2() {
        return this.getToiawasesakiPanel().getTxtToiawasesakiMeisho2();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho2(TextBox txtToiawasesakiMeisho2) {
        this.getToiawasesakiPanel().setTxtToiawasesakiMeisho2(txtToiawasesakiMeisho2);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiTelNo() {
        return this.getToiawasesakiPanel().getTxtToiawasesakiTelNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiTelNo(TextBox txtToiawasesakiTelNo) {
        this.getToiawasesakiPanel().setTxtToiawasesakiTelNo(txtToiawasesakiTelNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiJusho() {
        return this.getToiawasesakiPanel().getTxtToiawasesakiJusho();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiJusho(TextBox txtToiawasesakiJusho) {
        this.getToiawasesakiPanel().setTxtToiawasesakiJusho(txtToiawasesakiJusho);
    }

    // </editor-fold>
}
