package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokuTaishoshaJoho のクラスファイル
 *
 * @reamsid_L DBA-0520-030 wangkun
 */
public class ShikakuShutokuTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShikakuShutokuCommonJoho")
    private KaigoAtenaInfoDiv ShikakuShutokuCommonJoho;
    @JsonProperty("ShikakuShutokuDbJoho")
    private KaigoShikakuKihonDiv ShikakuShutokuDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShikakuShutokuCommonJoho")
    public KaigoAtenaInfoDiv getShikakuShutokuCommonJoho() {
        return ShikakuShutokuCommonJoho;
    }

    @JsonProperty("ShikakuShutokuCommonJoho")
    public void setShikakuShutokuCommonJoho(KaigoAtenaInfoDiv ShikakuShutokuCommonJoho) {
        this.ShikakuShutokuCommonJoho = ShikakuShutokuCommonJoho;
    }

    @JsonProperty("ShikakuShutokuDbJoho")
    public KaigoShikakuKihonDiv getShikakuShutokuDbJoho() {
        return ShikakuShutokuDbJoho;
    }

    @JsonProperty("ShikakuShutokuDbJoho")
    public void setShikakuShutokuDbJoho(KaigoShikakuKihonDiv ShikakuShutokuDbJoho) {
        this.ShikakuShutokuDbJoho = ShikakuShutokuDbJoho;
    }

}
