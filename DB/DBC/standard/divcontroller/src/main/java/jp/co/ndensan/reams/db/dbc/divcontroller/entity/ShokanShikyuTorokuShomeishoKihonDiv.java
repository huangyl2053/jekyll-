package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoKihonDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKeikaku")
    private ShokanShikyuTorokuShomeishoKihonKeikakuDiv ShokanShikyuTorokuShomeishoKihonKeikaku;
    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKikan")
    private ShokanShikyuTorokuShomeishoKihonKikanDiv ShokanShikyuTorokuShomeishoKihonKikan;
    @JsonProperty("ShokanShikyuTorokuShomeishoKihonNyutaisho")
    private ShokanShikyuTorokuShomeishoKihonNyutaishoDiv ShokanShikyuTorokuShomeishoKihonNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKeikaku")
    public ShokanShikyuTorokuShomeishoKihonKeikakuDiv getShokanShikyuTorokuShomeishoKihonKeikaku() {
        return ShokanShikyuTorokuShomeishoKihonKeikaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKeikaku")
    public void setShokanShikyuTorokuShomeishoKihonKeikaku(ShokanShikyuTorokuShomeishoKihonKeikakuDiv ShokanShikyuTorokuShomeishoKihonKeikaku) {
        this.ShokanShikyuTorokuShomeishoKihonKeikaku=ShokanShikyuTorokuShomeishoKihonKeikaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKikan")
    public ShokanShikyuTorokuShomeishoKihonKikanDiv getShokanShikyuTorokuShomeishoKihonKikan() {
        return ShokanShikyuTorokuShomeishoKihonKikan;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihonKikan")
    public void setShokanShikyuTorokuShomeishoKihonKikan(ShokanShikyuTorokuShomeishoKihonKikanDiv ShokanShikyuTorokuShomeishoKihonKikan) {
        this.ShokanShikyuTorokuShomeishoKihonKikan=ShokanShikyuTorokuShomeishoKihonKikan;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihonNyutaisho")
    public ShokanShikyuTorokuShomeishoKihonNyutaishoDiv getShokanShikyuTorokuShomeishoKihonNyutaisho() {
        return ShokanShikyuTorokuShomeishoKihonNyutaisho;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihonNyutaisho")
    public void setShokanShikyuTorokuShomeishoKihonNyutaisho(ShokanShikyuTorokuShomeishoKihonNyutaishoDiv ShokanShikyuTorokuShomeishoKihonNyutaisho) {
        this.ShokanShikyuTorokuShomeishoKihonNyutaisho=ShokanShikyuTorokuShomeishoKihonNyutaisho;
    }

}
