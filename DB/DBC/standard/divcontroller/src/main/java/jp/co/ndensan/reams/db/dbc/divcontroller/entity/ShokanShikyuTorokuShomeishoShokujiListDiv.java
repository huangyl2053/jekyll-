package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShokujiGokeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuTorokuShomeishoShokujiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShokujiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiListInfo")
    private ServiceTeikyoShomeishoShokujiListDiv ShokanShikyuTorokuShomeishoShokujiListInfo;
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiGokei")
    private ShokanShikyuTorokuShomeishoShokujiGokeiDiv ShokanShikyuTorokuShomeishoShokujiGokei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiListInfo")
    public ServiceTeikyoShomeishoShokujiListDiv getShokanShikyuTorokuShomeishoShokujiListInfo() {
        return ShokanShikyuTorokuShomeishoShokujiListInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiListInfo")
    public void setShokanShikyuTorokuShomeishoShokujiListInfo(ServiceTeikyoShomeishoShokujiListDiv ShokanShikyuTorokuShomeishoShokujiListInfo) {
        this.ShokanShikyuTorokuShomeishoShokujiListInfo=ShokanShikyuTorokuShomeishoShokujiListInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiGokei")
    public ShokanShikyuTorokuShomeishoShokujiGokeiDiv getShokanShikyuTorokuShomeishoShokujiGokei() {
        return ShokanShikyuTorokuShomeishoShokujiGokei;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiGokei")
    public void setShokanShikyuTorokuShomeishoShokujiGokei(ShokanShikyuTorokuShomeishoShokujiGokeiDiv ShokanShikyuTorokuShomeishoShokujiGokei) {
        this.ShokanShikyuTorokuShomeishoShokujiGokei=ShokanShikyuTorokuShomeishoShokujiGokei;
    }

}
