package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShokanShikyuKetteiShinseisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShokanShikyuKetteiShinseishoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteiShinseiInfo")
    private ShokanShikyuKetteiShinseiInfoDiv ShokanShikyuKetteiShinseiInfo;
    @JsonProperty("ShokanShikyuKetteiKozaInfo")
    private ShokanShikyuKetteiKozaInfoDiv ShokanShikyuKetteiKozaInfo;
    @JsonProperty("ShokanShikyuKetteiShomeishoInfo")
    private ShokanShikyuKetteiShomeishoInfoDiv ShokanShikyuKetteiShomeishoInfo;
    @JsonProperty("ShokanShikyuKetteiInfo")
    private ShokanShikyuKetteiInfoDiv ShokanShikyuKetteiInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShinseiInfo")
    public ShokanShikyuKetteiShinseiInfoDiv getShokanShikyuKetteiShinseiInfo() {
        return ShokanShikyuKetteiShinseiInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShinseiInfo")
    public void setShokanShikyuKetteiShinseiInfo(ShokanShikyuKetteiShinseiInfoDiv ShokanShikyuKetteiShinseiInfo) {
        this.ShokanShikyuKetteiShinseiInfo=ShokanShikyuKetteiShinseiInfo;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfo")
    public ShokanShikyuKetteiKozaInfoDiv getShokanShikyuKetteiKozaInfo() {
        return ShokanShikyuKetteiKozaInfo;
    }

    @JsonProperty("ShokanShikyuKetteiKozaInfo")
    public void setShokanShikyuKetteiKozaInfo(ShokanShikyuKetteiKozaInfoDiv ShokanShikyuKetteiKozaInfo) {
        this.ShokanShikyuKetteiKozaInfo=ShokanShikyuKetteiKozaInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoInfo")
    public ShokanShikyuKetteiShomeishoInfoDiv getShokanShikyuKetteiShomeishoInfo() {
        return ShokanShikyuKetteiShomeishoInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoInfo")
    public void setShokanShikyuKetteiShomeishoInfo(ShokanShikyuKetteiShomeishoInfoDiv ShokanShikyuKetteiShomeishoInfo) {
        this.ShokanShikyuKetteiShomeishoInfo=ShokanShikyuKetteiShomeishoInfo;
    }

    @JsonProperty("ShokanShikyuKetteiInfo")
    public ShokanShikyuKetteiInfoDiv getShokanShikyuKetteiInfo() {
        return ShokanShikyuKetteiInfo;
    }

    @JsonProperty("ShokanShikyuKetteiInfo")
    public void setShokanShikyuKetteiInfo(ShokanShikyuKetteiInfoDiv ShokanShikyuKetteiInfo) {
        this.ShokanShikyuKetteiInfo=ShokanShikyuKetteiInfo;
    }

}
