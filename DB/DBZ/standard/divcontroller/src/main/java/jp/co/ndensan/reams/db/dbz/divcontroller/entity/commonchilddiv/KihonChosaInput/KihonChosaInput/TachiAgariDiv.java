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
 * TachiAgari のクラスファイル 
 * 
 * @author 自動生成
 */
public class TachiAgariDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTachiAgari")
    private Button btnTachiAgari;
    @JsonProperty("radTachiAgari")
    private RadioButton radTachiAgari;

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
    public Button getBtnTachiAgari() {
        return btnTachiAgari;
    }

    /*
     * setbtnTachiAgari
     * @param btnTachiAgari btnTachiAgari
     */
    @JsonProperty("btnTachiAgari")
    public void setBtnTachiAgari(Button btnTachiAgari) {
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

    // </editor-fold>
}
