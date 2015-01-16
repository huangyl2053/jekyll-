package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.ChoshuYuyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.GemmenDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GemmenChoshuYuyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenChoshuYuyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Gemmen")
    private GemmenDiv Gemmen;
    @JsonProperty("ChoshuYuyo")
    private ChoshuYuyoDiv ChoshuYuyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Gemmen")
    public GemmenDiv getGemmen() {
        return Gemmen;
    }

    @JsonProperty("Gemmen")
    public void setGemmen(GemmenDiv Gemmen) {
        this.Gemmen=Gemmen;
    }

    @JsonProperty("ChoshuYuyo")
    public ChoshuYuyoDiv getChoshuYuyo() {
        return ChoshuYuyo;
    }

    @JsonProperty("ChoshuYuyo")
    public void setChoshuYuyo(ChoshuYuyoDiv ChoshuYuyo) {
        this.ChoshuYuyo=ChoshuYuyo;
    }

}
