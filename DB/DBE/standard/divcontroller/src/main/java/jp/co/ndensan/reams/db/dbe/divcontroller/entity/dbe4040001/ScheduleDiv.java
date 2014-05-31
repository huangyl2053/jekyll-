package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001;
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
 * Schedule のクラスファイル 
 * 
 * @author 自動生成
 */
public class ScheduleDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGogitaiNo")
    private Label lblGogitaiNo;
    @JsonProperty("ddlGogitai")
    private DropDownList ddlGogitai;
    @JsonProperty("lblKaisaiBasho")
    private Label lblKaisaiBasho;
    @JsonProperty("ddlKaisaiBasho")
    private DropDownList ddlKaisaiBasho;
    @JsonProperty("lblYoteiTime")
    private Label lblYoteiTime;
    @JsonProperty("txtYoteiTimeFrom")
    private TextBoxTime txtYoteiTimeFrom;
    @JsonProperty("lblYoteiTimeWave")
    private Label lblYoteiTimeWave;
    @JsonProperty("txtYoteiTimeTo")
    private TextBoxTime txtYoteiTimeTo;
    @JsonProperty("lblKaisaiDate")
    private Label lblKaisaiDate;
    @JsonProperty("txtKaisaiDate")
    private TextBoxDate txtKaisaiDate;
    @JsonProperty("lblYoteiTeiin")
    private Label lblYoteiTeiin;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("lblYoteiTeiinUnit")
    private Label lblYoteiTeiinUnit;
    @JsonProperty("lblMaxTeiin")
    private Label lblMaxTeiin;
    @JsonProperty("txtMaxTeiin")
    private TextBoxNum txtMaxTeiin;
    @JsonProperty("lblMaxTeiinUnit")
    private Label lblMaxTeiinUnit;
    @JsonProperty("lblAutoBindTeiin")
    private Label lblAutoBindTeiin;
    @JsonProperty("txtAutoBindTeiin")
    private TextBoxNum txtAutoBindTeiin;
    @JsonProperty("lblAutoBindTeiinUnit")
    private Label lblAutoBindTeiinUnit;
    @JsonProperty("Gogitai")
    private GogitaiDiv Gogitai;
    @JsonProperty("RegisterButton")
    private RegisterButtonDiv RegisterButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblGogitaiNo")
    public Label getLblGogitaiNo() {
        return lblGogitaiNo;
    }

    @JsonProperty("lblGogitaiNo")
    public void setLblGogitaiNo(Label lblGogitaiNo) {
        this.lblGogitaiNo=lblGogitaiNo;
    }

    @JsonProperty("ddlGogitai")
    public DropDownList getDdlGogitai() {
        return ddlGogitai;
    }

    @JsonProperty("ddlGogitai")
    public void setDdlGogitai(DropDownList ddlGogitai) {
        this.ddlGogitai=ddlGogitai;
    }

    @JsonProperty("lblKaisaiBasho")
    public Label getLblKaisaiBasho() {
        return lblKaisaiBasho;
    }

    @JsonProperty("lblKaisaiBasho")
    public void setLblKaisaiBasho(Label lblKaisaiBasho) {
        this.lblKaisaiBasho=lblKaisaiBasho;
    }

    @JsonProperty("ddlKaisaiBasho")
    public DropDownList getDdlKaisaiBasho() {
        return ddlKaisaiBasho;
    }

    @JsonProperty("ddlKaisaiBasho")
    public void setDdlKaisaiBasho(DropDownList ddlKaisaiBasho) {
        this.ddlKaisaiBasho=ddlKaisaiBasho;
    }

    @JsonProperty("lblYoteiTime")
    public Label getLblYoteiTime() {
        return lblYoteiTime;
    }

    @JsonProperty("lblYoteiTime")
    public void setLblYoteiTime(Label lblYoteiTime) {
        this.lblYoteiTime=lblYoteiTime;
    }

    @JsonProperty("txtYoteiTimeFrom")
    public TextBoxTime getTxtYoteiTimeFrom() {
        return txtYoteiTimeFrom;
    }

    @JsonProperty("txtYoteiTimeFrom")
    public void setTxtYoteiTimeFrom(TextBoxTime txtYoteiTimeFrom) {
        this.txtYoteiTimeFrom=txtYoteiTimeFrom;
    }

    @JsonProperty("lblYoteiTimeWave")
    public Label getLblYoteiTimeWave() {
        return lblYoteiTimeWave;
    }

    @JsonProperty("lblYoteiTimeWave")
    public void setLblYoteiTimeWave(Label lblYoteiTimeWave) {
        this.lblYoteiTimeWave=lblYoteiTimeWave;
    }

    @JsonProperty("txtYoteiTimeTo")
    public TextBoxTime getTxtYoteiTimeTo() {
        return txtYoteiTimeTo;
    }

    @JsonProperty("txtYoteiTimeTo")
    public void setTxtYoteiTimeTo(TextBoxTime txtYoteiTimeTo) {
        this.txtYoteiTimeTo=txtYoteiTimeTo;
    }

    @JsonProperty("lblKaisaiDate")
    public Label getLblKaisaiDate() {
        return lblKaisaiDate;
    }

    @JsonProperty("lblKaisaiDate")
    public void setLblKaisaiDate(Label lblKaisaiDate) {
        this.lblKaisaiDate=lblKaisaiDate;
    }

    @JsonProperty("txtKaisaiDate")
    public TextBoxDate getTxtKaisaiDate() {
        return txtKaisaiDate;
    }

    @JsonProperty("txtKaisaiDate")
    public void setTxtKaisaiDate(TextBoxDate txtKaisaiDate) {
        this.txtKaisaiDate=txtKaisaiDate;
    }

    @JsonProperty("lblYoteiTeiin")
    public Label getLblYoteiTeiin() {
        return lblYoteiTeiin;
    }

    @JsonProperty("lblYoteiTeiin")
    public void setLblYoteiTeiin(Label lblYoteiTeiin) {
        this.lblYoteiTeiin=lblYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin=txtYoteiTeiin;
    }

    @JsonProperty("lblYoteiTeiinUnit")
    public Label getLblYoteiTeiinUnit() {
        return lblYoteiTeiinUnit;
    }

    @JsonProperty("lblYoteiTeiinUnit")
    public void setLblYoteiTeiinUnit(Label lblYoteiTeiinUnit) {
        this.lblYoteiTeiinUnit=lblYoteiTeiinUnit;
    }

    @JsonProperty("lblMaxTeiin")
    public Label getLblMaxTeiin() {
        return lblMaxTeiin;
    }

    @JsonProperty("lblMaxTeiin")
    public void setLblMaxTeiin(Label lblMaxTeiin) {
        this.lblMaxTeiin=lblMaxTeiin;
    }

    @JsonProperty("txtMaxTeiin")
    public TextBoxNum getTxtMaxTeiin() {
        return txtMaxTeiin;
    }

    @JsonProperty("txtMaxTeiin")
    public void setTxtMaxTeiin(TextBoxNum txtMaxTeiin) {
        this.txtMaxTeiin=txtMaxTeiin;
    }

    @JsonProperty("lblMaxTeiinUnit")
    public Label getLblMaxTeiinUnit() {
        return lblMaxTeiinUnit;
    }

    @JsonProperty("lblMaxTeiinUnit")
    public void setLblMaxTeiinUnit(Label lblMaxTeiinUnit) {
        this.lblMaxTeiinUnit=lblMaxTeiinUnit;
    }

    @JsonProperty("lblAutoBindTeiin")
    public Label getLblAutoBindTeiin() {
        return lblAutoBindTeiin;
    }

    @JsonProperty("lblAutoBindTeiin")
    public void setLblAutoBindTeiin(Label lblAutoBindTeiin) {
        this.lblAutoBindTeiin=lblAutoBindTeiin;
    }

    @JsonProperty("txtAutoBindTeiin")
    public TextBoxNum getTxtAutoBindTeiin() {
        return txtAutoBindTeiin;
    }

    @JsonProperty("txtAutoBindTeiin")
    public void setTxtAutoBindTeiin(TextBoxNum txtAutoBindTeiin) {
        this.txtAutoBindTeiin=txtAutoBindTeiin;
    }

    @JsonProperty("lblAutoBindTeiinUnit")
    public Label getLblAutoBindTeiinUnit() {
        return lblAutoBindTeiinUnit;
    }

    @JsonProperty("lblAutoBindTeiinUnit")
    public void setLblAutoBindTeiinUnit(Label lblAutoBindTeiinUnit) {
        this.lblAutoBindTeiinUnit=lblAutoBindTeiinUnit;
    }

    @JsonProperty("Gogitai")
    public GogitaiDiv getGogitai() {
        return Gogitai;
    }

    @JsonProperty("Gogitai")
    public void setGogitai(GogitaiDiv Gogitai) {
        this.Gogitai=Gogitai;
    }

    @JsonProperty("RegisterButton")
    public RegisterButtonDiv getRegisterButton() {
        return RegisterButton;
    }

    @JsonProperty("RegisterButton")
    public void setRegisterButton(RegisterButtonDiv RegisterButton) {
        this.RegisterButton=RegisterButton;
    }

}
