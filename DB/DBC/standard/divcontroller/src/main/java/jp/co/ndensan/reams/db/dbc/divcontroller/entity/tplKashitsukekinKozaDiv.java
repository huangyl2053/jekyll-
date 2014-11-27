package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKashitsukekinKoza のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKashitsukekinKozaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKojinKinyuKikanCode")
    private TextBoxCode txtKojinKinyuKikanCode;
    @JsonProperty("txtKojinKinyuKikanName")
    private TextBox txtKojinKinyuKikanName;
    @JsonProperty("txtKojinKozaShubetsu")
    private TextBox txtKojinKozaShubetsu;
    @JsonProperty("txtKojinMeigininName")
    private TextBoxKana txtKojinMeigininName;
    @JsonProperty("txtKojinShitenCode")
    private TextBoxCode txtKojinShitenCode;
    @JsonProperty("txtKojinShitenName")
    private TextBox txtKojinShitenName;
    @JsonProperty("txtKojinKozaNo")
    private TextBoxCode txtKojinKozaNo;
    @JsonProperty("txtKojinMeigininKana")
    private TextBoxKana txtKojinMeigininKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKojinKinyuKikanCode")
    public TextBoxCode getTxtKojinKinyuKikanCode() {
        return txtKojinKinyuKikanCode;
    }

    @JsonProperty("txtKojinKinyuKikanCode")
    public void setTxtKojinKinyuKikanCode(TextBoxCode txtKojinKinyuKikanCode) {
        this.txtKojinKinyuKikanCode=txtKojinKinyuKikanCode;
    }

    @JsonProperty("txtKojinKinyuKikanName")
    public TextBox getTxtKojinKinyuKikanName() {
        return txtKojinKinyuKikanName;
    }

    @JsonProperty("txtKojinKinyuKikanName")
    public void setTxtKojinKinyuKikanName(TextBox txtKojinKinyuKikanName) {
        this.txtKojinKinyuKikanName=txtKojinKinyuKikanName;
    }

    @JsonProperty("txtKojinKozaShubetsu")
    public TextBox getTxtKojinKozaShubetsu() {
        return txtKojinKozaShubetsu;
    }

    @JsonProperty("txtKojinKozaShubetsu")
    public void setTxtKojinKozaShubetsu(TextBox txtKojinKozaShubetsu) {
        this.txtKojinKozaShubetsu=txtKojinKozaShubetsu;
    }

    @JsonProperty("txtKojinMeigininName")
    public TextBoxKana getTxtKojinMeigininName() {
        return txtKojinMeigininName;
    }

    @JsonProperty("txtKojinMeigininName")
    public void setTxtKojinMeigininName(TextBoxKana txtKojinMeigininName) {
        this.txtKojinMeigininName=txtKojinMeigininName;
    }

    @JsonProperty("txtKojinShitenCode")
    public TextBoxCode getTxtKojinShitenCode() {
        return txtKojinShitenCode;
    }

    @JsonProperty("txtKojinShitenCode")
    public void setTxtKojinShitenCode(TextBoxCode txtKojinShitenCode) {
        this.txtKojinShitenCode=txtKojinShitenCode;
    }

    @JsonProperty("txtKojinShitenName")
    public TextBox getTxtKojinShitenName() {
        return txtKojinShitenName;
    }

    @JsonProperty("txtKojinShitenName")
    public void setTxtKojinShitenName(TextBox txtKojinShitenName) {
        this.txtKojinShitenName=txtKojinShitenName;
    }

    @JsonProperty("txtKojinKozaNo")
    public TextBoxCode getTxtKojinKozaNo() {
        return txtKojinKozaNo;
    }

    @JsonProperty("txtKojinKozaNo")
    public void setTxtKojinKozaNo(TextBoxCode txtKojinKozaNo) {
        this.txtKojinKozaNo=txtKojinKozaNo;
    }

    @JsonProperty("txtKojinMeigininKana")
    public TextBoxKana getTxtKojinMeigininKana() {
        return txtKojinMeigininKana;
    }

    @JsonProperty("txtKojinMeigininKana")
    public void setTxtKojinMeigininKana(TextBoxKana txtKojinMeigininKana) {
        this.txtKojinMeigininKana=txtKojinMeigininKana;
    }

}
