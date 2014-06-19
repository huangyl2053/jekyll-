package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0942Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002.Kihonchosa0951Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09CenterRight のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09CenterRightDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa0942")
    private Kihonchosa0942Div Kihonchosa0942;
    @JsonProperty("Kihonchosa0951")
    private Kihonchosa0951Div Kihonchosa0951;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa0942")
    public Kihonchosa0942Div getKihonchosa0942() {
        return Kihonchosa0942;
    }

    @JsonProperty("Kihonchosa0942")
    public void setKihonchosa0942(Kihonchosa0942Div Kihonchosa0942) {
        this.Kihonchosa0942=Kihonchosa0942;
    }

    @JsonProperty("Kihonchosa0951")
    public Kihonchosa0951Div getKihonchosa0951() {
        return Kihonchosa0951;
    }

    @JsonProperty("Kihonchosa0951")
    public void setKihonchosa0951(Kihonchosa0951Div Kihonchosa0951) {
        this.Kihonchosa0951=Kihonchosa0951;
    }

}
