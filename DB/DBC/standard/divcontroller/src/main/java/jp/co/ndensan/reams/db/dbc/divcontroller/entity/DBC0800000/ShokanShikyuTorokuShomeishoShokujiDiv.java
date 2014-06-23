package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShokujiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShokujiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoShokuji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShokujiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiList")
    private ShokanShikyuTorokuShomeishoShokujiListDiv ShokanShikyuTorokuShomeishoShokujiList;
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisai")
    private ShokanShikyuTorokuShomeishoShokujiMeisaiDiv ShokanShikyuTorokuShomeishoShokujiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiList")
    public ShokanShikyuTorokuShomeishoShokujiListDiv getShokanShikyuTorokuShomeishoShokujiList() {
        return ShokanShikyuTorokuShomeishoShokujiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiList")
    public void setShokanShikyuTorokuShomeishoShokujiList(ShokanShikyuTorokuShomeishoShokujiListDiv ShokanShikyuTorokuShomeishoShokujiList) {
        this.ShokanShikyuTorokuShomeishoShokujiList=ShokanShikyuTorokuShomeishoShokujiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisai")
    public ShokanShikyuTorokuShomeishoShokujiMeisaiDiv getShokanShikyuTorokuShomeishoShokujiMeisai() {
        return ShokanShikyuTorokuShomeishoShokujiMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisai")
    public void setShokanShikyuTorokuShomeishoShokujiMeisai(ShokanShikyuTorokuShomeishoShokujiMeisaiDiv ShokanShikyuTorokuShomeishoShokujiMeisai) {
        this.ShokanShikyuTorokuShomeishoShokujiMeisai=ShokanShikyuTorokuShomeishoShokujiMeisai;
    }

}
