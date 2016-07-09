package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shokuji のクラスファイル
 *
 * @author 自動生成
 */
public class ShokujiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShokuji")
    private ButtonDialog btnShokuji;
    @JsonProperty("radShokuji")
    private RadioButton radShokuji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShokuji
     * @return btnShokuji
     */
    @JsonProperty("btnShokuji")
    public ButtonDialog getBtnShokuji() {
        return btnShokuji;
    }

    /*
     * setbtnShokuji
     * @param btnShokuji btnShokuji
     */
    @JsonProperty("btnShokuji")
    public void setBtnShokuji(ButtonDialog btnShokuji) {
        this.btnShokuji = btnShokuji;
    }

    /*
     * getradShokuji
     * @return radShokuji
     */
    @JsonProperty("radShokuji")
    public RadioButton getRadShokuji() {
        return radShokuji;
    }

    /*
     * setradShokuji
     * @param radShokuji radShokuji
     */
    @JsonProperty("radShokuji")
    public void setRadShokuji(RadioButton radShokuji) {
        this.radShokuji = radShokuji;
    }

    // </editor-fold>
}
