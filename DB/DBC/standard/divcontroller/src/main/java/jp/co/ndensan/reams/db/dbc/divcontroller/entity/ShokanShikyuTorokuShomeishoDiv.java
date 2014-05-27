package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabShokanShikyuTorokuShomeishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShomeishoTeikyoYM")
    private TextBoxDate txtShomeishoTeikyoYM;
    @JsonProperty("txtShomeishoJigyoshaCode")
    private TextBoxCode txtShomeishoJigyoshaCode;
    @JsonProperty("txtShomeishoJigyoshaName")
    private TextBox txtShomeishoJigyoshaName;
    @JsonProperty("txtShomeishoShinseiYMD")
    private TextBoxDate txtShomeishoShinseiYMD;
    @JsonProperty("txtShomeishoShomeisho")
    private TextBox txtShomeishoShomeisho;
    @JsonProperty("tabShokanShikyuTorokuShomeisho")
    private tabShokanShikyuTorokuShomeishoDiv tabShokanShikyuTorokuShomeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShomeishoTeikyoYM")
    public TextBoxDate getTxtShomeishoTeikyoYM() {
        return txtShomeishoTeikyoYM;
    }

    @JsonProperty("txtShomeishoTeikyoYM")
    public void setTxtShomeishoTeikyoYM(TextBoxDate txtShomeishoTeikyoYM) {
        this.txtShomeishoTeikyoYM=txtShomeishoTeikyoYM;
    }

    @JsonProperty("txtShomeishoJigyoshaCode")
    public TextBoxCode getTxtShomeishoJigyoshaCode() {
        return txtShomeishoJigyoshaCode;
    }

    @JsonProperty("txtShomeishoJigyoshaCode")
    public void setTxtShomeishoJigyoshaCode(TextBoxCode txtShomeishoJigyoshaCode) {
        this.txtShomeishoJigyoshaCode=txtShomeishoJigyoshaCode;
    }

    @JsonProperty("txtShomeishoJigyoshaName")
    public TextBox getTxtShomeishoJigyoshaName() {
        return txtShomeishoJigyoshaName;
    }

    @JsonProperty("txtShomeishoJigyoshaName")
    public void setTxtShomeishoJigyoshaName(TextBox txtShomeishoJigyoshaName) {
        this.txtShomeishoJigyoshaName=txtShomeishoJigyoshaName;
    }

    @JsonProperty("txtShomeishoShinseiYMD")
    public TextBoxDate getTxtShomeishoShinseiYMD() {
        return txtShomeishoShinseiYMD;
    }

    @JsonProperty("txtShomeishoShinseiYMD")
    public void setTxtShomeishoShinseiYMD(TextBoxDate txtShomeishoShinseiYMD) {
        this.txtShomeishoShinseiYMD=txtShomeishoShinseiYMD;
    }

    @JsonProperty("txtShomeishoShomeisho")
    public TextBox getTxtShomeishoShomeisho() {
        return txtShomeishoShomeisho;
    }

    @JsonProperty("txtShomeishoShomeisho")
    public void setTxtShomeishoShomeisho(TextBox txtShomeishoShomeisho) {
        this.txtShomeishoShomeisho=txtShomeishoShomeisho;
    }

    @JsonProperty("tabShokanShikyuTorokuShomeisho")
    public tabShokanShikyuTorokuShomeishoDiv getTabShokanShikyuTorokuShomeisho() {
        return tabShokanShikyuTorokuShomeisho;
    }

    @JsonProperty("tabShokanShikyuTorokuShomeisho")
    public void setTabShokanShikyuTorokuShomeisho(tabShokanShikyuTorokuShomeishoDiv tabShokanShikyuTorokuShomeisho) {
        this.tabShokanShikyuTorokuShomeisho=tabShokanShikyuTorokuShomeisho;
    }

}
