package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShojoAnteisei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShojoAnteiseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShojoAnteisei")
    private RadioButton radShojoAnteisei;
    @JsonProperty("txtFuanteiShosaiJokyo")
    private TextBox txtFuanteiShosaiJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShojoAnteisei
     * @return radShojoAnteisei
     */
    @JsonProperty("radShojoAnteisei")
    public RadioButton getRadShojoAnteisei() {
        return radShojoAnteisei;
    }

    /*
     * setradShojoAnteisei
     * @param radShojoAnteisei radShojoAnteisei
     */
    @JsonProperty("radShojoAnteisei")
    public void setRadShojoAnteisei(RadioButton radShojoAnteisei) {
        this.radShojoAnteisei = radShojoAnteisei;
    }

    /*
     * gettxtFuanteiShosaiJokyo
     * @return txtFuanteiShosaiJokyo
     */
    @JsonProperty("txtFuanteiShosaiJokyo")
    public TextBox getTxtFuanteiShosaiJokyo() {
        return txtFuanteiShosaiJokyo;
    }

    /*
     * settxtFuanteiShosaiJokyo
     * @param txtFuanteiShosaiJokyo txtFuanteiShosaiJokyo
     */
    @JsonProperty("txtFuanteiShosaiJokyo")
    public void setTxtFuanteiShosaiJokyo(TextBox txtFuanteiShosaiJokyo) {
        this.txtFuanteiShosaiJokyo = txtFuanteiShosaiJokyo;
    }

    // </editor-fold>
}
