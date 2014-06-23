package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
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
 * NinteiShinseiJigyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiJigyoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaCode")
    private TextBoxCode txtJigyoshaCode;
    @JsonProperty("btnSearchJigyosha")
    private ButtonDialog btnSearchJigyosha;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJigyoshaCode")
    public TextBoxCode getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBoxCode txtJigyoshaCode) {
        this.txtJigyoshaCode=txtJigyoshaCode;
    }

    @JsonProperty("btnSearchJigyosha")
    public ButtonDialog getBtnSearchJigyosha() {
        return btnSearchJigyosha;
    }

    @JsonProperty("btnSearchJigyosha")
    public void setBtnSearchJigyosha(ButtonDialog btnSearchJigyosha) {
        this.btnSearchJigyosha=btnSearchJigyosha;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun=ddlJigyoshaKubun;
    }

}
