package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken;
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
 * @author 自動生成
 */
public class NinchishoChukakuShojoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    @JsonProperty("radShokujiKoi")
    private RadioButton radShokujiKoi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radTankiKioku")
    public RadioButton getRadTankiKioku() {
        return radTankiKioku;
    }

    @JsonProperty("radTankiKioku")
    public void setRadTankiKioku(RadioButton radTankiKioku) {
        this.radTankiKioku=radTankiKioku;
    }

    @JsonProperty("radNichijoNinchiNoryoku")
    public RadioButton getRadNichijoNinchiNoryoku() {
        return radNichijoNinchiNoryoku;
    }

    @JsonProperty("radNichijoNinchiNoryoku")
    public void setRadNichijoNinchiNoryoku(RadioButton radNichijoNinchiNoryoku) {
        this.radNichijoNinchiNoryoku=radNichijoNinchiNoryoku;
    }

    @JsonProperty("radIshiDentatsuNoryoku")
    public RadioButton getRadIshiDentatsuNoryoku() {
        return radIshiDentatsuNoryoku;
    }

    @JsonProperty("radIshiDentatsuNoryoku")
    public void setRadIshiDentatsuNoryoku(RadioButton radIshiDentatsuNoryoku) {
        this.radIshiDentatsuNoryoku=radIshiDentatsuNoryoku;
    }

    @JsonProperty("radShokujiKoi")
    public RadioButton getRadShokujiKoi() {
        return radShokujiKoi;
    }

    @JsonProperty("radShokujiKoi")
    public void setRadShokujiKoi(RadioButton radShokujiKoi) {
        this.radShokujiKoi=radShokujiKoi;
    }

    // </editor-fold>
}
