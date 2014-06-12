package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku.ShogaishaTechoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HomonkaigoRiyoshaFutangakuGengakuDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonkaigoRiyoshaFutangakuGengakuDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtShinseiRiyu")
    private TextBox txtShinseiRiyu;
    @JsonProperty("txtHobetsuKubun")
    private TextBox txtHobetsuKubun;
    @JsonProperty("ShogaishaTecho")
    private ShogaishaTechoDiv ShogaishaTecho;
    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan")
    private HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBox getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBox txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

    @JsonProperty("txtHobetsuKubun")
    public TextBox getTxtHobetsuKubun() {
        return txtHobetsuKubun;
    }

    @JsonProperty("txtHobetsuKubun")
    public void setTxtHobetsuKubun(TextBox txtHobetsuKubun) {
        this.txtHobetsuKubun=txtHobetsuKubun;
    }

    @JsonProperty("ShogaishaTecho")
    public ShogaishaTechoDiv getShogaishaTecho() {
        return ShogaishaTecho;
    }

    @JsonProperty("ShogaishaTecho")
    public void setShogaishaTecho(ShogaishaTechoDiv ShogaishaTecho) {
        this.ShogaishaTecho=ShogaishaTecho;
    }

    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan")
    public HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan() {
        return HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan;
    }

    @JsonProperty("HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan")
    public void setHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan(HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan) {
        this.HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan=HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan;
    }

}
