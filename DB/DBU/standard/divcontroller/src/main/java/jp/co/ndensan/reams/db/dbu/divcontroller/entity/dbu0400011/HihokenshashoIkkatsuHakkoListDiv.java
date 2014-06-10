package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.OutputOrderAndNewpageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * HihokenshashoIkkatsuHakkoList のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshashoIkkatsuHakkoListDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshashoListOutputOrderAndNewPage")
    private OutputOrderAndNewpageDiv HihokenshashoListOutputOrderAndNewPage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshashoListOutputOrderAndNewPage")
    public OutputOrderAndNewpageDiv getHihokenshashoListOutputOrderAndNewPage() {
        return HihokenshashoListOutputOrderAndNewPage;
    }

    @JsonProperty("HihokenshashoListOutputOrderAndNewPage")
    public void setHihokenshashoListOutputOrderAndNewPage(OutputOrderAndNewpageDiv HihokenshashoListOutputOrderAndNewPage) {
        this.HihokenshashoListOutputOrderAndNewPage = HihokenshashoListOutputOrderAndNewPage;
    }

}
