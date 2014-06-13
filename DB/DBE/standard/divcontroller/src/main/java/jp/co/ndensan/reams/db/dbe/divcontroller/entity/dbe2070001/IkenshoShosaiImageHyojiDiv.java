package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
//import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.tabIkenshoImageHyojiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IkenshoShosaiImageHyoji のクラスファイル
 *
 * @author 自動生成
 */
public class IkenshoShosaiImageHyojiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtHyojiBairitsu")
    private TextBoxNum txtHyojiBairitsu;
    @JsonProperty("tabIkenshoImageHyoji")
    private tabIkenshoImageHyojiDiv tabIkenshoImageHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHyojiBairitsu")
    public TextBoxNum getTxtHyojiBairitsu() {
        return txtHyojiBairitsu;
    }

    @JsonProperty("txtHyojiBairitsu")
    public void setTxtHyojiBairitsu(TextBoxNum txtHyojiBairitsu) {
        this.txtHyojiBairitsu = txtHyojiBairitsu;
    }

    @JsonProperty("tabIkenshoImageHyoji")
    public tabIkenshoImageHyojiDiv getTabIkenshoImageHyoji() {
        return tabIkenshoImageHyoji;
    }

    @JsonProperty("tabIkenshoImageHyoji")
    public void setTabIkenshoImageHyoji(tabIkenshoImageHyojiDiv tabIkenshoImageHyoji) {
        this.tabIkenshoImageHyoji = tabIkenshoImageHyoji;
    }

}
