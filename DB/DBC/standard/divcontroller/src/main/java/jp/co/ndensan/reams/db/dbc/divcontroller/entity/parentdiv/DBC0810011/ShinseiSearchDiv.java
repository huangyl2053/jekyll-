package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011;
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
 * ShinseiSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelAtenaShikaku")
    private panelAtenaShikakuDiv panelAtenaShikaku;
    @JsonProperty("panelShokan")
    private panelShokanDiv panelShokan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelAtenaShikaku
     * @return panelAtenaShikaku
     */
    @JsonProperty("panelAtenaShikaku")
    public panelAtenaShikakuDiv getPanelAtenaShikaku() {
        return panelAtenaShikaku;
    }

    /*
     * setpanelAtenaShikaku
     * @param panelAtenaShikaku panelAtenaShikaku
     */
    @JsonProperty("panelAtenaShikaku")
    public void setPanelAtenaShikaku(panelAtenaShikakuDiv panelAtenaShikaku) {
        this.panelAtenaShikaku = panelAtenaShikaku;
    }

    /*
     * getpanelShokan
     * @return panelShokan
     */
    @JsonProperty("panelShokan")
    public panelShokanDiv getPanelShokan() {
        return panelShokan;
    }

    /*
     * setpanelShokan
     * @param panelShokan panelShokan
     */
    @JsonProperty("panelShokan")
    public void setPanelShokan(panelShokanDiv panelShokan) {
        this.panelShokan = panelShokan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtServerYmRange() {
        return this.getPanelShokan().getTxtServerYmRange();
    }

    @JsonIgnore
    public void  setTxtServerYmRange(TextBoxDateRange txtServerYmRange) {
        this.getPanelShokan().setTxtServerYmRange(txtServerYmRange);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getPanelShokan().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPanelShokan().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public DataGrid<dgShokanBaraisyokai_Row> getDgShokanBaraisyokai() {
        return this.getPanelShokan().getDgShokanBaraisyokai();
    }

    @JsonIgnore
    public void  setDgShokanBaraisyokai(DataGrid<dgShokanBaraisyokai_Row> dgShokanBaraisyokai) {
        this.getPanelShokan().setDgShokanBaraisyokai(dgShokanBaraisyokai);
    }

    // </editor-fold>
}
