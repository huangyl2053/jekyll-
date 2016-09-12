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
 * ToshoShutsuryokuH のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class ToshoShutsuryokuHDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radToshoShutsuryokuH")
    private RadioButton radToshoShutsuryokuH;
    @JsonProperty("ddlChukiKaishiKiH")
    private DropDownList ddlChukiKaishiKiH;
    @JsonProperty("ddlKokiKaishiKiH")
    private DropDownList ddlKokiKaishiKiH;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradToshoShutsuryokuH
     * @return radToshoShutsuryokuH
     */
    @JsonProperty("radToshoShutsuryokuH")
    public RadioButton getRadToshoShutsuryokuH() {
        return radToshoShutsuryokuH;
    }

    /*
     * setradToshoShutsuryokuH
     * @param radToshoShutsuryokuH radToshoShutsuryokuH
     */
    @JsonProperty("radToshoShutsuryokuH")
    public void setRadToshoShutsuryokuH(RadioButton radToshoShutsuryokuH) {
        this.radToshoShutsuryokuH = radToshoShutsuryokuH;
    }

    /*
     * getddlChukiKaishiKiH
     * @return ddlChukiKaishiKiH
     */
    @JsonProperty("ddlChukiKaishiKiH")
    public DropDownList getDdlChukiKaishiKiH() {
        return ddlChukiKaishiKiH;
    }

    /*
     * setddlChukiKaishiKiH
     * @param ddlChukiKaishiKiH ddlChukiKaishiKiH
     */
    @JsonProperty("ddlChukiKaishiKiH")
    public void setDdlChukiKaishiKiH(DropDownList ddlChukiKaishiKiH) {
        this.ddlChukiKaishiKiH = ddlChukiKaishiKiH;
    }

    /*
     * getddlKokiKaishiKiH
     * @return ddlKokiKaishiKiH
     */
    @JsonProperty("ddlKokiKaishiKiH")
    public DropDownList getDdlKokiKaishiKiH() {
        return ddlKokiKaishiKiH;
    }

    /*
     * setddlKokiKaishiKiH
     * @param ddlKokiKaishiKiH ddlKokiKaishiKiH
     */
    @JsonProperty("ddlKokiKaishiKiH")
    public void setDdlKokiKaishiKiH(DropDownList ddlKokiKaishiKiH) {
        this.ddlKokiKaishiKiH = ddlKokiKaishiKiH;
    }

    // </editor-fold>
}
