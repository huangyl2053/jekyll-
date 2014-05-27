package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoNyushoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoNyushoMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoNyusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoNyushoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoList")
    private ShokanShikyuTorokuShomeishoNyushoListDiv ShokanShikyuTorokuShomeishoNyushoList;
    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoMeisai")
    private ShokanShikyuTorokuShomeishoNyushoMeisaiDiv ShokanShikyuTorokuShomeishoNyushoMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoList")
    public ShokanShikyuTorokuShomeishoNyushoListDiv getShokanShikyuTorokuShomeishoNyushoList() {
        return ShokanShikyuTorokuShomeishoNyushoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoList")
    public void setShokanShikyuTorokuShomeishoNyushoList(ShokanShikyuTorokuShomeishoNyushoListDiv ShokanShikyuTorokuShomeishoNyushoList) {
        this.ShokanShikyuTorokuShomeishoNyushoList=ShokanShikyuTorokuShomeishoNyushoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoMeisai")
    public ShokanShikyuTorokuShomeishoNyushoMeisaiDiv getShokanShikyuTorokuShomeishoNyushoMeisai() {
        return ShokanShikyuTorokuShomeishoNyushoMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoNyushoMeisai")
    public void setShokanShikyuTorokuShomeishoNyushoMeisai(ShokanShikyuTorokuShomeishoNyushoMeisaiDiv ShokanShikyuTorokuShomeishoNyushoMeisai) {
        this.ShokanShikyuTorokuShomeishoNyushoMeisai=ShokanShikyuTorokuShomeishoNyushoMeisai;
    }

}
