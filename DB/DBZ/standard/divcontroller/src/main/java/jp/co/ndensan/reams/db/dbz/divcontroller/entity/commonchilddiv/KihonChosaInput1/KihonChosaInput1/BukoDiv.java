package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * Buko のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class BukoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBuko")
    private ButtonDialog btnBuko;
    @JsonProperty("radBuko")
    private RadioButton radBuko;
    @JsonProperty("BukoShinseishoKanriNo")
    private RString BukoShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBuko
     * @return btnBuko
     */
    @JsonProperty("btnBuko")
    public ButtonDialog getBtnBuko() {
        return btnBuko;
    }

    /*
     * setbtnBuko
     * @param btnBuko btnBuko
     */
    @JsonProperty("btnBuko")
    public void setBtnBuko(ButtonDialog btnBuko) {
        this.btnBuko = btnBuko;
    }

    /*
     * getradBuko
     * @return radBuko
     */
    @JsonProperty("radBuko")
    public RadioButton getRadBuko() {
        return radBuko;
    }

    /*
     * setradBuko
     * @param radBuko radBuko
     */
    @JsonProperty("radBuko")
    public void setRadBuko(RadioButton radBuko) {
        this.radBuko = radBuko;
    }

    /*
     * getBukoShinseishoKanriNo
     * @return BukoShinseishoKanriNo
     */
    @JsonProperty("BukoShinseishoKanriNo")
    public RString getBukoShinseishoKanriNo() {
        return BukoShinseishoKanriNo;
    }

    /*
     * setBukoShinseishoKanriNo
     * @param BukoShinseishoKanriNo BukoShinseishoKanriNo
     */
    @JsonProperty("BukoShinseishoKanriNo")
    public void setBukoShinseishoKanriNo(RString BukoShinseishoKanriNo) {
        this.BukoShinseishoKanriNo = BukoShinseishoKanriNo;
    }

    // </editor-fold>
}
