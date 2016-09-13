package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KaigoHihokensha のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KaigoHihokenshaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShotokuKubun")
    private DropDownList ddlShotokuKubun;
    @JsonProperty("ddlOver70ShotokuKubun")
    private DropDownList ddlOver70ShotokuKubun;
    @JsonProperty("txtShikakuSoshitsuYMD")
    private TextBoxDate txtShikakuSoshitsuYMD;
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    private DropDownList ddlShikakuSoshitsuJiyu;
    @JsonProperty("txtTaishoKeisanKikanYMD")
    private TextBoxDateRange txtTaishoKeisanKikanYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShotokuKubun
     * @return ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public DropDownList getDdlShotokuKubun() {
        return ddlShotokuKubun;
    }

    /*
     * setddlShotokuKubun
     * @param ddlShotokuKubun ddlShotokuKubun
     */
    @JsonProperty("ddlShotokuKubun")
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.ddlShotokuKubun = ddlShotokuKubun;
    }

    /*
     * getddlOver70ShotokuKubun
     * @return ddlOver70ShotokuKubun
     */
    @JsonProperty("ddlOver70ShotokuKubun")
    public DropDownList getDdlOver70ShotokuKubun() {
        return ddlOver70ShotokuKubun;
    }

    /*
     * setddlOver70ShotokuKubun
     * @param ddlOver70ShotokuKubun ddlOver70ShotokuKubun
     */
    @JsonProperty("ddlOver70ShotokuKubun")
    public void setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.ddlOver70ShotokuKubun = ddlOver70ShotokuKubun;
    }

    /*
     * gettxtShikakuSoshitsuYMD
     * @return txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return txtShikakuSoshitsuYMD;
    }

    /*
     * settxtShikakuSoshitsuYMD
     * @param txtShikakuSoshitsuYMD txtShikakuSoshitsuYMD
     */
    @JsonProperty("txtShikakuSoshitsuYMD")
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.txtShikakuSoshitsuYMD = txtShikakuSoshitsuYMD;
    }

    /*
     * getddlShikakuSoshitsuJiyu
     * @return ddlShikakuSoshitsuJiyu
     */
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return ddlShikakuSoshitsuJiyu;
    }

    /*
     * setddlShikakuSoshitsuJiyu
     * @param ddlShikakuSoshitsuJiyu ddlShikakuSoshitsuJiyu
     */
    @JsonProperty("ddlShikakuSoshitsuJiyu")
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.ddlShikakuSoshitsuJiyu = ddlShikakuSoshitsuJiyu;
    }

    /*
     * gettxtTaishoKeisanKikanYMD
     * @return txtTaishoKeisanKikanYMD
     */
    @JsonProperty("txtTaishoKeisanKikanYMD")
    public TextBoxDateRange getTxtTaishoKeisanKikanYMD() {
        return txtTaishoKeisanKikanYMD;
    }

    /*
     * settxtTaishoKeisanKikanYMD
     * @param txtTaishoKeisanKikanYMD txtTaishoKeisanKikanYMD
     */
    @JsonProperty("txtTaishoKeisanKikanYMD")
    public void setTxtTaishoKeisanKikanYMD(TextBoxDateRange txtTaishoKeisanKikanYMD) {
        this.txtTaishoKeisanKikanYMD = txtTaishoKeisanKikanYMD;
    }

    // </editor-fold>
}
