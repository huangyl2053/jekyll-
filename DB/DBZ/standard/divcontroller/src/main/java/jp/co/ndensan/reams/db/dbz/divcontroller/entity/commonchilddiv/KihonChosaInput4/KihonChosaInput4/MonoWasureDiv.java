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
 * MonoWasure のクラスファイル
 *
 * @author 自動生成
 */
public class MonoWasureDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMonoWasure")
    private ButtonDialog btnMonoWasure;
    @JsonProperty("radMonoWasure")
    private RadioButton radMonoWasure;
    @JsonProperty("MonoWasureShinseishoKanriNo")
    private RString MonoWasureShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnMonoWasure
     * @return btnMonoWasure
     */
    @JsonProperty("btnMonoWasure")
    public ButtonDialog getBtnMonoWasure() {
        return btnMonoWasure;
    }

    /*
     * setbtnMonoWasure
     * @param btnMonoWasure btnMonoWasure
     */
    @JsonProperty("btnMonoWasure")
    public void setBtnMonoWasure(ButtonDialog btnMonoWasure) {
        this.btnMonoWasure = btnMonoWasure;
    }

    /*
     * getradMonoWasure
     * @return radMonoWasure
     */
    @JsonProperty("radMonoWasure")
    public RadioButton getRadMonoWasure() {
        return radMonoWasure;
    }

    /*
     * setradMonoWasure
     * @param radMonoWasure radMonoWasure
     */
    @JsonProperty("radMonoWasure")
    public void setRadMonoWasure(RadioButton radMonoWasure) {
        this.radMonoWasure = radMonoWasure;
    }

    /*
     * getMonoWasureShinseishoKanriNo
     * @return MonoWasureShinseishoKanriNo
     */
    @JsonProperty("MonoWasureShinseishoKanriNo")
    public RString getMonoWasureShinseishoKanriNo() {
        return MonoWasureShinseishoKanriNo;
    }

    /*
     * setMonoWasureShinseishoKanriNo
     * @param MonoWasureShinseishoKanriNo MonoWasureShinseishoKanriNo
     */
    @JsonProperty("MonoWasureShinseishoKanriNo")
    public void setMonoWasureShinseishoKanriNo(RString MonoWasureShinseishoKanriNo) {
        this.MonoWasureShinseishoKanriNo = MonoWasureShinseishoKanriNo;
    }

    // </editor-fold>
}
