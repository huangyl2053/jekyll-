package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HenkoHokenshaJoho のクラスファイル
 *
 */
public class HenkoHokenshaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHenkoSochimotoHokensha")
    private DropDownList ddlHenkoSochimotoHokensha;
    @JsonProperty("ddlHenkoKyuHokensha")
    private DropDownList ddlHenkoKyuHokensha;
    @JsonProperty("ddlJuminJoho")
    private DropDownList ddlJuminJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHenkoSochimotoHokensha
     * @return ddlHenkoSochimotoHokensha
     */
    @JsonProperty("ddlHenkoSochimotoHokensha")
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return ddlHenkoSochimotoHokensha;
    }

    /*
     * setddlHenkoSochimotoHokensha
     * @param ddlHenkoSochimotoHokensha ddlHenkoSochimotoHokensha
     */
    @JsonProperty("ddlHenkoSochimotoHokensha")
    public void setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.ddlHenkoSochimotoHokensha = ddlHenkoSochimotoHokensha;
    }

    /*
     * getddlHenkoKyuHokensha
     * @return ddlHenkoKyuHokensha
     */
    @JsonProperty("ddlHenkoKyuHokensha")
    public DropDownList getDdlHenkoKyuHokensha() {
        return ddlHenkoKyuHokensha;
    }

    /*
     * setddlHenkoKyuHokensha
     * @param ddlHenkoKyuHokensha ddlHenkoKyuHokensha
     */
    @JsonProperty("ddlHenkoKyuHokensha")
    public void setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.ddlHenkoKyuHokensha = ddlHenkoKyuHokensha;
    }

    /*
     * getddlJuminJoho
     * @return ddlJuminJoho
     */
    @JsonProperty("ddlJuminJoho")
    public DropDownList getDdlJuminJoho() {
        return ddlJuminJoho;
    }

    /*
     * setddlJuminJoho
     * @param ddlJuminJoho ddlJuminJoho
     */
    @JsonProperty("ddlJuminJoho")
    public void setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.ddlJuminJoho = ddlJuminJoho;
    }

    // </editor-fold>
}
