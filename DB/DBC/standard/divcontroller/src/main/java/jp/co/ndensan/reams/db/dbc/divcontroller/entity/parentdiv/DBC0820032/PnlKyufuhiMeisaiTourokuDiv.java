package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * PnlKyufuhiMeisaiTouroku のクラスファイル
 *
 * @author 自動生成
 */
public class PnlKyufuhiMeisaiTourokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdServiceCodeInput")
    private ServiceCodeInputCommonChildDivDiv ccdServiceCodeInput;
    @JsonProperty("txtTanyi")
    private TextBoxNum txtTanyi;
    @JsonProperty("txtKaisu")
    private TextBoxNum txtKaisu;
    @JsonProperty("btnKeisan")
    private Button btnKeisan;
    @JsonProperty("txtServiceTani")
    private TextBoxNum txtServiceTani;
    @JsonProperty("txtTekiyo")
    private TextBox txtTekiyo;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("ccdHokenshaJoho")
    private HokenshaJohoDiv ccdHokenshaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdServiceCodeInput
     * @return ccdServiceCodeInput
     */
    @JsonProperty("ccdServiceCodeInput")
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return ccdServiceCodeInput;
    }

    /*
     * gettxtTanyi
     * @return txtTanyi
     */
    @JsonProperty("txtTanyi")
    public TextBoxNum getTxtTanyi() {
        return txtTanyi;
    }

    /*
     * settxtTanyi
     * @param txtTanyi txtTanyi
     */
    @JsonProperty("txtTanyi")
    public void setTxtTanyi(TextBoxNum txtTanyi) {
        this.txtTanyi = txtTanyi;
    }

    /*
     * gettxtKaisu
     * @return txtKaisu
     */
    @JsonProperty("txtKaisu")
    public TextBoxNum getTxtKaisu() {
        return txtKaisu;
    }

    /*
     * settxtKaisu
     * @param txtKaisu txtKaisu
     */
    @JsonProperty("txtKaisu")
    public void setTxtKaisu(TextBoxNum txtKaisu) {
        this.txtKaisu = txtKaisu;
    }

    /*
     * getbtnKeisan
     * @return btnKeisan
     */
    @JsonProperty("btnKeisan")
    public Button getBtnKeisan() {
        return btnKeisan;
    }

    /*
     * setbtnKeisan
     * @param btnKeisan btnKeisan
     */
    @JsonProperty("btnKeisan")
    public void setBtnKeisan(Button btnKeisan) {
        this.btnKeisan = btnKeisan;
    }

    /*
     * gettxtServiceTani
     * @return txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    /*
     * settxtServiceTani
     * @param txtServiceTani txtServiceTani
     */
    @JsonProperty("txtServiceTani")
    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.txtServiceTani = txtServiceTani;
    }

    /*
     * gettxtTekiyo
     * @return txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public TextBox getTxtTekiyo() {
        return txtTekiyo;
    }

    /*
     * settxtTekiyo
     * @param txtTekiyo txtTekiyo
     */
    @JsonProperty("txtTekiyo")
    public void setTxtTekiyo(TextBox txtTekiyo) {
        this.txtTekiyo = txtTekiyo;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
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

    /*
     * getccdHokenshaJoho
     * @return ccdHokenshaJoho
     */
    @JsonProperty("ccdHokenshaJoho")
    public IHokenshaJohoDiv getCcdHokenshaJoho() {
        return ccdHokenshaJoho;
    }

    // </editor-fold>
}
