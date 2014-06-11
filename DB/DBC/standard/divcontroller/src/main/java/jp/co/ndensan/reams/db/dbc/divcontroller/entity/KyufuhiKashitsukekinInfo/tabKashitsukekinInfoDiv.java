package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKashitsukekinInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKashitsukekinInfoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKashitsukekinShinsei")
    private tplKashitsukekinShinseiDiv tplKashitsukekinShinsei;
    @JsonProperty("tplKashitsukekinKettei")
    private tplKashitsukekinKetteiDiv tplKashitsukekinKettei;
    @JsonProperty("tplKashitsukekinKariuke")
    private tplKashitsukekinKariukeDiv tplKashitsukekinKariuke;
    @JsonProperty("tplKashitsukekinHenko")
    private tplKashitsukekinHenkoDiv tplKashitsukekinHenko;
    @JsonProperty("tplKashitsukekinKoza")
    private tplKashitsukekinKozaDiv tplKashitsukekinKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplKashitsukekinShinsei")
    public tplKashitsukekinShinseiDiv getTplKashitsukekinShinsei() {
        return tplKashitsukekinShinsei;
    }

    @JsonProperty("tplKashitsukekinShinsei")
    public void setTplKashitsukekinShinsei(tplKashitsukekinShinseiDiv tplKashitsukekinShinsei) {
        this.tplKashitsukekinShinsei=tplKashitsukekinShinsei;
    }

    @JsonProperty("tplKashitsukekinKettei")
    public tplKashitsukekinKetteiDiv getTplKashitsukekinKettei() {
        return tplKashitsukekinKettei;
    }

    @JsonProperty("tplKashitsukekinKettei")
    public void setTplKashitsukekinKettei(tplKashitsukekinKetteiDiv tplKashitsukekinKettei) {
        this.tplKashitsukekinKettei=tplKashitsukekinKettei;
    }

    @JsonProperty("tplKashitsukekinKariuke")
    public tplKashitsukekinKariukeDiv getTplKashitsukekinKariuke() {
        return tplKashitsukekinKariuke;
    }

    @JsonProperty("tplKashitsukekinKariuke")
    public void setTplKashitsukekinKariuke(tplKashitsukekinKariukeDiv tplKashitsukekinKariuke) {
        this.tplKashitsukekinKariuke=tplKashitsukekinKariuke;
    }

    @JsonProperty("tplKashitsukekinHenko")
    public tplKashitsukekinHenkoDiv getTplKashitsukekinHenko() {
        return tplKashitsukekinHenko;
    }

    @JsonProperty("tplKashitsukekinHenko")
    public void setTplKashitsukekinHenko(tplKashitsukekinHenkoDiv tplKashitsukekinHenko) {
        this.tplKashitsukekinHenko=tplKashitsukekinHenko;
    }

    @JsonProperty("tplKashitsukekinKoza")
    public tplKashitsukekinKozaDiv getTplKashitsukekinKoza() {
        return tplKashitsukekinKoza;
    }

    @JsonProperty("tplKashitsukekinKoza")
    public void setTplKashitsukekinKoza(tplKashitsukekinKozaDiv tplKashitsukekinKoza) {
        this.tplKashitsukekinKoza=tplKashitsukekinKoza;
    }

}
