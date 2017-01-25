package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoIraiTorokuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoIraiTorokuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIraiKubun")
    private DropDownList ddlIraiKubun;
    @JsonProperty("txtSakuseiIraiYmd")
    private TextBoxDate txtSakuseiIraiYmd;
    @JsonProperty("btnSettei")
    private Button btnSettei;
    @JsonProperty("btnSetteisezuModoru")
    private Button btnSetteisezuModoru;
    @JsonProperty("ccdShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlIraiKubun
     * @return ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public DropDownList getDdlIraiKubun() {
        return ddlIraiKubun;
    }

    /*
     * setddlIraiKubun
     * @param ddlIraiKubun ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.ddlIraiKubun = ddlIraiKubun;
    }

    /*
     * gettxtSakuseiIraiYmd
     * @return txtSakuseiIraiYmd
     */
    @JsonProperty("txtSakuseiIraiYmd")
    public TextBoxDate getTxtSakuseiIraiYmd() {
        return txtSakuseiIraiYmd;
    }

    /*
     * settxtSakuseiIraiYmd
     * @param txtSakuseiIraiYmd txtSakuseiIraiYmd
     */
    @JsonProperty("txtSakuseiIraiYmd")
    public void setTxtSakuseiIraiYmd(TextBoxDate txtSakuseiIraiYmd) {
        this.txtSakuseiIraiYmd = txtSakuseiIraiYmd;
    }

    /*
     * getbtnSettei
     * @return btnSettei
     */
    @JsonProperty("btnSettei")
    public Button getBtnSettei() {
        return btnSettei;
    }

    /*
     * setbtnSettei
     * @param btnSettei btnSettei
     */
    @JsonProperty("btnSettei")
    public void setBtnSettei(Button btnSettei) {
        this.btnSettei = btnSettei;
    }

    /*
     * getbtnSetteisezuModoru
     * @return btnSetteisezuModoru
     */
    @JsonProperty("btnSetteisezuModoru")
    public Button getBtnSetteisezuModoru() {
        return btnSetteisezuModoru;
    }

    /*
     * setbtnSetteisezuModoru
     * @param btnSetteisezuModoru btnSetteisezuModoru
     */
    @JsonProperty("btnSetteisezuModoru")
    public void setBtnSetteisezuModoru(Button btnSetteisezuModoru) {
        this.btnSetteisezuModoru = btnSetteisezuModoru;
    }

    /*
     * getccdShujiiInput
     * @return ccdShujiiInput
     */
    @JsonProperty("ccdShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return ccdShujiiInput;
    }

    // </editor-fold>
}
