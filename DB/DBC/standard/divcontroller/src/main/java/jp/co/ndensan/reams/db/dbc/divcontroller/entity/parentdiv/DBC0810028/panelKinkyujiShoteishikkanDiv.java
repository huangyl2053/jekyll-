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
 * panelKinkyujiShoteishikkan のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKinkyujiShoteishikkanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdKinkyujiShoteiList")
    private DataGrid<dgdKinkyujiShoteiList_Row> dgdKinkyujiShoteiList;
    @JsonProperty("panelDetail")
    private panelDetailDiv panelDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdKinkyujiShoteiList
     * @return dgdKinkyujiShoteiList
     */
    @JsonProperty("dgdKinkyujiShoteiList")
    public DataGrid<dgdKinkyujiShoteiList_Row> getDgdKinkyujiShoteiList() {
        return dgdKinkyujiShoteiList;
    }

    /*
     * setdgdKinkyujiShoteiList
     * @param dgdKinkyujiShoteiList dgdKinkyujiShoteiList
     */
    @JsonProperty("dgdKinkyujiShoteiList")
    public void setDgdKinkyujiShoteiList(DataGrid<dgdKinkyujiShoteiList_Row> dgdKinkyujiShoteiList) {
        this.dgdKinkyujiShoteiList = dgdKinkyujiShoteiList;
    }

    /*
     * getpanelDetail
     * @return panelDetail
     */
    @JsonProperty("panelDetail")
    public panelDetailDiv getPanelDetail() {
        return panelDetail;
    }

    /*
     * setpanelDetail
     * @param panelDetail panelDetail
     */
    @JsonProperty("panelDetail")
    public void setPanelDetail(panelDetailDiv panelDetail) {
        this.panelDetail = panelDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblOshin() {
        return this.getPanelDetail().getPanelOshinTuyin().getLblOshin();
    }

    @JsonIgnore
    public void  setLblOshin(Label lblOshin) {
        this.getPanelDetail().getPanelOshinTuyin().setLblOshin(lblOshin);
    }

    @JsonIgnore
    public TextBoxNum getTxtOshinNissu() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtOshinNissu();
    }

    @JsonIgnore
    public void  setTxtOshinNissu(TextBoxNum txtOshinNissu) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtOshinNissu(txtOshinNissu);
    }

    @JsonIgnore
    public TextBox getTxtOshinIryoKikanName() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtOshinIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtOshinIryoKikanName(TextBox txtOshinIryoKikanName) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtOshinIryoKikanName(txtOshinIryoKikanName);
    }

    @JsonIgnore
    public Label getLblTsuin() {
        return this.getPanelDetail().getPanelOshinTuyin().getLblTsuin();
    }

    @JsonIgnore
    public void  setLblTsuin(Label lblTsuin) {
        this.getPanelDetail().getPanelOshinTuyin().setLblTsuin(lblTsuin);
    }

    @JsonIgnore
    public TextBoxNum getTxtTsuyinNissu() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTsuyinNissu();
    }

    @JsonIgnore
    public void  setTxtTsuyinNissu(TextBoxNum txtTsuyinNissu) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTsuyinNissu(txtTsuyinNissu);
    }

    @JsonIgnore
    public TextBox getTxtTsuinKikanName() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTsuinKikanName();
    }

    @JsonIgnore
    public void  setTxtTsuinKikanName(TextBox txtTsuinKikanName) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTsuinKikanName(txtTsuinKikanName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTekiyou() {
        return this.getPanelDetail().getPanelOshinTuyin().getTxtTekiyou();
    }

    @JsonIgnore
    public void  setTxtTekiyou(TextBoxMultiLine txtTekiyou) {
        this.getPanelDetail().getPanelOshinTuyin().setTxtTekiyou(txtTekiyou);
    }

    // </editor-fold>
}
