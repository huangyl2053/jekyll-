package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShukeiList.ServiceTeikyoShomeishoShukeiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShukeiList.ServiceTeikyoShomeishoShukeiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuTorokuShomeishoShukeiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShukeiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiListInfo")
    private ServiceTeikyoShomeishoShukeiListDiv ShokanShikyuTorokuShomeishoShukeiListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiListInfo")
    public ServiceTeikyoShomeishoShukeiListDiv getShokanShikyuTorokuShomeishoShukeiListInfo() {
        return ShokanShikyuTorokuShomeishoShukeiListInfo;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiListInfo")
    public void setShokanShikyuTorokuShomeishoShukeiListInfo(ServiceTeikyoShomeishoShukeiListDiv ShokanShikyuTorokuShomeishoShukeiListInfo) {
        this.ShokanShikyuTorokuShomeishoShukeiListInfo=ShokanShikyuTorokuShomeishoShukeiListInfo;
    }

}
