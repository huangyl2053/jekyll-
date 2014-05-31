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
 * ShokanShikyuTorokuShomeishoNyushoMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoNyushoMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushohiShuruiCode")
    private TextBoxCode txtNyushohiShuruiCode;
    @JsonProperty("txtNyushohiServiceCode")
    private TextBoxCode txtNyushohiServiceCode;
    @JsonProperty("btnNyushohiService")
    private Button btnNyushohiService;
    @JsonProperty("txtNyushohiServiceName")
    private TextBox txtNyushohiServiceName;
    @JsonProperty("txtNyushohiHiyoTanka")
    private TextBoxNum txtNyushohiHiyoTanka;
    @JsonProperty("txtNyushohiFutanGendogaku")
    private TextBoxNum txtNyushohiFutanGendogaku;
    @JsonProperty("txtNyushohiNissu")
    private TextBoxNum txtNyushohiNissu;
    @JsonProperty("txtNyushohiHiyogaku")
    private TextBoxNum txtNyushohiHiyogaku;
    @JsonProperty("txtNyushohiHokengaku")
    private TextBoxNum txtNyushohiHokengaku;
    @JsonProperty("txtNyushohiFutangaku")
    private TextBoxNum txtNyushohiFutangaku;
    @JsonProperty("btnNyushohiKakutei")
    private Button btnNyushohiKakutei;
    @JsonProperty("txtNyushoSelectedIndex")
    private TextBox txtNyushoSelectedIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNyushohiShuruiCode")
    public TextBoxCode getTxtNyushohiShuruiCode() {
        return txtNyushohiShuruiCode;
    }

    @JsonProperty("txtNyushohiShuruiCode")
    public void setTxtNyushohiShuruiCode(TextBoxCode txtNyushohiShuruiCode) {
        this.txtNyushohiShuruiCode=txtNyushohiShuruiCode;
    }

    @JsonProperty("txtNyushohiServiceCode")
    public TextBoxCode getTxtNyushohiServiceCode() {
        return txtNyushohiServiceCode;
    }

    @JsonProperty("txtNyushohiServiceCode")
    public void setTxtNyushohiServiceCode(TextBoxCode txtNyushohiServiceCode) {
        this.txtNyushohiServiceCode=txtNyushohiServiceCode;
    }

    @JsonProperty("btnNyushohiService")
    public Button getBtnNyushohiService() {
        return btnNyushohiService;
    }

    @JsonProperty("btnNyushohiService")
    public void setBtnNyushohiService(Button btnNyushohiService) {
        this.btnNyushohiService=btnNyushohiService;
    }

    @JsonProperty("txtNyushohiServiceName")
    public TextBox getTxtNyushohiServiceName() {
        return txtNyushohiServiceName;
    }

    @JsonProperty("txtNyushohiServiceName")
    public void setTxtNyushohiServiceName(TextBox txtNyushohiServiceName) {
        this.txtNyushohiServiceName=txtNyushohiServiceName;
    }

    @JsonProperty("txtNyushohiHiyoTanka")
    public TextBoxNum getTxtNyushohiHiyoTanka() {
        return txtNyushohiHiyoTanka;
    }

    @JsonProperty("txtNyushohiHiyoTanka")
    public void setTxtNyushohiHiyoTanka(TextBoxNum txtNyushohiHiyoTanka) {
        this.txtNyushohiHiyoTanka=txtNyushohiHiyoTanka;
    }

    @JsonProperty("txtNyushohiFutanGendogaku")
    public TextBoxNum getTxtNyushohiFutanGendogaku() {
        return txtNyushohiFutanGendogaku;
    }

    @JsonProperty("txtNyushohiFutanGendogaku")
    public void setTxtNyushohiFutanGendogaku(TextBoxNum txtNyushohiFutanGendogaku) {
        this.txtNyushohiFutanGendogaku=txtNyushohiFutanGendogaku;
    }

    @JsonProperty("txtNyushohiNissu")
    public TextBoxNum getTxtNyushohiNissu() {
        return txtNyushohiNissu;
    }

    @JsonProperty("txtNyushohiNissu")
    public void setTxtNyushohiNissu(TextBoxNum txtNyushohiNissu) {
        this.txtNyushohiNissu=txtNyushohiNissu;
    }

    @JsonProperty("txtNyushohiHiyogaku")
    public TextBoxNum getTxtNyushohiHiyogaku() {
        return txtNyushohiHiyogaku;
    }

    @JsonProperty("txtNyushohiHiyogaku")
    public void setTxtNyushohiHiyogaku(TextBoxNum txtNyushohiHiyogaku) {
        this.txtNyushohiHiyogaku=txtNyushohiHiyogaku;
    }

    @JsonProperty("txtNyushohiHokengaku")
    public TextBoxNum getTxtNyushohiHokengaku() {
        return txtNyushohiHokengaku;
    }

    @JsonProperty("txtNyushohiHokengaku")
    public void setTxtNyushohiHokengaku(TextBoxNum txtNyushohiHokengaku) {
        this.txtNyushohiHokengaku=txtNyushohiHokengaku;
    }

    @JsonProperty("txtNyushohiFutangaku")
    public TextBoxNum getTxtNyushohiFutangaku() {
        return txtNyushohiFutangaku;
    }

    @JsonProperty("txtNyushohiFutangaku")
    public void setTxtNyushohiFutangaku(TextBoxNum txtNyushohiFutangaku) {
        this.txtNyushohiFutangaku=txtNyushohiFutangaku;
    }

    @JsonProperty("btnNyushohiKakutei")
    public Button getBtnNyushohiKakutei() {
        return btnNyushohiKakutei;
    }

    @JsonProperty("btnNyushohiKakutei")
    public void setBtnNyushohiKakutei(Button btnNyushohiKakutei) {
        this.btnNyushohiKakutei=btnNyushohiKakutei;
    }

    @JsonProperty("txtNyushoSelectedIndex")
    public TextBox getTxtNyushoSelectedIndex() {
        return txtNyushoSelectedIndex;
    }

    @JsonProperty("txtNyushoSelectedIndex")
    public void setTxtNyushoSelectedIndex(TextBox txtNyushoSelectedIndex) {
        this.txtNyushoSelectedIndex=txtNyushoSelectedIndex;
    }

}
