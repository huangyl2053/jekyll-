package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ButtonsForBindingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.RequestContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ninteichosaIraiListForByHandCom.NinteichosaIraiListForByHandCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosairaiBindByHandMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosairaiBindByHandMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RequestContents")
    private RequestContentsDiv RequestContents;
    @JsonProperty("comWaritukezumiList")
    private NinteichosaIraiListForByHandCom comWaritukezumiList;
    @JsonProperty("ButtonsForBinding")
    private ButtonsForBindingDiv ButtonsForBinding;
    @JsonProperty("comMiwarituskeList")
    private NinteichosaIraiListForByHandCom comMiwarituskeList;
    @JsonProperty("comNinteichosaIraiListGod")
    private NinteichosaIraiListForByHandCom comNinteichosaIraiListGod;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("RequestContents")
    public RequestContentsDiv getRequestContents() {
        return RequestContents;
    }

    @JsonProperty("RequestContents")
    public void setRequestContents(RequestContentsDiv RequestContents) {
        this.RequestContents=RequestContents;
    }

    @JsonProperty("comWaritukezumiList")
    public NinteichosaIraiListForByHandCom getComWaritukezumiList() {
        return comWaritukezumiList;
    }

    @JsonProperty("comWaritukezumiList")
    public void setComWaritukezumiList(NinteichosaIraiListForByHandCom comWaritukezumiList) {
        this.comWaritukezumiList=comWaritukezumiList;
    }

    @JsonProperty("ButtonsForBinding")
    public ButtonsForBindingDiv getButtonsForBinding() {
        return ButtonsForBinding;
    }

    @JsonProperty("ButtonsForBinding")
    public void setButtonsForBinding(ButtonsForBindingDiv ButtonsForBinding) {
        this.ButtonsForBinding=ButtonsForBinding;
    }

    @JsonProperty("comMiwarituskeList")
    public NinteichosaIraiListForByHandCom getComMiwarituskeList() {
        return comMiwarituskeList;
    }

    @JsonProperty("comMiwarituskeList")
    public void setComMiwarituskeList(NinteichosaIraiListForByHandCom comMiwarituskeList) {
        this.comMiwarituskeList=comMiwarituskeList;
    }

    @JsonProperty("comNinteichosaIraiListGod")
    public NinteichosaIraiListForByHandCom getComNinteichosaIraiListGod() {
        return comNinteichosaIraiListGod;
    }

    @JsonProperty("comNinteichosaIraiListGod")
    public void setComNinteichosaIraiListGod(NinteichosaIraiListForByHandCom comNinteichosaIraiListGod) {
        this.comNinteichosaIraiListGod=comNinteichosaIraiListGod;
    }

}
