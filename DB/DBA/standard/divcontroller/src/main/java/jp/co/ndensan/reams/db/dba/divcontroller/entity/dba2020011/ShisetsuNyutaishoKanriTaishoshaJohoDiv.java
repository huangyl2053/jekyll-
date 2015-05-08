package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.atenashokaisimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoKanriTaishoshaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuNyutaishoKanriTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("AtenaJoho")
    private AtenaShokaiSimpleDiv AtenaJoho;
    @JsonProperty("KaigoJoho")
    private KaigoShikakuKihonDiv KaigoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("AtenaJoho")
    public AtenaShokaiSimpleDiv getAtenaJoho() {
        return AtenaJoho;
    }

    @JsonProperty("AtenaJoho")
    public void setAtenaJoho(AtenaShokaiSimpleDiv AtenaJoho) {
        this.AtenaJoho = AtenaJoho;
    }

    @JsonProperty("KaigoJoho")
    public KaigoShikakuKihonDiv getKaigoJoho() {
        return KaigoJoho;
    }

    @JsonProperty("KaigoJoho")
    public void setKaigoJoho(KaigoShikakuKihonDiv KaigoJoho) {
        this.KaigoJoho = KaigoJoho;
    }

}
