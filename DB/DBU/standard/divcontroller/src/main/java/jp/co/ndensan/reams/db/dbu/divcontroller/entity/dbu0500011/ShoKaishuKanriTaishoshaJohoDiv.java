package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShoKaishuKanriTaishoshaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuKanriTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShoKaishuKanriTaishoshaCommonJoho")
    private KaigoAtenaInfoDiv ShoKaishuKanriTaishoshaCommonJoho;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShoKaishuKanriTaishoshaCommonJoho")
    public KaigoAtenaInfoDiv getShoKaishuKanriTaishoshaCommonJoho() {
        return ShoKaishuKanriTaishoshaCommonJoho;
    }

    @JsonProperty("ShoKaishuKanriTaishoshaCommonJoho")
    public void setShoKaishuKanriTaishoshaCommonJoho(KaigoAtenaInfoDiv ShoKaishuKanriTaishoshaCommonJoho) {
        this.ShoKaishuKanriTaishoshaCommonJoho = ShoKaishuKanriTaishoshaCommonJoho;
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
