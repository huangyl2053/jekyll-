package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoKanryoMessage のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoKanryoMessageDiv extends Panel implements IKaigoKanryoMessageDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void setSuccessMessage(RString messageMein, RString messageTaisho1, RString messageTaisho2) {
        ccdKanryoMessage.setMessage(messageMein, messageTaisho1, messageTaisho2, true);
    }
}
