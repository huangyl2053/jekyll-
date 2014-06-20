package jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosaItakusakiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.chosaItakusakiSelector.ChosainDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakusaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaItakusakiList")
    private ChosaItakusakiListDiv ChosaItakusakiList;
    @JsonProperty("Chosain")
    private ChosainDiv Chosain;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ChosaItakusakiList")
    public ChosaItakusakiListDiv getChosaItakusakiList() {
        return ChosaItakusakiList;
    }

    @JsonProperty("ChosaItakusakiList")
    public void setChosaItakusakiList(ChosaItakusakiListDiv ChosaItakusakiList) {
        this.ChosaItakusakiList=ChosaItakusakiList;
    }

    @JsonProperty("Chosain")
    public ChosainDiv getChosain() {
        return Chosain;
    }

    @JsonProperty("Chosain")
    public void setChosain(ChosainDiv Chosain) {
        this.Chosain=Chosain;
    }

}
