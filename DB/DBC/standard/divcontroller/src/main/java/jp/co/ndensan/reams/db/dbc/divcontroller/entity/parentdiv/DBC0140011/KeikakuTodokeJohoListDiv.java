package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KeikakuTodokeJohoList のクラスファイル 
 * 
 * @reamsid_L DBC-1960-010 wangxingpeng
 */
public class KeikakuTodokeJohoListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbJukyuShinseibi")
    private TextBoxDateRange tbJukyuShinseibi;
    @JsonProperty("ddlTaishousha")
    private DropDownList ddlTaishousha;
    @JsonProperty("ddlTodokeJokyo")
    private DropDownList ddlTodokeJokyo;
    @JsonProperty("tbKijunbi")
    private TextBoxDate tbKijunbi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbJukyuShinseibi
     * @return tbJukyuShinseibi
     */
    @JsonProperty("tbJukyuShinseibi")
    public TextBoxDateRange getTbJukyuShinseibi() {
        return tbJukyuShinseibi;
    }

    /*
     * settbJukyuShinseibi
     * @param tbJukyuShinseibi tbJukyuShinseibi
     */
    @JsonProperty("tbJukyuShinseibi")
    public void setTbJukyuShinseibi(TextBoxDateRange tbJukyuShinseibi) {
        this.tbJukyuShinseibi = tbJukyuShinseibi;
    }

    /*
     * getddlTaishousha
     * @return ddlTaishousha
     */
    @JsonProperty("ddlTaishousha")
    public DropDownList getDdlTaishousha() {
        return ddlTaishousha;
    }

    /*
     * setddlTaishousha
     * @param ddlTaishousha ddlTaishousha
     */
    @JsonProperty("ddlTaishousha")
    public void setDdlTaishousha(DropDownList ddlTaishousha) {
        this.ddlTaishousha = ddlTaishousha;
    }

    /*
     * getddlTodokeJokyo
     * @return ddlTodokeJokyo
     */
    @JsonProperty("ddlTodokeJokyo")
    public DropDownList getDdlTodokeJokyo() {
        return ddlTodokeJokyo;
    }

    /*
     * setddlTodokeJokyo
     * @param ddlTodokeJokyo ddlTodokeJokyo
     */
    @JsonProperty("ddlTodokeJokyo")
    public void setDdlTodokeJokyo(DropDownList ddlTodokeJokyo) {
        this.ddlTodokeJokyo = ddlTodokeJokyo;
    }

    /*
     * gettbKijunbi
     * @return tbKijunbi
     */
    @JsonProperty("tbKijunbi")
    public TextBoxDate getTbKijunbi() {
        return tbKijunbi;
    }

    /*
     * settbKijunbi
     * @param tbKijunbi tbKijunbi
     */
    @JsonProperty("tbKijunbi")
    public void setTbKijunbi(TextBoxDate tbKijunbi) {
        this.tbKijunbi = tbKijunbi;
    }

    // </editor-fold>
}
