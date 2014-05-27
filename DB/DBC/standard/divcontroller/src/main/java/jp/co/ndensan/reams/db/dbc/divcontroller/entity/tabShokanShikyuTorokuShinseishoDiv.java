package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShinseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShokanShikyuTorokuShinseisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShokanShikyuTorokuShinseishoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShinseiInfo")
    private ShokanShikyuTorokuShinseiInfoDiv ShokanShikyuTorokuShinseiInfo;
    @JsonProperty("ShokanShikyuTorokuKozaInfo")
    private ShokanShikyuTorokuKozaInfoDiv ShokanShikyuTorokuKozaInfo;
    @JsonProperty("ShokanShikyuTorokuShomeishoInfo")
    private ShokanShikyuTorokuShomeishoInfoDiv ShokanShikyuTorokuShomeishoInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShinseiInfo")
    public ShokanShikyuTorokuShinseiInfoDiv getShokanShikyuTorokuShinseiInfo() {
        return ShokanShikyuTorokuShinseiInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShinseiInfo")
    public void setShokanShikyuTorokuShinseiInfo(ShokanShikyuTorokuShinseiInfoDiv ShokanShikyuTorokuShinseiInfo) {
        this.ShokanShikyuTorokuShinseiInfo=ShokanShikyuTorokuShinseiInfo;
    }

    @JsonProperty("ShokanShikyuTorokuKozaInfo")
    public ShokanShikyuTorokuKozaInfoDiv getShokanShikyuTorokuKozaInfo() {
        return ShokanShikyuTorokuKozaInfo;
    }

    @JsonProperty("ShokanShikyuTorokuKozaInfo")
    public void setShokanShikyuTorokuKozaInfo(ShokanShikyuTorokuKozaInfoDiv ShokanShikyuTorokuKozaInfo) {
        this.ShokanShikyuTorokuKozaInfo=ShokanShikyuTorokuKozaInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoInfo")
    public ShokanShikyuTorokuShomeishoInfoDiv getShokanShikyuTorokuShomeishoInfo() {
        return ShokanShikyuTorokuShomeishoInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoInfo")
    public void setShokanShikyuTorokuShomeishoInfo(ShokanShikyuTorokuShomeishoInfoDiv ShokanShikyuTorokuShomeishoInfo) {
        this.ShokanShikyuTorokuShomeishoInfo=ShokanShikyuTorokuShomeishoInfo;
    }

}
