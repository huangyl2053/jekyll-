package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KobetsuHyojiArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class KobetsuHyojiAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiJunjo")
    private TextBox txtShinsakaiJunjo;
    @JsonProperty("txtShinseiDay")
    private TextBoxFlexibleDate txtShinseiDay;
    @JsonProperty("txtBirthYMD")
    private TextBoxFlexibleDate txtBirthYMD;
    @JsonProperty("txtShinseiKubunShinseiji")
    private TextBox txtShinseiKubunShinseiji;
    @JsonProperty("txtShinseiKubunLow")
    private TextBox txtShinseiKubunLow;
    @JsonProperty("txtIchijiHantei")
    private TextBox txtIchijiHantei;
    @JsonProperty("txtNijiHanteiDay")
    private TextBoxFlexibleDate txtNijiHanteiDay;
    @JsonProperty("txtTokuteiShippei")
    private TextBox txtTokuteiShippei;
    @JsonProperty("ddlJotaiZo")
    private DropDownList ddlJotaiZo;
    @JsonProperty("ddlHanteiKekka")
    private DropDownList ddlHanteiKekka;
    @JsonProperty("ddlNijiHantei")
    private DropDownList ddlNijiHantei;
    @JsonProperty("txtNinteiKikanFrom")
    private TextBoxDate txtNinteiKikanFrom;
    @JsonProperty("txtNinteiKikanTo")
    private TextBoxDate txtNinteiKikanTo;
    @JsonProperty("txtNinteiKikanMonth")
    private TextBoxNum txtNinteiKikanMonth;
    @JsonProperty("linHorizon")
    private HorizontalLine linHorizon;
    @JsonProperty("lblShiinsakaiMemo")
    private Label lblShiinsakaiMemo;
    @JsonProperty("btnShinsakaiMemoTeikeibunGuide")
    private ButtonDialog btnShinsakaiMemoTeikeibunGuide;
    @JsonProperty("lblShinsakaiIken")
    private Label lblShinsakaiIken;
    @JsonProperty("ddlShinsakaiIkenShurui")
    private DropDownList ddlShinsakaiIkenShurui;
    @JsonProperty("btnShinsakiIkenTeikeibunGuide")
    private ButtonDialog btnShinsakiIkenTeikeibunGuide;
    @JsonProperty("txtShinsakaiMemo")
    private TextBoxMultiLine txtShinsakaiMemo;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("lblIchijiHanteiKekkaHenkoRiyu")
    private Label lblIchijiHanteiKekkaHenkoRiyu;
    @JsonProperty("btnIchijiHanteiTeikeibunGuide")
    private ButtonDialog btnIchijiHanteiTeikeibunGuide;
    @JsonProperty("txtIchijiHanteiKekkaHenkoRiyu")
    private TextBoxMultiLine txtIchijiHanteiKekkaHenkoRiyu;
    @JsonProperty("btnNinteiChosaJokyoShokai")
    private ButtonDialog btnNinteiChosaJokyoShokai;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnIchigoHantei")
    private ButtonDialog btnIchigoHantei;
    @JsonProperty("hasData")
    private RString hasData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinsakaiJunjo
     * @return txtShinsakaiJunjo
     */
    @JsonProperty("txtShinsakaiJunjo")
    public TextBox getTxtShinsakaiJunjo() {
        return txtShinsakaiJunjo;
    }

    /*
     * settxtShinsakaiJunjo
     * @param txtShinsakaiJunjo txtShinsakaiJunjo
     */
    @JsonProperty("txtShinsakaiJunjo")
    public void setTxtShinsakaiJunjo(TextBox txtShinsakaiJunjo) {
        this.txtShinsakaiJunjo = txtShinsakaiJunjo;
    }

    /*
     * gettxtShinseiDay
     * @return txtShinseiDay
     */
    @JsonProperty("txtShinseiDay")
    public TextBoxFlexibleDate getTxtShinseiDay() {
        return txtShinseiDay;
    }

    /*
     * settxtShinseiDay
     * @param txtShinseiDay txtShinseiDay
     */
    @JsonProperty("txtShinseiDay")
    public void setTxtShinseiDay(TextBoxFlexibleDate txtShinseiDay) {
        this.txtShinseiDay = txtShinseiDay;
    }

    /*
     * gettxtBirthYMD
     * @return txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public TextBoxFlexibleDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    /*
     * settxtBirthYMD
     * @param txtBirthYMD txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxFlexibleDate txtBirthYMD) {
        this.txtBirthYMD = txtBirthYMD;
    }

    /*
     * gettxtShinseiKubunShinseiji
     * @return txtShinseiKubunShinseiji
     */
    @JsonProperty("txtShinseiKubunShinseiji")
    public TextBox getTxtShinseiKubunShinseiji() {
        return txtShinseiKubunShinseiji;
    }

    /*
     * settxtShinseiKubunShinseiji
     * @param txtShinseiKubunShinseiji txtShinseiKubunShinseiji
     */
    @JsonProperty("txtShinseiKubunShinseiji")
    public void setTxtShinseiKubunShinseiji(TextBox txtShinseiKubunShinseiji) {
        this.txtShinseiKubunShinseiji = txtShinseiKubunShinseiji;
    }

    /*
     * gettxtShinseiKubunLow
     * @return txtShinseiKubunLow
     */
    @JsonProperty("txtShinseiKubunLow")
    public TextBox getTxtShinseiKubunLow() {
        return txtShinseiKubunLow;
    }

    /*
     * settxtShinseiKubunLow
     * @param txtShinseiKubunLow txtShinseiKubunLow
     */
    @JsonProperty("txtShinseiKubunLow")
    public void setTxtShinseiKubunLow(TextBox txtShinseiKubunLow) {
        this.txtShinseiKubunLow = txtShinseiKubunLow;
    }

    /*
     * gettxtIchijiHantei
     * @return txtIchijiHantei
     */
    @JsonProperty("txtIchijiHantei")
    public TextBox getTxtIchijiHantei() {
        return txtIchijiHantei;
    }

    /*
     * settxtIchijiHantei
     * @param txtIchijiHantei txtIchijiHantei
     */
    @JsonProperty("txtIchijiHantei")
    public void setTxtIchijiHantei(TextBox txtIchijiHantei) {
        this.txtIchijiHantei = txtIchijiHantei;
    }

    /*
     * gettxtNijiHanteiDay
     * @return txtNijiHanteiDay
     */
    @JsonProperty("txtNijiHanteiDay")
    public TextBoxFlexibleDate getTxtNijiHanteiDay() {
        return txtNijiHanteiDay;
    }

    /*
     * settxtNijiHanteiDay
     * @param txtNijiHanteiDay txtNijiHanteiDay
     */
    @JsonProperty("txtNijiHanteiDay")
    public void setTxtNijiHanteiDay(TextBoxFlexibleDate txtNijiHanteiDay) {
        this.txtNijiHanteiDay = txtNijiHanteiDay;
    }

    /*
     * gettxtTokuteiShippei
     * @return txtTokuteiShippei
     */
    @JsonProperty("txtTokuteiShippei")
    public TextBox getTxtTokuteiShippei() {
        return txtTokuteiShippei;
    }

    /*
     * settxtTokuteiShippei
     * @param txtTokuteiShippei txtTokuteiShippei
     */
    @JsonProperty("txtTokuteiShippei")
    public void setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.txtTokuteiShippei = txtTokuteiShippei;
    }

    /*
     * getddlJotaiZo
     * @return ddlJotaiZo
     */
    @JsonProperty("ddlJotaiZo")
    public DropDownList getDdlJotaiZo() {
        return ddlJotaiZo;
    }

    /*
     * setddlJotaiZo
     * @param ddlJotaiZo ddlJotaiZo
     */
    @JsonProperty("ddlJotaiZo")
    public void setDdlJotaiZo(DropDownList ddlJotaiZo) {
        this.ddlJotaiZo = ddlJotaiZo;
    }

    /*
     * getddlHanteiKekka
     * @return ddlHanteiKekka
     */
    @JsonProperty("ddlHanteiKekka")
    public DropDownList getDdlHanteiKekka() {
        return ddlHanteiKekka;
    }

    /*
     * setddlHanteiKekka
     * @param ddlHanteiKekka ddlHanteiKekka
     */
    @JsonProperty("ddlHanteiKekka")
    public void setDdlHanteiKekka(DropDownList ddlHanteiKekka) {
        this.ddlHanteiKekka = ddlHanteiKekka;
    }

    /*
     * getddlNijiHantei
     * @return ddlNijiHantei
     */
    @JsonProperty("ddlNijiHantei")
    public DropDownList getDdlNijiHantei() {
        return ddlNijiHantei;
    }

    /*
     * setddlNijiHantei
     * @param ddlNijiHantei ddlNijiHantei
     */
    @JsonProperty("ddlNijiHantei")
    public void setDdlNijiHantei(DropDownList ddlNijiHantei) {
        this.ddlNijiHantei = ddlNijiHantei;
    }

    /*
     * gettxtNinteiKikanFrom
     * @return txtNinteiKikanFrom
     */
    @JsonProperty("txtNinteiKikanFrom")
    public TextBoxDate getTxtNinteiKikanFrom() {
        return txtNinteiKikanFrom;
    }

    /*
     * settxtNinteiKikanFrom
     * @param txtNinteiKikanFrom txtNinteiKikanFrom
     */
    @JsonProperty("txtNinteiKikanFrom")
    public void setTxtNinteiKikanFrom(TextBoxDate txtNinteiKikanFrom) {
        this.txtNinteiKikanFrom = txtNinteiKikanFrom;
    }

    /*
     * gettxtNinteiKikanTo
     * @return txtNinteiKikanTo
     */
    @JsonProperty("txtNinteiKikanTo")
    public TextBoxDate getTxtNinteiKikanTo() {
        return txtNinteiKikanTo;
    }

    /*
     * settxtNinteiKikanTo
     * @param txtNinteiKikanTo txtNinteiKikanTo
     */
    @JsonProperty("txtNinteiKikanTo")
    public void setTxtNinteiKikanTo(TextBoxDate txtNinteiKikanTo) {
        this.txtNinteiKikanTo = txtNinteiKikanTo;
    }

    /*
     * gettxtNinteiKikanMonth
     * @return txtNinteiKikanMonth
     */
    @JsonProperty("txtNinteiKikanMonth")
    public TextBoxNum getTxtNinteiKikanMonth() {
        return txtNinteiKikanMonth;
    }

    /*
     * settxtNinteiKikanMonth
     * @param txtNinteiKikanMonth txtNinteiKikanMonth
     */
    @JsonProperty("txtNinteiKikanMonth")
    public void setTxtNinteiKikanMonth(TextBoxNum txtNinteiKikanMonth) {
        this.txtNinteiKikanMonth = txtNinteiKikanMonth;
    }

    /*
     * getlinHorizon
     * @return linHorizon
     */
    @JsonProperty("linHorizon")
    public HorizontalLine getLinHorizon() {
        return linHorizon;
    }

    /*
     * setlinHorizon
     * @param linHorizon linHorizon
     */
    @JsonProperty("linHorizon")
    public void setLinHorizon(HorizontalLine linHorizon) {
        this.linHorizon = linHorizon;
    }

    /*
     * getlblShiinsakaiMemo
     * @return lblShiinsakaiMemo
     */
    @JsonProperty("lblShiinsakaiMemo")
    public Label getLblShiinsakaiMemo() {
        return lblShiinsakaiMemo;
    }

    /*
     * setlblShiinsakaiMemo
     * @param lblShiinsakaiMemo lblShiinsakaiMemo
     */
    @JsonProperty("lblShiinsakaiMemo")
    public void setLblShiinsakaiMemo(Label lblShiinsakaiMemo) {
        this.lblShiinsakaiMemo = lblShiinsakaiMemo;
    }

    /*
     * getbtnShinsakaiMemoTeikeibunGuide
     * @return btnShinsakaiMemoTeikeibunGuide
     */
    @JsonProperty("btnShinsakaiMemoTeikeibunGuide")
    public ButtonDialog getBtnShinsakaiMemoTeikeibunGuide() {
        return btnShinsakaiMemoTeikeibunGuide;
    }

    /*
     * setbtnShinsakaiMemoTeikeibunGuide
     * @param btnShinsakaiMemoTeikeibunGuide btnShinsakaiMemoTeikeibunGuide
     */
    @JsonProperty("btnShinsakaiMemoTeikeibunGuide")
    public void setBtnShinsakaiMemoTeikeibunGuide(ButtonDialog btnShinsakaiMemoTeikeibunGuide) {
        this.btnShinsakaiMemoTeikeibunGuide = btnShinsakaiMemoTeikeibunGuide;
    }

    /*
     * getlblShinsakaiIken
     * @return lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public Label getLblShinsakaiIken() {
        return lblShinsakaiIken;
    }

    /*
     * setlblShinsakaiIken
     * @param lblShinsakaiIken lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public void setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.lblShinsakaiIken = lblShinsakaiIken;
    }

    /*
     * getddlShinsakaiIkenShurui
     * @return ddlShinsakaiIkenShurui
     */
    @JsonProperty("ddlShinsakaiIkenShurui")
    public DropDownList getDdlShinsakaiIkenShurui() {
        return ddlShinsakaiIkenShurui;
    }

    /*
     * setddlShinsakaiIkenShurui
     * @param ddlShinsakaiIkenShurui ddlShinsakaiIkenShurui
     */
    @JsonProperty("ddlShinsakaiIkenShurui")
    public void setDdlShinsakaiIkenShurui(DropDownList ddlShinsakaiIkenShurui) {
        this.ddlShinsakaiIkenShurui = ddlShinsakaiIkenShurui;
    }

    /*
     * getbtnShinsakiIkenTeikeibunGuide
     * @return btnShinsakiIkenTeikeibunGuide
     */
    @JsonProperty("btnShinsakiIkenTeikeibunGuide")
    public ButtonDialog getBtnShinsakiIkenTeikeibunGuide() {
        return btnShinsakiIkenTeikeibunGuide;
    }

    /*
     * setbtnShinsakiIkenTeikeibunGuide
     * @param btnShinsakiIkenTeikeibunGuide btnShinsakiIkenTeikeibunGuide
     */
    @JsonProperty("btnShinsakiIkenTeikeibunGuide")
    public void setBtnShinsakiIkenTeikeibunGuide(ButtonDialog btnShinsakiIkenTeikeibunGuide) {
        this.btnShinsakiIkenTeikeibunGuide = btnShinsakiIkenTeikeibunGuide;
    }

    /*
     * gettxtShinsakaiMemo
     * @return txtShinsakaiMemo
     */
    @JsonProperty("txtShinsakaiMemo")
    public TextBoxMultiLine getTxtShinsakaiMemo() {
        return txtShinsakaiMemo;
    }

    /*
     * settxtShinsakaiMemo
     * @param txtShinsakaiMemo txtShinsakaiMemo
     */
    @JsonProperty("txtShinsakaiMemo")
    public void setTxtShinsakaiMemo(TextBoxMultiLine txtShinsakaiMemo) {
        this.txtShinsakaiMemo = txtShinsakaiMemo;
    }

    /*
     * gettxtShinsakaiIken
     * @return txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    /*
     * settxtShinsakaiIken
     * @param txtShinsakaiIken txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken = txtShinsakaiIken;
    }

    /*
     * getlblIchijiHanteiKekkaHenkoRiyu
     * @return lblIchijiHanteiKekkaHenkoRiyu
     */
    @JsonProperty("lblIchijiHanteiKekkaHenkoRiyu")
    public Label getLblIchijiHanteiKekkaHenkoRiyu() {
        return lblIchijiHanteiKekkaHenkoRiyu;
    }

    /*
     * setlblIchijiHanteiKekkaHenkoRiyu
     * @param lblIchijiHanteiKekkaHenkoRiyu lblIchijiHanteiKekkaHenkoRiyu
     */
    @JsonProperty("lblIchijiHanteiKekkaHenkoRiyu")
    public void setLblIchijiHanteiKekkaHenkoRiyu(Label lblIchijiHanteiKekkaHenkoRiyu) {
        this.lblIchijiHanteiKekkaHenkoRiyu = lblIchijiHanteiKekkaHenkoRiyu;
    }

    /*
     * getbtnIchijiHanteiTeikeibunGuide
     * @return btnIchijiHanteiTeikeibunGuide
     */
    @JsonProperty("btnIchijiHanteiTeikeibunGuide")
    public ButtonDialog getBtnIchijiHanteiTeikeibunGuide() {
        return btnIchijiHanteiTeikeibunGuide;
    }

    /*
     * setbtnIchijiHanteiTeikeibunGuide
     * @param btnIchijiHanteiTeikeibunGuide btnIchijiHanteiTeikeibunGuide
     */
    @JsonProperty("btnIchijiHanteiTeikeibunGuide")
    public void setBtnIchijiHanteiTeikeibunGuide(ButtonDialog btnIchijiHanteiTeikeibunGuide) {
        this.btnIchijiHanteiTeikeibunGuide = btnIchijiHanteiTeikeibunGuide;
    }

    /*
     * gettxtIchijiHanteiKekkaHenkoRiyu
     * @return txtIchijiHanteiKekkaHenkoRiyu
     */
    @JsonProperty("txtIchijiHanteiKekkaHenkoRiyu")
    public TextBoxMultiLine getTxtIchijiHanteiKekkaHenkoRiyu() {
        return txtIchijiHanteiKekkaHenkoRiyu;
    }

    /*
     * settxtIchijiHanteiKekkaHenkoRiyu
     * @param txtIchijiHanteiKekkaHenkoRiyu txtIchijiHanteiKekkaHenkoRiyu
     */
    @JsonProperty("txtIchijiHanteiKekkaHenkoRiyu")
    public void setTxtIchijiHanteiKekkaHenkoRiyu(TextBoxMultiLine txtIchijiHanteiKekkaHenkoRiyu) {
        this.txtIchijiHanteiKekkaHenkoRiyu = txtIchijiHanteiKekkaHenkoRiyu;
    }

    /*
     * getbtnNinteiChosaJokyoShokai
     * @return btnNinteiChosaJokyoShokai
     */
    @JsonProperty("btnNinteiChosaJokyoShokai")
    public ButtonDialog getBtnNinteiChosaJokyoShokai() {
        return btnNinteiChosaJokyoShokai;
    }

    /*
     * setbtnNinteiChosaJokyoShokai
     * @param btnNinteiChosaJokyoShokai btnNinteiChosaJokyoShokai
     */
    @JsonProperty("btnNinteiChosaJokyoShokai")
    public void setBtnNinteiChosaJokyoShokai(ButtonDialog btnNinteiChosaJokyoShokai) {
        this.btnNinteiChosaJokyoShokai = btnNinteiChosaJokyoShokai;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * getbtnIchigoHantei
     * @return btnIchigoHantei
     */
    @JsonProperty("btnIchigoHantei")
    public ButtonDialog getBtnIchigoHantei() {
        return btnIchigoHantei;
    }

    /*
     * setbtnIchigoHantei
     * @param btnIchigoHantei btnIchigoHantei
     */
    @JsonProperty("btnIchigoHantei")
    public void setBtnIchigoHantei(ButtonDialog btnIchigoHantei) {
        this.btnIchigoHantei = btnIchigoHantei;
    }

    /*
     * gethasData
     * @return hasData
     */
    @JsonProperty("hasData")
    public RString getHasData() {
        return hasData;
    }

    /*
     * sethasData
     * @param hasData hasData
     */
    @JsonProperty("hasData")
    public void setHasData(RString hasData) {
        this.hasData = hasData;
    }

    // </editor-fold>
}
