package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tabNinteiChosaKojinShokaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplNinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplNinteiChosaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabNinteiChosaKojinShokai")
    private tabNinteiChosaKojinShokaiDiv tabNinteiChosaKojinShokai;
    @JsonProperty("btnToShowTokkiImage")
    private ButtonDialog btnToShowTokkiImage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabNinteiChosaKojinShokai")
    public tabNinteiChosaKojinShokaiDiv getTabNinteiChosaKojinShokai() {
        return tabNinteiChosaKojinShokai;
    }

    @JsonProperty("tabNinteiChosaKojinShokai")
    public void setTabNinteiChosaKojinShokai(tabNinteiChosaKojinShokaiDiv tabNinteiChosaKojinShokai) {
        this.tabNinteiChosaKojinShokai=tabNinteiChosaKojinShokai;
    }

    @JsonProperty("btnToShowTokkiImage")
    public ButtonDialog getBtnToShowTokkiImage() {
        return btnToShowTokkiImage;
    }

    @JsonProperty("btnToShowTokkiImage")
    public void setBtnToShowTokkiImage(ButtonDialog btnToShowTokkiImage) {
        this.btnToShowTokkiImage=btnToShowTokkiImage;
    }

}
