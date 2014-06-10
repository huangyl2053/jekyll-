package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000;
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
 * KashitsukeShinseisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseishaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseishaName")
    private TextBox txtShinseishaName;
    @JsonProperty("btnShinseishaCopy")
    private Button btnShinseishaCopy;
    @JsonProperty("txtShinseishaKana")
    private TextBoxKana txtShinseishaKana;
    @JsonProperty("txtShinseishaKankei")
    private TextBox txtShinseishaKankei;
    @JsonProperty("txtShinseishaYubinNo")
    private TextBoxYubinNo txtShinseishaYubinNo;
    @JsonProperty("txtShinseishaJusho")
    private TextBox txtShinseishaJusho;
    @JsonProperty("txtShinseishaTelNo")
    private TextBox txtShinseishaTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseishaName")
    public TextBox getTxtShinseishaName() {
        return txtShinseishaName;
    }

    @JsonProperty("txtShinseishaName")
    public void setTxtShinseishaName(TextBox txtShinseishaName) {
        this.txtShinseishaName=txtShinseishaName;
    }

    @JsonProperty("btnShinseishaCopy")
    public Button getBtnShinseishaCopy() {
        return btnShinseishaCopy;
    }

    @JsonProperty("btnShinseishaCopy")
    public void setBtnShinseishaCopy(Button btnShinseishaCopy) {
        this.btnShinseishaCopy=btnShinseishaCopy;
    }

    @JsonProperty("txtShinseishaKana")
    public TextBoxKana getTxtShinseishaKana() {
        return txtShinseishaKana;
    }

    @JsonProperty("txtShinseishaKana")
    public void setTxtShinseishaKana(TextBoxKana txtShinseishaKana) {
        this.txtShinseishaKana=txtShinseishaKana;
    }

    @JsonProperty("txtShinseishaKankei")
    public TextBox getTxtShinseishaKankei() {
        return txtShinseishaKankei;
    }

    @JsonProperty("txtShinseishaKankei")
    public void setTxtShinseishaKankei(TextBox txtShinseishaKankei) {
        this.txtShinseishaKankei=txtShinseishaKankei;
    }

    @JsonProperty("txtShinseishaYubinNo")
    public TextBoxYubinNo getTxtShinseishaYubinNo() {
        return txtShinseishaYubinNo;
    }

    @JsonProperty("txtShinseishaYubinNo")
    public void setTxtShinseishaYubinNo(TextBoxYubinNo txtShinseishaYubinNo) {
        this.txtShinseishaYubinNo=txtShinseishaYubinNo;
    }

    @JsonProperty("txtShinseishaJusho")
    public TextBox getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaJusho")
    public void setTxtShinseishaJusho(TextBox txtShinseishaJusho) {
        this.txtShinseishaJusho=txtShinseishaJusho;
    }

    @JsonProperty("txtShinseishaTelNo")
    public TextBox getTxtShinseishaTelNo() {
        return txtShinseishaTelNo;
    }

    @JsonProperty("txtShinseishaTelNo")
    public void setTxtShinseishaTelNo(TextBox txtShinseishaTelNo) {
        this.txtShinseishaTelNo=txtShinseishaTelNo;
    }

}
