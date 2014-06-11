package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tabChosaKekkaShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tabIkenshoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tabShinsaKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001.tabTokkiJikoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabChosaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabChosaKekkaDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabChosaKekkaShosai")
    private tabChosaKekkaShosaiDiv tabChosaKekkaShosai;
    @JsonProperty("tabTokkiJiko")
    private tabTokkiJikoDiv tabTokkiJiko;
    @JsonProperty("tabIkensho")
    private tabIkenshoDiv tabIkensho;
    @JsonProperty("tabShinsaKekka")
    private tabShinsaKekkaDiv tabShinsaKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabChosaKekkaShosai")
    public tabChosaKekkaShosaiDiv getTabChosaKekkaShosai() {
        return tabChosaKekkaShosai;
    }

    @JsonProperty("tabChosaKekkaShosai")
    public void setTabChosaKekkaShosai(tabChosaKekkaShosaiDiv tabChosaKekkaShosai) {
        this.tabChosaKekkaShosai=tabChosaKekkaShosai;
    }

    @JsonProperty("tabTokkiJiko")
    public tabTokkiJikoDiv getTabTokkiJiko() {
        return tabTokkiJiko;
    }

    @JsonProperty("tabTokkiJiko")
    public void setTabTokkiJiko(tabTokkiJikoDiv tabTokkiJiko) {
        this.tabTokkiJiko=tabTokkiJiko;
    }

    @JsonProperty("tabIkensho")
    public tabIkenshoDiv getTabIkensho() {
        return tabIkensho;
    }

    @JsonProperty("tabIkensho")
    public void setTabIkensho(tabIkenshoDiv tabIkensho) {
        this.tabIkensho=tabIkensho;
    }

    @JsonProperty("tabShinsaKekka")
    public tabShinsaKekkaDiv getTabShinsaKekka() {
        return tabShinsaKekka;
    }

    @JsonProperty("tabShinsaKekka")
    public void setTabShinsaKekka(tabShinsaKekkaDiv tabShinsaKekka) {
        this.tabShinsaKekka=tabShinsaKekka;
    }

}
