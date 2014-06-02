package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0931Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0941Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09Center のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09CenterDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa0931")
    private Kihonchosa0931Div Kihonchosa0931;
    @JsonProperty("Kihonchosa0941")
    private Kihonchosa0941Div Kihonchosa0941;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa0931")
    public Kihonchosa0931Div getKihonchosa0931() {
        return Kihonchosa0931;
    }

    @JsonProperty("Kihonchosa0931")
    public void setKihonchosa0931(Kihonchosa0931Div Kihonchosa0931) {
        this.Kihonchosa0931=Kihonchosa0931;
    }

    @JsonProperty("Kihonchosa0941")
    public Kihonchosa0941Div getKihonchosa0941() {
        return Kihonchosa0941;
    }

    @JsonProperty("Kihonchosa0941")
    public void setKihonchosa0941(Kihonchosa0941Div Kihonchosa0941) {
        this.Kihonchosa0941=Kihonchosa0941;
    }

}
