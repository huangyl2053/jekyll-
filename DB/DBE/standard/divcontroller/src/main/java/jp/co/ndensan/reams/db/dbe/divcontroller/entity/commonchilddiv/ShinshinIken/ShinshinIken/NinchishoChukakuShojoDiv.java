package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinchishoChukakuShojo のクラスファイル 
 * 
 */
public class NinchishoChukakuShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTankiKioku")
    private RadioButton radTankiKioku;
    @JsonProperty("radNichijoNinchiNoryoku")
    private RadioButton radNichijoNinchiNoryoku;
    @JsonProperty("radIshiDentatsuNoryoku")
    private RadioButton radIshiDentatsuNoryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTankiKioku
     * @return radTankiKioku
     */
    @JsonProperty("radTankiKioku")
    public RadioButton getRadTankiKioku() {
        return radTankiKioku;
    }

    /*
     * setradTankiKioku
     * @param radTankiKioku radTankiKioku
     */
    @JsonProperty("radTankiKioku")
    public void setRadTankiKioku(RadioButton radTankiKioku) {
        this.radTankiKioku = radTankiKioku;
    }

    /*
     * getradNichijoNinchiNoryoku
     * @return radNichijoNinchiNoryoku
     */
    @JsonProperty("radNichijoNinchiNoryoku")
    public RadioButton getRadNichijoNinchiNoryoku() {
        return radNichijoNinchiNoryoku;
    }

    /*
     * setradNichijoNinchiNoryoku
     * @param radNichijoNinchiNoryoku radNichijoNinchiNoryoku
     */
    @JsonProperty("radNichijoNinchiNoryoku")
    public void setRadNichijoNinchiNoryoku(RadioButton radNichijoNinchiNoryoku) {
        this.radNichijoNinchiNoryoku = radNichijoNinchiNoryoku;
    }

    /*
     * getradIshiDentatsuNoryoku
     * @return radIshiDentatsuNoryoku
     */
    @JsonProperty("radIshiDentatsuNoryoku")
    public RadioButton getRadIshiDentatsuNoryoku() {
        return radIshiDentatsuNoryoku;
    }

    /*
     * setradIshiDentatsuNoryoku
     * @param radIshiDentatsuNoryoku radIshiDentatsuNoryoku
     */
    @JsonProperty("radIshiDentatsuNoryoku")
    public void setRadIshiDentatsuNoryoku(RadioButton radIshiDentatsuNoryoku) {
        this.radIshiDentatsuNoryoku = radIshiDentatsuNoryoku;
    }

    // </editor-fold>
}
