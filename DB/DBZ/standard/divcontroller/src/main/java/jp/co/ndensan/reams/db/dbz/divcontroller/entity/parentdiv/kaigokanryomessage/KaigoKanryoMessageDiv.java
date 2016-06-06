package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigokanryomessage;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
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

    @JsonProperty("KanryoMessage")
    private IKanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KanryoMessage")
    public IKanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    @Override
    public void setSuccessMessage(RString messageMein, RString messageTaisho1, RString messageTaisho2) {

    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：文字列の場合）を行います。
     *
     * @param message 完了メッセージ文字列
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    @Override
    public void setMessage(RString message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：文字列の場合、ラベル設定）を行います。
     *
     * @param message 完了メッセージ文字列
     * @param messageTaishoLabel 完了メッセージ対象ラベル
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    @Override
    public void setMessage(RString message, RString messageTaishoLabel, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」の場合）を行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     */
    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2, boolean isSuccess) {
    }

    /**
     * 親画面から介護完了メッセージを引き渡す時の処理（メッセージ：オブジェクト「IMessageGettable」、且つ置換文字列があるの場合）を行います。
     *
     * @param message 完了メッセージオブジェクト
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     * @param isSuccess 完了ステータス 成功ならばtrue
     * @param replaces メッセージ置換文字列
     */
    @Override
    public void setMessage(IMessageGettable message, RString messageTaisho1, RString messageTaisho2,
            boolean isSuccess, String... replaces) {
    }
    /**
     * 親画面から完了メッセージを引き渡す時の処理を行います。 <br/>
     * 失敗時の完了メッセージが出力されます。
     *
     * @param messageMain 完了メッセージメイン
     * @param messageTaisho1 完了メッセージ対象情報1
     * @param messageTaisho2 完了メッセージ対象情報2
     */
    @Override
    public void setFailMessage(RString messageMain, RString messageTaisho1, RString messageTaisho2) {
    }

    /**
     * 親画面から完了メッセージを引き渡す時の処理を行います。<br/>
     * 対象情報のメッセージを省略した形で、成功時の完了メッセージが出力されます。
     *
     * @param messageMain 完了メッセージメイン
     */
    @Override
    public void setSuccessMessage(RString messageMain) {
    }

    /**
     * 親画面から完了メッセージを引き渡す時の処理を行います。<br/>
     * 対象情報のメッセージを省略した形で、失敗時の完了メッセージが出力されます。
     *
     * @param messageMain 完了メッセージメイン
     */
    @Override
    public void setFailMessage(RString messageMain) {

    }
}
