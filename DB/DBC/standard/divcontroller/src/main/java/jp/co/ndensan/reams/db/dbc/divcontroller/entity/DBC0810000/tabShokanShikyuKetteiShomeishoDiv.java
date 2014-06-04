package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoNyushoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoRyoyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShafukuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShinryoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShokujiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShukeiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShokanShikyuKetteiShomeisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShokanShikyuKetteiShomeishoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoKihon")
    private ShokanShikyuKetteiShomeishoKihonDiv ShokanShikyuKetteiShomeishoKihon;
    @JsonProperty("ShokanShikyuKetteiShomeishoMeisai")
    private ShokanShikyuKetteiShomeishoMeisaiDiv ShokanShikyuKetteiShomeishoMeisai;
    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyo")
    private ShokanShikyuKetteiShomeishoRyoyoDiv ShokanShikyuKetteiShomeishoRyoyo;
    @JsonProperty("ShokanShikyuKetteiShomeishoShinryo")
    private ShokanShikyuKetteiShomeishoShinryoDiv ShokanShikyuKetteiShomeishoShinryo;
    @JsonProperty("ShokanShikyuKetteiShomeishoShokuji")
    private ShokanShikyuKetteiShomeishoShokujiDiv ShokanShikyuKetteiShomeishoShokuji;
    @JsonProperty("ShokanShikyuKetteiShomeishoKeikaku")
    private ShokanShikyuKetteiShomeishoKeikakuDiv ShokanShikyuKetteiShomeishoKeikaku;
    @JsonProperty("ShokanShikyuKetteiShomeishoShukei")
    private ShokanShikyuKetteiShomeishoShukeiDiv ShokanShikyuKetteiShomeishoShukei;
    @JsonProperty("ShokanShikyuKetteiShomeishoNyusho")
    private ShokanShikyuKetteiShomeishoNyushoDiv ShokanShikyuKetteiShomeishoNyusho;
    @JsonProperty("ShokanShikyuKetteiShomeishoShafuku")
    private ShokanShikyuKetteiShomeishoShafukuDiv ShokanShikyuKetteiShomeishoShafuku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoKihon")
    public ShokanShikyuKetteiShomeishoKihonDiv getShokanShikyuKetteiShomeishoKihon() {
        return ShokanShikyuKetteiShomeishoKihon;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKihon")
    public void setShokanShikyuKetteiShomeishoKihon(ShokanShikyuKetteiShomeishoKihonDiv ShokanShikyuKetteiShomeishoKihon) {
        this.ShokanShikyuKetteiShomeishoKihon=ShokanShikyuKetteiShomeishoKihon;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoMeisai")
    public ShokanShikyuKetteiShomeishoMeisaiDiv getShokanShikyuKetteiShomeishoMeisai() {
        return ShokanShikyuKetteiShomeishoMeisai;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoMeisai")
    public void setShokanShikyuKetteiShomeishoMeisai(ShokanShikyuKetteiShomeishoMeisaiDiv ShokanShikyuKetteiShomeishoMeisai) {
        this.ShokanShikyuKetteiShomeishoMeisai=ShokanShikyuKetteiShomeishoMeisai;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyo")
    public ShokanShikyuKetteiShomeishoRyoyoDiv getShokanShikyuKetteiShomeishoRyoyo() {
        return ShokanShikyuKetteiShomeishoRyoyo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyo")
    public void setShokanShikyuKetteiShomeishoRyoyo(ShokanShikyuKetteiShomeishoRyoyoDiv ShokanShikyuKetteiShomeishoRyoyo) {
        this.ShokanShikyuKetteiShomeishoRyoyo=ShokanShikyuKetteiShomeishoRyoyo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShinryo")
    public ShokanShikyuKetteiShomeishoShinryoDiv getShokanShikyuKetteiShomeishoShinryo() {
        return ShokanShikyuKetteiShomeishoShinryo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShinryo")
    public void setShokanShikyuKetteiShomeishoShinryo(ShokanShikyuKetteiShomeishoShinryoDiv ShokanShikyuKetteiShomeishoShinryo) {
        this.ShokanShikyuKetteiShomeishoShinryo=ShokanShikyuKetteiShomeishoShinryo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShokuji")
    public ShokanShikyuKetteiShomeishoShokujiDiv getShokanShikyuKetteiShomeishoShokuji() {
        return ShokanShikyuKetteiShomeishoShokuji;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShokuji")
    public void setShokanShikyuKetteiShomeishoShokuji(ShokanShikyuKetteiShomeishoShokujiDiv ShokanShikyuKetteiShomeishoShokuji) {
        this.ShokanShikyuKetteiShomeishoShokuji=ShokanShikyuKetteiShomeishoShokuji;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKeikaku")
    public ShokanShikyuKetteiShomeishoKeikakuDiv getShokanShikyuKetteiShomeishoKeikaku() {
        return ShokanShikyuKetteiShomeishoKeikaku;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoKeikaku")
    public void setShokanShikyuKetteiShomeishoKeikaku(ShokanShikyuKetteiShomeishoKeikakuDiv ShokanShikyuKetteiShomeishoKeikaku) {
        this.ShokanShikyuKetteiShomeishoKeikaku=ShokanShikyuKetteiShomeishoKeikaku;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShukei")
    public ShokanShikyuKetteiShomeishoShukeiDiv getShokanShikyuKetteiShomeishoShukei() {
        return ShokanShikyuKetteiShomeishoShukei;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShukei")
    public void setShokanShikyuKetteiShomeishoShukei(ShokanShikyuKetteiShomeishoShukeiDiv ShokanShikyuKetteiShomeishoShukei) {
        this.ShokanShikyuKetteiShomeishoShukei=ShokanShikyuKetteiShomeishoShukei;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoNyusho")
    public ShokanShikyuKetteiShomeishoNyushoDiv getShokanShikyuKetteiShomeishoNyusho() {
        return ShokanShikyuKetteiShomeishoNyusho;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoNyusho")
    public void setShokanShikyuKetteiShomeishoNyusho(ShokanShikyuKetteiShomeishoNyushoDiv ShokanShikyuKetteiShomeishoNyusho) {
        this.ShokanShikyuKetteiShomeishoNyusho=ShokanShikyuKetteiShomeishoNyusho;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShafuku")
    public ShokanShikyuKetteiShomeishoShafukuDiv getShokanShikyuKetteiShomeishoShafuku() {
        return ShokanShikyuKetteiShomeishoShafuku;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShafuku")
    public void setShokanShikyuKetteiShomeishoShafuku(ShokanShikyuKetteiShomeishoShafukuDiv ShokanShikyuKetteiShomeishoShafuku) {
        this.ShokanShikyuKetteiShomeishoShafuku=ShokanShikyuKetteiShomeishoShafuku;
    }

}
