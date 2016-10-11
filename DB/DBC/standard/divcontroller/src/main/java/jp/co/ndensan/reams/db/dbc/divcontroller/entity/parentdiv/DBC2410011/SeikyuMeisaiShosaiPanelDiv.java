package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
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
 * SeikyuMeisaiShosaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuMeisaiShosaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("JutakuKaishuRiyushoPanel")
    private JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel;
    @JsonProperty("JutakuKaishuPanel")
    private JutakuKaishuPanelDiv JutakuKaishuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * getJutakuKaishuRiyushoPanel
     * @return JutakuKaishuRiyushoPanel
     */
    @JsonProperty("JutakuKaishuRiyushoPanel")
    public JutakuKaishuRiyushoPanelDiv getJutakuKaishuRiyushoPanel() {
        return JutakuKaishuRiyushoPanel;
    }

    /*
     * setJutakuKaishuRiyushoPanel
     * @param JutakuKaishuRiyushoPanel JutakuKaishuRiyushoPanel
     */
    @JsonProperty("JutakuKaishuRiyushoPanel")
    public void setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel) {
        this.JutakuKaishuRiyushoPanel = JutakuKaishuRiyushoPanel;
    }

    /*
     * getJutakuKaishuPanel
     * @return JutakuKaishuPanel
     */
    @JsonProperty("JutakuKaishuPanel")
    public JutakuKaishuPanelDiv getJutakuKaishuPanel() {
        return JutakuKaishuPanel;
    }

    /*
     * setJutakuKaishuPanel
     * @param JutakuKaishuPanel JutakuKaishuPanel
     */
    @JsonProperty("JutakuKaishuPanel")
    public void setJutakuKaishuPanel(JutakuKaishuPanelDiv JutakuKaishuPanel) {
        this.JutakuKaishuPanel = JutakuKaishuPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return this.getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseiYMD(txtRiyushoSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return this.getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMeiKana(txtRiyushoSakuseishaMeiKana);
    }

    @JsonIgnore
    public TextBox getTxtRiyushoSakuseishaMei() {
        return this.getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMei(txtRiyushoSakuseishaMei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishuShikyuShinseiYMD() {
        return this.getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishuShikyuShinseiYMD(TextBoxDate txtKaishuShikyuShinseiYMD) {
        this.getJutakuKaishuPanel().setTxtKaishuShikyuShinseiYMD(txtKaishuShikyuShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJutakuKaishuChakkoYMD() {
        return this.getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuChakkoYMD(TextBoxDate txtJutakuKaishuChakkoYMD) {
        this.getJutakuKaishuPanel().setTxtJutakuKaishuChakkoYMD(txtJutakuKaishuChakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtJutakuKaishuJigyoshaMeisho() {
        return this.getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuJigyoshaMeisho(TextBox txtJutakuKaishuJigyoshaMeisho) {
        this.getJutakuKaishuPanel().setTxtJutakuKaishuJigyoshaMeisho(txtJutakuKaishuJigyoshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaishuTaishoJutakuJusho() {
        return this.getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho();
    }

    @JsonIgnore
    public void  setTxtKaishuTaishoJutakuJusho(TextBox txtKaishuTaishoJutakuJusho) {
        this.getJutakuKaishuPanel().setTxtKaishuTaishoJutakuJusho(txtKaishuTaishoJutakuJusho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaishuNaiyokashoKibo() {
        return this.getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo();
    }

    @JsonIgnore
    public void  setTxtKaishuNaiyokashoKibo(TextBoxMultiLine txtKaishuNaiyokashoKibo) {
        this.getJutakuKaishuPanel().setTxtKaishuNaiyokashoKibo(txtKaishuNaiyokashoKibo);
    }

    // </editor-fold>
}
