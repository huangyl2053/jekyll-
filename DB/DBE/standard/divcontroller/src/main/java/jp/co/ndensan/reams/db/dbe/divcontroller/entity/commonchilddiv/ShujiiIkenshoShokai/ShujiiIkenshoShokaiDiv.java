package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJiritsudo")
    private TextBox txtJiritsudo;
    @JsonProperty("txtTankiKioku")
    private TextBox txtTankiKioku;
    @JsonProperty("txtNinchiNoryoku")
    private TextBox txtNinchiNoryoku;
    @JsonProperty("txtDentatsuNoryoku")
    private TextBox txtDentatsuNoryoku;
    @JsonProperty("txtShokujiKoi")
    private TextBox txtShokujiKoi;
    @JsonProperty("txtTest")
    private TextBox txtTest;
    @JsonProperty("txtTest2")
    private TextBox txtTest2;
    @JsonProperty("txtTest3")
    private TextBox txtTest3;
    @JsonProperty("CcdChosaTokkiShiryoShokai")
    private ChosaTokkiShiryoShokaiDiv CcdChosaTokkiShiryoShokai;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("hiddenShinseishoKanriNo")
    private RString hiddenShinseishoKanriNo;
    @JsonProperty("hiddenIkenshoIraiRirekiNo")
    private RString hiddenIkenshoIraiRirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJiritsudo
     * @return txtJiritsudo
     */
    @JsonProperty("txtJiritsudo")
    public TextBox getTxtJiritsudo() {
        return txtJiritsudo;
    }

    /*
     * settxtJiritsudo
     * @param txtJiritsudo txtJiritsudo
     */
    @JsonProperty("txtJiritsudo")
    public void setTxtJiritsudo(TextBox txtJiritsudo) {
        this.txtJiritsudo = txtJiritsudo;
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
     * gettxtTest
     * @return txtTest
     */
    @JsonProperty("txtTest")
    public TextBox getTxtTest() {
        return txtTest;
    }

    /*
     * settxtTest
     * @param txtTest txtTest
     */
    @JsonProperty("txtTest")
    public void setTxtTest(TextBox txtTest) {
        this.txtTest = txtTest;
    }

    /*
     * gettxtTest2
     * @return txtTest2
     */
    @JsonProperty("txtTest2")
    public TextBox getTxtTest2() {
        return txtTest2;
    }

    /*
     * settxtTest2
     * @param txtTest2 txtTest2
     */
    @JsonProperty("txtTest2")
    public void setTxtTest2(TextBox txtTest2) {
        this.txtTest2 = txtTest2;
    }

    /*
     * gettxtTest3
     * @return txtTest3
     */
    @JsonProperty("txtTest3")
    public TextBox getTxtTest3() {
        return txtTest3;
    }

    /*
     * settxtTest3
     * @param txtTest3 txtTest3
     */
    @JsonProperty("txtTest3")
    public void setTxtTest3(TextBox txtTest3) {
        this.txtTest3 = txtTest3;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
