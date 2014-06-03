package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.FutangendogakuNinteiRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutangendogakuNinteiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuNinteiDetailDiv extends Panel {
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
    @JsonProperty("lblShinseiRiyu")
    private Label lblShinseiRiyu;
    @JsonProperty("txtShinseiRiyu")
    private TextBox txtShinseiRiyu;
    @JsonProperty("FutangendogakuNinteiRiyoshaFutan")
    private FutangendogakuNinteiRiyoshaFutanDiv FutangendogakuNinteiRiyoshaFutan;

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

    @JsonProperty("lblShinseiRiyu")
    public Label getLblShinseiRiyu() {
        return lblShinseiRiyu;
    }

    @JsonProperty("lblShinseiRiyu")
    public void setLblShinseiRiyu(Label lblShinseiRiyu) {
        this.lblShinseiRiyu=lblShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBox getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBox txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("FutangendogakuNinteiRiyoshaFutan")
    public FutangendogakuNinteiRiyoshaFutanDiv getFutangendogakuNinteiRiyoshaFutan() {
        return FutangendogakuNinteiRiyoshaFutan;
    }

    @JsonProperty("FutangendogakuNinteiRiyoshaFutan")
    public void setFutangendogakuNinteiRiyoshaFutan(FutangendogakuNinteiRiyoshaFutanDiv FutangendogakuNinteiRiyoshaFutan) {
        this.FutangendogakuNinteiRiyoshaFutan=FutangendogakuNinteiRiyoshaFutan;
    }

}
