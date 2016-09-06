package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoshaSearch")
    private RadioButton radTaishoshaSearch;
    @JsonProperty("txtZenkaiUketoriYM")
    private TextBoxFlexibleDate txtZenkaiUketoriYM;
    @JsonProperty("txtZenkaiUketoriDate")
    private TextBoxFlexibleDate txtZenkaiUketoriDate;
    @JsonProperty("txtZenkaiUketoriTime")
    private TextBoxTime txtZenkaiUketoriTime;
    @JsonProperty("txtUketoriYM")
    private TextBoxFlexibleDate txtUketoriYM;
    @JsonProperty("radHihokenshaNoShitei")
    private RadioButton radHihokenshaNoShitei;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("btnHihokenshaSearch")
    private ButtonDialog btnHihokenshaSearch;
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoshaSearch
     * @return radTaishoshaSearch
     */
    @JsonProperty("radTaishoshaSearch")
    public RadioButton getRadTaishoshaSearch() {
        return radTaishoshaSearch;
    }

    /*
     * setradTaishoshaSearch
     * @param radTaishoshaSearch radTaishoshaSearch
     */
    @JsonProperty("radTaishoshaSearch")
    public void setRadTaishoshaSearch(RadioButton radTaishoshaSearch) {
        this.radTaishoshaSearch = radTaishoshaSearch;
    }

    /*
     * gettxtZenkaiUketoriYM
     * @return txtZenkaiUketoriYM
     */
    @JsonProperty("txtZenkaiUketoriYM")
    public TextBoxFlexibleDate getTxtZenkaiUketoriYM() {
        return txtZenkaiUketoriYM;
    }

    /*
     * settxtZenkaiUketoriYM
     * @param txtZenkaiUketoriYM txtZenkaiUketoriYM
     */
    @JsonProperty("txtZenkaiUketoriYM")
    public void setTxtZenkaiUketoriYM(TextBoxFlexibleDate txtZenkaiUketoriYM) {
        this.txtZenkaiUketoriYM = txtZenkaiUketoriYM;
    }

    /*
     * gettxtZenkaiUketoriDate
     * @return txtZenkaiUketoriDate
     */
    @JsonProperty("txtZenkaiUketoriDate")
    public TextBoxFlexibleDate getTxtZenkaiUketoriDate() {
        return txtZenkaiUketoriDate;
    }

    /*
     * settxtZenkaiUketoriDate
     * @param txtZenkaiUketoriDate txtZenkaiUketoriDate
     */
    @JsonProperty("txtZenkaiUketoriDate")
    public void setTxtZenkaiUketoriDate(TextBoxFlexibleDate txtZenkaiUketoriDate) {
        this.txtZenkaiUketoriDate = txtZenkaiUketoriDate;
    }

    /*
     * gettxtZenkaiUketoriTime
     * @return txtZenkaiUketoriTime
     */
    @JsonProperty("txtZenkaiUketoriTime")
    public TextBoxTime getTxtZenkaiUketoriTime() {
        return txtZenkaiUketoriTime;
    }

    /*
     * settxtZenkaiUketoriTime
     * @param txtZenkaiUketoriTime txtZenkaiUketoriTime
     */
    @JsonProperty("txtZenkaiUketoriTime")
    public void setTxtZenkaiUketoriTime(TextBoxTime txtZenkaiUketoriTime) {
        this.txtZenkaiUketoriTime = txtZenkaiUketoriTime;
    }

    /*
     * gettxtUketoriYM
     * @return txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public TextBoxFlexibleDate getTxtUketoriYM() {
        return txtUketoriYM;
    }

    /*
     * settxtUketoriYM
     * @param txtUketoriYM txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public void setTxtUketoriYM(TextBoxFlexibleDate txtUketoriYM) {
        this.txtUketoriYM = txtUketoriYM;
    }

    /*
     * getradHihokenshaNoShitei
     * @return radHihokenshaNoShitei
     */
    @JsonProperty("radHihokenshaNoShitei")
    public RadioButton getRadHihokenshaNoShitei() {
        return radHihokenshaNoShitei;
    }

    /*
     * setradHihokenshaNoShitei
     * @param radHihokenshaNoShitei radHihokenshaNoShitei
     */
    @JsonProperty("radHihokenshaNoShitei")
    public void setRadHihokenshaNoShitei(RadioButton radHihokenshaNoShitei) {
        this.radHihokenshaNoShitei = radHihokenshaNoShitei;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokenshaSearch
     * @return btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public ButtonDialog getBtnHihokenshaSearch() {
        return btnHihokenshaSearch;
    }

    /*
     * setbtnHihokenshaSearch
     * @param btnHihokenshaSearch btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public void setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.btnHihokenshaSearch = btnHihokenshaSearch;
    }

    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    // </editor-fold>
}
