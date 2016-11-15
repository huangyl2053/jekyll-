package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hokenshajoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TorokuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TorokuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuTaishoNendo")
    private TextBox txtTorokuTaishoNendo;
    @JsonProperty("txtTorokuShokisaiHokenshaNo")
    private TextBox txtTorokuShokisaiHokenshaNo;
    @JsonProperty("txtTorokuShikyuShinseishoSeiriNo")
    private TextBox txtTorokuShikyuShinseishoSeiriNo;
    @JsonProperty("txtTorokuRirekiNo")
    private TextBox txtTorokuRirekiNo;
    @JsonProperty("tabTorokuJoho")
    private tabTorokuJohoDiv tabTorokuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokuTaishoNendo
     * @return txtTorokuTaishoNendo
     */
    @JsonProperty("txtTorokuTaishoNendo")
    public TextBox getTxtTorokuTaishoNendo() {
        return txtTorokuTaishoNendo;
    }

    /*
     * settxtTorokuTaishoNendo
     * @param txtTorokuTaishoNendo txtTorokuTaishoNendo
     */
    @JsonProperty("txtTorokuTaishoNendo")
    public void setTxtTorokuTaishoNendo(TextBox txtTorokuTaishoNendo) {
        this.txtTorokuTaishoNendo = txtTorokuTaishoNendo;
    }

    /*
     * gettxtTorokuShokisaiHokenshaNo
     * @return txtTorokuShokisaiHokenshaNo
     */
    @JsonProperty("txtTorokuShokisaiHokenshaNo")
    public TextBox getTxtTorokuShokisaiHokenshaNo() {
        return txtTorokuShokisaiHokenshaNo;
    }

    /*
     * settxtTorokuShokisaiHokenshaNo
     * @param txtTorokuShokisaiHokenshaNo txtTorokuShokisaiHokenshaNo
     */
    @JsonProperty("txtTorokuShokisaiHokenshaNo")
    public void setTxtTorokuShokisaiHokenshaNo(TextBox txtTorokuShokisaiHokenshaNo) {
        this.txtTorokuShokisaiHokenshaNo = txtTorokuShokisaiHokenshaNo;
    }

    /*
     * gettxtTorokuShikyuShinseishoSeiriNo
     * @return txtTorokuShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtTorokuShikyuShinseishoSeiriNo")
    public TextBox getTxtTorokuShikyuShinseishoSeiriNo() {
        return txtTorokuShikyuShinseishoSeiriNo;
    }

    /*
     * settxtTorokuShikyuShinseishoSeiriNo
     * @param txtTorokuShikyuShinseishoSeiriNo txtTorokuShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtTorokuShikyuShinseishoSeiriNo")
    public void setTxtTorokuShikyuShinseishoSeiriNo(TextBox txtTorokuShikyuShinseishoSeiriNo) {
        this.txtTorokuShikyuShinseishoSeiriNo = txtTorokuShikyuShinseishoSeiriNo;
    }

    /*
     * gettxtTorokuRirekiNo
     * @return txtTorokuRirekiNo
     */
    @JsonProperty("txtTorokuRirekiNo")
    public TextBox getTxtTorokuRirekiNo() {
        return txtTorokuRirekiNo;
    }

    /*
     * settxtTorokuRirekiNo
     * @param txtTorokuRirekiNo txtTorokuRirekiNo
     */
    @JsonProperty("txtTorokuRirekiNo")
    public void setTxtTorokuRirekiNo(TextBox txtTorokuRirekiNo) {
        this.txtTorokuRirekiNo = txtTorokuRirekiNo;
    }

    /*
     * gettabTorokuJoho
     * @return tabTorokuJoho
     */
    @JsonProperty("tabTorokuJoho")
    public tabTorokuJohoDiv getTabTorokuJoho() {
        return tabTorokuJoho;
    }

    /*
     * settabTorokuJoho
     * @param tabTorokuJoho tabTorokuJoho
     */
    @JsonProperty("tabTorokuJoho")
    public void setTabTorokuJoho(tabTorokuJohoDiv tabTorokuJoho) {
        this.tabTorokuJoho = tabTorokuJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShomeishoKisaiJikoDiv getTplShomeishoKisaiJiko() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko();
    }

    @JsonIgnore
    public void  setTplShomeishoKisaiJiko(tplShomeishoKisaiJikoDiv tplShomeishoKisaiJiko) {
        this.getTabTorokuJoho().setTplShomeishoKisaiJiko(tplShomeishoKisaiJiko);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUketsukeDate() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getTxtUketsukeDate();
    }

    @JsonIgnore
    public void  setTxtUketsukeDate(TextBoxFlexibleDate txtUketsukeDate) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().setTxtUketsukeDate(txtUketsukeDate);
    }

    @JsonIgnore
    public ShomeishoKisaiJohoDiv getShomeishoKisaiJoho() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho();
    }

    @JsonIgnore
    public void  setShomeishoKisaiJoho(ShomeishoKisaiJohoDiv ShomeishoKisaiJoho) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().setShomeishoKisaiJoho(ShomeishoKisaiJoho);
    }

    @JsonIgnore
    public TextBox getTxtJikofutangakuShomeishoSeiriNo() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getTxtJikofutangakuShomeishoSeiriNo();
    }

    @JsonIgnore
    public void  setTxtJikofutangakuShomeishoSeiriNo(TextBox txtJikofutangakuShomeishoSeiriNo) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().setTxtJikofutangakuShomeishoSeiriNo(txtJikofutangakuShomeishoSeiriNo);
    }

    @JsonIgnore
    public Label getLblTennyumae() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getLblTennyumae();
    }

    @JsonIgnore
    public void  setLblTennyumae(Label lblTennyumae) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().setLblTennyumae(lblTennyumae);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKikan() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getTxtTaishoKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKikan(TextBoxDateRange txtTaishoKikan) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().setTxtTaishoKikan(txtTaishoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void  setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getTxtHakkoDate();
    }

    @JsonIgnore
    public void  setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().setTxtHakkoDate(txtHakkoDate);
    }

    @JsonIgnore
    public IHokenshaJohoDiv getCcdTennyumaeHokensha() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getShomeishoKisaiJoho().getCcdTennyumaeHokensha();
    }

    @JsonIgnore
    public RenrakusakiJohoDiv getRenrakusakiJoho() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho();
    }

    @JsonIgnore
    public void  setRenrakusakiJoho(RenrakusakiJohoDiv RenrakusakiJoho) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().setRenrakusakiJoho(RenrakusakiJoho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakusakiJusho() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().getTxtRenrakusakiJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiJusho(TextBoxMultiLine txtRenrakusakiJusho) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().setTxtRenrakusakiJusho(txtRenrakusakiJusho);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusakiMei1() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().getTxtRenrakusakiMei1();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiMei1(TextBox txtRenrakusakiMei1) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().setTxtRenrakusakiMei1(txtRenrakusakiMei1);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusakiMei2() {
        return this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().getTxtRenrakusakiMei2();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiMei2(TextBox txtRenrakusakiMei2) {
        this.getTabTorokuJoho().getTplShomeishoKisaiJiko().getRenrakusakiJoho().setTxtRenrakusakiMei2(txtRenrakusakiMei2);
    }

    @JsonIgnore
    public tplJikofutangakuJohoDiv getTplJikofutangakuJoho() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho();
    }

    @JsonIgnore
    public void  setTplJikofutangakuJoho(tplJikofutangakuJohoDiv tplJikofutangakuJoho) {
        this.getTabTorokuJoho().setTplJikofutangakuJoho(tplJikofutangakuJoho);
    }

    @JsonIgnore
    public Label getLblJikofutangaku() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getLblJikofutangaku();
    }

    @JsonIgnore
    public void  setLblJikofutangaku(Label lblJikofutangaku) {
        this.getTabTorokuJoho().getTplJikofutangakuJoho().setLblJikofutangaku(lblJikofutangaku);
    }

    @JsonIgnore
    public tblJikofutangakuDiv getTblJikofutangaku() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku();
    }

    @JsonIgnore
    public void  setTblJikofutangaku(tblJikofutangakuDiv tblJikofutangaku) {
        this.getTabTorokuJoho().getTplJikofutangakuJoho().setTblJikofutangaku(tblJikofutangaku);
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblJikofutangaku1() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLblJikofutangaku1();
    }

    @JsonIgnore
    public Label getLblUchiFutangaku1() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLblUchiFutangaku1();
    }

    @JsonIgnore
    public Label getLbl8Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl8Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku8() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku8();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku8() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku8();
    }

    @JsonIgnore
    public Label getLbl9Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl9Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku9() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku9();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku9() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku9();
    }

    @JsonIgnore
    public Label getLbl10Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl10Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku10() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku10();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku10() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku10();
    }

    @JsonIgnore
    public Label getLbl11Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl11Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku11() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku11();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku11() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku11();
    }

    @JsonIgnore
    public Label getLbl12Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl12Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku12() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku12();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku12() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku12();
    }

    @JsonIgnore
    public Label getLbl1Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getLbl1Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku1() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtJikofutangaku1();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku1() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku().getTxtUchiFutangaku1();
    }

    @JsonIgnore
    public tblJikofutangaku2Div getTblJikofutangaku2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2();
    }

    @JsonIgnore
    public void  setTblJikofutangaku2(tblJikofutangaku2Div tblJikofutangaku2) {
        this.getTabTorokuJoho().getTplJikofutangakuJoho().setTblJikofutangaku2(tblJikofutangaku2);
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblJikofutangaku2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLblJikofutangaku2();
    }

    @JsonIgnore
    public Label getLblUchiFutangaku2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLblUchiFutangaku2();
    }

    @JsonIgnore
    public Label getLbl2Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl2Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku2();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku2() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku2();
    }

    @JsonIgnore
    public Label getLbl3Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl3Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku3() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku3();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku3() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku3();
    }

    @JsonIgnore
    public Label getLbl4Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl4Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku4() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku4();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku4() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku4();
    }

    @JsonIgnore
    public Label getLbl5Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl5Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku5() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku5();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku5() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku5();
    }

    @JsonIgnore
    public Label getLbl6Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl6Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku6() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku6();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku6() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku6();
    }

    @JsonIgnore
    public Label getLbl7Gatsu() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getLbl7Gatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangaku7() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangaku7();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangaku7() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangaku7();
    }

    @JsonIgnore
    public Button getBtnGokei() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getBtnGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtJikofutangakuGokei() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtJikofutangakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtUchiFutangakuGokei() {
        return this.getTabTorokuJoho().getTplJikofutangakuJoho().getTblJikofutangaku2().getTxtUchiFutangakuGokei();
    }

    // </editor-fold>
}
