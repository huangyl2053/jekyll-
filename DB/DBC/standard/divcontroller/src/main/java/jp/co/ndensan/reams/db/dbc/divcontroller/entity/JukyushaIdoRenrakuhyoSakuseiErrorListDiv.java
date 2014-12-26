package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IJukyushaIdoRenrakuhyoSakuseiErrorListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgErrorList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTeiseiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoSakuseiErrorList のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoSakuseiErrorListDiv extends Panel implements IJukyushaIdoRenrakuhyoSakuseiErrorListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblErrorList")
    private Label lblErrorList;
    @JsonProperty("dgErrorList")
    private DataGrid<dgErrorList_Row> dgErrorList;
    @JsonProperty("lblTeiseiList")
    private Label lblTeiseiList;
    @JsonProperty("dgTeiseiList")
    private DataGrid<dgTeiseiList_Row> dgTeiseiList;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblErrorList")
    public Label getLblErrorList() {
        return lblErrorList;
    }

    @JsonProperty("lblErrorList")
    public void setLblErrorList(Label lblErrorList) {
        this.lblErrorList=lblErrorList;
    }

    @JsonProperty("dgErrorList")
    public DataGrid<dgErrorList_Row> getDgErrorList() {
        return dgErrorList;
    }

    @JsonProperty("dgErrorList")
    public void setDgErrorList(DataGrid<dgErrorList_Row> dgErrorList) {
        this.dgErrorList=dgErrorList;
    }

    @JsonProperty("lblTeiseiList")
    public Label getLblTeiseiList() {
        return lblTeiseiList;
    }

    @JsonProperty("lblTeiseiList")
    public void setLblTeiseiList(Label lblTeiseiList) {
        this.lblTeiseiList=lblTeiseiList;
    }

    @JsonProperty("dgTeiseiList")
    public DataGrid<dgTeiseiList_Row> getDgTeiseiList() {
        return dgTeiseiList;
    }

    @JsonProperty("dgTeiseiList")
    public void setDgTeiseiList(DataGrid<dgTeiseiList_Row> dgTeiseiList) {
        this.dgTeiseiList=dgTeiseiList;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
