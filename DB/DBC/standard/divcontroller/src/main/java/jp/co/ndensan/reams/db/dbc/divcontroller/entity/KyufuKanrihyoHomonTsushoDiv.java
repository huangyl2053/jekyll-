package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * KyufuKanrihyoHomonTsusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuKanrihyoHomonTsushoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufuKanrihyoInfoHomonTsusho")
    private KyufuKanrihyoInfoDiv KyufuKanrihyoInfoHomonTsusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuKanrihyoInfoHomonTsusho")
    public KyufuKanrihyoInfoDiv getKyufuKanrihyoInfoHomonTsusho() {
        return KyufuKanrihyoInfoHomonTsusho;
    }

    @JsonProperty("KyufuKanrihyoInfoHomonTsusho")
    public void setKyufuKanrihyoInfoHomonTsusho(KyufuKanrihyoInfoDiv KyufuKanrihyoInfoHomonTsusho) {
        this.KyufuKanrihyoInfoHomonTsusho=KyufuKanrihyoInfoHomonTsusho;
    }

}
