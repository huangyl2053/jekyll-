package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo.KashitsukekinKetteiMadoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KashitsukekinKetteiShiharai のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKetteiShiharaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KashitsukekinKetteiMado")
    private KashitsukekinKetteiMadoDiv KashitsukekinKetteiMado;
    @JsonProperty("KashitsukekinKetteiKoza")
    private KashitsukekinKetteiKozaDiv KashitsukekinKetteiKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KashitsukekinKetteiMado")
    public KashitsukekinKetteiMadoDiv getKashitsukekinKetteiMado() {
        return KashitsukekinKetteiMado;
    }

    @JsonProperty("KashitsukekinKetteiMado")
    public void setKashitsukekinKetteiMado(KashitsukekinKetteiMadoDiv KashitsukekinKetteiMado) {
        this.KashitsukekinKetteiMado=KashitsukekinKetteiMado;
    }

    @JsonProperty("KashitsukekinKetteiKoza")
    public KashitsukekinKetteiKozaDiv getKashitsukekinKetteiKoza() {
        return KashitsukekinKetteiKoza;
    }

    @JsonProperty("KashitsukekinKetteiKoza")
    public void setKashitsukekinKetteiKoza(KashitsukekinKetteiKozaDiv KashitsukekinKetteiKoza) {
        this.KashitsukekinKetteiKoza=KashitsukekinKetteiKoza;
    }

}
