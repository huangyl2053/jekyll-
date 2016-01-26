package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032;
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
 * panelThree のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelThreeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdKyufuhiMeisai")
    private DataGrid<dgdKyufuhiMeisai_Row> dgdKyufuhiMeisai;
    @JsonProperty("panelFour")
    private panelFourDiv panelFour;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdKyufuhiMeisai
     * @return dgdKyufuhiMeisai
     */
    @JsonProperty("dgdKyufuhiMeisai")
    public DataGrid<dgdKyufuhiMeisai_Row> getDgdKyufuhiMeisai() {
        return dgdKyufuhiMeisai;
    }

    /*
     * setdgdKyufuhiMeisai
     * @param dgdKyufuhiMeisai dgdKyufuhiMeisai
     */
    @JsonProperty("dgdKyufuhiMeisai")
    public void setDgdKyufuhiMeisai(DataGrid<dgdKyufuhiMeisai_Row> dgdKyufuhiMeisai) {
        this.dgdKyufuhiMeisai = dgdKyufuhiMeisai;
    }

    /*
     * getpanelFour
     * @return panelFour
     */
    @JsonProperty("panelFour")
    public panelFourDiv getPanelFour() {
        return panelFour;
    }

    /*
     * setpanelFour
     * @param panelFour panelFour
     */
    @JsonProperty("panelFour")
    public void setPanelFour(panelFourDiv panelFour) {
        this.panelFour = panelFour;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtServiceShuruiCode() {
        return this.getPanelFour().getTxtServiceShuruiCode();
    }

    @JsonIgnore
    public void  setTxtServiceShuruiCode(TextBoxCode txtServiceShuruiCode) {
        this.getPanelFour().setTxtServiceShuruiCode(txtServiceShuruiCode);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceKoumokuCode() {
        return this.getPanelFour().getTxtServiceKoumokuCode();
    }

    @JsonIgnore
    public void  setTxtServiceKoumokuCode(TextBoxCode txtServiceKoumokuCode) {
        this.getPanelFour().setTxtServiceKoumokuCode(txtServiceKoumokuCode);
    }

    @JsonIgnore
    public TextBox getTxtServicename() {
        return this.getPanelFour().getTxtServicename();
    }

    @JsonIgnore
    public void  setTxtServicename(TextBox txtServicename) {
        this.getPanelFour().setTxtServicename(txtServicename);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyi() {
        return this.getPanelFour().getTxtTanyi();
    }

    @JsonIgnore
    public void  setTxtTanyi(TextBoxNum txtTanyi) {
        this.getPanelFour().setTxtTanyi(txtTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelFour().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelFour().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelFour().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelFour().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxCode getTxtShisetsuHokenshaCode() {
        return this.getPanelFour().getTxtShisetsuHokenshaCode();
    }

    @JsonIgnore
    public void  setTxtShisetsuHokenshaCode(TextBoxCode txtShisetsuHokenshaCode) {
        this.getPanelFour().setTxtShisetsuHokenshaCode(txtShisetsuHokenshaCode);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuHokenshaName() {
        return this.getPanelFour().getTxtShisetsuHokenshaName();
    }

    @JsonIgnore
    public void  setTxtShisetsuHokenshaName(TextBox txtShisetsuHokenshaName) {
        this.getPanelFour().setTxtShisetsuHokenshaName(txtShisetsuHokenshaName);
    }

    @JsonIgnore
    public TextBox getTxtTeikiyo() {
        return this.getPanelFour().getTxtTeikiyo();
    }

    @JsonIgnore
    public void  setTxtTeikiyo(TextBox txtTeikiyo) {
        this.getPanelFour().setTxtTeikiyo(txtTeikiyo);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelFour().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelFour().setBtnClose(btnClose);
    }

    // </editor-fold>
}
