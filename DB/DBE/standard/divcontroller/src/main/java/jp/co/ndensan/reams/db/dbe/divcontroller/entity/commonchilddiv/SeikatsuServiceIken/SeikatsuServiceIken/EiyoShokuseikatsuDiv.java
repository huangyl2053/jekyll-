package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EiyoShokuseikatsu のクラスファイル 
 * 
 */
public class EiyoShokuseikatsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShokujiKoi")
    private RadioButton radShokujiKoi;
    @JsonProperty("radGenzaiEiyoJotai")
    private RadioButton radGenzaiEiyoJotai;
    @JsonProperty("txtEiyoShokuseikatsuRyuiten")
    private TextBox txtEiyoShokuseikatsuRyuiten;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShokujiKoi
     * @return radShokujiKoi
     */
    @JsonProperty("radShokujiKoi")
    public RadioButton getRadShokujiKoi() {
        return radShokujiKoi;
    }

    /*
     * setradShokujiKoi
     * @param radShokujiKoi radShokujiKoi
     */
    @JsonProperty("radShokujiKoi")
    public void setRadShokujiKoi(RadioButton radShokujiKoi) {
        this.radShokujiKoi = radShokujiKoi;
    }

    /*
     * getradGenzaiEiyoJotai
     * @return radGenzaiEiyoJotai
     */
    @JsonProperty("radGenzaiEiyoJotai")
    public RadioButton getRadGenzaiEiyoJotai() {
        return radGenzaiEiyoJotai;
    }

    /*
     * setradGenzaiEiyoJotai
     * @param radGenzaiEiyoJotai radGenzaiEiyoJotai
     */
    @JsonProperty("radGenzaiEiyoJotai")
    public void setRadGenzaiEiyoJotai(RadioButton radGenzaiEiyoJotai) {
        this.radGenzaiEiyoJotai = radGenzaiEiyoJotai;
    }

    /*
     * gettxtEiyoShokuseikatsuRyuiten
     * @return txtEiyoShokuseikatsuRyuiten
     */
    @JsonProperty("txtEiyoShokuseikatsuRyuiten")
    public TextBox getTxtEiyoShokuseikatsuRyuiten() {
        return txtEiyoShokuseikatsuRyuiten;
    }

    /*
     * settxtEiyoShokuseikatsuRyuiten
     * @param txtEiyoShokuseikatsuRyuiten txtEiyoShokuseikatsuRyuiten
     */
    @JsonProperty("txtEiyoShokuseikatsuRyuiten")
    public void setTxtEiyoShokuseikatsuRyuiten(TextBox txtEiyoShokuseikatsuRyuiten) {
        this.txtEiyoShokuseikatsuRyuiten = txtEiyoShokuseikatsuRyuiten;
    }

    // </editor-fold>
}
