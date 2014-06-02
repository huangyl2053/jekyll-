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
 * Shuturyokujun3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Shuturyokujun3Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuturyokujun31")
    private TextBox txtShuturyokujun31;
    @JsonProperty("txtShuturyokujun32")
    private TextBox txtShuturyokujun32;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuturyokujun31")
    public TextBox getTxtShuturyokujun31() {
        return txtShuturyokujun31;
    }

    @JsonProperty("txtShuturyokujun31")
    public void setTxtShuturyokujun31(TextBox txtShuturyokujun31) {
        this.txtShuturyokujun31=txtShuturyokujun31;
    }

    @JsonProperty("txtShuturyokujun32")
    public TextBox getTxtShuturyokujun32() {
        return txtShuturyokujun32;
    }

    @JsonProperty("txtShuturyokujun32")
    public void setTxtShuturyokujun32(TextBox txtShuturyokujun32) {
        this.txtShuturyokujun32=txtShuturyokujun32;
    }

}
