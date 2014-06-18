package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * SearchConditionToShinsazumiShikyuShinseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionToShinsazumiShikyuShinseiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsaDate")
    private TextBoxDateRange txtShinsaDate;
    @JsonProperty("btnSearchShinsazumi")
    private Button btnSearchShinsazumi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsaDate")
    public TextBoxDateRange getTxtShinsaDate() {
        return txtShinsaDate;
    }

    @JsonProperty("txtShinsaDate")
    public void setTxtShinsaDate(TextBoxDateRange txtShinsaDate) {
        this.txtShinsaDate=txtShinsaDate;
    }

    @JsonProperty("btnSearchShinsazumi")
    public Button getBtnSearchShinsazumi() {
        return btnSearchShinsazumi;
    }

    @JsonProperty("btnSearchShinsazumi")
    public void setBtnSearchShinsazumi(Button btnSearchShinsazumi) {
        this.btnSearchShinsazumi=btnSearchShinsazumi;
    }

}
