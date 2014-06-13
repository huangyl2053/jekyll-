package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
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
 * JutakuKaishuDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKaishuContents")
    private TextBoxMultiLine txtKaishuContents;
    @JsonProperty("txtKaishuJigyoshaName")
    private TextBox txtKaishuJigyoshaName;
    @JsonProperty("txtKaishuTaishoAddress1")
    private TextBoxMultiLine txtKaishuTaishoAddress1;
    @JsonProperty("txtChakkoDueDate")
    private TextBoxDate txtChakkoDueDate;
    @JsonProperty("txtKanseiDueDate")
    private TextBoxDate txtKanseiDueDate;
    @JsonProperty("txtEstimatedAmount")
    private TextBoxNum txtEstimatedAmount;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKaishuContents")
    public TextBoxMultiLine getTxtKaishuContents() {
        return txtKaishuContents;
    }

    @JsonProperty("txtKaishuContents")
    public void setTxtKaishuContents(TextBoxMultiLine txtKaishuContents) {
        this.txtKaishuContents=txtKaishuContents;
    }

    @JsonProperty("txtKaishuJigyoshaName")
    public TextBox getTxtKaishuJigyoshaName() {
        return txtKaishuJigyoshaName;
    }

    @JsonProperty("txtKaishuJigyoshaName")
    public void setTxtKaishuJigyoshaName(TextBox txtKaishuJigyoshaName) {
        this.txtKaishuJigyoshaName=txtKaishuJigyoshaName;
    }

    @JsonProperty("txtKaishuTaishoAddress1")
    public TextBoxMultiLine getTxtKaishuTaishoAddress1() {
        return txtKaishuTaishoAddress1;
    }

    @JsonProperty("txtKaishuTaishoAddress1")
    public void setTxtKaishuTaishoAddress1(TextBoxMultiLine txtKaishuTaishoAddress1) {
        this.txtKaishuTaishoAddress1=txtKaishuTaishoAddress1;
    }

    @JsonProperty("txtChakkoDueDate")
    public TextBoxDate getTxtChakkoDueDate() {
        return txtChakkoDueDate;
    }

    @JsonProperty("txtChakkoDueDate")
    public void setTxtChakkoDueDate(TextBoxDate txtChakkoDueDate) {
        this.txtChakkoDueDate=txtChakkoDueDate;
    }

    @JsonProperty("txtKanseiDueDate")
    public TextBoxDate getTxtKanseiDueDate() {
        return txtKanseiDueDate;
    }

    @JsonProperty("txtKanseiDueDate")
    public void setTxtKanseiDueDate(TextBoxDate txtKanseiDueDate) {
        this.txtKanseiDueDate=txtKanseiDueDate;
    }

    @JsonProperty("txtEstimatedAmount")
    public TextBoxNum getTxtEstimatedAmount() {
        return txtEstimatedAmount;
    }

    @JsonProperty("txtEstimatedAmount")
    public void setTxtEstimatedAmount(TextBoxNum txtEstimatedAmount) {
        this.txtEstimatedAmount=txtEstimatedAmount;
    }

}
