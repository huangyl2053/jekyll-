package jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei.FutanGendogakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutanGendogakuNinteiRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiRiyoshaFutanDiv extends Panel {
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
    @JsonProperty("txtKyushochisha")
    private TextBox txtKyushochisha;
    @JsonProperty("txtFutanDankai")
    private TextBox txtFutanDankai;
    @JsonProperty("txtKyoshitsuType")
    private TextBox txtKyoshitsuType;
    @JsonProperty("txtKyokaiso")
    private TextBox txtKyokaiso;
    @JsonProperty("txtGekihenKanwa")
    private TextBox txtGekihenKanwa;
    @JsonProperty("FutanGendogaku")
    private FutanGendogakuDiv FutanGendogaku;
    @JsonProperty("txtFushoninRiyu")
    private TextBoxMultiLine txtFushoninRiyu;

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

    @JsonProperty("txtKyushochisha")
    public TextBox getTxtKyushochisha() {
        return txtKyushochisha;
    }

    @JsonProperty("txtKyushochisha")
    public void setTxtKyushochisha(TextBox txtKyushochisha) {
        this.txtKyushochisha=txtKyushochisha;
    }

    @JsonProperty("txtFutanDankai")
    public TextBox getTxtFutanDankai() {
        return txtFutanDankai;
    }

    @JsonProperty("txtFutanDankai")
    public void setTxtFutanDankai(TextBox txtFutanDankai) {
        this.txtFutanDankai=txtFutanDankai;
    }

    @JsonProperty("txtKyoshitsuType")
    public TextBox getTxtKyoshitsuType() {
        return txtKyoshitsuType;
    }

    @JsonProperty("txtKyoshitsuType")
    public void setTxtKyoshitsuType(TextBox txtKyoshitsuType) {
        this.txtKyoshitsuType=txtKyoshitsuType;
    }

    @JsonProperty("txtKyokaiso")
    public TextBox getTxtKyokaiso() {
        return txtKyokaiso;
    }

    @JsonProperty("txtKyokaiso")
    public void setTxtKyokaiso(TextBox txtKyokaiso) {
        this.txtKyokaiso=txtKyokaiso;
    }

    @JsonProperty("txtGekihenKanwa")
    public TextBox getTxtGekihenKanwa() {
        return txtGekihenKanwa;
    }

    @JsonProperty("txtGekihenKanwa")
    public void setTxtGekihenKanwa(TextBox txtGekihenKanwa) {
        this.txtGekihenKanwa=txtGekihenKanwa;
    }

    @JsonProperty("FutanGendogaku")
    public FutanGendogakuDiv getFutanGendogaku() {
        return FutanGendogaku;
    }

    @JsonProperty("FutanGendogaku")
    public void setFutanGendogaku(FutanGendogakuDiv FutanGendogaku) {
        this.FutanGendogaku=FutanGendogaku;
    }

    @JsonProperty("txtFushoninRiyu")
    public TextBoxMultiLine getTxtFushoninRiyu() {
        return txtFushoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public void setTxtFushoninRiyu(TextBoxMultiLine txtFushoninRiyu) {
        this.txtFushoninRiyu=txtFushoninRiyu;
    }

}
