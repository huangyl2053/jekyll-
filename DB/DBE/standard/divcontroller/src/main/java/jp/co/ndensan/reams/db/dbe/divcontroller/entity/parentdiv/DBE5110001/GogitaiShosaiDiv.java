package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GogitaiShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class GogitaiShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("txtYukoKaishiYMD")
    private TextBoxDate txtYukoKaishiYMD;
    @JsonProperty("txtYukoShuryoYMD")
    private TextBoxDate txtYukoShuryoYMD;
    @JsonProperty("txtKaishiYoteiTime")
    private TextBoxTime txtKaishiYoteiTime;
    @JsonProperty("txtShuryoYoteiTime")
    private TextBoxTime txtShuryoYoteiTime;
    @JsonProperty("ddlkaisaibasho")
    private DropDownList ddlkaisaibasho;
    @JsonProperty("txtIinTeiin")
    private TextBoxNum txtIinTeiin;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("txtJidoWariateTeiin")
    private TextBoxNum txtJidoWariateTeiin;
    @JsonProperty("radSeishinkaiSonzai")
    private RadioButton radSeishinkaiSonzai;
    @JsonProperty("radDummyFlag")
    private RadioButton radDummyFlag;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("GogitaiShinsakaiIinSentaku")
    private GogitaiShinsakaiIinSentakuDiv GogitaiShinsakaiIinSentaku;
    @JsonProperty("dgShinsainList")
    private DataGrid<dgShinsainList_Row> dgShinsainList;
    @JsonProperty("GogitaiVerticalLine1")
    private GogitaiVerticalLine1Div GogitaiVerticalLine1;
    @JsonProperty("GogitaiHoketsuIinSentaku")
    private GogitaiHoketsuIinSentakuDiv GogitaiHoketsuIinSentaku;
    @JsonProperty("dgHoketsuShinsainList")
    private DataGrid<dgHoketsuShinsainList_Row> dgHoketsuShinsainList;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("btnKosin")
    private Button btnKosin;
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
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getGogitaiShinsakaiIinSentaku
     * @return GogitaiShinsakaiIinSentaku
     */
    @JsonProperty("GogitaiShinsakaiIinSentaku")
    public GogitaiShinsakaiIinSentakuDiv getGogitaiShinsakaiIinSentaku() {
        return GogitaiShinsakaiIinSentaku;
    }

    /*
     * setGogitaiShinsakaiIinSentaku
     * @param GogitaiShinsakaiIinSentaku GogitaiShinsakaiIinSentaku
     */
    @JsonProperty("GogitaiShinsakaiIinSentaku")
    public void setGogitaiShinsakaiIinSentaku(GogitaiShinsakaiIinSentakuDiv GogitaiShinsakaiIinSentaku) {
        this.GogitaiShinsakaiIinSentaku = GogitaiShinsakaiIinSentaku;
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
     * getGogitaiVerticalLine1
     * @return GogitaiVerticalLine1
     */
    @JsonProperty("GogitaiVerticalLine1")
    public GogitaiVerticalLine1Div getGogitaiVerticalLine1() {
        return GogitaiVerticalLine1;
    }

    /*
     * setGogitaiVerticalLine1
     * @param GogitaiVerticalLine1 GogitaiVerticalLine1
     */
    @JsonProperty("GogitaiVerticalLine1")
    public void setGogitaiVerticalLine1(GogitaiVerticalLine1Div GogitaiVerticalLine1) {
        this.GogitaiVerticalLine1 = GogitaiVerticalLine1;
    }

    /*
     * getGogitaiHoketsuIinSentaku
     * @return GogitaiHoketsuIinSentaku
     */
    @JsonProperty("GogitaiHoketsuIinSentaku")
    public GogitaiHoketsuIinSentakuDiv getGogitaiHoketsuIinSentaku() {
        return GogitaiHoketsuIinSentaku;
    }

    /*
     * setGogitaiHoketsuIinSentaku
     * @param GogitaiHoketsuIinSentaku GogitaiHoketsuIinSentaku
     */
    @JsonProperty("GogitaiHoketsuIinSentaku")
    public void setGogitaiHoketsuIinSentaku(GogitaiHoketsuIinSentakuDiv GogitaiHoketsuIinSentaku) {
        this.GogitaiHoketsuIinSentaku = GogitaiHoketsuIinSentaku;
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
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getbtnKosin
     * @return btnKosin
     */
    @JsonProperty("btnKosin")
    public Button getBtnKosin() {
        return btnKosin;
    }

    /*
     * setbtnKosin
     * @param btnKosin btnKosin
     */
    @JsonProperty("btnKosin")
    public void setBtnKosin(Button btnKosin) {
        this.btnKosin = btnKosin;
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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShinsain() {
        return this.getGogitaiShinsakaiIinSentaku().getLblShinsain();
    }

    @JsonIgnore
    public void  setLblShinsain(Label lblShinsain) {
        this.getGogitaiShinsakaiIinSentaku().setLblShinsain(lblShinsain);
    }

    @JsonIgnore
    public ButtonDialog getBtnShinsainSelect() {
        return this.getGogitaiShinsakaiIinSentaku().getBtnShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnShinsainSelect(ButtonDialog btnShinsainSelect) {
        this.getGogitaiShinsakaiIinSentaku().setBtnShinsainSelect(btnShinsainSelect);
    }

    @JsonIgnore
    public VerticalLine getLin2() {
        return this.getGogitaiVerticalLine1().getLin2();
    }

    @JsonIgnore
    public void  setLin2(VerticalLine lin2) {
        this.getGogitaiVerticalLine1().setLin2(lin2);
    }

    @JsonIgnore
    public Label getLblHoketsuShinsain() {
        return this.getGogitaiHoketsuIinSentaku().getLblHoketsuShinsain();
    }

    @JsonIgnore
    public void  setLblHoketsuShinsain(Label lblHoketsuShinsain) {
        this.getGogitaiHoketsuIinSentaku().setLblHoketsuShinsain(lblHoketsuShinsain);
    }

    @JsonIgnore
    public ButtonDialog getBtnSubShinsainSelect() {
        return this.getGogitaiHoketsuIinSentaku().getBtnSubShinsainSelect();
    }

    @JsonIgnore
    public void  setBtnSubShinsainSelect(ButtonDialog btnSubShinsainSelect) {
        this.getGogitaiHoketsuIinSentaku().setBtnSubShinsainSelect(btnSubShinsainSelect);
    }

    // </editor-fold>
}
