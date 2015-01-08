package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuNushiJuminJoho のクラスファイル
 *
 * @author 自動生成
 */
public class KyotakuNushiJuminJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("CommonKyotakuJuminChildDiv1")
    private KaigoAtenaInfoDiv CommonKyotakuJuminChildDiv1;
    @JsonProperty("CommonKyotakuJuminChildDiv2")
    private KaigoShikakuKihonDiv CommonKyotakuJuminChildDiv2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonKyotakuJuminChildDiv1")
    public KaigoAtenaInfoDiv getCommonKyotakuJuminChildDiv1() {
        return CommonKyotakuJuminChildDiv1;
    }

    @JsonProperty("CommonKyotakuJuminChildDiv1")
    public void setCommonKyotakuJuminChildDiv1(KaigoAtenaInfoDiv CommonKyotakuJuminChildDiv1) {
        this.CommonKyotakuJuminChildDiv1 = CommonKyotakuJuminChildDiv1;
    }

    @JsonProperty("CommonKyotakuJuminChildDiv2")
    public KaigoShikakuKihonDiv getCommonKyotakuJuminChildDiv2() {
        return CommonKyotakuJuminChildDiv2;
    }

    @JsonProperty("CommonKyotakuJuminChildDiv2")
    public void setCommonKyotakuJuminChildDiv2(KaigoShikakuKihonDiv CommonKyotakuJuminChildDiv2) {
        this.CommonKyotakuJuminChildDiv2 = CommonKyotakuJuminChildDiv2;
    }

}
