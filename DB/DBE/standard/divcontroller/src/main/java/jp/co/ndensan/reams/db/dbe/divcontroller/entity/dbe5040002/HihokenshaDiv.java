package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5040002;
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
 * Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("lblGender")
    private Label lblGender;
    @JsonProperty("chkGender")
    private CheckBoxList chkGender;
    @JsonProperty("txtHihokensaName")
    private TextBox txtHihokensaName;
    @JsonProperty("txtBirthDay")
    private TextBoxDate txtBirthDay;
    @JsonProperty("lblPaddingHihokenshaName")
    private Label lblPaddingHihokenshaName;
    @JsonProperty("radNameSearchType")
    private RadioButton radNameSearchType;
    @JsonProperty("lblNameSearch")
    private Label lblNameSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("lblGender")
    public Label getLblGender() {
        return lblGender;
    }

    @JsonProperty("lblGender")
    public void setLblGender(Label lblGender) {
        this.lblGender=lblGender;
    }

    @JsonProperty("chkGender")
    public CheckBoxList getChkGender() {
        return chkGender;
    }

    @JsonProperty("chkGender")
    public void setChkGender(CheckBoxList chkGender) {
        this.chkGender=chkGender;
    }

    @JsonProperty("txtHihokensaName")
    public TextBox getTxtHihokensaName() {
        return txtHihokensaName;
    }

    @JsonProperty("txtHihokensaName")
    public void setTxtHihokensaName(TextBox txtHihokensaName) {
        this.txtHihokensaName=txtHihokensaName;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("lblPaddingHihokenshaName")
    public Label getLblPaddingHihokenshaName() {
        return lblPaddingHihokenshaName;
    }

    @JsonProperty("lblPaddingHihokenshaName")
    public void setLblPaddingHihokenshaName(Label lblPaddingHihokenshaName) {
        this.lblPaddingHihokenshaName=lblPaddingHihokenshaName;
    }

    @JsonProperty("radNameSearchType")
    public RadioButton getRadNameSearchType() {
        return radNameSearchType;
    }

    @JsonProperty("radNameSearchType")
    public void setRadNameSearchType(RadioButton radNameSearchType) {
        this.radNameSearchType=radNameSearchType;
    }

    @JsonProperty("lblNameSearch")
    public Label getLblNameSearch() {
        return lblNameSearch;
    }

    @JsonProperty("lblNameSearch")
    public void setLblNameSearch(Label lblNameSearch) {
        this.lblNameSearch=lblNameSearch;
    }

}
