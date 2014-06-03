package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoNyushoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoRyoyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShafukuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShinryoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShokujiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShokanShikyuTorokuShomeisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShokanShikyuTorokuShomeishoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKihon")
    private ShokanShikyuTorokuShomeishoKihonDiv ShokanShikyuTorokuShomeishoKihon;
    @JsonProperty("ShokanShikyuTorokuShomeishoMeisai")
    private ShokanShikyuTorokuShomeishoMeisaiDiv ShokanShikyuTorokuShomeishoMeisai;
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyo")
    private ShokanShikyuTorokuShomeishoRyoyoDiv ShokanShikyuTorokuShomeishoRyoyo;
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryo")
    private ShokanShikyuTorokuShomeishoShinryoDiv ShokanShikyuTorokuShomeishoShinryo;
    @JsonProperty("ShokanShikyuTorokuShomeishoShokuji")
    private ShokanShikyuTorokuShomeishoShokujiDiv ShokanShikyuTorokuShomeishoShokuji;
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikaku")
    private ShokanShikyuTorokuShomeishoKeikakuDiv ShokanShikyuTorokuShomeishoKeikaku;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukei")
    private ShokanShikyuTorokuShomeishoShukeiDiv ShokanShikyuTorokuShomeishoShukei;
    @JsonProperty("ShokanShikyuTorokuShomeishoNyusho")
    private ShokanShikyuTorokuShomeishoNyushoDiv ShokanShikyuTorokuShomeishoNyusho;
    @JsonProperty("ShokanShikyuTorokuShomeishoShafuku")
    private ShokanShikyuTorokuShomeishoShafukuDiv ShokanShikyuTorokuShomeishoShafuku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKihon")
    public ShokanShikyuTorokuShomeishoKihonDiv getShokanShikyuTorokuShomeishoKihon() {
        return ShokanShikyuTorokuShomeishoKihon;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKihon")
    public void setShokanShikyuTorokuShomeishoKihon(ShokanShikyuTorokuShomeishoKihonDiv ShokanShikyuTorokuShomeishoKihon) {
        this.ShokanShikyuTorokuShomeishoKihon=ShokanShikyuTorokuShomeishoKihon;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoMeisai")
    public ShokanShikyuTorokuShomeishoMeisaiDiv getShokanShikyuTorokuShomeishoMeisai() {
        return ShokanShikyuTorokuShomeishoMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoMeisai")
    public void setShokanShikyuTorokuShomeishoMeisai(ShokanShikyuTorokuShomeishoMeisaiDiv ShokanShikyuTorokuShomeishoMeisai) {
        this.ShokanShikyuTorokuShomeishoMeisai=ShokanShikyuTorokuShomeishoMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyo")
    public ShokanShikyuTorokuShomeishoRyoyoDiv getShokanShikyuTorokuShomeishoRyoyo() {
        return ShokanShikyuTorokuShomeishoRyoyo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyo")
    public void setShokanShikyuTorokuShomeishoRyoyo(ShokanShikyuTorokuShomeishoRyoyoDiv ShokanShikyuTorokuShomeishoRyoyo) {
        this.ShokanShikyuTorokuShomeishoRyoyo=ShokanShikyuTorokuShomeishoRyoyo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryo")
    public ShokanShikyuTorokuShomeishoShinryoDiv getShokanShikyuTorokuShomeishoShinryo() {
        return ShokanShikyuTorokuShomeishoShinryo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryo")
    public void setShokanShikyuTorokuShomeishoShinryo(ShokanShikyuTorokuShomeishoShinryoDiv ShokanShikyuTorokuShomeishoShinryo) {
        this.ShokanShikyuTorokuShomeishoShinryo=ShokanShikyuTorokuShomeishoShinryo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokuji")
    public ShokanShikyuTorokuShomeishoShokujiDiv getShokanShikyuTorokuShomeishoShokuji() {
        return ShokanShikyuTorokuShomeishoShokuji;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokuji")
    public void setShokanShikyuTorokuShomeishoShokuji(ShokanShikyuTorokuShomeishoShokujiDiv ShokanShikyuTorokuShomeishoShokuji) {
        this.ShokanShikyuTorokuShomeishoShokuji=ShokanShikyuTorokuShomeishoShokuji;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikaku")
    public ShokanShikyuTorokuShomeishoKeikakuDiv getShokanShikyuTorokuShomeishoKeikaku() {
        return ShokanShikyuTorokuShomeishoKeikaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikaku")
    public void setShokanShikyuTorokuShomeishoKeikaku(ShokanShikyuTorokuShomeishoKeikakuDiv ShokanShikyuTorokuShomeishoKeikaku) {
        this.ShokanShikyuTorokuShomeishoKeikaku=ShokanShikyuTorokuShomeishoKeikaku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukei")
    public ShokanShikyuTorokuShomeishoShukeiDiv getShokanShikyuTorokuShomeishoShukei() {
        return ShokanShikyuTorokuShomeishoShukei;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukei")
    public void setShokanShikyuTorokuShomeishoShukei(ShokanShikyuTorokuShomeishoShukeiDiv ShokanShikyuTorokuShomeishoShukei) {
        this.ShokanShikyuTorokuShomeishoShukei=ShokanShikyuTorokuShomeishoShukei;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoNyusho")
    public ShokanShikyuTorokuShomeishoNyushoDiv getShokanShikyuTorokuShomeishoNyusho() {
        return ShokanShikyuTorokuShomeishoNyusho;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoNyusho")
    public void setShokanShikyuTorokuShomeishoNyusho(ShokanShikyuTorokuShomeishoNyushoDiv ShokanShikyuTorokuShomeishoNyusho) {
        this.ShokanShikyuTorokuShomeishoNyusho=ShokanShikyuTorokuShomeishoNyusho;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShafuku")
    public ShokanShikyuTorokuShomeishoShafukuDiv getShokanShikyuTorokuShomeishoShafuku() {
        return ShokanShikyuTorokuShomeishoShafuku;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShafuku")
    public void setShokanShikyuTorokuShomeishoShafuku(ShokanShikyuTorokuShomeishoShafukuDiv ShokanShikyuTorokuShomeishoShafuku) {
        this.ShokanShikyuTorokuShomeishoShafuku=ShokanShikyuTorokuShomeishoShafuku;
    }

}
