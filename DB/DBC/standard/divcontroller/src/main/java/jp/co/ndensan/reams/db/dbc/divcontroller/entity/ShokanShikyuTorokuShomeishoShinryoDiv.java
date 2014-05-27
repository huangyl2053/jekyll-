package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShinryoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoShinryoMeisaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuShomeishoShinryo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShinryoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoList")
    private ShokanShikyuTorokuShomeishoShinryoListDiv ShokanShikyuTorokuShomeishoShinryoList;
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisai")
    private ShokanShikyuTorokuShomeishoShinryoMeisaiDiv ShokanShikyuTorokuShomeishoShinryoMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoList")
    public ShokanShikyuTorokuShomeishoShinryoListDiv getShokanShikyuTorokuShomeishoShinryoList() {
        return ShokanShikyuTorokuShomeishoShinryoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoList")
    public void setShokanShikyuTorokuShomeishoShinryoList(ShokanShikyuTorokuShomeishoShinryoListDiv ShokanShikyuTorokuShomeishoShinryoList) {
        this.ShokanShikyuTorokuShomeishoShinryoList=ShokanShikyuTorokuShomeishoShinryoList;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisai")
    public ShokanShikyuTorokuShomeishoShinryoMeisaiDiv getShokanShikyuTorokuShomeishoShinryoMeisai() {
        return ShokanShikyuTorokuShomeishoShinryoMeisai;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShinryoMeisai")
    public void setShokanShikyuTorokuShomeishoShinryoMeisai(ShokanShikyuTorokuShomeishoShinryoMeisaiDiv ShokanShikyuTorokuShomeishoShinryoMeisai) {
        this.ShokanShikyuTorokuShomeishoShinryoMeisai=ShokanShikyuTorokuShomeishoShinryoMeisai;
    }

}
