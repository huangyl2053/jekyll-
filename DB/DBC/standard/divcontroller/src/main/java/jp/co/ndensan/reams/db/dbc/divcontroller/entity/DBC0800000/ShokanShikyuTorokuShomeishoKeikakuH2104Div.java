package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKeikakuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoKeikakuMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokanShikyuTorokuShomeishoKeikakuH2104 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoKeikakuH2104Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuList")
    private ShokanShikyuTorokuShomeishoKeikakuListDiv ShokanShikyuTorokuShomeishoKeikakuList;
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuMeisai")
    private ShokanShikyuTorokuShomeishoKeikakuMeisaiDiv ShokanShikyuTorokuShomeishoKeikakuMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuList")
    public ShokanShikyuTorokuShomeishoKeikakuListDiv getShokanShikyuTorokuShomeishoKeikakuList() {
        return ShokanShikyuTorokuShomeishoKeikakuList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuList")
    public void setShokanShikyuTorokuShomeishoKeikakuList(ShokanShikyuTorokuShomeishoKeikakuListDiv ShokanShikyuTorokuShomeishoKeikakuList) {
        this.ShokanShikyuTorokuShomeishoKeikakuList=ShokanShikyuTorokuShomeishoKeikakuList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuMeisai")
    public ShokanShikyuTorokuShomeishoKeikakuMeisaiDiv getShokanShikyuTorokuShomeishoKeikakuMeisai() {
        return ShokanShikyuTorokuShomeishoKeikakuMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoKeikakuMeisai")
    public void setShokanShikyuTorokuShomeishoKeikakuMeisai(ShokanShikyuTorokuShomeishoKeikakuMeisaiDiv ShokanShikyuTorokuShomeishoKeikakuMeisai) {
        this.ShokanShikyuTorokuShomeishoKeikakuMeisai=ShokanShikyuTorokuShomeishoKeikakuMeisai;
    }

}
