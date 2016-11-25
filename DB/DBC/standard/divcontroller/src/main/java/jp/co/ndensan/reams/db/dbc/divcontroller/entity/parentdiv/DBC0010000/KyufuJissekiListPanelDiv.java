package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
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
 * KyufuJissekiListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJissekiListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DataIdoPanel")
    private DataIdoPanelDiv DataIdoPanel;
    @JsonProperty("dgKyufuJissekiMeisaiList")
    private DataGrid<dgKyufuJissekiMeisaiList_Row> dgKyufuJissekiMeisaiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDataIdoPanel
     * @return DataIdoPanel
     */
    @JsonProperty("DataIdoPanel")
    public DataIdoPanelDiv getDataIdoPanel() {
        return DataIdoPanel;
    }

    /*
     * setDataIdoPanel
     * @param DataIdoPanel DataIdoPanel
     */
    @JsonProperty("DataIdoPanel")
    public void setDataIdoPanel(DataIdoPanelDiv DataIdoPanel) {
        this.DataIdoPanel = DataIdoPanel;
    }

    /*
     * getdgKyufuJissekiMeisaiList
     * @return dgKyufuJissekiMeisaiList
     */
    @JsonProperty("dgKyufuJissekiMeisaiList")
    public DataGrid<dgKyufuJissekiMeisaiList_Row> getDgKyufuJissekiMeisaiList() {
        return dgKyufuJissekiMeisaiList;
    }

    /*
     * setdgKyufuJissekiMeisaiList
     * @param dgKyufuJissekiMeisaiList dgKyufuJissekiMeisaiList
     */
    @JsonProperty("dgKyufuJissekiMeisaiList")
    public void setDgKyufuJissekiMeisaiList(DataGrid<dgKyufuJissekiMeisaiList_Row> dgKyufuJissekiMeisaiList) {
        this.dgKyufuJissekiMeisaiList = dgKyufuJissekiMeisaiList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnSento() {
        return this.getDataIdoPanel().getBtnSento();
    }

    @JsonIgnore
    public void  setBtnSento(Button btnSento) {
        this.getDataIdoPanel().setBtnSento(btnSento);
    }

    @JsonIgnore
    public Button getBtnTsugi() {
        return this.getDataIdoPanel().getBtnTsugi();
    }

    @JsonIgnore
    public void  setBtnTsugi(Button btnTsugi) {
        this.getDataIdoPanel().setBtnTsugi(btnTsugi);
    }

    @JsonIgnore
    public Button getBtnMae() {
        return this.getDataIdoPanel().getBtnMae();
    }

    @JsonIgnore
    public void  setBtnMae(Button btnMae) {
        this.getDataIdoPanel().setBtnMae(btnMae);
    }

    @JsonIgnore
    public Button getBtnSaigo() {
        return this.getDataIdoPanel().getBtnSaigo();
    }

    @JsonIgnore
    public void  setBtnSaigo(Button btnSaigo) {
        this.getDataIdoPanel().setBtnSaigo(btnSaigo);
    }

    // </editor-fold>
}
