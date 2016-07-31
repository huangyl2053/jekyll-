package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.IKogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplJudgementResult のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class tplJudgementResultDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKogakuKyufuTaishoList")
    private KogakuKyufuTaishoListDiv ccdKogakuKyufuTaishoList;
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("txtHonninShiharaiGaku")
    private TextBoxNum txtHonninShiharaiGaku;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("rdbShikyuKubun")
    private RadioButton rdbShikyuKubun;
    @JsonProperty("rdbShinsaHohoKubun")
    private RadioButton rdbShinsaHohoKubun;
    @JsonProperty("txtSetaiSyuyakuBango")
    private TextBox txtSetaiSyuyakuBango;
    @JsonProperty("txtShikyuKingaku")
    private TextBoxNum txtShikyuKingaku;
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    private RadioButton rdbKogakuJidoSyokanTaisyo;
    @JsonProperty("txtShikyusinaiRiyu")
    private TextBoxMultiLine txtShikyusinaiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKogakuKyufuTaishoList
     * @return ccdKogakuKyufuTaishoList
     */
    @JsonProperty("ccdKogakuKyufuTaishoList")
    public IKogakuKyufuTaishoListDiv getCcdKogakuKyufuTaishoList() {
        return ccdKogakuKyufuTaishoList;
    }

    /*
     * gettxtUketsukeYMD
     * @return txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public TextBoxDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    /*
     * settxtUketsukeYMD
     * @param txtUketsukeYMD txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.txtUketsukeYMD = txtUketsukeYMD;
    }

    /*
     * gettxtHonninShiharaiGaku
     * @return txtHonninShiharaiGaku
     */
    @JsonProperty("txtHonninShiharaiGaku")
    public TextBoxNum getTxtHonninShiharaiGaku() {
        return txtHonninShiharaiGaku;
    }

    /*
     * settxtHonninShiharaiGaku
     * @param txtHonninShiharaiGaku txtHonninShiharaiGaku
     */
    @JsonProperty("txtHonninShiharaiGaku")
    public void setTxtHonninShiharaiGaku(TextBoxNum txtHonninShiharaiGaku) {
        this.txtHonninShiharaiGaku = txtHonninShiharaiGaku;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getrdbShikyuKubun
     * @return rdbShikyuKubun
     */
    @JsonProperty("rdbShikyuKubun")
    public RadioButton getRdbShikyuKubun() {
        return rdbShikyuKubun;
    }

    /*
     * setrdbShikyuKubun
     * @param rdbShikyuKubun rdbShikyuKubun
     */
    @JsonProperty("rdbShikyuKubun")
    public void setRdbShikyuKubun(RadioButton rdbShikyuKubun) {
        this.rdbShikyuKubun = rdbShikyuKubun;
    }

    /*
     * getrdbShinsaHohoKubun
     * @return rdbShinsaHohoKubun
     */
    @JsonProperty("rdbShinsaHohoKubun")
    public RadioButton getRdbShinsaHohoKubun() {
        return rdbShinsaHohoKubun;
    }

    /*
     * setrdbShinsaHohoKubun
     * @param rdbShinsaHohoKubun rdbShinsaHohoKubun
     */
    @JsonProperty("rdbShinsaHohoKubun")
    public void setRdbShinsaHohoKubun(RadioButton rdbShinsaHohoKubun) {
        this.rdbShinsaHohoKubun = rdbShinsaHohoKubun;
    }

    /*
     * gettxtSetaiSyuyakuBango
     * @return txtSetaiSyuyakuBango
     */
    @JsonProperty("txtSetaiSyuyakuBango")
    public TextBox getTxtSetaiSyuyakuBango() {
        return txtSetaiSyuyakuBango;
    }

    /*
     * settxtSetaiSyuyakuBango
     * @param txtSetaiSyuyakuBango txtSetaiSyuyakuBango
     */
    @JsonProperty("txtSetaiSyuyakuBango")
    public void setTxtSetaiSyuyakuBango(TextBox txtSetaiSyuyakuBango) {
        this.txtSetaiSyuyakuBango = txtSetaiSyuyakuBango;
    }

    /*
     * gettxtShikyuKingaku
     * @return txtShikyuKingaku
     */
    @JsonProperty("txtShikyuKingaku")
    public TextBoxNum getTxtShikyuKingaku() {
        return txtShikyuKingaku;
    }

    /*
     * settxtShikyuKingaku
     * @param txtShikyuKingaku txtShikyuKingaku
     */
    @JsonProperty("txtShikyuKingaku")
    public void setTxtShikyuKingaku(TextBoxNum txtShikyuKingaku) {
        this.txtShikyuKingaku = txtShikyuKingaku;
    }

    /*
     * getrdbKogakuJidoSyokanTaisyo
     * @return rdbKogakuJidoSyokanTaisyo
     */
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    public RadioButton getRdbKogakuJidoSyokanTaisyo() {
        return rdbKogakuJidoSyokanTaisyo;
    }

    /*
     * setrdbKogakuJidoSyokanTaisyo
     * @param rdbKogakuJidoSyokanTaisyo rdbKogakuJidoSyokanTaisyo
     */
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    public void setRdbKogakuJidoSyokanTaisyo(RadioButton rdbKogakuJidoSyokanTaisyo) {
        this.rdbKogakuJidoSyokanTaisyo = rdbKogakuJidoSyokanTaisyo;
    }

    /*
     * gettxtShikyusinaiRiyu
     * @return txtShikyusinaiRiyu
     */
    @JsonProperty("txtShikyusinaiRiyu")
    public TextBoxMultiLine getTxtShikyusinaiRiyu() {
        return txtShikyusinaiRiyu;
    }

    /*
     * settxtShikyusinaiRiyu
     * @param txtShikyusinaiRiyu txtShikyusinaiRiyu
     */
    @JsonProperty("txtShikyusinaiRiyu")
    public void setTxtShikyusinaiRiyu(TextBoxMultiLine txtShikyusinaiRiyu) {
        this.txtShikyusinaiRiyu = txtShikyusinaiRiyu;
    }

    // </editor-fold>
}
