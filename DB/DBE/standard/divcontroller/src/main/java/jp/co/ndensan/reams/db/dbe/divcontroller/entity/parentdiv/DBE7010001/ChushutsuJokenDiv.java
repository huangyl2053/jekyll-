package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHihokenshaKubun")
    private CheckBoxList chkHihokenshaKubun;
    @JsonProperty("txtTaishoNendo")
    private TextBoxDate txtTaishoNendo;
    @JsonProperty("ddlGogitaiBango")
    private DropDownList ddlGogitaiBango;
    @JsonProperty("chkModifyTaishoTsuki")
    private CheckBoxList chkModifyTaishoTsuki;
    @JsonProperty("ddlTsuki")
    private DropDownList ddlTsuki;
    @JsonProperty("txtKijyunYMD")
    private TextBoxDate txtKijyunYMD;
    @JsonProperty("chkModifyTaishoGeppi")
    private CheckBoxList chkModifyTaishoGeppi;
    @JsonProperty("txtTaishoGappi")
    private TextBoxDateRange txtTaishoGappi;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkHihokenshaKubun
     * @return chkHihokenshaKubun
     */
    @JsonProperty("chkHihokenshaKubun")
    public CheckBoxList getChkHihokenshaKubun() {
        return chkHihokenshaKubun;
    }

    /*
     * setchkHihokenshaKubun
     * @param chkHihokenshaKubun chkHihokenshaKubun
     */
    @JsonProperty("chkHihokenshaKubun")
    public void setChkHihokenshaKubun(CheckBoxList chkHihokenshaKubun) {
        this.chkHihokenshaKubun = chkHihokenshaKubun;
    }

    /*
     * gettxtTaishoNendo
     * @return txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public TextBoxDate getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    /*
     * settxtTaishoNendo
     * @param txtTaishoNendo txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.txtTaishoNendo = txtTaishoNendo;
    }

    /*
     * getddlGogitaiBango
     * @return ddlGogitaiBango
     */
    @JsonProperty("ddlGogitaiBango")
    public DropDownList getDdlGogitaiBango() {
        return ddlGogitaiBango;
    }

    /*
     * setddlGogitaiBango
     * @param ddlGogitaiBango ddlGogitaiBango
     */
    @JsonProperty("ddlGogitaiBango")
    public void setDdlGogitaiBango(DropDownList ddlGogitaiBango) {
        this.ddlGogitaiBango = ddlGogitaiBango;
    }

    /*
     * getchkModifyTaishoTsuki
     * @return chkModifyTaishoTsuki
     */
    @JsonProperty("chkModifyTaishoTsuki")
    public CheckBoxList getChkModifyTaishoTsuki() {
        return chkModifyTaishoTsuki;
    }

    /*
     * setchkModifyTaishoTsuki
     * @param chkModifyTaishoTsuki chkModifyTaishoTsuki
     */
    @JsonProperty("chkModifyTaishoTsuki")
    public void setChkModifyTaishoTsuki(CheckBoxList chkModifyTaishoTsuki) {
        this.chkModifyTaishoTsuki = chkModifyTaishoTsuki;
    }

    /*
     * getddlTsuki
     * @return ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public DropDownList getDdlTsuki() {
        return ddlTsuki;
    }

    /*
     * setddlTsuki
     * @param ddlTsuki ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.ddlTsuki = ddlTsuki;
    }

    /*
     * gettxtKijyunYMD
     * @return txtKijyunYMD
     */
    @JsonProperty("txtKijyunYMD")
    public TextBoxDate getTxtKijyunYMD() {
        return txtKijyunYMD;
    }

    /*
     * settxtKijyunYMD
     * @param txtKijyunYMD txtKijyunYMD
     */
    @JsonProperty("txtKijyunYMD")
    public void setTxtKijyunYMD(TextBoxDate txtKijyunYMD) {
        this.txtKijyunYMD = txtKijyunYMD;
    }

    /*
     * getchkModifyTaishoGeppi
     * @return chkModifyTaishoGeppi
     */
    @JsonProperty("chkModifyTaishoGeppi")
    public CheckBoxList getChkModifyTaishoGeppi() {
        return chkModifyTaishoGeppi;
    }

    /*
     * setchkModifyTaishoGeppi
     * @param chkModifyTaishoGeppi chkModifyTaishoGeppi
     */
    @JsonProperty("chkModifyTaishoGeppi")
    public void setChkModifyTaishoGeppi(CheckBoxList chkModifyTaishoGeppi) {
        this.chkModifyTaishoGeppi = chkModifyTaishoGeppi;
    }

    /*
     * gettxtTaishoGappi
     * @return txtTaishoGappi
     */
    @JsonProperty("txtTaishoGappi")
    public TextBoxDateRange getTxtTaishoGappi() {
        return txtTaishoGappi;
    }

    /*
     * settxtTaishoGappi
     * @param txtTaishoGappi txtTaishoGappi
     */
    @JsonProperty("txtTaishoGappi")
    public void setTxtTaishoGappi(TextBoxDateRange txtTaishoGappi) {
        this.txtTaishoGappi = txtTaishoGappi;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
