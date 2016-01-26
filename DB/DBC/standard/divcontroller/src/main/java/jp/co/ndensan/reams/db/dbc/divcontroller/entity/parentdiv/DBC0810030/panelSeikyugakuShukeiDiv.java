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
 * panelSeikyugakuShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelSeikyugakuShukeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdSeikyugakushukei")
    private DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei;
    @JsonProperty("panelSeikyuShokai")
    private panelSeikyuShokaiDiv panelSeikyuShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdSeikyugakushukei
     * @return dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public DataGrid<dgdSeikyugakushukei_Row> getDgdSeikyugakushukei() {
        return dgdSeikyugakushukei;
    }

    /*
     * setdgdSeikyugakushukei
     * @param dgdSeikyugakushukei dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public void setDgdSeikyugakushukei(DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei) {
        this.dgdSeikyugakushukei = dgdSeikyugakushukei;
    }

    /*
     * getpanelSeikyuShokai
     * @return panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public panelSeikyuShokaiDiv getPanelSeikyuShokai() {
        return panelSeikyuShokai;
    }

    /*
     * setpanelSeikyuShokai
     * @param panelSeikyuShokai panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public void setPanelSeikyuShokai(panelSeikyuShokaiDiv panelSeikyuShokai) {
        this.panelSeikyuShokai = panelSeikyuShokai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtServiceShurui() {
        return this.getPanelSeikyuShokai().getTxtServiceShurui();
    }

    @JsonIgnore
    public void  setTxtServiceShurui(TextBoxCode txtServiceShurui) {
        this.getPanelSeikyuShokai().setTxtServiceShurui(txtServiceShurui);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelSeikyuShokai().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelSeikyuShokai().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtJitsuNissu() {
        return this.getPanelSeikyuShokai().getTxtJitsuNissu();
    }

    @JsonIgnore
    public void  setTxtJitsuNissu(TextBoxNum txtJitsuNissu) {
        this.getPanelSeikyuShokai().setTxtJitsuNissu(txtJitsuNissu);
    }

    @JsonIgnore
    public RadioButton getRdoShinsahouhou() {
        return this.getPanelSeikyuShokai().getRdoShinsahouhou();
    }

    @JsonIgnore
    public void  setRdoShinsahouhou(RadioButton rdoShinsahouhou) {
        this.getPanelSeikyuShokai().setRdoShinsahouhou(rdoShinsahouhou);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getPanelSeikyuShokai().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getPanelSeikyuShokai().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikakuTanyi() {
        return this.getPanelSeikyuShokai().getTxtKeikakuTanyi();
    }

    @JsonIgnore
    public void  setTxtKeikakuTanyi(TextBoxNum txtKeikakuTanyi) {
        this.getPanelSeikyuShokai().setTxtKeikakuTanyi(txtKeikakuTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtTaishoTanyi() {
        return this.getPanelSeikyuShokai().getTxtTaishoTanyi();
    }

    @JsonIgnore
    public void  setTxtTaishoTanyi(TextBoxNum txtTaishoTanyi) {
        this.getPanelSeikyuShokai().setTxtTaishoTanyi(txtTaishoTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtTaishoGaiTanyi() {
        return this.getPanelSeikyuShokai().getTxtTaishoGaiTanyi();
    }

    @JsonIgnore
    public void  setTxtTaishoGaiTanyi(TextBoxNum txtTaishoGaiTanyi) {
        this.getPanelSeikyuShokai().setTxtTaishoGaiTanyi(txtTaishoGaiTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikakuNissu() {
        return this.getPanelSeikyuShokai().getTxtKeikakuNissu();
    }

    @JsonIgnore
    public void  setTxtKeikakuNissu(TextBoxNum txtKeikakuNissu) {
        this.getPanelSeikyuShokai().setTxtKeikakuNissu(txtKeikakuNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtJitsuNissuTankinyusho() {
        return this.getPanelSeikyuShokai().getTxtJitsuNissuTankinyusho();
    }

    @JsonIgnore
    public void  setTxtJitsuNissuTankinyusho(TextBoxNum txtJitsuNissuTankinyusho) {
        this.getPanelSeikyuShokai().setTxtJitsuNissuTankinyusho(txtJitsuNissuTankinyusho);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyigokeiHokenbun() {
        return this.getPanelSeikyuShokai().getTxtTanyigokeiHokenbun();
    }

    @JsonIgnore
    public void  setTxtTanyigokeiHokenbun(TextBoxNum txtTanyigokeiHokenbun) {
        this.getPanelSeikyuShokai().setTxtTanyigokeiHokenbun(txtTanyigokeiHokenbun);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiTanka() {
        return this.getPanelSeikyuShokai().getTxtTanyiTanka();
    }

    @JsonIgnore
    public void  setTxtTanyiTanka(TextBoxNum txtTanyiTanka) {
        this.getPanelSeikyuShokai().setTxtTanyiTanka(txtTanyiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugakuHoken() {
        return this.getPanelSeikyuShokai().getTxtSeikyugakuHoken();
    }

    @JsonIgnore
    public void  setTxtSeikyugakuHoken(TextBoxNum txtSeikyugakuHoken) {
        this.getPanelSeikyuShokai().setTxtSeikyugakuHoken(txtSeikyugakuHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanHoken() {
        return this.getPanelSeikyuShokai().getTxtRiyoshaFutanHoken();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanHoken(TextBoxNum txtRiyoshaFutanHoken) {
        this.getPanelSeikyuShokai().setTxtRiyoshaFutanHoken(txtRiyoshaFutanHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagakukinngakuHoken() {
        return this.getPanelSeikyuShokai().getTxtSagakukinngakuHoken();
    }

    @JsonIgnore
    public void  setTxtSagakukinngakuHoken(TextBoxNum txtSagakukinngakuHoken) {
        this.getPanelSeikyuShokai().setTxtSagakukinngakuHoken(txtSagakukinngakuHoken);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyigokeiDekikatabun() {
        return this.getPanelSeikyuShokai().getTxtTanyigokeiDekikatabun();
    }

    @JsonIgnore
    public void  setTxtTanyigokeiDekikatabun(TextBoxNum txtTanyigokeiDekikatabun) {
        this.getPanelSeikyuShokai().setTxtTanyigokeiDekikatabun(txtTanyigokeiDekikatabun);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugakuDekikata() {
        return this.getPanelSeikyuShokai().getTxtSeikyugakuDekikata();
    }

    @JsonIgnore
    public void  setTxtSeikyugakuDekikata(TextBoxNum txtSeikyugakuDekikata) {
        this.getPanelSeikyuShokai().setTxtSeikyugakuDekikata(txtSeikyugakuDekikata);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanDekikata() {
        return this.getPanelSeikyuShokai().getTxtRiyoshaFutanDekikata();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanDekikata(TextBoxNum txtRiyoshaFutanDekikata) {
        this.getPanelSeikyuShokai().setTxtRiyoshaFutanDekikata(txtRiyoshaFutanDekikata);
    }

    @JsonIgnore
    public TextBoxNum getTxtSagakukinngakuDekikata() {
        return this.getPanelSeikyuShokai().getTxtSagakukinngakuDekikata();
    }

    @JsonIgnore
    public void  setTxtSagakukinngakuDekikata(TextBoxNum txtSagakukinngakuDekikata) {
        this.getPanelSeikyuShokai().setTxtSagakukinngakuDekikata(txtSagakukinngakuDekikata);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelSeikyuShokai().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelSeikyuShokai().setBtnClose(btnClose);
    }

    // </editor-fold>
}
