package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa0961Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.Kihonchosa0971Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09Right のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09RightDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa0961")
    private Kihonchosa0961Div Kihonchosa0961;
    @JsonProperty("Kihonchosa0971")
    private Kihonchosa0971Div Kihonchosa0971;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa0961")
    public Kihonchosa0961Div getKihonchosa0961() {
        return Kihonchosa0961;
    }

    @JsonProperty("Kihonchosa0961")
    public void setKihonchosa0961(Kihonchosa0961Div Kihonchosa0961) {
        this.Kihonchosa0961=Kihonchosa0961;
    }

    @JsonProperty("Kihonchosa0971")
    public Kihonchosa0971Div getKihonchosa0971() {
        return Kihonchosa0971;
    }

    @JsonProperty("Kihonchosa0971")
    public void setKihonchosa0971(Kihonchosa0971Div Kihonchosa0971) {
        this.Kihonchosa0971=Kihonchosa0971;
    }

}
