package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0110000;
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
 * KyotakuJikoTodokedesha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuJikoTodokedeshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("ddlKankeiKubun")
    private DropDownList ddlKankeiKubun;
    @JsonProperty("txtKana")
    private TextBoxKana txtKana;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName=txtName;
    }

    @JsonProperty("ddlKankeiKubun")
    public DropDownList getDdlKankeiKubun() {
        return ddlKankeiKubun;
    }

    @JsonProperty("ddlKankeiKubun")
    public void setDdlKankeiKubun(DropDownList ddlKankeiKubun) {
        this.ddlKankeiKubun=ddlKankeiKubun;
    }

    @JsonProperty("txtKana")
    public TextBoxKana getTxtKana() {
        return txtKana;
    }

    @JsonProperty("txtKana")
    public void setTxtKana(TextBoxKana txtKana) {
        this.txtKana=txtKana;
    }

    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

}
