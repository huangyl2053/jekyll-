package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISeikatsuhogoRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSeikatsuhogoRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SeikatsuhogoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuhogoRirekiDiv extends Panel implements ISeikatsuhogoRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddRow")
    private Button btnAddRow;
    @JsonProperty("dgSeikatsuhogoRireki")
    private DataGrid<dgSeikatsuhogoRireki_Row> dgSeikatsuhogoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddRow")
    public Button getBtnAddRow() {
        return btnAddRow;
    }

    @JsonProperty("btnAddRow")
    public void setBtnAddRow(Button btnAddRow) {
        this.btnAddRow=btnAddRow;
    }

    @JsonProperty("dgSeikatsuhogoRireki")
    public DataGrid<dgSeikatsuhogoRireki_Row> getDgSeikatsuhogoRireki() {
        return dgSeikatsuhogoRireki;
    }

    @JsonProperty("dgSeikatsuhogoRireki")
    public void setDgSeikatsuhogoRireki(DataGrid<dgSeikatsuhogoRireki_Row> dgSeikatsuhogoRireki) {
        this.dgSeikatsuhogoRireki=dgSeikatsuhogoRireki;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
