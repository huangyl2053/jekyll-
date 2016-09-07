package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkkatsuHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkOutPutSelect")
    private CheckBoxList chkOutPutSelect;
    @JsonProperty("txtSakuseiDaytxtSakuseiDaytxtSakuseiDay")
    private TextBoxFlexibleDate txtSakuseiDaytxtSakuseiDaytxtSakuseiDay;
    @JsonProperty("ChushutsuTasho")
    private ChushutsuTashoDiv ChushutsuTasho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkOutPutSelect
     * @return chkOutPutSelect
     */
    @JsonProperty("chkOutPutSelect")
    public CheckBoxList getChkOutPutSelect() {
        return chkOutPutSelect;
    }

    /*
     * setchkOutPutSelect
     * @param chkOutPutSelect chkOutPutSelect
     */
    @JsonProperty("chkOutPutSelect")
    public void setChkOutPutSelect(CheckBoxList chkOutPutSelect) {
        this.chkOutPutSelect = chkOutPutSelect;
    }

    /*
     * gettxtSakuseiDaytxtSakuseiDaytxtSakuseiDay
     * @return txtSakuseiDaytxtSakuseiDaytxtSakuseiDay
     */
    @JsonProperty("txtSakuseiDaytxtSakuseiDaytxtSakuseiDay")
    public TextBoxFlexibleDate getTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay() {
        return txtSakuseiDaytxtSakuseiDaytxtSakuseiDay;
    }

    /*
     * settxtSakuseiDaytxtSakuseiDaytxtSakuseiDay
     * @param txtSakuseiDaytxtSakuseiDaytxtSakuseiDay txtSakuseiDaytxtSakuseiDaytxtSakuseiDay
     */
    @JsonProperty("txtSakuseiDaytxtSakuseiDaytxtSakuseiDay")
    public void setTxtSakuseiDaytxtSakuseiDaytxtSakuseiDay(TextBoxFlexibleDate txtSakuseiDaytxtSakuseiDaytxtSakuseiDay) {
        this.txtSakuseiDaytxtSakuseiDaytxtSakuseiDay = txtSakuseiDaytxtSakuseiDaytxtSakuseiDay;
    }

    /*
     * getChushutsuTasho
     * @return ChushutsuTasho
     */
    @JsonProperty("ChushutsuTasho")
    public ChushutsuTashoDiv getChushutsuTasho() {
        return ChushutsuTasho;
    }

    /*
     * setChushutsuTasho
     * @param ChushutsuTasho ChushutsuTasho
     */
    @JsonProperty("ChushutsuTasho")
    public void setChushutsuTasho(ChushutsuTashoDiv ChushutsuTasho) {
        this.ChushutsuTasho = ChushutsuTasho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTanpyoHakkoZumi() {
        return this.getChushutsuTasho().getRadTanpyoHakkoZumi();
    }

    @JsonIgnore
    public void  setRadTanpyoHakkoZumi(RadioButton radTanpyoHakkoZumi) {
        this.getChushutsuTasho().setRadTanpyoHakkoZumi(radTanpyoHakkoZumi);
    }

    @JsonIgnore
    public Label getLblTaishoKikan() {
        return this.getChushutsuTasho().getLblTaishoKikan();
    }

    @JsonIgnore
    public void  setLblTaishoKikan(Label lblTaishoKikan) {
        this.getChushutsuTasho().setLblTaishoKikan(lblTaishoKikan);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaTsuchisho() {
        return this.getChushutsuTasho().getLblNinteiKekkaTsuchisho();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaTsuchisho(Label lblNinteiKekkaTsuchisho) {
        this.getChushutsuTasho().setLblNinteiKekkaTsuchisho(lblNinteiKekkaTsuchisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtNinteiKekkaZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDFrom) {
        this.getChushutsuTasho().setTxtNinteiKekkaZenkaiYMDFrom(txtNinteiKekkaZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeFrom() {
        return this.getChushutsuTasho().getTxtNinteiKekkaZenkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiTimeFrom(TextBoxTime txtNinteiKekkaZenkaiTimeFrom) {
        this.getChushutsuTasho().setTxtNinteiKekkaZenkaiTimeFrom(txtNinteiKekkaZenkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaZenkaiFor() {
        return this.getChushutsuTasho().getLblNinteiKekkaZenkaiFor();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaZenkaiFor(Label lblNinteiKekkaZenkaiFor) {
        this.getChushutsuTasho().setLblNinteiKekkaZenkaiFor(lblNinteiKekkaZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaZenkaiYMDTo() {
        return this.getChushutsuTasho().getTxtNinteiKekkaZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaZenkaiYMDTo) {
        this.getChushutsuTasho().setTxtNinteiKekkaZenkaiYMDTo(txtNinteiKekkaZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaZenkaiTimeTo() {
        return this.getChushutsuTasho().getTxtNinteiKekkaZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaZenkaiTimeTo(TextBoxTime txtNinteiKekkaZenkaiTimeTo) {
        this.getChushutsuTasho().setTxtNinteiKekkaZenkaiTimeTo(txtNinteiKekkaZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtNinteiKekkaKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiYMDFrom(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDFrom) {
        this.getChushutsuTasho().setTxtNinteiKekkaKonkaiYMDFrom(txtNinteiKekkaKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeFrom() {
        return this.getChushutsuTasho().getTxtNinteiKekkaKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiTimeFrom(TextBoxTime txtNinteiKekkaKonkaiTimeFrom) {
        this.getChushutsuTasho().setTxtNinteiKekkaKonkaiTimeFrom(txtNinteiKekkaKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblNinteiKekkaKonkaiFor() {
        return this.getChushutsuTasho().getLblNinteiKekkaKonkaiFor();
    }

    @JsonIgnore
    public void  setLblNinteiKekkaKonkaiFor(Label lblNinteiKekkaKonkaiFor) {
        this.getChushutsuTasho().setLblNinteiKekkaKonkaiFor(lblNinteiKekkaKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiKekkaKonkaiYMDTo() {
        return this.getChushutsuTasho().getTxtNinteiKekkaKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiYMDTo(TextBoxFlexibleDate txtNinteiKekkaKonkaiYMDTo) {
        this.getChushutsuTasho().setTxtNinteiKekkaKonkaiYMDTo(txtNinteiKekkaKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtNinteiKekkaKonkaiTimeTo() {
        return this.getChushutsuTasho().getTxtNinteiKekkaKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtNinteiKekkaKonkaiTimeTo(TextBoxTime txtNinteiKekkaKonkaiTimeTo) {
        this.getChushutsuTasho().setTxtNinteiKekkaKonkaiTimeTo(txtNinteiKekkaKonkaiTimeTo);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizontal1() {
        return this.getChushutsuTasho().getLinHorizontal1();
    }

    @JsonIgnore
    public void  setLinHorizontal1(HorizontalLine linHorizontal1) {
        this.getChushutsuTasho().setLinHorizontal1(linHorizontal1);
    }

    @JsonIgnore
    public Label getLblServiceHenkoTsuchi() {
        return this.getChushutsuTasho().getLblServiceHenkoTsuchi();
    }

    @JsonIgnore
    public void  setLblServiceHenkoTsuchi(Label lblServiceHenkoTsuchi) {
        this.getChushutsuTasho().setLblServiceHenkoTsuchi(lblServiceHenkoTsuchi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtServiceHenkoZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDFrom) {
        this.getChushutsuTasho().setTxtServiceHenkoZenkaiYMDFrom(txtServiceHenkoZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoZenkaiTimeForm() {
        return this.getChushutsuTasho().getTxtServiceHenkoZenkaiTimeForm();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiTimeForm(TextBoxTime txtServiceHenkoZenkaiTimeForm) {
        this.getChushutsuTasho().setTxtServiceHenkoZenkaiTimeForm(txtServiceHenkoZenkaiTimeForm);
    }

    @JsonIgnore
    public Label getLblServiceHenkoZenkaiFor() {
        return this.getChushutsuTasho().getLblServiceHenkoZenkaiFor();
    }

    @JsonIgnore
    public void  setLblServiceHenkoZenkaiFor(Label lblServiceHenkoZenkaiFor) {
        this.getChushutsuTasho().setLblServiceHenkoZenkaiFor(lblServiceHenkoZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoZenkaiYMDTo() {
        return this.getChushutsuTasho().getTxtServiceHenkoZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoZenkaiYMDTo) {
        this.getChushutsuTasho().setTxtServiceHenkoZenkaiYMDTo(txtServiceHenkoZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoZenkaiTimeTo() {
        return this.getChushutsuTasho().getTxtServiceHenkoZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoZenkaiTimeTo(TextBoxTime txtServiceHenkoZenkaiTimeTo) {
        this.getChushutsuTasho().setTxtServiceHenkoZenkaiTimeTo(txtServiceHenkoZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtServiceHenkoKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDFrom) {
        this.getChushutsuTasho().setTxtServiceHenkoKonkaiYMDFrom(txtServiceHenkoKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoKonkaiTimeFrom() {
        return this.getChushutsuTasho().getTxtServiceHenkoKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiTimeFrom(TextBoxTime txtServiceHenkoKonkaiTimeFrom) {
        this.getChushutsuTasho().setTxtServiceHenkoKonkaiTimeFrom(txtServiceHenkoKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblServiceHenkoKonkaiFor() {
        return this.getChushutsuTasho().getLblServiceHenkoKonkaiFor();
    }

    @JsonIgnore
    public void  setLblServiceHenkoKonkaiFor(Label lblServiceHenkoKonkaiFor) {
        this.getChushutsuTasho().setLblServiceHenkoKonkaiFor(lblServiceHenkoKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtServiceHenkoKonkaiYMDTo() {
        return this.getChushutsuTasho().getTxtServiceHenkoKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiYMDTo(TextBoxFlexibleDate txtServiceHenkoKonkaiYMDTo) {
        this.getChushutsuTasho().setTxtServiceHenkoKonkaiYMDTo(txtServiceHenkoKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtServiceHenkoKonkaiTimeTo() {
        return this.getChushutsuTasho().getTxtServiceHenkoKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtServiceHenkoKonkaiTimeTo(TextBoxTime txtServiceHenkoKonkaiTimeTo) {
        this.getChushutsuTasho().setTxtServiceHenkoKonkaiTimeTo(txtServiceHenkoKonkaiTimeTo);
    }

    @JsonIgnore
    public HorizontalLine getLinHorizontal2() {
        return this.getChushutsuTasho().getLinHorizontal2();
    }

    @JsonIgnore
    public void  setLinHorizontal2(HorizontalLine linHorizontal2) {
        this.getChushutsuTasho().setLinHorizontal2(linHorizontal2);
    }

    @JsonIgnore
    public Label getLblYokaigoKubunHenkoTsuchisho() {
        return this.getChushutsuTasho().getLblYokaigoKubunHenkoTsuchisho();
    }

    @JsonIgnore
    public void  setLblYokaigoKubunHenkoTsuchisho(Label lblYokaigoKubunHenkoTsuchisho) {
        this.getChushutsuTasho().setLblYokaigoKubunHenkoTsuchisho(lblYokaigoKubunHenkoTsuchisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtKubunHenkoZenkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDFrom) {
        this.getChushutsuTasho().setTxtKubunHenkoZenkaiYMDFrom(txtKubunHenkoZenkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoZenkaiTimeFrom() {
        return this.getChushutsuTasho().getTxtKubunHenkoZenkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiTimeFrom(TextBoxTime txtKubunHenkoZenkaiTimeFrom) {
        this.getChushutsuTasho().setTxtKubunHenkoZenkaiTimeFrom(txtKubunHenkoZenkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblKubunHenkoZenkaiFor() {
        return this.getChushutsuTasho().getLblKubunHenkoZenkaiFor();
    }

    @JsonIgnore
    public void  setLblKubunHenkoZenkaiFor(Label lblKubunHenkoZenkaiFor) {
        this.getChushutsuTasho().setLblKubunHenkoZenkaiFor(lblKubunHenkoZenkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoZenkaiYMDTo() {
        return this.getChushutsuTasho().getTxtKubunHenkoZenkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoZenkaiYMDTo) {
        this.getChushutsuTasho().setTxtKubunHenkoZenkaiYMDTo(txtKubunHenkoZenkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoZenkaiTimeTo() {
        return this.getChushutsuTasho().getTxtKubunHenkoZenkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoZenkaiTimeTo(TextBoxTime txtKubunHenkoZenkaiTimeTo) {
        this.getChushutsuTasho().setTxtKubunHenkoZenkaiTimeTo(txtKubunHenkoZenkaiTimeTo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDFrom() {
        return this.getChushutsuTasho().getTxtKubunHenkoKonkaiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiYMDFrom(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDFrom) {
        this.getChushutsuTasho().setTxtKubunHenkoKonkaiYMDFrom(txtKubunHenkoKonkaiYMDFrom);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoKonkaiTimeFrom() {
        return this.getChushutsuTasho().getTxtKubunHenkoKonkaiTimeFrom();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiTimeFrom(TextBoxTime txtKubunHenkoKonkaiTimeFrom) {
        this.getChushutsuTasho().setTxtKubunHenkoKonkaiTimeFrom(txtKubunHenkoKonkaiTimeFrom);
    }

    @JsonIgnore
    public Label getLblKubunHenkoKonkaiFor() {
        return this.getChushutsuTasho().getLblKubunHenkoKonkaiFor();
    }

    @JsonIgnore
    public void  setLblKubunHenkoKonkaiFor(Label lblKubunHenkoKonkaiFor) {
        this.getChushutsuTasho().setLblKubunHenkoKonkaiFor(lblKubunHenkoKonkaiFor);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKubunHenkoKonkaiYMDTo() {
        return this.getChushutsuTasho().getTxtKubunHenkoKonkaiYMDTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiYMDTo(TextBoxFlexibleDate txtKubunHenkoKonkaiYMDTo) {
        this.getChushutsuTasho().setTxtKubunHenkoKonkaiYMDTo(txtKubunHenkoKonkaiYMDTo);
    }

    @JsonIgnore
    public TextBoxTime getTxtKubunHenkoKonkaiTimeTo() {
        return this.getChushutsuTasho().getTxtKubunHenkoKonkaiTimeTo();
    }

    @JsonIgnore
    public void  setTxtKubunHenkoKonkaiTimeTo(TextBoxTime txtKubunHenkoKonkaiTimeTo) {
        this.getChushutsuTasho().setTxtKubunHenkoKonkaiTimeTo(txtKubunHenkoKonkaiTimeTo);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuNinteiKekkaBunshoBango() {
        return this.getChushutsuTasho().getCcdIkkatsuNinteiKekkaBunshoBango();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuKubunHenkoBunshoBango() {
        return this.getChushutsuTasho().getCcdIkkatsuKubunHenkoBunshoBango();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdIkkatsuServiceHenkoBunshoBango() {
        return this.getChushutsuTasho().getCcdIkkatsuServiceHenkoBunshoBango();
    }

    // </editor-fold>
}
