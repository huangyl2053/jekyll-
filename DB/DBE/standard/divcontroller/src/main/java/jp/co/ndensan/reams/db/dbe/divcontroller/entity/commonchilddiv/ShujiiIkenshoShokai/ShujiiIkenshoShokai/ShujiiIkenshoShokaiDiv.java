package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.IChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoShokaiDiv extends Panel implements IShujiiIkenshoShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-20_05-03-35">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    private ShujiiIryokikaknAndShujiiInputDiv ShujiiIryokikaknAndShujiiInput;
    @JsonProperty("txtShogaiJiritsudo")
    private TextBox txtShogaiJiritsudo;
    @JsonProperty("txtNinchishoJiritsudo")
    private TextBox txtNinchishoJiritsudo;
    @JsonProperty("txtTankiKioku")
    private TextBox txtTankiKioku;
    @JsonProperty("txtNinchiNoryoku")
    private TextBox txtNinchiNoryoku;
    @JsonProperty("txtDentatsuNoryoku")
    private TextBox txtDentatsuNoryoku;
    @JsonProperty("txtShokujiKoi")
    private TextBox txtShokujiKoi;
    @JsonProperty("CcdChosaTokkiShiryoShokai")
    private ChosaTokkiShiryoShokaiDiv CcdChosaTokkiShiryoShokai;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("hiddenShinseishoKanriNo")
    private RString hiddenShinseishoKanriNo;
    @JsonProperty("hiddenIkenshoIraiRirekiNo")
    private RString hiddenIkenshoIraiRirekiNo;
    @JsonProperty("hdnShujiiIryoKikanCode")
    private RString hdnShujiiIryoKikanCode;
    @JsonProperty("hdnShujiiIryoKikanName")
    private RString hdnShujiiIryoKikanName;
    @JsonProperty("hdnShujiiCode")
    private RString hdnShujiiCode;
    @JsonProperty("hdnShujiiName")
    private RString hdnShujiiName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiIryokikaknAndShujiiInput
     * @return ShujiiIryokikaknAndShujiiInput
     */
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    public ShujiiIryokikaknAndShujiiInputDiv getShujiiIryokikaknAndShujiiInput() {
        return ShujiiIryokikaknAndShujiiInput;
    }

    /*
     * setShujiiIryokikaknAndShujiiInput
     * @param ShujiiIryokikaknAndShujiiInput ShujiiIryokikaknAndShujiiInput
     */
    @JsonProperty("ShujiiIryokikaknAndShujiiInput")
    public void setShujiiIryokikaknAndShujiiInput(ShujiiIryokikaknAndShujiiInputDiv ShujiiIryokikaknAndShujiiInput) {
        this.ShujiiIryokikaknAndShujiiInput = ShujiiIryokikaknAndShujiiInput;
    }

    /*
     * gettxtShogaiJiritsudo
     * @return txtShogaiJiritsudo
     */
    @JsonProperty("txtShogaiJiritsudo")
    public TextBox getTxtShogaiJiritsudo() {
        return txtShogaiJiritsudo;
    }

    /*
     * settxtShogaiJiritsudo
     * @param txtShogaiJiritsudo txtShogaiJiritsudo
     */
    @JsonProperty("txtShogaiJiritsudo")
    public void setTxtShogaiJiritsudo(TextBox txtShogaiJiritsudo) {
        this.txtShogaiJiritsudo = txtShogaiJiritsudo;
    }

    /*
     * gettxtNinchishoJiritsudo
     * @return txtNinchishoJiritsudo
     */
    @JsonProperty("txtNinchishoJiritsudo")
    public TextBox getTxtNinchishoJiritsudo() {
        return txtNinchishoJiritsudo;
    }

    /*
     * settxtNinchishoJiritsudo
     * @param txtNinchishoJiritsudo txtNinchishoJiritsudo
     */
    @JsonProperty("txtNinchishoJiritsudo")
    public void setTxtNinchishoJiritsudo(TextBox txtNinchishoJiritsudo) {
        this.txtNinchishoJiritsudo = txtNinchishoJiritsudo;
    }

    /*
     * gettxtTankiKioku
     * @return txtTankiKioku
     */
    @JsonProperty("txtTankiKioku")
    public TextBox getTxtTankiKioku() {
        return txtTankiKioku;
    }

    /*
     * settxtTankiKioku
     * @param txtTankiKioku txtTankiKioku
     */
    @JsonProperty("txtTankiKioku")
    public void setTxtTankiKioku(TextBox txtTankiKioku) {
        this.txtTankiKioku = txtTankiKioku;
    }

    /*
     * gettxtNinchiNoryoku
     * @return txtNinchiNoryoku
     */
    @JsonProperty("txtNinchiNoryoku")
    public TextBox getTxtNinchiNoryoku() {
        return txtNinchiNoryoku;
    }

    /*
     * settxtNinchiNoryoku
     * @param txtNinchiNoryoku txtNinchiNoryoku
     */
    @JsonProperty("txtNinchiNoryoku")
    public void setTxtNinchiNoryoku(TextBox txtNinchiNoryoku) {
        this.txtNinchiNoryoku = txtNinchiNoryoku;
    }

    /*
     * gettxtDentatsuNoryoku
     * @return txtDentatsuNoryoku
     */
    @JsonProperty("txtDentatsuNoryoku")
    public TextBox getTxtDentatsuNoryoku() {
        return txtDentatsuNoryoku;
    }

    /*
     * settxtDentatsuNoryoku
     * @param txtDentatsuNoryoku txtDentatsuNoryoku
     */
    @JsonProperty("txtDentatsuNoryoku")
    public void setTxtDentatsuNoryoku(TextBox txtDentatsuNoryoku) {
        this.txtDentatsuNoryoku = txtDentatsuNoryoku;
    }

    /*
     * gettxtShokujiKoi
     * @return txtShokujiKoi
     */
    @JsonProperty("txtShokujiKoi")
    public TextBox getTxtShokujiKoi() {
        return txtShokujiKoi;
    }

    /*
     * settxtShokujiKoi
     * @param txtShokujiKoi txtShokujiKoi
     */
    @JsonProperty("txtShokujiKoi")
    public void setTxtShokujiKoi(TextBox txtShokujiKoi) {
        this.txtShokujiKoi = txtShokujiKoi;
    }

    /*
     * getCcdChosaTokkiShiryoShokai
     * @return CcdChosaTokkiShiryoShokai
     */
    @JsonProperty("CcdChosaTokkiShiryoShokai")
    public IChosaTokkiShiryoShokaiDiv getCcdChosaTokkiShiryoShokai() {
        return CcdChosaTokkiShiryoShokai;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * gethiddenShinseishoKanriNo
     * @return hiddenShinseishoKanriNo
     */
    @JsonProperty("hiddenShinseishoKanriNo")
    public RString getHiddenShinseishoKanriNo() {
        return hiddenShinseishoKanriNo;
    }

    /*
     * sethiddenShinseishoKanriNo
     * @param hiddenShinseishoKanriNo hiddenShinseishoKanriNo
     */
    @JsonProperty("hiddenShinseishoKanriNo")
    public void setHiddenShinseishoKanriNo(RString hiddenShinseishoKanriNo) {
        this.hiddenShinseishoKanriNo = hiddenShinseishoKanriNo;
    }

    /*
     * gethiddenIkenshoIraiRirekiNo
     * @return hiddenIkenshoIraiRirekiNo
     */
    @JsonProperty("hiddenIkenshoIraiRirekiNo")
    public RString getHiddenIkenshoIraiRirekiNo() {
        return hiddenIkenshoIraiRirekiNo;
    }

    /*
     * sethiddenIkenshoIraiRirekiNo
     * @param hiddenIkenshoIraiRirekiNo hiddenIkenshoIraiRirekiNo
     */
    @JsonProperty("hiddenIkenshoIraiRirekiNo")
    public void setHiddenIkenshoIraiRirekiNo(RString hiddenIkenshoIraiRirekiNo) {
        this.hiddenIkenshoIraiRirekiNo = hiddenIkenshoIraiRirekiNo;
    }

    /*
     * gethdnShujiiIryoKikanCode
     * @return hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public RString getHdnShujiiIryoKikanCode() {
        return hdnShujiiIryoKikanCode;
    }

    /*
     * sethdnShujiiIryoKikanCode
     * @param hdnShujiiIryoKikanCode hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public void setHdnShujiiIryoKikanCode(RString hdnShujiiIryoKikanCode) {
        this.hdnShujiiIryoKikanCode = hdnShujiiIryoKikanCode;
    }

    /*
     * gethdnShujiiIryoKikanName
     * @return hdnShujiiIryoKikanName
     */
    @JsonProperty("hdnShujiiIryoKikanName")
    public RString getHdnShujiiIryoKikanName() {
        return hdnShujiiIryoKikanName;
    }

    /*
     * sethdnShujiiIryoKikanName
     * @param hdnShujiiIryoKikanName hdnShujiiIryoKikanName
     */
    @JsonProperty("hdnShujiiIryoKikanName")
    public void setHdnShujiiIryoKikanName(RString hdnShujiiIryoKikanName) {
        this.hdnShujiiIryoKikanName = hdnShujiiIryoKikanName;
    }

    /*
     * gethdnShujiiCode
     * @return hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public RString getHdnShujiiCode() {
        return hdnShujiiCode;
    }

    /*
     * sethdnShujiiCode
     * @param hdnShujiiCode hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public void setHdnShujiiCode(RString hdnShujiiCode) {
        this.hdnShujiiCode = hdnShujiiCode;
    }

    /*
     * gethdnShujiiName
     * @return hdnShujiiName
     */
    @JsonProperty("hdnShujiiName")
    public RString getHdnShujiiName() {
        return hdnShujiiName;
    }

    /*
     * sethdnShujiiName
     * @param hdnShujiiName hdnShujiiName
     */
    @JsonProperty("hdnShujiiName")
    public void setHdnShujiiName(RString hdnShujiiName) {
        this.hdnShujiiName = hdnShujiiName;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiIryoKikanCode(txtShujiiIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanName() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiIryoKikanName(txtShujiiIryoKikanName);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShujiiIryokikaknAndShujiiInput().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShujiiIryokikaknAndShujiiInput().setTxtShujiiName(txtShujiiName);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
