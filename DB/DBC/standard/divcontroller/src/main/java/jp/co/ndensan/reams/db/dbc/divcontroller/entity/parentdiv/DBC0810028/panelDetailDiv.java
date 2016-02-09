package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028;
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
 * panelDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelShobyoName")
    private panelShobyoNameDiv panelShobyoName;
    @JsonProperty("panelOshinTuyin")
    private panelOshinTuyinDiv panelOshinTuyin;
    @JsonProperty("panelJiryoutensu")
    private panelJiryoutensuDiv panelJiryoutensu;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelShobyoName
     * @return panelShobyoName
     */
    @JsonProperty("panelShobyoName")
    public panelShobyoNameDiv getPanelShobyoName() {
        return panelShobyoName;
    }

    /*
     * setpanelShobyoName
     * @param panelShobyoName panelShobyoName
     */
    @JsonProperty("panelShobyoName")
    public void setPanelShobyoName(panelShobyoNameDiv panelShobyoName) {
        this.panelShobyoName = panelShobyoName;
    }

    /*
     * getpanelOshinTuyin
     * @return panelOshinTuyin
     */
    @JsonProperty("panelOshinTuyin")
    public panelOshinTuyinDiv getPanelOshinTuyin() {
        return panelOshinTuyin;
    }

    /*
     * setpanelOshinTuyin
     * @param panelOshinTuyin panelOshinTuyin
     */
    @JsonProperty("panelOshinTuyin")
    public void setPanelOshinTuyin(panelOshinTuyinDiv panelOshinTuyin) {
        this.panelOshinTuyin = panelOshinTuyin;
    }

    /*
     * getpanelJiryoutensu
     * @return panelJiryoutensu
     */
    @JsonProperty("panelJiryoutensu")
    public panelJiryoutensuDiv getPanelJiryoutensu() {
        return panelJiryoutensu;
    }

    /*
     * setpanelJiryoutensu
     * @param panelJiryoutensu panelJiryoutensu
     */
    @JsonProperty("panelJiryoutensu")
    public void setPanelJiryoutensu(panelJiryoutensuDiv panelJiryoutensu) {
        this.panelJiryoutensu = panelJiryoutensu;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelOshinTuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelOshinTuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelOshinTuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelOshinTuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinIryoKikanName() {
        return this.getPanelOshinTuyin().getTxtOshinIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.getPanelOshinTuyin().setTxtOshinIryoKikanName(txtOshinIryoKikanName);
    }

    @JsonIgnore
    public Label getLblTsuin() {
        return this.getPanelOshinTuyin().getLblTsuin();
    }

    @JsonIgnore
    public void  setLblTsuin(Label lblTsuin) {
        this.getPanelOshinTuyin().setLblTsuin(lblTsuin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTsuyinNissu() {
        return this.getPanelOshinTuyin().getTxtTsuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.getPanelOshinTuyin().setTxtTsuyinNissu(txtTsuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTsuinKikanName() {
        return this.getPanelOshinTuyin().getTxtTsuinKikanName();
    }

    @JsonIgnore
    public void  setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.getPanelOshinTuyin().setTxtTsuinKikanName(txtTsuinKikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyou() {
        return this.getPanelOshinTuyin().getTxtTekiyou();
    }

    @JsonIgnore
    public void  setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.getPanelOshinTuyin().setTxtTekiyou(txtTekiyou);
    }

    // </editor-fold>
}
