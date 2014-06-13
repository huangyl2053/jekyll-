package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShukeiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShukeiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiList")
    private ShokanShikyuTorokuShomeishoShukeiListDiv ShokanShikyuTorokuShomeishoShukeiList;
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiMeisai")
    private ShokanShikyuTorokuShomeishoShukeiMeisaiDiv ShokanShikyuTorokuShomeishoShukeiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiList")
    public ShokanShikyuTorokuShomeishoShukeiListDiv getShokanShikyuTorokuShomeishoShukeiList() {
        return ShokanShikyuTorokuShomeishoShukeiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiList")
    public void setShokanShikyuTorokuShomeishoShukeiList(ShokanShikyuTorokuShomeishoShukeiListDiv ShokanShikyuTorokuShomeishoShukeiList) {
        this.ShokanShikyuTorokuShomeishoShukeiList=ShokanShikyuTorokuShomeishoShukeiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiMeisai")
    public ShokanShikyuTorokuShomeishoShukeiMeisaiDiv getShokanShikyuTorokuShomeishoShukeiMeisai() {
        return ShokanShikyuTorokuShomeishoShukeiMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShukeiMeisai")
    public void setShokanShikyuTorokuShomeishoShukeiMeisai(ShokanShikyuTorokuShomeishoShukeiMeisaiDiv ShokanShikyuTorokuShomeishoShukeiMeisai) {
        this.ShokanShikyuTorokuShomeishoShukeiMeisai=ShokanShikyuTorokuShomeishoShukeiMeisai;
    }

}
