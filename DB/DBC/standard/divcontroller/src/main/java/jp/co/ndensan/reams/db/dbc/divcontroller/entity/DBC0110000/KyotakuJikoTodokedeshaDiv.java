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
    @JsonProperty("txtTodokedeshaName")
    private TextBox txtTodokedeshaName;
    @JsonProperty("ddlKankeiKubun")
    private DropDownList ddlKankeiKubun;
    @JsonProperty("txtTodokedeshaKana")
    private TextBoxKana txtTodokedeshaKana;
    @JsonProperty("txtTodokedeshaTelNo")
    private TextBox txtTodokedeshaTelNo;
    @JsonProperty("txtTodokedeshaYubinNo")
    private TextBoxYubinNo txtTodokedeshaYubinNo;
    @JsonProperty("txtTodokedeshaJusho")
    private TextBox txtTodokedeshaJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTodokedeshaName")
    public TextBox getTxtTodokedeshaName() {
        return txtTodokedeshaName;
    }

    @JsonProperty("txtTodokedeshaName")
    public void setTxtTodokedeshaName(TextBox txtTodokedeshaName) {
        this.txtTodokedeshaName=txtTodokedeshaName;
    }

    @JsonProperty("ddlKankeiKubun")
    public DropDownList getDdlKankeiKubun() {
        return ddlKankeiKubun;
    }

    @JsonProperty("ddlKankeiKubun")
    public void setDdlKankeiKubun(DropDownList ddlKankeiKubun) {
        this.ddlKankeiKubun=ddlKankeiKubun;
    }

    @JsonProperty("txtTodokedeshaKana")
    public TextBoxKana getTxtTodokedeshaKana() {
        return txtTodokedeshaKana;
    }

    @JsonProperty("txtTodokedeshaKana")
    public void setTxtTodokedeshaKana(TextBoxKana txtTodokedeshaKana) {
        this.txtTodokedeshaKana=txtTodokedeshaKana;
    }

    @JsonProperty("txtTodokedeshaTelNo")
    public TextBox getTxtTodokedeshaTelNo() {
        return txtTodokedeshaTelNo;
    }

    @JsonProperty("txtTodokedeshaTelNo")
    public void setTxtTodokedeshaTelNo(TextBox txtTodokedeshaTelNo) {
        this.txtTodokedeshaTelNo=txtTodokedeshaTelNo;
    }

    @JsonProperty("txtTodokedeshaYubinNo")
    public TextBoxYubinNo getTxtTodokedeshaYubinNo() {
        return txtTodokedeshaYubinNo;
    }

    @JsonProperty("txtTodokedeshaYubinNo")
    public void setTxtTodokedeshaYubinNo(TextBoxYubinNo txtTodokedeshaYubinNo) {
        this.txtTodokedeshaYubinNo=txtTodokedeshaYubinNo;
    }

    @JsonProperty("txtTodokedeshaJusho")
    public TextBox getTxtTodokedeshaJusho() {
        return txtTodokedeshaJusho;
    }

    @JsonProperty("txtTodokedeshaJusho")
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.txtTodokedeshaJusho=txtTodokedeshaJusho;
    }

}
