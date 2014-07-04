package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.MiwariateshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.WariateZumishaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplTaishoshaWariate のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplTaishoshaWariateDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Miwariatesha")
    private MiwariateshaDiv Miwariatesha;
    @JsonProperty("WariateZumisha")
    private WariateZumishaDiv WariateZumisha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Miwariatesha")
    public MiwariateshaDiv getMiwariatesha() {
        return Miwariatesha;
    }

    @JsonProperty("Miwariatesha")
    public void setMiwariatesha(MiwariateshaDiv Miwariatesha) {
        this.Miwariatesha=Miwariatesha;
    }

    @JsonProperty("WariateZumisha")
    public WariateZumishaDiv getWariateZumisha() {
        return WariateZumisha;
    }

    @JsonProperty("WariateZumisha")
    public void setWariateZumisha(WariateZumishaDiv WariateZumisha) {
        this.WariateZumisha=WariateZumisha;
    }

}
