package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * JikoFutangakuHoseiDetail のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiDetailDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSanteiKBN")
    private TextBox txtSanteiKBN;
    @JsonProperty("txtTaishouNendo")
    private TextBoxDate txtTaishouNendo;
    @JsonProperty("txtShoukisaiHokenjaNO")
    private TextBox txtShoukisaiHokenjaNO;
    @JsonProperty("txtShikyuShinseiSeiriNO")
    private TextBox txtShikyuShinseiSeiriNO;
    @JsonProperty("txtUketoriYM")
    private TextBoxDate txtUketoriYM;
    @JsonProperty("txtJikofutangakuKeisanYMD")
    private TextBoxDate txtJikofutangakuKeisanYMD;
    @JsonProperty("txtHoseibiTan")
    private TextBoxDate txtHoseibiTan;
    @JsonProperty("txtShoumeishoSakuseiYMD")
    private TextBoxDate txtShoumeishoSakuseiYMD;
    @JsonProperty("lblShoumeishoYou")
    private Label lblShoumeishoYou;
    @JsonProperty("linLine2")
    private HorizontalLine linLine2;
    @JsonProperty("tabJikofutanKanriJohoNyuryoku")
    private tabJikofutanKanriJohoNyuryokuDiv tabJikofutanKanriJohoNyuryoku;
    @JsonProperty("btnJikofutangakuJohoNyuryoku")
    private Button btnJikofutangakuJohoNyuryoku;
    @JsonProperty("btnJikofutangakuJohoNiModoru")
    private Button btnJikofutangakuJohoNiModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSanteiKBN
     * @return txtSanteiKBN
     */
    @JsonProperty("txtSanteiKBN")
    public TextBox getTxtSanteiKBN() {
        return txtSanteiKBN;
    }

    /*
     * settxtSanteiKBN
     * @param txtSanteiKBN txtSanteiKBN
     */
    @JsonProperty("txtSanteiKBN")
    public void setTxtSanteiKBN(TextBox txtSanteiKBN) {
        this.txtSanteiKBN = txtSanteiKBN;
    }

    /*
     * gettxtTaishouNendo
     * @return txtTaishouNendo
     */
    @JsonProperty("txtTaishouNendo")
    public TextBoxDate getTxtTaishouNendo() {
        return txtTaishouNendo;
    }

    /*
     * settxtTaishouNendo
     * @param txtTaishouNendo txtTaishouNendo
     */
    @JsonProperty("txtTaishouNendo")
    public void setTxtTaishouNendo(TextBoxDate txtTaishouNendo) {
        this.txtTaishouNendo = txtTaishouNendo;
    }

    /*
     * gettxtShoukisaiHokenjaNO
     * @return txtShoukisaiHokenjaNO
     */
    @JsonProperty("txtShoukisaiHokenjaNO")
    public TextBox getTxtShoukisaiHokenjaNO() {
        return txtShoukisaiHokenjaNO;
    }

    /*
     * settxtShoukisaiHokenjaNO
     * @param txtShoukisaiHokenjaNO txtShoukisaiHokenjaNO
     */
    @JsonProperty("txtShoukisaiHokenjaNO")
    public void setTxtShoukisaiHokenjaNO(TextBox txtShoukisaiHokenjaNO) {
        this.txtShoukisaiHokenjaNO = txtShoukisaiHokenjaNO;
    }

    /*
     * gettxtShikyuShinseiSeiriNO
     * @return txtShikyuShinseiSeiriNO
     */
    @JsonProperty("txtShikyuShinseiSeiriNO")
    public TextBox getTxtShikyuShinseiSeiriNO() {
        return txtShikyuShinseiSeiriNO;
    }

    /*
     * settxtShikyuShinseiSeiriNO
     * @param txtShikyuShinseiSeiriNO txtShikyuShinseiSeiriNO
     */
    @JsonProperty("txtShikyuShinseiSeiriNO")
    public void setTxtShikyuShinseiSeiriNO(TextBox txtShikyuShinseiSeiriNO) {
        this.txtShikyuShinseiSeiriNO = txtShikyuShinseiSeiriNO;
    }

    /*
     * gettxtUketoriYM
     * @return txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public TextBoxDate getTxtUketoriYM() {
        return txtUketoriYM;
    }

    /*
     * settxtUketoriYM
     * @param txtUketoriYM txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.txtUketoriYM = txtUketoriYM;
    }

    /*
     * gettxtJikofutangakuKeisanYMD
     * @return txtJikofutangakuKeisanYMD
     */
    @JsonProperty("txtJikofutangakuKeisanYMD")
    public TextBoxDate getTxtJikofutangakuKeisanYMD() {
        return txtJikofutangakuKeisanYMD;
    }

    /*
     * settxtJikofutangakuKeisanYMD
     * @param txtJikofutangakuKeisanYMD txtJikofutangakuKeisanYMD
     */
    @JsonProperty("txtJikofutangakuKeisanYMD")
    public void setTxtJikofutangakuKeisanYMD(TextBoxDate txtJikofutangakuKeisanYMD) {
        this.txtJikofutangakuKeisanYMD = txtJikofutangakuKeisanYMD;
    }

    /*
     * gettxtHoseibiTan
     * @return txtHoseibiTan
     */
    @JsonProperty("txtHoseibiTan")
    public TextBoxDate getTxtHoseibiTan() {
        return txtHoseibiTan;
    }

    /*
     * settxtHoseibiTan
     * @param txtHoseibiTan txtHoseibiTan
     */
    @JsonProperty("txtHoseibiTan")
    public void setTxtHoseibiTan(TextBoxDate txtHoseibiTan) {
        this.txtHoseibiTan = txtHoseibiTan;
    }

    /*
     * gettxtShoumeishoSakuseiYMD
     * @return txtShoumeishoSakuseiYMD
     */
    @JsonProperty("txtShoumeishoSakuseiYMD")
    public TextBoxDate getTxtShoumeishoSakuseiYMD() {
        return txtShoumeishoSakuseiYMD;
    }

    /*
     * settxtShoumeishoSakuseiYMD
     * @param txtShoumeishoSakuseiYMD txtShoumeishoSakuseiYMD
     */
    @JsonProperty("txtShoumeishoSakuseiYMD")
    public void setTxtShoumeishoSakuseiYMD(TextBoxDate txtShoumeishoSakuseiYMD) {
        this.txtShoumeishoSakuseiYMD = txtShoumeishoSakuseiYMD;
    }

    /*
     * getlblShoumeishoYou
     * @return lblShoumeishoYou
     */
    @JsonProperty("lblShoumeishoYou")
    public Label getLblShoumeishoYou() {
        return lblShoumeishoYou;
    }

    /*
     * setlblShoumeishoYou
     * @param lblShoumeishoYou lblShoumeishoYou
     */
    @JsonProperty("lblShoumeishoYou")
    public void setLblShoumeishoYou(Label lblShoumeishoYou) {
        this.lblShoumeishoYou = lblShoumeishoYou;
    }

    /*
     * getlinLine2
     * @return linLine2
     */
    @JsonProperty("linLine2")
    public HorizontalLine getLinLine2() {
        return linLine2;
    }

    /*
     * setlinLine2
     * @param linLine2 linLine2
     */
    @JsonProperty("linLine2")
    public void setLinLine2(HorizontalLine linLine2) {
        this.linLine2 = linLine2;
    }

    /*
     * gettabJikofutanKanriJohoNyuryoku
     * @return tabJikofutanKanriJohoNyuryoku
     */
    @JsonProperty("tabJikofutanKanriJohoNyuryoku")
    public tabJikofutanKanriJohoNyuryokuDiv getTabJikofutanKanriJohoNyuryoku() {
        return tabJikofutanKanriJohoNyuryoku;
    }

    /*
     * settabJikofutanKanriJohoNyuryoku
     * @param tabJikofutanKanriJohoNyuryoku tabJikofutanKanriJohoNyuryoku
     */
    @JsonProperty("tabJikofutanKanriJohoNyuryoku")
    public void setTabJikofutanKanriJohoNyuryoku(tabJikofutanKanriJohoNyuryokuDiv tabJikofutanKanriJohoNyuryoku) {
        this.tabJikofutanKanriJohoNyuryoku = tabJikofutanKanriJohoNyuryoku;
    }

    /*
     * getbtnJikofutangakuJohoNyuryoku
     * @return btnJikofutangakuJohoNyuryoku
     */
    @JsonProperty("btnJikofutangakuJohoNyuryoku")
    public Button getBtnJikofutangakuJohoNyuryoku() {
        return btnJikofutangakuJohoNyuryoku;
    }

    /*
     * setbtnJikofutangakuJohoNyuryoku
     * @param btnJikofutangakuJohoNyuryoku btnJikofutangakuJohoNyuryoku
     */
    @JsonProperty("btnJikofutangakuJohoNyuryoku")
    public void setBtnJikofutangakuJohoNyuryoku(Button btnJikofutangakuJohoNyuryoku) {
        this.btnJikofutangakuJohoNyuryoku = btnJikofutangakuJohoNyuryoku;
    }

    /*
     * getbtnJikofutangakuJohoNiModoru
     * @return btnJikofutangakuJohoNiModoru
     */
    @JsonProperty("btnJikofutangakuJohoNiModoru")
    public Button getBtnJikofutangakuJohoNiModoru() {
        return btnJikofutangakuJohoNiModoru;
    }

    /*
     * setbtnJikofutangakuJohoNiModoru
     * @param btnJikofutangakuJohoNiModoru btnJikofutangakuJohoNiModoru
     */
    @JsonProperty("btnJikofutangakuJohoNiModoru")
    public void setBtnJikofutangakuJohoNiModoru(Button btnJikofutangakuJohoNiModoru) {
        this.btnJikofutangakuJohoNiModoru = btnJikofutangakuJohoNiModoru;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplJikofutanKanriJoho1Div getTplJikofutanKanriJoho1() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1();
    }

    @JsonIgnore
    public void setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1Div tplJikofutanKanriJoho1) {
        this.getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1);
    }

    @JsonIgnore
    public TextBox getTxtIdouKBN() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtIdouKBN();
    }

    @JsonIgnore
    public void setTxtIdouKBN(TextBox txtIdouKBN) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtIdouKBN(txtIdouKBN);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKBN() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdlShotokuKBN();
    }

    @JsonIgnore
    public void setDdlShotokuKBN(DropDownList ddlShotokuKBN) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdlShotokuKBN(ddlShotokuKBN);
    }

    @JsonIgnore
    public DropDownList getDdl70SaiIjouShotokuKBN() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdl70SaiIjouShotokuKBN();
    }

    @JsonIgnore
    public void setDdl70SaiIjouShotokuKBN(DropDownList ddl70SaiIjouShotokuKBN) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdl70SaiIjouShotokuKBN(ddl70SaiIjouShotokuKBN);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo1Div getJikoFutangakuHoseiTotsugo1() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHokenjaNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHokenjaNO(txtKoukiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHihokenshaNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHihokenshaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHihokenshaNO(txtKoukiHihokenshaNO);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo2Div getJikoFutangakuHoseiTotsugo2() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenjaNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHokenjaNO(txtKokuhoHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshaKojinNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshaKojinNO(txtKokuhoHihokenshaKojinNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshashouNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshashouNO(txtKokuhoHihokenshashouNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishouKeisanKikan() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtTaishouKeisanKikan();
    }

    @JsonIgnore
    public void setTxtTaishouKeisanKikan(TextBoxDateRange txtTaishouKeisanKikan) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtTaishouKeisanKikan(txtTaishouKeisanKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public tplJikofutanKanriJoho2Div getTplJikofutanKanriJoho2() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2();
    }

    @JsonIgnore
    public void setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2Div tplJikofutanKanriJoho2) {
        this.getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2);
    }

    @JsonIgnore
    public JikoFutangakuHoseiAtesakiDiv getJikoFutangakuHoseiAtesaki() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesaki);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiShimei() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiShimei();
    }

    @JsonIgnore
    public void setTxtAtesakiShimei(TextBox txtAtesakiShimei) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiShimei(txtAtesakiShimei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtAtesakiYubinNO() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiYubinNO();
    }

    @JsonIgnore
    public void setTxtAtesakiYubinNO(TextBoxYubinNo txtAtesakiYubinNO) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiYubinNO(txtAtesakiYubinNO);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiJusho() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiJusho();
    }

    @JsonIgnore
    public void setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiJusho(txtAtesakiJusho);
    }

    @JsonIgnore
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiTaishoushaHantei() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiTaishoushaHantei();
    }

    @JsonIgnore
    public void setTxtMadoguchiTaishoushaHantei(TextBox txtMadoguchiTaishoushaHantei) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiTaishoushaHantei(txtMadoguchiTaishoushaHantei);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShiharaiBasho() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtMadoguchiShiharaiBasho(TextBox txtMadoguchiShiharaiBasho) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShiharaiBasho(txtMadoguchiShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiKaishiYMD() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYMD(TextBoxDate txtMadoguchiKaishiYMD) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYMD(txtMadoguchiKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiYoubi() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYoubi(TextBox txtMadoguchiKaishiYoubi) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYoubi(txtMadoguchiKaishiYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiJikan() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiJikan(TextBoxNum txtMadoguchiKaishiJikan) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiJikan(txtMadoguchiKaishiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiFun() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiFun(TextBoxNum txtMadoguchiKaishiFun) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiFun(txtMadoguchiKaishiFun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiShuryoYMD() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYMD(TextBoxDate txtMadoguchiShuryoYMD) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYMD(txtMadoguchiShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoYoubi() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYoubi(TextBox txtMadoguchiShuryoYoubi) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYoubi(txtMadoguchiShuryoYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoJikan() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoJikan(TextBoxNum txtMadoguchiShuryoJikan) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoJikan(txtMadoguchiShuryoJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoFun() {
        return this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoFun(TextBoxNum txtMadoguchiShuryoFun) {
        this.getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoFun(txtMadoguchiShuryoFun);
    }

    // </editor-fold>
}
