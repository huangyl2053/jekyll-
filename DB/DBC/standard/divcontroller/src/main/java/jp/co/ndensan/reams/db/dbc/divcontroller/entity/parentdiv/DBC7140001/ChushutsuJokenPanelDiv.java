package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuKubun")
    private RadioButton radChushutsuKubun;
    @JsonProperty("ddlSinseiJokyoKubun")
    private DropDownList ddlSinseiJokyoKubun;
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("txtSinseibi")
    private TextBoxDateRange txtSinseibi;
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    private TextBox txtSikyuSinseishoSeiriBangoKaishi;
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    private TextBox txtSikyuSinseishoSeiriBangoShuryo;
    @JsonProperty("txtSofuNengetsu")
    private TextBoxDateRange txtSofuNengetsu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuKubun
     * @return radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public RadioButton getRadChushutsuKubun() {
        return radChushutsuKubun;
    }

    /*
     * setradChushutsuKubun
     * @param radChushutsuKubun radChushutsuKubun
     */
    @JsonProperty("radChushutsuKubun")
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.radChushutsuKubun = radChushutsuKubun;
    }

    /*
     * getddlSinseiJokyoKubun
     * @return ddlSinseiJokyoKubun
     */
    @JsonProperty("ddlSinseiJokyoKubun")
    public DropDownList getDdlSinseiJokyoKubun() {
        return ddlSinseiJokyoKubun;
    }

    /*
     * setddlSinseiJokyoKubun
     * @param ddlSinseiJokyoKubun ddlSinseiJokyoKubun
     */
    @JsonProperty("ddlSinseiJokyoKubun")
    public void setDdlSinseiJokyoKubun(DropDownList ddlSinseiJokyoKubun) {
        this.ddlSinseiJokyoKubun = ddlSinseiJokyoKubun;
    }

    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * gettxtSinseibi
     * @return txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public TextBoxDateRange getTxtSinseibi() {
        return txtSinseibi;
    }

    /*
     * settxtSinseibi
     * @param txtSinseibi txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public void setTxtSinseibi(TextBoxDateRange txtSinseibi) {
        this.txtSinseibi = txtSinseibi;
    }

    /*
     * gettxtSikyuSinseishoSeiriBangoKaishi
     * @return txtSikyuSinseishoSeiriBangoKaishi
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    public TextBox getTxtSikyuSinseishoSeiriBangoKaishi() {
        return txtSikyuSinseishoSeiriBangoKaishi;
    }

    /*
     * settxtSikyuSinseishoSeiriBangoKaishi
     * @param txtSikyuSinseishoSeiriBangoKaishi txtSikyuSinseishoSeiriBangoKaishi
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    public void setTxtSikyuSinseishoSeiriBangoKaishi(TextBox txtSikyuSinseishoSeiriBangoKaishi) {
        this.txtSikyuSinseishoSeiriBangoKaishi = txtSikyuSinseishoSeiriBangoKaishi;
    }

    /*
     * gettxtSikyuSinseishoSeiriBangoShuryo
     * @return txtSikyuSinseishoSeiriBangoShuryo
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    public TextBox getTxtSikyuSinseishoSeiriBangoShuryo() {
        return txtSikyuSinseishoSeiriBangoShuryo;
    }

    /*
     * settxtSikyuSinseishoSeiriBangoShuryo
     * @param txtSikyuSinseishoSeiriBangoShuryo txtSikyuSinseishoSeiriBangoShuryo
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    public void setTxtSikyuSinseishoSeiriBangoShuryo(TextBox txtSikyuSinseishoSeiriBangoShuryo) {
        this.txtSikyuSinseishoSeiriBangoShuryo = txtSikyuSinseishoSeiriBangoShuryo;
    }

    /*
     * gettxtSofuNengetsu
     * @return txtSofuNengetsu
     */
    @JsonProperty("txtSofuNengetsu")
    public TextBoxDateRange getTxtSofuNengetsu() {
        return txtSofuNengetsu;
    }

    /*
     * settxtSofuNengetsu
     * @param txtSofuNengetsu txtSofuNengetsu
     */
    @JsonProperty("txtSofuNengetsu")
    public void setTxtSofuNengetsu(TextBoxDateRange txtSofuNengetsu) {
        this.txtSofuNengetsu = txtSofuNengetsu;
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
