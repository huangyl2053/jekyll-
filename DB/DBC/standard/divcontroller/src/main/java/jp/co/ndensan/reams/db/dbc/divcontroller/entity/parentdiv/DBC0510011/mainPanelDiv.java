package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * mainPanel のクラスファイル
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class mainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiYMD")
    private TextBoxDate txtZenkaiYMD;
    @JsonProperty("txtZenkaiTime")
    private TextBoxTime txtZenkaiTime;
    @JsonProperty("txtTorikomiKeishiki")
    private TextBox txtTorikomiKeishiki;
    @JsonProperty("txtRenkekeishiki")
    private TextBox txtRenkekeishiki;
    @JsonProperty("btnTorikomi")
    private ButtonDialog btnTorikomi;
    @JsonProperty("txtFileYMD")
    private TextBoxDate txtFileYMD;
    @JsonProperty("txtFileTime")
    private TextBoxTime txtFileTime;
    @JsonProperty("sp1")
    private Space sp1;
    @JsonProperty("meisaiPanel")
    private meisaiPanelDiv meisaiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiYMD
     * @return txtZenkaiYMD
     */
    @JsonProperty("txtZenkaiYMD")
    public TextBoxDate getTxtZenkaiYMD() {
        return txtZenkaiYMD;
    }

    /*
     * settxtZenkaiYMD
     * @param txtZenkaiYMD txtZenkaiYMD
     */
    @JsonProperty("txtZenkaiYMD")
    public void setTxtZenkaiYMD(TextBoxDate txtZenkaiYMD) {
        this.txtZenkaiYMD = txtZenkaiYMD;
    }

    /*
     * gettxtZenkaiTime
     * @return txtZenkaiTime
     */
    @JsonProperty("txtZenkaiTime")
    public TextBoxTime getTxtZenkaiTime() {
        return txtZenkaiTime;
    }

    /*
     * settxtZenkaiTime
     * @param txtZenkaiTime txtZenkaiTime
     */
    @JsonProperty("txtZenkaiTime")
    public void setTxtZenkaiTime(TextBoxTime txtZenkaiTime) {
        this.txtZenkaiTime = txtZenkaiTime;
    }

    /*
     * gettxtTorikomiKeishiki
     * @return txtTorikomiKeishiki
     */
    @JsonProperty("txtTorikomiKeishiki")
    public TextBox getTxtTorikomiKeishiki() {
        return txtTorikomiKeishiki;
    }

    /*
     * settxtTorikomiKeishiki
     * @param txtTorikomiKeishiki txtTorikomiKeishiki
     */
    @JsonProperty("txtTorikomiKeishiki")
    public void setTxtTorikomiKeishiki(TextBox txtTorikomiKeishiki) {
        this.txtTorikomiKeishiki = txtTorikomiKeishiki;
    }

    /*
     * gettxtRenkekeishiki
     * @return txtRenkekeishiki
     */
    @JsonProperty("txtRenkekeishiki")
    public TextBox getTxtRenkekeishiki() {
        return txtRenkekeishiki;
    }

    /*
     * settxtRenkekeishiki
     * @param txtRenkekeishiki txtRenkekeishiki
     */
    @JsonProperty("txtRenkekeishiki")
    public void setTxtRenkekeishiki(TextBox txtRenkekeishiki) {
        this.txtRenkekeishiki = txtRenkekeishiki;
    }

    /*
     * getbtnTorikomi
     * @return btnTorikomi
     */
    @JsonProperty("btnTorikomi")
    public ButtonDialog getBtnTorikomi() {
        return btnTorikomi;
    }

    /*
     * setbtnTorikomi
     * @param btnTorikomi btnTorikomi
     */
    @JsonProperty("btnTorikomi")
    public void setBtnTorikomi(ButtonDialog btnTorikomi) {
        this.btnTorikomi = btnTorikomi;
    }

    /*
     * gettxtFileYMD
     * @return txtFileYMD
     */
    @JsonProperty("txtFileYMD")
    public TextBoxDate getTxtFileYMD() {
        return txtFileYMD;
    }

    /*
     * settxtFileYMD
     * @param txtFileYMD txtFileYMD
     */
    @JsonProperty("txtFileYMD")
    public void setTxtFileYMD(TextBoxDate txtFileYMD) {
        this.txtFileYMD = txtFileYMD;
    }

    /*
     * gettxtFileTime
     * @return txtFileTime
     */
    @JsonProperty("txtFileTime")
    public TextBoxTime getTxtFileTime() {
        return txtFileTime;
    }

    /*
     * settxtFileTime
     * @param txtFileTime txtFileTime
     */
    @JsonProperty("txtFileTime")
    public void setTxtFileTime(TextBoxTime txtFileTime) {
        this.txtFileTime = txtFileTime;
    }

    /*
     * getsp1
     * @return sp1
     */
    @JsonProperty("sp1")
    public Space getSp1() {
        return sp1;
    }

    /*
     * setsp1
     * @param sp1 sp1
     */
    @JsonProperty("sp1")
    public void setSp1(Space sp1) {
        this.sp1 = sp1;
    }

    /*
     * getmeisaiPanel
     * @return meisaiPanel
     */
    @JsonProperty("meisaiPanel")
    public meisaiPanelDiv getMeisaiPanel() {
        return meisaiPanel;
    }

    /*
     * setmeisaiPanel
     * @param meisaiPanel meisaiPanel
     */
    @JsonProperty("meisaiPanel")
    public void setMeisaiPanel(meisaiPanelDiv meisaiPanel) {
        this.meisaiPanel = meisaiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgShichoson_Row> getDgShichoson() {
        return this.getMeisaiPanel().getDgShichoson();
    }

    @JsonIgnore
    public void setDgShichoson(DataGrid<dgShichoson_Row> dgShichoson) {
        this.getMeisaiPanel().setDgShichoson(dgShichoson);
    }

    // </editor-fold>
}
