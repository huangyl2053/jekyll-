package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * tplJikofutanKanriJoho1 のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class tplJikofutanKanriJoho1Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIdouKBN")
    private TextBox txtIdouKBN;
    @JsonProperty("ddlShotokuKBN")
    private DropDownList ddlShotokuKBN;
    @JsonProperty("ddl70SaiIjouShotokuKBN")
    private DropDownList ddl70SaiIjouShotokuKBN;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("JikoFutangakuHoseiTotsugo1")
    private JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1;
    @JsonProperty("JikoFutangakuHoseiTotsugo2")
    private JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtTaishouKeisanKikan")
    private TextBoxDateRange txtTaishouKeisanKikan;
    @JsonProperty("txtHihokenshaKikan")
    private TextBoxDateRange txtHihokenshaKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIdouKBN
     * @return txtIdouKBN
     */
    @JsonProperty("txtIdouKBN")
    public TextBox getTxtIdouKBN() {
        return txtIdouKBN;
    }

    /*
     * settxtIdouKBN
     * @param txtIdouKBN txtIdouKBN
     */
    @JsonProperty("txtIdouKBN")
    public void setTxtIdouKBN(TextBox txtIdouKBN) {
        this.txtIdouKBN = txtIdouKBN;
    }

    /*
     * getddlShotokuKBN
     * @return ddlShotokuKBN
     */
    @JsonProperty("ddlShotokuKBN")
    public DropDownList getDdlShotokuKBN() {
        return ddlShotokuKBN;
    }

    /*
     * setddlShotokuKBN
     * @param ddlShotokuKBN ddlShotokuKBN
     */
    @JsonProperty("ddlShotokuKBN")
    public void setDdlShotokuKBN(DropDownList ddlShotokuKBN) {
        this.ddlShotokuKBN = ddlShotokuKBN;
    }

    /*
     * getddl70SaiIjouShotokuKBN
     * @return ddl70SaiIjouShotokuKBN
     */
    @JsonProperty("ddl70SaiIjouShotokuKBN")
    public DropDownList getDdl70SaiIjouShotokuKBN() {
        return ddl70SaiIjouShotokuKBN;
    }

    /*
     * setddl70SaiIjouShotokuKBN
     * @param ddl70SaiIjouShotokuKBN ddl70SaiIjouShotokuKBN
     */
    @JsonProperty("ddl70SaiIjouShotokuKBN")
    public void setDdl70SaiIjouShotokuKBN(DropDownList ddl70SaiIjouShotokuKBN) {
        this.ddl70SaiIjouShotokuKBN = ddl70SaiIjouShotokuKBN;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * getJikoFutangakuHoseiTotsugo1
     * @return JikoFutangakuHoseiTotsugo1
     */
    @JsonProperty("JikoFutangakuHoseiTotsugo1")
    public JikoFutangakuHoseiTotsugo1Div getJikoFutangakuHoseiTotsugo1() {
        return JikoFutangakuHoseiTotsugo1;
    }

    /*
     * setJikoFutangakuHoseiTotsugo1
     * @param JikoFutangakuHoseiTotsugo1 JikoFutangakuHoseiTotsugo1
     */
    @JsonProperty("JikoFutangakuHoseiTotsugo1")
    public void setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1) {
        this.JikoFutangakuHoseiTotsugo1 = JikoFutangakuHoseiTotsugo1;
    }

    /*
     * getJikoFutangakuHoseiTotsugo2
     * @return JikoFutangakuHoseiTotsugo2
     */
    @JsonProperty("JikoFutangakuHoseiTotsugo2")
    public JikoFutangakuHoseiTotsugo2Div getJikoFutangakuHoseiTotsugo2() {
        return JikoFutangakuHoseiTotsugo2;
    }

    /*
     * setJikoFutangakuHoseiTotsugo2
     * @param JikoFutangakuHoseiTotsugo2 JikoFutangakuHoseiTotsugo2
     */
    @JsonProperty("JikoFutangakuHoseiTotsugo2")
    public void setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2) {
        this.JikoFutangakuHoseiTotsugo2 = JikoFutangakuHoseiTotsugo2;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtTaishouKeisanKikan
     * @return txtTaishouKeisanKikan
     */
    @JsonProperty("txtTaishouKeisanKikan")
    public TextBoxDateRange getTxtTaishouKeisanKikan() {
        return txtTaishouKeisanKikan;
    }

    /*
     * settxtTaishouKeisanKikan
     * @param txtTaishouKeisanKikan txtTaishouKeisanKikan
     */
    @JsonProperty("txtTaishouKeisanKikan")
    public void setTxtTaishouKeisanKikan(TextBoxDateRange txtTaishouKeisanKikan) {
        this.txtTaishouKeisanKikan = txtTaishouKeisanKikan;
    }

    /*
     * gettxtHihokenshaKikan
     * @return txtHihokenshaKikan
     */
    @JsonProperty("txtHihokenshaKikan")
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return txtHihokenshaKikan;
    }

    /*
     * settxtHihokenshaKikan
     * @param txtHihokenshaKikan txtHihokenshaKikan
     */
    @JsonProperty("txtHihokenshaKikan")
    public void setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.txtHihokenshaKikan = txtHihokenshaKikan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKoukiHokenjaNO() {
        return this.getJikoFutangakuHoseiTotsugo1().getTxtKoukiHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.getJikoFutangakuHoseiTotsugo1().setTxtKoukiHokenjaNO(txtKoukiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHihokenshaNO() {
        return this.getJikoFutangakuHoseiTotsugo1().getTxtKoukiHihokenshaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.getJikoFutangakuHoseiTotsugo1().setTxtKoukiHihokenshaNO(txtKoukiHihokenshaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenjaNO() {
        return this.getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHokenjaNO(txtKokuhoHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return this.getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshaKojinNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshaKojinNO(txtKokuhoHihokenshaKojinNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return this.getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshashouNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshashouNO(txtKokuhoHihokenshashouNO);
    }

    // </editor-fold>
}
