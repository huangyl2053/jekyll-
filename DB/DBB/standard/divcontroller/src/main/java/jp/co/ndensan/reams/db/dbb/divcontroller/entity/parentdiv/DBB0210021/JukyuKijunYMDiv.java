package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyuKijunYM のクラスファイル
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class JukyuKijunYMDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlJukyuKijunY")
    private DropDownList ddlJukyuKijunY;
    @JsonProperty("ddlJukyuKijunM")
    private DropDownList ddlJukyuKijunM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlJukyuKijunY
     * @return ddlJukyuKijunY
     */
    @JsonProperty("ddlJukyuKijunY")
    public DropDownList getDdlJukyuKijunY() {
        return ddlJukyuKijunY;
    }

    /*
     * setddlJukyuKijunY
     * @param ddlJukyuKijunY ddlJukyuKijunY
     */
    @JsonProperty("ddlJukyuKijunY")
    public void setDdlJukyuKijunY(DropDownList ddlJukyuKijunY) {
        this.ddlJukyuKijunY = ddlJukyuKijunY;
    }

    /*
     * getddlJukyuKijunM
     * @return ddlJukyuKijunM
     */
    @JsonProperty("ddlJukyuKijunM")
    public DropDownList getDdlJukyuKijunM() {
        return ddlJukyuKijunM;
    }

    /*
     * setddlJukyuKijunM
     * @param ddlJukyuKijunM ddlJukyuKijunM
     */
    @JsonProperty("ddlJukyuKijunM")
    public void setDdlJukyuKijunM(DropDownList ddlJukyuKijunM) {
        this.ddlJukyuKijunM = ddlJukyuKijunM;
    }

    // </editor-fold>
}
