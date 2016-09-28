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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HokenryoDankaibetsuShunoritsuIchiranBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class HokenryoDankaibetsuShunoritsuIchiranBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuNendoHani")
    private ChushutsuNendoHaniDiv ChushutsuNendoHani;
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ShutsuryokuTaisho")
    private ShutsuryokuTaishoDiv ShutsuryokuTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuNendoHani
     * @return ChushutsuNendoHani
     */
    @JsonProperty("ChushutsuNendoHani")
    public ChushutsuNendoHaniDiv getChushutsuNendoHani() {
        return ChushutsuNendoHani;
    }

    /*
     * setChushutsuNendoHani
     * @param ChushutsuNendoHani ChushutsuNendoHani
     */
    @JsonProperty("ChushutsuNendoHani")
    public void setChushutsuNendoHani(ChushutsuNendoHaniDiv ChushutsuNendoHani) {
        this.ChushutsuNendoHani = ChushutsuNendoHani;
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
     * getShutsuryokuTaisho
     * @return ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public ShutsuryokuTaishoDiv getShutsuryokuTaisho() {
        return ShutsuryokuTaisho;
    }

    /*
     * setShutsuryokuTaisho
     * @param ShutsuryokuTaisho ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public void setShutsuryokuTaisho(ShutsuryokuTaishoDiv ShutsuryokuTaisho) {
        this.ShutsuryokuTaisho = ShutsuryokuTaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblNendoFrom() {
        return this.getChushutsuNendoHani().getLblNendoFrom();
    }

    @JsonIgnore
    public void setLblNendoFrom(Label lblNendoFrom) {
        this.getChushutsuNendoHani().setLblNendoFrom(lblNendoFrom);
    }

    @JsonIgnore
    public Label getLblNendoTo() {
        return this.getChushutsuNendoHani().getLblNendoTo();
    }

    @JsonIgnore
    public void setLblNendoTo(Label lblNendoTo) {
        this.getChushutsuNendoHani().setLblNendoTo(lblNendoTo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChoteiNendoRange() {
        return this.getChushutsuNendoHani().getTxtChoteiNendoRange();
    }

    @JsonIgnore
    public void setTxtChoteiNendoRange(TextBoxDateRange txtChoteiNendoRange) {
        this.getChushutsuNendoHani().setTxtChoteiNendoRange(txtChoteiNendoRange);
    }

    @JsonIgnore
    public DropDownList getDdlChoteiKijunY() {
        return this.getChushutsuNendoHani().getDdlChoteiKijunY();
    }

    @JsonIgnore
    public void setDdlChoteiKijunY(DropDownList ddlChoteiKijunY) {
        this.getChushutsuNendoHani().setDdlChoteiKijunY(ddlChoteiKijunY);
    }

    @JsonIgnore
    public DropDownList getDdlChoteiKijunM() {
        return this.getChushutsuNendoHani().getDdlChoteiKijunM();
    }

    @JsonIgnore
    public void setDdlChoteiKijunM(DropDownList ddlChoteiKijunM) {
        this.getChushutsuNendoHani().setDdlChoteiKijunM(ddlChoteiKijunM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtFukaNendoRange() {
        return this.getChushutsuNendoHani().getTxtFukaNendoRange();
    }

    @JsonIgnore
    public void setTxtFukaNendoRange(TextBoxDateRange txtFukaNendoRange) {
        this.getChushutsuNendoHani().setTxtFukaNendoRange(txtFukaNendoRange);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public JukyuKijunYMDiv getJukyuKijunYM() {
        return this.getChushutsuJoken().getJukyuKijunYM();
    }

    @JsonIgnore
    public void setJukyuKijunYM(JukyuKijunYMDiv JukyuKijunYM) {
        this.getChushutsuJoken().setJukyuKijunYM(JukyuKijunYM);
    }

    @JsonIgnore
    public DropDownList getDdlJukyuKijunY() {
        return this.getChushutsuJoken().getJukyuKijunYM().getDdlJukyuKijunY();
    }

    @JsonIgnore
    public void setDdlJukyuKijunY(DropDownList ddlJukyuKijunY) {
        this.getChushutsuJoken().getJukyuKijunYM().setDdlJukyuKijunY(ddlJukyuKijunY);
    }

    @JsonIgnore
    public DropDownList getDdlJukyuKijunM() {
        return this.getChushutsuJoken().getJukyuKijunYM().getDdlJukyuKijunM();
    }

    @JsonIgnore
    public void setDdlJukyuKijunM(DropDownList ddlJukyuKijunM) {
        this.getChushutsuJoken().getJukyuKijunYM().setDdlJukyuKijunM(ddlJukyuKijunM);
    }

    @JsonIgnore
    public HorizontalLine getLinChushutsuJoken() {
        return this.getChushutsuJoken().getLinChushutsuJoken();
    }

    @JsonIgnore
    public void setLinChushutsuJoken(HorizontalLine linChushutsuJoken) {
        this.getChushutsuJoken().setLinChushutsuJoken(linChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadNenrei() {
        return this.getChushutsuJoken().getRadNenrei();
    }

    @JsonIgnore
    public void setRadNenrei(RadioButton radNenrei) {
        this.getChushutsuJoken().setRadNenrei(radNenrei);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtAgeRange() {
        return this.getChushutsuJoken().getTxtAgeRange();
    }

    @JsonIgnore
    public void setTxtAgeRange(TextBoxNumRange txtAgeRange) {
        this.getChushutsuJoken().setTxtAgeRange(txtAgeRange);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunYMD() {
        return this.getChushutsuJoken().getTxtNenreiKijunYMD();
    }

    @JsonIgnore
    public void setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.getChushutsuJoken().setTxtNenreiKijunYMD(txtNenreiKijunYMD);
    }

    @JsonIgnore
    public RadioButton getRadUmareYMD() {
        return this.getChushutsuJoken().getRadUmareYMD();
    }

    @JsonIgnore
    public void setRadUmareYMD(RadioButton radUmareYMD) {
        this.getChushutsuJoken().setRadUmareYMD(radUmareYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtBirthRange() {
        return this.getChushutsuJoken().getTxtBirthRange();
    }

    @JsonIgnore
    public void setTxtBirthRange(TextBoxDateRange txtBirthRange) {
        this.getChushutsuJoken().setTxtBirthRange(txtBirthRange);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return this.getChushutsuJoken().getCcdChikuShichosonSelect();
    }

    @JsonIgnore
    public CheckBoxList getChkKanno() {
        return this.getShutsuryokuTaisho().getChkKanno();
    }

    @JsonIgnore
    public void setChkKanno(CheckBoxList chkKanno) {
        this.getShutsuryokuTaisho().setChkKanno(chkKanno);
    }

    // </editor-fold>
}
