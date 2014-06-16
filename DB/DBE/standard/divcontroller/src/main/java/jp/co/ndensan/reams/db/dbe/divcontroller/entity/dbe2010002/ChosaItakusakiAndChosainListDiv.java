package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ShozokuChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.WaritsukesakiChosaItakusakiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakusakiAndChosainList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShozokuChosainList")
    private ShozokuChosainListDiv ShozokuChosainList;
    @JsonProperty("WaritsukesakiChosaItakusakiList")
    private WaritsukesakiChosaItakusakiListDiv WaritsukesakiChosaItakusakiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShozokuChosainList")
    public ShozokuChosainListDiv getShozokuChosainList() {
        return ShozokuChosainList;
    }

    @JsonProperty("ShozokuChosainList")
    public void setShozokuChosainList(ShozokuChosainListDiv ShozokuChosainList) {
        this.ShozokuChosainList=ShozokuChosainList;
    }

    @JsonProperty("WaritsukesakiChosaItakusakiList")
    public WaritsukesakiChosaItakusakiListDiv getWaritsukesakiChosaItakusakiList() {
        return WaritsukesakiChosaItakusakiList;
    }

    @JsonProperty("WaritsukesakiChosaItakusakiList")
    public void setWaritsukesakiChosaItakusakiList(WaritsukesakiChosaItakusakiListDiv WaritsukesakiChosaItakusakiList) {
        this.WaritsukesakiChosaItakusakiList=WaritsukesakiChosaItakusakiList;
    }

}
