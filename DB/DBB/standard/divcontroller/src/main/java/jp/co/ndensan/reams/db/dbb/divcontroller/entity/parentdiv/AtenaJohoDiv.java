package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.kaigofukakihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
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

    @JsonProperty("KaigoAtenaInfo")
    private KaigoAtenaInfoDiv KaigoAtenaInfo;
    @JsonProperty("KaigoFukaKihon")
    private KaigoFukaKihonDiv KaigoFukaKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KaigoAtenaInfo")
    public KaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return KaigoAtenaInfo;
    }

    @JsonProperty("KaigoAtenaInfo")
    public void setKaigoAtenaInfo(KaigoAtenaInfoDiv KaigoAtenaInfo) {
        this.KaigoAtenaInfo = KaigoAtenaInfo;
    }

    @JsonProperty("KaigoFukaKihon")
    public KaigoFukaKihonDiv getKaigoFukaKihon() {
        return KaigoFukaKihon;
    }

    @JsonProperty("KaigoFukaKihon")
    public void setKaigoFukaKihon(KaigoFukaKihonDiv KaigoFukaKihon) {
        this.KaigoFukaKihon = KaigoFukaKihon;
    }

}
