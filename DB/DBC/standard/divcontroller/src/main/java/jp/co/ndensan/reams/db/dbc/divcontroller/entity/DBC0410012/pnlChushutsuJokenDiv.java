package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * pnlChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlChushutsuJokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("txtShoriJoken")
    private TextBoxDate txtShoriJoken;
    @JsonProperty("txtSaishoriKubun")
    private TextBox txtSaishoriKubun;
    @JsonProperty("txtKokanShikibetsuNo")
    private TextBox txtKokanShikibetsuNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken=lblChushutsuJoken;
    }

    @JsonProperty("txtShoriJoken")
    public TextBoxDate getTxtShoriJoken() {
        return txtShoriJoken;
    }

    @JsonProperty("txtShoriJoken")
    public void setTxtShoriJoken(TextBoxDate txtShoriJoken) {
        this.txtShoriJoken=txtShoriJoken;
    }

    @JsonProperty("txtSaishoriKubun")
    public TextBox getTxtSaishoriKubun() {
        return txtSaishoriKubun;
    }

    @JsonProperty("txtSaishoriKubun")
    public void setTxtSaishoriKubun(TextBox txtSaishoriKubun) {
        this.txtSaishoriKubun=txtSaishoriKubun;
    }

    @JsonProperty("txtKokanShikibetsuNo")
    public TextBox getTxtKokanShikibetsuNo() {
        return txtKokanShikibetsuNo;
    }

    @JsonProperty("txtKokanShikibetsuNo")
    public void setTxtKokanShikibetsuNo(TextBox txtKokanShikibetsuNo) {
        this.txtKokanShikibetsuNo=txtKokanShikibetsuNo;
    }

}
