package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
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
 * Kanjyo のクラスファイル
 *
 * @reamsid_L DBE-3000-093 wangjie2
 */
public class KanjyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKanjyo")
    private ButtonDialog btnKanjyo;
    @JsonProperty("radKanjyo")
    private RadioButton radKanjyo;
    @JsonProperty("KanjyoShinseishoKanriNo")
    private RString KanjyoShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKanjyo
     * @return btnKanjyo
     */
    @JsonProperty("btnKanjyo")
    public ButtonDialog getBtnKanjyo() {
        return btnKanjyo;
    }

    /*
     * setbtnKanjyo
     * @param btnKanjyo btnKanjyo
     */
    @JsonProperty("btnKanjyo")
    public void setBtnKanjyo(ButtonDialog btnKanjyo) {
        this.btnKanjyo = btnKanjyo;
    }

    /*
     * getradKanjyo
     * @return radKanjyo
     */
    @JsonProperty("radKanjyo")
    public RadioButton getRadKanjyo() {
        return radKanjyo;
    }

    /*
     * setradKanjyo
     * @param radKanjyo radKanjyo
     */
    @JsonProperty("radKanjyo")
    public void setRadKanjyo(RadioButton radKanjyo) {
        this.radKanjyo = radKanjyo;
    }

    /*
     * getKanjyoShinseishoKanriNo
     * @return KanjyoShinseishoKanriNo
     */
    @JsonProperty("KanjyoShinseishoKanriNo")
    public RString getKanjyoShinseishoKanriNo() {
        return KanjyoShinseishoKanriNo;
    }

    /*
     * setKanjyoShinseishoKanriNo
     * @param KanjyoShinseishoKanriNo KanjyoShinseishoKanriNo
     */
    @JsonProperty("KanjyoShinseishoKanriNo")
    public void setKanjyoShinseishoKanriNo(RString KanjyoShinseishoKanriNo) {
        this.KanjyoShinseishoKanriNo = KanjyoShinseishoKanriNo;
    }

    // </editor-fold>
}
