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
 * Shuturyokujun4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Shuturyokujun4Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuturyokujun33")
    private TextBox txtShuturyokujun33;
    @JsonProperty("txtShuturyokujun34")
    private TextBox txtShuturyokujun34;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuturyokujun33")
    public TextBox getTxtShuturyokujun33() {
        return txtShuturyokujun33;
    }

    @JsonProperty("txtShuturyokujun33")
    public void setTxtShuturyokujun33(TextBox txtShuturyokujun33) {
        this.txtShuturyokujun33=txtShuturyokujun33;
    }

    @JsonProperty("txtShuturyokujun34")
    public TextBox getTxtShuturyokujun34() {
        return txtShuturyokujun34;
    }

    @JsonProperty("txtShuturyokujun34")
    public void setTxtShuturyokujun34(TextBox txtShuturyokujun34) {
        this.txtShuturyokujun34=txtShuturyokujun34;
    }

}
