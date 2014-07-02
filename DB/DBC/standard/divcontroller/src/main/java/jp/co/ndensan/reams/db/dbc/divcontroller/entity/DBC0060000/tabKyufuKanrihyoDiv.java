package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoHomonTsushoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoTankiNyushoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKyufuKanrihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKyufuKanrihyoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuKanrihyoHomonTsusho")
    private KyufuKanrihyoHomonTsushoDiv KyufuKanrihyoHomonTsusho;
    @JsonProperty("KyufuKanrihyoTankiNyusho")
    private KyufuKanrihyoTankiNyushoDiv KyufuKanrihyoTankiNyusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuKanrihyoHomonTsusho")
    public KyufuKanrihyoHomonTsushoDiv getKyufuKanrihyoHomonTsusho() {
        return KyufuKanrihyoHomonTsusho;
    }

    @JsonProperty("KyufuKanrihyoHomonTsusho")
    public void setKyufuKanrihyoHomonTsusho(KyufuKanrihyoHomonTsushoDiv KyufuKanrihyoHomonTsusho) {
        this.KyufuKanrihyoHomonTsusho=KyufuKanrihyoHomonTsusho;
    }

    @JsonProperty("KyufuKanrihyoTankiNyusho")
    public KyufuKanrihyoTankiNyushoDiv getKyufuKanrihyoTankiNyusho() {
        return KyufuKanrihyoTankiNyusho;
    }

    @JsonProperty("KyufuKanrihyoTankiNyusho")
    public void setKyufuKanrihyoTankiNyusho(KyufuKanrihyoTankiNyushoDiv KyufuKanrihyoTankiNyusho) {
        this.KyufuKanrihyoTankiNyusho=KyufuKanrihyoTankiNyusho;
    }

}
