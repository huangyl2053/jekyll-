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
 * ShokanShikyuTorokuShomeishoRyoyoKinkyuji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRyoyohiKinkyuName1")
    private TextBox txtRyoyohiKinkyuName1;
    @JsonProperty("txtRyoyohiChiryoKaishiYMD1")
    private TextBoxDate txtRyoyohiChiryoKaishiYMD1;
    @JsonProperty("txtRyoyohiKinkyuName2")
    private TextBox txtRyoyohiKinkyuName2;
    @JsonProperty("txtRyoyohiChiryoKaishiYMD2")
    private TextBoxDate txtRyoyohiChiryoKaishiYMD2;
    @JsonProperty("txtRyoyohiKinkyuName3")
    private TextBox txtRyoyohiKinkyuName3;
    @JsonProperty("txtRyoyohiChiryoKaishiYMD3")
    private TextBoxDate txtRyoyohiChiryoKaishiYMD3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtRyoyohiKinkyuName1")
    public TextBox getTxtRyoyohiKinkyuName1() {
        return txtRyoyohiKinkyuName1;
    }

    @JsonProperty("txtRyoyohiKinkyuName1")
    public void setTxtRyoyohiKinkyuName1(TextBox txtRyoyohiKinkyuName1) {
        this.txtRyoyohiKinkyuName1=txtRyoyohiKinkyuName1;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD1")
    public TextBoxDate getTxtRyoyohiChiryoKaishiYMD1() {
        return txtRyoyohiChiryoKaishiYMD1;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD1")
    public void setTxtRyoyohiChiryoKaishiYMD1(TextBoxDate txtRyoyohiChiryoKaishiYMD1) {
        this.txtRyoyohiChiryoKaishiYMD1=txtRyoyohiChiryoKaishiYMD1;
    }

    @JsonProperty("txtRyoyohiKinkyuName2")
    public TextBox getTxtRyoyohiKinkyuName2() {
        return txtRyoyohiKinkyuName2;
    }

    @JsonProperty("txtRyoyohiKinkyuName2")
    public void setTxtRyoyohiKinkyuName2(TextBox txtRyoyohiKinkyuName2) {
        this.txtRyoyohiKinkyuName2=txtRyoyohiKinkyuName2;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD2")
    public TextBoxDate getTxtRyoyohiChiryoKaishiYMD2() {
        return txtRyoyohiChiryoKaishiYMD2;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD2")
    public void setTxtRyoyohiChiryoKaishiYMD2(TextBoxDate txtRyoyohiChiryoKaishiYMD2) {
        this.txtRyoyohiChiryoKaishiYMD2=txtRyoyohiChiryoKaishiYMD2;
    }

    @JsonProperty("txtRyoyohiKinkyuName3")
    public TextBox getTxtRyoyohiKinkyuName3() {
        return txtRyoyohiKinkyuName3;
    }

    @JsonProperty("txtRyoyohiKinkyuName3")
    public void setTxtRyoyohiKinkyuName3(TextBox txtRyoyohiKinkyuName3) {
        this.txtRyoyohiKinkyuName3=txtRyoyohiKinkyuName3;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD3")
    public TextBoxDate getTxtRyoyohiChiryoKaishiYMD3() {
        return txtRyoyohiChiryoKaishiYMD3;
    }

    @JsonProperty("txtRyoyohiChiryoKaishiYMD3")
    public void setTxtRyoyohiChiryoKaishiYMD3(TextBoxDate txtRyoyohiChiryoKaishiYMD3) {
        this.txtRyoyohiChiryoKaishiYMD3=txtRyoyohiChiryoKaishiYMD3;
    }

}
