package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * CyushutsuJoken のクラスファイル
 *
 * reamsid_L DBB-5660-010 wangxingpeng
 */
public class CyushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTaishosha")
    private CheckBoxList chkTaishosha;
    @JsonProperty("lblCyushutuKikan")
    private Label lblCyushutuKikan;
    @JsonProperty("lblKijyunnengatu")
    private Label lblKijyunnengatu;
    @JsonProperty("txtKijyunnengatu")
    private TextBoxFlexibleDate txtKijyunnengatu;
    @JsonProperty("ddlShikakuKubun")
    private DropDownList ddlShikakuKubun;
    @JsonProperty("ddlShicyouson")
    private DropDownList ddlShicyouson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTaishosha
     * @return chkTaishosha
     */
    @JsonProperty("chkTaishosha")
    public CheckBoxList getChkTaishosha() {
        return chkTaishosha;
    }

    /*
     * setchkTaishosha
     * @param chkTaishosha chkTaishosha
     */
    @JsonProperty("chkTaishosha")
    public void setChkTaishosha(CheckBoxList chkTaishosha) {
        this.chkTaishosha = chkTaishosha;
    }

    /*
     * getlblCyushutuKikan
     * @return lblCyushutuKikan
     */
    @JsonProperty("lblCyushutuKikan")
    public Label getLblCyushutuKikan() {
        return lblCyushutuKikan;
    }

    /*
     * setlblCyushutuKikan
     * @param lblCyushutuKikan lblCyushutuKikan
     */
    @JsonProperty("lblCyushutuKikan")
    public void setLblCyushutuKikan(Label lblCyushutuKikan) {
        this.lblCyushutuKikan = lblCyushutuKikan;
    }

    /*
     * getlblKijyunnengatu
     * @return lblKijyunnengatu
     */
    @JsonProperty("lblKijyunnengatu")
    public Label getLblKijyunnengatu() {
        return lblKijyunnengatu;
    }

    /*
     * setlblKijyunnengatu
     * @param lblKijyunnengatu lblKijyunnengatu
     */
    @JsonProperty("lblKijyunnengatu")
    public void setLblKijyunnengatu(Label lblKijyunnengatu) {
        this.lblKijyunnengatu = lblKijyunnengatu;
    }

    /*
     * gettxtKijyunnengatu
     * @return txtKijyunnengatu
     */
    @JsonProperty("txtKijyunnengatu")
    public TextBoxFlexibleDate getTxtKijyunnengatu() {
        return txtKijyunnengatu;
    }

    /*
     * settxtKijyunnengatu
     * @param txtKijyunnengatu txtKijyunnengatu
     */
    @JsonProperty("txtKijyunnengatu")
    public void setTxtKijyunnengatu(TextBoxFlexibleDate txtKijyunnengatu) {
        this.txtKijyunnengatu = txtKijyunnengatu;
    }

    /*
     * getddlShikakuKubun
     * @return ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public DropDownList getDdlShikakuKubun() {
        return ddlShikakuKubun;
    }

    /*
     * setddlShikakuKubun
     * @param ddlShikakuKubun ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public void setDdlShikakuKubun(DropDownList ddlShikakuKubun) {
        this.ddlShikakuKubun = ddlShikakuKubun;
    }

    /*
     * getddlShicyouson
     * @return ddlShicyouson
     */
    @JsonProperty("ddlShicyouson")
    public DropDownList getDdlShicyouson() {
        return ddlShicyouson;
    }

    /*
     * setddlShicyouson
     * @param ddlShicyouson ddlShicyouson
     */
    @JsonProperty("ddlShicyouson")
    public void setDdlShicyouson(DropDownList ddlShicyouson) {
        this.ddlShicyouson = ddlShicyouson;
    }

    // </editor-fold>
}
