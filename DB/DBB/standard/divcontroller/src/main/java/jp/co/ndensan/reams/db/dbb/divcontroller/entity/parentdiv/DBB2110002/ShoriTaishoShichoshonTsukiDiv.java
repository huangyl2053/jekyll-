package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002;
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
 * ShoriTaishoShichoshonTsuki のクラスファイル
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class ShoriTaishoShichoshonTsukiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShichosonSelect")
    private RadioButton radShichosonSelect;
    @JsonProperty("ddlShichosonSelect")
    private DropDownList ddlShichosonSelect;
    @JsonProperty("radTsukiSelect")
    private RadioButton radTsukiSelect;
    @JsonProperty("ddlTsuki")
    private DropDownList ddlTsuki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShichosonSelect
     * @return radShichosonSelect
     */
    @JsonProperty("radShichosonSelect")
    public RadioButton getRadShichosonSelect() {
        return radShichosonSelect;
    }

    /*
     * setradShichosonSelect
     * @param radShichosonSelect radShichosonSelect
     */
    @JsonProperty("radShichosonSelect")
    public void setRadShichosonSelect(RadioButton radShichosonSelect) {
        this.radShichosonSelect = radShichosonSelect;
    }

    /*
     * getddlShichosonSelect
     * @return ddlShichosonSelect
     */
    @JsonProperty("ddlShichosonSelect")
    public DropDownList getDdlShichosonSelect() {
        return ddlShichosonSelect;
    }

    /*
     * setddlShichosonSelect
     * @param ddlShichosonSelect ddlShichosonSelect
     */
    @JsonProperty("ddlShichosonSelect")
    public void setDdlShichosonSelect(DropDownList ddlShichosonSelect) {
        this.ddlShichosonSelect = ddlShichosonSelect;
    }

    /*
     * getradTsukiSelect
     * @return radTsukiSelect
     */
    @JsonProperty("radTsukiSelect")
    public RadioButton getRadTsukiSelect() {
        return radTsukiSelect;
    }

    /*
     * setradTsukiSelect
     * @param radTsukiSelect radTsukiSelect
     */
    @JsonProperty("radTsukiSelect")
    public void setRadTsukiSelect(RadioButton radTsukiSelect) {
        this.radTsukiSelect = radTsukiSelect;
    }

    /*
     * getddlTsuki
     * @return ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public DropDownList getDdlTsuki() {
        return ddlTsuki;
    }

    /*
     * setddlTsuki
     * @param ddlTsuki ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.ddlTsuki = ddlTsuki;
    }

    // </editor-fold>
}
