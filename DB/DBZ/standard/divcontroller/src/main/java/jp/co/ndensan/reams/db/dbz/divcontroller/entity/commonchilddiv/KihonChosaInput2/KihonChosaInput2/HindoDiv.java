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
 * Hindo のクラスファイル
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class HindoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHindo")
    private ButtonDialog btnHindo;
    @JsonProperty("radHindo")
    private RadioButton radHindo;
    @JsonProperty("HindoShinseishoKanriNo")
    private RString HindoShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHindo
     * @return btnHindo
     */
    @JsonProperty("btnHindo")
    public ButtonDialog getBtnHindo() {
        return btnHindo;
    }

    /*
     * setbtnHindo
     * @param btnHindo btnHindo
     */
    @JsonProperty("btnHindo")
    public void setBtnHindo(ButtonDialog btnHindo) {
        this.btnHindo = btnHindo;
    }

    /*
     * getradHindo
     * @return radHindo
     */
    @JsonProperty("radHindo")
    public RadioButton getRadHindo() {
        return radHindo;
    }

    /*
     * setradHindo
     * @param radHindo radHindo
     */
    @JsonProperty("radHindo")
    public void setRadHindo(RadioButton radHindo) {
        this.radHindo = radHindo;
    }

    /*
     * getHindoShinseishoKanriNo
     * @return HindoShinseishoKanriNo
     */
    @JsonProperty("HindoShinseishoKanriNo")
    public RString getHindoShinseishoKanriNo() {
        return HindoShinseishoKanriNo;
    }

    /*
     * setHindoShinseishoKanriNo
     * @param HindoShinseishoKanriNo HindoShinseishoKanriNo
     */
    @JsonProperty("HindoShinseishoKanriNo")
    public void setHindoShinseishoKanriNo(RString HindoShinseishoKanriNo) {
        this.HindoShinseishoKanriNo = HindoShinseishoKanriNo;
    }

    // </editor-fold>
}
