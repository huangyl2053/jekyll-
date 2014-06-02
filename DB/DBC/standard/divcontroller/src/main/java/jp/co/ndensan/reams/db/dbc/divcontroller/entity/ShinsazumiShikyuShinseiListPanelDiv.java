package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShinsazumiShikyuShinsei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsazumiShikyuShinseiListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsazumiShikyuShinseiListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiDate")
    private TextBoxDate txtKetteiDate;
    @JsonProperty("dgShinsazumiShikyuShinsei")
    private DataGrid<dgShinsazumiShikyuShinsei_Row> dgShinsazumiShikyuShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxDate txtKetteiDate) {
        this.txtKetteiDate=txtKetteiDate;
    }

    @JsonProperty("dgShinsazumiShikyuShinsei")
    public DataGrid<dgShinsazumiShikyuShinsei_Row> getDgShinsazumiShikyuShinsei() {
        return dgShinsazumiShikyuShinsei;
    }

    @JsonProperty("dgShinsazumiShikyuShinsei")
    public void setDgShinsazumiShikyuShinsei(DataGrid<dgShinsazumiShikyuShinsei_Row> dgShinsazumiShikyuShinsei) {
        this.dgShinsazumiShikyuShinsei=dgShinsazumiShikyuShinsei;
    }

}
