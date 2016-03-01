package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shiryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShiryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShiryoku")
    private Button btnShiryoku;
    @JsonProperty("radShiryoku")
    private RadioButton radShiryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShiryoku
     * @return btnShiryoku
     */
    @JsonProperty("btnShiryoku")
    public Button getBtnShiryoku() {
        return btnShiryoku;
    }

    /*
     * setbtnShiryoku
     * @param btnShiryoku btnShiryoku
     */
    @JsonProperty("btnShiryoku")
    public void setBtnShiryoku(Button btnShiryoku) {
        this.btnShiryoku = btnShiryoku;
    }

    /*
     * getradShiryoku
     * @return radShiryoku
     */
    @JsonProperty("radShiryoku")
    public RadioButton getRadShiryoku() {
        return radShiryoku;
    }

    /*
     * setradShiryoku
     * @param radShiryoku radShiryoku
     */
    @JsonProperty("radShiryoku")
    public void setRadShiryoku(RadioButton radShiryoku) {
        this.radShiryoku = radShiryoku;
    }

    // </editor-fold>
}
