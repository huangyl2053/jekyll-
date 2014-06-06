package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
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
 * NinteiTsuchiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiTsuchiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTsuchiKbn")
    private TextBox txtTsuchiKbn;
    @JsonProperty("txtTsuchibi")
    private TextBoxDate txtTsuchibi;
    @JsonProperty("txtYukokikanKaishibi")
    private TextBoxDate txtYukokikanKaishibi;
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("txtYukokikanShuryobi")
    private TextBoxDate txtYukokikanShuryobi;
    @JsonProperty("txtTsuchiRiyu")
    private TextBox txtTsuchiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTsuchiKbn")
    public TextBox getTxtTsuchiKbn() {
        return txtTsuchiKbn;
    }

    @JsonProperty("txtTsuchiKbn")
    public void setTxtTsuchiKbn(TextBox txtTsuchiKbn) {
        this.txtTsuchiKbn=txtTsuchiKbn;
    }

    @JsonProperty("txtTsuchibi")
    public TextBoxDate getTxtTsuchibi() {
        return txtTsuchibi;
    }

    @JsonProperty("txtTsuchibi")
    public void setTxtTsuchibi(TextBoxDate txtTsuchibi) {
        this.txtTsuchibi=txtTsuchibi;
    }

    @JsonProperty("txtYukokikanKaishibi")
    public TextBoxDate getTxtYukokikanKaishibi() {
        return txtYukokikanKaishibi;
    }

    @JsonProperty("txtYukokikanKaishibi")
    public void setTxtYukokikanKaishibi(TextBoxDate txtYukokikanKaishibi) {
        this.txtYukokikanKaishibi=txtYukokikanKaishibi;
    }

    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1=Label1;
    }

    @JsonProperty("txtYukokikanShuryobi")
    public TextBoxDate getTxtYukokikanShuryobi() {
        return txtYukokikanShuryobi;
    }

    @JsonProperty("txtYukokikanShuryobi")
    public void setTxtYukokikanShuryobi(TextBoxDate txtYukokikanShuryobi) {
        this.txtYukokikanShuryobi=txtYukokikanShuryobi;
    }

    @JsonProperty("txtTsuchiRiyu")
    public TextBox getTxtTsuchiRiyu() {
        return txtTsuchiRiyu;
    }

    @JsonProperty("txtTsuchiRiyu")
    public void setTxtTsuchiRiyu(TextBox txtTsuchiRiyu) {
        this.txtTsuchiRiyu=txtTsuchiRiyu;
    }

}
