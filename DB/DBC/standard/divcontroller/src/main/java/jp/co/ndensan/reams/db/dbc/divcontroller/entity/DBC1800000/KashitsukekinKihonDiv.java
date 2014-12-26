package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukekinKihon のクラスファイル
 *
 * @author 自動生成
 */
public class KashitsukekinKihonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KashitsukekinKihonInfo")
    private KaigoAtenaInfoDiv KashitsukekinKihonInfo;
    @JsonProperty("KashitsukekinKaigoKihonInfo")
    private KaigoShikakuKihonDiv KashitsukekinKaigoKihonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukekinKihonInfo")
    public KaigoAtenaInfoDiv getKashitsukekinKihonInfo() {
        return KashitsukekinKihonInfo;
    }

    @JsonProperty("KashitsukekinKihonInfo")
    public void setKashitsukekinKihonInfo(KaigoAtenaInfoDiv KashitsukekinKihonInfo) {
        this.KashitsukekinKihonInfo = KashitsukekinKihonInfo;
    }

    @JsonProperty("KashitsukekinKaigoKihonInfo")
    public KaigoShikakuKihonDiv getKashitsukekinKaigoKihonInfo() {
        return KashitsukekinKaigoKihonInfo;
    }

    @JsonProperty("KashitsukekinKaigoKihonInfo")
    public void setKashitsukekinKaigoKihonInfo(KaigoShikakuKihonDiv KashitsukekinKaigoKihonInfo) {
        this.KashitsukekinKaigoKihonInfo = KashitsukekinKaigoKihonInfo;
    }

}
