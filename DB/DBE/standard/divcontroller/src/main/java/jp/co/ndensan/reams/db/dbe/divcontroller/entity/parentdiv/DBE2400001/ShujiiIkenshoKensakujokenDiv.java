package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShujiiIkenshoKensakujoken のクラスファイル
 *
 * @reamsid_L DBE-0080-010 duanzhanli
 */
public class ShujiiIkenshoKensakujokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiFrom")
    private TextBoxDate txtShujiiIkenshoSakuseiIraibiFrom;
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiTo")
    private TextBoxDate txtShujiiIkenshoSakuseiIraibiTo;
    @JsonProperty("chkShujiiikenshoSakuseiIrai")
    private CheckBoxList chkShujiiikenshoSakuseiIrai;
    @JsonProperty("chkShujiiIkensho")
    private CheckBoxList chkShujiiIkensho;
    @JsonProperty("btnShujiiIkenshoKensaku")
    private Button btnShujiiIkenshoKensaku;
    @JsonProperty("ccdShujiiIkenshoHokensha")
    private HokenshaListDiv ccdShujiiIkenshoHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShujiiIkenshoSakuseiIraibiFrom
     * @return txtShujiiIkenshoSakuseiIraibiFrom
     */
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiFrom")
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiFrom() {
        return txtShujiiIkenshoSakuseiIraibiFrom;
    }

    /*
     * settxtShujiiIkenshoSakuseiIraibiFrom
     * @param txtShujiiIkenshoSakuseiIraibiFrom txtShujiiIkenshoSakuseiIraibiFrom
     */
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiFrom")
    public void setTxtShujiiIkenshoSakuseiIraibiFrom(TextBoxDate txtShujiiIkenshoSakuseiIraibiFrom) {
        this.txtShujiiIkenshoSakuseiIraibiFrom = txtShujiiIkenshoSakuseiIraibiFrom;
    }

    /*
     * gettxtShujiiIkenshoSakuseiIraibiTo
     * @return txtShujiiIkenshoSakuseiIraibiTo
     */
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiTo")
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiTo() {
        return txtShujiiIkenshoSakuseiIraibiTo;
    }

    /*
     * settxtShujiiIkenshoSakuseiIraibiTo
     * @param txtShujiiIkenshoSakuseiIraibiTo txtShujiiIkenshoSakuseiIraibiTo
     */
    @JsonProperty("txtShujiiIkenshoSakuseiIraibiTo")
    public void setTxtShujiiIkenshoSakuseiIraibiTo(TextBoxDate txtShujiiIkenshoSakuseiIraibiTo) {
        this.txtShujiiIkenshoSakuseiIraibiTo = txtShujiiIkenshoSakuseiIraibiTo;
    }

    /*
     * getchkShujiiikenshoSakuseiIrai
     * @return chkShujiiikenshoSakuseiIrai
     */
    @JsonProperty("chkShujiiikenshoSakuseiIrai")
    public CheckBoxList getChkShujiiikenshoSakuseiIrai() {
        return chkShujiiikenshoSakuseiIrai;
    }

    /*
     * setchkShujiiikenshoSakuseiIrai
     * @param chkShujiiikenshoSakuseiIrai chkShujiiikenshoSakuseiIrai
     */
    @JsonProperty("chkShujiiikenshoSakuseiIrai")
    public void setChkShujiiikenshoSakuseiIrai(CheckBoxList chkShujiiikenshoSakuseiIrai) {
        this.chkShujiiikenshoSakuseiIrai = chkShujiiikenshoSakuseiIrai;
    }

    /*
     * getchkShujiiIkensho
     * @return chkShujiiIkensho
     */
    @JsonProperty("chkShujiiIkensho")
    public CheckBoxList getChkShujiiIkensho() {
        return chkShujiiIkensho;
    }

    /*
     * setchkShujiiIkensho
     * @param chkShujiiIkensho chkShujiiIkensho
     */
    @JsonProperty("chkShujiiIkensho")
    public void setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.chkShujiiIkensho = chkShujiiIkensho;
    }

    /*
     * getbtnShujiiIkenshoKensaku
     * @return btnShujiiIkenshoKensaku
     */
    @JsonProperty("btnShujiiIkenshoKensaku")
    public Button getBtnShujiiIkenshoKensaku() {
        return btnShujiiIkenshoKensaku;
    }

    /*
     * setbtnShujiiIkenshoKensaku
     * @param btnShujiiIkenshoKensaku btnShujiiIkenshoKensaku
     */
    @JsonProperty("btnShujiiIkenshoKensaku")
    public void setBtnShujiiIkenshoKensaku(Button btnShujiiIkenshoKensaku) {
        this.btnShujiiIkenshoKensaku = btnShujiiIkenshoKensaku;
    }

    /*
     * getccdShujiiIkenshoHokensha
     * @return ccdShujiiIkenshoHokensha
     */
    @JsonProperty("ccdShujiiIkenshoHokensha")
    public IHokenshaListDiv getCcdShujiiIkenshoHokensha() {
        return ccdShujiiIkenshoHokensha;
    }

    // </editor-fold>
}
