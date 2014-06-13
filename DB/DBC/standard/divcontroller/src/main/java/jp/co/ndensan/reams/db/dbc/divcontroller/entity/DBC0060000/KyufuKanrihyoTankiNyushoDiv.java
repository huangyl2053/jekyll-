package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfo.KyufuKanrihyoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * KyufuKanrihyoTankiNyusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuKanrihyoTankiNyushoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuKanrihyoInfoTankiNyusho")
    private KyufuKanrihyoInfoDiv KyufuKanrihyoInfoTankiNyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuKanrihyoInfoTankiNyusho")
    public KyufuKanrihyoInfoDiv getKyufuKanrihyoInfoTankiNyusho() {
        return KyufuKanrihyoInfoTankiNyusho;
    }

    @JsonProperty("KyufuKanrihyoInfoTankiNyusho")
    public void setKyufuKanrihyoInfoTankiNyusho(KyufuKanrihyoInfoDiv KyufuKanrihyoInfoTankiNyusho) {
        this.KyufuKanrihyoInfoTankiNyusho=KyufuKanrihyoInfoTankiNyusho;
    }

}
