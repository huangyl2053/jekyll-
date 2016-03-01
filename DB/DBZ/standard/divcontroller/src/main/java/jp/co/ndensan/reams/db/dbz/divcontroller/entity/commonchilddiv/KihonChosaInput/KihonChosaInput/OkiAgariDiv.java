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
 * OkiAgari のクラスファイル 
 * 
 * @author 自動生成
 */
public class OkiAgariDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOkiAgari")
    private Button btnOkiAgari;
    @JsonProperty("radOkiAgari")
    private RadioButton radOkiAgari;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOkiAgari
     * @return btnOkiAgari
     */
    @JsonProperty("btnOkiAgari")
    public Button getBtnOkiAgari() {
        return btnOkiAgari;
    }

    /*
     * setbtnOkiAgari
     * @param btnOkiAgari btnOkiAgari
     */
    @JsonProperty("btnOkiAgari")
    public void setBtnOkiAgari(Button btnOkiAgari) {
        this.btnOkiAgari = btnOkiAgari;
    }

    /*
     * getradOkiAgari
     * @return radOkiAgari
     */
    @JsonProperty("radOkiAgari")
    public RadioButton getRadOkiAgari() {
        return radOkiAgari;
    }

    /*
     * setradOkiAgari
     * @param radOkiAgari radOkiAgari
     */
    @JsonProperty("radOkiAgari")
    public void setRadOkiAgari(RadioButton radOkiAgari) {
        this.radOkiAgari = radOkiAgari;
    }

    // </editor-fold>
}
