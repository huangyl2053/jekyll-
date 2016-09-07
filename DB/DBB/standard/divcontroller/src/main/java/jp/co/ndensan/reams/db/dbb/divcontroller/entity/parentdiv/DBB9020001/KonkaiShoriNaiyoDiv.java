package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KonkaiShoriNaiyo のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class KonkaiShoriNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlFukaNendo")
    private DropDownList ddlFukaNendo;
    @JsonProperty("ddlRank")
    private DropDownList ddlRank;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlFukaNendo
     * @return ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public DropDownList getDdlFukaNendo() {
        return ddlFukaNendo;
    }

    /*
     * setddlFukaNendo
     * @param ddlFukaNendo ddlFukaNendo
     */
    @JsonProperty("ddlFukaNendo")
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.ddlFukaNendo = ddlFukaNendo;
    }

    /*
     * getddlRank
     * @return ddlRank
     */
    @JsonProperty("ddlRank")
    public DropDownList getDdlRank() {
        return ddlRank;
    }

    /*
     * setddlRank
     * @param ddlRank ddlRank
     */
    @JsonProperty("ddlRank")
    public void setDdlRank(DropDownList ddlRank) {
        this.ddlRank = ddlRank;
    }

    // </editor-fold>
}
