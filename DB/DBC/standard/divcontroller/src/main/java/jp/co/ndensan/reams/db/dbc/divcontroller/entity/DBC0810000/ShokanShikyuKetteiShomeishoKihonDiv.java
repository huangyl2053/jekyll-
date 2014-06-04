package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuKetteiShomeishoKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoKihonDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKeikaku")
    private ShokanShikyuKetteiShomeishoKihonKeikakuDiv ShokanShikyuKetteiShomeishoKihonKeikaku;
    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKikan")
    private ShokanShikyuKetteiShomeishoKihonKikanDiv ShokanShikyuKetteiShomeishoKihonKikan;
    @JsonProperty("ShokanShikyuKetteiShomeishoKihonNyutaisho")
    private ShokanShikyuKetteiShomeishoKihonNyutaishoDiv ShokanShikyuKetteiShomeishoKihonNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKeikaku")
    public ShokanShikyuKetteiShomeishoKihonKeikakuDiv getShokanShikyuKetteiShomeishoKihonKeikaku() {
        return ShokanShikyuKetteiShomeishoKihonKeikaku;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKeikaku")
    public void setShokanShikyuKetteiShomeishoKihonKeikaku(ShokanShikyuKetteiShomeishoKihonKeikakuDiv ShokanShikyuKetteiShomeishoKihonKeikaku) {
        this.ShokanShikyuKetteiShomeishoKihonKeikaku=ShokanShikyuKetteiShomeishoKihonKeikaku;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKikan")
    public ShokanShikyuKetteiShomeishoKihonKikanDiv getShokanShikyuKetteiShomeishoKihonKikan() {
        return ShokanShikyuKetteiShomeishoKihonKikan;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihonKikan")
    public void setShokanShikyuKetteiShomeishoKihonKikan(ShokanShikyuKetteiShomeishoKihonKikanDiv ShokanShikyuKetteiShomeishoKihonKikan) {
        this.ShokanShikyuKetteiShomeishoKihonKikan=ShokanShikyuKetteiShomeishoKihonKikan;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihonNyutaisho")
    public ShokanShikyuKetteiShomeishoKihonNyutaishoDiv getShokanShikyuKetteiShomeishoKihonNyutaisho() {
        return ShokanShikyuKetteiShomeishoKihonNyutaisho;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihonNyutaisho")
    public void setShokanShikyuKetteiShomeishoKihonNyutaisho(ShokanShikyuKetteiShomeishoKihonNyutaishoDiv ShokanShikyuKetteiShomeishoKihonNyutaisho) {
        this.ShokanShikyuKetteiShomeishoKihonNyutaisho=ShokanShikyuKetteiShomeishoKihonNyutaisho;
    }

}
