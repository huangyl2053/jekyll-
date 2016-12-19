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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHihokenshaKubun")
    private CheckBoxList chkHihokenshaKubun;
    @JsonProperty("txtNengetsu")
    private TextBoxFlexibleYearMonth txtNengetsu;
    @JsonProperty("ddlGogitaiBango")
    private DropDownList ddlGogitaiBango;
    @JsonProperty("txtTaishoGappi")
    private TextBoxDateRange txtTaishoGappi;
    @JsonProperty("txtKijyunYMD")
    private TextBoxDate txtKijyunYMD;
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
     * gettxtNengetsu
     * @return txtNengetsu
     */
    @JsonProperty("txtNengetsu")
    public TextBoxFlexibleYearMonth getTxtNengetsu() {
        return txtNengetsu;
    }

    /*
     * settxtNengetsu
     * @param txtNengetsu txtNengetsu
     */
    @JsonProperty("txtNengetsu")
    public void setTxtNengetsu(TextBoxFlexibleYearMonth txtNengetsu) {
        this.txtNengetsu = txtNengetsu;
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
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}
