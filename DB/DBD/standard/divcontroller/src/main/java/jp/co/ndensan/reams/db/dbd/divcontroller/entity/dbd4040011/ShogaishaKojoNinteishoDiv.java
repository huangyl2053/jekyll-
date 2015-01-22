package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoShinseishaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoNinteisho のクラスファイル
 *
 * @author 自動生成
 */
public class ShogaishaKojoNinteishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("NinteishoPrintSetting")
    private PrintContentsSettingDiv NinteishoPrintSetting;
    @JsonProperty("ShogaishaKojoShinseisha")
    private ShogaishaKojoShinseishaDiv ShogaishaKojoShinseisha;
    @JsonProperty("btnHakko")
    private Button btnHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteishoPrintSetting")
    public PrintContentsSettingDiv getNinteishoPrintSetting() {
        return NinteishoPrintSetting;
    }

    @JsonProperty("NinteishoPrintSetting")
    public void setNinteishoPrintSetting(PrintContentsSettingDiv NinteishoPrintSetting) {
        this.NinteishoPrintSetting = NinteishoPrintSetting;
    }

    @JsonProperty("ShogaishaKojoShinseisha")
    public ShogaishaKojoShinseishaDiv getShogaishaKojoShinseisha() {
        return ShogaishaKojoShinseisha;
    }

    @JsonProperty("ShogaishaKojoShinseisha")
    public void setShogaishaKojoShinseisha(ShogaishaKojoShinseishaDiv ShogaishaKojoShinseisha) {
        this.ShogaishaKojoShinseisha = ShogaishaKojoShinseisha;
    }

    @JsonProperty("btnHakko")
    public Button getBtnHakko() {
        return btnHakko;
    }

    @JsonProperty("btnHakko")
    public void setBtnHakko(Button btnHakko) {
        this.btnHakko = btnHakko;
    }

}
