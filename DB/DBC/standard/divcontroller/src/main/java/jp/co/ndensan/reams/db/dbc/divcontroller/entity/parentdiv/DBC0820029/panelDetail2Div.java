package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820029;
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
 * panelDetail2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelDetail2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTanyi")
    private TextBoxNum txtTanyi;
    @JsonProperty("txtKaisuuNisuu")
    private TextBoxNum txtKaisuuNisuu;
    @JsonProperty("btnCal2")
    private Button btnCal2;
    @JsonProperty("btnKinngaku")
    private TextBoxNum btnKinngaku;
    @JsonProperty("btnConfirm2")
    private Button btnConfirm2;
    @JsonProperty("btnClear2")
    private Button btnClear2;
    @JsonProperty("btnCancel2")
    private Button btnCancel2;
    @JsonProperty("ccdServiceCodeInput")
    private ServiceCodeInputCommonChildDivDiv ccdServiceCodeInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtKaisuuNisuu
     * @return txtKaisuuNisuu
     */
    @JsonProperty("txtKaisuuNisuu")
    public TextBoxNum getTxtKaisuuNisuu() {
        return txtKaisuuNisuu;
    }

    /*
     * settxtKaisuuNisuu
     * @param txtKaisuuNisuu txtKaisuuNisuu
     */
    @JsonProperty("txtKaisuuNisuu")
    public void setTxtKaisuuNisuu(TextBoxNum txtKaisuuNisuu) {
        this.txtKaisuuNisuu = txtKaisuuNisuu;
    }

    /*
     * getbtnCal2
     * @return btnCal2
     */
    @JsonProperty("btnCal2")
    public Button getBtnCal2() {
        return btnCal2;
    }

    /*
     * setbtnCal2
     * @param btnCal2 btnCal2
     */
    @JsonProperty("btnCal2")
    public void setBtnCal2(Button btnCal2) {
        this.btnCal2 = btnCal2;
    }

    /*
     * getbtnKinngaku
     * @return btnKinngaku
     */
    @JsonProperty("btnKinngaku")
    public TextBoxNum getBtnKinngaku() {
        return btnKinngaku;
    }

    /*
     * setbtnKinngaku
     * @param btnKinngaku btnKinngaku
     */
    @JsonProperty("btnKinngaku")
    public void setBtnKinngaku(TextBoxNum btnKinngaku) {
        this.btnKinngaku = btnKinngaku;
    }

    /*
     * getbtnConfirm2
     * @return btnConfirm2
     */
    @JsonProperty("btnConfirm2")
    public Button getBtnConfirm2() {
        return btnConfirm2;
    }

    /*
     * setbtnConfirm2
     * @param btnConfirm2 btnConfirm2
     */
    @JsonProperty("btnConfirm2")
    public void setBtnConfirm2(Button btnConfirm2) {
        this.btnConfirm2 = btnConfirm2;
    }

    /*
     * getbtnClear2
     * @return btnClear2
     */
    @JsonProperty("btnClear2")
    public Button getBtnClear2() {
        return btnClear2;
    }

    /*
     * setbtnClear2
     * @param btnClear2 btnClear2
     */
    @JsonProperty("btnClear2")
    public void setBtnClear2(Button btnClear2) {
        this.btnClear2 = btnClear2;
    }

    /*
     * getbtnCancel2
     * @return btnCancel2
     */
    @JsonProperty("btnCancel2")
    public Button getBtnCancel2() {
        return btnCancel2;
    }

    /*
     * setbtnCancel2
     * @param btnCancel2 btnCancel2
     */
    @JsonProperty("btnCancel2")
    public void setBtnCancel2(Button btnCancel2) {
        this.btnCancel2 = btnCancel2;
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
