package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001;
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
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
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
    @JsonProperty("ddlDetaKubun")
    private DropDownList ddlDetaKubun;
    @JsonProperty("radDataShurui")
    private RadioButton radDataShurui;
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("txtUketoriNengetsu")
    private TextBoxDateRange txtUketoriNengetsu;
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
     * getddlDetaKubun
     * @return ddlDetaKubun
     */
    @JsonProperty("ddlDetaKubun")
    public DropDownList getDdlDetaKubun() {
        return ddlDetaKubun;
    }

    /*
     * setddlDetaKubun
     * @param ddlDetaKubun ddlDetaKubun
     */
    @JsonProperty("ddlDetaKubun")
    public void setDdlDetaKubun(DropDownList ddlDetaKubun) {
        this.ddlDetaKubun = ddlDetaKubun;
    }

    /*
     * getradDataShurui
     * @return radDataShurui
     */
    @JsonProperty("radDataShurui")
    public RadioButton getRadDataShurui() {
        return radDataShurui;
    }

    /*
     * setradDataShurui
     * @param radDataShurui radDataShurui
     */
    @JsonProperty("radDataShurui")
    public void setRadDataShurui(RadioButton radDataShurui) {
        this.radDataShurui = radDataShurui;
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
     * gettxtUketoriNengetsu
     * @return txtUketoriNengetsu
     */
    @JsonProperty("txtUketoriNengetsu")
    public TextBoxDateRange getTxtUketoriNengetsu() {
        return txtUketoriNengetsu;
    }

    /*
     * settxtUketoriNengetsu
     * @param txtUketoriNengetsu txtUketoriNengetsu
     */
    @JsonProperty("txtUketoriNengetsu")
    public void setTxtUketoriNengetsu(TextBoxDateRange txtUketoriNengetsu) {
        this.txtUketoriNengetsu = txtUketoriNengetsu;
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
