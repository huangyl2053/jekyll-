package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002;
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
 * NinteiTorikeshi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiTorikeshiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiTorikeshiRiyu")
    private TextBox txtNinteiTorikeshiRiyu;
    @JsonProperty("txtTorikeshiYMD")
    private TextBoxFlexibleDate txtTorikeshiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiTorikeshiRiyu")
    public TextBox getTxtNinteiTorikeshiRiyu() {
        return txtNinteiTorikeshiRiyu;
    }

    @JsonProperty("txtNinteiTorikeshiRiyu")
    public void setTxtNinteiTorikeshiRiyu(TextBox txtNinteiTorikeshiRiyu) {
        this.txtNinteiTorikeshiRiyu=txtNinteiTorikeshiRiyu;
    }

    @JsonProperty("txtTorikeshiYMD")
    public TextBoxFlexibleDate getTxtTorikeshiYMD() {
        return txtTorikeshiYMD;
    }

    @JsonProperty("txtTorikeshiYMD")
    public void setTxtTorikeshiYMD(TextBoxFlexibleDate txtTorikeshiYMD) {
        this.txtTorikeshiYMD=txtTorikeshiYMD;
    }

}
