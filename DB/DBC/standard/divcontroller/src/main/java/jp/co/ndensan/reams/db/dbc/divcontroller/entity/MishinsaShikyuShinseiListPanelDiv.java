package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShinsaButtonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SystemCheckDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * MishinsaShikyuShinseiListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MishinsaShikyuShinseiListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsaDate")
    private TextBoxDate txtShinsaDate;
    @JsonProperty("btnKari")
    private Button btnKari;
    @JsonProperty("dgMishinsaShikyuShinsei")
    private DataGrid<dgMishinsaShikyuShinsei_Row> dgMishinsaShikyuShinsei;
    @JsonProperty("ShinsaButton")
    private ShinsaButtonDiv ShinsaButton;
    @JsonProperty("SystemCheck")
    private SystemCheckDiv SystemCheck;

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

    @JsonProperty("btnKari")
    public Button getBtnKari() {
        return btnKari;
    }

    @JsonProperty("btnKari")
    public void setBtnKari(Button btnKari) {
        this.btnKari=btnKari;
    }

    @JsonProperty("dgMishinsaShikyuShinsei")
    public DataGrid<dgMishinsaShikyuShinsei_Row> getDgMishinsaShikyuShinsei() {
        return dgMishinsaShikyuShinsei;
    }

    @JsonProperty("dgMishinsaShikyuShinsei")
    public void setDgMishinsaShikyuShinsei(DataGrid<dgMishinsaShikyuShinsei_Row> dgMishinsaShikyuShinsei) {
        this.dgMishinsaShikyuShinsei=dgMishinsaShikyuShinsei;
    }

    @JsonProperty("ShinsaButton")
    public ShinsaButtonDiv getShinsaButton() {
        return ShinsaButton;
    }

    @JsonProperty("ShinsaButton")
    public void setShinsaButton(ShinsaButtonDiv ShinsaButton) {
        this.ShinsaButton=ShinsaButton;
    }

    @JsonProperty("SystemCheck")
    public SystemCheckDiv getSystemCheck() {
        return SystemCheck;
    }

    @JsonProperty("SystemCheck")
    public void setSystemCheck(SystemCheckDiv SystemCheck) {
        this.SystemCheck=SystemCheck;
    }

}
