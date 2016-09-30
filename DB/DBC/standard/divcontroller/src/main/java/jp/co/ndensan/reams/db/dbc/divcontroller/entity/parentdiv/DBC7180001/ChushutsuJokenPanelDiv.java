package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7180001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
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
    @JsonProperty("linChushutsuJyoken1")
    private HorizontalLine linChushutsuJyoken1;
    @JsonProperty("radSakuseiKubun")
    private RadioButton radSakuseiKubun;
    @JsonProperty("linChushutsuJyoken2")
    private HorizontalLine linChushutsuJyoken2;
    @JsonProperty("txtSabisuTeikyoNengetsu")
    private TextBoxDateRange txtSabisuTeikyoNengetsu;
    @JsonProperty("txtSinsaNengetsu")
    private TextBoxDateRange txtSinsaNengetsu;
    @JsonProperty("txtTorikomiNengetsu")
    private TextBoxDateRange txtTorikomiNengetsu;
    @JsonProperty("ddlSabisuSyurui")
    private DropDownList ddlSabisuSyurui;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;
    @JsonProperty("ccdJigyoshaBango")
    private ShisetsuJohoCommonChildDivDiv ccdJigyoshaBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinChushutsuJyoken1
     * @return linChushutsuJyoken1
     */
    @JsonProperty("linChushutsuJyoken1")
    public HorizontalLine getLinChushutsuJyoken1() {
        return linChushutsuJyoken1;
    }

    /*
     * setlinChushutsuJyoken1
     * @param linChushutsuJyoken1 linChushutsuJyoken1
     */
    @JsonProperty("linChushutsuJyoken1")
    public void setLinChushutsuJyoken1(HorizontalLine linChushutsuJyoken1) {
        this.linChushutsuJyoken1 = linChushutsuJyoken1;
    }

    /*
     * getradSakuseiKubun
     * @return radSakuseiKubun
     */
    @JsonProperty("radSakuseiKubun")
    public RadioButton getRadSakuseiKubun() {
        return radSakuseiKubun;
    }

    /*
     * setradSakuseiKubun
     * @param radSakuseiKubun radSakuseiKubun
     */
    @JsonProperty("radSakuseiKubun")
    public void setRadSakuseiKubun(RadioButton radSakuseiKubun) {
        this.radSakuseiKubun = radSakuseiKubun;
    }

    /*
     * getlinChushutsuJyoken2
     * @return linChushutsuJyoken2
     */
    @JsonProperty("linChushutsuJyoken2")
    public HorizontalLine getLinChushutsuJyoken2() {
        return linChushutsuJyoken2;
    }

    /*
     * setlinChushutsuJyoken2
     * @param linChushutsuJyoken2 linChushutsuJyoken2
     */
    @JsonProperty("linChushutsuJyoken2")
    public void setLinChushutsuJyoken2(HorizontalLine linChushutsuJyoken2) {
        this.linChushutsuJyoken2 = linChushutsuJyoken2;
    }

    /*
     * gettxtSabisuTeikyoNengetsu
     * @return txtSabisuTeikyoNengetsu
     */
    @JsonProperty("txtSabisuTeikyoNengetsu")
    public TextBoxDateRange getTxtSabisuTeikyoNengetsu() {
        return txtSabisuTeikyoNengetsu;
    }

    /*
     * settxtSabisuTeikyoNengetsu
     * @param txtSabisuTeikyoNengetsu txtSabisuTeikyoNengetsu
     */
    @JsonProperty("txtSabisuTeikyoNengetsu")
    public void setTxtSabisuTeikyoNengetsu(TextBoxDateRange txtSabisuTeikyoNengetsu) {
        this.txtSabisuTeikyoNengetsu = txtSabisuTeikyoNengetsu;
    }

    /*
     * gettxtSinsaNengetsu
     * @return txtSinsaNengetsu
     */
    @JsonProperty("txtSinsaNengetsu")
    public TextBoxDateRange getTxtSinsaNengetsu() {
        return txtSinsaNengetsu;
    }

    /*
     * settxtSinsaNengetsu
     * @param txtSinsaNengetsu txtSinsaNengetsu
     */
    @JsonProperty("txtSinsaNengetsu")
    public void setTxtSinsaNengetsu(TextBoxDateRange txtSinsaNengetsu) {
        this.txtSinsaNengetsu = txtSinsaNengetsu;
    }

    /*
     * gettxtTorikomiNengetsu
     * @return txtTorikomiNengetsu
     */
    @JsonProperty("txtTorikomiNengetsu")
    public TextBoxDateRange getTxtTorikomiNengetsu() {
        return txtTorikomiNengetsu;
    }

    /*
     * settxtTorikomiNengetsu
     * @param txtTorikomiNengetsu txtTorikomiNengetsu
     */
    @JsonProperty("txtTorikomiNengetsu")
    public void setTxtTorikomiNengetsu(TextBoxDateRange txtTorikomiNengetsu) {
        this.txtTorikomiNengetsu = txtTorikomiNengetsu;
    }

    /*
     * getddlSabisuSyurui
     * @return ddlSabisuSyurui
     */
    @JsonProperty("ddlSabisuSyurui")
    public DropDownList getDdlSabisuSyurui() {
        return ddlSabisuSyurui;
    }

    /*
     * setddlSabisuSyurui
     * @param ddlSabisuSyurui ddlSabisuSyurui
     */
    @JsonProperty("ddlSabisuSyurui")
    public void setDdlSabisuSyurui(DropDownList ddlSabisuSyurui) {
        this.ddlSabisuSyurui = ddlSabisuSyurui;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * getccdJigyoshaBango
     * @return ccdJigyoshaBango
     */
    @JsonProperty("ccdJigyoshaBango")
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaBango() {
        return ccdJigyoshaBango;
    }

    // </editor-fold>
}
