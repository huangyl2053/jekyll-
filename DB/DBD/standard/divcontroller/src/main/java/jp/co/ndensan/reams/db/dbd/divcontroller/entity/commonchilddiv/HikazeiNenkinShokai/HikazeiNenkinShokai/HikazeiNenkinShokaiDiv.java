package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinShokai.HikazeiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HikazeiNenkinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinShokaiDiv extends Panel implements IHikazeiNenkinShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("radRireki")
    private RadioButton radRireki;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    private Label lblHojinHikazeiNenkinJoho;
    @JsonProperty("txtShotokuKananGakugo")
    private TextBoxNum txtShotokuKananGakugo;
    @JsonProperty("dgHikazeiNenkinShokai")
    private DataGrid<dgHikazeiNenkinShokai_Row> dgHikazeiNenkinShokai;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * getradRireki
     * @return radRireki
     */
    @JsonProperty("radRireki")
    public RadioButton getRadRireki() {
        return radRireki;
    }

    /*
     * setradRireki
     * @param radRireki radRireki
     */
    @JsonProperty("radRireki")
    public void setRadRireki(RadioButton radRireki) {
        this.radRireki = radRireki;
    }

    /*
     * getbtnSaiHyoji
     * @return btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    /*
     * setbtnSaiHyoji
     * @param btnSaiHyoji btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji = btnSaiHyoji;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getlblHojinHikazeiNenkinJoho
     * @return lblHojinHikazeiNenkinJoho
     */
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    public Label getLblHojinHikazeiNenkinJoho() {
        return lblHojinHikazeiNenkinJoho;
    }

    /*
     * setlblHojinHikazeiNenkinJoho
     * @param lblHojinHikazeiNenkinJoho lblHojinHikazeiNenkinJoho
     */
    @JsonProperty("lblHojinHikazeiNenkinJoho")
    public void setLblHojinHikazeiNenkinJoho(Label lblHojinHikazeiNenkinJoho) {
        this.lblHojinHikazeiNenkinJoho = lblHojinHikazeiNenkinJoho;
    }

    /*
     * gettxtShotokuKananGakugo
     * @return txtShotokuKananGakugo
     */
    @JsonProperty("txtShotokuKananGakugo")
    public TextBoxNum getTxtShotokuKananGakugo() {
        return txtShotokuKananGakugo;
    }

    /*
     * settxtShotokuKananGakugo
     * @param txtShotokuKananGakugo txtShotokuKananGakugo
     */
    @JsonProperty("txtShotokuKananGakugo")
    public void setTxtShotokuKananGakugo(TextBoxNum txtShotokuKananGakugo) {
        this.txtShotokuKananGakugo = txtShotokuKananGakugo;
    }

    /*
     * getdgHikazeiNenkinShokai
     * @return dgHikazeiNenkinShokai
     */
    @JsonProperty("dgHikazeiNenkinShokai")
    public DataGrid<dgHikazeiNenkinShokai_Row> getDgHikazeiNenkinShokai() {
        return dgHikazeiNenkinShokai;
    }

    /*
     * setdgHikazeiNenkinShokai
     * @param dgHikazeiNenkinShokai dgHikazeiNenkinShokai
     */
    @JsonProperty("dgHikazeiNenkinShokai")
    public void setDgHikazeiNenkinShokai(DataGrid<dgHikazeiNenkinShokai_Row> dgHikazeiNenkinShokai) {
        this.dgHikazeiNenkinShokai = dgHikazeiNenkinShokai;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
