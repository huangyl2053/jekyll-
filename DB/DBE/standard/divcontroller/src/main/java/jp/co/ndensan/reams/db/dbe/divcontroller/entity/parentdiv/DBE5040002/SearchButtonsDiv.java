package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5040002;
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
 * SearchButtons のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchButtonsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToClearCriteria")
    private Button btnToClearCriteria;
    @JsonProperty("btnToSearch")
    private Button btnToSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToClearCriteria")
    public Button getBtnToClearCriteria() {
        return btnToClearCriteria;
    }

    @JsonProperty("btnToClearCriteria")
    public void setBtnToClearCriteria(Button btnToClearCriteria) {
        this.btnToClearCriteria=btnToClearCriteria;
    }

    @JsonProperty("btnToSearch")
    public Button getBtnToSearch() {
        return btnToSearch;
    }

    @JsonProperty("btnToSearch")
    public void setBtnToSearch(Button btnToSearch) {
        this.btnToSearch=btnToSearch;
    }

}
