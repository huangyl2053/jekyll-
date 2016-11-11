package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * PostMainPanel のクラスファイル
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
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
    private Button btnTorikomi;
    @JsonProperty("txtFileYMD")
    private TextBoxDate txtFileYMD;
    @JsonProperty("txtFileTime")
    private TextBoxTime txtFileTime;
    @JsonProperty("sp1")
    private Space sp1;
    @JsonProperty("meisaiPanel")
    private meisaiPanelDiv meisaiPanel;
    @JsonProperty("hdnShichosonCD")
    private TextBox hdnShichosonCD;
    @JsonProperty("FileUpload")
    private FileUploadDiv FileUpload;
    @JsonProperty("hdnModl")
    private RString hdnModl;
    @JsonProperty("hdnModl1")
    private RString hdnModl1;
    @JsonProperty("hdnModl2")
    private RString hdnModl2;

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
    public Button getBtnTorikomi() {
        return btnTorikomi;
    }

    /*
     * setbtnTorikomi
     * @param btnTorikomi btnTorikomi
     */
    @JsonProperty("btnTorikomi")
    public void setBtnTorikomi(Button btnTorikomi) {
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
     * gethdnShichosonCD
     * @return hdnShichosonCD
     */
    @JsonProperty("hdnShichosonCD")
    public TextBox getHdnShichosonCD() {
        return hdnShichosonCD;
    }

    /*
     * sethdnShichosonCD
     * @param hdnShichosonCD hdnShichosonCD
     */
    @JsonProperty("hdnShichosonCD")
    public void setHdnShichosonCD(TextBox hdnShichosonCD) {
        this.hdnShichosonCD = hdnShichosonCD;
    }

    /*
     * getFileUpload
     * @return FileUpload
     */
    @JsonProperty("FileUpload")
    public FileUploadDiv getFileUpload() {
        return FileUpload;
    }

    /*
     * setFileUpload
     * @param FileUpload FileUpload
     */
    @JsonProperty("FileUpload")
    public void setFileUpload(FileUploadDiv FileUpload) {
        this.FileUpload = FileUpload;
    }

    /*
     * gethdnModl
     * @return hdnModl
     */
    @JsonProperty("hdnModl")
    public RString getHdnModl() {
        return hdnModl;
    }

    /*
     * sethdnModl
     * @param hdnModl hdnModl
     */
    @JsonProperty("hdnModl")
    public void setHdnModl(RString hdnModl) {
        this.hdnModl = hdnModl;
    }

    /*
     * gethdnModl1
     * @return hdnModl1
     */
    @JsonProperty("hdnModl1")
    public RString getHdnModl1() {
        return hdnModl1;
    }

    /*
     * sethdnModl1
     * @param hdnModl1 hdnModl1
     */
    @JsonProperty("hdnModl1")
    public void setHdnModl1(RString hdnModl1) {
        this.hdnModl1 = hdnModl1;
    }

    /*
     * gethdnModl2
     * @return hdnModl2
     */
    @JsonProperty("hdnModl2")
    public RString getHdnModl2() {
        return hdnModl2;
    }

    /*
     * sethdnModl2
     * @param hdnModl2 hdnModl2
     */
    @JsonProperty("hdnModl2")
    public void setHdnModl2(RString hdnModl2) {
        this.hdnModl2 = hdnModl2;
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

    @JsonIgnore
    public UploadPanel getUplIdoJohoFile() {
        return this.getFileUpload().getUplIdoJohoFile();
    }

    @JsonIgnore
    public void setUplIdoJohoFile(UploadPanel uplIdoJohoFile) {
        this.getFileUpload().setUplIdoJohoFile(uplIdoJohoFile);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getFileUpload().getBtnUpload();
    }

    @JsonIgnore
    public void setBtnUpload(Button btnUpload) {
        this.getFileUpload().setBtnUpload(btnUpload);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getFileUpload().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getFileUpload().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
