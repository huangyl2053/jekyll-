package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNumRange;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuJoken")
    private RadioButton radChushutsuJoken;
    @JsonProperty("JukyuKijunYM")
    private JukyuKijunYMDiv JukyuKijunYM;
    @JsonProperty("linChushutsuJoken")
    private HorizontalLine linChushutsuJoken;
    @JsonProperty("radNenrei")
    private RadioButton radNenrei;
    @JsonProperty("txtAgeRange")
    private TextBoxNumRange txtAgeRange;
    @JsonProperty("txtNenreiKijunYMD")
    private TextBoxDate txtNenreiKijunYMD;
    @JsonProperty("radUmareYMD")
    private RadioButton radUmareYMD;
    @JsonProperty("txtBirthRange")
    private TextBoxDateRange txtBirthRange;
    @JsonProperty("ccdChikuShichosonSelect")
    private ChikuShichosonSelectDiv ccdChikuShichosonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuJoken
     * @return radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public RadioButton getRadChushutsuJoken() {
        return radChushutsuJoken;
    }

    /*
     * setradChushutsuJoken
     * @param radChushutsuJoken radChushutsuJoken
     */
    @JsonProperty("radChushutsuJoken")
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.radChushutsuJoken = radChushutsuJoken;
    }

    /*
     * getJukyuKijunYM
     * @return JukyuKijunYM
     */
    @JsonProperty("JukyuKijunYM")
    public JukyuKijunYMDiv getJukyuKijunYM() {
        return JukyuKijunYM;
    }

    /*
     * setJukyuKijunYM
     * @param JukyuKijunYM JukyuKijunYM
     */
    @JsonProperty("JukyuKijunYM")
    public void setJukyuKijunYM(JukyuKijunYMDiv JukyuKijunYM) {
        this.JukyuKijunYM = JukyuKijunYM;
    }

    /*
     * getlinChushutsuJoken
     * @return linChushutsuJoken
     */
    @JsonProperty("linChushutsuJoken")
    public HorizontalLine getLinChushutsuJoken() {
        return linChushutsuJoken;
    }

    /*
     * setlinChushutsuJoken
     * @param linChushutsuJoken linChushutsuJoken
     */
    @JsonProperty("linChushutsuJoken")
    public void setLinChushutsuJoken(HorizontalLine linChushutsuJoken) {
        this.linChushutsuJoken = linChushutsuJoken;
    }

    /*
     * getradNenrei
     * @return radNenrei
     */
    @JsonProperty("radNenrei")
    public RadioButton getRadNenrei() {
        return radNenrei;
    }

    /*
     * setradNenrei
     * @param radNenrei radNenrei
     */
    @JsonProperty("radNenrei")
    public void setRadNenrei(RadioButton radNenrei) {
        this.radNenrei = radNenrei;
    }

    /*
     * gettxtAgeRange
     * @return txtAgeRange
     */
    @JsonProperty("txtAgeRange")
    public TextBoxNumRange getTxtAgeRange() {
        return txtAgeRange;
    }

    /*
     * settxtAgeRange
     * @param txtAgeRange txtAgeRange
     */
    @JsonProperty("txtAgeRange")
    public void setTxtAgeRange(TextBoxNumRange txtAgeRange) {
        this.txtAgeRange = txtAgeRange;
    }

    /*
     * gettxtNenreiKijunYMD
     * @return txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public TextBoxDate getTxtNenreiKijunYMD() {
        return txtNenreiKijunYMD;
    }

    /*
     * settxtNenreiKijunYMD
     * @param txtNenreiKijunYMD txtNenreiKijunYMD
     */
    @JsonProperty("txtNenreiKijunYMD")
    public void setTxtNenreiKijunYMD(TextBoxDate txtNenreiKijunYMD) {
        this.txtNenreiKijunYMD = txtNenreiKijunYMD;
    }

    /*
     * getradUmareYMD
     * @return radUmareYMD
     */
    @JsonProperty("radUmareYMD")
    public RadioButton getRadUmareYMD() {
        return radUmareYMD;
    }

    /*
     * setradUmareYMD
     * @param radUmareYMD radUmareYMD
     */
    @JsonProperty("radUmareYMD")
    public void setRadUmareYMD(RadioButton radUmareYMD) {
        this.radUmareYMD = radUmareYMD;
    }

    /*
     * gettxtBirthRange
     * @return txtBirthRange
     */
    @JsonProperty("txtBirthRange")
    public TextBoxDateRange getTxtBirthRange() {
        return txtBirthRange;
    }

    /*
     * settxtBirthRange
     * @param txtBirthRange txtBirthRange
     */
    @JsonProperty("txtBirthRange")
    public void setTxtBirthRange(TextBoxDateRange txtBirthRange) {
        this.txtBirthRange = txtBirthRange;
    }

    /*
     * getccdChikuShichosonSelect
     * @return ccdChikuShichosonSelect
     */
    @JsonProperty("ccdChikuShichosonSelect")
    public IChikuShichosonSelectDiv getCcdChikuShichosonSelect() {
        return ccdChikuShichosonSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlJukyuKijunY() {
        return this.getJukyuKijunYM().getDdlJukyuKijunY();
    }

    @JsonIgnore
    public void setDdlJukyuKijunY(DropDownList ddlJukyuKijunY) {
        this.getJukyuKijunYM().setDdlJukyuKijunY(ddlJukyuKijunY);
    }

    @JsonIgnore
    public DropDownList getDdlJukyuKijunM() {
        return this.getJukyuKijunYM().getDdlJukyuKijunM();
    }

    @JsonIgnore
    public void setDdlJukyuKijunM(DropDownList ddlJukyuKijunM) {
        this.getJukyuKijunYM().setDdlJukyuKijunM(ddlJukyuKijunM);
    }

    // </editor-fold>
}
