package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShafukuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShafukuMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTrokuShomeishoShafuku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTrokuShomeishoShafukuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuList")
    private ShokanShikyuTorokuShomeishoShafukuListDiv ShokanShikyuTorokuShomeishoShafukuList;
    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuMeisai")
    private ShokanShikyuTorokuShomeishoShafukuMeisaiDiv ShokanShikyuTorokuShomeishoShafukuMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuList")
    public ShokanShikyuTorokuShomeishoShafukuListDiv getShokanShikyuTorokuShomeishoShafukuList() {
        return ShokanShikyuTorokuShomeishoShafukuList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuList")
    public void setShokanShikyuTorokuShomeishoShafukuList(ShokanShikyuTorokuShomeishoShafukuListDiv ShokanShikyuTorokuShomeishoShafukuList) {
        this.ShokanShikyuTorokuShomeishoShafukuList=ShokanShikyuTorokuShomeishoShafukuList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuMeisai")
    public ShokanShikyuTorokuShomeishoShafukuMeisaiDiv getShokanShikyuTorokuShomeishoShafukuMeisai() {
        return ShokanShikyuTorokuShomeishoShafukuMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShafukuMeisai")
    public void setShokanShikyuTorokuShomeishoShafukuMeisai(ShokanShikyuTorokuShomeishoShafukuMeisaiDiv ShokanShikyuTorokuShomeishoShafukuMeisai) {
        this.ShokanShikyuTorokuShomeishoShafukuMeisai=ShokanShikyuTorokuShomeishoShafukuMeisai;
    }

}
