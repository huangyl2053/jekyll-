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
 * SearchConditionToMishinsaShikyuShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionToMishinsaShikyuShinseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikyuShinseiDate")
    private TextBoxDateRange txtShikyuShinseiDate;
    @JsonProperty("btnSearchMishinsa")
    private Button btnSearchMishinsa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikyuShinseiDate")
    public TextBoxDateRange getTxtShikyuShinseiDate() {
        return txtShikyuShinseiDate;
    }

    @JsonProperty("txtShikyuShinseiDate")
    public void setTxtShikyuShinseiDate(TextBoxDateRange txtShikyuShinseiDate) {
        this.txtShikyuShinseiDate=txtShikyuShinseiDate;
    }

    @JsonProperty("btnSearchMishinsa")
    public Button getBtnSearchMishinsa() {
        return btnSearchMishinsa;
    }

    @JsonProperty("btnSearchMishinsa")
    public void setBtnSearchMishinsa(Button btnSearchMishinsa) {
        this.btnSearchMishinsa=btnSearchMishinsa;
    }

}
