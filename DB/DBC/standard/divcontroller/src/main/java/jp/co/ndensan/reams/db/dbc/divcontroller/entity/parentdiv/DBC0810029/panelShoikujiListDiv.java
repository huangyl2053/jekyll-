package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029;
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
 * panelShoikujiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShoikujiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdShokuji")
    private DataGrid<dgdShokuji_Row> dgdShokuji;
    @JsonProperty("panelGokeiSet")
    private panelGokeiSetDiv panelGokeiSet;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdShokuji
     * @return dgdShokuji
     */
    @JsonProperty("dgdShokuji")
    public DataGrid<dgdShokuji_Row> getDgdShokuji() {
        return dgdShokuji;
    }

    /*
     * setdgdShokuji
     * @param dgdShokuji dgdShokuji
     */
    @JsonProperty("dgdShokuji")
    public void setDgdShokuji(DataGrid<dgdShokuji_Row> dgdShokuji) {
        this.dgdShokuji = dgdShokuji;
    }

    /*
     * getpanelGokeiSet
     * @return panelGokeiSet
     */
    @JsonProperty("panelGokeiSet")
    public panelGokeiSetDiv getPanelGokeiSet() {
        return panelGokeiSet;
    }

    /*
     * setpanelGokeiSet
     * @param panelGokeiSet panelGokeiSet
     */
    @JsonProperty("panelGokeiSet")
    public void setPanelGokeiSet(panelGokeiSetDiv panelGokeiSet) {
        this.panelGokeiSet = panelGokeiSet;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyoTotalNissuGokei() {
        return this.getPanelGokeiSet().getTxtShokujiTeikyoTotalNissuGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyoTotalNissuGokei(TextBoxNum txtShokujiTeikyoTotalNissuGokei) {
        this.getPanelGokeiSet().setTxtShokujiTeikyoTotalNissuGokei(txtShokujiTeikyoTotalNissuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtnichigakuHyojunFutangakuGokei() {
        return this.getPanelGokeiSet().getTxtnichigakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtnichigakuHyojunFutangakuGokei(TextBoxNum txtnichigakuHyojunFutangakuGokei) {
        this.getPanelGokeiSet().setTxtnichigakuHyojunFutangakuGokei(txtnichigakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtgetsugakuHyojunFutangakuGokei() {
        return this.getPanelGokeiSet().getTxtgetsugakuHyojunFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtgetsugakuHyojunFutangakuGokei(TextBoxNum txtgetsugakuHyojunFutangakuGokei) {
        this.getPanelGokeiSet().setTxtgetsugakuHyojunFutangakuGokei(txtgetsugakuHyojunFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokujiTeikyohiTotalGokei() {
        return this.getPanelGokeiSet().getTxtShokujiTeikyohiTotalGokei();
    }

    @JsonIgnore
    public void  setTxtShokujiTeikyohiTotalGokei(TextBoxNum txtShokujiTeikyohiTotalGokei) {
        this.getPanelGokeiSet().setTxtShokujiTeikyohiTotalGokei(txtShokujiTeikyohiTotalGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtshokujiTeikyohiSeikyugakuGokei() {
        return this.getPanelGokeiSet().getTxtshokujiTeikyohiSeikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtshokujiTeikyohiSeikyugakuGokei(TextBoxNum txtshokujiTeikyohiSeikyugakuGokei) {
        this.getPanelGokeiSet().setTxtshokujiTeikyohiSeikyugakuGokei(txtshokujiTeikyohiSeikyugakuGokei);
    }

    @JsonIgnore
    public Label getLblFree() {
        return this.getPanelGokeiSet().getLblFree();
    }

    @JsonIgnore
    public void  setLblFree(Label lblFree) {
        this.getPanelGokeiSet().setLblFree(lblFree);
    }

    @JsonIgnore
    public Button getBtnCloseGokei() {
        return this.getPanelGokeiSet().getBtnCloseGokei();
    }

    @JsonIgnore
    public void  setBtnCloseGokei(Button btnCloseGokei) {
        this.getPanelGokeiSet().setBtnCloseGokei(btnCloseGokei);
    }

    // </editor-fold>
}
