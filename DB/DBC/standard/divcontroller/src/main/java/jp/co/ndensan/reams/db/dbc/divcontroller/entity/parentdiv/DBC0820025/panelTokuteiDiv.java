package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820025;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelTokutei のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelTokuteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdTokuteiYichiran")
    private DataGrid<dgdTokuteiYichiran_Row> dgdTokuteiYichiran;
    @JsonProperty("lblGokei")
    private Label lblGokei;
    @JsonProperty("txtHiyogakuTotal")
    private TextBoxNum txtHiyogakuTotal;
    @JsonProperty("txtHokenbunTotal")
    private TextBoxNum txtHokenbunTotal;
    @JsonProperty("txtRiyoshaFutangakuTotal")
    private TextBoxNum txtRiyoshaFutangakuTotal;
    @JsonProperty("panelMeisai")
    private panelMeisaiDiv panelMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgdTokuteiYichiran
     * @return dgdTokuteiYichiran
     */
    @JsonProperty("dgdTokuteiYichiran")
    public DataGrid<dgdTokuteiYichiran_Row> getDgdTokuteiYichiran() {
        return dgdTokuteiYichiran;
    }

    /*
     * setdgdTokuteiYichiran
     * @param dgdTokuteiYichiran dgdTokuteiYichiran
     */
    @JsonProperty("dgdTokuteiYichiran")
    public void setDgdTokuteiYichiran(DataGrid<dgdTokuteiYichiran_Row> dgdTokuteiYichiran) {
        this.dgdTokuteiYichiran = dgdTokuteiYichiran;
    }

    /*
     * getlblGokei
     * @return lblGokei
     */
    @JsonProperty("lblGokei")
    public Label getLblGokei() {
        return lblGokei;
    }

    /*
     * setlblGokei
     * @param lblGokei lblGokei
     */
    @JsonProperty("lblGokei")
    public void setLblGokei(Label lblGokei) {
        this.lblGokei = lblGokei;
    }

    /*
     * gettxtHiyogakuTotal
     * @return txtHiyogakuTotal
     */
    @JsonProperty("txtHiyogakuTotal")
    public TextBoxNum getTxtHiyogakuTotal() {
        return txtHiyogakuTotal;
    }

    /*
     * settxtHiyogakuTotal
     * @param txtHiyogakuTotal txtHiyogakuTotal
     */
    @JsonProperty("txtHiyogakuTotal")
    public void setTxtHiyogakuTotal(TextBoxNum txtHiyogakuTotal) {
        this.txtHiyogakuTotal = txtHiyogakuTotal;
    }

    /*
     * gettxtHokenbunTotal
     * @return txtHokenbunTotal
     */
    @JsonProperty("txtHokenbunTotal")
    public TextBoxNum getTxtHokenbunTotal() {
        return txtHokenbunTotal;
    }

    /*
     * settxtHokenbunTotal
     * @param txtHokenbunTotal txtHokenbunTotal
     */
    @JsonProperty("txtHokenbunTotal")
    public void setTxtHokenbunTotal(TextBoxNum txtHokenbunTotal) {
        this.txtHokenbunTotal = txtHokenbunTotal;
    }

    /*
     * gettxtRiyoshaFutangakuTotal
     * @return txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return txtRiyoshaFutangakuTotal;
    }

    /*
     * settxtRiyoshaFutangakuTotal
     * @param txtRiyoshaFutangakuTotal txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public void setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.txtRiyoshaFutangakuTotal = txtRiyoshaFutangakuTotal;
    }

    /*
     * getpanelMeisai
     * @return panelMeisai
     */
    @JsonProperty("panelMeisai")
    public panelMeisaiDiv getPanelMeisai() {
        return panelMeisai;
    }

    /*
     * setpanelMeisai
     * @param panelMeisai panelMeisai
     */
    @JsonProperty("panelMeisai")
    public void setPanelMeisai(panelMeisaiDiv panelMeisai) {
        this.panelMeisai = panelMeisai;
    }

    // </editor-fold>
}
