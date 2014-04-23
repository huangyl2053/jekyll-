package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * DBCommonSearchInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBCommonSearchInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchHihokenshaNoLabel")
    private Label SearchHihokenshaNoLabel;
    @JsonProperty("SearchHihokenshaNoText")
    private TextBox SearchHihokenshaNoText;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchHihokenshaNoLabel")
    public Label getSearchHihokenshaNoLabel() {
        return SearchHihokenshaNoLabel;
    }

    @JsonProperty("SearchHihokenshaNoLabel")
    public void setSearchHihokenshaNoLabel(Label SearchHihokenshaNoLabel) {
        this.SearchHihokenshaNoLabel=SearchHihokenshaNoLabel;
    }

    @JsonProperty("SearchHihokenshaNoText")
    public TextBox getSearchHihokenshaNoText() {
        return SearchHihokenshaNoText;
    }

    @JsonProperty("SearchHihokenshaNoText")
    public void setSearchHihokenshaNoText(TextBox SearchHihokenshaNoText) {
        this.SearchHihokenshaNoText=SearchHihokenshaNoText;
    }

}
