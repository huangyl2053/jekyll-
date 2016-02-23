package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030;
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
 * SeikyuGakuShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuGakuShukeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelSeikyugakuShukei")
    private panelSeikyugakuShukeiDiv panelSeikyugakuShukei;

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
     * getpanelSeikyugakuShukei
     * @return panelSeikyugakuShukei
     */
    @JsonProperty("panelSeikyugakuShukei")
    public panelSeikyugakuShukeiDiv getPanelSeikyugakuShukei() {
        return panelSeikyugakuShukei;
    }

    /*
     * setpanelSeikyugakuShukei
     * @param panelSeikyugakuShukei panelSeikyugakuShukei
     */
    @JsonProperty("panelSeikyugakuShukei")
    public void setPanelSeikyugakuShukei(panelSeikyugakuShukeiDiv panelSeikyugakuShukei) {
        this.panelSeikyugakuShukei = panelSeikyugakuShukei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgdSeikyugakushukei_Row> getDgdSeikyugakushukei() {
        return this.getPanelSeikyugakuShukei().getDgdSeikyugakushukei();
    }

    @JsonIgnore
    public void  setDgdSeikyugakushukei(DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei) {
        this.getPanelSeikyugakuShukei().setDgdSeikyugakushukei(dgdSeikyugakushukei);
    }

    @JsonIgnore
    public panelSeikyuShokaiDiv getPanelSeikyuShokai() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai();
    }

    @JsonIgnore
    public void  setPanelSeikyuShokai(panelSeikyuShokaiDiv panelSeikyuShokai) {
        this.getPanelSeikyugakuShukei().setPanelSeikyuShokai(panelSeikyuShokai);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceShurui() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtServiceShurui();
    }

    @JsonIgnore
    public void  setTxtServiceShurui(TextBoxCode txtServiceShurui) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtServiceShurui(txtServiceShurui);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtJitsuNissu() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissu();
    }

    @JsonIgnore
    public void  setTxtJitsuNissu(TextBoxNum txtJitsuNissu) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtJitsuNissu(txtJitsuNissu);
    }

    @JsonIgnore
    public RadioButton getRdoShinsahouhou() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getRdoShinsahouhou();
    }

    @JsonIgnore
    public void  setRdoShinsahouhou(RadioButton rdoShinsahouhou) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setRdoShinsahouhou(rdoShinsahouhou);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikakuTanyi() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuTanyi();
    }

    @JsonIgnore
    public void  setTxtKeikakuTanyi(TextBoxNum txtKeikakuTanyi) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtKeikakuTanyi(txtKeikakuTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtTaishoTanyi() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoTanyi();
    }

    @JsonIgnore
    public void  setTxtTaishoTanyi(TextBoxNum txtTaishoTanyi) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtTaishoTanyi(txtTaishoTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtTaishoGaiTanyi() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTaishoGaiTanyi();
    }

    @JsonIgnore
    public void  setTxtTaishoGaiTanyi(TextBoxNum txtTaishoGaiTanyi) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtTaishoGaiTanyi(txtTaishoGaiTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikakuNissu() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtKeikakuNissu();
    }

    @JsonIgnore
    public void  setTxtKeikakuNissu(TextBoxNum txtKeikakuNissu) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtKeikakuNissu(txtKeikakuNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtJitsuNissuTankinyusho() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho();
    }

    @JsonIgnore
    public void  setTxtJitsuNissuTankinyusho(TextBoxNum txtJitsuNissuTankinyusho) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtJitsuNissuTankinyusho(txtJitsuNissuTankinyusho);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyigokeiHokenbun() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiHokenbun();
    }

    @JsonIgnore
    public void  setTxtTanyigokeiHokenbun(TextBoxNum txtTanyigokeiHokenbun) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtTanyigokeiHokenbun(txtTanyigokeiHokenbun);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiTanka() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyiTanka();
    }

    @JsonIgnore
    public void  setTxtTanyiTanka(TextBoxNum txtTanyiTanka) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtTanyiTanka(txtTanyiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugakuHoken() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuHoken();
    }

    @JsonIgnore
    public void  setTxtSeikyugakuHoken(TextBoxNum txtSeikyugakuHoken) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtSeikyugakuHoken(txtSeikyugakuHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanHoken() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanHoken();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanHoken(TextBoxNum txtRiyoshaFutanHoken) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtRiyoshaFutanHoken(txtRiyoshaFutanHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagakukinngakuHoken() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSagakukinngakuHoken();
    }

    @JsonIgnore
    public void  setTxtSagakukinngakuHoken(TextBoxNum txtSagakukinngakuHoken) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtSagakukinngakuHoken(txtSagakukinngakuHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyigokeiDekikatabun() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun();
    }

    @JsonIgnore
    public void  setTxtTanyigokeiDekikatabun(TextBoxNum txtTanyigokeiDekikatabun) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtTanyigokeiDekikatabun(txtTanyigokeiDekikatabun);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugakuDekikata() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSeikyugakuDekikata();
    }

    @JsonIgnore
    public void  setTxtSeikyugakuDekikata(TextBoxNum txtSeikyugakuDekikata) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtSeikyugakuDekikata(txtSeikyugakuDekikata);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanDekikata() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanDekikata(TextBoxNum txtRiyoshaFutanDekikata) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtRiyoshaFutanDekikata(txtRiyoshaFutanDekikata);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagakukinngakuDekikata() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getTxtSagakukinngakuDekikata();
    }

    @JsonIgnore
    public void  setTxtSagakukinngakuDekikata(TextBoxNum txtSagakukinngakuDekikata) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setTxtSagakukinngakuDekikata(txtSagakukinngakuDekikata);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelSeikyugakuShukei().getPanelSeikyuShokai().setBtnClose(btnClose);
    }

    // </editor-fold>
}
