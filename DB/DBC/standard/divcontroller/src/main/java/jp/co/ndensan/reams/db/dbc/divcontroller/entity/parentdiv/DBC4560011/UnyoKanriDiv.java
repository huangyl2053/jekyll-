package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4560011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * UnyoKanri のクラスファイル
 *
 * @reamsid_L DBC-5820-010 tianshuai
 */
public class UnyoKanriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHonninMishinkokuKubun")
    private DropDownList ddlHonninMishinkokuKubun;
    @JsonProperty("ddlHonninShutokuChosachuKubun")
    private DropDownList ddlHonninShutokuChosachuKubun;
    @JsonProperty("txtNenjiFutanWariaiShoriZumiNendo")
    private TextBoxDate txtNenjiFutanWariaiShoriZumiNendo;
    @JsonProperty("ddlNenjiFutanWariaiShoriJotai")
    private DropDownList ddlNenjiFutanWariaiShoriJotai;
    @JsonProperty("hdnHonninMishinkokuKubun")
    private RString hdnHonninMishinkokuKubun;
    @JsonProperty("hdnHonninShutokuChosachuKubun")
    private RString hdnHonninShutokuChosachuKubun;
    @JsonProperty("hdnNenjiFutanWariaiShoriJotai")
    private RString hdnNenjiFutanWariaiShoriJotai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHonninMishinkokuKubun
     * @return ddlHonninMishinkokuKubun
     */
    @JsonProperty("ddlHonninMishinkokuKubun")
    public DropDownList getDdlHonninMishinkokuKubun() {
        return ddlHonninMishinkokuKubun;
    }

    /*
     * setddlHonninMishinkokuKubun
     * @param ddlHonninMishinkokuKubun ddlHonninMishinkokuKubun
     */
    @JsonProperty("ddlHonninMishinkokuKubun")
    public void setDdlHonninMishinkokuKubun(DropDownList ddlHonninMishinkokuKubun) {
        this.ddlHonninMishinkokuKubun = ddlHonninMishinkokuKubun;
    }

    /*
     * getddlHonninShutokuChosachuKubun
     * @return ddlHonninShutokuChosachuKubun
     */
    @JsonProperty("ddlHonninShutokuChosachuKubun")
    public DropDownList getDdlHonninShutokuChosachuKubun() {
        return ddlHonninShutokuChosachuKubun;
    }

    /*
     * setddlHonninShutokuChosachuKubun
     * @param ddlHonninShutokuChosachuKubun ddlHonninShutokuChosachuKubun
     */
    @JsonProperty("ddlHonninShutokuChosachuKubun")
    public void setDdlHonninShutokuChosachuKubun(DropDownList ddlHonninShutokuChosachuKubun) {
        this.ddlHonninShutokuChosachuKubun = ddlHonninShutokuChosachuKubun;
    }

    /*
     * gettxtNenjiFutanWariaiShoriZumiNendo
     * @return txtNenjiFutanWariaiShoriZumiNendo
     */
    @JsonProperty("txtNenjiFutanWariaiShoriZumiNendo")
    public TextBoxDate getTxtNenjiFutanWariaiShoriZumiNendo() {
        return txtNenjiFutanWariaiShoriZumiNendo;
    }

    /*
     * settxtNenjiFutanWariaiShoriZumiNendo
     * @param txtNenjiFutanWariaiShoriZumiNendo txtNenjiFutanWariaiShoriZumiNendo
     */
    @JsonProperty("txtNenjiFutanWariaiShoriZumiNendo")
    public void setTxtNenjiFutanWariaiShoriZumiNendo(TextBoxDate txtNenjiFutanWariaiShoriZumiNendo) {
        this.txtNenjiFutanWariaiShoriZumiNendo = txtNenjiFutanWariaiShoriZumiNendo;
    }

    /*
     * getddlNenjiFutanWariaiShoriJotai
     * @return ddlNenjiFutanWariaiShoriJotai
     */
    @JsonProperty("ddlNenjiFutanWariaiShoriJotai")
    public DropDownList getDdlNenjiFutanWariaiShoriJotai() {
        return ddlNenjiFutanWariaiShoriJotai;
    }

    /*
     * setddlNenjiFutanWariaiShoriJotai
     * @param ddlNenjiFutanWariaiShoriJotai ddlNenjiFutanWariaiShoriJotai
     */
    @JsonProperty("ddlNenjiFutanWariaiShoriJotai")
    public void setDdlNenjiFutanWariaiShoriJotai(DropDownList ddlNenjiFutanWariaiShoriJotai) {
        this.ddlNenjiFutanWariaiShoriJotai = ddlNenjiFutanWariaiShoriJotai;
    }

    /*
     * gethdnHonninMishinkokuKubun
     * @return hdnHonninMishinkokuKubun
     */
    @JsonProperty("hdnHonninMishinkokuKubun")
    public RString getHdnHonninMishinkokuKubun() {
        return hdnHonninMishinkokuKubun;
    }

    /*
     * sethdnHonninMishinkokuKubun
     * @param hdnHonninMishinkokuKubun hdnHonninMishinkokuKubun
     */
    @JsonProperty("hdnHonninMishinkokuKubun")
    public void setHdnHonninMishinkokuKubun(RString hdnHonninMishinkokuKubun) {
        this.hdnHonninMishinkokuKubun = hdnHonninMishinkokuKubun;
    }

    /*
     * gethdnHonninShutokuChosachuKubun
     * @return hdnHonninShutokuChosachuKubun
     */
    @JsonProperty("hdnHonninShutokuChosachuKubun")
    public RString getHdnHonninShutokuChosachuKubun() {
        return hdnHonninShutokuChosachuKubun;
    }

    /*
     * sethdnHonninShutokuChosachuKubun
     * @param hdnHonninShutokuChosachuKubun hdnHonninShutokuChosachuKubun
     */
    @JsonProperty("hdnHonninShutokuChosachuKubun")
    public void setHdnHonninShutokuChosachuKubun(RString hdnHonninShutokuChosachuKubun) {
        this.hdnHonninShutokuChosachuKubun = hdnHonninShutokuChosachuKubun;
    }

    /*
     * gethdnNenjiFutanWariaiShoriJotai
     * @return hdnNenjiFutanWariaiShoriJotai
     */
    @JsonProperty("hdnNenjiFutanWariaiShoriJotai")
    public RString getHdnNenjiFutanWariaiShoriJotai() {
        return hdnNenjiFutanWariaiShoriJotai;
    }

    /*
     * sethdnNenjiFutanWariaiShoriJotai
     * @param hdnNenjiFutanWariaiShoriJotai hdnNenjiFutanWariaiShoriJotai
     */
    @JsonProperty("hdnNenjiFutanWariaiShoriJotai")
    public void setHdnNenjiFutanWariaiShoriJotai(RString hdnNenjiFutanWariaiShoriJotai) {
        this.hdnNenjiFutanWariaiShoriJotai = hdnNenjiFutanWariaiShoriJotai;
    }

    // </editor-fold>
}
