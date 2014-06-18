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
 * HihokenshaForNinteichosaResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaForNinteichosaResultDiv extends Panel {
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
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtShinseiKubun")
    private TextBox txtShinseiKubun;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("txtHihokenshaBirthDay")
    private TextBoxFlexibleDate txtHihokenshaBirthDay;
    @JsonProperty("txtHihokenshaAge")
    private TextBox txtHihokenshaAge;
    @JsonProperty("txtHihokenshaGender")
    private TextBox txtHihokenshaGender;
    @JsonProperty("txtHihokenshaYubinNo")
    private TextBox txtHihokenshaYubinNo;
    @JsonProperty("txtHihokenshaJusho")
    private TextBox txtHihokenshaJusho;

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

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("txtShinseiKubun")
    public TextBox getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    @JsonProperty("txtShinseiKubun")
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.txtShinseiKubun=txtShinseiKubun;
    }

    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName=txtHihokenshaName;
    }

    @JsonProperty("txtHihokenshaBirthDay")
    public TextBoxFlexibleDate getTxtHihokenshaBirthDay() {
        return txtHihokenshaBirthDay;
    }

    @JsonProperty("txtHihokenshaBirthDay")
    public void setTxtHihokenshaBirthDay(TextBoxFlexibleDate txtHihokenshaBirthDay) {
        this.txtHihokenshaBirthDay=txtHihokenshaBirthDay;
    }

    @JsonProperty("txtHihokenshaAge")
    public TextBox getTxtHihokenshaAge() {
        return txtHihokenshaAge;
    }

    @JsonProperty("txtHihokenshaAge")
    public void setTxtHihokenshaAge(TextBox txtHihokenshaAge) {
        this.txtHihokenshaAge=txtHihokenshaAge;
    }

    @JsonProperty("txtHihokenshaGender")
    public TextBox getTxtHihokenshaGender() {
        return txtHihokenshaGender;
    }

    @JsonProperty("txtHihokenshaGender")
    public void setTxtHihokenshaGender(TextBox txtHihokenshaGender) {
        this.txtHihokenshaGender=txtHihokenshaGender;
    }

    @JsonProperty("txtHihokenshaYubinNo")
    public TextBox getTxtHihokenshaYubinNo() {
        return txtHihokenshaYubinNo;
    }

    @JsonProperty("txtHihokenshaYubinNo")
    public void setTxtHihokenshaYubinNo(TextBox txtHihokenshaYubinNo) {
        this.txtHihokenshaYubinNo=txtHihokenshaYubinNo;
    }

    @JsonProperty("txtHihokenshaJusho")
    public TextBox getTxtHihokenshaJusho() {
        return txtHihokenshaJusho;
    }

    @JsonProperty("txtHihokenshaJusho")
    public void setTxtHihokenshaJusho(TextBox txtHihokenshaJusho) {
        this.txtHihokenshaJusho=txtHihokenshaJusho;
    }

}
