package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA7030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuKihonJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuKihonJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdKaigoShikakuJoho")
    private KaigoShikakuKihonDiv ccdKaigoShikakuJoho;
    @JsonProperty("ccdAtenaJoho")
    private AtenaShokaiSimpleDiv ccdAtenaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoShikakuJoho")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuJoho() {
        return ccdKaigoShikakuJoho;
    }

    @JsonProperty("ccdAtenaJoho")
    public IAtenaShokaiSimpleDiv getCcdAtenaJoho() {
        return ccdAtenaJoho;
    }

}
