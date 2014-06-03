package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoMeisaiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoMeisaiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiList")
    private ShokanShikyuTorokuShomeishoMeisaiListDiv ShokanShikyuTorokuShomeishoMeisaiList;
    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiMeisai")
    private ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv ShokanShikyuTorokuShomeishoMeisaiMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiList")
    public ShokanShikyuTorokuShomeishoMeisaiListDiv getShokanShikyuTorokuShomeishoMeisaiList() {
        return ShokanShikyuTorokuShomeishoMeisaiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiList")
    public void setShokanShikyuTorokuShomeishoMeisaiList(ShokanShikyuTorokuShomeishoMeisaiListDiv ShokanShikyuTorokuShomeishoMeisaiList) {
        this.ShokanShikyuTorokuShomeishoMeisaiList=ShokanShikyuTorokuShomeishoMeisaiList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiMeisai")
    public ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv getShokanShikyuTorokuShomeishoMeisaiMeisai() {
        return ShokanShikyuTorokuShomeishoMeisaiMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoMeisaiMeisai")
    public void setShokanShikyuTorokuShomeishoMeisaiMeisai(ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv ShokanShikyuTorokuShomeishoMeisaiMeisai) {
        this.ShokanShikyuTorokuShomeishoMeisaiMeisai=ShokanShikyuTorokuShomeishoMeisaiMeisai;
    }

}
