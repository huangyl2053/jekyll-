package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IServiceTeikyoShomeishoGokeiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceTeikyoShomeishoGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceTeikyoShomeishoGokeiDiv extends Panel implements IServiceTeikyoShomeishoGokeiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceTani")
    private TextBoxNum txtServiceTani;
    @JsonProperty("txtHokengaku")
    private TextBoxNum txtHokengaku;
    @JsonProperty("txtFutangaku")
    private TextBoxNum txtFutangaku;
    @JsonProperty("txtRyoyohi")
    private TextBoxNum txtRyoyohi;
    @JsonProperty("txtShinryohi")
    private TextBoxNum txtShinryohi;
    @JsonProperty("txtShokujihi")
    private TextBoxNum txtShokujihi;
    @JsonProperty("btnServiceTeikyoShomeishoGokeiReturn")
    private Button btnServiceTeikyoShomeishoGokeiReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtServiceTani")
    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    @JsonProperty("txtServiceTani")
    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.txtServiceTani=txtServiceTani;
    }

    @JsonProperty("txtHokengaku")
    public TextBoxNum getTxtHokengaku() {
        return txtHokengaku;
    }

    @JsonProperty("txtHokengaku")
    public void setTxtHokengaku(TextBoxNum txtHokengaku) {
        this.txtHokengaku=txtHokengaku;
    }

    @JsonProperty("txtFutangaku")
    public TextBoxNum getTxtFutangaku() {
        return txtFutangaku;
    }

    @JsonProperty("txtFutangaku")
    public void setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.txtFutangaku=txtFutangaku;
    }

    @JsonProperty("txtRyoyohi")
    public TextBoxNum getTxtRyoyohi() {
        return txtRyoyohi;
    }

    @JsonProperty("txtRyoyohi")
    public void setTxtRyoyohi(TextBoxNum txtRyoyohi) {
        this.txtRyoyohi=txtRyoyohi;
    }

    @JsonProperty("txtShinryohi")
    public TextBoxNum getTxtShinryohi() {
        return txtShinryohi;
    }

    @JsonProperty("txtShinryohi")
    public void setTxtShinryohi(TextBoxNum txtShinryohi) {
        this.txtShinryohi=txtShinryohi;
    }

    @JsonProperty("txtShokujihi")
    public TextBoxNum getTxtShokujihi() {
        return txtShokujihi;
    }

    @JsonProperty("txtShokujihi")
    public void setTxtShokujihi(TextBoxNum txtShokujihi) {
        this.txtShokujihi=txtShokujihi;
    }

    @JsonProperty("btnServiceTeikyoShomeishoGokeiReturn")
    public Button getBtnServiceTeikyoShomeishoGokeiReturn() {
        return btnServiceTeikyoShomeishoGokeiReturn;
    }

    @JsonProperty("btnServiceTeikyoShomeishoGokeiReturn")
    public void setBtnServiceTeikyoShomeishoGokeiReturn(Button btnServiceTeikyoShomeishoGokeiReturn) {
        this.btnServiceTeikyoShomeishoGokeiReturn=btnServiceTeikyoShomeishoGokeiReturn;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
