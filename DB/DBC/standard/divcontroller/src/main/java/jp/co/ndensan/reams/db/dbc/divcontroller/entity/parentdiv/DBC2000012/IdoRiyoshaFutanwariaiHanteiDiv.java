package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * IdoRiyoshaFutanwariaiHantei のクラスファイル
 *
 * @reamsid_L DBC-4950-010 liuxiaoyu
 */
public class IdoRiyoshaFutanwariaiHanteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("txtNenjiShoriDate")
    private TextBoxDate txtNenjiShoriDate;
    @JsonProperty("txtNenjiShoriTime")
    private TextBoxTime txtNenjiShoriTime;
    @JsonProperty("PanelIdoTaishoKikan")
    private PanelIdoTaishoKikanDiv PanelIdoTaishoKikan;
    @JsonProperty("chkTest")
    private CheckBoxList chkTest;
    @JsonProperty("PanelNote")
    private PanelNoteDiv PanelNote;
    @JsonProperty("tblNote")
    private TablePanel tblNote;
    @JsonProperty("ErrorFlag")
    private RString ErrorFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * gettxtNenjiShoriDate
     * @return txtNenjiShoriDate
     */
    @JsonProperty("txtNenjiShoriDate")
    public TextBoxDate getTxtNenjiShoriDate() {
        return txtNenjiShoriDate;
    }

    /*
     * settxtNenjiShoriDate
     * @param txtNenjiShoriDate txtNenjiShoriDate
     */
    @JsonProperty("txtNenjiShoriDate")
    public void setTxtNenjiShoriDate(TextBoxDate txtNenjiShoriDate) {
        this.txtNenjiShoriDate = txtNenjiShoriDate;
    }

    /*
     * gettxtNenjiShoriTime
     * @return txtNenjiShoriTime
     */
    @JsonProperty("txtNenjiShoriTime")
    public TextBoxTime getTxtNenjiShoriTime() {
        return txtNenjiShoriTime;
    }

    /*
     * settxtNenjiShoriTime
     * @param txtNenjiShoriTime txtNenjiShoriTime
     */
    @JsonProperty("txtNenjiShoriTime")
    public void setTxtNenjiShoriTime(TextBoxTime txtNenjiShoriTime) {
        this.txtNenjiShoriTime = txtNenjiShoriTime;
    }

    /*
     * getPanelIdoTaishoKikan
     * @return PanelIdoTaishoKikan
     */
    @JsonProperty("PanelIdoTaishoKikan")
    public PanelIdoTaishoKikanDiv getPanelIdoTaishoKikan() {
        return PanelIdoTaishoKikan;
    }

    /*
     * setPanelIdoTaishoKikan
     * @param PanelIdoTaishoKikan PanelIdoTaishoKikan
     */
    @JsonProperty("PanelIdoTaishoKikan")
    public void setPanelIdoTaishoKikan(PanelIdoTaishoKikanDiv PanelIdoTaishoKikan) {
        this.PanelIdoTaishoKikan = PanelIdoTaishoKikan;
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
     * getPanelNote
     * @return PanelNote
     */
    @JsonProperty("PanelNote")
    public PanelNoteDiv getPanelNote() {
        return PanelNote;
    }

    /*
     * setPanelNote
     * @param PanelNote PanelNote
     */
    @JsonProperty("PanelNote")
    public void setPanelNote(PanelNoteDiv PanelNote) {
        this.PanelNote = PanelNote;
    }

    /*
     * gettblNote
     * @return tblNote
     */
    @JsonProperty("tblNote")
    public TablePanel getTblNote() {
        return tblNote;
    }

    /*
     * settblNote
     * @param tblNote tblNote
     */
    @JsonProperty("tblNote")
    public void setTblNote(TablePanel tblNote) {
        this.tblNote = tblNote;
    }

    /*
     * getErrorFlag
     * @return ErrorFlag
     */
    @JsonProperty("ErrorFlag")
    public RString getErrorFlag() {
        return ErrorFlag;
    }

    /*
     * setErrorFlag
     * @param ErrorFlag ErrorFlag
     */
    @JsonProperty("ErrorFlag")
    public void setErrorFlag(RString ErrorFlag) {
        this.ErrorFlag = ErrorFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKaishiDate() {
        return this.getPanelIdoTaishoKikan().getLblKaishiDate();
    }

    @JsonIgnore
    public void setLblKaishiDate(Label lblKaishiDate) {
        this.getPanelIdoTaishoKikan().setLblKaishiDate(lblKaishiDate);
    }

    @JsonIgnore
    public Label getLblKaishiTime() {
        return this.getPanelIdoTaishoKikan().getLblKaishiTime();
    }

    @JsonIgnore
    public void setLblKaishiTime(Label lblKaishiTime) {
        this.getPanelIdoTaishoKikan().setLblKaishiTime(lblKaishiTime);
    }

    @JsonIgnore
    public Label getLblShuryoDate() {
        return this.getPanelIdoTaishoKikan().getLblShuryoDate();
    }

    @JsonIgnore
    public void setLblShuryoDate(Label lblShuryoDate) {
        this.getPanelIdoTaishoKikan().setLblShuryoDate(lblShuryoDate);
    }

    @JsonIgnore
    public Label getLblShuryoTime() {
        return this.getPanelIdoTaishoKikan().getLblShuryoTime();
    }

    @JsonIgnore
    public void setLblShuryoTime(Label lblShuryoTime) {
        this.getPanelIdoTaishoKikan().setLblShuryoTime(lblShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiKaishiDate() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiKaishiDate();
    }

    @JsonIgnore
    public void setTxtZenkaiKaishiDate(TextBoxDate txtZenkaiKaishiDate) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiKaishiDate(txtZenkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiKaishiTime() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiKaishiTime();
    }

    @JsonIgnore
    public void setTxtZenkaiKaishiTime(TextBoxTime txtZenkaiKaishiTime) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiKaishiTime(txtZenkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen1() {
        return this.getPanelIdoTaishoKikan().getLblNamisen1();
    }

    @JsonIgnore
    public void setLblNamisen1(Label lblNamisen1) {
        this.getPanelIdoTaishoKikan().setLblNamisen1(lblNamisen1);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiShuryoDate() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiShuryoDate();
    }

    @JsonIgnore
    public void setTxtZenkaiShuryoDate(TextBoxDate txtZenkaiShuryoDate) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiShuryoDate(txtZenkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtZenkaiShuryoTime() {
        return this.getPanelIdoTaishoKikan().getTxtZenkaiShuryoTime();
    }

    @JsonIgnore
    public void setTxtZenkaiShuryoTime(TextBoxTime txtZenkaiShuryoTime) {
        this.getPanelIdoTaishoKikan().setTxtZenkaiShuryoTime(txtZenkaiShuryoTime);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiKaishiDate() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiKaishiDate();
    }

    @JsonIgnore
    public void setTxtKonkaiKaishiDate(TextBoxDate txtKonkaiKaishiDate) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiKaishiDate(txtKonkaiKaishiDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiKaishiTime() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiKaishiTime();
    }

    @JsonIgnore
    public void setTxtKonkaiKaishiTime(TextBoxTime txtKonkaiKaishiTime) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiKaishiTime(txtKonkaiKaishiTime);
    }

    @JsonIgnore
    public Label getLblNamisen2() {
        return this.getPanelIdoTaishoKikan().getLblNamisen2();
    }

    @JsonIgnore
    public void setLblNamisen2(Label lblNamisen2) {
        this.getPanelIdoTaishoKikan().setLblNamisen2(lblNamisen2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKonkaiShuryoDate() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiShuryoDate();
    }

    @JsonIgnore
    public void setTxtKonkaiShuryoDate(TextBoxDate txtKonkaiShuryoDate) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiShuryoDate(txtKonkaiShuryoDate);
    }

    @JsonIgnore
    public TextBoxTime getTxtKonkaiShuryoTime() {
        return this.getPanelIdoTaishoKikan().getTxtKonkaiShuryoTime();
    }

    @JsonIgnore
    public void setTxtKonkaiShuryoTime(TextBoxTime txtKonkaiShuryoTime) {
        this.getPanelIdoTaishoKikan().setTxtKonkaiShuryoTime(txtKonkaiShuryoTime);
    }

    @JsonIgnore
    public Label getLblNote1() {
        return this.getPanelNote().getLblNote1();
    }

    @JsonIgnore
    public void setLblNote1(Label lblNote1) {
        this.getPanelNote().setLblNote1(lblNote1);
    }

    @JsonIgnore
    public Label getLblNote2() {
        return this.getPanelNote().getLblNote2();
    }

    @JsonIgnore
    public void setLblNote2(Label lblNote2) {
        this.getPanelNote().setLblNote2(lblNote2);
    }

    @JsonIgnore
    public Label getLblNote3() {
        return this.getPanelNote().getLblNote3();
    }

    @JsonIgnore
    public void setLblNote3(Label lblNote3) {
        this.getPanelNote().setLblNote3(lblNote3);
    }

    @JsonIgnore
    public Label getLblNote4() {
        return this.getPanelNote().getLblNote4();
    }

    @JsonIgnore
    public void setLblNote4(Label lblNote4) {
        this.getPanelNote().setLblNote4(lblNote4);
    }

    @JsonIgnore
    public Label getLblNote5() {
        return this.getPanelNote().getLblNote5();
    }

    @JsonIgnore
    public void setLblNote5(Label lblNote5) {
        this.getPanelNote().setLblNote5(lblNote5);
    }

    // </editor-fold>
}
