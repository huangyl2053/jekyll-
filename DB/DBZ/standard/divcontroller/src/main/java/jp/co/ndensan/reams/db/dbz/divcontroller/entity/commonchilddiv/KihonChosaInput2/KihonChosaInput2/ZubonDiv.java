package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2;
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
 * Zubon のクラスファイル
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class ZubonDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnZubon")
    private ButtonDialog btnZubon;
    @JsonProperty("radZubon")
    private RadioButton radZubon;
    @JsonProperty("ZubonShinseishoKanriNo")
    private RString ZubonShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnZubon
     * @return btnZubon
     */
    @JsonProperty("btnZubon")
    public ButtonDialog getBtnZubon() {
        return btnZubon;
    }

    /*
     * setbtnZubon
     * @param btnZubon btnZubon
     */
    @JsonProperty("btnZubon")
    public void setBtnZubon(ButtonDialog btnZubon) {
        this.btnZubon = btnZubon;
    }

    /*
     * getradZubon
     * @return radZubon
     */
    @JsonProperty("radZubon")
    public RadioButton getRadZubon() {
        return radZubon;
    }

    /*
     * setradZubon
     * @param radZubon radZubon
     */
    @JsonProperty("radZubon")
    public void setRadZubon(RadioButton radZubon) {
        this.radZubon = radZubon;
    }

    /*
     * getZubonShinseishoKanriNo
     * @return ZubonShinseishoKanriNo
     */
    @JsonProperty("ZubonShinseishoKanriNo")
    public RString getZubonShinseishoKanriNo() {
        return ZubonShinseishoKanriNo;
    }

    /*
     * setZubonShinseishoKanriNo
     * @param ZubonShinseishoKanriNo ZubonShinseishoKanriNo
     */
    @JsonProperty("ZubonShinseishoKanriNo")
    public void setZubonShinseishoKanriNo(RString ZubonShinseishoKanriNo) {
        this.ZubonShinseishoKanriNo = ZubonShinseishoKanriNo;
    }

    // </editor-fold>
}
