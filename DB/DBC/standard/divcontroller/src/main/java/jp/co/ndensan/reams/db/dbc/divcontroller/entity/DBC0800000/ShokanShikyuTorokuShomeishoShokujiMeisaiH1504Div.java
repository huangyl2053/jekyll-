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
 * ShokanShikyuTorokuShomeishoShokujiMeisaiH1504 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShokujiMeisaiH1504Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShokujihiShuruiCode")
    private TextBoxCode txtShokujihiShuruiCode;
    @JsonProperty("txtShokujihiServiceCode")
    private TextBoxCode txtShokujihiServiceCode;
    @JsonProperty("btnShokujihiService")
    private Button btnShokujihiService;
    @JsonProperty("txtShokujihiServiceName")
    private TextBox txtShokujihiServiceName;
    @JsonProperty("txtShokujihiTanisu")
    private TextBoxNum txtShokujihiTanisu;
    @JsonProperty("txtShokujihiNissuKaisu")
    private TextBoxNum txtShokujihiNissuKaisu;
    @JsonProperty("txtShokujihiKingaku")
    private TextBoxNum txtShokujihiKingaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShokujihiShuruiCode")
    public TextBoxCode getTxtShokujihiShuruiCode() {
        return txtShokujihiShuruiCode;
    }

    @JsonProperty("txtShokujihiShuruiCode")
    public void setTxtShokujihiShuruiCode(TextBoxCode txtShokujihiShuruiCode) {
        this.txtShokujihiShuruiCode=txtShokujihiShuruiCode;
    }

    @JsonProperty("txtShokujihiServiceCode")
    public TextBoxCode getTxtShokujihiServiceCode() {
        return txtShokujihiServiceCode;
    }

    @JsonProperty("txtShokujihiServiceCode")
    public void setTxtShokujihiServiceCode(TextBoxCode txtShokujihiServiceCode) {
        this.txtShokujihiServiceCode=txtShokujihiServiceCode;
    }

    @JsonProperty("btnShokujihiService")
    public Button getBtnShokujihiService() {
        return btnShokujihiService;
    }

    @JsonProperty("btnShokujihiService")
    public void setBtnShokujihiService(Button btnShokujihiService) {
        this.btnShokujihiService=btnShokujihiService;
    }

    @JsonProperty("txtShokujihiServiceName")
    public TextBox getTxtShokujihiServiceName() {
        return txtShokujihiServiceName;
    }

    @JsonProperty("txtShokujihiServiceName")
    public void setTxtShokujihiServiceName(TextBox txtShokujihiServiceName) {
        this.txtShokujihiServiceName=txtShokujihiServiceName;
    }

    @JsonProperty("txtShokujihiTanisu")
    public TextBoxNum getTxtShokujihiTanisu() {
        return txtShokujihiTanisu;
    }

    @JsonProperty("txtShokujihiTanisu")
    public void setTxtShokujihiTanisu(TextBoxNum txtShokujihiTanisu) {
        this.txtShokujihiTanisu=txtShokujihiTanisu;
    }

    @JsonProperty("txtShokujihiNissuKaisu")
    public TextBoxNum getTxtShokujihiNissuKaisu() {
        return txtShokujihiNissuKaisu;
    }

    @JsonProperty("txtShokujihiNissuKaisu")
    public void setTxtShokujihiNissuKaisu(TextBoxNum txtShokujihiNissuKaisu) {
        this.txtShokujihiNissuKaisu=txtShokujihiNissuKaisu;
    }

    @JsonProperty("txtShokujihiKingaku")
    public TextBoxNum getTxtShokujihiKingaku() {
        return txtShokujihiKingaku;
    }

    @JsonProperty("txtShokujihiKingaku")
    public void setTxtShokujihiKingaku(TextBoxNum txtShokujihiKingaku) {
        this.txtShokujihiKingaku=txtShokujihiKingaku;
    }

}
