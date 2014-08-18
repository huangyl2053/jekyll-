package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaShikaiTaishoshaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaShikaiTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshaShokaiCommonJoho")
    private KaigoAtenaInfoDiv HihokenshaShokaiCommonJoho;
    @JsonProperty("HihokenshaShokaiDbJoho")
    private KaigoShikakuKihonDiv HihokenshaShokaiDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaShokaiCommonJoho")
    public KaigoAtenaInfoDiv getHihokenshaShokaiCommonJoho() {
        return HihokenshaShokaiCommonJoho;
    }

    @JsonProperty("HihokenshaShokaiCommonJoho")
    public void setHihokenshaShokaiCommonJoho(KaigoAtenaInfoDiv HihokenshaShokaiCommonJoho) {
        this.HihokenshaShokaiCommonJoho = HihokenshaShokaiCommonJoho;
    }

    @JsonProperty("HihokenshaShokaiDbJoho")
    public KaigoShikakuKihonDiv getHihokenshaShokaiDbJoho() {
        return HihokenshaShokaiDbJoho;
    }

    @JsonProperty("HihokenshaShokaiDbJoho")
    public void setHihokenshaShokaiDbJoho(KaigoShikakuKihonDiv HihokenshaShokaiDbJoho) {
        this.HihokenshaShokaiDbJoho = HihokenshaShokaiDbJoho;
    }

}
