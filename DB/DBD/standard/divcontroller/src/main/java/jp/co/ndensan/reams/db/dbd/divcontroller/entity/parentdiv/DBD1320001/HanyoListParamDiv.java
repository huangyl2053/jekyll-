package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HanyoListParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozon")
    private JokenFukugenHozonDiv JokenFukugenHozon;
    @JsonProperty("txtHyodaiMeisho")
    private TextBox txtHyodaiMeisho;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("CsvHenshuHoho")
    private CsvHenshuHohoDiv CsvHenshuHoho;
    @JsonProperty("ccdShutsuryokuKomoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKomoku;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;
    @JsonProperty("ccdHanyoListAtenaSelect")
    private HanyoListAtenaSelectDiv ccdHanyoListAtenaSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJokenFukugenHozon
     * @return JokenFukugenHozon
     */
    @JsonProperty("JokenFukugenHozon")
    public JokenFukugenHozonDiv getJokenFukugenHozon() {
        return JokenFukugenHozon;
    }

    /*
     * setJokenFukugenHozon
     * @param JokenFukugenHozon JokenFukugenHozon
     */
    @JsonProperty("JokenFukugenHozon")
    public void setJokenFukugenHozon(JokenFukugenHozonDiv JokenFukugenHozon) {
        this.JokenFukugenHozon = JokenFukugenHozon;
    }

    /*
     * gettxtHyodaiMeisho
     * @return txtHyodaiMeisho
     */
    @JsonProperty("txtHyodaiMeisho")
    public TextBox getTxtHyodaiMeisho() {
        return txtHyodaiMeisho;
    }

    /*
     * settxtHyodaiMeisho
     * @param txtHyodaiMeisho txtHyodaiMeisho
     */
    @JsonProperty("txtHyodaiMeisho")
    public void setTxtHyodaiMeisho(TextBox txtHyodaiMeisho) {
        this.txtHyodaiMeisho = txtHyodaiMeisho;
    }

    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getCsvHenshuHoho
     * @return CsvHenshuHoho
     */
    @JsonProperty("CsvHenshuHoho")
    public CsvHenshuHohoDiv getCsvHenshuHoho() {
        return CsvHenshuHoho;
    }

    /*
     * setCsvHenshuHoho
     * @param CsvHenshuHoho CsvHenshuHoho
     */
    @JsonProperty("CsvHenshuHoho")
    public void setCsvHenshuHoho(CsvHenshuHohoDiv CsvHenshuHoho) {
        this.CsvHenshuHoho = CsvHenshuHoho;
    }

    /*
     * getccdShutsuryokuKomoku
     * @return ccdShutsuryokuKomoku
     */
    @JsonProperty("ccdShutsuryokuKomoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKomoku() {
        return ccdShutsuryokuKomoku;
    }

    /*
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * getccdHanyoListAtenaSelect
     * @return ccdHanyoListAtenaSelect
     */
    @JsonProperty("ccdHanyoListAtenaSelect")
    public IHanyoListAtenaSelectDiv getCcdHanyoListAtenaSelect() {
        return ccdHanyoListAtenaSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnParamSave() {
        return this.getJokenFukugenHozon().getBtnParamSave();
    }

    @JsonIgnore
    public void  setBtnParamSave(ButtonBatchParameterSave btnParamSave) {
        this.getJokenFukugenHozon().setBtnParamSave(btnParamSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnParamRestore() {
        return this.getJokenFukugenHozon().getBtnParamRestore();
    }

    @JsonIgnore
    public void  setBtnParamRestore(ButtonBatchParameterRestore btnParamRestore) {
        this.getJokenFukugenHozon().setBtnParamRestore(btnParamRestore);
    }

    @JsonIgnore
    public ChushutsuJokenADiv getChushutsuJokenA() {
        return this.getChushutsuJoken().getChushutsuJokenA();
    }

    @JsonIgnore
    public void  setChushutsuJokenA(ChushutsuJokenADiv ChushutsuJokenA) {
        this.getChushutsuJoken().setChushutsuJokenA(ChushutsuJokenA);
    }

    @JsonIgnore
    public RadioButtonADiv getRadioButtonA() {
        return this.getChushutsuJoken().getChushutsuJokenA().getRadioButtonA();
    }

    @JsonIgnore
    public void  setRadioButtonA(RadioButtonADiv RadioButtonA) {
        this.getChushutsuJoken().getChushutsuJokenA().setRadioButtonA(RadioButtonA);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenA1() {
        return this.getChushutsuJoken().getChushutsuJokenA().getRadioButtonA().getRadChushutsuJokenA1();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenA1(RadioButton radChushutsuJokenA1) {
        this.getChushutsuJoken().getChushutsuJokenA().getRadioButtonA().setRadChushutsuJokenA1(radChushutsuJokenA1);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenA2() {
        return this.getChushutsuJoken().getChushutsuJokenA().getRadioButtonA().getRadChushutsuJokenA2();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenA2(RadioButton radChushutsuJokenA2) {
        this.getChushutsuJoken().getChushutsuJokenA().getRadioButtonA().setRadChushutsuJokenA2(radChushutsuJokenA2);
    }

    @JsonIgnore
    public ChushutsuShosaiADiv getChushutsuShosaiA() {
        return this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA();
    }

    @JsonIgnore
    public void  setChushutsuShosaiA(ChushutsuShosaiADiv ChushutsuShosaiA) {
        this.getChushutsuJoken().getChushutsuJokenA().setChushutsuShosaiA(ChushutsuShosaiA);
    }

    @JsonIgnore
    public DropDownList getDdlKijunNendo() {
        return this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().getDdlKijunNendo();
    }

    @JsonIgnore
    public void  setDdlKijunNendo(DropDownList ddlKijunNendo) {
        this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().setDdlKijunNendo(ddlKijunNendo);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomiA() {
        return this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().getChkChokkinNomiA();
    }

    @JsonIgnore
    public void  setChkChokkinNomiA(CheckBoxList chkChokkinNomiA) {
        this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().setChkChokkinNomiA(chkChokkinNomiA);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDateA() {
        return this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().getTxtKijunDateA();
    }

    @JsonIgnore
    public void  setTxtKijunDateA(TextBoxDate txtKijunDateA) {
        this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().setTxtKijunDateA(txtKijunDateA);
    }

    @JsonIgnore
    public Label getLblKijyunDateSetumeiA() {
        return this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().getLblKijyunDateSetumeiA();
    }

    @JsonIgnore
    public void  setLblKijyunDateSetumeiA(Label lblKijyunDateSetumeiA) {
        this.getChushutsuJoken().getChushutsuJokenA().getChushutsuShosaiA().setLblKijyunDateSetumeiA(lblKijyunDateSetumeiA);
    }

    @JsonIgnore
    public ChushutsuJokenBDiv getChushutsuJokenB() {
        return this.getChushutsuJoken().getChushutsuJokenB();
    }

    @JsonIgnore
    public void  setChushutsuJokenB(ChushutsuJokenBDiv ChushutsuJokenB) {
        this.getChushutsuJoken().setChushutsuJokenB(ChushutsuJokenB);
    }

    @JsonIgnore
    public RadioButtonBDiv getRadioButtonB() {
        return this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB();
    }

    @JsonIgnore
    public void  setRadioButtonB(RadioButtonBDiv RadioButtonB) {
        this.getChushutsuJoken().getChushutsuJokenB().setRadioButtonB(RadioButtonB);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenB1() {
        return this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().getRadChushutsuJokenB1();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenB1(RadioButton radChushutsuJokenB1) {
        this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().setRadChushutsuJokenB1(radChushutsuJokenB1);
    }

    @JsonIgnore
    public Label getLblSpace() {
        return this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().getLblSpace();
    }

    @JsonIgnore
    public void  setLblSpace(Label lblSpace) {
        this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().setLblSpace(lblSpace);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenB2() {
        return this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().getRadChushutsuJokenB2();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenB2(RadioButton radChushutsuJokenB2) {
        this.getChushutsuJoken().getChushutsuJokenB().getRadioButtonB().setRadChushutsuJokenB2(radChushutsuJokenB2);
    }

    @JsonIgnore
    public ChushutsuShosaiB10Div getChushutsuShosaiB10() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB10(ChushutsuShosaiB10Div ChushutsuShosaiB10) {
        this.getChushutsuJoken().getChushutsuJokenB().setChushutsuShosaiB10(ChushutsuShosaiB10);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDateB() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getTxtKijunDateB();
    }

    @JsonIgnore
    public void  setTxtKijunDateB(TextBoxDate txtKijunDateB) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().setTxtKijunDateB(txtKijunDateB);
    }

    @JsonIgnore
    public Label getLblJitenTaishoshaB() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getLblJitenTaishoshaB();
    }

    @JsonIgnore
    public void  setLblJitenTaishoshaB(Label lblJitenTaishoshaB) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().setLblJitenTaishoshaB(lblJitenTaishoshaB);
    }

    @JsonIgnore
    public ChushutsuShosaiB20Div getChushutsuShosaiB20() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB20(ChushutsuShosaiB20Div ChushutsuShosaiB20) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().setChushutsuShosaiB20(ChushutsuShosaiB20);
    }

    @JsonIgnore
    public ChushutsuShosaiB21Div getChushutsuShosaiB21() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB21(ChushutsuShosaiB21Div ChushutsuShosaiB21) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB21(ChushutsuShosaiB21);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken1() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21().getRadHaniJoken1();
    }

    @JsonIgnore
    public void  setRadHaniJoken1(RadioButton radHaniJoken1) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB21().setRadHaniJoken1(radHaniJoken1);
    }

    @JsonIgnore
    public ChushutsuShosaiB22Div getChushutsuShosaiB22() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB22(ChushutsuShosaiB22Div ChushutsuShosaiB22) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB22(ChushutsuShosaiB22);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken2() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().getRadHaniJoken2();
    }

    @JsonIgnore
    public void  setRadHaniJoken2(RadioButton radHaniJoken2) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().setRadHaniJoken2(radHaniJoken2);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseishaNomi() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().getChkShinseishaNomi();
    }

    @JsonIgnore
    public void  setChkShinseishaNomi(CheckBoxList chkShinseishaNomi) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB22().setChkShinseishaNomi(chkShinseishaNomi);
    }

    @JsonIgnore
    public ChushutsuShosaiB23Div getChushutsuShosaiB23() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB23(ChushutsuShosaiB23Div ChushutsuShosaiB23) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB23(ChushutsuShosaiB23);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken3() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23().getRadHaniJoken3();
    }

    @JsonIgnore
    public void  setRadHaniJoken3(RadioButton radHaniJoken3) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB23().setRadHaniJoken3(radHaniJoken3);
    }

    @JsonIgnore
    public ChushutsuShosaiB24Div getChushutsuShosaiB24() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB24(ChushutsuShosaiB24Div ChushutsuShosaiB24) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB24(ChushutsuShosaiB24);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken4() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24().getRadHaniJoken4();
    }

    @JsonIgnore
    public void  setRadHaniJoken4(RadioButton radHaniJoken4) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB24().setRadHaniJoken4(radHaniJoken4);
    }

    @JsonIgnore
    public ChushutsuShosaiB25Div getChushutsuShosaiB25() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25();
    }

    @JsonIgnore
    public void  setChushutsuShosaiB25(ChushutsuShosaiB25Div ChushutsuShosaiB25) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().setChushutsuShosaiB25(ChushutsuShosaiB25);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomi2() {
        return this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().getChkChokkinNomi2();
    }

    @JsonIgnore
    public void  setChkChokkinNomi2(CheckBoxList chkChokkinNomi2) {
        this.getChushutsuJoken().getChushutsuJokenB().getChushutsuShosaiB10().getChushutsuShosaiB20().getChushutsuShosaiB25().setChkChokkinNomi2(chkChokkinNomi2);
    }

    @JsonIgnore
    public ChushutsuJokenC1Div getChushutsuJokenC1() {
        return this.getChushutsuJoken().getChushutsuJokenC1();
    }

    @JsonIgnore
    public void  setChushutsuJokenC1(ChushutsuJokenC1Div ChushutsuJokenC1) {
        this.getChushutsuJoken().setChushutsuJokenC1(ChushutsuJokenC1);
    }

    @JsonIgnore
    public RadioButton getRadChusyutuKubun() {
        return this.getChushutsuJoken().getChushutsuJokenC1().getRadChusyutuKubun();
    }

    @JsonIgnore
    public void  setRadChusyutuKubun(RadioButton radChusyutuKubun) {
        this.getChushutsuJoken().getChushutsuJokenC1().setRadChusyutuKubun(radChusyutuKubun);
    }

    @JsonIgnore
    public ChushutsuJokenC2Div getChushutsuJokenC2() {
        return this.getChushutsuJoken().getChushutsuJokenC2();
    }

    @JsonIgnore
    public void  setChushutsuJokenC2(ChushutsuJokenC2Div ChushutsuJokenC2) {
        this.getChushutsuJoken().setChushutsuJokenC2(ChushutsuJokenC2);
    }

    @JsonIgnore
    public CheckBoxList getChkFutanWariaiKubun() {
        return this.getChushutsuJoken().getChushutsuJokenC2().getChkFutanWariaiKubun();
    }

    @JsonIgnore
    public void  setChkFutanWariaiKubun(CheckBoxList chkFutanWariaiKubun) {
        this.getChushutsuJoken().getChushutsuJokenC2().setChkFutanWariaiKubun(chkFutanWariaiKubun);
    }

    @JsonIgnore
    public ChushutsuJokenC3Div getChushutsuJokenC3() {
        return this.getChushutsuJoken().getChushutsuJokenC3();
    }

    @JsonIgnore
    public void  setChushutsuJokenC3(ChushutsuJokenC3Div ChushutsuJokenC3) {
        this.getChushutsuJoken().setChushutsuJokenC3(ChushutsuJokenC3);
    }

    @JsonIgnore
    public CheckBoxList getChkKyuSochisha() {
        return this.getChushutsuJoken().getChushutsuJokenC3().getChkKyuSochisha();
    }

    @JsonIgnore
    public void  setChkKyuSochisha(CheckBoxList chkKyuSochisha) {
        this.getChushutsuJoken().getChushutsuJokenC3().setChkKyuSochisha(chkKyuSochisha);
    }

    @JsonIgnore
    public ChushutsuJokenC4Div getChushutsuJokenC4() {
        return this.getChushutsuJoken().getChushutsuJokenC4();
    }

    @JsonIgnore
    public void  setChushutsuJokenC4(ChushutsuJokenC4Div ChushutsuJokenC4) {
        this.getChushutsuJoken().setChushutsuJokenC4(ChushutsuJokenC4);
    }

    @JsonIgnore
    public CheckBoxList getChkRiyousyaFutanDankai() {
        return this.getChushutsuJoken().getChushutsuJokenC4().getChkRiyousyaFutanDankai();
    }

    @JsonIgnore
    public void  setChkRiyousyaFutanDankai(CheckBoxList chkRiyousyaFutanDankai) {
        this.getChushutsuJoken().getChushutsuJokenC4().setChkRiyousyaFutanDankai(chkRiyousyaFutanDankai);
    }

    @JsonIgnore
    public ChushutsuJokenC5Div getChushutsuJokenC5() {
        return this.getChushutsuJoken().getChushutsuJokenC5();
    }

    @JsonIgnore
    public void  setChushutsuJokenC5(ChushutsuJokenC5Div ChushutsuJokenC5) {
        this.getChushutsuJoken().setChushutsuJokenC5(ChushutsuJokenC5);
    }

    @JsonIgnore
    public DropDownList getDdlKyuSochisya() {
        return this.getChushutsuJoken().getChushutsuJokenC5().getDdlKyuSochisya();
    }

    @JsonIgnore
    public void  setDdlKyuSochisya(DropDownList ddlKyuSochisya) {
        this.getChushutsuJoken().getChushutsuJokenC5().setDdlKyuSochisya(ddlKyuSochisya);
    }

    @JsonIgnore
    public DropDownList getDdlHoubetsuKubun() {
        return this.getChushutsuJoken().getChushutsuJokenC5().getDdlHoubetsuKubun();
    }

    @JsonIgnore
    public void  setDdlHoubetsuKubun(DropDownList ddlHoubetsuKubun) {
        this.getChushutsuJoken().getChushutsuJokenC5().setDdlHoubetsuKubun(ddlHoubetsuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlKyakkasha() {
        return this.getChushutsuJoken().getChushutsuJokenC5().getDdlKyakkasha();
    }

    @JsonIgnore
    public void  setDdlKyakkasha(DropDownList ddlKyakkasha) {
        this.getChushutsuJoken().getChushutsuJokenC5().setDdlKyakkasha(ddlKyakkasha);
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuKubun() {
        return this.getChushutsuJoken().getChushutsuJokenC5().getDdlSoshitsuKubun();
    }

    @JsonIgnore
    public void  setDdlSoshitsuKubun(DropDownList ddlSoshitsuKubun) {
        this.getChushutsuJoken().getChushutsuJokenC5().setDdlSoshitsuKubun(ddlSoshitsuKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
