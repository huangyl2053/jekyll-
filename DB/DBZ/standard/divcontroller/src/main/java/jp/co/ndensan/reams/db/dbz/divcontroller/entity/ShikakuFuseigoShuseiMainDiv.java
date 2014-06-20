package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuFuseigoIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuShuseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuFuseigoShuseiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuFuseigoShuseiMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikakuFuseigoIchiran")
    private ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran;
    @JsonProperty("ShikakuShusei")
    private ShikakuShuseiDiv ShikakuShusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShikakuFuseigoIchiran")
    public ShikakuFuseigoIchiranDiv getShikakuFuseigoIchiran() {
        return ShikakuFuseigoIchiran;
    }

    @JsonProperty("ShikakuFuseigoIchiran")
    public void setShikakuFuseigoIchiran(ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran) {
        this.ShikakuFuseigoIchiran=ShikakuFuseigoIchiran;
    }

    @JsonProperty("ShikakuShusei")
    public ShikakuShuseiDiv getShikakuShusei() {
        return ShikakuShusei;
    }

    @JsonProperty("ShikakuShusei")
    public void setShikakuShusei(ShikakuShuseiDiv ShikakuShusei) {
        this.ShikakuShusei=ShikakuShusei;
    }

}
