package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe8020001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KojinJokyoShokaiTaishoshaKensaku のクラスファイル
 *
 * @author 自動生成
 */
public class KojinJokyoShokaiTaishoshaKensakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshaFinder")
    private HihokenshaFinderDiv HihokenshaFinder;
    @JsonProperty("ShinseishaKensakuResultIchiran")
    private ShinseishaKensakuResultIchiranDiv ShinseishaKensakuResultIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaFinder")
    public HihokenshaFinderDiv getHihokenshaFinder() {
        return HihokenshaFinder;
    }

    @JsonProperty("HihokenshaFinder")
    public void setHihokenshaFinder(HihokenshaFinderDiv HihokenshaFinder) {
        this.HihokenshaFinder = HihokenshaFinder;
    }

    @JsonProperty("ShinseishaKensakuResultIchiran")
    public ShinseishaKensakuResultIchiranDiv getShinseishaKensakuResultIchiran() {
        return ShinseishaKensakuResultIchiran;
    }

    @JsonProperty("ShinseishaKensakuResultIchiran")
    public void setShinseishaKensakuResultIchiran(ShinseishaKensakuResultIchiranDiv ShinseishaKensakuResultIchiran) {
        this.ShinseishaKensakuResultIchiran = ShinseishaKensakuResultIchiran;
    }

}
