package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelServiceKeikakuhiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelServiceKeikakuhiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTanyiUp")
    private TextBoxNum txtTanyiUp;
    @JsonProperty("txtKaisu")
    private TextBoxNum txtKaisu;
    @JsonProperty("btnKeisan")
    private Button btnKeisan;
    @JsonProperty("txtServiceTanyiSu")
    private TextBoxNum txtServiceTanyiSu;
    @JsonProperty("txtTekiyoUp")
    private TextBox txtTekiyoUp;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("ccdServiceCodeInput")
    private ServiceCodeInputCommonChildDivDiv ccdServiceCodeInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTanyiUp
     * @return txtTanyiUp
     */
    @JsonProperty("txtTanyiUp")
    public TextBoxNum getTxtTanyiUp() {
        return txtTanyiUp;
    }

    /*
     * settxtTanyiUp
     * @param txtTanyiUp txtTanyiUp
     */
    @JsonProperty("txtTanyiUp")
    public void setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.txtTanyiUp = txtTanyiUp;
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
     * gettxtServiceTanyiSu
     * @return txtServiceTanyiSu
     */
    @JsonProperty("txtServiceTanyiSu")
    public TextBoxNum getTxtServiceTanyiSu() {
        return txtServiceTanyiSu;
    }

    /*
     * settxtServiceTanyiSu
     * @param txtServiceTanyiSu txtServiceTanyiSu
     */
    @JsonProperty("txtServiceTanyiSu")
    public void setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.txtServiceTanyiSu = txtServiceTanyiSu;
    }

    /*
     * gettxtTekiyoUp
     * @return txtTekiyoUp
     */
    @JsonProperty("txtTekiyoUp")
    public TextBox getTxtTekiyoUp() {
        return txtTekiyoUp;
    }

    /*
     * settxtTekiyoUp
     * @param txtTekiyoUp txtTekiyoUp
     */
    @JsonProperty("txtTekiyoUp")
    public void setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.txtTekiyoUp = txtTekiyoUp;
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
     * getccdServiceCodeInput
     * @return ccdServiceCodeInput
     */
    @JsonProperty("ccdServiceCodeInput")
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return ccdServiceCodeInput;
    }

    // </editor-fold>
}
