package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiMishinsaResultList のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiMishinsaResultListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsaDate")
    private TextBoxDate txtShinsaDate;
    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    private DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    @JsonProperty("btnIkkatsuShinsa")
    private Button btnIkkatsuShinsa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsaDate")
    public TextBoxDate getTxtShinsaDate() {
        return txtShinsaDate;
    }

    @JsonProperty("txtShinsaDate")
    public void setTxtShinsaDate(TextBoxDate txtShinsaDate) {
        this.txtShinsaDate=txtShinsaDate;
    }

    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    public DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> getDgYoguKonyuhiShisaMishinsaShikyuShinseiList() {
        return dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    }

    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    public void setDgYoguKonyuhiShisaMishinsaShikyuShinseiList(DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> dgYoguKonyuhiShisaMishinsaShikyuShinseiList) {
        this.dgYoguKonyuhiShisaMishinsaShikyuShinseiList=dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    }

    @JsonProperty("btnIkkatsuShinsa")
    public Button getBtnIkkatsuShinsa() {
        return btnIkkatsuShinsa;
    }

    @JsonProperty("btnIkkatsuShinsa")
    public void setBtnIkkatsuShinsa(Button btnIkkatsuShinsa) {
        this.btnIkkatsuShinsa=btnIkkatsuShinsa;
    }

}
