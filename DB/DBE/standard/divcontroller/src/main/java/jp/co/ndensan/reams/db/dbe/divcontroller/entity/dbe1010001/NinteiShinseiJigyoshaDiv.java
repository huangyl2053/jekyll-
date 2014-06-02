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
    @JsonProperty("lblJigyosha")
    private Label lblJigyosha;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("imgToSearchJigyosha")
    private StaticImage imgToSearchJigyosha;
    @JsonProperty("lblJigyoshaKubun")
    private Label lblJigyoshaKubun;
    @JsonProperty("txtJigyoshaCode")
    private TextBoxCode txtJigyoshaCode;
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblJigyosha")
    public Label getLblJigyosha() {
        return lblJigyosha;
    }

    @JsonProperty("lblJigyosha")
    public void setLblJigyosha(Label lblJigyosha) {
        this.lblJigyosha=lblJigyosha;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("imgToSearchJigyosha")
    public StaticImage getImgToSearchJigyosha() {
        return imgToSearchJigyosha;
    }

    @JsonProperty("imgToSearchJigyosha")
    public void setImgToSearchJigyosha(StaticImage imgToSearchJigyosha) {
        this.imgToSearchJigyosha=imgToSearchJigyosha;
    }

    @JsonProperty("lblJigyoshaKubun")
    public Label getLblJigyoshaKubun() {
        return lblJigyoshaKubun;
    }

    @JsonProperty("lblJigyoshaKubun")
    public void setLblJigyoshaKubun(Label lblJigyoshaKubun) {
        this.lblJigyoshaKubun=lblJigyoshaKubun;
    }

    @JsonProperty("txtJigyoshaCode")
    public TextBoxCode getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBoxCode txtJigyoshaCode) {
        this.txtJigyoshaCode=txtJigyoshaCode;
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
