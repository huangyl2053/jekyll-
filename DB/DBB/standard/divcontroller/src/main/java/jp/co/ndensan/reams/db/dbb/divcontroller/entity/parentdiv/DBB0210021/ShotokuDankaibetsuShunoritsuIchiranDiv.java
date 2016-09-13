package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuDankaibetsuShunoritsuIchiran のクラスファイル
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ShotokuDankaibetsuShunoritsuIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenryoDankaibetsuShunoritsuIchiranBatchParameter")
    private HokenryoDankaibetsuShunoritsuIchiranBatchParameterDiv HokenryoDankaibetsuShunoritsuIchiranBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenryoDankaibetsuShunoritsuIchiranBatchParameter
     * @return HokenryoDankaibetsuShunoritsuIchiranBatchParameter
     */
    @JsonProperty("HokenryoDankaibetsuShunoritsuIchiranBatchParameter")
    public HokenryoDankaibetsuShunoritsuIchiranBatchParameterDiv getHokenryoDankaibetsuShunoritsuIchiranBatchParameter() {
        return HokenryoDankaibetsuShunoritsuIchiranBatchParameter;
    }

    /*
     * setHokenryoDankaibetsuShunoritsuIchiranBatchParameter
     * @param HokenryoDankaibetsuShunoritsuIchiranBatchParameter HokenryoDankaibetsuShunoritsuIchiranBatchParameter
     */
    @JsonProperty("HokenryoDankaibetsuShunoritsuIchiranBatchParameter")
    public void setHokenryoDankaibetsuShunoritsuIchiranBatchParameter(HokenryoDankaibetsuShunoritsuIchiranBatchParameterDiv HokenryoDankaibetsuShunoritsuIchiranBatchParameter) {
        this.HokenryoDankaibetsuShunoritsuIchiranBatchParameter = HokenryoDankaibetsuShunoritsuIchiranBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNendoFrom() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getLblNendoFrom();
    }

    @JsonIgnore
    public void setLblNendoFrom(Label lblNendoFrom) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setLblNendoFrom(lblNendoFrom);
    }

    @JsonIgnore
    public Label getLblNendoTo() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getLblNendoTo();
    }

    @JsonIgnore
    public void setLblNendoTo(Label lblNendoTo) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setLblNendoTo(lblNendoTo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChoteiNendoRange() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getTxtChoteiNendoRange();
    }

    @JsonIgnore
    public void setTxtChoteiNendoRange(TextBoxDateRange txtChoteiNendoRange) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setTxtChoteiNendoRange(txtChoteiNendoRange);
    }

    @JsonIgnore
    public DropDownList getDdlChoteiKijunY() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getDdlChoteiKijunY();
    }

    @JsonIgnore
    public void setDdlChoteiKijunY(DropDownList ddlChoteiKijunY) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setDdlChoteiKijunY(ddlChoteiKijunY);
    }

    @JsonIgnore
    public DropDownList getDdlChoteiKijunM() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getDdlChoteiKijunM();
    }

    @JsonIgnore
    public void setDdlChoteiKijunM(DropDownList ddlChoteiKijunM) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setDdlChoteiKijunM(ddlChoteiKijunM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtFukaNendoRange() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().getTxtFukaNendoRange();
    }

    @JsonIgnore
    public void setTxtFukaNendoRange(TextBoxDateRange txtFukaNendoRange) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuNendoHani().setTxtFukaNendoRange(txtFukaNendoRange);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public JukyuKijunYMDiv getJukyuKijunYM() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getJukyuKijunYM();
    }

    @JsonIgnore
    public void setJukyuKijunYM(JukyuKijunYMDiv JukyuKijunYM) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setJukyuKijunYM(JukyuKijunYM);
    }

    @JsonIgnore
    public DropDownList getDdlJukyuKijunY() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getJukyuKijunYM().getDdlJukyuKijunY();
    }

    @JsonIgnore
    public void setDdlJukyuKijunY(DropDownList ddlJukyuKijunY) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getJukyuKijunYM().setDdlJukyuKijunY(ddlJukyuKijunY);
    }

    @JsonIgnore
    public DropDownList getDdlJukyuKijunM() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getJukyuKijunYM().getDdlJukyuKijunM();
    }

    @JsonIgnore
    public void setDdlJukyuKijunM(DropDownList ddlJukyuKijunM) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getJukyuKijunYM().setDdlJukyuKijunM(ddlJukyuKijunM);
    }

    @JsonIgnore
    public HorizontalLine getLinChushutsuJoken() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getLinChushutsuJoken();
    }

    @JsonIgnore
    public void setLinChushutsuJoken(HorizontalLine linChushutsuJoken) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setLinChushutsuJoken(linChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadNenrei() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getRadNenrei();
    }

    @JsonIgnore
    public void setRadNenrei(RadioButton radNenrei) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setRadNenrei(radNenrei);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtAgeRange() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getTxtAgeRange();
    }

    @JsonIgnore
    public void setTxtAgeRange(TextBoxNumRange txtAgeRange) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setTxtAgeRange(txtAgeRange);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public RadioButton getRadUmareYMD() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getRadUmareYMD();
    }

    @JsonIgnore
    public void setRadUmareYMD(RadioButton radUmareYMD) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setRadUmareYMD(radUmareYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtBirthRange() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getTxtBirthRange();
    }

    @JsonIgnore
    public void setTxtBirthRange(TextBoxDateRange txtBirthRange) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().setTxtBirthRange(txtBirthRange);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getChushutsuJoken().getCcdChikuShichosonSelect();
    }

    @JsonIgnore
    public CheckBoxList getChkKanno() {
        return this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getShutsuryokuTaisho().getChkKanno();
    }

    @JsonIgnore
    public void setChkKanno(CheckBoxList chkKanno) {
        this.getHokenryoDankaibetsuShunoritsuIchiranBatchParameter().getShutsuryokuTaisho().setChkKanno(chkKanno);
    }

    // </editor-fold>
}
