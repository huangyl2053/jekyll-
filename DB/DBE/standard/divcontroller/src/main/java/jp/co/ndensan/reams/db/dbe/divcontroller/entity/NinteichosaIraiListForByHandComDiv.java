package jp.co.ndensan.reams.db.dbe.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiListForByHandCom のクラスファイル
 *
 * @author 自動生成
 */
public class NinteichosaIraiListForByHandComDiv extends Panel implements INinteichosaIraiListForByHandComDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("dgNinteichosaIraiListForByHand")
    private DataGrid<dgNinteichosaIraiListForByHand_Row> dgNinteichosaIraiListForByHand;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgNinteichosaIraiListForByHand")
    public DataGrid<dgNinteichosaIraiListForByHand_Row> getDgNinteichosaIraiListForByHand() {
        return dgNinteichosaIraiListForByHand;
    }

    @JsonProperty("dgNinteichosaIraiListForByHand")
    public void setDgNinteichosaIraiListForByHand(DataGrid<dgNinteichosaIraiListForByHand_Row> dgNinteichosaIraiListForByHand) {
        this.dgNinteichosaIraiListForByHand = dgNinteichosaIraiListForByHand;
    }

    //--------------- この行より下にコードを追加してください -------------------
}
