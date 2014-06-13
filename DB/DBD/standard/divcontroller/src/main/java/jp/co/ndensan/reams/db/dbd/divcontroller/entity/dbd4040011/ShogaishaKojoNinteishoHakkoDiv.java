package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoNinteishoHakko のクラスファイル
 *
 * @author 自動生成
 */
public class ShogaishaKojoNinteishoHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShogaishaKojoTaishoshaDetail")
    private ShogaishaKojoTaishoshaDetailDiv ShogaishaKojoTaishoshaDetail;
    @JsonProperty("ShogaishaKojoNinteisho")
    private ShogaishaKojoNinteishoDiv ShogaishaKojoNinteisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShogaishaKojoTaishoshaDetail")
    public ShogaishaKojoTaishoshaDetailDiv getShogaishaKojoTaishoshaDetail() {
        return ShogaishaKojoTaishoshaDetail;
    }

    @JsonProperty("ShogaishaKojoTaishoshaDetail")
    public void setShogaishaKojoTaishoshaDetail(ShogaishaKojoTaishoshaDetailDiv ShogaishaKojoTaishoshaDetail) {
        this.ShogaishaKojoTaishoshaDetail = ShogaishaKojoTaishoshaDetail;
    }

    @JsonProperty("ShogaishaKojoNinteisho")
    public ShogaishaKojoNinteishoDiv getShogaishaKojoNinteisho() {
        return ShogaishaKojoNinteisho;
    }

    @JsonProperty("ShogaishaKojoNinteisho")
    public void setShogaishaKojoNinteisho(ShogaishaKojoNinteishoDiv ShogaishaKojoNinteisho) {
        this.ShogaishaKojoNinteisho = ShogaishaKojoNinteisho;
    }

}
