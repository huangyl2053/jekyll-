package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.TokubetsuChiikiKasanGemmenRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokubetsuChiikiKasanGemmenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChiikiKasanGemmenDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinseiDate")
    private Label lblShinseiDate;
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    private TokubetsuChiikiKasanGemmenRiyoshaFutanDiv TokubetsuChiikiKasanGemmenRiyoshaFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseiDate")
    public Label getLblShinseiDate() {
        return lblShinseiDate;
    }

    @JsonProperty("lblShinseiDate")
    public void setLblShinseiDate(Label lblShinseiDate) {
        this.lblShinseiDate=lblShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    public TokubetsuChiikiKasanGemmenRiyoshaFutanDiv getTokubetsuChiikiKasanGemmenRiyoshaFutan() {
        return TokubetsuChiikiKasanGemmenRiyoshaFutan;
    }

    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    public void setTokubetsuChiikiKasanGemmenRiyoshaFutan(TokubetsuChiikiKasanGemmenRiyoshaFutanDiv TokubetsuChiikiKasanGemmenRiyoshaFutan) {
        this.TokubetsuChiikiKasanGemmenRiyoshaFutan=TokubetsuChiikiKasanGemmenRiyoshaFutan;
    }

}
