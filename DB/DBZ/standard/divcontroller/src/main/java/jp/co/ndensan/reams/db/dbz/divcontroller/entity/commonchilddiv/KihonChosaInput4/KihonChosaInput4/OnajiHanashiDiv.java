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
 * OnajiHanashi のクラスファイル
 *
 * @author 自動生成
 */
public class OnajiHanashiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOnajiHanashi")
    private ButtonDialog btnOnajiHanashi;
    @JsonProperty("radOnajiHanashi")
    private RadioButton radOnajiHanashi;
    @JsonProperty("OnajiHanashiShinseishoKanriNo")
    private RString OnajiHanashiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOnajiHanashi
     * @return btnOnajiHanashi
     */
    @JsonProperty("btnOnajiHanashi")
    public ButtonDialog getBtnOnajiHanashi() {
        return btnOnajiHanashi;
    }

    /*
     * setbtnOnajiHanashi
     * @param btnOnajiHanashi btnOnajiHanashi
     */
    @JsonProperty("btnOnajiHanashi")
    public void setBtnOnajiHanashi(ButtonDialog btnOnajiHanashi) {
        this.btnOnajiHanashi = btnOnajiHanashi;
    }

    /*
     * getradOnajiHanashi
     * @return radOnajiHanashi
     */
    @JsonProperty("radOnajiHanashi")
    public RadioButton getRadOnajiHanashi() {
        return radOnajiHanashi;
    }

    /*
     * setradOnajiHanashi
     * @param radOnajiHanashi radOnajiHanashi
     */
    @JsonProperty("radOnajiHanashi")
    public void setRadOnajiHanashi(RadioButton radOnajiHanashi) {
        this.radOnajiHanashi = radOnajiHanashi;
    }

    /*
     * getOnajiHanashiShinseishoKanriNo
     * @return OnajiHanashiShinseishoKanriNo
     */
    @JsonProperty("OnajiHanashiShinseishoKanriNo")
    public RString getOnajiHanashiShinseishoKanriNo() {
        return OnajiHanashiShinseishoKanriNo;
    }

    /*
     * setOnajiHanashiShinseishoKanriNo
     * @param OnajiHanashiShinseishoKanriNo OnajiHanashiShinseishoKanriNo
     */
    @JsonProperty("OnajiHanashiShinseishoKanriNo")
    public void setOnajiHanashiShinseishoKanriNo(RString OnajiHanashiShinseishoKanriNo) {
        this.OnajiHanashiShinseishoKanriNo = OnajiHanashiShinseishoKanriNo;
    }

    // </editor-fold>
}
