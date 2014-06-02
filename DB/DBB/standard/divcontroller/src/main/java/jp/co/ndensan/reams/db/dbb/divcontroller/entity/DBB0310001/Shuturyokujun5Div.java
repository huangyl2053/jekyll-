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
 * Shuturyokujun5 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Shuturyokujun5Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuturyokujun35")
    private TextBox txtShuturyokujun35;
    @JsonProperty("txtShuturyokujun36")
    private TextBox txtShuturyokujun36;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuturyokujun35")
    public TextBox getTxtShuturyokujun35() {
        return txtShuturyokujun35;
    }

    @JsonProperty("txtShuturyokujun35")
    public void setTxtShuturyokujun35(TextBox txtShuturyokujun35) {
        this.txtShuturyokujun35=txtShuturyokujun35;
    }

    @JsonProperty("txtShuturyokujun36")
    public TextBox getTxtShuturyokujun36() {
        return txtShuturyokujun36;
    }

    @JsonProperty("txtShuturyokujun36")
    public void setTxtShuturyokujun36(TextBox txtShuturyokujun36) {
        this.txtShuturyokujun36=txtShuturyokujun36;
    }

}
