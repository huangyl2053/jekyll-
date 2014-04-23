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
 * ReamsCommonSearchInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReamsCommonSearchInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchShimeiLabel")
    private Label SearchShimeiLabel;
    @JsonProperty("SearchShimeiText")
    private TextBox SearchShimeiText;
    @JsonProperty("SearchDateObBirthLabel")
    private Label SearchDateObBirthLabel;
    @JsonProperty("SearchDateOfBirthText")
    private TextBox SearchDateOfBirthText;
    @JsonProperty("SearchShichosonCodeLabel")
    private Label SearchShichosonCodeLabel;
    @JsonProperty("SearchShichosonCodeText")
    private TextBox SearchShichosonCodeText;
    @JsonProperty("SearchShikibetsuCodeLabel")
    private Label SearchShikibetsuCodeLabel;
    @JsonProperty("SearchShikibetsuCodeText")
    private TextBox SearchShikibetsuCodeText;
    @JsonProperty("SearchSetaiCodeLabel")
    private Label SearchSetaiCodeLabel;
    @JsonProperty("SearchSetaiCodeText")
    private TextBox SearchSetaiCodeText;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchShimeiLabel")
    public Label getSearchShimeiLabel() {
        return SearchShimeiLabel;
    }

    @JsonProperty("SearchShimeiLabel")
    public void setSearchShimeiLabel(Label SearchShimeiLabel) {
        this.SearchShimeiLabel=SearchShimeiLabel;
    }

    @JsonProperty("SearchShimeiText")
    public TextBox getSearchShimeiText() {
        return SearchShimeiText;
    }

    @JsonProperty("SearchShimeiText")
    public void setSearchShimeiText(TextBox SearchShimeiText) {
        this.SearchShimeiText=SearchShimeiText;
    }

    @JsonProperty("SearchDateObBirthLabel")
    public Label getSearchDateObBirthLabel() {
        return SearchDateObBirthLabel;
    }

    @JsonProperty("SearchDateObBirthLabel")
    public void setSearchDateObBirthLabel(Label SearchDateObBirthLabel) {
        this.SearchDateObBirthLabel=SearchDateObBirthLabel;
    }

    @JsonProperty("SearchDateOfBirthText")
    public TextBox getSearchDateOfBirthText() {
        return SearchDateOfBirthText;
    }

    @JsonProperty("SearchDateOfBirthText")
    public void setSearchDateOfBirthText(TextBox SearchDateOfBirthText) {
        this.SearchDateOfBirthText=SearchDateOfBirthText;
    }

    @JsonProperty("SearchShichosonCodeLabel")
    public Label getSearchShichosonCodeLabel() {
        return SearchShichosonCodeLabel;
    }

    @JsonProperty("SearchShichosonCodeLabel")
    public void setSearchShichosonCodeLabel(Label SearchShichosonCodeLabel) {
        this.SearchShichosonCodeLabel=SearchShichosonCodeLabel;
    }

    @JsonProperty("SearchShichosonCodeText")
    public TextBox getSearchShichosonCodeText() {
        return SearchShichosonCodeText;
    }

    @JsonProperty("SearchShichosonCodeText")
    public void setSearchShichosonCodeText(TextBox SearchShichosonCodeText) {
        this.SearchShichosonCodeText=SearchShichosonCodeText;
    }

    @JsonProperty("SearchShikibetsuCodeLabel")
    public Label getSearchShikibetsuCodeLabel() {
        return SearchShikibetsuCodeLabel;
    }

    @JsonProperty("SearchShikibetsuCodeLabel")
    public void setSearchShikibetsuCodeLabel(Label SearchShikibetsuCodeLabel) {
        this.SearchShikibetsuCodeLabel=SearchShikibetsuCodeLabel;
    }

    @JsonProperty("SearchShikibetsuCodeText")
    public TextBox getSearchShikibetsuCodeText() {
        return SearchShikibetsuCodeText;
    }

    @JsonProperty("SearchShikibetsuCodeText")
    public void setSearchShikibetsuCodeText(TextBox SearchShikibetsuCodeText) {
        this.SearchShikibetsuCodeText=SearchShikibetsuCodeText;
    }

    @JsonProperty("SearchSetaiCodeLabel")
    public Label getSearchSetaiCodeLabel() {
        return SearchSetaiCodeLabel;
    }

    @JsonProperty("SearchSetaiCodeLabel")
    public void setSearchSetaiCodeLabel(Label SearchSetaiCodeLabel) {
        this.SearchSetaiCodeLabel=SearchSetaiCodeLabel;
    }

    @JsonProperty("SearchSetaiCodeText")
    public TextBox getSearchSetaiCodeText() {
        return SearchSetaiCodeText;
    }

    @JsonProperty("SearchSetaiCodeText")
    public void setSearchSetaiCodeText(TextBox SearchSetaiCodeText) {
        this.SearchSetaiCodeText=SearchSetaiCodeText;
    }

}
