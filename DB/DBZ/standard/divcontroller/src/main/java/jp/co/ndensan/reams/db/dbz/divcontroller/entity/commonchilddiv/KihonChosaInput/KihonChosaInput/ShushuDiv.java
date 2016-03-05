package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shushu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShushuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShushu")
    private ButtonDialog btnShushu;
    @JsonProperty("radShushu")
    private RadioButton radShushu;
    @JsonProperty("ShushuShinseishoKanriNo")
    private RString ShushuShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShushu
     * @return btnShushu
     */
    @JsonProperty("btnShushu")
    public ButtonDialog getBtnShushu() {
        return btnShushu;
    }

    /*
     * setbtnShushu
     * @param btnShushu btnShushu
     */
    @JsonProperty("btnShushu")
    public void setBtnShushu(ButtonDialog btnShushu) {
        this.btnShushu = btnShushu;
    }

    /*
     * getradShushu
     * @return radShushu
     */
    @JsonProperty("radShushu")
    public RadioButton getRadShushu() {
        return radShushu;
    }

    /*
     * setradShushu
     * @param radShushu radShushu
     */
    @JsonProperty("radShushu")
    public void setRadShushu(RadioButton radShushu) {
        this.radShushu = radShushu;
    }

    /*
     * getShushuShinseishoKanriNo
     * @return ShushuShinseishoKanriNo
     */
    @JsonProperty("ShushuShinseishoKanriNo")
    public RString getShushuShinseishoKanriNo() {
        return ShushuShinseishoKanriNo;
    }

    /*
     * setShushuShinseishoKanriNo
     * @param ShushuShinseishoKanriNo ShushuShinseishoKanriNo
     */
    @JsonProperty("ShushuShinseishoKanriNo")
    public void setShushuShinseishoKanriNo(RString ShushuShinseishoKanriNo) {
        this.ShushuShinseishoKanriNo = ShushuShinseishoKanriNo;
    }

    // </editor-fold>
}
