package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.IkenshoIraiIkkatuHakkoTabDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.NinteichosaIraiIkkatuHakkoTabDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabIraishoIkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabIraishoIkkatsuHakkoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiIkkatuHakkoTab")
    private NinteichosaIraiIkkatuHakkoTabDiv NinteichosaIraiIkkatuHakkoTab;
    @JsonProperty("IkenshoIraiIkkatuHakkoTab")
    private IkenshoIraiIkkatuHakkoTabDiv IkenshoIraiIkkatuHakkoTab;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraiIkkatuHakkoTab")
    public NinteichosaIraiIkkatuHakkoTabDiv getNinteichosaIraiIkkatuHakkoTab() {
        return NinteichosaIraiIkkatuHakkoTab;
    }

    @JsonProperty("NinteichosaIraiIkkatuHakkoTab")
    public void setNinteichosaIraiIkkatuHakkoTab(NinteichosaIraiIkkatuHakkoTabDiv NinteichosaIraiIkkatuHakkoTab) {
        this.NinteichosaIraiIkkatuHakkoTab=NinteichosaIraiIkkatuHakkoTab;
    }

    @JsonProperty("IkenshoIraiIkkatuHakkoTab")
    public IkenshoIraiIkkatuHakkoTabDiv getIkenshoIraiIkkatuHakkoTab() {
        return IkenshoIraiIkkatuHakkoTab;
    }

    @JsonProperty("IkenshoIraiIkkatuHakkoTab")
    public void setIkenshoIraiIkkatuHakkoTab(IkenshoIraiIkkatuHakkoTabDiv IkenshoIraiIkkatuHakkoTab) {
        this.IkenshoIraiIkkatuHakkoTab=IkenshoIraiIkkatuHakkoTab;
    }

}
