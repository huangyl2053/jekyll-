package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ScheduleSetting のクラスファイル
 *
 * @reamsid_L DBC-2930-010 liuxiaoyu
 */
public class ScheduleSettingDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNengetsu")
    private TextBoxDate txtShoriNengetsu;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;
    @JsonProperty("linShoriNengetsu")
    private HorizontalLine linShoriNengetsu;
    @JsonProperty("txtHyojiTaishoNengetsu")
    private TextBoxDate txtHyojiTaishoNengetsu;
    @JsonProperty("linHyojiTaishoNengetsu")
    private HorizontalLine linHyojiTaishoNengetsu;
    @JsonProperty("lblDataSofu")
    private Label lblDataSofu;
    @JsonProperty("dgDataSofu")
    private DataGrid<dgDataSofu_Row> dgDataSofu;
    @JsonProperty("linDataSofu")
    private HorizontalLine linDataSofu;
    @JsonProperty("lblDataTorikomi")
    private Label lblDataTorikomi;
    @JsonProperty("dgDataTorikomi")
    private DataGrid<dgDataTorikomi_Row> dgDataTorikomi;
    @JsonProperty("linDataTorikomi")
    private HorizontalLine linDataTorikomi;
    @JsonProperty("txtJokyo")
    private TextBox txtJokyo;

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
     * getbtnDisplay
     * @return btnDisplay
     */
    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    /*
     * setbtnDisplay
     * @param btnDisplay btnDisplay
     */
    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay = btnDisplay;
    }

    /*
     * getlinShoriNengetsu
     * @return linShoriNengetsu
     */
    @JsonProperty("linShoriNengetsu")
    public HorizontalLine getLinShoriNengetsu() {
        return linShoriNengetsu;
    }

    /*
     * setlinShoriNengetsu
     * @param linShoriNengetsu linShoriNengetsu
     */
    @JsonProperty("linShoriNengetsu")
    public void setLinShoriNengetsu(HorizontalLine linShoriNengetsu) {
        this.linShoriNengetsu = linShoriNengetsu;
    }

    /*
     * gettxtHyojiTaishoNengetsu
     * @return txtHyojiTaishoNengetsu
     */
    @JsonProperty("txtHyojiTaishoNengetsu")
    public TextBoxDate getTxtHyojiTaishoNengetsu() {
        return txtHyojiTaishoNengetsu;
    }

    /*
     * settxtHyojiTaishoNengetsu
     * @param txtHyojiTaishoNengetsu txtHyojiTaishoNengetsu
     */
    @JsonProperty("txtHyojiTaishoNengetsu")
    public void setTxtHyojiTaishoNengetsu(TextBoxDate txtHyojiTaishoNengetsu) {
        this.txtHyojiTaishoNengetsu = txtHyojiTaishoNengetsu;
    }

    /*
     * getlinHyojiTaishoNengetsu
     * @return linHyojiTaishoNengetsu
     */
    @JsonProperty("linHyojiTaishoNengetsu")
    public HorizontalLine getLinHyojiTaishoNengetsu() {
        return linHyojiTaishoNengetsu;
    }

    /*
     * setlinHyojiTaishoNengetsu
     * @param linHyojiTaishoNengetsu linHyojiTaishoNengetsu
     */
    @JsonProperty("linHyojiTaishoNengetsu")
    public void setLinHyojiTaishoNengetsu(HorizontalLine linHyojiTaishoNengetsu) {
        this.linHyojiTaishoNengetsu = linHyojiTaishoNengetsu;
    }

    /*
     * getlblDataSofu
     * @return lblDataSofu
     */
    @JsonProperty("lblDataSofu")
    public Label getLblDataSofu() {
        return lblDataSofu;
    }

    /*
     * setlblDataSofu
     * @param lblDataSofu lblDataSofu
     */
    @JsonProperty("lblDataSofu")
    public void setLblDataSofu(Label lblDataSofu) {
        this.lblDataSofu = lblDataSofu;
    }

    /*
     * getdgDataSofu
     * @return dgDataSofu
     */
    @JsonProperty("dgDataSofu")
    public DataGrid<dgDataSofu_Row> getDgDataSofu() {
        return dgDataSofu;
    }

    /*
     * setdgDataSofu
     * @param dgDataSofu dgDataSofu
     */
    @JsonProperty("dgDataSofu")
    public void setDgDataSofu(DataGrid<dgDataSofu_Row> dgDataSofu) {
        this.dgDataSofu = dgDataSofu;
    }

    /*
     * getlinDataSofu
     * @return linDataSofu
     */
    @JsonProperty("linDataSofu")
    public HorizontalLine getLinDataSofu() {
        return linDataSofu;
    }

    /*
     * setlinDataSofu
     * @param linDataSofu linDataSofu
     */
    @JsonProperty("linDataSofu")
    public void setLinDataSofu(HorizontalLine linDataSofu) {
        this.linDataSofu = linDataSofu;
    }

    /*
     * getlblDataTorikomi
     * @return lblDataTorikomi
     */
    @JsonProperty("lblDataTorikomi")
    public Label getLblDataTorikomi() {
        return lblDataTorikomi;
    }

    /*
     * setlblDataTorikomi
     * @param lblDataTorikomi lblDataTorikomi
     */
    @JsonProperty("lblDataTorikomi")
    public void setLblDataTorikomi(Label lblDataTorikomi) {
        this.lblDataTorikomi = lblDataTorikomi;
    }

    /*
     * getdgDataTorikomi
     * @return dgDataTorikomi
     */
    @JsonProperty("dgDataTorikomi")
    public DataGrid<dgDataTorikomi_Row> getDgDataTorikomi() {
        return dgDataTorikomi;
    }

    /*
     * setdgDataTorikomi
     * @param dgDataTorikomi dgDataTorikomi
     */
    @JsonProperty("dgDataTorikomi")
    public void setDgDataTorikomi(DataGrid<dgDataTorikomi_Row> dgDataTorikomi) {
        this.dgDataTorikomi = dgDataTorikomi;
    }

    /*
     * getlinDataTorikomi
     * @return linDataTorikomi
     */
    @JsonProperty("linDataTorikomi")
    public HorizontalLine getLinDataTorikomi() {
        return linDataTorikomi;
    }

    /*
     * setlinDataTorikomi
     * @param linDataTorikomi linDataTorikomi
     */
    @JsonProperty("linDataTorikomi")
    public void setLinDataTorikomi(HorizontalLine linDataTorikomi) {
        this.linDataTorikomi = linDataTorikomi;
    }

    /*
     * gettxtJokyo
     * @return txtJokyo
     */
    @JsonProperty("txtJokyo")
    public TextBox getTxtJokyo() {
        return txtJokyo;
    }

    /*
     * settxtJokyo
     * @param txtJokyo txtJokyo
     */
    @JsonProperty("txtJokyo")
    public void setTxtJokyo(TextBox txtJokyo) {
        this.txtJokyo = txtJokyo;
    }

    // </editor-fold>
}
