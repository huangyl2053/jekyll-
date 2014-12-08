package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKozaPaymentDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KozaPayment のクラスファイル 
 * 
 * @author 自動生成
 */
public class KozaPaymentDiv extends Panel implements IKozaPaymentDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKinyuKikanCode")
    private TextBoxCode txtKinyuKikanCode;
    @JsonProperty("txtKinyuKikanName")
    private TextBox txtKinyuKikanName;
    @JsonProperty("radKozaShubetsu")
    private RadioButton radKozaShubetsu;
    @JsonProperty("txtKozaMeigininKana")
    private TextBox txtKozaMeigininKana;
    @JsonProperty("txtKinyuKikanBrunchCode")
    private TextBoxCode txtKinyuKikanBrunchCode;
    @JsonProperty("txtKinyuKikanBrunchName")
    private TextBox txtKinyuKikanBrunchName;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtKozaMeiginin")
    private TextBox txtKozaMeiginin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKinyuKikanCode")
    public TextBoxCode getTxtKinyuKikanCode() {
        return txtKinyuKikanCode;
    }

    @JsonProperty("txtKinyuKikanCode")
    public void setTxtKinyuKikanCode(TextBoxCode txtKinyuKikanCode) {
        this.txtKinyuKikanCode=txtKinyuKikanCode;
    }

    @JsonProperty("txtKinyuKikanName")
    public TextBox getTxtKinyuKikanName() {
        return txtKinyuKikanName;
    }

    @JsonProperty("txtKinyuKikanName")
    public void setTxtKinyuKikanName(TextBox txtKinyuKikanName) {
        this.txtKinyuKikanName=txtKinyuKikanName;
    }

    @JsonProperty("radKozaShubetsu")
    public RadioButton getRadKozaShubetsu() {
        return radKozaShubetsu;
    }

    @JsonProperty("radKozaShubetsu")
    public void setRadKozaShubetsu(RadioButton radKozaShubetsu) {
        this.radKozaShubetsu=radKozaShubetsu;
    }

    @JsonProperty("txtKozaMeigininKana")
    public TextBox getTxtKozaMeigininKana() {
        return txtKozaMeigininKana;
    }

    @JsonProperty("txtKozaMeigininKana")
    public void setTxtKozaMeigininKana(TextBox txtKozaMeigininKana) {
        this.txtKozaMeigininKana=txtKozaMeigininKana;
    }

    @JsonProperty("txtKinyuKikanBrunchCode")
    public TextBoxCode getTxtKinyuKikanBrunchCode() {
        return txtKinyuKikanBrunchCode;
    }

    @JsonProperty("txtKinyuKikanBrunchCode")
    public void setTxtKinyuKikanBrunchCode(TextBoxCode txtKinyuKikanBrunchCode) {
        this.txtKinyuKikanBrunchCode=txtKinyuKikanBrunchCode;
    }

    @JsonProperty("txtKinyuKikanBrunchName")
    public TextBox getTxtKinyuKikanBrunchName() {
        return txtKinyuKikanBrunchName;
    }

    @JsonProperty("txtKinyuKikanBrunchName")
    public void setTxtKinyuKikanBrunchName(TextBox txtKinyuKikanBrunchName) {
        this.txtKinyuKikanBrunchName=txtKinyuKikanBrunchName;
    }

    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo=txtKozaNo;
    }

    @JsonProperty("txtKozaMeiginin")
    public TextBox getTxtKozaMeiginin() {
        return txtKozaMeiginin;
    }

    @JsonProperty("txtKozaMeiginin")
    public void setTxtKozaMeiginin(TextBox txtKozaMeiginin) {
        this.txtKozaMeiginin=txtKozaMeiginin;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
