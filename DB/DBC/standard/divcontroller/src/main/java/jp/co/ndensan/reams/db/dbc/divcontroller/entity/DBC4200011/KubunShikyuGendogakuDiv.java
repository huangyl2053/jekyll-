package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC4200011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KubunShikyuGendogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KubunShikyuGendogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKubunShikyuGengogaku")
    private Label lblKubunShikyuGengogaku;
    @JsonProperty("tplKubunShikyuGendogaku")
    private tplKubunShikyuGendogakuDiv tplKubunShikyuGendogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKubunShikyuGengogaku")
    public Label getLblKubunShikyuGengogaku() {
        return lblKubunShikyuGengogaku;
    }

    @JsonProperty("lblKubunShikyuGengogaku")
    public void setLblKubunShikyuGengogaku(Label lblKubunShikyuGengogaku) {
        this.lblKubunShikyuGengogaku=lblKubunShikyuGengogaku;
    }

    @JsonProperty("tplKubunShikyuGendogaku")
    public tplKubunShikyuGendogakuDiv getTplKubunShikyuGendogaku() {
        return tplKubunShikyuGendogaku;
    }

    @JsonProperty("tplKubunShikyuGendogaku")
    public void setTplKubunShikyuGendogaku(tplKubunShikyuGendogakuDiv tplKubunShikyuGendogaku) {
        this.tplKubunShikyuGendogaku=tplKubunShikyuGendogaku;
    }

}
