package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgMishinsaShikyuShinseiList_Row;
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
    @JsonProperty("dgMishinsaShikyuShinseiList")
    private DataGrid<dgMishinsaShikyuShinseiList_Row> dgMishinsaShikyuShinseiList;
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

    @JsonProperty("dgMishinsaShikyuShinseiList")
    public DataGrid<dgMishinsaShikyuShinseiList_Row> getDgMishinsaShikyuShinseiList() {
        return dgMishinsaShikyuShinseiList;
    }

    @JsonProperty("dgMishinsaShikyuShinseiList")
    public void setDgMishinsaShikyuShinseiList(DataGrid<dgMishinsaShikyuShinseiList_Row> dgMishinsaShikyuShinseiList) {
        this.dgMishinsaShikyuShinseiList=dgMishinsaShikyuShinseiList;
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
