package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0911Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09Left のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09LeftDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa0911")
    private Kihonchosa0911Div Kihonchosa0911;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa0911")
    public Kihonchosa0911Div getKihonchosa0911() {
        return Kihonchosa0911;
    }

    @JsonProperty("Kihonchosa0911")
    public void setKihonchosa0911(Kihonchosa0911Div Kihonchosa0911) {
        this.Kihonchosa0911=Kihonchosa0911;
    }

}
