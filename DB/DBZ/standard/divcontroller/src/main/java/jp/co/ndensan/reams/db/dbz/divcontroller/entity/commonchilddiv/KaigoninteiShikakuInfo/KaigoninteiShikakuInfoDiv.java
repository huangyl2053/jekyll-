package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * KaigoninteiShikakuInfo のクラスファイル
 *
 * @reamsid_L DBZ-1300-060 lizhuoxuan
 */
public class KaigoninteiShikakuInfoDiv extends Panel implements IKaigoninteiShikakuInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShutokuYmd")
    private TextBoxFlexibleDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxFlexibleDate txtSoshitsuYmd;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("txtJutokuKubun")
    private TextBox txtJutokuKubun;
    @JsonProperty("txtYokaigoJotaiKubun")
    private TextBox txtYokaigoJotaiKubun;
    @JsonProperty("txtNinteiKaishiYmd")
    private TextBoxDate txtNinteiKaishiYmd;
    @JsonProperty("txtNinteiShuryoYmd")
    private TextBoxDate txtNinteiShuryoYmd;
    @JsonProperty("txtHookenshaCode")
    private TextBoxCode txtHookenshaCode;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("hdnShinchsonCode")
    private RString hdnShinchsonCode;
    @JsonProperty("hdnHihokenShaNo")
    private RString hdnHihokenShaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtShutokuYmd
     * @return txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public TextBoxFlexibleDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    /*
     * settxtShutokuYmd
     * @param txtShutokuYmd txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxFlexibleDate txtShutokuYmd) {
        this.txtShutokuYmd = txtShutokuYmd;
    }

    /*
     * gettxtShutokuJiyu
     * @return txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    /*
     * settxtShutokuJiyu
     * @param txtShutokuJiyu txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu = txtShutokuJiyu;
    }

    /*
     * gettxtSoshitsuYmd
     * @return txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public TextBoxFlexibleDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    /*
     * settxtSoshitsuYmd
     * @param txtSoshitsuYmd txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxFlexibleDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd = txtSoshitsuYmd;
    }

    /*
     * gettxtSoshitsuJiyu
     * @return txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    /*
     * settxtSoshitsuJiyu
     * @param txtSoshitsuJiyu txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu = txtSoshitsuJiyu;
    }

    /*
     * gettxtJutokuKubun
     * @return txtJutokuKubun
     */
    @JsonProperty("txtJutokuKubun")
    public TextBox getTxtJutokuKubun() {
        return txtJutokuKubun;
    }

    /*
     * settxtJutokuKubun
     * @param txtJutokuKubun txtJutokuKubun
     */
    @JsonProperty("txtJutokuKubun")
    public void setTxtJutokuKubun(TextBox txtJutokuKubun) {
        this.txtJutokuKubun = txtJutokuKubun;
    }

    /*
     * gettxtYokaigoJotaiKubun
     * @return txtYokaigoJotaiKubun
     */
    @JsonProperty("txtYokaigoJotaiKubun")
    public TextBox getTxtYokaigoJotaiKubun() {
        return txtYokaigoJotaiKubun;
    }

    /*
     * settxtYokaigoJotaiKubun
     * @param txtYokaigoJotaiKubun txtYokaigoJotaiKubun
     */
    @JsonProperty("txtYokaigoJotaiKubun")
    public void setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.txtYokaigoJotaiKubun = txtYokaigoJotaiKubun;
    }

    /*
     * gettxtNinteiKaishiYmd
     * @return txtNinteiKaishiYmd
     */
    @JsonProperty("txtNinteiKaishiYmd")
    public TextBoxDate getTxtNinteiKaishiYmd() {
        return txtNinteiKaishiYmd;
    }

    /*
     * settxtNinteiKaishiYmd
     * @param txtNinteiKaishiYmd txtNinteiKaishiYmd
     */
    @JsonProperty("txtNinteiKaishiYmd")
    public void setTxtNinteiKaishiYmd(TextBoxDate txtNinteiKaishiYmd) {
        this.txtNinteiKaishiYmd = txtNinteiKaishiYmd;
    }

    /*
     * gettxtNinteiShuryoYmd
     * @return txtNinteiShuryoYmd
     */
    @JsonProperty("txtNinteiShuryoYmd")
    public TextBoxDate getTxtNinteiShuryoYmd() {
        return txtNinteiShuryoYmd;
    }

    /*
     * settxtNinteiShuryoYmd
     * @param txtNinteiShuryoYmd txtNinteiShuryoYmd
     */
    @JsonProperty("txtNinteiShuryoYmd")
    public void setTxtNinteiShuryoYmd(TextBoxDate txtNinteiShuryoYmd) {
        this.txtNinteiShuryoYmd = txtNinteiShuryoYmd;
    }

    /*
     * gettxtHookenshaCode
     * @return txtHookenshaCode
     */
    @JsonProperty("txtHookenshaCode")
    public TextBoxCode getTxtHookenshaCode() {
        return txtHookenshaCode;
    }

    /*
     * settxtHookenshaCode
     * @param txtHookenshaCode txtHookenshaCode
     */
    @JsonProperty("txtHookenshaCode")
    public void setTxtHookenshaCode(TextBoxCode txtHookenshaCode) {
        this.txtHookenshaCode = txtHookenshaCode;
    }

    /*
     * gettxtHokensha
     * @return txtHokensha
     */
    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    /*
     * settxtHokensha
     * @param txtHokensha txtHokensha
     */
    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha = txtHokensha;
    }

    /*
     * gethdnShinchsonCode
     * @return hdnShinchsonCode
     */
    @JsonProperty("hdnShinchsonCode")
    public RString getHdnShinchsonCode() {
        return hdnShinchsonCode;
    }

    /*
     * sethdnShinchsonCode
     * @param hdnShinchsonCode hdnShinchsonCode
     */
    @JsonProperty("hdnShinchsonCode")
    public void setHdnShinchsonCode(RString hdnShinchsonCode) {
        this.hdnShinchsonCode = hdnShinchsonCode;
    }

    /*
     * gethdnHihokenShaNo
     * @return hdnHihokenShaNo
     */
    @JsonProperty("hdnHihokenShaNo")
    public RString getHdnHihokenShaNo() {
        return hdnHihokenShaNo;
    }

    /*
     * sethdnHihokenShaNo
     * @param hdnHihokenShaNo hdnHihokenShaNo
     */
    @JsonProperty("hdnHihokenShaNo")
    public void setHdnHihokenShaNo(RString hdnHihokenShaNo) {
        this.hdnHihokenShaNo = hdnHihokenShaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString hdnShinchsonCode, RString hdnHihokenShaNo) {
        getHandler().initialize(hdnShinchsonCode, hdnHihokenShaNo);
    }

    @Override
    public TextBox getTxtYokaigodo() {
        return txtYokaigoJotaiKubun;
    }

    @Override
    public RString getHookenshaCode() {
        return txtHookenshaCode.getValue();
    }

    @Override
    public RString getHokensha() {
        return txtHokensha.getValue();
    }

    private KaigoNinteiShikakuInfoHandler getHandler() {
        return new KaigoNinteiShikakuInfoHandler(this);
    }

}
