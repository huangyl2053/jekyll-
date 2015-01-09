package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011.ShogaishaKojoNinteishoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoTaishoshaNinteishoHakkoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("TaishoshaAtena")
    private KaigoAtenaInfoDiv TaishoshaAtena;
    @JsonProperty("TaishoshaKaigoShikaku")
    private KaigoShikakuKihonDiv TaishoshaKaigoShikaku;
    @JsonProperty("ShogaishaKojoNinteishoHakko")
    private ShogaishaKojoNinteishoHakkoDiv ShogaishaKojoNinteishoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TaishoshaAtena")
    public KaigoAtenaInfoDiv getTaishoshaAtena() {
        return TaishoshaAtena;
    }

    @JsonProperty("TaishoshaAtena")
    public void setTaishoshaAtena(KaigoAtenaInfoDiv TaishoshaAtena) {
        this.TaishoshaAtena = TaishoshaAtena;
    }

    @JsonProperty("TaishoshaKaigoShikaku")
    public KaigoShikakuKihonDiv getTaishoshaKaigoShikaku() {
        return TaishoshaKaigoShikaku;
    }

    @JsonProperty("TaishoshaKaigoShikaku")
    public void setTaishoshaKaigoShikaku(KaigoShikakuKihonDiv TaishoshaKaigoShikaku) {
        this.TaishoshaKaigoShikaku = TaishoshaKaigoShikaku;
    }

    @JsonProperty("ShogaishaKojoNinteishoHakko")
    public ShogaishaKojoNinteishoHakkoDiv getShogaishaKojoNinteishoHakko() {
        return ShogaishaKojoNinteishoHakko;
    }

    @JsonProperty("ShogaishaKojoNinteishoHakko")
    public void setShogaishaKojoNinteishoHakko(ShogaishaKojoNinteishoHakkoDiv ShogaishaKojoNinteishoHakko) {
        this.ShogaishaKojoNinteishoHakko = ShogaishaKojoNinteishoHakko;
    }

}
