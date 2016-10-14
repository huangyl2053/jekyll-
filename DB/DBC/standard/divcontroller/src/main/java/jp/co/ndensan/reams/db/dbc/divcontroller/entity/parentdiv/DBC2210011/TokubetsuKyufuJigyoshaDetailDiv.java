package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailCode")
    private TokubetsuKyufuJigyoshaDetailCodeDiv TokubetsuKyufuJigyoshaDetailCode;
    @JsonProperty("ddlHojinShubetsu")
    private DropDownList ddlHojinShubetsu;
    @JsonProperty("radIdoKubun")
    private RadioButton radIdoKubun;
    @JsonProperty("txtIdoYMD")
    private TextBoxDate txtIdoYMD;
    @JsonProperty("txtBiko")
    private TextBox txtBiko;
    @JsonProperty("tabTokubetsuKyufuJigyoshaDetail")
    private tabTokubetsuKyufuJigyoshaDetailDiv tabTokubetsuKyufuJigyoshaDetail;
    @JsonProperty("btnSaveTemp")
    private Button btnSaveTemp;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuKyufuJigyoshaDetailCode
     * @return TokubetsuKyufuJigyoshaDetailCode
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailCode")
    public TokubetsuKyufuJigyoshaDetailCodeDiv getTokubetsuKyufuJigyoshaDetailCode() {
        return TokubetsuKyufuJigyoshaDetailCode;
    }

    /*
     * setTokubetsuKyufuJigyoshaDetailCode
     * @param TokubetsuKyufuJigyoshaDetailCode TokubetsuKyufuJigyoshaDetailCode
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailCode")
    public void setTokubetsuKyufuJigyoshaDetailCode(TokubetsuKyufuJigyoshaDetailCodeDiv TokubetsuKyufuJigyoshaDetailCode) {
        this.TokubetsuKyufuJigyoshaDetailCode = TokubetsuKyufuJigyoshaDetailCode;
    }

    /*
     * getddlHojinShubetsu
     * @return ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public DropDownList getDdlHojinShubetsu() {
        return ddlHojinShubetsu;
    }

    /*
     * setddlHojinShubetsu
     * @param ddlHojinShubetsu ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public void setDdlHojinShubetsu(DropDownList ddlHojinShubetsu) {
        this.ddlHojinShubetsu = ddlHojinShubetsu;
    }

    /*
     * getradIdoKubun
     * @return radIdoKubun
     */
    @JsonProperty("radIdoKubun")
    public RadioButton getRadIdoKubun() {
        return radIdoKubun;
    }

    /*
     * setradIdoKubun
     * @param radIdoKubun radIdoKubun
     */
    @JsonProperty("radIdoKubun")
    public void setRadIdoKubun(RadioButton radIdoKubun) {
        this.radIdoKubun = radIdoKubun;
    }

    /*
     * gettxtIdoYMD
     * @return txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public TextBoxDate getTxtIdoYMD() {
        return txtIdoYMD;
    }

    /*
     * settxtIdoYMD
     * @param txtIdoYMD txtIdoYMD
     */
    @JsonProperty("txtIdoYMD")
    public void setTxtIdoYMD(TextBoxDate txtIdoYMD) {
        this.txtIdoYMD = txtIdoYMD;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBox getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBox txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * gettabTokubetsuKyufuJigyoshaDetail
     * @return tabTokubetsuKyufuJigyoshaDetail
     */
    @JsonProperty("tabTokubetsuKyufuJigyoshaDetail")
    public tabTokubetsuKyufuJigyoshaDetailDiv getTabTokubetsuKyufuJigyoshaDetail() {
        return tabTokubetsuKyufuJigyoshaDetail;
    }

    /*
     * settabTokubetsuKyufuJigyoshaDetail
     * @param tabTokubetsuKyufuJigyoshaDetail tabTokubetsuKyufuJigyoshaDetail
     */
    @JsonProperty("tabTokubetsuKyufuJigyoshaDetail")
    public void setTabTokubetsuKyufuJigyoshaDetail(tabTokubetsuKyufuJigyoshaDetailDiv tabTokubetsuKyufuJigyoshaDetail) {
        this.tabTokubetsuKyufuJigyoshaDetail = tabTokubetsuKyufuJigyoshaDetail;
    }

    /*
     * getbtnSaveTemp
     * @return btnSaveTemp
     */
    @JsonProperty("btnSaveTemp")
    public Button getBtnSaveTemp() {
        return btnSaveTemp;
    }

    /*
     * setbtnSaveTemp
     * @param btnSaveTemp btnSaveTemp
     */
    @JsonProperty("btnSaveTemp")
    public void setBtnSaveTemp(Button btnSaveTemp) {
        this.btnSaveTemp = btnSaveTemp;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShinseiDiv getTplShinsei() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei();
    }

    @JsonIgnore
    public void  setTplShinsei(tplShinseiDiv tplShinsei) {
        this.getTabTokubetsuKyufuJigyoshaDetail().setTplShinsei(tplShinsei);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailShinseishaDiv getTokubetsuKyufuJigyoshaDetailShinseisha() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailShinseisha();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailShinseisha(TokubetsuKyufuJigyoshaDetailShinseishaDiv TokubetsuKyufuJigyoshaDetailShinseisha) {
        this.getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().setTokubetsuKyufuJigyoshaDetailShinseisha(TokubetsuKyufuJigyoshaDetailShinseisha);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailDaihyoshaDiv getTokubetsuKyufuJigyoshaDetailDaihyosha() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().getTokubetsuKyufuJigyoshaDetailDaihyosha();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailDaihyosha(TokubetsuKyufuJigyoshaDetailDaihyoshaDiv TokubetsuKyufuJigyoshaDetailDaihyosha) {
        this.getTabTokubetsuKyufuJigyoshaDetail().getTplShinsei().setTokubetsuKyufuJigyoshaDetailDaihyosha(TokubetsuKyufuJigyoshaDetailDaihyosha);
    }

    @JsonIgnore
    public tplServiceDiv getTplService() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplService();
    }

    @JsonIgnore
    public void  setTplService(tplServiceDiv tplService) {
        this.getTabTokubetsuKyufuJigyoshaDetail().setTplService(tplService);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailServiceListDiv getTokubetsuKyufuJigyoshaDetailServiceList() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceList();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailServiceList(TokubetsuKyufuJigyoshaDetailServiceListDiv TokubetsuKyufuJigyoshaDetailServiceList) {
        this.getTabTokubetsuKyufuJigyoshaDetail().getTplService().setTokubetsuKyufuJigyoshaDetailServiceList(TokubetsuKyufuJigyoshaDetailServiceList);
    }

    @JsonIgnore
    public TokubetsuKyufuJigyoshaDetailServiceInfoDiv getTokubetsuKyufuJigyoshaDetailServiceInfo() {
        return this.getTabTokubetsuKyufuJigyoshaDetail().getTplService().getTokubetsuKyufuJigyoshaDetailServiceInfo();
    }

    @JsonIgnore
    public void  setTokubetsuKyufuJigyoshaDetailServiceInfo(TokubetsuKyufuJigyoshaDetailServiceInfoDiv TokubetsuKyufuJigyoshaDetailServiceInfo) {
        this.getTabTokubetsuKyufuJigyoshaDetail().getTplService().setTokubetsuKyufuJigyoshaDetailServiceInfo(TokubetsuKyufuJigyoshaDetailServiceInfo);
    }

    // </editor-fold>
}
