package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * NofuZumiKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class NofuZumiKikanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNofuZumiKikan")
    private Label lblNofuZumiKikan;
    @JsonProperty("txtNofuZumiKikan")
    private TextBoxNum txtNofuZumiKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblNofuZumiKikan")
    public Label getLblNofuZumiKikan() {
        return lblNofuZumiKikan;
    }

    @JsonProperty("lblNofuZumiKikan")
    public void setLblNofuZumiKikan(Label lblNofuZumiKikan) {
        this.lblNofuZumiKikan=lblNofuZumiKikan;
    }

    @JsonProperty("txtNofuZumiKikan")
    public TextBoxNum getTxtNofuZumiKikan() {
        return txtNofuZumiKikan;
    }

    @JsonProperty("txtNofuZumiKikan")
    public void setTxtNofuZumiKikan(TextBoxNum txtNofuZumiKikan) {
        this.txtNofuZumiKikan=txtNofuZumiKikan;
    }

}
