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
 * Hindo のクラスファイル
 *
 * @author 自動生成
 */
public class HindoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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

    // </editor-fold>
}
