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
 * EditShisetsuRereki のクラスファイル 
 * 
 * @author 自動生成
 */
public class EditShisetsuRerekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShisetsuName")
    private Label lblShisetsuName;
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("imgToSearchShisetsu")
    private StaticImage imgToSearchShisetsu;
    @JsonProperty("lblStartDate")
    private Label lblStartDate;
    @JsonProperty("txtStartDate")
    private TextBoxDate txtStartDate;
    @JsonProperty("lblEndDate")
    private Label lblEndDate;
    @JsonProperty("txtEndDate")
    private TextBoxDate txtEndDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShisetsuName")
    public Label getLblShisetsuName() {
        return lblShisetsuName;
    }

    @JsonProperty("lblShisetsuName")
    public void setLblShisetsuName(Label lblShisetsuName) {
        this.lblShisetsuName=lblShisetsuName;
    }

    @JsonProperty("txtShisetsuName")
    public TextBox getTxtShisetsuName() {
        return txtShisetsuName;
    }

    @JsonProperty("txtShisetsuName")
    public void setTxtShisetsuName(TextBox txtShisetsuName) {
        this.txtShisetsuName=txtShisetsuName;
    }

    @JsonProperty("imgToSearchShisetsu")
    public StaticImage getImgToSearchShisetsu() {
        return imgToSearchShisetsu;
    }

    @JsonProperty("imgToSearchShisetsu")
    public void setImgToSearchShisetsu(StaticImage imgToSearchShisetsu) {
        this.imgToSearchShisetsu=imgToSearchShisetsu;
    }

    @JsonProperty("lblStartDate")
    public Label getLblStartDate() {
        return lblStartDate;
    }

    @JsonProperty("lblStartDate")
    public void setLblStartDate(Label lblStartDate) {
        this.lblStartDate=lblStartDate;
    }

    @JsonProperty("txtStartDate")
    public TextBoxDate getTxtStartDate() {
        return txtStartDate;
    }

    @JsonProperty("txtStartDate")
    public void setTxtStartDate(TextBoxDate txtStartDate) {
        this.txtStartDate=txtStartDate;
    }

    @JsonProperty("lblEndDate")
    public Label getLblEndDate() {
        return lblEndDate;
    }

    @JsonProperty("lblEndDate")
    public void setLblEndDate(Label lblEndDate) {
        this.lblEndDate=lblEndDate;
    }

    @JsonProperty("txtEndDate")
    public TextBoxDate getTxtEndDate() {
        return txtEndDate;
    }

    @JsonProperty("txtEndDate")
    public void setTxtEndDate(TextBoxDate txtEndDate) {
        this.txtEndDate=txtEndDate;
    }

}
