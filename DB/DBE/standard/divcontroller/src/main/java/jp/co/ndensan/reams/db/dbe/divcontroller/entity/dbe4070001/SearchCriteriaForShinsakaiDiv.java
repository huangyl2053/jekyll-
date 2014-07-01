package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.ButtonsForShinsakaiSearchDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchCriteriaForShinsakai のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchCriteriaForShinsakaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaisaiDateRange")
    private TextBoxDateRange txtKaisaiDateRange;
    @JsonProperty("ButtonsForShinsakaiSearch")
    private ButtonsForShinsakaiSearchDiv ButtonsForShinsakaiSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKaisaiDateRange")
    public TextBoxDateRange getTxtKaisaiDateRange() {
        return txtKaisaiDateRange;
    }

    @JsonProperty("txtKaisaiDateRange")
    public void setTxtKaisaiDateRange(TextBoxDateRange txtKaisaiDateRange) {
        this.txtKaisaiDateRange=txtKaisaiDateRange;
    }

    @JsonProperty("ButtonsForShinsakaiSearch")
    public ButtonsForShinsakaiSearchDiv getButtonsForShinsakaiSearch() {
        return ButtonsForShinsakaiSearch;
    }

    @JsonProperty("ButtonsForShinsakaiSearch")
    public void setButtonsForShinsakaiSearch(ButtonsForShinsakaiSearchDiv ButtonsForShinsakaiSearch) {
        this.ButtonsForShinsakaiSearch=ButtonsForShinsakaiSearch;
    }

}
