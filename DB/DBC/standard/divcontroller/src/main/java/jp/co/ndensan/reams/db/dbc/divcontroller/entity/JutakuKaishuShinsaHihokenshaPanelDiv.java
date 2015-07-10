package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinsaHihokenshaPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JutakuKaishuShinsaHihokenshaPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KaigoAtena")
    private KaigoAtenaInfoDiv KaigoAtena;
    @JsonProperty("KaigoShikakuKihon")
    private KaigoShikakuKihonDiv KaigoShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KaigoAtena")
    public KaigoAtenaInfoDiv getKaigoAtena() {
        return KaigoAtena;
    }

    @JsonProperty("KaigoAtena")
    public void setKaigoAtena(KaigoAtenaInfoDiv KaigoAtena) {
        this.KaigoAtena = KaigoAtena;
    }

    @JsonProperty("KaigoShikakuKihon")
    public KaigoShikakuKihonDiv getKaigoShikakuKihon() {
        return KaigoShikakuKihon;
    }

    @JsonProperty("KaigoShikakuKihon")
    public void setKaigoShikakuKihon(KaigoShikakuKihonDiv KaigoShikakuKihon) {
        this.KaigoShikakuKihon = KaigoShikakuKihon;
    }

}
