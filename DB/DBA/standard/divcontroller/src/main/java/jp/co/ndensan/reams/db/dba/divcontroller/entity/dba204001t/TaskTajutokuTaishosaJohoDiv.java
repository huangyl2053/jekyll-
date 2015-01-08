package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaskTajutokuTaishosaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class TaskTajutokuTaishosaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("AtenaJoho")
    private AtenaShokaiSimpleDiv AtenaJoho;
    @JsonProperty("KaigoShikakuJoho")
    private KaigoShikakuKihonDiv KaigoShikakuJoho;

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

    @JsonProperty("KaigoShikakuJoho")
    public KaigoShikakuKihonDiv getKaigoShikakuJoho() {
        return KaigoShikakuJoho;
    }

    @JsonProperty("KaigoShikakuJoho")
    public void setKaigoShikakuJoho(KaigoShikakuKihonDiv KaigoShikakuJoho) {
        this.KaigoShikakuJoho = KaigoShikakuJoho;
    }

}
