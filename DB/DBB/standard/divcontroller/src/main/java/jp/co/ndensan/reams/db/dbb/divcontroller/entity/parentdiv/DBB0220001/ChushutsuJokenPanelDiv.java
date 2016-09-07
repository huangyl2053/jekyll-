package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShikakuKubun")
    private DropDownList ddlShikakuKubun;
    @JsonProperty("ddlJukyushaHantei")
    private DropDownList ddlJukyushaHantei;
    @JsonProperty("ddlChosyuHoho")
    private DropDownList ddlChosyuHoho;
    @JsonProperty("chkHokenryoDankai")
    private CheckBoxList chkHokenryoDankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShikakuKubun
     * @return ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public DropDownList getDdlShikakuKubun() {
        return ddlShikakuKubun;
    }

    /*
     * setddlShikakuKubun
     * @param ddlShikakuKubun ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public void setDdlShikakuKubun(DropDownList ddlShikakuKubun) {
        this.ddlShikakuKubun = ddlShikakuKubun;
    }

    /*
     * getddlJukyushaHantei
     * @return ddlJukyushaHantei
     */
    @JsonProperty("ddlJukyushaHantei")
    public DropDownList getDdlJukyushaHantei() {
        return ddlJukyushaHantei;
    }

    /*
     * setddlJukyushaHantei
     * @param ddlJukyushaHantei ddlJukyushaHantei
     */
    @JsonProperty("ddlJukyushaHantei")
    public void setDdlJukyushaHantei(DropDownList ddlJukyushaHantei) {
        this.ddlJukyushaHantei = ddlJukyushaHantei;
    }

    /*
     * getddlChosyuHoho
     * @return ddlChosyuHoho
     */
    @JsonProperty("ddlChosyuHoho")
    public DropDownList getDdlChosyuHoho() {
        return ddlChosyuHoho;
    }

    /*
     * setddlChosyuHoho
     * @param ddlChosyuHoho ddlChosyuHoho
     */
    @JsonProperty("ddlChosyuHoho")
    public void setDdlChosyuHoho(DropDownList ddlChosyuHoho) {
        this.ddlChosyuHoho = ddlChosyuHoho;
    }

    /*
     * getchkHokenryoDankai
     * @return chkHokenryoDankai
     */
    @JsonProperty("chkHokenryoDankai")
    public CheckBoxList getChkHokenryoDankai() {
        return chkHokenryoDankai;
    }

    /*
     * setchkHokenryoDankai
     * @param chkHokenryoDankai chkHokenryoDankai
     */
    @JsonProperty("chkHokenryoDankai")
    public void setChkHokenryoDankai(CheckBoxList chkHokenryoDankai) {
        this.chkHokenryoDankai = chkHokenryoDankai;
    }

    // </editor-fold>
}
