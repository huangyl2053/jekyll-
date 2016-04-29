package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShikakuSoshitsuInput のクラスファイル
 *
 */
public class ShikakuSoshitsuInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;
    @JsonProperty("txtShutokuTodokedeDate")
    private TextBoxFlexibleDate txtShutokuTodokedeDate;
    @JsonProperty("ddlShikakuShutokuJiyu")
    private DropDownList ddlShikakuShutokuJiyu;
    @JsonProperty("btnShikakuSoshitsuKakutei")
    private Button btnShikakuSoshitsuKakutei;
    @JsonProperty("btnShikakuSoshitsuTorikeshi")
    private Button btnShikakuSoshitsuTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShutokuDate
     * @return txtShutokuDate
     */
    @JsonProperty("txtShutokuDate")
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return txtShutokuDate;
    }

    /*
     * settxtShutokuDate
     * @param txtShutokuDate txtShutokuDate
     */
    @JsonProperty("txtShutokuDate")
    public void setTxtShutokuDate(TextBoxFlexibleDate txtShutokuDate) {
        this.txtShutokuDate = txtShutokuDate;
    }

    /*
     * gettxtShutokuTodokedeDate
     * @return txtShutokuTodokedeDate
     */
    @JsonProperty("txtShutokuTodokedeDate")
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return txtShutokuTodokedeDate;
    }

    /*
     * settxtShutokuTodokedeDate
     * @param txtShutokuTodokedeDate txtShutokuTodokedeDate
     */
    @JsonProperty("txtShutokuTodokedeDate")
    public void setTxtShutokuTodokedeDate(TextBoxFlexibleDate txtShutokuTodokedeDate) {
        this.txtShutokuTodokedeDate = txtShutokuTodokedeDate;
    }

    /*
     * getddlShikakuShutokuJiyu
     * @return ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public DropDownList getDdlShikakuShutokuJiyu() {
        return ddlShikakuShutokuJiyu;
    }

    /*
     * setddlShikakuShutokuJiyu
     * @param ddlShikakuShutokuJiyu ddlShikakuShutokuJiyu
     */
    @JsonProperty("ddlShikakuShutokuJiyu")
    public void setDdlShikakuShutokuJiyu(DropDownList ddlShikakuShutokuJiyu) {
        this.ddlShikakuShutokuJiyu = ddlShikakuShutokuJiyu;
    }

    /*
     * getbtnShikakuSoshitsuKakutei
     * @return btnShikakuSoshitsuKakutei
     */
    @JsonProperty("btnShikakuSoshitsuKakutei")
    public Button getBtnShikakuSoshitsuKakutei() {
        return btnShikakuSoshitsuKakutei;
    }

    /*
     * setbtnShikakuSoshitsuKakutei
     * @param btnShikakuSoshitsuKakutei btnShikakuSoshitsuKakutei
     */
    @JsonProperty("btnShikakuSoshitsuKakutei")
    public void setBtnShikakuSoshitsuKakutei(Button btnShikakuSoshitsuKakutei) {
        this.btnShikakuSoshitsuKakutei = btnShikakuSoshitsuKakutei;
    }

    /*
     * getbtnShikakuSoshitsuTorikeshi
     * @return btnShikakuSoshitsuTorikeshi
     */
    @JsonProperty("btnShikakuSoshitsuTorikeshi")
    public Button getBtnShikakuSoshitsuTorikeshi() {
        return btnShikakuSoshitsuTorikeshi;
    }

    /*
     * setbtnShikakuSoshitsuTorikeshi
     * @param btnShikakuSoshitsuTorikeshi btnShikakuSoshitsuTorikeshi
     */
    @JsonProperty("btnShikakuSoshitsuTorikeshi")
    public void setBtnShikakuSoshitsuTorikeshi(Button btnShikakuSoshitsuTorikeshi) {
        this.btnShikakuSoshitsuTorikeshi = btnShikakuSoshitsuTorikeshi;
    }

    // </editor-fold>
}
