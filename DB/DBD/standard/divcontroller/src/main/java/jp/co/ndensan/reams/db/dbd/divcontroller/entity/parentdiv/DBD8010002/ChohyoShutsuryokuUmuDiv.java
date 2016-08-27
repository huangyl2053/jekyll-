package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChohyoShutsuryokuUmu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChohyoShutsuryokuUmuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblItiranhyo")
    private Label lblItiranhyo;
    @JsonProperty("lblShutsuryoku")
    private Label lblShutsuryoku;
    @JsonProperty("radSonotaChohyo")
    private RadioButton radSonotaChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblItiranhyo
     * @return lblItiranhyo
     */
    @JsonProperty("lblItiranhyo")
    public Label getLblItiranhyo() {
        return lblItiranhyo;
    }

    /*
     * setlblItiranhyo
     * @param lblItiranhyo lblItiranhyo
     */
    @JsonProperty("lblItiranhyo")
    public void setLblItiranhyo(Label lblItiranhyo) {
        this.lblItiranhyo = lblItiranhyo;
    }

    /*
     * getlblShutsuryoku
     * @return lblShutsuryoku
     */
    @JsonProperty("lblShutsuryoku")
    public Label getLblShutsuryoku() {
        return lblShutsuryoku;
    }

    /*
     * setlblShutsuryoku
     * @param lblShutsuryoku lblShutsuryoku
     */
    @JsonProperty("lblShutsuryoku")
    public void setLblShutsuryoku(Label lblShutsuryoku) {
        this.lblShutsuryoku = lblShutsuryoku;
    }

    /*
     * getradSonotaChohyo
     * @return radSonotaChohyo
     */
    @JsonProperty("radSonotaChohyo")
    public RadioButton getRadSonotaChohyo() {
        return radSonotaChohyo;
    }

    /*
     * setradSonotaChohyo
     * @param radSonotaChohyo radSonotaChohyo
     */
    @JsonProperty("radSonotaChohyo")
    public void setRadSonotaChohyo(RadioButton radSonotaChohyo) {
        this.radSonotaChohyo = radSonotaChohyo;
    }

    // </editor-fold>
}
