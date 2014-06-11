package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
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
    private AtenaShokaiSimpleDiv HihokenshashoHakkoTaishoshaCommonJoho;
    @JsonProperty("HihokenshashoHakkoTaishoshaDbJoho")
    private HihokenshashoHakkoTaishoshaDbJohoDiv HihokenshashoHakkoTaishoshaDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaCommonJoho")
    public AtenaShokaiSimpleDiv getHihokenshashoHakkoTaishoshaCommonJoho() {
        return HihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("HihokenshashoHakkoTaishoshaCommonJoho")
    public void setHihokenshashoHakkoTaishoshaCommonJoho(AtenaShokaiSimpleDiv HihokenshashoHakkoTaishoshaCommonJoho) {
        this.HihokenshashoHakkoTaishoshaCommonJoho = HihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("HihokenshashoHakkoTaishoshaDbJoho")
    public HihokenshashoHakkoTaishoshaDbJohoDiv getHihokenshashoHakkoTaishoshaDbJoho() {
        return HihokenshashoHakkoTaishoshaDbJoho;
    }

    @JsonProperty("HihokenshashoHakkoTaishoshaDbJoho")
    public void setHihokenshashoHakkoTaishoshaDbJoho(HihokenshashoHakkoTaishoshaDbJohoDiv HihokenshashoHakkoTaishoshaDbJoho) {
        this.HihokenshashoHakkoTaishoshaDbJoho = HihokenshashoHakkoTaishoshaDbJoho;
    }

}
