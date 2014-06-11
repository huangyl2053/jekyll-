package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaRirekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendoFukaRireki")
    private TextBox txtFukaNendoFukaRireki;
    @JsonProperty("dgFukaRirekiFukaRireki")
    private DataGrid<dgFukaRirekiFukaRireki_Row> dgFukaRirekiFukaRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukaNendoFukaRireki")
    public TextBox getTxtFukaNendoFukaRireki() {
        return txtFukaNendoFukaRireki;
    }

    @JsonProperty("txtFukaNendoFukaRireki")
    public void setTxtFukaNendoFukaRireki(TextBox txtFukaNendoFukaRireki) {
        this.txtFukaNendoFukaRireki=txtFukaNendoFukaRireki;
    }

    @JsonProperty("dgFukaRirekiFukaRireki")
    public DataGrid<dgFukaRirekiFukaRireki_Row> getDgFukaRirekiFukaRireki() {
        return dgFukaRirekiFukaRireki;
    }

    @JsonProperty("dgFukaRirekiFukaRireki")
    public void setDgFukaRirekiFukaRireki(DataGrid<dgFukaRirekiFukaRireki_Row> dgFukaRirekiFukaRireki) {
        this.dgFukaRirekiFukaRireki=dgFukaRirekiFukaRireki;
    }

}
