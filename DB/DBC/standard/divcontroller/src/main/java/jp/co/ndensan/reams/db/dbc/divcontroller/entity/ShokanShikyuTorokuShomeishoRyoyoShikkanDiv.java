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
 * ShokanShikyuTorokuShomeishoRyoyoShikkan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoRyoyoShikkanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRyoyohiShikkanName1")
    private TextBox txtRyoyohiShikkanName1;
    @JsonProperty("txtRyoyohiRyoyoKaishiYMD1")
    private TextBoxDate txtRyoyohiRyoyoKaishiYMD1;
    @JsonProperty("txtRyoyohiShikkanName2")
    private TextBox txtRyoyohiShikkanName2;
    @JsonProperty("txtRyoyohiRyoyoKaishiYMD2")
    private TextBoxDate txtRyoyohiRyoyoKaishiYMD2;
    @JsonProperty("txtRyoyohiShikkanName3")
    private TextBox txtRyoyohiShikkanName3;
    @JsonProperty("txtRyoyohiRyoyoKaishiYMD3")
    private TextBoxDate txtRyoyohiRyoyoKaishiYMD3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtRyoyohiShikkanName1")
    public TextBox getTxtRyoyohiShikkanName1() {
        return txtRyoyohiShikkanName1;
    }

    @JsonProperty("txtRyoyohiShikkanName1")
    public void setTxtRyoyohiShikkanName1(TextBox txtRyoyohiShikkanName1) {
        this.txtRyoyohiShikkanName1=txtRyoyohiShikkanName1;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD1")
    public TextBoxDate getTxtRyoyohiRyoyoKaishiYMD1() {
        return txtRyoyohiRyoyoKaishiYMD1;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD1")
    public void setTxtRyoyohiRyoyoKaishiYMD1(TextBoxDate txtRyoyohiRyoyoKaishiYMD1) {
        this.txtRyoyohiRyoyoKaishiYMD1=txtRyoyohiRyoyoKaishiYMD1;
    }

    @JsonProperty("txtRyoyohiShikkanName2")
    public TextBox getTxtRyoyohiShikkanName2() {
        return txtRyoyohiShikkanName2;
    }

    @JsonProperty("txtRyoyohiShikkanName2")
    public void setTxtRyoyohiShikkanName2(TextBox txtRyoyohiShikkanName2) {
        this.txtRyoyohiShikkanName2=txtRyoyohiShikkanName2;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD2")
    public TextBoxDate getTxtRyoyohiRyoyoKaishiYMD2() {
        return txtRyoyohiRyoyoKaishiYMD2;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD2")
    public void setTxtRyoyohiRyoyoKaishiYMD2(TextBoxDate txtRyoyohiRyoyoKaishiYMD2) {
        this.txtRyoyohiRyoyoKaishiYMD2=txtRyoyohiRyoyoKaishiYMD2;
    }

    @JsonProperty("txtRyoyohiShikkanName3")
    public TextBox getTxtRyoyohiShikkanName3() {
        return txtRyoyohiShikkanName3;
    }

    @JsonProperty("txtRyoyohiShikkanName3")
    public void setTxtRyoyohiShikkanName3(TextBox txtRyoyohiShikkanName3) {
        this.txtRyoyohiShikkanName3=txtRyoyohiShikkanName3;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD3")
    public TextBoxDate getTxtRyoyohiRyoyoKaishiYMD3() {
        return txtRyoyohiRyoyoKaishiYMD3;
    }

    @JsonProperty("txtRyoyohiRyoyoKaishiYMD3")
    public void setTxtRyoyohiRyoyoKaishiYMD3(TextBoxDate txtRyoyohiRyoyoKaishiYMD3) {
        this.txtRyoyohiRyoyoKaishiYMD3=txtRyoyohiRyoyoKaishiYMD3;
    }

}
