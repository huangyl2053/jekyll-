package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv;
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
 * GenGakuKikan2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenGakuKikan2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGenGakuKikan")
    private Label lblGenGakuKikan;
    @JsonProperty("txtGenGakuKikan")
    private TextBoxNum txtGenGakuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblGenGakuKikan")
    public Label getLblGenGakuKikan() {
        return lblGenGakuKikan;
    }

    @JsonProperty("lblGenGakuKikan")
    public void setLblGenGakuKikan(Label lblGenGakuKikan) {
        this.lblGenGakuKikan=lblGenGakuKikan;
    }

    @JsonProperty("txtGenGakuKikan")
    public TextBoxNum getTxtGenGakuKikan() {
        return txtGenGakuKikan;
    }

    @JsonProperty("txtGenGakuKikan")
    public void setTxtGenGakuKikan(TextBoxNum txtGenGakuKikan) {
        this.txtGenGakuKikan=txtGenGakuKikan;
    }

}
