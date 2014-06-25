package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GemmenTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenTsuchiKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGemmenHakkoYMD")
    private TextBoxDate txtGemmenHakkoYMD;
    @JsonProperty("lblGemmenTsuchiBunshoNo")
    private Label lblGemmenTsuchiBunshoNo;
    @JsonProperty("txtGemmenTsuchiBunshoNo")
    private TextBox txtGemmenTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtGemmenHakkoYMD")
    public TextBoxDate getTxtGemmenHakkoYMD() {
        return txtGemmenHakkoYMD;
    }

    @JsonProperty("txtGemmenHakkoYMD")
    public void setTxtGemmenHakkoYMD(TextBoxDate txtGemmenHakkoYMD) {
        this.txtGemmenHakkoYMD=txtGemmenHakkoYMD;
    }

    @JsonProperty("lblGemmenTsuchiBunshoNo")
    public Label getLblGemmenTsuchiBunshoNo() {
        return lblGemmenTsuchiBunshoNo;
    }

    @JsonProperty("lblGemmenTsuchiBunshoNo")
    public void setLblGemmenTsuchiBunshoNo(Label lblGemmenTsuchiBunshoNo) {
        this.lblGemmenTsuchiBunshoNo=lblGemmenTsuchiBunshoNo;
    }

    @JsonProperty("txtGemmenTsuchiBunshoNo")
    public TextBox getTxtGemmenTsuchiBunshoNo() {
        return txtGemmenTsuchiBunshoNo;
    }

    @JsonProperty("txtGemmenTsuchiBunshoNo")
    public void setTxtGemmenTsuchiBunshoNo(TextBox txtGemmenTsuchiBunshoNo) {
        this.txtGemmenTsuchiBunshoNo=txtGemmenTsuchiBunshoNo;
    }

}
