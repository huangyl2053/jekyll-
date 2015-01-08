package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Hihokensha のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    private KaigoAtenaInfoDiv CommonKaigpAtenainfoChildDiv1;
    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    private KaigoShikakuKihonDiv CommonKaigoshikakuKihonChildDiv2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    public KaigoAtenaInfoDiv getCommonKaigpAtenainfoChildDiv1() {
        return CommonKaigpAtenainfoChildDiv1;
    }

    @JsonProperty("CommonKaigpAtenainfoChildDiv1")
    public void setCommonKaigpAtenainfoChildDiv1(KaigoAtenaInfoDiv CommonKaigpAtenainfoChildDiv1) {
        this.CommonKaigpAtenainfoChildDiv1 = CommonKaigpAtenainfoChildDiv1;
    }

    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    public KaigoShikakuKihonDiv getCommonKaigoshikakuKihonChildDiv2() {
        return CommonKaigoshikakuKihonChildDiv2;
    }

    @JsonProperty("CommonKaigoshikakuKihonChildDiv2")
    public void setCommonKaigoshikakuKihonChildDiv2(KaigoShikakuKihonDiv CommonKaigoshikakuKihonChildDiv2) {
        this.CommonKaigoshikakuKihonChildDiv2 = CommonKaigoshikakuKihonChildDiv2;
    }

}
