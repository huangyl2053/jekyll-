package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
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
 * ToshoShutsuryokuK のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class ToshoShutsuryokuKDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radToshoShutsuryokuK")
    private RadioButton radToshoShutsuryokuK;
    @JsonProperty("ddlChukiKaishiKiK")
    private DropDownList ddlChukiKaishiKiK;
    @JsonProperty("ddlKokiKaishiKiK")
    private DropDownList ddlKokiKaishiKiK;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradToshoShutsuryokuK
     * @return radToshoShutsuryokuK
     */
    @JsonProperty("radToshoShutsuryokuK")
    public RadioButton getRadToshoShutsuryokuK() {
        return radToshoShutsuryokuK;
    }

    /*
     * setradToshoShutsuryokuK
     * @param radToshoShutsuryokuK radToshoShutsuryokuK
     */
    @JsonProperty("radToshoShutsuryokuK")
    public void setRadToshoShutsuryokuK(RadioButton radToshoShutsuryokuK) {
        this.radToshoShutsuryokuK = radToshoShutsuryokuK;
    }

    /*
     * getddlChukiKaishiKiK
     * @return ddlChukiKaishiKiK
     */
    @JsonProperty("ddlChukiKaishiKiK")
    public DropDownList getDdlChukiKaishiKiK() {
        return ddlChukiKaishiKiK;
    }

    /*
     * setddlChukiKaishiKiK
     * @param ddlChukiKaishiKiK ddlChukiKaishiKiK
     */
    @JsonProperty("ddlChukiKaishiKiK")
    public void setDdlChukiKaishiKiK(DropDownList ddlChukiKaishiKiK) {
        this.ddlChukiKaishiKiK = ddlChukiKaishiKiK;
    }

    /*
     * getddlKokiKaishiKiK
     * @return ddlKokiKaishiKiK
     */
    @JsonProperty("ddlKokiKaishiKiK")
    public DropDownList getDdlKokiKaishiKiK() {
        return ddlKokiKaishiKiK;
    }

    /*
     * setddlKokiKaishiKiK
     * @param ddlKokiKaishiKiK ddlKokiKaishiKiK
     */
    @JsonProperty("ddlKokiKaishiKiK")
    public void setDdlKokiKaishiKiK(DropDownList ddlKokiKaishiKiK) {
        this.ddlKokiKaishiKiK = ddlKokiKaishiKiK;
    }

    // </editor-fold>
}
