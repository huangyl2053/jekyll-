package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuKetteiKanryo のクラスファイル
 *
 * @author 自動生成
 */
public class ShokanShikyuKetteiKanryoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShokanShikyuKetteiKanryoMessage")
    private KaigoKanryoMessageDiv ShokanShikyuKetteiKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiKanryoMessage")
    public KaigoKanryoMessageDiv getShokanShikyuKetteiKanryoMessage() {
        return ShokanShikyuKetteiKanryoMessage;
    }

    @JsonProperty("ShokanShikyuKetteiKanryoMessage")
    public void setShokanShikyuKetteiKanryoMessage(KaigoKanryoMessageDiv ShokanShikyuKetteiKanryoMessage) {
        this.ShokanShikyuKetteiKanryoMessage = ShokanShikyuKetteiKanryoMessage;
    }

}
