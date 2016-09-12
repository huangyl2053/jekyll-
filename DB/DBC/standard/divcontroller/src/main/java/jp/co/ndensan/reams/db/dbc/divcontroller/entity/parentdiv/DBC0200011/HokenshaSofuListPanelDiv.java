package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HokenshaSofuListPanel のクラスファイル
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class HokenshaSofuListPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNengetsu")
    private TextBoxDate txtShoriNengetsu;
    @JsonProperty("btnHyojisuru")
    private Button btnHyojisuru;
    @JsonProperty("btnScheduleSetting")
    private Button btnScheduleSetting;
    @JsonProperty("dgHokenshaSofuList")
    private DataGrid<dgHokenshaSofuList_Row> dgHokenshaSofuList;
    @JsonProperty("lblHokenshaSofuList")
    private Label lblHokenshaSofuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNengetsu
     * @return txtShoriNengetsu
     */
    @JsonProperty("txtShoriNengetsu")
    public TextBoxDate getTxtShoriNengetsu() {
        return txtShoriNengetsu;
    }

    /*
     * settxtShoriNengetsu
     * @param txtShoriNengetsu txtShoriNengetsu
     */
    @JsonProperty("txtShoriNengetsu")
    public void setTxtShoriNengetsu(TextBoxDate txtShoriNengetsu) {
        this.txtShoriNengetsu = txtShoriNengetsu;
    }

    /*
     * getbtnHyojisuru
     * @return btnHyojisuru
     */
    @JsonProperty("btnHyojisuru")
    public Button getBtnHyojisuru() {
        return btnHyojisuru;
    }

    /*
     * setbtnHyojisuru
     * @param btnHyojisuru btnHyojisuru
     */
    @JsonProperty("btnHyojisuru")
    public void setBtnHyojisuru(Button btnHyojisuru) {
        this.btnHyojisuru = btnHyojisuru;
    }

    /*
     * getbtnScheduleSetting
     * @return btnScheduleSetting
     */
    @JsonProperty("btnScheduleSetting")
    public Button getBtnScheduleSetting() {
        return btnScheduleSetting;
    }

    /*
     * setbtnScheduleSetting
     * @param btnScheduleSetting btnScheduleSetting
     */
    @JsonProperty("btnScheduleSetting")
    public void setBtnScheduleSetting(Button btnScheduleSetting) {
        this.btnScheduleSetting = btnScheduleSetting;
    }

    /*
     * getdgHokenshaSofuList
     * @return dgHokenshaSofuList
     */
    @JsonProperty("dgHokenshaSofuList")
    public DataGrid<dgHokenshaSofuList_Row> getDgHokenshaSofuList() {
        return dgHokenshaSofuList;
    }

    /*
     * setdgHokenshaSofuList
     * @param dgHokenshaSofuList dgHokenshaSofuList
     */
    @JsonProperty("dgHokenshaSofuList")
    public void setDgHokenshaSofuList(DataGrid<dgHokenshaSofuList_Row> dgHokenshaSofuList) {
        this.dgHokenshaSofuList = dgHokenshaSofuList;
    }

    /*
     * getlblHokenshaSofuList
     * @return lblHokenshaSofuList
     */
    @JsonProperty("lblHokenshaSofuList")
    public Label getLblHokenshaSofuList() {
        return lblHokenshaSofuList;
    }

    /*
     * setlblHokenshaSofuList
     * @param lblHokenshaSofuList lblHokenshaSofuList
     */
    @JsonProperty("lblHokenshaSofuList")
    public void setLblHokenshaSofuList(Label lblHokenshaSofuList) {
        this.lblHokenshaSofuList = lblHokenshaSofuList;
    }

    // </editor-fold>
}
