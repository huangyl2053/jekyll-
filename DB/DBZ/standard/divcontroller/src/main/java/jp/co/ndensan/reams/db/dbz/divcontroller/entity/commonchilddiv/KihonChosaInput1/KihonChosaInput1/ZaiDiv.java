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
 * Zai のクラスファイル
 *
 * @author 自動生成
 */
public class ZaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnZai")
    private ButtonDialog btnZai;
    @JsonProperty("radZai")
    private RadioButton radZai;
    @JsonProperty("ZaiShinseishoKanriNo")
    private RString ZaiShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnZai
     * @return btnZai
     */
    @JsonProperty("btnZai")
    public ButtonDialog getBtnZai() {
        return btnZai;
    }

    /*
     * setbtnZai
     * @param btnZai btnZai
     */
    @JsonProperty("btnZai")
    public void setBtnZai(ButtonDialog btnZai) {
        this.btnZai = btnZai;
    }

    /*
     * getradZai
     * @return radZai
     */
    @JsonProperty("radZai")
    public RadioButton getRadZai() {
        return radZai;
    }

    /*
     * setradZai
     * @param radZai radZai
     */
    @JsonProperty("radZai")
    public void setRadZai(RadioButton radZai) {
        this.radZai = radZai;
    }

    /*
     * getZaiShinseishoKanriNo
     * @return ZaiShinseishoKanriNo
     */
    @JsonProperty("ZaiShinseishoKanriNo")
    public RString getZaiShinseishoKanriNo() {
        return ZaiShinseishoKanriNo;
    }

    /*
     * setZaiShinseishoKanriNo
     * @param ZaiShinseishoKanriNo ZaiShinseishoKanriNo
     */
    @JsonProperty("ZaiShinseishoKanriNo")
    public void setZaiShinseishoKanriNo(RString ZaiShinseishoKanriNo) {
        this.ZaiShinseishoKanriNo = ZaiShinseishoKanriNo;
    }

    // </editor-fold>
}
