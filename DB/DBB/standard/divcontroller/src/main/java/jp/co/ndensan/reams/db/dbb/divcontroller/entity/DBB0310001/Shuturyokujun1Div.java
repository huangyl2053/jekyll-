package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * Shuturyokujun1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Shuturyokujun1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuturyokujun11")
    private TextBox txtShuturyokujun11;
    @JsonProperty("txtShuturyokujun12")
    private TextBox txtShuturyokujun12;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuturyokujun11")
    public TextBox getTxtShuturyokujun11() {
        return txtShuturyokujun11;
    }

    @JsonProperty("txtShuturyokujun11")
    public void setTxtShuturyokujun11(TextBox txtShuturyokujun11) {
        this.txtShuturyokujun11=txtShuturyokujun11;
    }

    @JsonProperty("txtShuturyokujun12")
    public TextBox getTxtShuturyokujun12() {
        return txtShuturyokujun12;
    }

    @JsonProperty("txtShuturyokujun12")
    public void setTxtShuturyokujun12(TextBox txtShuturyokujun12) {
        this.txtShuturyokujun12=txtShuturyokujun12;
    }

}
