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
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShomeishoKisaiJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShomeishoKisaiJikoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUketsukeDate")
    private TextBoxFlexibleDate txtUketsukeDate;
    @JsonProperty("ShomeishoKisaiJoho")
    private ShomeishoKisaiJohoDiv ShomeishoKisaiJoho;
    @JsonProperty("RenrakusakiJoho")
    private RenrakusakiJohoDiv RenrakusakiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtUketsukeDate
     * @return txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public TextBoxFlexibleDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    /*
     * settxtUketsukeDate
     * @param txtUketsukeDate txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxFlexibleDate txtUketsukeDate) {
        this.txtUketsukeDate = txtUketsukeDate;
    }

    /*
     * getShomeishoKisaiJoho
     * @return ShomeishoKisaiJoho
     */
    @JsonProperty("ShomeishoKisaiJoho")
    public ShomeishoKisaiJohoDiv getShomeishoKisaiJoho() {
        return ShomeishoKisaiJoho;
    }

    /*
     * setShomeishoKisaiJoho
     * @param ShomeishoKisaiJoho ShomeishoKisaiJoho
     */
    @JsonProperty("ShomeishoKisaiJoho")
    public void setShomeishoKisaiJoho(ShomeishoKisaiJohoDiv ShomeishoKisaiJoho) {
        this.ShomeishoKisaiJoho = ShomeishoKisaiJoho;
    }

    /*
     * getRenrakusakiJoho
     * @return RenrakusakiJoho
     */
    @JsonProperty("RenrakusakiJoho")
    public RenrakusakiJohoDiv getRenrakusakiJoho() {
        return RenrakusakiJoho;
    }

    /*
     * setRenrakusakiJoho
     * @param RenrakusakiJoho RenrakusakiJoho
     */
    @JsonProperty("RenrakusakiJoho")
    public void setRenrakusakiJoho(RenrakusakiJohoDiv RenrakusakiJoho) {
        this.RenrakusakiJoho = RenrakusakiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtJikofutangakuShomeishoSeiriNo() {
        return this.getShomeishoKisaiJoho().getTxtJikofutangakuShomeishoSeiriNo();
    }

    @JsonIgnore
    public void  setTxtJikofutangakuShomeishoSeiriNo(TextBox txtJikofutangakuShomeishoSeiriNo) {
        this.getShomeishoKisaiJoho().setTxtJikofutangakuShomeishoSeiriNo(txtJikofutangakuShomeishoSeiriNo);
    }

    @JsonIgnore
    public Label getLblTennyumae() {
        return this.getShomeishoKisaiJoho().getLblTennyumae();
    }

    @JsonIgnore
    public void  setLblTennyumae(Label lblTennyumae) {
        this.getShomeishoKisaiJoho().setLblTennyumae(lblTennyumae);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKikan() {
        return this.getShomeishoKisaiJoho().getTxtTaishoKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKikan(TextBoxDateRange txtTaishoKikan) {
        this.getShomeishoKisaiJoho().setTxtTaishoKikan(txtTaishoKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getShomeishoKisaiJoho().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void  setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getShomeishoKisaiJoho().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoDate() {
        return this.getShomeishoKisaiJoho().getTxtHakkoDate();
    }

    @JsonIgnore
    public void  setTxtHakkoDate(TextBoxFlexibleDate txtHakkoDate) {
        this.getShomeishoKisaiJoho().setTxtHakkoDate(txtHakkoDate);
    }

    @JsonIgnore
    public IHokenshaJohoDiv getCcdTennyumaeHokensha() {
        return this.getShomeishoKisaiJoho().getCcdTennyumaeHokensha();
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getRenrakusakiJoho().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getRenrakusakiJoho().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtRenrakusakiJusho() {
        return this.getRenrakusakiJoho().getTxtRenrakusakiJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiJusho(TextBoxMultiLine txtRenrakusakiJusho) {
        this.getRenrakusakiJoho().setTxtRenrakusakiJusho(txtRenrakusakiJusho);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusakiMei1() {
        return this.getRenrakusakiJoho().getTxtRenrakusakiMei1();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiMei1(TextBox txtRenrakusakiMei1) {
        this.getRenrakusakiJoho().setTxtRenrakusakiMei1(txtRenrakusakiMei1);
    }

    @JsonIgnore
    public TextBox getTxtRenrakusakiMei2() {
        return this.getRenrakusakiJoho().getTxtRenrakusakiMei2();
    }

    @JsonIgnore
    public void  setTxtRenrakusakiMei2(TextBox txtRenrakusakiMei2) {
        this.getRenrakusakiJoho().setTxtRenrakusakiMei2(txtRenrakusakiMei2);
    }

    // </editor-fold>
}
