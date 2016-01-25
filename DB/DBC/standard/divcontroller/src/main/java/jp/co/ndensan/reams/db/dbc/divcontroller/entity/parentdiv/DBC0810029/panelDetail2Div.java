package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelDetail2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelDetail2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceCodeShurui")
    private TextBoxCode txtServiceCodeShurui;
    @JsonProperty("txtServiceItemCode")
    private TextBoxCode txtServiceItemCode;
    @JsonProperty("txtServiceName")
    private TextBox txtServiceName;
    @JsonProperty("txtTanyi")
    private TextBoxNum txtTanyi;
    @JsonProperty("txtKaisuuNisuu")
    private TextBoxNum txtKaisuuNisuu;
    @JsonProperty("btnKinngaku")
    private TextBoxNum btnKinngaku;
    @JsonProperty("btnCloseDown")
    private Button btnCloseDown;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceCodeShurui
     * @return txtServiceCodeShurui
     */
    @JsonProperty("txtServiceCodeShurui")
    public TextBoxCode getTxtServiceCodeShurui() {
        return txtServiceCodeShurui;
    }

    /*
     * settxtServiceCodeShurui
     * @param txtServiceCodeShurui txtServiceCodeShurui
     */
    @JsonProperty("txtServiceCodeShurui")
    public void setTxtServiceCodeShurui(TextBoxCode txtServiceCodeShurui) {
        this.txtServiceCodeShurui = txtServiceCodeShurui;
    }

    /*
     * gettxtServiceItemCode
     * @return txtServiceItemCode
     */
    @JsonProperty("txtServiceItemCode")
    public TextBoxCode getTxtServiceItemCode() {
        return txtServiceItemCode;
    }

    /*
     * settxtServiceItemCode
     * @param txtServiceItemCode txtServiceItemCode
     */
    @JsonProperty("txtServiceItemCode")
    public void setTxtServiceItemCode(TextBoxCode txtServiceItemCode) {
        this.txtServiceItemCode = txtServiceItemCode;
    }

    /*
     * gettxtServiceName
     * @return txtServiceName
     */
    @JsonProperty("txtServiceName")
    public TextBox getTxtServiceName() {
        return txtServiceName;
    }

    /*
     * settxtServiceName
     * @param txtServiceName txtServiceName
     */
    @JsonProperty("txtServiceName")
    public void setTxtServiceName(TextBox txtServiceName) {
        this.txtServiceName = txtServiceName;
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
     * getbtnCloseDown
     * @return btnCloseDown
     */
    @JsonProperty("btnCloseDown")
    public Button getBtnCloseDown() {
        return btnCloseDown;
    }

    /*
     * setbtnCloseDown
     * @param btnCloseDown btnCloseDown
     */
    @JsonProperty("btnCloseDown")
    public void setBtnCloseDown(Button btnCloseDown) {
        this.btnCloseDown = btnCloseDown;
    }

    // </editor-fold>
}
