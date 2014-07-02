package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * KogakuServicehiJudgementResultDetail1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuServicehiJudgementResultDetail1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUketsukeDate")
    private TextBoxDate txtUketsukeDate;
    @JsonProperty("txtHonninPaymentAmount")
    private TextBoxNum txtHonninPaymentAmount;
    @JsonProperty("txtKetteiDate")
    private TextBoxDate txtKetteiDate;
    @JsonProperty("radShikyuKubun")
    private RadioButton radShikyuKubun;
    @JsonProperty("txtsetaiShuyakuNo")
    private TextBoxCode txtsetaiShuyakuNo;
    @JsonProperty("txtShikyuAmount")
    private TextBoxNum txtShikyuAmount;
    @JsonProperty("radIsKogakuAutoShokan")
    private RadioButton radIsKogakuAutoShokan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtUketsukeDate")
    public TextBoxDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxDate txtUketsukeDate) {
        this.txtUketsukeDate=txtUketsukeDate;
    }

    @JsonProperty("txtHonninPaymentAmount")
    public TextBoxNum getTxtHonninPaymentAmount() {
        return txtHonninPaymentAmount;
    }

    @JsonProperty("txtHonninPaymentAmount")
    public void setTxtHonninPaymentAmount(TextBoxNum txtHonninPaymentAmount) {
        this.txtHonninPaymentAmount=txtHonninPaymentAmount;
    }

    @JsonProperty("txtKetteiDate")
    public TextBoxDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxDate txtKetteiDate) {
        this.txtKetteiDate=txtKetteiDate;
    }

    @JsonProperty("radShikyuKubun")
    public RadioButton getRadShikyuKubun() {
        return radShikyuKubun;
    }

    @JsonProperty("radShikyuKubun")
    public void setRadShikyuKubun(RadioButton radShikyuKubun) {
        this.radShikyuKubun=radShikyuKubun;
    }

    @JsonProperty("txtsetaiShuyakuNo")
    public TextBoxCode getTxtsetaiShuyakuNo() {
        return txtsetaiShuyakuNo;
    }

    @JsonProperty("txtsetaiShuyakuNo")
    public void setTxtsetaiShuyakuNo(TextBoxCode txtsetaiShuyakuNo) {
        this.txtsetaiShuyakuNo=txtsetaiShuyakuNo;
    }

    @JsonProperty("txtShikyuAmount")
    public TextBoxNum getTxtShikyuAmount() {
        return txtShikyuAmount;
    }

    @JsonProperty("txtShikyuAmount")
    public void setTxtShikyuAmount(TextBoxNum txtShikyuAmount) {
        this.txtShikyuAmount=txtShikyuAmount;
    }

    @JsonProperty("radIsKogakuAutoShokan")
    public RadioButton getRadIsKogakuAutoShokan() {
        return radIsKogakuAutoShokan;
    }

    @JsonProperty("radIsKogakuAutoShokan")
    public void setRadIsKogakuAutoShokan(RadioButton radIsKogakuAutoShokan) {
        this.radIsKogakuAutoShokan=radIsKogakuAutoShokan;
    }

}
