package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NendoKijumbiSitei のクラスファイル
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class NendoKijumbiSiteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChoteiNendo")
    private DropDownList ddlChoteiNendo;
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("chkKijyunbiSiteiUmu")
    private CheckBoxList chkKijyunbiSiteiUmu;
    @JsonProperty("txtKijyunbi")
    private TextBoxDate txtKijyunbi;
    @JsonProperty("radKijumbiSentaku")
    private RadioButton radKijumbiSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChoteiNendo
     * @return ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public DropDownList getDdlChoteiNendo() {
        return ddlChoteiNendo;
    }

    /*
     * setddlChoteiNendo
     * @param ddlChoteiNendo ddlChoteiNendo
     */
    @JsonProperty("ddlChoteiNendo")
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.ddlChoteiNendo = ddlChoteiNendo;
    }

    /*
     * getddlFukaNendo
     * @return ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    /*
     * setddlFukaNendo
     * @param ddlFukaNendo ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo = ddlFukaNendo;
    }

    /*
     * getchkKijyunbiSiteiUmu
     * @return chkKijyunbiSiteiUmu
     */
    @JsonProperty("chkKijyunbiSiteiUmu")
    public CheckBoxList getChkKijyunbiSiteiUmu() {
        return chkKijyunbiSiteiUmu;
    }

    /*
     * setchkKijyunbiSiteiUmu
     * @param chkKijyunbiSiteiUmu chkKijyunbiSiteiUmu
     */
    @JsonProperty("chkKijyunbiSiteiUmu")
    public void setChkKijyunbiSiteiUmu(CheckBoxList chkKijyunbiSiteiUmu) {
        this.chkKijyunbiSiteiUmu = chkKijyunbiSiteiUmu;
    }

    /*
     * gettxtKijyunbi
     * @return txtKijyunbi
     */
    @JsonProperty("txtKijyunbi")
    public TextBoxDate getTxtKijyunbi() {
        return txtKijyunbi;
    }

    /*
     * settxtKijyunbi
     * @param txtKijyunbi txtKijyunbi
     */
    @JsonProperty("txtKijyunbi")
    public void setTxtKijyunbi(TextBoxDate txtKijyunbi) {
        this.txtKijyunbi = txtKijyunbi;
    }

    /*
     * getradKijumbiSentaku
     * @return radKijumbiSentaku
     */
    @JsonProperty("radKijumbiSentaku")
    public RadioButton getRadKijumbiSentaku() {
        return radKijumbiSentaku;
    }

    /*
     * setradKijumbiSentaku
     * @param radKijumbiSentaku radKijumbiSentaku
     */
    @JsonProperty("radKijumbiSentaku")
    public void setRadKijumbiSentaku(RadioButton radKijumbiSentaku) {
        this.radKijumbiSentaku = radKijumbiSentaku;
    }

    // </editor-fold>
}
