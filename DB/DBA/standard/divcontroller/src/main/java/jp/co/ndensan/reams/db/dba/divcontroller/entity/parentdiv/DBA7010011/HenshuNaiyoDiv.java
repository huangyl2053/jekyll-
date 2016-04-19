package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * HenshuNaiyo のクラスファイル 
 * 
 */
public class HenshuNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYakushoMeiOne")
    private TextBox txtYakushoMeiOne;
    @JsonProperty("txtTantokamei")
    private TextBox txtTantokamei;
    @JsonProperty("txtSam")
    private TextBox txtSam;
    @JsonProperty("txtYakushoMeiTwo")
    private TextBox txtYakushoMeiTwo;
    @JsonProperty("txtOnchu")
    private TextBox txtOnchu;
    @JsonProperty("chkTenNyuGonai")
    private CheckBoxList chkTenNyuGonai;
    @JsonProperty("btnZenkaiBango")
    private Button btnZenkaiBango;
    @JsonProperty("txtBunshoBango")
    private TextBox txtBunshoBango;
    @JsonProperty("btnJidoFuban")
    private Button btnJidoFuban;
    @JsonProperty("ccdPrintContentsSetting")
    private PrintContentsSettingDiv ccdPrintContentsSetting;
    @JsonProperty("ccdZenkokuJushoInput")
    private ZenkokuJushoInputDiv ccdZenkokuJushoInput;
    @JsonProperty("他市町村住所地特例異動日")
    private RString 他市町村住所地特例異動日;
    @JsonProperty("他市町村住所地特例枝番")
    private RString 他市町村住所地特例枝番;
    @JsonProperty("入所日")
    private RString 入所日;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYakushoMeiOne
     * @return txtYakushoMeiOne
     */
    @JsonProperty("txtYakushoMeiOne")
    public TextBox getTxtYakushoMeiOne() {
        return txtYakushoMeiOne;
    }

    /*
     * settxtYakushoMeiOne
     * @param txtYakushoMeiOne txtYakushoMeiOne
     */
    @JsonProperty("txtYakushoMeiOne")
    public void setTxtYakushoMeiOne(TextBox txtYakushoMeiOne) {
        this.txtYakushoMeiOne = txtYakushoMeiOne;
    }

    /*
     * gettxtTantokamei
     * @return txtTantokamei
     */
    @JsonProperty("txtTantokamei")
    public TextBox getTxtTantokamei() {
        return txtTantokamei;
    }

    /*
     * settxtTantokamei
     * @param txtTantokamei txtTantokamei
     */
    @JsonProperty("txtTantokamei")
    public void setTxtTantokamei(TextBox txtTantokamei) {
        this.txtTantokamei = txtTantokamei;
    }

    /*
     * gettxtSam
     * @return txtSam
     */
    @JsonProperty("txtSam")
    public TextBox getTxtSam() {
        return txtSam;
    }

    /*
     * settxtSam
     * @param txtSam txtSam
     */
    @JsonProperty("txtSam")
    public void setTxtSam(TextBox txtSam) {
        this.txtSam = txtSam;
    }

    /*
     * gettxtYakushoMeiTwo
     * @return txtYakushoMeiTwo
     */
    @JsonProperty("txtYakushoMeiTwo")
    public TextBox getTxtYakushoMeiTwo() {
        return txtYakushoMeiTwo;
    }

    /*
     * settxtYakushoMeiTwo
     * @param txtYakushoMeiTwo txtYakushoMeiTwo
     */
    @JsonProperty("txtYakushoMeiTwo")
    public void setTxtYakushoMeiTwo(TextBox txtYakushoMeiTwo) {
        this.txtYakushoMeiTwo = txtYakushoMeiTwo;
    }

    /*
     * gettxtOnchu
     * @return txtOnchu
     */
    @JsonProperty("txtOnchu")
    public TextBox getTxtOnchu() {
        return txtOnchu;
    }

    /*
     * settxtOnchu
     * @param txtOnchu txtOnchu
     */
    @JsonProperty("txtOnchu")
    public void setTxtOnchu(TextBox txtOnchu) {
        this.txtOnchu = txtOnchu;
    }

    /*
     * getchkTenNyuGonai
     * @return chkTenNyuGonai
     */
    @JsonProperty("chkTenNyuGonai")
    public CheckBoxList getChkTenNyuGonai() {
        return chkTenNyuGonai;
    }

    /*
     * setchkTenNyuGonai
     * @param chkTenNyuGonai chkTenNyuGonai
     */
    @JsonProperty("chkTenNyuGonai")
    public void setChkTenNyuGonai(CheckBoxList chkTenNyuGonai) {
        this.chkTenNyuGonai = chkTenNyuGonai;
    }

    /*
     * getbtnZenkaiBango
     * @return btnZenkaiBango
     */
    @JsonProperty("btnZenkaiBango")
    public Button getBtnZenkaiBango() {
        return btnZenkaiBango;
    }

    /*
     * setbtnZenkaiBango
     * @param btnZenkaiBango btnZenkaiBango
     */
    @JsonProperty("btnZenkaiBango")
    public void setBtnZenkaiBango(Button btnZenkaiBango) {
        this.btnZenkaiBango = btnZenkaiBango;
    }

    /*
     * gettxtBunshoBango
     * @return txtBunshoBango
     */
    @JsonProperty("txtBunshoBango")
    public TextBox getTxtBunshoBango() {
        return txtBunshoBango;
    }

    /*
     * settxtBunshoBango
     * @param txtBunshoBango txtBunshoBango
     */
    @JsonProperty("txtBunshoBango")
    public void setTxtBunshoBango(TextBox txtBunshoBango) {
        this.txtBunshoBango = txtBunshoBango;
    }

    /*
     * getbtnJidoFuban
     * @return btnJidoFuban
     */
    @JsonProperty("btnJidoFuban")
    public Button getBtnJidoFuban() {
        return btnJidoFuban;
    }

    /*
     * setbtnJidoFuban
     * @param btnJidoFuban btnJidoFuban
     */
    @JsonProperty("btnJidoFuban")
    public void setBtnJidoFuban(Button btnJidoFuban) {
        this.btnJidoFuban = btnJidoFuban;
    }

    /*
     * getccdPrintContentsSetting
     * @return ccdPrintContentsSetting
     */
    @JsonProperty("ccdPrintContentsSetting")
    public IPrintContentsSettingDiv getCcdPrintContentsSetting() {
        return ccdPrintContentsSetting;
    }

    /*
     * getccdZenkokuJushoInput
     * @return ccdZenkokuJushoInput
     */
    @JsonProperty("ccdZenkokuJushoInput")
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput() {
        return ccdZenkokuJushoInput;
    }

    /*
     * get他市町村住所地特例異動日
     * @return 他市町村住所地特例異動日
     */
    @JsonProperty("他市町村住所地特例異動日")
    public RString get他市町村住所地特例異動日() {
        return 他市町村住所地特例異動日;
    }

    /*
     * set他市町村住所地特例異動日
     * @param 他市町村住所地特例異動日 他市町村住所地特例異動日
     */
    @JsonProperty("他市町村住所地特例異動日")
    public void set他市町村住所地特例異動日(RString 他市町村住所地特例異動日) {
        this.他市町村住所地特例異動日 = 他市町村住所地特例異動日;
    }

    /*
     * get他市町村住所地特例枝番
     * @return 他市町村住所地特例枝番
     */
    @JsonProperty("他市町村住所地特例枝番")
    public RString get他市町村住所地特例枝番() {
        return 他市町村住所地特例枝番;
    }

    /*
     * set他市町村住所地特例枝番
     * @param 他市町村住所地特例枝番 他市町村住所地特例枝番
     */
    @JsonProperty("他市町村住所地特例枝番")
    public void set他市町村住所地特例枝番(RString 他市町村住所地特例枝番) {
        this.他市町村住所地特例枝番 = 他市町村住所地特例枝番;
    }

    /*
     * get入所日
     * @return 入所日
     */
    @JsonProperty("入所日")
    public RString get入所日() {
        return 入所日;
    }

    /*
     * set入所日
     * @param 入所日 入所日
     */
    @JsonProperty("入所日")
    public void set入所日(RString 入所日) {
        this.入所日 = 入所日;
    }

    // </editor-fold>
}
