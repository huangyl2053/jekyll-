package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Teikou のクラスファイル
 *
 * @author 自動生成
 */
public class TeikouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTeikou")
    private ButtonDialog btnTeikou;
    @JsonProperty("radTeikou")
    private RadioButton radTeikou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTeikou
     * @return btnTeikou
     */
    @JsonProperty("btnTeikou")
    public ButtonDialog getBtnTeikou() {
        return btnTeikou;
    }

    /*
     * setbtnTeikou
     * @param btnTeikou btnTeikou
     */
    @JsonProperty("btnTeikou")
    public void setBtnTeikou(ButtonDialog btnTeikou) {
        this.btnTeikou = btnTeikou;
    }

    /*
     * getradTeikou
     * @return radTeikou
     */
    @JsonProperty("radTeikou")
    public RadioButton getRadTeikou() {
        return radTeikou;
    }

    /*
     * setradTeikou
     * @param radTeikou radTeikou
     */
    @JsonProperty("radTeikou")
    public void setRadTeikou(RadioButton radTeikou) {
        this.radTeikou = radTeikou;
    }

    // </editor-fold>
}
