package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 08 20:00:42 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShoriJokyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoriJokyoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblJuminzeiKakutei")
    private Label lblJuminzeiKakutei;
    @JsonProperty("txtJuminzeiKakuteiNichiji")
    private TextBoxDate txtJuminzeiKakuteiNichiji;
    @JsonProperty("lblTokuchoDoteiShoriNichiji")
    private Label lblTokuchoDoteiShoriNichiji;
    @JsonProperty("txtTokuchoDoteiShoriNichiji")
    private TextBoxDate txtTokuchoDoteiShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblJuminzeiKakutei")
    public Label getLblJuminzeiKakutei() {
        return lblJuminzeiKakutei;
    }

    @JsonProperty("lblJuminzeiKakutei")
    public void setLblJuminzeiKakutei(Label lblJuminzeiKakutei) {
        this.lblJuminzeiKakutei=lblJuminzeiKakutei;
    }

    @JsonProperty("txtJuminzeiKakuteiNichiji")
    public TextBoxDate getTxtJuminzeiKakuteiNichiji() {
        return txtJuminzeiKakuteiNichiji;
    }

    @JsonProperty("txtJuminzeiKakuteiNichiji")
    public void setTxtJuminzeiKakuteiNichiji(TextBoxDate txtJuminzeiKakuteiNichiji) {
        this.txtJuminzeiKakuteiNichiji=txtJuminzeiKakuteiNichiji;
    }

    @JsonProperty("lblTokuchoDoteiShoriNichiji")
    public Label getLblTokuchoDoteiShoriNichiji() {
        return lblTokuchoDoteiShoriNichiji;
    }

    @JsonProperty("lblTokuchoDoteiShoriNichiji")
    public void setLblTokuchoDoteiShoriNichiji(Label lblTokuchoDoteiShoriNichiji) {
        this.lblTokuchoDoteiShoriNichiji=lblTokuchoDoteiShoriNichiji;
    }

    @JsonProperty("txtTokuchoDoteiShoriNichiji")
    public TextBoxDate getTxtTokuchoDoteiShoriNichiji() {
        return txtTokuchoDoteiShoriNichiji;
    }

    @JsonProperty("txtTokuchoDoteiShoriNichiji")
    public void setTxtTokuchoDoteiShoriNichiji(TextBoxDate txtTokuchoDoteiShoriNichiji) {
        this.txtTokuchoDoteiShoriNichiji=txtTokuchoDoteiShoriNichiji;
    }

}
