package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

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
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtShinseiKubun")
    private TextBox txtShinseiKubun;
    @JsonProperty("txtChiku")
    private TextBox txtChiku;
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
    @JsonProperty("btnRenrakusaki")
    private Button btnRenrakusaki;
    @JsonProperty("btnShichosonRenraku")
    private Button btnShichosonRenraku;
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
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    @JsonProperty("txtShinseiKubun")
    public TextBox getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    @JsonProperty("txtShinseiKubun")
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.txtShinseiKubun = txtShinseiKubun;
    }

    @JsonProperty("txtChiku")
    public TextBox getTxtChiku() {
        return txtChiku;
    }

    @JsonProperty("txtChiku")
    public void setTxtChiku(TextBox txtChiku) {
        this.txtChiku = txtChiku;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxFlexibleDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxFlexibleDate txtBirthDay) {
        this.txtBirthDay = txtBirthDay;
    }

    @JsonProperty("txtGender")
    public TextBox getTxtGender() {
        return txtGender;
    }

    @JsonProperty("txtGender")
    public void setTxtGender(TextBox txtGender) {
        this.txtGender = txtGender;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBox getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBox txtJusho) {
        this.txtJusho = txtJusho;
    }

    @JsonProperty("btnRenrakusaki")
    public Button getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(Button btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    @JsonProperty("btnShichosonRenraku")
    public Button getBtnShichosonRenraku() {
        return btnShichosonRenraku;
    }

    @JsonProperty("btnShichosonRenraku")
    public void setBtnShichosonRenraku(Button btnShichosonRenraku) {
        this.btnShichosonRenraku = btnShichosonRenraku;
    }

    @JsonProperty("NinteichosaIraiEntryTargetLatestChosain")
    public NinteichosaIraiEntryTargetLatestChosainDiv getNinteichosaIraiEntryTargetLatestChosain() {
        return NinteichosaIraiEntryTargetLatestChosain;
    }

    @JsonProperty("NinteichosaIraiEntryTargetLatestChosain")
    public void setNinteichosaIraiEntryTargetLatestChosain(NinteichosaIraiEntryTargetLatestChosainDiv NinteichosaIraiEntryTargetLatestChosain) {
        this.NinteichosaIraiEntryTargetLatestChosain = NinteichosaIraiEntryTargetLatestChosain;
    }

}
