package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ButtonsForNinteichosaResultEntryTarget のクラスファイル
 *
 * @author 自動生成
 */
public class ButtonsForNinteichosaResultEntryTargetDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnHiddenCallOnResume")
    private Button btnHiddenCallOnResume;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnHiddenCallOnResume")
    public Button getBtnHiddenCallOnResume() {
        return btnHiddenCallOnResume;
    }

    @JsonProperty("btnHiddenCallOnResume")
    public void setBtnHiddenCallOnResume(Button btnHiddenCallOnResume) {
        this.btnHiddenCallOnResume = btnHiddenCallOnResume;
    }

}
