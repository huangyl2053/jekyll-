package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshashoHakkoTaishoshaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshashoHakkoTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshashoHakkoTaishoshaCommonJoho")
    private KaigoAtenaInfoDiv HihokenshashoHakkoTaishoshaCommonJoho;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaCommonJoho")
    public KaigoAtenaInfoDiv getHihokenshashoHakkoTaishoshaCommonJoho() {
        return HihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("HihokenshashoHakkoTaishoshaCommonJoho")
    public void setHihokenshashoHakkoTaishoshaCommonJoho(KaigoAtenaInfoDiv HihokenshashoHakkoTaishoshaCommonJoho) {
        this.HihokenshashoHakkoTaishoshaCommonJoho = HihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("ccdKaigoShikakuKihon")
    public KaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    @JsonProperty("ccdKaigoShikakuKihon")
    public void setCcdKaigoShikakuKihon(KaigoShikakuKihonDiv ccdKaigoShikakuKihon) {
        this.ccdKaigoShikakuKihon = ccdKaigoShikakuKihon;
    }

}
