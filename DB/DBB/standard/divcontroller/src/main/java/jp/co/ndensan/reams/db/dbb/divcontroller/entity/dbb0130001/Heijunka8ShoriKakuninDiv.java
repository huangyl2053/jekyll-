package jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.dgHeijunka8ShoriKakunin1_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Heijunka8ShoriKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class Heijunka8ShoriKakuninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHeijunka8ShoriKakunin1")
    private DataGrid<dgHeijunka8ShoriKakunin1_Row> dgHeijunka8ShoriKakunin1;
    @JsonProperty("lblShoriKakunin1")
    private Label lblShoriKakunin1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgHeijunka8ShoriKakunin1")
    public DataGrid<dgHeijunka8ShoriKakunin1_Row> getDgHeijunka8ShoriKakunin1() {
        return dgHeijunka8ShoriKakunin1;
    }

    @JsonProperty("dgHeijunka8ShoriKakunin1")
    public void setDgHeijunka8ShoriKakunin1(DataGrid<dgHeijunka8ShoriKakunin1_Row> dgHeijunka8ShoriKakunin1) {
        this.dgHeijunka8ShoriKakunin1=dgHeijunka8ShoriKakunin1;
    }

    @JsonProperty("lblShoriKakunin1")
    public Label getLblShoriKakunin1() {
        return lblShoriKakunin1;
    }

    @JsonProperty("lblShoriKakunin1")
    public void setLblShoriKakunin1(Label lblShoriKakunin1) {
        this.lblShoriKakunin1=lblShoriKakunin1;
    }

}
