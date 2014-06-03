package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKeikakuH2103Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKeikakuH2104Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoKeikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoKeikakuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2103")
    private ShokanShikyuTorokuShomeishoKeikakuH2103Div ShokanShikyuTorokuShomeishoKeikakuH2103;
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2104")
    private ShokanShikyuTorokuShomeishoKeikakuH2104Div ShokanShikyuTorokuShomeishoKeikakuH2104;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2103")
    public ShokanShikyuTorokuShomeishoKeikakuH2103Div getShokanShikyuTorokuShomeishoKeikakuH2103() {
        return ShokanShikyuTorokuShomeishoKeikakuH2103;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2103")
    public void setShokanShikyuTorokuShomeishoKeikakuH2103(ShokanShikyuTorokuShomeishoKeikakuH2103Div ShokanShikyuTorokuShomeishoKeikakuH2103) {
        this.ShokanShikyuTorokuShomeishoKeikakuH2103=ShokanShikyuTorokuShomeishoKeikakuH2103;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2104")
    public ShokanShikyuTorokuShomeishoKeikakuH2104Div getShokanShikyuTorokuShomeishoKeikakuH2104() {
        return ShokanShikyuTorokuShomeishoKeikakuH2104;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuH2104")
    public void setShokanShikyuTorokuShomeishoKeikakuH2104(ShokanShikyuTorokuShomeishoKeikakuH2104Div ShokanShikyuTorokuShomeishoKeikakuH2104) {
        this.ShokanShikyuTorokuShomeishoKeikakuH2104=ShokanShikyuTorokuShomeishoKeikakuH2104;
    }

}
