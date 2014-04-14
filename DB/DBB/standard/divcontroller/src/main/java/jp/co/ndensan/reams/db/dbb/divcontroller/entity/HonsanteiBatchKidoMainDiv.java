package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 08 20:00:42 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShikakuFuseigoIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.ShoriJokyoPanelDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonsanteiBatchKidoMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiBatchKidoMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyoPanel")
    private ShoriJokyoPanelDiv ShoriJokyoPanel;
    @JsonProperty("ShikakuFuseigoIchiran")
    private ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShoriJokyoPanel")
    public ShoriJokyoPanelDiv getShoriJokyoPanel() {
        return ShoriJokyoPanel;
    }

    @JsonProperty("ShoriJokyoPanel")
    public void setShoriJokyoPanel(ShoriJokyoPanelDiv ShoriJokyoPanel) {
        this.ShoriJokyoPanel=ShoriJokyoPanel;
    }

    @JsonProperty("ShikakuFuseigoIchiran")
    public ShikakuFuseigoIchiranDiv getShikakuFuseigoIchiran() {
        return ShikakuFuseigoIchiran;
    }

    @JsonProperty("ShikakuFuseigoIchiran")
    public void setShikakuFuseigoIchiran(ShikakuFuseigoIchiranDiv ShikakuFuseigoIchiran) {
        this.ShikakuFuseigoIchiran=ShikakuFuseigoIchiran;
    }

}
