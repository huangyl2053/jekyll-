package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo;
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
 * ServiceRiyohyoBeppyoGokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoGokeiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    private TextBoxNum txtShuruiGendoChokaTani;
    @JsonProperty("txtShuruiGendonaiTani")
    private TextBoxNum txtShuruiGendonaiTani;
    @JsonProperty("txtTanisuTanka")
    private TextBoxNum txtTanisuTanka;
    @JsonProperty("txtKubunGendoChokaTani")
    private TextBoxNum txtKubunGendoChokaTani;
    @JsonProperty("txtKubunGendonaiTani")
    private TextBoxNum txtKubunGendonaiTani;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("txtHiyoSogaku")
    private TextBoxNum txtHiyoSogaku;
    @JsonProperty("lblHiyoSogaku")
    private Label lblHiyoSogaku;
    @JsonProperty("txtHokenKyufugaku")
    private TextBoxNum txtHokenKyufugaku;
    @JsonProperty("lblHokenKyufugaku")
    private Label lblHokenKyufugaku;
    @JsonProperty("txtRiyoshaFutangakuHoken")
    private TextBoxNum txtRiyoshaFutangakuHoken;
    @JsonProperty("lblRiyoshaFutangakuHoken")
    private Label lblRiyoshaFutangakuHoken;
    @JsonProperty("txtRiyoshaFutangakuZengaku")
    private TextBoxNum txtRiyoshaFutangakuZengaku;
    @JsonProperty("lblRiyoshaFutangakuZengaku")
    private Label lblRiyoshaFutangakuZengaku;
    @JsonProperty("btnBeppyoGokeiKakutei")
    private Button btnBeppyoGokeiKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShuruiGendoChokaTani")
    public TextBoxNum getTxtShuruiGendoChokaTani() {
        return txtShuruiGendoChokaTani;
    }

    @JsonProperty("txtShuruiGendoChokaTani")
    public void setTxtShuruiGendoChokaTani(TextBoxNum txtShuruiGendoChokaTani) {
        this.txtShuruiGendoChokaTani=txtShuruiGendoChokaTani;
    }

    @JsonProperty("txtShuruiGendonaiTani")
    public TextBoxNum getTxtShuruiGendonaiTani() {
        return txtShuruiGendonaiTani;
    }

    @JsonProperty("txtShuruiGendonaiTani")
    public void setTxtShuruiGendonaiTani(TextBoxNum txtShuruiGendonaiTani) {
        this.txtShuruiGendonaiTani=txtShuruiGendonaiTani;
    }

    @JsonProperty("txtTanisuTanka")
    public TextBoxNum getTxtTanisuTanka() {
        return txtTanisuTanka;
    }

    @JsonProperty("txtTanisuTanka")
    public void setTxtTanisuTanka(TextBoxNum txtTanisuTanka) {
        this.txtTanisuTanka=txtTanisuTanka;
    }

    @JsonProperty("txtKubunGendoChokaTani")
    public TextBoxNum getTxtKubunGendoChokaTani() {
        return txtKubunGendoChokaTani;
    }

    @JsonProperty("txtKubunGendoChokaTani")
    public void setTxtKubunGendoChokaTani(TextBoxNum txtKubunGendoChokaTani) {
        this.txtKubunGendoChokaTani=txtKubunGendoChokaTani;
    }

    @JsonProperty("txtKubunGendonaiTani")
    public TextBoxNum getTxtKubunGendonaiTani() {
        return txtKubunGendonaiTani;
    }

    @JsonProperty("txtKubunGendonaiTani")
    public void setTxtKubunGendonaiTani(TextBoxNum txtKubunGendonaiTani) {
        this.txtKubunGendonaiTani=txtKubunGendonaiTani;
    }

    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu=txtKyufuritsu;
    }

    @JsonProperty("txtHiyoSogaku")
    public TextBoxNum getTxtHiyoSogaku() {
        return txtHiyoSogaku;
    }

    @JsonProperty("txtHiyoSogaku")
    public void setTxtHiyoSogaku(TextBoxNum txtHiyoSogaku) {
        this.txtHiyoSogaku=txtHiyoSogaku;
    }

    @JsonProperty("lblHiyoSogaku")
    public Label getLblHiyoSogaku() {
        return lblHiyoSogaku;
    }

    @JsonProperty("lblHiyoSogaku")
    public void setLblHiyoSogaku(Label lblHiyoSogaku) {
        this.lblHiyoSogaku=lblHiyoSogaku;
    }

    @JsonProperty("txtHokenKyufugaku")
    public TextBoxNum getTxtHokenKyufugaku() {
        return txtHokenKyufugaku;
    }

    @JsonProperty("txtHokenKyufugaku")
    public void setTxtHokenKyufugaku(TextBoxNum txtHokenKyufugaku) {
        this.txtHokenKyufugaku=txtHokenKyufugaku;
    }

    @JsonProperty("lblHokenKyufugaku")
    public Label getLblHokenKyufugaku() {
        return lblHokenKyufugaku;
    }

    @JsonProperty("lblHokenKyufugaku")
    public void setLblHokenKyufugaku(Label lblHokenKyufugaku) {
        this.lblHokenKyufugaku=lblHokenKyufugaku;
    }

    @JsonProperty("txtRiyoshaFutangakuHoken")
    public TextBoxNum getTxtRiyoshaFutangakuHoken() {
        return txtRiyoshaFutangakuHoken;
    }

    @JsonProperty("txtRiyoshaFutangakuHoken")
    public void setTxtRiyoshaFutangakuHoken(TextBoxNum txtRiyoshaFutangakuHoken) {
        this.txtRiyoshaFutangakuHoken=txtRiyoshaFutangakuHoken;
    }

    @JsonProperty("lblRiyoshaFutangakuHoken")
    public Label getLblRiyoshaFutangakuHoken() {
        return lblRiyoshaFutangakuHoken;
    }

    @JsonProperty("lblRiyoshaFutangakuHoken")
    public void setLblRiyoshaFutangakuHoken(Label lblRiyoshaFutangakuHoken) {
        this.lblRiyoshaFutangakuHoken=lblRiyoshaFutangakuHoken;
    }

    @JsonProperty("txtRiyoshaFutangakuZengaku")
    public TextBoxNum getTxtRiyoshaFutangakuZengaku() {
        return txtRiyoshaFutangakuZengaku;
    }

    @JsonProperty("txtRiyoshaFutangakuZengaku")
    public void setTxtRiyoshaFutangakuZengaku(TextBoxNum txtRiyoshaFutangakuZengaku) {
        this.txtRiyoshaFutangakuZengaku=txtRiyoshaFutangakuZengaku;
    }

    @JsonProperty("lblRiyoshaFutangakuZengaku")
    public Label getLblRiyoshaFutangakuZengaku() {
        return lblRiyoshaFutangakuZengaku;
    }

    @JsonProperty("lblRiyoshaFutangakuZengaku")
    public void setLblRiyoshaFutangakuZengaku(Label lblRiyoshaFutangakuZengaku) {
        this.lblRiyoshaFutangakuZengaku=lblRiyoshaFutangakuZengaku;
    }

    @JsonProperty("btnBeppyoGokeiKakutei")
    public Button getBtnBeppyoGokeiKakutei() {
        return btnBeppyoGokeiKakutei;
    }

    @JsonProperty("btnBeppyoGokeiKakutei")
    public void setBtnBeppyoGokeiKakutei(Button btnBeppyoGokeiKakutei) {
        this.btnBeppyoGokeiKakutei=btnBeppyoGokeiKakutei;
    }

}
