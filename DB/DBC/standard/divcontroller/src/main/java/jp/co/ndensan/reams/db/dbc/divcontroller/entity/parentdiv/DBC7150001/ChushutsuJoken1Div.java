package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * ChushutsuJoken1 のクラスファイル
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class ChushutsuJoken1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuKubun")
    private RadioButton radChushutsuKubun;
    @JsonProperty("ddlDetaSakuseiKubun")
    private DropDownList ddlDetaSakuseiKubun;
    @JsonProperty("radDataShurui")
    private RadioButton radDataShurui;
    @JsonProperty("radHoseuJokyo")
    private RadioButton radHoseuJokyo;

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
     * getddlDetaSakuseiKubun
     * @return ddlDetaSakuseiKubun
     */
    @JsonProperty("ddlDetaSakuseiKubun")
    public DropDownList getDdlDetaSakuseiKubun() {
        return ddlDetaSakuseiKubun;
    }

    /*
     * setddlDetaSakuseiKubun
     * @param ddlDetaSakuseiKubun ddlDetaSakuseiKubun
     */
    @JsonProperty("ddlDetaSakuseiKubun")
    public void setDdlDetaSakuseiKubun(DropDownList ddlDetaSakuseiKubun) {
        this.ddlDetaSakuseiKubun = ddlDetaSakuseiKubun;
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
     * getradHoseuJokyo
     * @return radHoseuJokyo
     */
    @JsonProperty("radHoseuJokyo")
    public RadioButton getRadHoseuJokyo() {
        return radHoseuJokyo;
    }

    /*
     * setradHoseuJokyo
     * @param radHoseuJokyo radHoseuJokyo
     */
    @JsonProperty("radHoseuJokyo")
    public void setRadHoseuJokyo(RadioButton radHoseuJokyo) {
        this.radHoseuJokyo = radHoseuJokyo;
    }

    // </editor-fold>
}
