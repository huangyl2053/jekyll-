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
 * HihokenshaShujii のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShujiiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblIryokikan")
    private Label lblIryokikan;
    @JsonProperty("txtIryokikanCode")
    private TextBoxCode txtIryokikanCode;
    @JsonProperty("txtIryokikanName")
    private TextBox txtIryokikanName;
    @JsonProperty("imgToSearchShujii")
    private StaticImage imgToSearchShujii;
    @JsonProperty("lblShujii")
    private Label lblShujii;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("imgPadding1")
    private StaticImage imgPadding1;
    @JsonProperty("btnToCopyLatestShujii")
    private Button btnToCopyLatestShujii;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblIryokikan")
    public Label getLblIryokikan() {
        return lblIryokikan;
    }

    @JsonProperty("lblIryokikan")
    public void setLblIryokikan(Label lblIryokikan) {
        this.lblIryokikan=lblIryokikan;
    }

    @JsonProperty("txtIryokikanCode")
    public TextBoxCode getTxtIryokikanCode() {
        return txtIryokikanCode;
    }

    @JsonProperty("txtIryokikanCode")
    public void setTxtIryokikanCode(TextBoxCode txtIryokikanCode) {
        this.txtIryokikanCode=txtIryokikanCode;
    }

    @JsonProperty("txtIryokikanName")
    public TextBox getTxtIryokikanName() {
        return txtIryokikanName;
    }

    @JsonProperty("txtIryokikanName")
    public void setTxtIryokikanName(TextBox txtIryokikanName) {
        this.txtIryokikanName=txtIryokikanName;
    }

    @JsonProperty("imgToSearchShujii")
    public StaticImage getImgToSearchShujii() {
        return imgToSearchShujii;
    }

    @JsonProperty("imgToSearchShujii")
    public void setImgToSearchShujii(StaticImage imgToSearchShujii) {
        this.imgToSearchShujii=imgToSearchShujii;
    }

    @JsonProperty("lblShujii")
    public Label getLblShujii() {
        return lblShujii;
    }

    @JsonProperty("lblShujii")
    public void setLblShujii(Label lblShujii) {
        this.lblShujii=lblShujii;
    }

    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode=txtShujiiCode;
    }

    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName=txtShujiiName;
    }

    @JsonProperty("imgPadding1")
    public StaticImage getImgPadding1() {
        return imgPadding1;
    }

    @JsonProperty("imgPadding1")
    public void setImgPadding1(StaticImage imgPadding1) {
        this.imgPadding1=imgPadding1;
    }

    @JsonProperty("btnToCopyLatestShujii")
    public Button getBtnToCopyLatestShujii() {
        return btnToCopyLatestShujii;
    }

    @JsonProperty("btnToCopyLatestShujii")
    public void setBtnToCopyLatestShujii(Button btnToCopyLatestShujii) {
        this.btnToCopyLatestShujii=btnToCopyLatestShujii;
    }

}
