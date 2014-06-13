package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
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
 * ShokanShikyuTorokuShomeishoMeisaiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKyufuhiShuruiCode")
    private TextBoxCode txtKyufuhiShuruiCode;
    @JsonProperty("txtKyufuhiServiceCode")
    private TextBoxCode txtKyufuhiServiceCode;
    @JsonProperty("btnKyufuhiService")
    private Button btnKyufuhiService;
    @JsonProperty("txtKyufuhiServiceName")
    private TextBox txtKyufuhiServiceName;
    @JsonProperty("txtKyufuhiTanisu")
    private TextBoxNum txtKyufuhiTanisu;
    @JsonProperty("txtKyufuhiKaisuNissu")
    private TextBoxNum txtKyufuhiKaisuNissu;
    @JsonProperty("txtKyufuhiServiceTanisu")
    private TextBoxNum txtKyufuhiServiceTanisu;
    @JsonProperty("txtKyufuhiTekiyo")
    private TextBox txtKyufuhiTekiyo;
    @JsonProperty("btnKyufuhiKakutei")
    private Button btnKyufuhiKakutei;
    @JsonProperty("txtKyufuhiSelectedIndex")
    private TextBox txtKyufuhiSelectedIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKyufuhiShuruiCode")
    public TextBoxCode getTxtKyufuhiShuruiCode() {
        return txtKyufuhiShuruiCode;
    }

    @JsonProperty("txtKyufuhiShuruiCode")
    public void setTxtKyufuhiShuruiCode(TextBoxCode txtKyufuhiShuruiCode) {
        this.txtKyufuhiShuruiCode=txtKyufuhiShuruiCode;
    }

    @JsonProperty("txtKyufuhiServiceCode")
    public TextBoxCode getTxtKyufuhiServiceCode() {
        return txtKyufuhiServiceCode;
    }

    @JsonProperty("txtKyufuhiServiceCode")
    public void setTxtKyufuhiServiceCode(TextBoxCode txtKyufuhiServiceCode) {
        this.txtKyufuhiServiceCode=txtKyufuhiServiceCode;
    }

    @JsonProperty("btnKyufuhiService")
    public Button getBtnKyufuhiService() {
        return btnKyufuhiService;
    }

    @JsonProperty("btnKyufuhiService")
    public void setBtnKyufuhiService(Button btnKyufuhiService) {
        this.btnKyufuhiService=btnKyufuhiService;
    }

    @JsonProperty("txtKyufuhiServiceName")
    public TextBox getTxtKyufuhiServiceName() {
        return txtKyufuhiServiceName;
    }

    @JsonProperty("txtKyufuhiServiceName")
    public void setTxtKyufuhiServiceName(TextBox txtKyufuhiServiceName) {
        this.txtKyufuhiServiceName=txtKyufuhiServiceName;
    }

    @JsonProperty("txtKyufuhiTanisu")
    public TextBoxNum getTxtKyufuhiTanisu() {
        return txtKyufuhiTanisu;
    }

    @JsonProperty("txtKyufuhiTanisu")
    public void setTxtKyufuhiTanisu(TextBoxNum txtKyufuhiTanisu) {
        this.txtKyufuhiTanisu=txtKyufuhiTanisu;
    }

    @JsonProperty("txtKyufuhiKaisuNissu")
    public TextBoxNum getTxtKyufuhiKaisuNissu() {
        return txtKyufuhiKaisuNissu;
    }

    @JsonProperty("txtKyufuhiKaisuNissu")
    public void setTxtKyufuhiKaisuNissu(TextBoxNum txtKyufuhiKaisuNissu) {
        this.txtKyufuhiKaisuNissu=txtKyufuhiKaisuNissu;
    }

    @JsonProperty("txtKyufuhiServiceTanisu")
    public TextBoxNum getTxtKyufuhiServiceTanisu() {
        return txtKyufuhiServiceTanisu;
    }

    @JsonProperty("txtKyufuhiServiceTanisu")
    public void setTxtKyufuhiServiceTanisu(TextBoxNum txtKyufuhiServiceTanisu) {
        this.txtKyufuhiServiceTanisu=txtKyufuhiServiceTanisu;
    }

    @JsonProperty("txtKyufuhiTekiyo")
    public TextBox getTxtKyufuhiTekiyo() {
        return txtKyufuhiTekiyo;
    }

    @JsonProperty("txtKyufuhiTekiyo")
    public void setTxtKyufuhiTekiyo(TextBox txtKyufuhiTekiyo) {
        this.txtKyufuhiTekiyo=txtKyufuhiTekiyo;
    }

    @JsonProperty("btnKyufuhiKakutei")
    public Button getBtnKyufuhiKakutei() {
        return btnKyufuhiKakutei;
    }

    @JsonProperty("btnKyufuhiKakutei")
    public void setBtnKyufuhiKakutei(Button btnKyufuhiKakutei) {
        this.btnKyufuhiKakutei=btnKyufuhiKakutei;
    }

    @JsonProperty("txtKyufuhiSelectedIndex")
    public TextBox getTxtKyufuhiSelectedIndex() {
        return txtKyufuhiSelectedIndex;
    }

    @JsonProperty("txtKyufuhiSelectedIndex")
    public void setTxtKyufuhiSelectedIndex(TextBox txtKyufuhiSelectedIndex) {
        this.txtKyufuhiSelectedIndex=txtKyufuhiSelectedIndex;
    }

}
