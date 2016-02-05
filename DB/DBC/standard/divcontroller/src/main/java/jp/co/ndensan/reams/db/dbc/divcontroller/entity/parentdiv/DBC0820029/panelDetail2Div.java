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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("btnCacel2")
    private Button btnCacel2;
    @JsonProperty("btnClear1")
    private Button btnClear1;
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
     * getbtnCacel2
     * @return btnCacel2
     */
    @JsonProperty("btnCacel2")
    public Button getBtnCacel2() {
        return btnCacel2;
    }

    /*
     * setbtnCacel2
     * @param btnCacel2 btnCacel2
     */
    @JsonProperty("btnCacel2")
    public void setBtnCacel2(Button btnCacel2) {
        this.btnCacel2 = btnCacel2;
    }

    /*
     * getbtnClear1
     * @return btnClear1
     */
    @JsonProperty("btnClear1")
    public Button getBtnClear1() {
        return btnClear1;
    }

    /*
     * setbtnClear1
     * @param btnClear1 btnClear1
     */
    @JsonProperty("btnClear1")
    public void setBtnClear1(Button btnClear1) {
        this.btnClear1 = btnClear1;
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
