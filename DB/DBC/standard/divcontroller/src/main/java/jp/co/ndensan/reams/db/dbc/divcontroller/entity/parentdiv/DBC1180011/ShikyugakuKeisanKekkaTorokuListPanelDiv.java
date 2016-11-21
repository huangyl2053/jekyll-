package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyugakuKeisanKekkaTorokuListPanel のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuListPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKensakuTaishoNendo")
    private TextBoxDateRange txtKensakuTaishoNendo;
    @JsonProperty("chkRirekiHyoji")
    private CheckBoxList chkRirekiHyoji;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("txtShikyuShinseishoSeiriNoInput")
    private TextBoxCode txtShikyuShinseishoSeiriNoInput;
    @JsonProperty("btnAddKeisanKekka")
    private Button btnAddKeisanKekka;
    @JsonProperty("lin02")
    private HorizontalLine lin02;
    @JsonProperty("dgKogakuGassanShikyuGakuKeisanKekka")
    private DataGrid<dgKogakuGassanShikyuGakuKeisanKekka_Row> dgKogakuGassanShikyuGakuKeisanKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKensakuTaishoNendo
     * @return txtKensakuTaishoNendo
     */
    @JsonProperty("txtKensakuTaishoNendo")
    public TextBoxDateRange getTxtKensakuTaishoNendo() {
        return txtKensakuTaishoNendo;
    }

    /*
     * settxtKensakuTaishoNendo
     * @param txtKensakuTaishoNendo txtKensakuTaishoNendo
     */
    @JsonProperty("txtKensakuTaishoNendo")
    public void setTxtKensakuTaishoNendo(TextBoxDateRange txtKensakuTaishoNendo) {
        this.txtKensakuTaishoNendo = txtKensakuTaishoNendo;
    }

    /*
     * getchkRirekiHyoji
     * @return chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public CheckBoxList getChkRirekiHyoji() {
        return chkRirekiHyoji;
    }

    /*
     * setchkRirekiHyoji
     * @param chkRirekiHyoji chkRirekiHyoji
     */
    @JsonProperty("chkRirekiHyoji")
    public void setChkRirekiHyoji(CheckBoxList chkRirekiHyoji) {
        this.chkRirekiHyoji = chkRirekiHyoji;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * gettxtShikyuShinseishoSeiriNoInput
     * @return txtShikyuShinseishoSeiriNoInput
     */
    @JsonProperty("txtShikyuShinseishoSeiriNoInput")
    public TextBoxCode getTxtShikyuShinseishoSeiriNoInput() {
        return txtShikyuShinseishoSeiriNoInput;
    }

    /*
     * settxtShikyuShinseishoSeiriNoInput
     * @param txtShikyuShinseishoSeiriNoInput txtShikyuShinseishoSeiriNoInput
     */
    @JsonProperty("txtShikyuShinseishoSeiriNoInput")
    public void setTxtShikyuShinseishoSeiriNoInput(TextBoxCode txtShikyuShinseishoSeiriNoInput) {
        this.txtShikyuShinseishoSeiriNoInput = txtShikyuShinseishoSeiriNoInput;
    }

    /*
     * getbtnAddKeisanKekka
     * @return btnAddKeisanKekka
     */
    @JsonProperty("btnAddKeisanKekka")
    public Button getBtnAddKeisanKekka() {
        return btnAddKeisanKekka;
    }

    /*
     * setbtnAddKeisanKekka
     * @param btnAddKeisanKekka btnAddKeisanKekka
     */
    @JsonProperty("btnAddKeisanKekka")
    public void setBtnAddKeisanKekka(Button btnAddKeisanKekka) {
        this.btnAddKeisanKekka = btnAddKeisanKekka;
    }

    /*
     * getlin02
     * @return lin02
     */
    @JsonProperty("lin02")
    public HorizontalLine getLin02() {
        return lin02;
    }

    /*
     * setlin02
     * @param lin02 lin02
     */
    @JsonProperty("lin02")
    public void setLin02(HorizontalLine lin02) {
        this.lin02 = lin02;
    }

    /*
     * getdgKogakuGassanShikyuGakuKeisanKekka
     * @return dgKogakuGassanShikyuGakuKeisanKekka
     */
    @JsonProperty("dgKogakuGassanShikyuGakuKeisanKekka")
    public DataGrid<dgKogakuGassanShikyuGakuKeisanKekka_Row> getDgKogakuGassanShikyuGakuKeisanKekka() {
        return dgKogakuGassanShikyuGakuKeisanKekka;
    }

    /*
     * setdgKogakuGassanShikyuGakuKeisanKekka
     * @param dgKogakuGassanShikyuGakuKeisanKekka dgKogakuGassanShikyuGakuKeisanKekka
     */
    @JsonProperty("dgKogakuGassanShikyuGakuKeisanKekka")
    public void setDgKogakuGassanShikyuGakuKeisanKekka(DataGrid<dgKogakuGassanShikyuGakuKeisanKekka_Row> dgKogakuGassanShikyuGakuKeisanKekka) {
        this.dgKogakuGassanShikyuGakuKeisanKekka = dgKogakuGassanShikyuGakuKeisanKekka;
    }

    // </editor-fold>
}
