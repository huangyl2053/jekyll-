package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
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
 * SogoShokaiSetai のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiSetaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSetai1")
    private Label lblSetai1;
    @JsonProperty("lblSetai2")
    private Label lblSetai2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblSetai1")
    public Label getLblSetai1() {
        return lblSetai1;
    }

    @JsonProperty("lblSetai1")
    public void setLblSetai1(Label lblSetai1) {
        this.lblSetai1=lblSetai1;
    }

    @JsonProperty("lblSetai2")
    public Label getLblSetai2() {
        return lblSetai2;
    }

    @JsonProperty("lblSetai2")
    public void setLblSetai2(Label lblSetai2) {
        this.lblSetai2=lblSetai2;
    }

}
