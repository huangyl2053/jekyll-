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
 * TachiAgari のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class TachiAgariDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTachiAgari")
    private ButtonDialog btnTachiAgari;
    @JsonProperty("radTachiAgari")
    private RadioButton radTachiAgari;
    @JsonProperty("TachiAgariShinseishoKanriNo")
    private RString TachiAgariShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTachiAgari
     * @return btnTachiAgari
     */
    @JsonProperty("btnTachiAgari")
    public ButtonDialog getBtnTachiAgari() {
        return btnTachiAgari;
    }

    /*
     * setbtnTachiAgari
     * @param btnTachiAgari btnTachiAgari
     */
    @JsonProperty("btnTachiAgari")
    public void setBtnTachiAgari(ButtonDialog btnTachiAgari) {
        this.btnTachiAgari = btnTachiAgari;
    }

    /*
     * getradTachiAgari
     * @return radTachiAgari
     */
    @JsonProperty("radTachiAgari")
    public RadioButton getRadTachiAgari() {
        return radTachiAgari;
    }

    /*
     * setradTachiAgari
     * @param radTachiAgari radTachiAgari
     */
    @JsonProperty("radTachiAgari")
    public void setRadTachiAgari(RadioButton radTachiAgari) {
        this.radTachiAgari = radTachiAgari;
    }

    /*
     * getTachiAgariShinseishoKanriNo
     * @return TachiAgariShinseishoKanriNo
     */
    @JsonProperty("TachiAgariShinseishoKanriNo")
    public RString getTachiAgariShinseishoKanriNo() {
        return TachiAgariShinseishoKanriNo;
    }

    /*
     * setTachiAgariShinseishoKanriNo
     * @param TachiAgariShinseishoKanriNo TachiAgariShinseishoKanriNo
     */
    @JsonProperty("TachiAgariShinseishoKanriNo")
    public void setTachiAgariShinseishoKanriNo(RString TachiAgariShinseishoKanriNo) {
        this.TachiAgariShinseishoKanriNo = TachiAgariShinseishoKanriNo;
    }

    // </editor-fold>
}
