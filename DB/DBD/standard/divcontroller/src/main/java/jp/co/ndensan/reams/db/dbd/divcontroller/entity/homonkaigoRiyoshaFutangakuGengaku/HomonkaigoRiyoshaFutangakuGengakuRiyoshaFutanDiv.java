package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiDate")
    private TextBoxFlexibleDate txtKetteiDate;
    @JsonProperty("txtKetteiKubun")
    private TextBox txtKetteiKubun;
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtYukokigenDate")
    private TextBoxFlexibleDate txtYukokigenDate;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("txtHishoninRiyu")
    private TextBoxMultiLine txtHishoninRiyu;
    @JsonProperty("txtKohiFutanshaNo")
    private TextBoxCode txtKohiFutanshaNo;
    @JsonProperty("txtKohiJukyushaNo")
    private TextBoxCode txtKohiJukyushaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.txtKetteiDate=txtKetteiDate;
    }

    @JsonProperty("txtKetteiKubun")
    public TextBox getTxtKetteiKubun() {
        return txtKetteiKubun;
    }

    @JsonProperty("txtKetteiKubun")
    public void setTxtKetteiKubun(TextBox txtKetteiKubun) {
        this.txtKetteiKubun=txtKetteiKubun;
    }

    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate=txtTekiyoDate;
    }

    @JsonProperty("txtYukokigenDate")
    public TextBoxFlexibleDate getTxtYukokigenDate() {
        return txtYukokigenDate;
    }

    @JsonProperty("txtYukokigenDate")
    public void setTxtYukokigenDate(TextBoxFlexibleDate txtYukokigenDate) {
        this.txtYukokigenDate=txtYukokigenDate;
    }

    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu=txtKyufuRitsu;
    }

    @JsonProperty("txtHishoninRiyu")
    public TextBoxMultiLine getTxtHishoninRiyu() {
        return txtHishoninRiyu;
    }

    @JsonProperty("txtHishoninRiyu")
    public void setTxtHishoninRiyu(TextBoxMultiLine txtHishoninRiyu) {
        this.txtHishoninRiyu=txtHishoninRiyu;
    }

    @JsonProperty("txtKohiFutanshaNo")
    public TextBoxCode getTxtKohiFutanshaNo() {
        return txtKohiFutanshaNo;
    }

    @JsonProperty("txtKohiFutanshaNo")
    public void setTxtKohiFutanshaNo(TextBoxCode txtKohiFutanshaNo) {
        this.txtKohiFutanshaNo=txtKohiFutanshaNo;
    }

    @JsonProperty("txtKohiJukyushaNo")
    public TextBoxCode getTxtKohiJukyushaNo() {
        return txtKohiJukyushaNo;
    }

    @JsonProperty("txtKohiJukyushaNo")
    public void setTxtKohiJukyushaNo(TextBoxCode txtKohiJukyushaNo) {
        this.txtKohiJukyushaNo=txtKohiJukyushaNo;
    }

}
