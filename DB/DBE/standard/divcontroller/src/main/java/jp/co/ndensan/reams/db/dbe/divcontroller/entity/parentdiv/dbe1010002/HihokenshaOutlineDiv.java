package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe1010002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaOutline のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaOutlineDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("AtenaInfo")
    private KaigoAtenaInfoDiv AtenaInfo;
    @JsonProperty("ShikakuKihon")
    private KaigoShikakuKihonDiv ShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("AtenaInfo")
    public KaigoAtenaInfoDiv getAtenaInfo() {
        return AtenaInfo;
    }

    @JsonProperty("AtenaInfo")
    public void setAtenaInfo(KaigoAtenaInfoDiv AtenaInfo) {
        this.AtenaInfo = AtenaInfo;
    }

    @JsonProperty("ShikakuKihon")
    public KaigoShikakuKihonDiv getShikakuKihon() {
        return ShikakuKihon;
    }

    @JsonProperty("ShikakuKihon")
    public void setShikakuKihon(KaigoShikakuKihonDiv ShikakuKihon) {
        this.ShikakuKihon = ShikakuKihon;
    }

}
