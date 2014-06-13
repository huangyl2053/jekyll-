package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0912Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa0921Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kihonchosa09CenterLeft のクラスファイル 
 * 
 * @author 自動生成
 */
public class Kihonchosa09CenterLeftDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Kihonchosa0912")
    private Kihonchosa0912Div Kihonchosa0912;
    @JsonProperty("Kihonchosa0921")
    private Kihonchosa0921Div Kihonchosa0921;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Kihonchosa0912")
    public Kihonchosa0912Div getKihonchosa0912() {
        return Kihonchosa0912;
    }

    @JsonProperty("Kihonchosa0912")
    public void setKihonchosa0912(Kihonchosa0912Div Kihonchosa0912) {
        this.Kihonchosa0912=Kihonchosa0912;
    }

    @JsonProperty("Kihonchosa0921")
    public Kihonchosa0921Div getKihonchosa0921() {
        return Kihonchosa0921;
    }

    @JsonProperty("Kihonchosa0921")
    public void setKihonchosa0921(Kihonchosa0921Div Kihonchosa0921) {
        this.Kihonchosa0921=Kihonchosa0921;
    }

}
