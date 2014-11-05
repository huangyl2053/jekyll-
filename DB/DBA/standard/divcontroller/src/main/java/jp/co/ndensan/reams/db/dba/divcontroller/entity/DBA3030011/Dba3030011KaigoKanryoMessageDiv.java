package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA3030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigokanryomessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Dba3030011KaigoKanryoMessage のクラスファイル
 *
 * @author 自動生成
 */
public class Dba3030011KaigoKanryoMessageDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public KaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }
}
