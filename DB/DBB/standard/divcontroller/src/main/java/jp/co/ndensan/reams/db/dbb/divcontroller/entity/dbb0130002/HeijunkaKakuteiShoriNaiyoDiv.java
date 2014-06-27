package jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002;
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
 * HeijunkaKakuteiShoriNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaKakuteiShoriNaiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtShoriNichiji")
    private TextBox txtShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtShoriNichiji")
    public TextBox getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    @JsonProperty("txtShoriNichiji")
    public void setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.txtShoriNichiji=txtShoriNichiji;
    }

}
