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
 * JutakuKaishuJizenShinseiReason のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiReasonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCreateDate")
    private TextBoxDate txtCreateDate;
    @JsonProperty("txtCreationJigyoshaNo")
    private TextBoxCode txtCreationJigyoshaNo;
    @JsonProperty("btnSearchCreationJigyoshaName")
    private Button btnSearchCreationJigyoshaName;
    @JsonProperty("txtCreationJigyoshaName")
    private TextBox txtCreationJigyoshaName;
    @JsonProperty("txtCreatorKanaName")
    private TextBox txtCreatorKanaName;
    @JsonProperty("txtCreatorName")
    private TextBox txtCreatorName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCreateDate")
    public TextBoxDate getTxtCreateDate() {
        return txtCreateDate;
    }

    @JsonProperty("txtCreateDate")
    public void setTxtCreateDate(TextBoxDate txtCreateDate) {
        this.txtCreateDate=txtCreateDate;
    }

    @JsonProperty("txtCreationJigyoshaNo")
    public TextBoxCode getTxtCreationJigyoshaNo() {
        return txtCreationJigyoshaNo;
    }

    @JsonProperty("txtCreationJigyoshaNo")
    public void setTxtCreationJigyoshaNo(TextBoxCode txtCreationJigyoshaNo) {
        this.txtCreationJigyoshaNo=txtCreationJigyoshaNo;
    }

    @JsonProperty("btnSearchCreationJigyoshaName")
    public Button getBtnSearchCreationJigyoshaName() {
        return btnSearchCreationJigyoshaName;
    }

    @JsonProperty("btnSearchCreationJigyoshaName")
    public void setBtnSearchCreationJigyoshaName(Button btnSearchCreationJigyoshaName) {
        this.btnSearchCreationJigyoshaName=btnSearchCreationJigyoshaName;
    }

    @JsonProperty("txtCreationJigyoshaName")
    public TextBox getTxtCreationJigyoshaName() {
        return txtCreationJigyoshaName;
    }

    @JsonProperty("txtCreationJigyoshaName")
    public void setTxtCreationJigyoshaName(TextBox txtCreationJigyoshaName) {
        this.txtCreationJigyoshaName=txtCreationJigyoshaName;
    }

    @JsonProperty("txtCreatorKanaName")
    public TextBox getTxtCreatorKanaName() {
        return txtCreatorKanaName;
    }

    @JsonProperty("txtCreatorKanaName")
    public void setTxtCreatorKanaName(TextBox txtCreatorKanaName) {
        this.txtCreatorKanaName=txtCreatorKanaName;
    }

    @JsonProperty("txtCreatorName")
    public TextBox getTxtCreatorName() {
        return txtCreatorName;
    }

    @JsonProperty("txtCreatorName")
    public void setTxtCreatorName(TextBox txtCreatorName) {
        this.txtCreatorName=txtCreatorName;
    }

}
