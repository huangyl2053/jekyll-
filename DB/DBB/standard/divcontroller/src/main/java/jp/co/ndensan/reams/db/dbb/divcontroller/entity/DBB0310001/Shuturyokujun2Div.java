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
 * Shuturyokujun2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Shuturyokujun2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuturyokujun21")
    private TextBox txtShuturyokujun21;
    @JsonProperty("txtShuturyokujun22")
    private TextBox txtShuturyokujun22;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuturyokujun21")
    public TextBox getTxtShuturyokujun21() {
        return txtShuturyokujun21;
    }

    @JsonProperty("txtShuturyokujun21")
    public void setTxtShuturyokujun21(TextBox txtShuturyokujun21) {
        this.txtShuturyokujun21=txtShuturyokujun21;
    }

    @JsonProperty("txtShuturyokujun22")
    public TextBox getTxtShuturyokujun22() {
        return txtShuturyokujun22;
    }

    @JsonProperty("txtShuturyokujun22")
    public void setTxtShuturyokujun22(TextBox txtShuturyokujun22) {
        this.txtShuturyokujun22=txtShuturyokujun22;
    }

}
