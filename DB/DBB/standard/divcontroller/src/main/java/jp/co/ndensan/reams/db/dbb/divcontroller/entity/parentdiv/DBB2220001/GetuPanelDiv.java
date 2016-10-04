package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GetuPanel のクラスファイル
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class GetuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlGetu")
    private DropDownList ddlGetu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlGetu
     * @return ddlGetu
     */
    @JsonProperty("ddlGetu")
    public DropDownList getDdlGetu() {
        return ddlGetu;
    }

    /*
     * setddlGetu
     * @param ddlGetu ddlGetu
     */
    @JsonProperty("ddlGetu")
    public void setDdlGetu(DropDownList ddlGetu) {
        this.ddlGetu = ddlGetu;
    }

    // </editor-fold>
}
