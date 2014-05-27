package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuKozaInfoMadoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuTorokuKozaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuKozaInfoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuKozaInfoMado")
    private ShokanShikyuTorokuKozaInfoMadoDiv ShokanShikyuTorokuKozaInfoMado;
    @JsonProperty("ShokanShikyuTorokuKozaInfoKoza")
    private ShokanShikyuTorokuKozaInfoKozaDiv ShokanShikyuTorokuKozaInfoKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuKozaInfoMado")
    public ShokanShikyuTorokuKozaInfoMadoDiv getShokanShikyuTorokuKozaInfoMado() {
        return ShokanShikyuTorokuKozaInfoMado;
    }

    @JsonProperty("ShokanShikyuTorokuKozaInfoMado")
    public void setShokanShikyuTorokuKozaInfoMado(ShokanShikyuTorokuKozaInfoMadoDiv ShokanShikyuTorokuKozaInfoMado) {
        this.ShokanShikyuTorokuKozaInfoMado=ShokanShikyuTorokuKozaInfoMado;
    }

    @JsonProperty("ShokanShikyuTorokuKozaInfoKoza")
    public ShokanShikyuTorokuKozaInfoKozaDiv getShokanShikyuTorokuKozaInfoKoza() {
        return ShokanShikyuTorokuKozaInfoKoza;
    }

    @JsonProperty("ShokanShikyuTorokuKozaInfoKoza")
    public void setShokanShikyuTorokuKozaInfoKoza(ShokanShikyuTorokuKozaInfoKozaDiv ShokanShikyuTorokuKozaInfoKoza) {
        this.ShokanShikyuTorokuKozaInfoKoza=ShokanShikyuTorokuKozaInfoKoza;
    }

}
