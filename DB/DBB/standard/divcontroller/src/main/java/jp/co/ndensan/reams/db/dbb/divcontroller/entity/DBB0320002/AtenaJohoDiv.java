package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class AtenaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KaigoFukaKihon")
    private IKaigoFukaKihonDiv KaigoFukaKihon;
    @JsonProperty("KaigoAtenaInfo")
    private IKaigoAtenaInfoDiv KaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KaigoFukaKihon")
    public IKaigoFukaKihonDiv getKaigoFukaKihon() {
        return KaigoFukaKihon;
    }

    @JsonProperty("KaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return KaigoAtenaInfo;
    }

}
