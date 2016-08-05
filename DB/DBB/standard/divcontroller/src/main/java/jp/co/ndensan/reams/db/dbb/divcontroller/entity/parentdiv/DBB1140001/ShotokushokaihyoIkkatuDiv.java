package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokushokaihyoIkkatu のクラスファイル
 *
 * @reamsid_L DBB-1720-010 lijunjun
 */
public class ShotokushokaihyoIkkatuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriNendo")
    private DropDownList ddlShoriNendo;
    @JsonProperty("txtShokaiYMD")
    private TextBoxDate txtShokaiYMD;
    @JsonProperty("chkTestPrint")
    private CheckBoxList chkTestPrint;
    @JsonProperty("lblMassege")
    private Label lblMassege;
    @JsonProperty("linShotokushokai1")
    private HorizontalLine linShotokushokai1;
    @JsonProperty("chkShuturyokuTaisho")
    private CheckBoxList chkShuturyokuTaisho;
    @JsonProperty("chkSaihakko")
    private CheckBoxList chkSaihakko;
    @JsonProperty("dgSaihakko")
    private DataGrid<dgSaihakko_Row> dgSaihakko;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShoriNendo
     * @return ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public DropDownList getDdlShoriNendo() {
        return ddlShoriNendo;
    }

    /*
     * setddlShoriNendo
     * @param ddlShoriNendo ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.ddlShoriNendo = ddlShoriNendo;
    }

    /*
     * gettxtShokaiYMD
     * @return txtShokaiYMD
     */
    @JsonProperty("txtShokaiYMD")
    public TextBoxDate getTxtShokaiYMD() {
        return txtShokaiYMD;
    }

    /*
     * settxtShokaiYMD
     * @param txtShokaiYMD txtShokaiYMD
     */
    @JsonProperty("txtShokaiYMD")
    public void setTxtShokaiYMD(TextBoxDate txtShokaiYMD) {
        this.txtShokaiYMD = txtShokaiYMD;
    }

    /*
     * getchkTestPrint
     * @return chkTestPrint
     */
    @JsonProperty("chkTestPrint")
    public CheckBoxList getChkTestPrint() {
        return chkTestPrint;
    }

    /*
     * setchkTestPrint
     * @param chkTestPrint chkTestPrint
     */
    @JsonProperty("chkTestPrint")
    public void setChkTestPrint(CheckBoxList chkTestPrint) {
        this.chkTestPrint = chkTestPrint;
    }

    /*
     * getlblMassege
     * @return lblMassege
     */
    @JsonProperty("lblMassege")
    public Label getLblMassege() {
        return lblMassege;
    }

    /*
     * setlblMassege
     * @param lblMassege lblMassege
     */
    @JsonProperty("lblMassege")
    public void setLblMassege(Label lblMassege) {
        this.lblMassege = lblMassege;
    }

    /*
     * getlinShotokushokai1
     * @return linShotokushokai1
     */
    @JsonProperty("linShotokushokai1")
    public HorizontalLine getLinShotokushokai1() {
        return linShotokushokai1;
    }

    /*
     * setlinShotokushokai1
     * @param linShotokushokai1 linShotokushokai1
     */
    @JsonProperty("linShotokushokai1")
    public void setLinShotokushokai1(HorizontalLine linShotokushokai1) {
        this.linShotokushokai1 = linShotokushokai1;
    }

    /*
     * getchkShuturyokuTaisho
     * @return chkShuturyokuTaisho
     */
    @JsonProperty("chkShuturyokuTaisho")
    public CheckBoxList getChkShuturyokuTaisho() {
        return chkShuturyokuTaisho;
    }

    /*
     * setchkShuturyokuTaisho
     * @param chkShuturyokuTaisho chkShuturyokuTaisho
     */
    @JsonProperty("chkShuturyokuTaisho")
    public void setChkShuturyokuTaisho(CheckBoxList chkShuturyokuTaisho) {
        this.chkShuturyokuTaisho = chkShuturyokuTaisho;
    }

    /*
     * getchkSaihakko
     * @return chkSaihakko
     */
    @JsonProperty("chkSaihakko")
    public CheckBoxList getChkSaihakko() {
        return chkSaihakko;
    }

    /*
     * setchkSaihakko
     * @param chkSaihakko chkSaihakko
     */
    @JsonProperty("chkSaihakko")
    public void setChkSaihakko(CheckBoxList chkSaihakko) {
        this.chkSaihakko = chkSaihakko;
    }

    /*
     * getdgSaihakko
     * @return dgSaihakko
     */
    @JsonProperty("dgSaihakko")
    public DataGrid<dgSaihakko_Row> getDgSaihakko() {
        return dgSaihakko;
    }

    /*
     * setdgSaihakko
     * @param dgSaihakko dgSaihakko
     */
    @JsonProperty("dgSaihakko")
    public void setDgSaihakko(DataGrid<dgSaihakko_Row> dgSaihakko) {
        this.dgSaihakko = dgSaihakko;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
}
