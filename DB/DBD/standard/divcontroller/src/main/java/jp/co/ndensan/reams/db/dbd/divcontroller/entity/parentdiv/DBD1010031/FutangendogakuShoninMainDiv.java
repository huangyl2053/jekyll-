package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * FutangendogakuShoninMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuShoninMainDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FutangendogakuShonin")
    private FutangendogakuShoninDiv FutangendogakuShonin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFutangendogakuShonin
     * @return FutangendogakuShonin
     */
    @JsonProperty("FutangendogakuShonin")
    public FutangendogakuShoninDiv getFutangendogakuShonin() {
        return FutangendogakuShonin;
    }

    /*
     * setFutangendogakuShonin
     * @param FutangendogakuShonin FutangendogakuShonin
     */
    @JsonProperty("FutangendogakuShonin")
    public void setFutangendogakuShonin(FutangendogakuShoninDiv FutangendogakuShonin) {
        this.FutangendogakuShonin = FutangendogakuShonin;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiNendo() {
        return this.getFutangendogakuShonin().getTxtSakuseiNendo();
    }

    @JsonIgnore
    public void  setTxtSakuseiNendo(TextBoxFlexibleDate txtSakuseiNendo) {
        this.getFutangendogakuShonin().setTxtSakuseiNendo(txtSakuseiNendo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChoteiKikan() {
        return this.getFutangendogakuShonin().getTxtChoteiKikan();
    }

    @JsonIgnore
    public void  setTxtChoteiKikan(TextBoxDateRange txtChoteiKikan) {
        this.getFutangendogakuShonin().setTxtChoteiKikan(txtChoteiKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteibi() {
        return this.getFutangendogakuShonin().getTxtKetteibi();
    }

    @JsonIgnore
    public void  setTxtKetteibi(TextBoxFlexibleDate txtKetteibi) {
        this.getFutangendogakuShonin().setTxtKetteibi(txtKetteibi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseibiJoken() {
        return this.getFutangendogakuShonin().getTxtShinseibiJoken();
    }

    @JsonIgnore
    public void  setTxtShinseibiJoken(TextBoxDateRange txtShinseibiJoken) {
        this.getFutangendogakuShonin().setTxtShinseibiJoken(txtShinseibiJoken);
    }

    @JsonIgnore
    public HorizontalLine getLinHidukeJoken() {
        return this.getFutangendogakuShonin().getLinHidukeJoken();
    }

    @JsonIgnore
    public void  setLinHidukeJoken(HorizontalLine linHidukeJoken) {
        this.getFutangendogakuShonin().setLinHidukeJoken(linHidukeJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkHikazeiKyakka() {
        return this.getFutangendogakuShonin().getChkHikazeiKyakka();
    }

    @JsonIgnore
    public void  setChkHikazeiKyakka(CheckBoxList chkHikazeiKyakka) {
        this.getFutangendogakuShonin().setChkHikazeiKyakka(chkHikazeiKyakka);
    }

    @JsonIgnore
    public ButtonDialog getBtnShoninShinaiRiyu1() {
        return this.getFutangendogakuShonin().getBtnShoninShinaiRiyu1();
    }

    @JsonIgnore
    public void  setBtnShoninShinaiRiyu1(ButtonDialog btnShoninShinaiRiyu1) {
        this.getFutangendogakuShonin().setBtnShoninShinaiRiyu1(btnShoninShinaiRiyu1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninShinaiRiyu1() {
        return this.getFutangendogakuShonin().getTxtShoninShinaiRiyu1();
    }

    @JsonIgnore
    public void  setTxtShoninShinaiRiyu1(TextBoxMultiLine txtShoninShinaiRiyu1) {
        this.getFutangendogakuShonin().setTxtShoninShinaiRiyu1(txtShoninShinaiRiyu1);
    }

    @JsonIgnore
    public CheckBoxList getChkHaigushaKazei() {
        return this.getFutangendogakuShonin().getChkHaigushaKazei();
    }

    @JsonIgnore
    public void  setChkHaigushaKazei(CheckBoxList chkHaigushaKazei) {
        this.getFutangendogakuShonin().setChkHaigushaKazei(chkHaigushaKazei);
    }

    @JsonIgnore
    public ButtonDialog getBtnShoninShinaiRiyu2() {
        return this.getFutangendogakuShonin().getBtnShoninShinaiRiyu2();
    }

    @JsonIgnore
    public void  setBtnShoninShinaiRiyu2(ButtonDialog btnShoninShinaiRiyu2) {
        this.getFutangendogakuShonin().setBtnShoninShinaiRiyu2(btnShoninShinaiRiyu2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninShinaiRiyu2() {
        return this.getFutangendogakuShonin().getTxtShoninShinaiRiyu2();
    }

    @JsonIgnore
    public void  setTxtShoninShinaiRiyu2(TextBoxMultiLine txtShoninShinaiRiyu2) {
        this.getFutangendogakuShonin().setTxtShoninShinaiRiyu2(txtShoninShinaiRiyu2);
    }

    @JsonIgnore
    public CheckBoxList getChkYochokinJogenOver() {
        return this.getFutangendogakuShonin().getChkYochokinJogenOver();
    }

    @JsonIgnore
    public void  setChkYochokinJogenOver(CheckBoxList chkYochokinJogenOver) {
        this.getFutangendogakuShonin().setChkYochokinJogenOver(chkYochokinJogenOver);
    }

    @JsonIgnore
    public ButtonDialog getBtnShoninShinaiRiyu3() {
        return this.getFutangendogakuShonin().getBtnShoninShinaiRiyu3();
    }

    @JsonIgnore
    public void  setBtnShoninShinaiRiyu3(ButtonDialog btnShoninShinaiRiyu3) {
        this.getFutangendogakuShonin().setBtnShoninShinaiRiyu3(btnShoninShinaiRiyu3);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShoninShinaiRiyu3() {
        return this.getFutangendogakuShonin().getTxtShoninShinaiRiyu3();
    }

    @JsonIgnore
    public void  setTxtShoninShinaiRiyu3(TextBoxMultiLine txtShoninShinaiRiyu3) {
        this.getFutangendogakuShonin().setTxtShoninShinaiRiyu3(txtShoninShinaiRiyu3);
    }

    @JsonIgnore
    public CheckBoxList getChkTest() {
        return this.getFutangendogakuShonin().getChkTest();
    }

    @JsonIgnore
    public void  setChkTest(CheckBoxList chkTest) {
        this.getFutangendogakuShonin().setChkTest(chkTest);
    }

    @JsonIgnore
    public ShinseiPrintDiv getShinseiPrint() {
        return this.getFutangendogakuShonin().getShinseiPrint();
    }

    @JsonIgnore
    public void  setShinseiPrint(ShinseiPrintDiv ShinseiPrint) {
        this.getFutangendogakuShonin().setShinseiPrint(ShinseiPrint);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoYMD() {
        return this.getFutangendogakuShonin().getShinseiPrint().getTxtHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtHakkoYMD(TextBoxFlexibleDate txtHakkoYMD) {
        this.getFutangendogakuShonin().getShinseiPrint().setTxtHakkoYMD(txtHakkoYMD);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getFutangendogakuShonin().getShinseiPrint().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
