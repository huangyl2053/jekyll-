package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * HenshuNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenshuNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("txtYakushoMei")
    private TextBox txtYakushoMei;
    @JsonProperty("txtOnchu")
    private TextBox txtOnchu;
    @JsonProperty("txtTantokamei")
    private TextBox txtTantokamei;
    @JsonProperty("txtSam")
    private TextBox txtSam;
    @JsonProperty("btnJidoFuban")
    private Button btnJidoFuban;
    @JsonProperty("ccdPrintContentsSetting")
    private PrintContentsSettingDiv ccdPrintContentsSetting;
    @JsonProperty("txtBunshoBango")
    private TextBox txtBunshoBango;
    @JsonProperty("異動日")
    private RString 異動日;
    @JsonProperty("枝番")
    private RString 枝番;
    @JsonProperty("入所日")
    private RString 入所日;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtYakushoMei
     * @return txtYakushoMei
     */
    @JsonProperty("txtYakushoMei")
    public TextBox getTxtYakushoMei() {
        return txtYakushoMei;
    }

    /*
     * settxtYakushoMei
     * @param txtYakushoMei txtYakushoMei
     */
    @JsonProperty("txtYakushoMei")
    public void setTxtYakushoMei(TextBox txtYakushoMei) {
        this.txtYakushoMei = txtYakushoMei;
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
     * get異動日
     * @return 異動日
     */
    @JsonProperty("異動日")
    public RString get異動日() {
        return 異動日;
    }

    /*
     * set異動日
     * @param 異動日 異動日
     */
    @JsonProperty("異動日")
    public void set異動日(RString 異動日) {
        this.異動日 = 異動日;
    }

    /*
     * get枝番
     * @return 枝番
     */
    @JsonProperty("枝番")
    public RString get枝番() {
        return 枝番;
    }

    /*
     * set枝番
     * @param 枝番 枝番
     */
    @JsonProperty("枝番")
    public void set枝番(RString 枝番) {
        this.枝番 = 枝番;
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
