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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutangendogakuShonin のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuShoninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSakuseiNendo")
    private TextBoxFlexibleDate txtSakuseiNendo;
    @JsonProperty("txtChoteiKikan")
    private TextBoxDateRange txtChoteiKikan;
    @JsonProperty("txtKetteibi")
    private TextBoxFlexibleDate txtKetteibi;
    @JsonProperty("txtShinseibiJoken")
    private TextBoxDateRange txtShinseibiJoken;
    @JsonProperty("linHidukeJoken")
    private HorizontalLine linHidukeJoken;
    @JsonProperty("chkHikazeiKyakka")
    private CheckBoxList chkHikazeiKyakka;
    @JsonProperty("btnShoninShinaiRiyu1")
    private ButtonDialog btnShoninShinaiRiyu1;
    @JsonProperty("txtShoninShinaiRiyu1")
    private TextBoxMultiLine txtShoninShinaiRiyu1;
    @JsonProperty("chkHaigushaKazei")
    private CheckBoxList chkHaigushaKazei;
    @JsonProperty("btnShoninShinaiRiyu2")
    private ButtonDialog btnShoninShinaiRiyu2;
    @JsonProperty("txtShoninShinaiRiyu2")
    private TextBoxMultiLine txtShoninShinaiRiyu2;
    @JsonProperty("chkYochokinJogenOver")
    private CheckBoxList chkYochokinJogenOver;
    @JsonProperty("btnShoninShinaiRiyu3")
    private ButtonDialog btnShoninShinaiRiyu3;
    @JsonProperty("txtShoninShinaiRiyu3")
    private TextBoxMultiLine txtShoninShinaiRiyu3;
    @JsonProperty("chkTest")
    private CheckBoxList chkTest;
    @JsonProperty("ShinseiPrint")
    private ShinseiPrintDiv ShinseiPrint;
    @JsonProperty("subGyomuCode")
    private RString subGyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;
    @JsonProperty("kakuninListReportId")
    private RString kakuninListReportId;
    @JsonProperty("kakuninListDisplayType")
    private RString kakuninListDisplayType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSakuseiNendo
     * @return txtSakuseiNendo
     */
    @JsonProperty("txtSakuseiNendo")
    public TextBoxFlexibleDate getTxtSakuseiNendo() {
        return txtSakuseiNendo;
    }

    /*
     * settxtSakuseiNendo
     * @param txtSakuseiNendo txtSakuseiNendo
     */
    @JsonProperty("txtSakuseiNendo")
    public void setTxtSakuseiNendo(TextBoxFlexibleDate txtSakuseiNendo) {
        this.txtSakuseiNendo = txtSakuseiNendo;
    }

    /*
     * gettxtChoteiKikan
     * @return txtChoteiKikan
     */
    @JsonProperty("txtChoteiKikan")
    public TextBoxDateRange getTxtChoteiKikan() {
        return txtChoteiKikan;
    }

    /*
     * settxtChoteiKikan
     * @param txtChoteiKikan txtChoteiKikan
     */
    @JsonProperty("txtChoteiKikan")
    public void setTxtChoteiKikan(TextBoxDateRange txtChoteiKikan) {
        this.txtChoteiKikan = txtChoteiKikan;
    }

    /*
     * gettxtKetteibi
     * @return txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public TextBoxFlexibleDate getTxtKetteibi() {
        return txtKetteibi;
    }

    /*
     * settxtKetteibi
     * @param txtKetteibi txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public void setTxtKetteibi(TextBoxFlexibleDate txtKetteibi) {
        this.txtKetteibi = txtKetteibi;
    }

    /*
     * gettxtShinseibiJoken
     * @return txtShinseibiJoken
     */
    @JsonProperty("txtShinseibiJoken")
    public TextBoxDateRange getTxtShinseibiJoken() {
        return txtShinseibiJoken;
    }

    /*
     * settxtShinseibiJoken
     * @param txtShinseibiJoken txtShinseibiJoken
     */
    @JsonProperty("txtShinseibiJoken")
    public void setTxtShinseibiJoken(TextBoxDateRange txtShinseibiJoken) {
        this.txtShinseibiJoken = txtShinseibiJoken;
    }

    /*
     * getlinHidukeJoken
     * @return linHidukeJoken
     */
    @JsonProperty("linHidukeJoken")
    public HorizontalLine getLinHidukeJoken() {
        return linHidukeJoken;
    }

    /*
     * setlinHidukeJoken
     * @param linHidukeJoken linHidukeJoken
     */
    @JsonProperty("linHidukeJoken")
    public void setLinHidukeJoken(HorizontalLine linHidukeJoken) {
        this.linHidukeJoken = linHidukeJoken;
    }

    /*
     * getchkHikazeiKyakka
     * @return chkHikazeiKyakka
     */
    @JsonProperty("chkHikazeiKyakka")
    public CheckBoxList getChkHikazeiKyakka() {
        return chkHikazeiKyakka;
    }

    /*
     * setchkHikazeiKyakka
     * @param chkHikazeiKyakka chkHikazeiKyakka
     */
    @JsonProperty("chkHikazeiKyakka")
    public void setChkHikazeiKyakka(CheckBoxList chkHikazeiKyakka) {
        this.chkHikazeiKyakka = chkHikazeiKyakka;
    }

    /*
     * getbtnShoninShinaiRiyu1
     * @return btnShoninShinaiRiyu1
     */
    @JsonProperty("btnShoninShinaiRiyu1")
    public ButtonDialog getBtnShoninShinaiRiyu1() {
        return btnShoninShinaiRiyu1;
    }

    /*
     * setbtnShoninShinaiRiyu1
     * @param btnShoninShinaiRiyu1 btnShoninShinaiRiyu1
     */
    @JsonProperty("btnShoninShinaiRiyu1")
    public void setBtnShoninShinaiRiyu1(ButtonDialog btnShoninShinaiRiyu1) {
        this.btnShoninShinaiRiyu1 = btnShoninShinaiRiyu1;
    }

    /*
     * gettxtShoninShinaiRiyu1
     * @return txtShoninShinaiRiyu1
     */
    @JsonProperty("txtShoninShinaiRiyu1")
    public TextBoxMultiLine getTxtShoninShinaiRiyu1() {
        return txtShoninShinaiRiyu1;
    }

    /*
     * settxtShoninShinaiRiyu1
     * @param txtShoninShinaiRiyu1 txtShoninShinaiRiyu1
     */
    @JsonProperty("txtShoninShinaiRiyu1")
    public void setTxtShoninShinaiRiyu1(TextBoxMultiLine txtShoninShinaiRiyu1) {
        this.txtShoninShinaiRiyu1 = txtShoninShinaiRiyu1;
    }

    /*
     * getchkHaigushaKazei
     * @return chkHaigushaKazei
     */
    @JsonProperty("chkHaigushaKazei")
    public CheckBoxList getChkHaigushaKazei() {
        return chkHaigushaKazei;
    }

    /*
     * setchkHaigushaKazei
     * @param chkHaigushaKazei chkHaigushaKazei
     */
    @JsonProperty("chkHaigushaKazei")
    public void setChkHaigushaKazei(CheckBoxList chkHaigushaKazei) {
        this.chkHaigushaKazei = chkHaigushaKazei;
    }

    /*
     * getbtnShoninShinaiRiyu2
     * @return btnShoninShinaiRiyu2
     */
    @JsonProperty("btnShoninShinaiRiyu2")
    public ButtonDialog getBtnShoninShinaiRiyu2() {
        return btnShoninShinaiRiyu2;
    }

    /*
     * setbtnShoninShinaiRiyu2
     * @param btnShoninShinaiRiyu2 btnShoninShinaiRiyu2
     */
    @JsonProperty("btnShoninShinaiRiyu2")
    public void setBtnShoninShinaiRiyu2(ButtonDialog btnShoninShinaiRiyu2) {
        this.btnShoninShinaiRiyu2 = btnShoninShinaiRiyu2;
    }

    /*
     * gettxtShoninShinaiRiyu2
     * @return txtShoninShinaiRiyu2
     */
    @JsonProperty("txtShoninShinaiRiyu2")
    public TextBoxMultiLine getTxtShoninShinaiRiyu2() {
        return txtShoninShinaiRiyu2;
    }

    /*
     * settxtShoninShinaiRiyu2
     * @param txtShoninShinaiRiyu2 txtShoninShinaiRiyu2
     */
    @JsonProperty("txtShoninShinaiRiyu2")
    public void setTxtShoninShinaiRiyu2(TextBoxMultiLine txtShoninShinaiRiyu2) {
        this.txtShoninShinaiRiyu2 = txtShoninShinaiRiyu2;
    }

    /*
     * getchkYochokinJogenOver
     * @return chkYochokinJogenOver
     */
    @JsonProperty("chkYochokinJogenOver")
    public CheckBoxList getChkYochokinJogenOver() {
        return chkYochokinJogenOver;
    }

    /*
     * setchkYochokinJogenOver
     * @param chkYochokinJogenOver chkYochokinJogenOver
     */
    @JsonProperty("chkYochokinJogenOver")
    public void setChkYochokinJogenOver(CheckBoxList chkYochokinJogenOver) {
        this.chkYochokinJogenOver = chkYochokinJogenOver;
    }

    /*
     * getbtnShoninShinaiRiyu3
     * @return btnShoninShinaiRiyu3
     */
    @JsonProperty("btnShoninShinaiRiyu3")
    public ButtonDialog getBtnShoninShinaiRiyu3() {
        return btnShoninShinaiRiyu3;
    }

    /*
     * setbtnShoninShinaiRiyu3
     * @param btnShoninShinaiRiyu3 btnShoninShinaiRiyu3
     */
    @JsonProperty("btnShoninShinaiRiyu3")
    public void setBtnShoninShinaiRiyu3(ButtonDialog btnShoninShinaiRiyu3) {
        this.btnShoninShinaiRiyu3 = btnShoninShinaiRiyu3;
    }

    /*
     * gettxtShoninShinaiRiyu3
     * @return txtShoninShinaiRiyu3
     */
    @JsonProperty("txtShoninShinaiRiyu3")
    public TextBoxMultiLine getTxtShoninShinaiRiyu3() {
        return txtShoninShinaiRiyu3;
    }

    /*
     * settxtShoninShinaiRiyu3
     * @param txtShoninShinaiRiyu3 txtShoninShinaiRiyu3
     */
    @JsonProperty("txtShoninShinaiRiyu3")
    public void setTxtShoninShinaiRiyu3(TextBoxMultiLine txtShoninShinaiRiyu3) {
        this.txtShoninShinaiRiyu3 = txtShoninShinaiRiyu3;
    }

    /*
     * getchkTest
     * @return chkTest
     */
    @JsonProperty("chkTest")
    public CheckBoxList getChkTest() {
        return chkTest;
    }

    /*
     * setchkTest
     * @param chkTest chkTest
     */
    @JsonProperty("chkTest")
    public void setChkTest(CheckBoxList chkTest) {
        this.chkTest = chkTest;
    }

    /*
     * getShinseiPrint
     * @return ShinseiPrint
     */
    @JsonProperty("ShinseiPrint")
    public ShinseiPrintDiv getShinseiPrint() {
        return ShinseiPrint;
    }

    /*
     * setShinseiPrint
     * @param ShinseiPrint ShinseiPrint
     */
    @JsonProperty("ShinseiPrint")
    public void setShinseiPrint(ShinseiPrintDiv ShinseiPrint) {
        this.ShinseiPrint = ShinseiPrint;
    }

    /*
     * getsubGyomuCode
     * @return subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public RString getSubGyomuCode() {
        return subGyomuCode;
    }

    /*
     * setsubGyomuCode
     * @param subGyomuCode subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public void setSubGyomuCode(RString subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /*
     * getsampleBunshoGroupCode
     * @return sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public RString getSampleBunshoGroupCode() {
        return sampleBunshoGroupCode;
    }

    /*
     * setsampleBunshoGroupCode
     * @param sampleBunshoGroupCode sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public void setSampleBunshoGroupCode(RString sampleBunshoGroupCode) {
        this.sampleBunshoGroupCode = sampleBunshoGroupCode;
    }

    /*
     * getkakuninListReportId
     * @return kakuninListReportId
     */
    @JsonProperty("kakuninListReportId")
    public RString getKakuninListReportId() {
        return kakuninListReportId;
    }

    /*
     * setkakuninListReportId
     * @param kakuninListReportId kakuninListReportId
     */
    @JsonProperty("kakuninListReportId")
    public void setKakuninListReportId(RString kakuninListReportId) {
        this.kakuninListReportId = kakuninListReportId;
    }

    /*
     * getkakuninListDisplayType
     * @return kakuninListDisplayType
     */
    @JsonProperty("kakuninListDisplayType")
    public RString getKakuninListDisplayType() {
        return kakuninListDisplayType;
    }

    /*
     * setkakuninListDisplayType
     * @param kakuninListDisplayType kakuninListDisplayType
     */
    @JsonProperty("kakuninListDisplayType")
    public void setKakuninListDisplayType(RString kakuninListDisplayType) {
        this.kakuninListDisplayType = kakuninListDisplayType;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakkoYMD() {
        return this.getShinseiPrint().getTxtHakkoYMD();
    }

    @JsonIgnore
    public void  setTxtHakkoYMD(TextBoxFlexibleDate txtHakkoYMD) {
        this.getShinseiPrint().setTxtHakkoYMD(txtHakkoYMD);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShinseiPrint().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
