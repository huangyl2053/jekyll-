package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
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
 * ShikyugakuKeisanKekkaTorokuUchiwakeList のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuUchiwakeListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnUchiwakeAdd")
    private Button btnUchiwakeAdd;
    @JsonProperty("dgKogakuGassanShikyugakuKeisanKekkaMeisai")
    private DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai;
    @JsonProperty("GokeiJohoPanel")
    private GokeiJohoPanelDiv GokeiJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnUchiwakeAdd
     * @return btnUchiwakeAdd
     */
    @JsonProperty("btnUchiwakeAdd")
    public Button getBtnUchiwakeAdd() {
        return btnUchiwakeAdd;
    }

    /*
     * setbtnUchiwakeAdd
     * @param btnUchiwakeAdd btnUchiwakeAdd
     */
    @JsonProperty("btnUchiwakeAdd")
    public void setBtnUchiwakeAdd(Button btnUchiwakeAdd) {
        this.btnUchiwakeAdd = btnUchiwakeAdd;
    }

    /*
     * getdgKogakuGassanShikyugakuKeisanKekkaMeisai
     * @return dgKogakuGassanShikyugakuKeisanKekkaMeisai
     */
    @JsonProperty("dgKogakuGassanShikyugakuKeisanKekkaMeisai")
    public DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> getDgKogakuGassanShikyugakuKeisanKekkaMeisai() {
        return dgKogakuGassanShikyugakuKeisanKekkaMeisai;
    }

    /*
     * setdgKogakuGassanShikyugakuKeisanKekkaMeisai
     * @param dgKogakuGassanShikyugakuKeisanKekkaMeisai dgKogakuGassanShikyugakuKeisanKekkaMeisai
     */
    @JsonProperty("dgKogakuGassanShikyugakuKeisanKekkaMeisai")
    public void setDgKogakuGassanShikyugakuKeisanKekkaMeisai(DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai) {
        this.dgKogakuGassanShikyugakuKeisanKekkaMeisai = dgKogakuGassanShikyugakuKeisanKekkaMeisai;
    }

    /*
     * getGokeiJohoPanel
     * @return GokeiJohoPanel
     */
    @JsonProperty("GokeiJohoPanel")
    public GokeiJohoPanelDiv getGokeiJohoPanel() {
        return GokeiJohoPanel;
    }

    /*
     * setGokeiJohoPanel
     * @param GokeiJohoPanel GokeiJohoPanel
     */
    @JsonProperty("GokeiJohoPanel")
    public void setGokeiJohoPanel(GokeiJohoPanelDiv GokeiJohoPanel) {
        this.GokeiJohoPanel = GokeiJohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtJohoOver70FutangakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoOver70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70FutangakuGokei(TextBoxNum txtJohoOver70FutangakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoOver70FutangakuGokei(txtJohoOver70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70ShikyugakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoOver70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70ShikyugakuGokei(TextBoxNum txtJohoOver70ShikyugakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoOver70ShikyugakuGokei(txtJohoOver70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70FutangakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoUnder70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70FutangakuGokei(TextBoxNum txtJohoUnder70FutangakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoUnder70FutangakuGokei(txtJohoUnder70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoFutangakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoFutangakuGokei(TextBoxNum txtJohoFutangakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoFutangakuGokei(txtJohoFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70ShikyugakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoUnder70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70ShikyugakuGokei(TextBoxNum txtJohoUnder70ShikyugakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoUnder70ShikyugakuGokei(txtJohoUnder70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoShikyugakuGokei() {
        return this.getGokeiJohoPanel().getTxtJohoShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoShikyugakuGokei(TextBoxNum txtJohoShikyugakuGokei) {
        this.getGokeiJohoPanel().setTxtJohoShikyugakuGokei(txtJohoShikyugakuGokei);
    }

    // </editor-fold>
}
