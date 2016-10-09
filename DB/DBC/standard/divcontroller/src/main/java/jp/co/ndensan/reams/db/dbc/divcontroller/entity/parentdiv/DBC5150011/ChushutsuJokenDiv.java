package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.IServiceTypeInputCommonChildDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunYM")
    private TextBoxDate txtKijunYM;
    @JsonProperty("radChushutsuJokenAll")
    private RadioButton radChushutsuJokenAll;
    @JsonProperty("radChushutsuJokenServiceCode")
    private RadioButton radChushutsuJokenServiceCode;
    @JsonProperty("ServiceCodeChushutsuJoken")
    private ServiceCodeChushutsuJokenDiv ServiceCodeChushutsuJoken;
    @JsonProperty("radChushutsuJokenServiceBunrui")
    private RadioButton radChushutsuJokenServiceBunrui;
    @JsonProperty("panServiceSyurui")
    private panServiceSyuruiDiv panServiceSyurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunYM
     * @return txtKijunYM
     */
    @JsonProperty("txtKijunYM")
    public TextBoxDate getTxtKijunYM() {
        return txtKijunYM;
    }

    /*
     * settxtKijunYM
     * @param txtKijunYM txtKijunYM
     */
    @JsonProperty("txtKijunYM")
    public void setTxtKijunYM(TextBoxDate txtKijunYM) {
        this.txtKijunYM = txtKijunYM;
    }

    /*
     * getradChushutsuJokenAll
     * @return radChushutsuJokenAll
     */
    @JsonProperty("radChushutsuJokenAll")
    public RadioButton getRadChushutsuJokenAll() {
        return radChushutsuJokenAll;
    }

    /*
     * setradChushutsuJokenAll
     * @param radChushutsuJokenAll radChushutsuJokenAll
     */
    @JsonProperty("radChushutsuJokenAll")
    public void setRadChushutsuJokenAll(RadioButton radChushutsuJokenAll) {
        this.radChushutsuJokenAll = radChushutsuJokenAll;
    }

    /*
     * getradChushutsuJokenServiceCode
     * @return radChushutsuJokenServiceCode
     */
    @JsonProperty("radChushutsuJokenServiceCode")
    public RadioButton getRadChushutsuJokenServiceCode() {
        return radChushutsuJokenServiceCode;
    }

    /*
     * setradChushutsuJokenServiceCode
     * @param radChushutsuJokenServiceCode radChushutsuJokenServiceCode
     */
    @JsonProperty("radChushutsuJokenServiceCode")
    public void setRadChushutsuJokenServiceCode(RadioButton radChushutsuJokenServiceCode) {
        this.radChushutsuJokenServiceCode = radChushutsuJokenServiceCode;
    }

    /*
     * getServiceCodeChushutsuJoken
     * @return ServiceCodeChushutsuJoken
     */
    @JsonProperty("ServiceCodeChushutsuJoken")
    public ServiceCodeChushutsuJokenDiv getServiceCodeChushutsuJoken() {
        return ServiceCodeChushutsuJoken;
    }

    /*
     * setServiceCodeChushutsuJoken
     * @param ServiceCodeChushutsuJoken ServiceCodeChushutsuJoken
     */
    @JsonProperty("ServiceCodeChushutsuJoken")
    public void setServiceCodeChushutsuJoken(ServiceCodeChushutsuJokenDiv ServiceCodeChushutsuJoken) {
        this.ServiceCodeChushutsuJoken = ServiceCodeChushutsuJoken;
    }

    /*
     * getradChushutsuJokenServiceBunrui
     * @return radChushutsuJokenServiceBunrui
     */
    @JsonProperty("radChushutsuJokenServiceBunrui")
    public RadioButton getRadChushutsuJokenServiceBunrui() {
        return radChushutsuJokenServiceBunrui;
    }

    /*
     * setradChushutsuJokenServiceBunrui
     * @param radChushutsuJokenServiceBunrui radChushutsuJokenServiceBunrui
     */
    @JsonProperty("radChushutsuJokenServiceBunrui")
    public void setRadChushutsuJokenServiceBunrui(RadioButton radChushutsuJokenServiceBunrui) {
        this.radChushutsuJokenServiceBunrui = radChushutsuJokenServiceBunrui;
    }

    /*
     * getpanServiceSyurui
     * @return panServiceSyurui
     */
    @JsonProperty("panServiceSyurui")
    public panServiceSyuruiDiv getPanServiceSyurui() {
        return panServiceSyurui;
    }

    /*
     * setpanServiceSyurui
     * @param panServiceSyurui panServiceSyurui
     */
    @JsonProperty("panServiceSyurui")
    public void setPanServiceSyurui(panServiceSyuruiDiv panServiceSyurui) {
        this.panServiceSyurui = panServiceSyurui;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox get項目() {
        return this.getServiceCodeChushutsuJoken().get項目();
    }

    @JsonIgnore
    public void set項目(TextBox 項目) {
        this.getServiceCodeChushutsuJoken().set項目(項目);
    }

    @JsonIgnore
    public IServiceTypeInputCommonChildDiv getCcdServiceShurui() {
        return this.getServiceCodeChushutsuJoken().getCcdServiceShurui();
    }

    @JsonIgnore
    public DataGrid<dgServiceBunruiList_Row> getDgServiceBunruiList() {
        return this.getPanServiceSyurui().getDgServiceBunruiList();
    }

    @JsonIgnore
    public void setDgServiceBunruiList(DataGrid<dgServiceBunruiList_Row> dgServiceBunruiList) {
        this.getPanServiceSyurui().setDgServiceBunruiList(dgServiceBunruiList);
    }

    // </editor-fold>
}
