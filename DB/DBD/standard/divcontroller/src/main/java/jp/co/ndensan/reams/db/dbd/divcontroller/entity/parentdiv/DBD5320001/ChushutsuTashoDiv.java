package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuTasho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuTashoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTanpyoHakkoZumi")
    private RadioButton radTanpyoHakkoZumi;
    @JsonProperty("lblTaishoKikan")
    private Label lblTaishoKikan;
    @JsonProperty("lblNinteiKekkaTsuchisho")
    private Label lblNinteiKekkaTsuchisho;
    @JsonProperty("txtNinteiKekkaZenkaiYMDFrom")
    private TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDFrom;
    @JsonProperty("txtNinteiKekkaZenkaiTimeFrom")
    private TextBoxTime txtNinteiKekkaZenkaiTimeFrom;
    @JsonProperty("lblNinteiKekkaZenkaiFor")
    private Label lblNinteiKekkaZenkaiFor;
    @JsonProperty("txtNinteiKekkaZenkaiYMDTo")
    private TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDTo;
    @JsonProperty("txtNinteiKekkaZenkaiTimeTo")
    private TextBoxTime txtNinteiKekkaZenkaiTimeTo;
    @JsonProperty("txtNinteiKekkaKonkaiYMDFrom")
    private TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDFrom;
    @JsonProperty("txtNinteiKekkaKonkaiTimeFrom")
    private TextBoxTime txtNinteiKekkaKonkaiTimeFrom;
    @JsonProperty("lblNinteiKekkaKonkaiFor")
    private Label lblNinteiKekkaKonkaiFor;
    @JsonProperty("txtNinteiKekkaKonkaiYMDTo")
    private TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDTo;
    @JsonProperty("txtNinteiKekkaKonkaiTimeTo")
    private TextBoxTime txtNinteiKekkaKonkaiTimeTo;
    @JsonProperty("linHorizontal1")
    private HorizontalLine linHorizontal1;
    @JsonProperty("lblServiceHenkoTsuchi")
    private Label lblServiceHenkoTsuchi;
    @JsonProperty("txtServiceHenkoZenkaiYMDFrom")
    private TextBoxFlexibleDate txtServiceHenkoZenkaiYMDFrom;
    @JsonProperty("txtServiceHenkoZenkaiTimeForm")
    private TextBoxTime txtServiceHenkoZenkaiTimeForm;
    @JsonProperty("lblServiceHenkoZenkaiFor")
    private Label lblServiceHenkoZenkaiFor;
    @JsonProperty("txtServiceHenkoZenkaiYMDTo")
    private TextBoxFlexibleDate txtServiceHenkoZenkaiYMDTo;
    @JsonProperty("txtServiceHenkoZenkaiTimeTo")
    private TextBoxTime txtServiceHenkoZenkaiTimeTo;
    @JsonProperty("txtServiceHenkoKonkaiYMDFrom")
    private TextBoxFlexibleDate txtServiceHenkoKonkaiYMDFrom;
    @JsonProperty("txtServiceHenkoKonkaiTimeFrom")
    private TextBoxTime txtServiceHenkoKonkaiTimeFrom;
    @JsonProperty("lblServiceHenkoKonkaiFor")
    private Label lblServiceHenkoKonkaiFor;
    @JsonProperty("txtServiceHenkoKonkaiYMDTo")
    private TextBoxFlexibleDate txtServiceHenkoKonkaiYMDTo;
    @JsonProperty("txtServiceHenkoKonkaiTimeTo")
    private TextBoxTime txtServiceHenkoKonkaiTimeTo;
    @JsonProperty("linHorizontal2")
    private HorizontalLine linHorizontal2;
    @JsonProperty("lblYokaigoKubunHenkoTsuchisho")
    private Label lblYokaigoKubunHenkoTsuchisho;
    @JsonProperty("txtKubunHenkoZenkaiYMDFrom")
    private TextBoxFlexibleDate txtKubunHenkoZenkaiYMDFrom;
    @JsonProperty("txtKubunHenkoZenkaiTimeFrom")
    private TextBoxTime txtKubunHenkoZenkaiTimeFrom;
    @JsonProperty("lblKubunHenkoZenkaiFor")
    private Label lblKubunHenkoZenkaiFor;
    @JsonProperty("txtKubunHenkoZenkaiYMDTo")
    private TextBoxFlexibleDate txtKubunHenkoZenkaiYMDTo;
    @JsonProperty("txtKubunHenkoZenkaiTimeTo")
    private TextBoxTime txtKubunHenkoZenkaiTimeTo;
    @JsonProperty("txtKubunHenkoKonkaiYMDFrom")
    private TextBoxFlexibleDate txtKubunHenkoKonkaiYMDFrom;
    @JsonProperty("txtKubunHenkoKonkaiTimeFrom")
    private TextBoxTime txtKubunHenkoKonkaiTimeFrom;
    @JsonProperty("lblKubunHenkoKonkaiFor")
    private Label lblKubunHenkoKonkaiFor;
    @JsonProperty("txtKubunHenkoKonkaiYMDTo")
    private TextBoxFlexibleDate txtKubunHenkoKonkaiYMDTo;
    @JsonProperty("txtKubunHenkoKonkaiTimeTo")
    private TextBoxTime txtKubunHenkoKonkaiTimeTo;
    @JsonProperty("ccdIkkatsuNinteiKekkaBunshoBango")
    private BunshoBangoInputDiv ccdIkkatsuNinteiKekkaBunshoBango;
    @JsonProperty("ccdIkkatsuServiceHenkoBunshoBango")
    private BunshoBangoInputDiv ccdIkkatsuServiceHenkoBunshoBango;
    @JsonProperty("ccdIkkatsuKubunHenkoBunshoBango")
    private BunshoBangoInputDiv ccdIkkatsuKubunHenkoBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTanpyoHakkoZumi
     * @return radTanpyoHakkoZumi
     */
    @JsonProperty("radTanpyoHakkoZumi")
    public RadioButton getRadTanpyoHakkoZumi() {
        return radTanpyoHakkoZumi;
    }

    /*
     * setradTanpyoHakkoZumi
     * @param radTanpyoHakkoZumi radTanpyoHakkoZumi
     */
    @JsonProperty("radTanpyoHakkoZumi")
    public void setRadTanpyoHakkoZumi(RadioButton radTanpyoHakkoZumi) {
        this.radTanpyoHakkoZumi = radTanpyoHakkoZumi;
    }

    /*
     * getlblTaishoKikan
     * @return lblTaishoKikan
     */
    @JsonProperty("lblTaishoKikan")
    public Label getLblTaishoKikan() {
        return lblTaishoKikan;
    }

    /*
     * setlblTaishoKikan
     * @param lblTaishoKikan lblTaishoKikan
     */
    @JsonProperty("lblTaishoKikan")
    public void setLblTaishoKikan(Label lblTaishoKikan) {
        this.lblTaishoKikan = lblTaishoKikan;
    }

    /*
     * getlblNinteiKekkaTsuchisho
     * @return lblNinteiKekkaTsuchisho
     */
    @JsonProperty("lblNinteiKekkaTsuchisho")
    public Label getLblNinteiKekkaTsuchisho() {
        return lblNinteiKekkaTsuchisho;
    }

    /*
     * setlblNinteiKekkaTsuchisho
     * @param lblNinteiKekkaTsuchisho lblNinteiKekkaTsuchisho
     */
    @JsonProperty("lblNinteiKekkaTsuchisho")
    public void setLblNinteiKekkaTsuchisho(Label lblNinteiKekkaTsuchisho) {
        this.lblNinteiKekkaTsuchisho = lblNinteiKekkaTsuchisho;
    }

    /*
     * gettxtNinteiKekkaZenkaiYMDFrom
     * @return txtNinteiKekkaZenkaiYMDFrom
     */
    @JsonProperty("txtNinteiKekkaZenkaiYMDFrom")
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDFrom() {
        return txtNinteiKekkaZenkaiYMDFrom;
    }

    /*
     * settxtNinteiKekkaZenkaiYMDFrom
     * @param txtNinteiKekkaZenkaiYMDFrom txtNinteiKekkaZenkaiYMDFrom
     */
    @JsonProperty("txtNinteiKekkaZenkaiYMDFrom")
    public void setTxtNinteiKekkaZenkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDFrom) {
        this.txtNinteiKekkaZenkaiYMDFrom = txtNinteiKekkaZenkaiYMDFrom;
    }

    /*
     * gettxtNinteiKekkaZenkaiTimeFrom
     * @return txtNinteiKekkaZenkaiTimeFrom
     */
    @JsonProperty("txtNinteiKekkaZenkaiTimeFrom")
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeFrom() {
        return txtNinteiKekkaZenkaiTimeFrom;
    }

    /*
     * settxtNinteiKekkaZenkaiTimeFrom
     * @param txtNinteiKekkaZenkaiTimeFrom txtNinteiKekkaZenkaiTimeFrom
     */
    @JsonProperty("txtNinteiKekkaZenkaiTimeFrom")
    public void setTxtNinteiKekkaZenkaiTimeFrom(TextBoxTime txtNinteiKekkaZenkaiTimeFrom) {
        this.txtNinteiKekkaZenkaiTimeFrom = txtNinteiKekkaZenkaiTimeFrom;
    }

    /*
     * getlblNinteiKekkaZenkaiFor
     * @return lblNinteiKekkaZenkaiFor
     */
    @JsonProperty("lblNinteiKekkaZenkaiFor")
    public Label getLblNinteiKekkaZenkaiFor() {
        return lblNinteiKekkaZenkaiFor;
    }

    /*
     * setlblNinteiKekkaZenkaiFor
     * @param lblNinteiKekkaZenkaiFor lblNinteiKekkaZenkaiFor
     */
    @JsonProperty("lblNinteiKekkaZenkaiFor")
    public void setLblNinteiKekkaZenkaiFor(Label lblNinteiKekkaZenkaiFor) {
        this.lblNinteiKekkaZenkaiFor = lblNinteiKekkaZenkaiFor;
    }

    /*
     * gettxtNinteiKekkaZenkaiYMDTo
     * @return txtNinteiKekkaZenkaiYMDTo
     */
    @JsonProperty("txtNinteiKekkaZenkaiYMDTo")
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDTo() {
        return txtNinteiKekkaZenkaiYMDTo;
    }

    /*
     * settxtNinteiKekkaZenkaiYMDTo
     * @param txtNinteiKekkaZenkaiYMDTo txtNinteiKekkaZenkaiYMDTo
     */
    @JsonProperty("txtNinteiKekkaZenkaiYMDTo")
    public void setTxtNinteiKekkaZenkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDTo) {
        this.txtNinteiKekkaZenkaiYMDTo = txtNinteiKekkaZenkaiYMDTo;
    }

    /*
     * gettxtNinteiKekkaZenkaiTimeTo
     * @return txtNinteiKekkaZenkaiTimeTo
     */
    @JsonProperty("txtNinteiKekkaZenkaiTimeTo")
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeTo() {
        return txtNinteiKekkaZenkaiTimeTo;
    }

    /*
     * settxtNinteiKekkaZenkaiTimeTo
     * @param txtNinteiKekkaZenkaiTimeTo txtNinteiKekkaZenkaiTimeTo
     */
    @JsonProperty("txtNinteiKekkaZenkaiTimeTo")
    public void setTxtNinteiKekkaZenkaiTimeTo(TextBoxTime txtNinteiKekkaZenkaiTimeTo) {
        this.txtNinteiKekkaZenkaiTimeTo = txtNinteiKekkaZenkaiTimeTo;
    }

    /*
     * gettxtNinteiKekkaKonkaiYMDFrom
     * @return txtNinteiKekkaKonkaiYMDFrom
     */
    @JsonProperty("txtNinteiKekkaKonkaiYMDFrom")
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDFrom() {
        return txtNinteiKekkaKonkaiYMDFrom;
    }

    /*
     * settxtNinteiKekkaKonkaiYMDFrom
     * @param txtNinteiKekkaKonkaiYMDFrom txtNinteiKekkaKonkaiYMDFrom
     */
    @JsonProperty("txtNinteiKekkaKonkaiYMDFrom")
    public void setTxtNinteiKekkaKonkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDFrom) {
        this.txtNinteiKekkaKonkaiYMDFrom = txtNinteiKekkaKonkaiYMDFrom;
    }

    /*
     * gettxtNinteiKekkaKonkaiTimeFrom
     * @return txtNinteiKekkaKonkaiTimeFrom
     */
    @JsonProperty("txtNinteiKekkaKonkaiTimeFrom")
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeFrom() {
        return txtNinteiKekkaKonkaiTimeFrom;
    }

    /*
     * settxtNinteiKekkaKonkaiTimeFrom
     * @param txtNinteiKekkaKonkaiTimeFrom txtNinteiKekkaKonkaiTimeFrom
     */
    @JsonProperty("txtNinteiKekkaKonkaiTimeFrom")
    public void setTxtNinteiKekkaKonkaiTimeFrom(TextBoxTime txtNinteiKekkaKonkaiTimeFrom) {
        this.txtNinteiKekkaKonkaiTimeFrom = txtNinteiKekkaKonkaiTimeFrom;
    }

    /*
     * getlblNinteiKekkaKonkaiFor
     * @return lblNinteiKekkaKonkaiFor
     */
    @JsonProperty("lblNinteiKekkaKonkaiFor")
    public Label getLblNinteiKekkaKonkaiFor() {
        return lblNinteiKekkaKonkaiFor;
    }

    /*
     * setlblNinteiKekkaKonkaiFor
     * @param lblNinteiKekkaKonkaiFor lblNinteiKekkaKonkaiFor
     */
    @JsonProperty("lblNinteiKekkaKonkaiFor")
    public void setLblNinteiKekkaKonkaiFor(Label lblNinteiKekkaKonkaiFor) {
        this.lblNinteiKekkaKonkaiFor = lblNinteiKekkaKonkaiFor;
    }

    /*
     * gettxtNinteiKekkaKonkaiYMDTo
     * @return txtNinteiKekkaKonkaiYMDTo
     */
    @JsonProperty("txtNinteiKekkaKonkaiYMDTo")
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDTo() {
        return txtNinteiKekkaKonkaiYMDTo;
    }

    /*
     * settxtNinteiKekkaKonkaiYMDTo
     * @param txtNinteiKekkaKonkaiYMDTo txtNinteiKekkaKonkaiYMDTo
     */
    @JsonProperty("txtNinteiKekkaKonkaiYMDTo")
    public void setTxtNinteiKekkaKonkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDTo) {
        this.txtNinteiKekkaKonkaiYMDTo = txtNinteiKekkaKonkaiYMDTo;
    }

    /*
     * gettxtNinteiKekkaKonkaiTimeTo
     * @return txtNinteiKekkaKonkaiTimeTo
     */
    @JsonProperty("txtNinteiKekkaKonkaiTimeTo")
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeTo() {
        return txtNinteiKekkaKonkaiTimeTo;
    }

    /*
     * settxtNinteiKekkaKonkaiTimeTo
     * @param txtNinteiKekkaKonkaiTimeTo txtNinteiKekkaKonkaiTimeTo
     */
    @JsonProperty("txtNinteiKekkaKonkaiTimeTo")
    public void setTxtNinteiKekkaKonkaiTimeTo(TextBoxTime txtNinteiKekkaKonkaiTimeTo) {
        this.txtNinteiKekkaKonkaiTimeTo = txtNinteiKekkaKonkaiTimeTo;
    }

    /*
     * getlinHorizontal1
     * @return linHorizontal1
     */
    @JsonProperty("linHorizontal1")
    public HorizontalLine getLinHorizontal1() {
        return linHorizontal1;
    }

    /*
     * setlinHorizontal1
     * @param linHorizontal1 linHorizontal1
     */
    @JsonProperty("linHorizontal1")
    public void setLinHorizontal1(HorizontalLine linHorizontal1) {
        this.linHorizontal1 = linHorizontal1;
    }

    /*
     * getlblServiceHenkoTsuchi
     * @return lblServiceHenkoTsuchi
     */
    @JsonProperty("lblServiceHenkoTsuchi")
    public Label getLblServiceHenkoTsuchi() {
        return lblServiceHenkoTsuchi;
    }

    /*
     * setlblServiceHenkoTsuchi
     * @param lblServiceHenkoTsuchi lblServiceHenkoTsuchi
     */
    @JsonProperty("lblServiceHenkoTsuchi")
    public void setLblServiceHenkoTsuchi(Label lblServiceHenkoTsuchi) {
        this.lblServiceHenkoTsuchi = lblServiceHenkoTsuchi;
    }

    /*
     * gettxtServiceHenkoZenkaiYMDFrom
     * @return txtServiceHenkoZenkaiYMDFrom
     */
    @JsonProperty("txtServiceHenkoZenkaiYMDFrom")
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDFrom() {
        return txtServiceHenkoZenkaiYMDFrom;
    }

    /*
     * settxtServiceHenkoZenkaiYMDFrom
     * @param txtServiceHenkoZenkaiYMDFrom txtServiceHenkoZenkaiYMDFrom
     */
    @JsonProperty("txtServiceHenkoZenkaiYMDFrom")
    public void setTxtServiceHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDFrom) {
        this.txtServiceHenkoZenkaiYMDFrom = txtServiceHenkoZenkaiYMDFrom;
    }

    /*
     * gettxtServiceHenkoZenkaiTimeForm
     * @return txtServiceHenkoZenkaiTimeForm
     */
    @JsonProperty("txtServiceHenkoZenkaiTimeForm")
    public TextBoxTime getTxtServiceHenkoZenkaiTimeForm() {
        return txtServiceHenkoZenkaiTimeForm;
    }

    /*
     * settxtServiceHenkoZenkaiTimeForm
     * @param txtServiceHenkoZenkaiTimeForm txtServiceHenkoZenkaiTimeForm
     */
    @JsonProperty("txtServiceHenkoZenkaiTimeForm")
    public void setTxtServiceHenkoZenkaiTimeForm(TextBoxTime txtServiceHenkoZenkaiTimeForm) {
        this.txtServiceHenkoZenkaiTimeForm = txtServiceHenkoZenkaiTimeForm;
    }

    /*
     * getlblServiceHenkoZenkaiFor
     * @return lblServiceHenkoZenkaiFor
     */
    @JsonProperty("lblServiceHenkoZenkaiFor")
    public Label getLblServiceHenkoZenkaiFor() {
        return lblServiceHenkoZenkaiFor;
    }

    /*
     * setlblServiceHenkoZenkaiFor
     * @param lblServiceHenkoZenkaiFor lblServiceHenkoZenkaiFor
     */
    @JsonProperty("lblServiceHenkoZenkaiFor")
    public void setLblServiceHenkoZenkaiFor(Label lblServiceHenkoZenkaiFor) {
        this.lblServiceHenkoZenkaiFor = lblServiceHenkoZenkaiFor;
    }

    /*
     * gettxtServiceHenkoZenkaiYMDTo
     * @return txtServiceHenkoZenkaiYMDTo
     */
    @JsonProperty("txtServiceHenkoZenkaiYMDTo")
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDTo() {
        return txtServiceHenkoZenkaiYMDTo;
    }

    /*
     * settxtServiceHenkoZenkaiYMDTo
     * @param txtServiceHenkoZenkaiYMDTo txtServiceHenkoZenkaiYMDTo
     */
    @JsonProperty("txtServiceHenkoZenkaiYMDTo")
    public void setTxtServiceHenkoZenkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDTo) {
        this.txtServiceHenkoZenkaiYMDTo = txtServiceHenkoZenkaiYMDTo;
    }

    /*
     * gettxtServiceHenkoZenkaiTimeTo
     * @return txtServiceHenkoZenkaiTimeTo
     */
    @JsonProperty("txtServiceHenkoZenkaiTimeTo")
    public TextBoxTime getTxtServiceHenkoZenkaiTimeTo() {
        return txtServiceHenkoZenkaiTimeTo;
    }

    /*
     * settxtServiceHenkoZenkaiTimeTo
     * @param txtServiceHenkoZenkaiTimeTo txtServiceHenkoZenkaiTimeTo
     */
    @JsonProperty("txtServiceHenkoZenkaiTimeTo")
    public void setTxtServiceHenkoZenkaiTimeTo(TextBoxTime txtServiceHenkoZenkaiTimeTo) {
        this.txtServiceHenkoZenkaiTimeTo = txtServiceHenkoZenkaiTimeTo;
    }

    /*
     * gettxtServiceHenkoKonkaiYMDFrom
     * @return txtServiceHenkoKonkaiYMDFrom
     */
    @JsonProperty("txtServiceHenkoKonkaiYMDFrom")
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDFrom() {
        return txtServiceHenkoKonkaiYMDFrom;
    }

    /*
     * settxtServiceHenkoKonkaiYMDFrom
     * @param txtServiceHenkoKonkaiYMDFrom txtServiceHenkoKonkaiYMDFrom
     */
    @JsonProperty("txtServiceHenkoKonkaiYMDFrom")
    public void setTxtServiceHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDFrom) {
        this.txtServiceHenkoKonkaiYMDFrom = txtServiceHenkoKonkaiYMDFrom;
    }

    /*
     * gettxtServiceHenkoKonkaiTimeFrom
     * @return txtServiceHenkoKonkaiTimeFrom
     */
    @JsonProperty("txtServiceHenkoKonkaiTimeFrom")
    public TextBoxTime getTxtServiceHenkoKonkaiTimeFrom() {
        return txtServiceHenkoKonkaiTimeFrom;
    }

    /*
     * settxtServiceHenkoKonkaiTimeFrom
     * @param txtServiceHenkoKonkaiTimeFrom txtServiceHenkoKonkaiTimeFrom
     */
    @JsonProperty("txtServiceHenkoKonkaiTimeFrom")
    public void setTxtServiceHenkoKonkaiTimeFrom(TextBoxTime txtServiceHenkoKonkaiTimeFrom) {
        this.txtServiceHenkoKonkaiTimeFrom = txtServiceHenkoKonkaiTimeFrom;
    }

    /*
     * getlblServiceHenkoKonkaiFor
     * @return lblServiceHenkoKonkaiFor
     */
    @JsonProperty("lblServiceHenkoKonkaiFor")
    public Label getLblServiceHenkoKonkaiFor() {
        return lblServiceHenkoKonkaiFor;
    }

    /*
     * setlblServiceHenkoKonkaiFor
     * @param lblServiceHenkoKonkaiFor lblServiceHenkoKonkaiFor
     */
    @JsonProperty("lblServiceHenkoKonkaiFor")
    public void setLblServiceHenkoKonkaiFor(Label lblServiceHenkoKonkaiFor) {
        this.lblServiceHenkoKonkaiFor = lblServiceHenkoKonkaiFor;
    }

    /*
     * gettxtServiceHenkoKonkaiYMDTo
     * @return txtServiceHenkoKonkaiYMDTo
     */
    @JsonProperty("txtServiceHenkoKonkaiYMDTo")
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDTo() {
        return txtServiceHenkoKonkaiYMDTo;
    }

    /*
     * settxtServiceHenkoKonkaiYMDTo
     * @param txtServiceHenkoKonkaiYMDTo txtServiceHenkoKonkaiYMDTo
     */
    @JsonProperty("txtServiceHenkoKonkaiYMDTo")
    public void setTxtServiceHenkoKonkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDTo) {
        this.txtServiceHenkoKonkaiYMDTo = txtServiceHenkoKonkaiYMDTo;
    }

    /*
     * gettxtServiceHenkoKonkaiTimeTo
     * @return txtServiceHenkoKonkaiTimeTo
     */
    @JsonProperty("txtServiceHenkoKonkaiTimeTo")
    public TextBoxTime getTxtServiceHenkoKonkaiTimeTo() {
        return txtServiceHenkoKonkaiTimeTo;
    }

    /*
     * settxtServiceHenkoKonkaiTimeTo
     * @param txtServiceHenkoKonkaiTimeTo txtServiceHenkoKonkaiTimeTo
     */
    @JsonProperty("txtServiceHenkoKonkaiTimeTo")
    public void setTxtServiceHenkoKonkaiTimeTo(TextBoxTime txtServiceHenkoKonkaiTimeTo) {
        this.txtServiceHenkoKonkaiTimeTo = txtServiceHenkoKonkaiTimeTo;
    }

    /*
     * getlinHorizontal2
     * @return linHorizontal2
     */
    @JsonProperty("linHorizontal2")
    public HorizontalLine getLinHorizontal2() {
        return linHorizontal2;
    }

    /*
     * setlinHorizontal2
     * @param linHorizontal2 linHorizontal2
     */
    @JsonProperty("linHorizontal2")
    public void setLinHorizontal2(HorizontalLine linHorizontal2) {
        this.linHorizontal2 = linHorizontal2;
    }

    /*
     * getlblYokaigoKubunHenkoTsuchisho
     * @return lblYokaigoKubunHenkoTsuchisho
     */
    @JsonProperty("lblYokaigoKubunHenkoTsuchisho")
    public Label getLblYokaigoKubunHenkoTsuchisho() {
        return lblYokaigoKubunHenkoTsuchisho;
    }

    /*
     * setlblYokaigoKubunHenkoTsuchisho
     * @param lblYokaigoKubunHenkoTsuchisho lblYokaigoKubunHenkoTsuchisho
     */
    @JsonProperty("lblYokaigoKubunHenkoTsuchisho")
    public void setLblYokaigoKubunHenkoTsuchisho(Label lblYokaigoKubunHenkoTsuchisho) {
        this.lblYokaigoKubunHenkoTsuchisho = lblYokaigoKubunHenkoTsuchisho;
    }

    /*
     * gettxtKubunHenkoZenkaiYMDFrom
     * @return txtKubunHenkoZenkaiYMDFrom
     */
    @JsonProperty("txtKubunHenkoZenkaiYMDFrom")
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDFrom() {
        return txtKubunHenkoZenkaiYMDFrom;
    }

    /*
     * settxtKubunHenkoZenkaiYMDFrom
     * @param txtKubunHenkoZenkaiYMDFrom txtKubunHenkoZenkaiYMDFrom
     */
    @JsonProperty("txtKubunHenkoZenkaiYMDFrom")
    public void setTxtKubunHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDFrom) {
        this.txtKubunHenkoZenkaiYMDFrom = txtKubunHenkoZenkaiYMDFrom;
    }

    /*
     * gettxtKubunHenkoZenkaiTimeFrom
     * @return txtKubunHenkoZenkaiTimeFrom
     */
    @JsonProperty("txtKubunHenkoZenkaiTimeFrom")
    public TextBoxTime getTxtKubunHenkoZenkaiTimeFrom() {
        return txtKubunHenkoZenkaiTimeFrom;
    }

    /*
     * settxtKubunHenkoZenkaiTimeFrom
     * @param txtKubunHenkoZenkaiTimeFrom txtKubunHenkoZenkaiTimeFrom
     */
    @JsonProperty("txtKubunHenkoZenkaiTimeFrom")
    public void setTxtKubunHenkoZenkaiTimeFrom(TextBoxTime txtKubunHenkoZenkaiTimeFrom) {
        this.txtKubunHenkoZenkaiTimeFrom = txtKubunHenkoZenkaiTimeFrom;
    }

    /*
     * getlblKubunHenkoZenkaiFor
     * @return lblKubunHenkoZenkaiFor
     */
    @JsonProperty("lblKubunHenkoZenkaiFor")
    public Label getLblKubunHenkoZenkaiFor() {
        return lblKubunHenkoZenkaiFor;
    }

    /*
     * setlblKubunHenkoZenkaiFor
     * @param lblKubunHenkoZenkaiFor lblKubunHenkoZenkaiFor
     */
    @JsonProperty("lblKubunHenkoZenkaiFor")
    public void setLblKubunHenkoZenkaiFor(Label lblKubunHenkoZenkaiFor) {
        this.lblKubunHenkoZenkaiFor = lblKubunHenkoZenkaiFor;
    }

    /*
     * gettxtKubunHenkoZenkaiYMDTo
     * @return txtKubunHenkoZenkaiYMDTo
     */
    @JsonProperty("txtKubunHenkoZenkaiYMDTo")
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDTo() {
        return txtKubunHenkoZenkaiYMDTo;
    }

    /*
     * settxtKubunHenkoZenkaiYMDTo
     * @param txtKubunHenkoZenkaiYMDTo txtKubunHenkoZenkaiYMDTo
     */
    @JsonProperty("txtKubunHenkoZenkaiYMDTo")
    public void setTxtKubunHenkoZenkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDTo) {
        this.txtKubunHenkoZenkaiYMDTo = txtKubunHenkoZenkaiYMDTo;
    }

    /*
     * gettxtKubunHenkoZenkaiTimeTo
     * @return txtKubunHenkoZenkaiTimeTo
     */
    @JsonProperty("txtKubunHenkoZenkaiTimeTo")
    public TextBoxTime getTxtKubunHenkoZenkaiTimeTo() {
        return txtKubunHenkoZenkaiTimeTo;
    }

    /*
     * settxtKubunHenkoZenkaiTimeTo
     * @param txtKubunHenkoZenkaiTimeTo txtKubunHenkoZenkaiTimeTo
     */
    @JsonProperty("txtKubunHenkoZenkaiTimeTo")
    public void setTxtKubunHenkoZenkaiTimeTo(TextBoxTime txtKubunHenkoZenkaiTimeTo) {
        this.txtKubunHenkoZenkaiTimeTo = txtKubunHenkoZenkaiTimeTo;
    }

    /*
     * gettxtKubunHenkoKonkaiYMDFrom
     * @return txtKubunHenkoKonkaiYMDFrom
     */
    @JsonProperty("txtKubunHenkoKonkaiYMDFrom")
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDFrom() {
        return txtKubunHenkoKonkaiYMDFrom;
    }

    /*
     * settxtKubunHenkoKonkaiYMDFrom
     * @param txtKubunHenkoKonkaiYMDFrom txtKubunHenkoKonkaiYMDFrom
     */
    @JsonProperty("txtKubunHenkoKonkaiYMDFrom")
    public void setTxtKubunHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDFrom) {
        this.txtKubunHenkoKonkaiYMDFrom = txtKubunHenkoKonkaiYMDFrom;
    }

    /*
     * gettxtKubunHenkoKonkaiTimeFrom
     * @return txtKubunHenkoKonkaiTimeFrom
     */
    @JsonProperty("txtKubunHenkoKonkaiTimeFrom")
    public TextBoxTime getTxtKubunHenkoKonkaiTimeFrom() {
        return txtKubunHenkoKonkaiTimeFrom;
    }

    /*
     * settxtKubunHenkoKonkaiTimeFrom
     * @param txtKubunHenkoKonkaiTimeFrom txtKubunHenkoKonkaiTimeFrom
     */
    @JsonProperty("txtKubunHenkoKonkaiTimeFrom")
    public void setTxtKubunHenkoKonkaiTimeFrom(TextBoxTime txtKubunHenkoKonkaiTimeFrom) {
        this.txtKubunHenkoKonkaiTimeFrom = txtKubunHenkoKonkaiTimeFrom;
    }

    /*
     * getlblKubunHenkoKonkaiFor
     * @return lblKubunHenkoKonkaiFor
     */
    @JsonProperty("lblKubunHenkoKonkaiFor")
    public Label getLblKubunHenkoKonkaiFor() {
        return lblKubunHenkoKonkaiFor;
    }

    /*
     * setlblKubunHenkoKonkaiFor
     * @param lblKubunHenkoKonkaiFor lblKubunHenkoKonkaiFor
     */
    @JsonProperty("lblKubunHenkoKonkaiFor")
    public void setLblKubunHenkoKonkaiFor(Label lblKubunHenkoKonkaiFor) {
        this.lblKubunHenkoKonkaiFor = lblKubunHenkoKonkaiFor;
    }

    /*
     * gettxtKubunHenkoKonkaiYMDTo
     * @return txtKubunHenkoKonkaiYMDTo
     */
    @JsonProperty("txtKubunHenkoKonkaiYMDTo")
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDTo() {
        return txtKubunHenkoKonkaiYMDTo;
    }

    /*
     * settxtKubunHenkoKonkaiYMDTo
     * @param txtKubunHenkoKonkaiYMDTo txtKubunHenkoKonkaiYMDTo
     */
    @JsonProperty("txtKubunHenkoKonkaiYMDTo")
    public void setTxtKubunHenkoKonkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDTo) {
        this.txtKubunHenkoKonkaiYMDTo = txtKubunHenkoKonkaiYMDTo;
    }

    /*
     * gettxtKubunHenkoKonkaiTimeTo
     * @return txtKubunHenkoKonkaiTimeTo
     */
    @JsonProperty("txtKubunHenkoKonkaiTimeTo")
    public TextBoxTime getTxtKubunHenkoKonkaiTimeTo() {
        return txtKubunHenkoKonkaiTimeTo;
    }

    /*
     * settxtKubunHenkoKonkaiTimeTo
     * @param txtKubunHenkoKonkaiTimeTo txtKubunHenkoKonkaiTimeTo
     */
    @JsonProperty("txtKubunHenkoKonkaiTimeTo")
    public void setTxtKubunHenkoKonkaiTimeTo(TextBoxTime txtKubunHenkoKonkaiTimeTo) {
        this.txtKubunHenkoKonkaiTimeTo = txtKubunHenkoKonkaiTimeTo;
    }

    /*
     * getccdIkkatsuNinteiKekkaBunshoBango
     * @return ccdIkkatsuNinteiKekkaBunshoBango
     */
    @JsonProperty("ccdIkkatsuNinteiKekkaBunshoBango")
    public IBunshoBangoInputDiv getCcdIkkatsuNinteiKekkaBunshoBango() {
        return ccdIkkatsuNinteiKekkaBunshoBango;
    }

    /*
     * getccdIkkatsuServiceHenkoBunshoBango
     * @return ccdIkkatsuServiceHenkoBunshoBango
     */
    @JsonProperty("ccdIkkatsuServiceHenkoBunshoBango")
    public IBunshoBangoInputDiv getCcdIkkatsuServiceHenkoBunshoBango() {
        return ccdIkkatsuServiceHenkoBunshoBango;
    }

    /*
     * getccdIkkatsuKubunHenkoBunshoBango
     * @return ccdIkkatsuKubunHenkoBunshoBango
     */
    @JsonProperty("ccdIkkatsuKubunHenkoBunshoBango")
    public IBunshoBangoInputDiv getCcdIkkatsuKubunHenkoBunshoBango() {
        return ccdIkkatsuKubunHenkoBunshoBango;
    }

    // </editor-fold>
}
