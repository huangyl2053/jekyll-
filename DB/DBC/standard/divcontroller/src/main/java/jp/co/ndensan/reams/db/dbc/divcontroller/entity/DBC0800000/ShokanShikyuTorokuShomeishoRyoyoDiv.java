package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoRyoyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoRyoyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoRyoyoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoList")
    private ShokanShikyuTorokuShomeishoRyoyoListDiv ShokanShikyuTorokuShomeishoRyoyoList;
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoMeisai")
    private ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv ShokanShikyuTorokuShomeishoRyoyoMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoList")
    public ShokanShikyuTorokuShomeishoRyoyoListDiv getShokanShikyuTorokuShomeishoRyoyoList() {
        return ShokanShikyuTorokuShomeishoRyoyoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoList")
    public void setShokanShikyuTorokuShomeishoRyoyoList(ShokanShikyuTorokuShomeishoRyoyoListDiv ShokanShikyuTorokuShomeishoRyoyoList) {
        this.ShokanShikyuTorokuShomeishoRyoyoList=ShokanShikyuTorokuShomeishoRyoyoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoMeisai")
    public ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv getShokanShikyuTorokuShomeishoRyoyoMeisai() {
        return ShokanShikyuTorokuShomeishoRyoyoMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoRyoyoMeisai")
    public void setShokanShikyuTorokuShomeishoRyoyoMeisai(ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv ShokanShikyuTorokuShomeishoRyoyoMeisai) {
        this.ShokanShikyuTorokuShomeishoRyoyoMeisai=ShokanShikyuTorokuShomeishoRyoyoMeisai;
    }

}
