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
 * TumeKiri のクラスファイル
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class TumeKiriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTumeKiri")
    private ButtonDialog btnTumeKiri;
    @JsonProperty("radTumeKiri")
    private RadioButton radTumeKiri;
    @JsonProperty("TumeKiriShinseishoKanriNo")
    private RString TumeKiriShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTumeKiri
     * @return btnTumeKiri
     */
    @JsonProperty("btnTumeKiri")
    public ButtonDialog getBtnTumeKiri() {
        return btnTumeKiri;
    }

    /*
     * setbtnTumeKiri
     * @param btnTumeKiri btnTumeKiri
     */
    @JsonProperty("btnTumeKiri")
    public void setBtnTumeKiri(ButtonDialog btnTumeKiri) {
        this.btnTumeKiri = btnTumeKiri;
    }

    /*
     * getradTumeKiri
     * @return radTumeKiri
     */
    @JsonProperty("radTumeKiri")
    public RadioButton getRadTumeKiri() {
        return radTumeKiri;
    }

    /*
     * setradTumeKiri
     * @param radTumeKiri radTumeKiri
     */
    @JsonProperty("radTumeKiri")
    public void setRadTumeKiri(RadioButton radTumeKiri) {
        this.radTumeKiri = radTumeKiri;
    }

    /*
     * getTumeKiriShinseishoKanriNo
     * @return TumeKiriShinseishoKanriNo
     */
    @JsonProperty("TumeKiriShinseishoKanriNo")
    public RString getTumeKiriShinseishoKanriNo() {
        return TumeKiriShinseishoKanriNo;
    }

    /*
     * setTumeKiriShinseishoKanriNo
     * @param TumeKiriShinseishoKanriNo TumeKiriShinseishoKanriNo
     */
    @JsonProperty("TumeKiriShinseishoKanriNo")
    public void setTumeKiriShinseishoKanriNo(RString TumeKiriShinseishoKanriNo) {
        this.TumeKiriShinseishoKanriNo = TumeKiriShinseishoKanriNo;
    }

    // </editor-fold>
}
