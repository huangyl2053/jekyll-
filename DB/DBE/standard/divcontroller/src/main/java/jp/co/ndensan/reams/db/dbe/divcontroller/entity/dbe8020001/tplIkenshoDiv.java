package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tabIkenshoKojinShokaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIkenshoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabIkenshoKojinShokai")
    private tabIkenshoKojinShokaiDiv tabIkenshoKojinShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabIkenshoKojinShokai")
    public tabIkenshoKojinShokaiDiv getTabIkenshoKojinShokai() {
        return tabIkenshoKojinShokai;
    }

    @JsonProperty("tabIkenshoKojinShokai")
    public void setTabIkenshoKojinShokai(tabIkenshoKojinShokaiDiv tabIkenshoKojinShokai) {
        this.tabIkenshoKojinShokai=tabIkenshoKojinShokai;
    }

}
