package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SanteiKisoShutsuryokuHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class SanteiKisoShutsuryokuHohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKiso1")
    private DropDownList ddlKiso1;
    @JsonProperty("ddlKiso2")
    private DropDownList ddlKiso2;
    @JsonProperty("ddlKiso3")
    private DropDownList ddlKiso3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKiso1
     * @return ddlKiso1
     */
    @JsonProperty("ddlKiso1")
    public DropDownList getDdlKiso1() {
        return ddlKiso1;
    }

    /*
     * setddlKiso1
     * @param ddlKiso1 ddlKiso1
     */
    @JsonProperty("ddlKiso1")
    public void setDdlKiso1(DropDownList ddlKiso1) {
        this.ddlKiso1 = ddlKiso1;
    }

    /*
     * getddlKiso2
     * @return ddlKiso2
     */
    @JsonProperty("ddlKiso2")
    public DropDownList getDdlKiso2() {
        return ddlKiso2;
    }

    /*
     * setddlKiso2
     * @param ddlKiso2 ddlKiso2
     */
    @JsonProperty("ddlKiso2")
    public void setDdlKiso2(DropDownList ddlKiso2) {
        this.ddlKiso2 = ddlKiso2;
    }

    /*
     * getddlKiso3
     * @return ddlKiso3
     */
    @JsonProperty("ddlKiso3")
    public DropDownList getDdlKiso3() {
        return ddlKiso3;
    }

    /*
     * setddlKiso3
     * @param ddlKiso3 ddlKiso3
     */
    @JsonProperty("ddlKiso3")
    public void setDdlKiso3(DropDownList ddlKiso3) {
        this.ddlKiso3 = ddlKiso3;
    }

    // </editor-fold>
}
