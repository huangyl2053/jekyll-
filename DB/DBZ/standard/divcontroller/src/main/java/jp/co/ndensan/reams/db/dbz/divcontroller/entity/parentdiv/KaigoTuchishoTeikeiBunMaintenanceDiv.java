package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * KaigoTuchishoTeikeiBunMaintenance のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoTuchishoTeikeiBunMaintenanceDiv extends Panel implements IKaigoTuchishoTeikeiBunMaintenanceDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtBunsho")
    private TextBoxMultiLine txtBunsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtBunsho")
    public TextBoxMultiLine getTxtBunsho() {
        return txtBunsho;
    }

    @JsonProperty("txtBunsho")
    public void setTxtBunsho(TextBoxMultiLine txtBunsho) {
        this.txtBunsho = txtBunsho;
    }

    //--------------- この行より下にコードを追加してください -------------------
}
