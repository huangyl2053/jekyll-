package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShikyugakuKeisanKekkaTorokuShikyuGaku のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTaishoKeisanKikan")
    private TextBoxDateRange txtTaishoKeisanKikan;
    @JsonProperty("txtJikoFutanSeiriNo")
    private TextBox txtJikoFutanSeiriNo;
    @JsonProperty("ddlShotokuKubun")
    private DropDownList ddlShotokuKubun;
    @JsonProperty("ddlOver70ShotokuKubun")
    private DropDownList ddlOver70ShotokuKubun;
    @JsonProperty("txtSetaiFutanSogaku")
    private TextBoxNum txtSetaiFutanSogaku;
    @JsonProperty("txtSetaiShikyuSogaku")
    private TextBoxNum txtSetaiShikyuSogaku;
    @JsonProperty("txtOver70SetaiShikyuSogaku")
    private TextBoxNum txtOver70SetaiShikyuSogaku;
    @JsonProperty("txtSetaiGassanGaku")
    private TextBoxNum txtSetaiGassanGaku;
    @JsonProperty("txtOver70SetaiGassanGaku")
    private TextBoxNum txtOver70SetaiGassanGaku;
    @JsonProperty("txtHonninShikyugaku")
    private TextBoxNum txtHonninShikyugaku;
    @JsonProperty("txtOver70HonninShikyugaku")
    private TextBoxNum txtOver70HonninShikyugaku;
    @JsonProperty("txtSanteiKijunGaku")
    private TextBoxNum txtSanteiKijunGaku;
    @JsonProperty("txtOver70SanteiKijyunGaku")
    private TextBoxNum txtOver70SanteiKijyunGaku;
    @JsonProperty("cblTeiShotoku1SaiKeisanUmu")
    private CheckBoxList cblTeiShotoku1SaiKeisanUmu;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTaishoKeisanKikan
     * @return txtTaishoKeisanKikan
     */
    @JsonProperty("txtTaishoKeisanKikan")
    public TextBoxDateRange getTxtTaishoKeisanKikan() {
        return txtTaishoKeisanKikan;
    }

    /*
     * settxtTaishoKeisanKikan
     * @param txtTaishoKeisanKikan txtTaishoKeisanKikan
     */
    @JsonProperty("txtTaishoKeisanKikan")
    public void setTxtTaishoKeisanKikan(TextBoxDateRange txtTaishoKeisanKikan) {
        this.txtTaishoKeisanKikan = txtTaishoKeisanKikan;
    }

    /*
     * gettxtJikoFutanSeiriNo
     * @return txtJikoFutanSeiriNo
     */
    @JsonProperty("txtJikoFutanSeiriNo")
    public TextBox getTxtJikoFutanSeiriNo() {
        return txtJikoFutanSeiriNo;
    }

    /*
     * settxtJikoFutanSeiriNo
     * @param txtJikoFutanSeiriNo txtJikoFutanSeiriNo
     */
    @JsonProperty("txtJikoFutanSeiriNo")
    public void setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.txtJikoFutanSeiriNo = txtJikoFutanSeiriNo;
    }

    /*
     * getddlShotokuKubun
     * @return ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public DropDownList getDdlShotokuKubun() {
        return ddlShotokuKubun;
    }

    /*
     * setddlShotokuKubun
     * @param ddlShotokuKubun ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.ddlShotokuKubun = ddlShotokuKubun;
    }

    /*
     * getddlOver70ShotokuKubun
     * @return ddlOver70ShotokuKubun
     */
    @JsonProperty("ddlOver70ShotokuKubun")
    public DropDownList getDdlOver70ShotokuKubun() {
        return ddlOver70ShotokuKubun;
    }

    /*
     * setddlOver70ShotokuKubun
     * @param ddlOver70ShotokuKubun ddlOver70ShotokuKubun
     */
    @JsonProperty("ddlOver70ShotokuKubun")
    public void setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.ddlOver70ShotokuKubun = ddlOver70ShotokuKubun;
    }

    /*
     * gettxtSetaiFutanSogaku
     * @return txtSetaiFutanSogaku
     */
    @JsonProperty("txtSetaiFutanSogaku")
    public TextBoxNum getTxtSetaiFutanSogaku() {
        return txtSetaiFutanSogaku;
    }

    /*
     * settxtSetaiFutanSogaku
     * @param txtSetaiFutanSogaku txtSetaiFutanSogaku
     */
    @JsonProperty("txtSetaiFutanSogaku")
    public void setTxtSetaiFutanSogaku(TextBoxNum txtSetaiFutanSogaku) {
        this.txtSetaiFutanSogaku = txtSetaiFutanSogaku;
    }

    /*
     * gettxtSetaiShikyuSogaku
     * @return txtSetaiShikyuSogaku
     */
    @JsonProperty("txtSetaiShikyuSogaku")
    public TextBoxNum getTxtSetaiShikyuSogaku() {
        return txtSetaiShikyuSogaku;
    }

    /*
     * settxtSetaiShikyuSogaku
     * @param txtSetaiShikyuSogaku txtSetaiShikyuSogaku
     */
    @JsonProperty("txtSetaiShikyuSogaku")
    public void setTxtSetaiShikyuSogaku(TextBoxNum txtSetaiShikyuSogaku) {
        this.txtSetaiShikyuSogaku = txtSetaiShikyuSogaku;
    }

    /*
     * gettxtOver70SetaiShikyuSogaku
     * @return txtOver70SetaiShikyuSogaku
     */
    @JsonProperty("txtOver70SetaiShikyuSogaku")
    public TextBoxNum getTxtOver70SetaiShikyuSogaku() {
        return txtOver70SetaiShikyuSogaku;
    }

    /*
     * settxtOver70SetaiShikyuSogaku
     * @param txtOver70SetaiShikyuSogaku txtOver70SetaiShikyuSogaku
     */
    @JsonProperty("txtOver70SetaiShikyuSogaku")
    public void setTxtOver70SetaiShikyuSogaku(TextBoxNum txtOver70SetaiShikyuSogaku) {
        this.txtOver70SetaiShikyuSogaku = txtOver70SetaiShikyuSogaku;
    }

    /*
     * gettxtSetaiGassanGaku
     * @return txtSetaiGassanGaku
     */
    @JsonProperty("txtSetaiGassanGaku")
    public TextBoxNum getTxtSetaiGassanGaku() {
        return txtSetaiGassanGaku;
    }

    /*
     * settxtSetaiGassanGaku
     * @param txtSetaiGassanGaku txtSetaiGassanGaku
     */
    @JsonProperty("txtSetaiGassanGaku")
    public void setTxtSetaiGassanGaku(TextBoxNum txtSetaiGassanGaku) {
        this.txtSetaiGassanGaku = txtSetaiGassanGaku;
    }

    /*
     * gettxtOver70SetaiGassanGaku
     * @return txtOver70SetaiGassanGaku
     */
    @JsonProperty("txtOver70SetaiGassanGaku")
    public TextBoxNum getTxtOver70SetaiGassanGaku() {
        return txtOver70SetaiGassanGaku;
    }

    /*
     * settxtOver70SetaiGassanGaku
     * @param txtOver70SetaiGassanGaku txtOver70SetaiGassanGaku
     */
    @JsonProperty("txtOver70SetaiGassanGaku")
    public void setTxtOver70SetaiGassanGaku(TextBoxNum txtOver70SetaiGassanGaku) {
        this.txtOver70SetaiGassanGaku = txtOver70SetaiGassanGaku;
    }

    /*
     * gettxtHonninShikyugaku
     * @return txtHonninShikyugaku
     */
    @JsonProperty("txtHonninShikyugaku")
    public TextBoxNum getTxtHonninShikyugaku() {
        return txtHonninShikyugaku;
    }

    /*
     * settxtHonninShikyugaku
     * @param txtHonninShikyugaku txtHonninShikyugaku
     */
    @JsonProperty("txtHonninShikyugaku")
    public void setTxtHonninShikyugaku(TextBoxNum txtHonninShikyugaku) {
        this.txtHonninShikyugaku = txtHonninShikyugaku;
    }

    /*
     * gettxtOver70HonninShikyugaku
     * @return txtOver70HonninShikyugaku
     */
    @JsonProperty("txtOver70HonninShikyugaku")
    public TextBoxNum getTxtOver70HonninShikyugaku() {
        return txtOver70HonninShikyugaku;
    }

    /*
     * settxtOver70HonninShikyugaku
     * @param txtOver70HonninShikyugaku txtOver70HonninShikyugaku
     */
    @JsonProperty("txtOver70HonninShikyugaku")
    public void setTxtOver70HonninShikyugaku(TextBoxNum txtOver70HonninShikyugaku) {
        this.txtOver70HonninShikyugaku = txtOver70HonninShikyugaku;
    }

    /*
     * gettxtSanteiKijunGaku
     * @return txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public TextBoxNum getTxtSanteiKijunGaku() {
        return txtSanteiKijunGaku;
    }

    /*
     * settxtSanteiKijunGaku
     * @param txtSanteiKijunGaku txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public void setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.txtSanteiKijunGaku = txtSanteiKijunGaku;
    }

    /*
     * gettxtOver70SanteiKijyunGaku
     * @return txtOver70SanteiKijyunGaku
     */
    @JsonProperty("txtOver70SanteiKijyunGaku")
    public TextBoxNum getTxtOver70SanteiKijyunGaku() {
        return txtOver70SanteiKijyunGaku;
    }

    /*
     * settxtOver70SanteiKijyunGaku
     * @param txtOver70SanteiKijyunGaku txtOver70SanteiKijyunGaku
     */
    @JsonProperty("txtOver70SanteiKijyunGaku")
    public void setTxtOver70SanteiKijyunGaku(TextBoxNum txtOver70SanteiKijyunGaku) {
        this.txtOver70SanteiKijyunGaku = txtOver70SanteiKijyunGaku;
    }

    /*
     * getcblTeiShotoku1SaiKeisanUmu
     * @return cblTeiShotoku1SaiKeisanUmu
     */
    @JsonProperty("cblTeiShotoku1SaiKeisanUmu")
    public CheckBoxList getCblTeiShotoku1SaiKeisanUmu() {
        return cblTeiShotoku1SaiKeisanUmu;
    }

    /*
     * setcblTeiShotoku1SaiKeisanUmu
     * @param cblTeiShotoku1SaiKeisanUmu cblTeiShotoku1SaiKeisanUmu
     */
    @JsonProperty("cblTeiShotoku1SaiKeisanUmu")
    public void setCblTeiShotoku1SaiKeisanUmu(CheckBoxList cblTeiShotoku1SaiKeisanUmu) {
        this.cblTeiShotoku1SaiKeisanUmu = cblTeiShotoku1SaiKeisanUmu;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    // </editor-fold>
}
