package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe2050001.tabIraishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IraishoIkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraishoIkkatsuHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabIraishoIkkatsuHakko")
    private tabIraishoIkkatsuHakkoDiv tabIraishoIkkatsuHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabIraishoIkkatsuHakko")
    public tabIraishoIkkatsuHakkoDiv getTabIraishoIkkatsuHakko() {
        return tabIraishoIkkatsuHakko;
    }

    @JsonProperty("tabIraishoIkkatsuHakko")
    public void setTabIraishoIkkatsuHakko(tabIraishoIkkatsuHakkoDiv tabIraishoIkkatsuHakko) {
        this.tabIraishoIkkatsuHakko=tabIraishoIkkatsuHakko;
    }

}
