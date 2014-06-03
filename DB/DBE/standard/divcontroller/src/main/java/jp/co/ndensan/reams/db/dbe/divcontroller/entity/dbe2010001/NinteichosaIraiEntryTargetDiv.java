package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetLatestChosainDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiEntryTarget のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryTargetDiv extends Panel {
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
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtBirthDay")
    private TextBoxFlexibleDate txtBirthDay;
    @JsonProperty("txtGender")
    private TextBox txtGender;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBox txtJusho;
    @JsonProperty("NinteichosaIraiEntryTargetLatestChosain")
    private NinteichosaIraiEntryTargetLatestChosainDiv NinteichosaIraiEntryTargetLatestChosain;

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

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxFlexibleDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxFlexibleDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("txtGender")
    public TextBox getTxtGender() {
        return txtGender;
    }

    @JsonProperty("txtGender")
    public void setTxtGender(TextBox txtGender) {
        this.txtGender=txtGender;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("NinteichosaIraiEntryTargetLatestChosain")
    public NinteichosaIraiEntryTargetLatestChosainDiv getNinteichosaIraiEntryTargetLatestChosain() {
        return NinteichosaIraiEntryTargetLatestChosain;
    }

    @JsonProperty("NinteichosaIraiEntryTargetLatestChosain")
    public void setNinteichosaIraiEntryTargetLatestChosain(NinteichosaIraiEntryTargetLatestChosainDiv NinteichosaIraiEntryTargetLatestChosain) {
        this.NinteichosaIraiEntryTargetLatestChosain=NinteichosaIraiEntryTargetLatestChosain;
    }

}
