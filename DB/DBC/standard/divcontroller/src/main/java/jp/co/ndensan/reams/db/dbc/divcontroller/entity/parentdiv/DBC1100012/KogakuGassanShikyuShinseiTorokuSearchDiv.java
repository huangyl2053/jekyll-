package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanShikyuShinseiTorokuSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanShikyuShinseiTorokuSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShiChoSon")
    private DropDownList ddlShiChoSon;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ddlShinseiTaisyoNendo")
    private DropDownList ddlShinseiTaisyoNendo;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDateRange txtShinseiYMD;
    @JsonProperty("cbkKaigoShikyuShinseishoSeiriBango")
    private CheckBoxList cbkKaigoShikyuShinseishoSeiriBango;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    private TextBox txtKaigoShikyuShinseishoSeiriBango1;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    private TextBox txtKaigoShikyuShinseishoSeiriBango2;
    @JsonProperty("ddlKaigoShikyuShinseishoSeiriBango3")
    private DropDownList ddlKaigoShikyuShinseishoSeiriBango3;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    private TextBox txtKaigoShikyuShinseishoSeiriBango4;
    @JsonProperty("cbkIryoShikyuShinseishoSeiriBango")
    private CheckBoxList cbkIryoShikyuShinseishoSeiriBango;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    private TextBox txtIryoShikyuShinseishoSeiriBango1;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    private TextBox txtIryoShikyuShinseishoSeiriBango2;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    private TextBox txtIryoShikyuShinseishoSeiriBango3;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    private TextBox txtIryoShikyuShinseishoSeiriBango4;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("rdbShinseiKihonJohoKensaku")
    private RadioButton rdbShinseiKihonJohoKensaku;
    @JsonProperty("txtShinseiDaihyoshaShimei")
    private TextBox txtShinseiDaihyoshaShimei;
    @JsonProperty("chkZempoItchi1")
    private CheckBoxList chkZempoItchi1;
    @JsonProperty("rdbHihokensyaJohoKensaku")
    private RadioButton rdbHihokensyaJohoKensaku;
    @JsonProperty("txtHihobango")
    private TextBox txtHihobango;
    @JsonProperty("txtHihokensyaShimei")
    private TextBox txtHihokensyaShimei;
    @JsonProperty("chkZempoItchi2")
    private CheckBoxList chkZempoItchi2;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShiChoSon
     * @return ddlShiChoSon
     */
    @JsonProperty("ddlShiChoSon")
    public DropDownList getDdlShiChoSon() {
        return ddlShiChoSon;
    }

    /*
     * setddlShiChoSon
     * @param ddlShiChoSon ddlShiChoSon
     */
    @JsonProperty("ddlShiChoSon")
    public void setDdlShiChoSon(DropDownList ddlShiChoSon) {
        this.ddlShiChoSon = ddlShiChoSon;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getddlShinseiTaisyoNendo
     * @return ddlShinseiTaisyoNendo
     */
    @JsonProperty("ddlShinseiTaisyoNendo")
    public DropDownList getDdlShinseiTaisyoNendo() {
        return ddlShinseiTaisyoNendo;
    }

    /*
     * setddlShinseiTaisyoNendo
     * @param ddlShinseiTaisyoNendo ddlShinseiTaisyoNendo
     */
    @JsonProperty("ddlShinseiTaisyoNendo")
    public void setDdlShinseiTaisyoNendo(DropDownList ddlShinseiTaisyoNendo) {
        this.ddlShinseiTaisyoNendo = ddlShinseiTaisyoNendo;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDateRange getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getcbkKaigoShikyuShinseishoSeiriBango
     * @return cbkKaigoShikyuShinseishoSeiriBango
     */
    @JsonProperty("cbkKaigoShikyuShinseishoSeiriBango")
    public CheckBoxList getCbkKaigoShikyuShinseishoSeiriBango() {
        return cbkKaigoShikyuShinseishoSeiriBango;
    }

    /*
     * setcbkKaigoShikyuShinseishoSeiriBango
     * @param cbkKaigoShikyuShinseishoSeiriBango cbkKaigoShikyuShinseishoSeiriBango
     */
    @JsonProperty("cbkKaigoShikyuShinseishoSeiriBango")
    public void setCbkKaigoShikyuShinseishoSeiriBango(CheckBoxList cbkKaigoShikyuShinseishoSeiriBango) {
        this.cbkKaigoShikyuShinseishoSeiriBango = cbkKaigoShikyuShinseishoSeiriBango;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango1
     * @return txtKaigoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango1() {
        return txtKaigoShikyuShinseishoSeiriBango1;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango1
     * @param txtKaigoShikyuShinseishoSeiriBango1 txtKaigoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    public void setTxtKaigoShikyuShinseishoSeiriBango1(TextBox txtKaigoShikyuShinseishoSeiriBango1) {
        this.txtKaigoShikyuShinseishoSeiriBango1 = txtKaigoShikyuShinseishoSeiriBango1;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango2
     * @return txtKaigoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango2() {
        return txtKaigoShikyuShinseishoSeiriBango2;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango2
     * @param txtKaigoShikyuShinseishoSeiriBango2 txtKaigoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    public void setTxtKaigoShikyuShinseishoSeiriBango2(TextBox txtKaigoShikyuShinseishoSeiriBango2) {
        this.txtKaigoShikyuShinseishoSeiriBango2 = txtKaigoShikyuShinseishoSeiriBango2;
    }

    /*
     * getddlKaigoShikyuShinseishoSeiriBango3
     * @return ddlKaigoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("ddlKaigoShikyuShinseishoSeiriBango3")
    public DropDownList getDdlKaigoShikyuShinseishoSeiriBango3() {
        return ddlKaigoShikyuShinseishoSeiriBango3;
    }

    /*
     * setddlKaigoShikyuShinseishoSeiriBango3
     * @param ddlKaigoShikyuShinseishoSeiriBango3 ddlKaigoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("ddlKaigoShikyuShinseishoSeiriBango3")
    public void setDdlKaigoShikyuShinseishoSeiriBango3(DropDownList ddlKaigoShikyuShinseishoSeiriBango3) {
        this.ddlKaigoShikyuShinseishoSeiriBango3 = ddlKaigoShikyuShinseishoSeiriBango3;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango4
     * @return txtKaigoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango4() {
        return txtKaigoShikyuShinseishoSeiriBango4;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango4
     * @param txtKaigoShikyuShinseishoSeiriBango4 txtKaigoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    public void setTxtKaigoShikyuShinseishoSeiriBango4(TextBox txtKaigoShikyuShinseishoSeiriBango4) {
        this.txtKaigoShikyuShinseishoSeiriBango4 = txtKaigoShikyuShinseishoSeiriBango4;
    }

    /*
     * getcbkIryoShikyuShinseishoSeiriBango
     * @return cbkIryoShikyuShinseishoSeiriBango
     */
    @JsonProperty("cbkIryoShikyuShinseishoSeiriBango")
    public CheckBoxList getCbkIryoShikyuShinseishoSeiriBango() {
        return cbkIryoShikyuShinseishoSeiriBango;
    }

    /*
     * setcbkIryoShikyuShinseishoSeiriBango
     * @param cbkIryoShikyuShinseishoSeiriBango cbkIryoShikyuShinseishoSeiriBango
     */
    @JsonProperty("cbkIryoShikyuShinseishoSeiriBango")
    public void setCbkIryoShikyuShinseishoSeiriBango(CheckBoxList cbkIryoShikyuShinseishoSeiriBango) {
        this.cbkIryoShikyuShinseishoSeiriBango = cbkIryoShikyuShinseishoSeiriBango;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango1
     * @return txtIryoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango1() {
        return txtIryoShikyuShinseishoSeiriBango1;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango1
     * @param txtIryoShikyuShinseishoSeiriBango1 txtIryoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    public void setTxtIryoShikyuShinseishoSeiriBango1(TextBox txtIryoShikyuShinseishoSeiriBango1) {
        this.txtIryoShikyuShinseishoSeiriBango1 = txtIryoShikyuShinseishoSeiriBango1;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango2
     * @return txtIryoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango2() {
        return txtIryoShikyuShinseishoSeiriBango2;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango2
     * @param txtIryoShikyuShinseishoSeiriBango2 txtIryoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    public void setTxtIryoShikyuShinseishoSeiriBango2(TextBox txtIryoShikyuShinseishoSeiriBango2) {
        this.txtIryoShikyuShinseishoSeiriBango2 = txtIryoShikyuShinseishoSeiriBango2;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango3
     * @return txtIryoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango3() {
        return txtIryoShikyuShinseishoSeiriBango3;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango3
     * @param txtIryoShikyuShinseishoSeiriBango3 txtIryoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    public void setTxtIryoShikyuShinseishoSeiriBango3(TextBox txtIryoShikyuShinseishoSeiriBango3) {
        this.txtIryoShikyuShinseishoSeiriBango3 = txtIryoShikyuShinseishoSeiriBango3;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango4
     * @return txtIryoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango4() {
        return txtIryoShikyuShinseishoSeiriBango4;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango4
     * @param txtIryoShikyuShinseishoSeiriBango4 txtIryoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    public void setTxtIryoShikyuShinseishoSeiriBango4(TextBox txtIryoShikyuShinseishoSeiriBango4) {
        this.txtIryoShikyuShinseishoSeiriBango4 = txtIryoShikyuShinseishoSeiriBango4;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getrdbShinseiKihonJohoKensaku
     * @return rdbShinseiKihonJohoKensaku
     */
    @JsonProperty("rdbShinseiKihonJohoKensaku")
    public RadioButton getRdbShinseiKihonJohoKensaku() {
        return rdbShinseiKihonJohoKensaku;
    }

    /*
     * setrdbShinseiKihonJohoKensaku
     * @param rdbShinseiKihonJohoKensaku rdbShinseiKihonJohoKensaku
     */
    @JsonProperty("rdbShinseiKihonJohoKensaku")
    public void setRdbShinseiKihonJohoKensaku(RadioButton rdbShinseiKihonJohoKensaku) {
        this.rdbShinseiKihonJohoKensaku = rdbShinseiKihonJohoKensaku;
    }

    /*
     * gettxtShinseiDaihyoshaShimei
     * @return txtShinseiDaihyoshaShimei
     */
    @JsonProperty("txtShinseiDaihyoshaShimei")
    public TextBox getTxtShinseiDaihyoshaShimei() {
        return txtShinseiDaihyoshaShimei;
    }

    /*
     * settxtShinseiDaihyoshaShimei
     * @param txtShinseiDaihyoshaShimei txtShinseiDaihyoshaShimei
     */
    @JsonProperty("txtShinseiDaihyoshaShimei")
    public void setTxtShinseiDaihyoshaShimei(TextBox txtShinseiDaihyoshaShimei) {
        this.txtShinseiDaihyoshaShimei = txtShinseiDaihyoshaShimei;
    }

    /*
     * getchkZempoItchi1
     * @return chkZempoItchi1
     */
    @JsonProperty("chkZempoItchi1")
    public CheckBoxList getChkZempoItchi1() {
        return chkZempoItchi1;
    }

    /*
     * setchkZempoItchi1
     * @param chkZempoItchi1 chkZempoItchi1
     */
    @JsonProperty("chkZempoItchi1")
    public void setChkZempoItchi1(CheckBoxList chkZempoItchi1) {
        this.chkZempoItchi1 = chkZempoItchi1;
    }

    /*
     * getrdbHihokensyaJohoKensaku
     * @return rdbHihokensyaJohoKensaku
     */
    @JsonProperty("rdbHihokensyaJohoKensaku")
    public RadioButton getRdbHihokensyaJohoKensaku() {
        return rdbHihokensyaJohoKensaku;
    }

    /*
     * setrdbHihokensyaJohoKensaku
     * @param rdbHihokensyaJohoKensaku rdbHihokensyaJohoKensaku
     */
    @JsonProperty("rdbHihokensyaJohoKensaku")
    public void setRdbHihokensyaJohoKensaku(RadioButton rdbHihokensyaJohoKensaku) {
        this.rdbHihokensyaJohoKensaku = rdbHihokensyaJohoKensaku;
    }

    /*
     * gettxtHihobango
     * @return txtHihobango
     */
    @JsonProperty("txtHihobango")
    public TextBox getTxtHihobango() {
        return txtHihobango;
    }

    /*
     * settxtHihobango
     * @param txtHihobango txtHihobango
     */
    @JsonProperty("txtHihobango")
    public void setTxtHihobango(TextBox txtHihobango) {
        this.txtHihobango = txtHihobango;
    }

    /*
     * gettxtHihokensyaShimei
     * @return txtHihokensyaShimei
     */
    @JsonProperty("txtHihokensyaShimei")
    public TextBox getTxtHihokensyaShimei() {
        return txtHihokensyaShimei;
    }

    /*
     * settxtHihokensyaShimei
     * @param txtHihokensyaShimei txtHihokensyaShimei
     */
    @JsonProperty("txtHihokensyaShimei")
    public void setTxtHihokensyaShimei(TextBox txtHihokensyaShimei) {
        this.txtHihokensyaShimei = txtHihokensyaShimei;
    }

    /*
     * getchkZempoItchi2
     * @return chkZempoItchi2
     */
    @JsonProperty("chkZempoItchi2")
    public CheckBoxList getChkZempoItchi2() {
        return chkZempoItchi2;
    }

    /*
     * setchkZempoItchi2
     * @param chkZempoItchi2 chkZempoItchi2
     */
    @JsonProperty("chkZempoItchi2")
    public void setChkZempoItchi2(CheckBoxList chkZempoItchi2) {
        this.chkZempoItchi2 = chkZempoItchi2;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    // </editor-fold>
}
