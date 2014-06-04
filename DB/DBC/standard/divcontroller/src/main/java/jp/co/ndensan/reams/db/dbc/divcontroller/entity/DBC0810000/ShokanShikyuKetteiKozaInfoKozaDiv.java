package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
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
 * ShokanShikyuKetteiKozaInfoKoza のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiKozaInfoKozaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiKinyuKikanCode")
    private TextBoxCode txtShinseiKinyuKikanCode;
    @JsonProperty("txtShinseiShitenCode")
    private TextBoxCode txtShinseiShitenCode;
    @JsonProperty("txtShinseiKozaShubetsu")
    private TextBox txtShinseiKozaShubetsu;
    @JsonProperty("txtShinseiKozaNo")
    private TextBoxNum txtShinseiKozaNo;
    @JsonProperty("txtShinseiKinyuKikanName")
    private TextBox txtShinseiKinyuKikanName;
    @JsonProperty("txtShinseiMeigininName")
    private TextBox txtShinseiMeigininName;
    @JsonProperty("txtShinseiMeigininKana")
    private TextBoxKana txtShinseiMeigininKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiKinyuKikanCode")
    public TextBoxCode getTxtShinseiKinyuKikanCode() {
        return txtShinseiKinyuKikanCode;
    }

    @JsonProperty("txtShinseiKinyuKikanCode")
    public void setTxtShinseiKinyuKikanCode(TextBoxCode txtShinseiKinyuKikanCode) {
        this.txtShinseiKinyuKikanCode=txtShinseiKinyuKikanCode;
    }

    @JsonProperty("txtShinseiShitenCode")
    public TextBoxCode getTxtShinseiShitenCode() {
        return txtShinseiShitenCode;
    }

    @JsonProperty("txtShinseiShitenCode")
    public void setTxtShinseiShitenCode(TextBoxCode txtShinseiShitenCode) {
        this.txtShinseiShitenCode=txtShinseiShitenCode;
    }

    @JsonProperty("txtShinseiKozaShubetsu")
    public TextBox getTxtShinseiKozaShubetsu() {
        return txtShinseiKozaShubetsu;
    }

    @JsonProperty("txtShinseiKozaShubetsu")
    public void setTxtShinseiKozaShubetsu(TextBox txtShinseiKozaShubetsu) {
        this.txtShinseiKozaShubetsu=txtShinseiKozaShubetsu;
    }

    @JsonProperty("txtShinseiKozaNo")
    public TextBoxNum getTxtShinseiKozaNo() {
        return txtShinseiKozaNo;
    }

    @JsonProperty("txtShinseiKozaNo")
    public void setTxtShinseiKozaNo(TextBoxNum txtShinseiKozaNo) {
        this.txtShinseiKozaNo=txtShinseiKozaNo;
    }

    @JsonProperty("txtShinseiKinyuKikanName")
    public TextBox getTxtShinseiKinyuKikanName() {
        return txtShinseiKinyuKikanName;
    }

    @JsonProperty("txtShinseiKinyuKikanName")
    public void setTxtShinseiKinyuKikanName(TextBox txtShinseiKinyuKikanName) {
        this.txtShinseiKinyuKikanName=txtShinseiKinyuKikanName;
    }

    @JsonProperty("txtShinseiMeigininName")
    public TextBox getTxtShinseiMeigininName() {
        return txtShinseiMeigininName;
    }

    @JsonProperty("txtShinseiMeigininName")
    public void setTxtShinseiMeigininName(TextBox txtShinseiMeigininName) {
        this.txtShinseiMeigininName=txtShinseiMeigininName;
    }

    @JsonProperty("txtShinseiMeigininKana")
    public TextBoxKana getTxtShinseiMeigininKana() {
        return txtShinseiMeigininKana;
    }

    @JsonProperty("txtShinseiMeigininKana")
    public void setTxtShinseiMeigininKana(TextBoxKana txtShinseiMeigininKana) {
        this.txtShinseiMeigininKana=txtShinseiMeigininKana;
    }

}
