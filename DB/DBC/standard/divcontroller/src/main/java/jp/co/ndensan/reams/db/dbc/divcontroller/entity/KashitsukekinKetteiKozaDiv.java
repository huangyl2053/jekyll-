package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * KashitsukekinKetteiKoza のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukekinKetteiKozaDiv extends Panel {
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
    @JsonProperty("txtKozaShubetsu")
    private TextBox txtKozaShubetsu;
    @JsonProperty("txtMeigininName")
    private TextBoxKana txtMeigininName;
    @JsonProperty("txtShitenCode")
    private TextBoxCode txtShitenCode;
    @JsonProperty("txtShitenName")
    private TextBox txtShitenName;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtMeigininKana")
    private TextBoxKana txtMeigininKana;

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

    @JsonProperty("txtKozaShubetsu")
    public TextBox getTxtKozaShubetsu() {
        return txtKozaShubetsu;
    }

    @JsonProperty("txtKozaShubetsu")
    public void setTxtKozaShubetsu(TextBox txtKozaShubetsu) {
        this.txtKozaShubetsu=txtKozaShubetsu;
    }

    @JsonProperty("txtMeigininName")
    public TextBoxKana getTxtMeigininName() {
        return txtMeigininName;
    }

    @JsonProperty("txtMeigininName")
    public void setTxtMeigininName(TextBoxKana txtMeigininName) {
        this.txtMeigininName=txtMeigininName;
    }

    @JsonProperty("txtShitenCode")
    public TextBoxCode getTxtShitenCode() {
        return txtShitenCode;
    }

    @JsonProperty("txtShitenCode")
    public void setTxtShitenCode(TextBoxCode txtShitenCode) {
        this.txtShitenCode=txtShitenCode;
    }

    @JsonProperty("txtShitenName")
    public TextBox getTxtShitenName() {
        return txtShitenName;
    }

    @JsonProperty("txtShitenName")
    public void setTxtShitenName(TextBox txtShitenName) {
        this.txtShitenName=txtShitenName;
    }

    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo=txtKozaNo;
    }

    @JsonProperty("txtMeigininKana")
    public TextBoxKana getTxtMeigininKana() {
        return txtMeigininKana;
    }

    @JsonProperty("txtMeigininKana")
    public void setTxtMeigininKana(TextBoxKana txtMeigininKana) {
        this.txtMeigininKana=txtMeigininKana;
    }

}
