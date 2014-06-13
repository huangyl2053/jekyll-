package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
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
 * SeriveJokyoRiyoShisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeriveJokyoRiyoShisetsuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShisetsuType")
    private RadioButton radShisetsuType;
    @JsonProperty("lblSpace2")
    private Label lblSpace2;
    @JsonProperty("lblShisetsuName")
    private Label lblShisetsuName;
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("lblShisetsuJusho")
    private Label lblShisetsuJusho;
    @JsonProperty("txtShisetsuYubinNo")
    private TextBox txtShisetsuYubinNo;
    @JsonProperty("txtShisetsuJusho")
    private TextBox txtShisetsuJusho;
    @JsonProperty("lblShisetsuTelNo")
    private Label lblShisetsuTelNo;
    @JsonProperty("txtShisetsuTelNo")
    private TextBox txtShisetsuTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShisetsuType")
    public RadioButton getRadShisetsuType() {
        return radShisetsuType;
    }

    @JsonProperty("radShisetsuType")
    public void setRadShisetsuType(RadioButton radShisetsuType) {
        this.radShisetsuType=radShisetsuType;
    }

    @JsonProperty("lblSpace2")
    public Label getLblSpace2() {
        return lblSpace2;
    }

    @JsonProperty("lblSpace2")
    public void setLblSpace2(Label lblSpace2) {
        this.lblSpace2=lblSpace2;
    }

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

    @JsonProperty("lblShisetsuJusho")
    public Label getLblShisetsuJusho() {
        return lblShisetsuJusho;
    }

    @JsonProperty("lblShisetsuJusho")
    public void setLblShisetsuJusho(Label lblShisetsuJusho) {
        this.lblShisetsuJusho=lblShisetsuJusho;
    }

    @JsonProperty("txtShisetsuYubinNo")
    public TextBox getTxtShisetsuYubinNo() {
        return txtShisetsuYubinNo;
    }

    @JsonProperty("txtShisetsuYubinNo")
    public void setTxtShisetsuYubinNo(TextBox txtShisetsuYubinNo) {
        this.txtShisetsuYubinNo=txtShisetsuYubinNo;
    }

    @JsonProperty("txtShisetsuJusho")
    public TextBox getTxtShisetsuJusho() {
        return txtShisetsuJusho;
    }

    @JsonProperty("txtShisetsuJusho")
    public void setTxtShisetsuJusho(TextBox txtShisetsuJusho) {
        this.txtShisetsuJusho=txtShisetsuJusho;
    }

    @JsonProperty("lblShisetsuTelNo")
    public Label getLblShisetsuTelNo() {
        return lblShisetsuTelNo;
    }

    @JsonProperty("lblShisetsuTelNo")
    public void setLblShisetsuTelNo(Label lblShisetsuTelNo) {
        this.lblShisetsuTelNo=lblShisetsuTelNo;
    }

    @JsonProperty("txtShisetsuTelNo")
    public TextBox getTxtShisetsuTelNo() {
        return txtShisetsuTelNo;
    }

    @JsonProperty("txtShisetsuTelNo")
    public void setTxtShisetsuTelNo(TextBox txtShisetsuTelNo) {
        this.txtShisetsuTelNo=txtShisetsuTelNo;
    }

}
