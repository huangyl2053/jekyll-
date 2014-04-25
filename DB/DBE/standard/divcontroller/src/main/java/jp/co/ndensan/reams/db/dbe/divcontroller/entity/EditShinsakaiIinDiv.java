package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * EditShinsakaiIin のクラスファイル 
 * 
 * @author 自動生成
 */
public class EditShinsakaiIinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKankeiIinCode")
    private Label lblKankeiIinCode;
    @JsonProperty("txtKankeiIinCode")
    private TextBoxCode txtKankeiIinCode;
    @JsonProperty("imgToSearchShinsakaiIin")
    private StaticImage imgToSearchShinsakaiIin;
    @JsonProperty("lblKankeiIinName")
    private Label lblKankeiIinName;
    @JsonProperty("txtKankeiIinName")
    private TextBox txtKankeiIinName;
    @JsonProperty("lblShozokuKikan")
    private Label lblShozokuKikan;
    @JsonProperty("txtShozokuKikan")
    private TextBox txtShozokuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKankeiIinCode")
    public Label getLblKankeiIinCode() {
        return lblKankeiIinCode;
    }

    @JsonProperty("lblKankeiIinCode")
    public void setLblKankeiIinCode(Label lblKankeiIinCode) {
        this.lblKankeiIinCode=lblKankeiIinCode;
    }

    @JsonProperty("txtKankeiIinCode")
    public TextBoxCode getTxtKankeiIinCode() {
        return txtKankeiIinCode;
    }

    @JsonProperty("txtKankeiIinCode")
    public void setTxtKankeiIinCode(TextBoxCode txtKankeiIinCode) {
        this.txtKankeiIinCode=txtKankeiIinCode;
    }

    @JsonProperty("imgToSearchShinsakaiIin")
    public StaticImage getImgToSearchShinsakaiIin() {
        return imgToSearchShinsakaiIin;
    }

    @JsonProperty("imgToSearchShinsakaiIin")
    public void setImgToSearchShinsakaiIin(StaticImage imgToSearchShinsakaiIin) {
        this.imgToSearchShinsakaiIin=imgToSearchShinsakaiIin;
    }

    @JsonProperty("lblKankeiIinName")
    public Label getLblKankeiIinName() {
        return lblKankeiIinName;
    }

    @JsonProperty("lblKankeiIinName")
    public void setLblKankeiIinName(Label lblKankeiIinName) {
        this.lblKankeiIinName=lblKankeiIinName;
    }

    @JsonProperty("txtKankeiIinName")
    public TextBox getTxtKankeiIinName() {
        return txtKankeiIinName;
    }

    @JsonProperty("txtKankeiIinName")
    public void setTxtKankeiIinName(TextBox txtKankeiIinName) {
        this.txtKankeiIinName=txtKankeiIinName;
    }

    @JsonProperty("lblShozokuKikan")
    public Label getLblShozokuKikan() {
        return lblShozokuKikan;
    }

    @JsonProperty("lblShozokuKikan")
    public void setLblShozokuKikan(Label lblShozokuKikan) {
        this.lblShozokuKikan=lblShozokuKikan;
    }

    @JsonProperty("txtShozokuKikan")
    public TextBox getTxtShozokuKikan() {
        return txtShozokuKikan;
    }

    @JsonProperty("txtShozokuKikan")
    public void setTxtShozokuKikan(TextBox txtShozokuKikan) {
        this.txtShozokuKikan=txtShozokuKikan;
    }

}
