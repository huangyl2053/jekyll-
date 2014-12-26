package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBAMN02001;
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
 * UFLabel のクラスファイル 
 * 
 * @author 自動生成
 */
public class UFLabelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Label3")
    private Label Label3;
    @JsonProperty("chkdcChkHihoDaicho")
    private CheckBoxList chkdcChkHihoDaicho;
    @JsonProperty("HorizontalLine1")
    private HorizontalLine HorizontalLine1;
    @JsonProperty("Button2")
    private Button Button2;
    @JsonProperty("RadioButton2")
    private RadioButton RadioButton2;
    @JsonProperty("TextBox2")
    private TextBox TextBox2;
    @JsonProperty("Label1")
    private Label Label1;
    @JsonProperty("rdoRbtMojigireCtrl")
    private RadioButton rdoRbtMojigireCtrl;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Label3")
    public Label getLabel3() {
        return Label3;
    }

    @JsonProperty("Label3")
    public void setLabel3(Label Label3) {
        this.Label3=Label3;
    }

    @JsonProperty("chkdcChkHihoDaicho")
    public CheckBoxList getChkdcChkHihoDaicho() {
        return chkdcChkHihoDaicho;
    }

    @JsonProperty("chkdcChkHihoDaicho")
    public void setChkdcChkHihoDaicho(CheckBoxList chkdcChkHihoDaicho) {
        this.chkdcChkHihoDaicho=chkdcChkHihoDaicho;
    }

    @JsonProperty("HorizontalLine1")
    public HorizontalLine getHorizontalLine1() {
        return HorizontalLine1;
    }

    @JsonProperty("HorizontalLine1")
    public void setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.HorizontalLine1=HorizontalLine1;
    }

    @JsonProperty("Button2")
    public Button getButton2() {
        return Button2;
    }

    @JsonProperty("Button2")
    public void setButton2(Button Button2) {
        this.Button2=Button2;
    }

    @JsonProperty("RadioButton2")
    public RadioButton getRadioButton2() {
        return RadioButton2;
    }

    @JsonProperty("RadioButton2")
    public void setRadioButton2(RadioButton RadioButton2) {
        this.RadioButton2=RadioButton2;
    }

    @JsonProperty("TextBox2")
    public TextBox getTextBox2() {
        return TextBox2;
    }

    @JsonProperty("TextBox2")
    public void setTextBox2(TextBox TextBox2) {
        this.TextBox2=TextBox2;
    }

    @JsonProperty("Label1")
    public Label getLabel1() {
        return Label1;
    }

    @JsonProperty("Label1")
    public void setLabel1(Label Label1) {
        this.Label1=Label1;
    }

    @JsonProperty("rdoRbtMojigireCtrl")
    public RadioButton getRdoRbtMojigireCtrl() {
        return rdoRbtMojigireCtrl;
    }

    @JsonProperty("rdoRbtMojigireCtrl")
    public void setRdoRbtMojigireCtrl(RadioButton rdoRbtMojigireCtrl) {
        this.rdoRbtMojigireCtrl=rdoRbtMojigireCtrl;
    }

}
