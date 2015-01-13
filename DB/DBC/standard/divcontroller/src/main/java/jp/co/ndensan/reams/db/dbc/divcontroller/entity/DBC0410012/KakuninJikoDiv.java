package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KakuninJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class KakuninJikoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKakuninJiko1")
    private Label lblKakuninJiko1;
    @JsonProperty("lblKakuninJiko2")
    private Label lblKakuninJiko2;
    @JsonProperty("lblKakuninJiko3")
    private Label lblKakuninJiko3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKakuninJiko1")
    public Label getLblKakuninJiko1() {
        return lblKakuninJiko1;
    }

    @JsonProperty("lblKakuninJiko1")
    public void setLblKakuninJiko1(Label lblKakuninJiko1) {
        this.lblKakuninJiko1=lblKakuninJiko1;
    }

    @JsonProperty("lblKakuninJiko2")
    public Label getLblKakuninJiko2() {
        return lblKakuninJiko2;
    }

    @JsonProperty("lblKakuninJiko2")
    public void setLblKakuninJiko2(Label lblKakuninJiko2) {
        this.lblKakuninJiko2=lblKakuninJiko2;
    }

    @JsonProperty("lblKakuninJiko3")
    public Label getLblKakuninJiko3() {
        return lblKakuninJiko3;
    }

    @JsonProperty("lblKakuninJiko3")
    public void setLblKakuninJiko3(Label lblKakuninJiko3) {
        this.lblKakuninJiko3=lblKakuninJiko3;
    }

}
