package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GogitaiShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGogitaiNumber")
    private TextBox txtGogitaiNumber;
    @JsonProperty("txtGogitaiMeisho")
    private TextBox txtGogitaiMeisho;
    @JsonProperty("ddlkaisaibasho")
    private DropDownList ddlkaisaibasho;
    @JsonProperty("txtYukoKaishiYMD")
    private TextBoxDate txtYukoKaishiYMD;
    @JsonProperty("txtYukoShuryoYMD")
    private TextBoxDate txtYukoShuryoYMD;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtJidoWariateTeiin")
    private TextBoxNum txtJidoWariateTeiin;
    @JsonProperty("txtKaishiYoteiTime")
    private TextBoxTime txtKaishiYoteiTime;
    @JsonProperty("txtShuryoYoteiTime")
    private TextBoxTime txtShuryoYoteiTime;
    @JsonProperty("txtIinTeiin")
    private TextBoxNum txtIinTeiin;
    @JsonProperty("radSeishinkaiSonzai")
    private RadioButton radSeishinkaiSonzai;
    @JsonProperty("radDummyFlag")
    private RadioButton radDummyFlag;
    @JsonProperty("spSpace")
    private Space spSpace;
    @JsonProperty("lblShinsain")
    private Label lblShinsain;
    @JsonProperty("dgShinsainList")
    private DataGrid<dgShinsainList_Row> dgShinsainList;
    @JsonProperty("btnShinsainSelect")
    private Button btnShinsainSelect;
    @JsonProperty("lblHoketsuShinsain")
    private Label lblHoketsuShinsain;
    @JsonProperty("dgHoketsuShinsainList")
    private DataGrid<dgHoketsuShinsainList_Row> dgHoketsuShinsainList;
    @JsonProperty("btnSubShinsainSelect")
    private Button btnSubShinsainSelect;
    @JsonProperty("spSpace1")
    private Space spSpace1;
    @JsonProperty("btnkosin")
    private Button btnkosin;
    @JsonProperty("btnback")
    private Button btnback;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGogitaiNumber
     * @return txtGogitaiNumber
     */
    @JsonProperty("txtGogitaiNumber")
    public TextBox getTxtGogitaiNumber() {
        return txtGogitaiNumber;
    }

    /*
     * settxtGogitaiNumber
     * @param txtGogitaiNumber txtGogitaiNumber
     */
    @JsonProperty("txtGogitaiNumber")
    public void setTxtGogitaiNumber(TextBox txtGogitaiNumber) {
        this.txtGogitaiNumber = txtGogitaiNumber;
    }

    /*
     * gettxtGogitaiMeisho
     * @return txtGogitaiMeisho
     */
    @JsonProperty("txtGogitaiMeisho")
    public TextBox getTxtGogitaiMeisho() {
        return txtGogitaiMeisho;
    }

    /*
     * settxtGogitaiMeisho
     * @param txtGogitaiMeisho txtGogitaiMeisho
     */
    @JsonProperty("txtGogitaiMeisho")
    public void setTxtGogitaiMeisho(TextBox txtGogitaiMeisho) {
        this.txtGogitaiMeisho = txtGogitaiMeisho;
    }

    /*
     * getddlkaisaibasho
     * @return ddlkaisaibasho
     */
    @JsonProperty("ddlkaisaibasho")
    public DropDownList getDdlkaisaibasho() {
        return ddlkaisaibasho;
    }

    /*
     * setddlkaisaibasho
     * @param ddlkaisaibasho ddlkaisaibasho
     */
    @JsonProperty("ddlkaisaibasho")
    public void setDdlkaisaibasho(DropDownList ddlkaisaibasho) {
        this.ddlkaisaibasho = ddlkaisaibasho;
    }

    /*
     * gettxtYukoKaishiYMD
     * @return txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public TextBoxDate getTxtYukoKaishiYMD() {
        return txtYukoKaishiYMD;
    }

    /*
     * settxtYukoKaishiYMD
     * @param txtYukoKaishiYMD txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public void setTxtYukoKaishiYMD(TextBoxDate txtYukoKaishiYMD) {
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
    }

    /*
     * gettxtYukoShuryoYMD
     * @return txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public TextBoxDate getTxtYukoShuryoYMD() {
        return txtYukoShuryoYMD;
    }

    /*
     * settxtYukoShuryoYMD
     * @param txtYukoShuryoYMD txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public void setTxtYukoShuryoYMD(TextBoxDate txtYukoShuryoYMD) {
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

    /*
     * gettxtYoteiTeiin
     * @return txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    /*
     * settxtYoteiTeiin
     * @param txtYoteiTeiin txtYoteiTeiin
     */
    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin = txtYoteiTeiin;
    }

    /*
     * gettxtJidoWariateTeiin
     * @return txtJidoWariateTeiin
     */
    @JsonProperty("txtJidoWariateTeiin")
    public TextBoxNum getTxtJidoWariateTeiin() {
        return txtJidoWariateTeiin;
    }

    /*
     * settxtJidoWariateTeiin
     * @param txtJidoWariateTeiin txtJidoWariateTeiin
     */
    @JsonProperty("txtJidoWariateTeiin")
    public void setTxtJidoWariateTeiin(TextBoxNum txtJidoWariateTeiin) {
        this.txtJidoWariateTeiin = txtJidoWariateTeiin;
    }

    /*
     * gettxtKaishiYoteiTime
     * @return txtKaishiYoteiTime
     */
    @JsonProperty("txtKaishiYoteiTime")
    public TextBoxTime getTxtKaishiYoteiTime() {
        return txtKaishiYoteiTime;
    }

    /*
     * settxtKaishiYoteiTime
     * @param txtKaishiYoteiTime txtKaishiYoteiTime
     */
    @JsonProperty("txtKaishiYoteiTime")
    public void setTxtKaishiYoteiTime(TextBoxTime txtKaishiYoteiTime) {
        this.txtKaishiYoteiTime = txtKaishiYoteiTime;
    }

    /*
     * gettxtShuryoYoteiTime
     * @return txtShuryoYoteiTime
     */
    @JsonProperty("txtShuryoYoteiTime")
    public TextBoxTime getTxtShuryoYoteiTime() {
        return txtShuryoYoteiTime;
    }

    /*
     * settxtShuryoYoteiTime
     * @param txtShuryoYoteiTime txtShuryoYoteiTime
     */
    @JsonProperty("txtShuryoYoteiTime")
    public void setTxtShuryoYoteiTime(TextBoxTime txtShuryoYoteiTime) {
        this.txtShuryoYoteiTime = txtShuryoYoteiTime;
    }

    /*
     * gettxtIinTeiin
     * @return txtIinTeiin
     */
    @JsonProperty("txtIinTeiin")
    public TextBoxNum getTxtIinTeiin() {
        return txtIinTeiin;
    }

    /*
     * settxtIinTeiin
     * @param txtIinTeiin txtIinTeiin
     */
    @JsonProperty("txtIinTeiin")
    public void setTxtIinTeiin(TextBoxNum txtIinTeiin) {
        this.txtIinTeiin = txtIinTeiin;
    }

    /*
     * getradSeishinkaiSonzai
     * @return radSeishinkaiSonzai
     */
    @JsonProperty("radSeishinkaiSonzai")
    public RadioButton getRadSeishinkaiSonzai() {
        return radSeishinkaiSonzai;
    }

    /*
     * setradSeishinkaiSonzai
     * @param radSeishinkaiSonzai radSeishinkaiSonzai
     */
    @JsonProperty("radSeishinkaiSonzai")
    public void setRadSeishinkaiSonzai(RadioButton radSeishinkaiSonzai) {
        this.radSeishinkaiSonzai = radSeishinkaiSonzai;
    }

    /*
     * getradDummyFlag
     * @return radDummyFlag
     */
    @JsonProperty("radDummyFlag")
    public RadioButton getRadDummyFlag() {
        return radDummyFlag;
    }

    /*
     * setradDummyFlag
     * @param radDummyFlag radDummyFlag
     */
    @JsonProperty("radDummyFlag")
    public void setRadDummyFlag(RadioButton radDummyFlag) {
        this.radDummyFlag = radDummyFlag;
    }

    /*
     * getspSpace
     * @return spSpace
     */
    @JsonProperty("spSpace")
    public Space getSpSpace() {
        return spSpace;
    }

    /*
     * setspSpace
     * @param spSpace spSpace
     */
    @JsonProperty("spSpace")
    public void setSpSpace(Space spSpace) {
        this.spSpace = spSpace;
    }

    /*
     * getlblShinsain
     * @return lblShinsain
     */
    @JsonProperty("lblShinsain")
    public Label getLblShinsain() {
        return lblShinsain;
    }

    /*
     * setlblShinsain
     * @param lblShinsain lblShinsain
     */
    @JsonProperty("lblShinsain")
    public void setLblShinsain(Label lblShinsain) {
        this.lblShinsain = lblShinsain;
    }

    /*
     * getdgShinsainList
     * @return dgShinsainList
     */
    @JsonProperty("dgShinsainList")
    public DataGrid<dgShinsainList_Row> getDgShinsainList() {
        return dgShinsainList;
    }

    /*
     * setdgShinsainList
     * @param dgShinsainList dgShinsainList
     */
    @JsonProperty("dgShinsainList")
    public void setDgShinsainList(DataGrid<dgShinsainList_Row> dgShinsainList) {
        this.dgShinsainList = dgShinsainList;
    }

    /*
     * getbtnShinsainSelect
     * @return btnShinsainSelect
     */
    @JsonProperty("btnShinsainSelect")
    public Button getBtnShinsainSelect() {
        return btnShinsainSelect;
    }

    /*
     * setbtnShinsainSelect
     * @param btnShinsainSelect btnShinsainSelect
     */
    @JsonProperty("btnShinsainSelect")
    public void setBtnShinsainSelect(Button btnShinsainSelect) {
        this.btnShinsainSelect = btnShinsainSelect;
    }

    /*
     * getlblHoketsuShinsain
     * @return lblHoketsuShinsain
     */
    @JsonProperty("lblHoketsuShinsain")
    public Label getLblHoketsuShinsain() {
        return lblHoketsuShinsain;
    }

    /*
     * setlblHoketsuShinsain
     * @param lblHoketsuShinsain lblHoketsuShinsain
     */
    @JsonProperty("lblHoketsuShinsain")
    public void setLblHoketsuShinsain(Label lblHoketsuShinsain) {
        this.lblHoketsuShinsain = lblHoketsuShinsain;
    }

    /*
     * getdgHoketsuShinsainList
     * @return dgHoketsuShinsainList
     */
    @JsonProperty("dgHoketsuShinsainList")
    public DataGrid<dgHoketsuShinsainList_Row> getDgHoketsuShinsainList() {
        return dgHoketsuShinsainList;
    }

    /*
     * setdgHoketsuShinsainList
     * @param dgHoketsuShinsainList dgHoketsuShinsainList
     */
    @JsonProperty("dgHoketsuShinsainList")
    public void setDgHoketsuShinsainList(DataGrid<dgHoketsuShinsainList_Row> dgHoketsuShinsainList) {
        this.dgHoketsuShinsainList = dgHoketsuShinsainList;
    }

    /*
     * getbtnSubShinsainSelect
     * @return btnSubShinsainSelect
     */
    @JsonProperty("btnSubShinsainSelect")
    public Button getBtnSubShinsainSelect() {
        return btnSubShinsainSelect;
    }

    /*
     * setbtnSubShinsainSelect
     * @param btnSubShinsainSelect btnSubShinsainSelect
     */
    @JsonProperty("btnSubShinsainSelect")
    public void setBtnSubShinsainSelect(Button btnSubShinsainSelect) {
        this.btnSubShinsainSelect = btnSubShinsainSelect;
    }

    /*
     * getspSpace1
     * @return spSpace1
     */
    @JsonProperty("spSpace1")
    public Space getSpSpace1() {
        return spSpace1;
    }

    /*
     * setspSpace1
     * @param spSpace1 spSpace1
     */
    @JsonProperty("spSpace1")
    public void setSpSpace1(Space spSpace1) {
        this.spSpace1 = spSpace1;
    }

    /*
     * getbtnkosin
     * @return btnkosin
     */
    @JsonProperty("btnkosin")
    public Button getBtnkosin() {
        return btnkosin;
    }

    /*
     * setbtnkosin
     * @param btnkosin btnkosin
     */
    @JsonProperty("btnkosin")
    public void setBtnkosin(Button btnkosin) {
        this.btnkosin = btnkosin;
    }

    /*
     * getbtnback
     * @return btnback
     */
    @JsonProperty("btnback")
    public Button getBtnback() {
        return btnback;
    }

    /*
     * setbtnback
     * @param btnback btnback
     */
    @JsonProperty("btnback")
    public void setBtnback(Button btnback) {
        this.btnback = btnback;
    }

    // </editor-fold>
}
