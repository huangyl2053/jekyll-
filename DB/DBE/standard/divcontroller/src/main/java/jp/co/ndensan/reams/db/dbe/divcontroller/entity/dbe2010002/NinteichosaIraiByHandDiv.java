package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ButtonsForNinteichosaIraiByHandDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ChosaItakusakiAndChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ChosairaiBindByHandMainDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiByHand のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiByHandDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaItakusakiAndChosainList")
    private ChosaItakusakiAndChosainListDiv ChosaItakusakiAndChosainList;
    @JsonProperty("ChosairaiBindByHandMain")
    private ChosairaiBindByHandMainDiv ChosairaiBindByHandMain;
    @JsonProperty("ButtonsForNinteichosaIraiByHand")
    private ButtonsForNinteichosaIraiByHandDiv ButtonsForNinteichosaIraiByHand;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ChosaItakusakiAndChosainList")
    public ChosaItakusakiAndChosainListDiv getChosaItakusakiAndChosainList() {
        return ChosaItakusakiAndChosainList;
    }

    @JsonProperty("ChosaItakusakiAndChosainList")
    public void setChosaItakusakiAndChosainList(ChosaItakusakiAndChosainListDiv ChosaItakusakiAndChosainList) {
        this.ChosaItakusakiAndChosainList=ChosaItakusakiAndChosainList;
    }

    @JsonProperty("ChosairaiBindByHandMain")
    public ChosairaiBindByHandMainDiv getChosairaiBindByHandMain() {
        return ChosairaiBindByHandMain;
    }

    @JsonProperty("ChosairaiBindByHandMain")
    public void setChosairaiBindByHandMain(ChosairaiBindByHandMainDiv ChosairaiBindByHandMain) {
        this.ChosairaiBindByHandMain=ChosairaiBindByHandMain;
    }

    @JsonProperty("ButtonsForNinteichosaIraiByHand")
    public ButtonsForNinteichosaIraiByHandDiv getButtonsForNinteichosaIraiByHand() {
        return ButtonsForNinteichosaIraiByHand;
    }

    @JsonProperty("ButtonsForNinteichosaIraiByHand")
    public void setButtonsForNinteichosaIraiByHand(ButtonsForNinteichosaIraiByHandDiv ButtonsForNinteichosaIraiByHand) {
        this.ButtonsForNinteichosaIraiByHand=ButtonsForNinteichosaIraiByHand;
    }

}
