package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * ReamsCommonInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ReamsCommonInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminShubetsuLabel")
    private Label JuminShubetsuLabel;
    @JsonProperty("JuminShubetsuText")
    private TextBox JuminShubetsuText;
    @JsonProperty("HurikanaLabel")
    private Label HurikanaLabel;
    @JsonProperty("HurikanaText")
    private TextBox HurikanaText;
    @JsonProperty("GenderLabel")
    private Label GenderLabel;
    @JsonProperty("GenderText")
    private TextBox GenderText;
    @JsonProperty("AgeLabel")
    private Label AgeLabel;
    @JsonProperty("AgeText")
    private TextBox AgeText;
    @JsonProperty("ShimeiLabel")
    private Label ShimeiLabel;
    @JsonProperty("ShimeiText")
    private TextBox ShimeiText;
    @JsonProperty("DateOfBirthLabel")
    private Label DateOfBirthLabel;
    @JsonProperty("DateOfBirthText")
    private TextBoxFlexibleDate DateOfBirthText;
    @JsonProperty("JushoLabel")
    private Label JushoLabel;
    @JsonProperty("JushoCodeText")
    private TextBox JushoCodeText;
    @JsonProperty("JushoText")
    private TextBox JushoText;
    @JsonProperty("GyoseikuLabel")
    private Label GyoseikuLabel;
    @JsonProperty("GyoseikuText")
    private TextBox GyoseikuText;
    @JsonProperty("KumiaiLabel")
    private Label KumiaiLabel;
    @JsonProperty("KumiaiText")
    private TextBox KumiaiText;
    @JsonProperty("SetaiCodeLabel")
    private Label SetaiCodeLabel;
    @JsonProperty("SetaiCodeText")
    private TextBox SetaiCodeText;
    @JsonProperty("JuminhyoCodeLabel")
    private Label JuminhyoCodeLabel;
    @JsonProperty("JuminhyoCodeText")
    private TextBox JuminhyoCodeText;
    @JsonProperty("Renrakusaki1Label")
    private Label Renrakusaki1Label;
    @JsonProperty("Renrakusaki1Text")
    private TextBox Renrakusaki1Text;
    @JsonProperty("Renrakusaki2Label")
    private Label Renrakusaki2Label;
    @JsonProperty("Renrakusaki2Text")
    private TextBox Renrakusaki2Text;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JuminShubetsuLabel")
    public Label getJuminShubetsuLabel() {
        return JuminShubetsuLabel;
    }

    @JsonProperty("JuminShubetsuLabel")
    public void setJuminShubetsuLabel(Label JuminShubetsuLabel) {
        this.JuminShubetsuLabel=JuminShubetsuLabel;
    }

    @JsonProperty("JuminShubetsuText")
    public TextBox getJuminShubetsuText() {
        return JuminShubetsuText;
    }

    @JsonProperty("JuminShubetsuText")
    public void setJuminShubetsuText(TextBox JuminShubetsuText) {
        this.JuminShubetsuText=JuminShubetsuText;
    }

    @JsonProperty("HurikanaLabel")
    public Label getHurikanaLabel() {
        return HurikanaLabel;
    }

    @JsonProperty("HurikanaLabel")
    public void setHurikanaLabel(Label HurikanaLabel) {
        this.HurikanaLabel=HurikanaLabel;
    }

    @JsonProperty("HurikanaText")
    public TextBox getHurikanaText() {
        return HurikanaText;
    }

    @JsonProperty("HurikanaText")
    public void setHurikanaText(TextBox HurikanaText) {
        this.HurikanaText=HurikanaText;
    }

    @JsonProperty("GenderLabel")
    public Label getGenderLabel() {
        return GenderLabel;
    }

    @JsonProperty("GenderLabel")
    public void setGenderLabel(Label GenderLabel) {
        this.GenderLabel=GenderLabel;
    }

    @JsonProperty("GenderText")
    public TextBox getGenderText() {
        return GenderText;
    }

    @JsonProperty("GenderText")
    public void setGenderText(TextBox GenderText) {
        this.GenderText=GenderText;
    }

    @JsonProperty("AgeLabel")
    public Label getAgeLabel() {
        return AgeLabel;
    }

    @JsonProperty("AgeLabel")
    public void setAgeLabel(Label AgeLabel) {
        this.AgeLabel=AgeLabel;
    }

    @JsonProperty("AgeText")
    public TextBox getAgeText() {
        return AgeText;
    }

    @JsonProperty("AgeText")
    public void setAgeText(TextBox AgeText) {
        this.AgeText=AgeText;
    }

    @JsonProperty("ShimeiLabel")
    public Label getShimeiLabel() {
        return ShimeiLabel;
    }

    @JsonProperty("ShimeiLabel")
    public void setShimeiLabel(Label ShimeiLabel) {
        this.ShimeiLabel=ShimeiLabel;
    }

    @JsonProperty("ShimeiText")
    public TextBox getShimeiText() {
        return ShimeiText;
    }

    @JsonProperty("ShimeiText")
    public void setShimeiText(TextBox ShimeiText) {
        this.ShimeiText=ShimeiText;
    }

    @JsonProperty("DateOfBirthLabel")
    public Label getDateOfBirthLabel() {
        return DateOfBirthLabel;
    }

    @JsonProperty("DateOfBirthLabel")
    public void setDateOfBirthLabel(Label DateOfBirthLabel) {
        this.DateOfBirthLabel=DateOfBirthLabel;
    }

    @JsonProperty("DateOfBirthText")
    public TextBoxFlexibleDate getDateOfBirthText() {
        return DateOfBirthText;
    }

    @JsonProperty("DateOfBirthText")
    public void setDateOfBirthText(TextBoxFlexibleDate DateOfBirthText) {
        this.DateOfBirthText=DateOfBirthText;
    }

    @JsonProperty("JushoLabel")
    public Label getJushoLabel() {
        return JushoLabel;
    }

    @JsonProperty("JushoLabel")
    public void setJushoLabel(Label JushoLabel) {
        this.JushoLabel=JushoLabel;
    }

    @JsonProperty("JushoCodeText")
    public TextBox getJushoCodeText() {
        return JushoCodeText;
    }

    @JsonProperty("JushoCodeText")
    public void setJushoCodeText(TextBox JushoCodeText) {
        this.JushoCodeText=JushoCodeText;
    }

    @JsonProperty("JushoText")
    public TextBox getJushoText() {
        return JushoText;
    }

    @JsonProperty("JushoText")
    public void setJushoText(TextBox JushoText) {
        this.JushoText=JushoText;
    }

    @JsonProperty("GyoseikuLabel")
    public Label getGyoseikuLabel() {
        return GyoseikuLabel;
    }

    @JsonProperty("GyoseikuLabel")
    public void setGyoseikuLabel(Label GyoseikuLabel) {
        this.GyoseikuLabel=GyoseikuLabel;
    }

    @JsonProperty("GyoseikuText")
    public TextBox getGyoseikuText() {
        return GyoseikuText;
    }

    @JsonProperty("GyoseikuText")
    public void setGyoseikuText(TextBox GyoseikuText) {
        this.GyoseikuText=GyoseikuText;
    }

    @JsonProperty("KumiaiLabel")
    public Label getKumiaiLabel() {
        return KumiaiLabel;
    }

    @JsonProperty("KumiaiLabel")
    public void setKumiaiLabel(Label KumiaiLabel) {
        this.KumiaiLabel=KumiaiLabel;
    }

    @JsonProperty("KumiaiText")
    public TextBox getKumiaiText() {
        return KumiaiText;
    }

    @JsonProperty("KumiaiText")
    public void setKumiaiText(TextBox KumiaiText) {
        this.KumiaiText=KumiaiText;
    }

    @JsonProperty("SetaiCodeLabel")
    public Label getSetaiCodeLabel() {
        return SetaiCodeLabel;
    }

    @JsonProperty("SetaiCodeLabel")
    public void setSetaiCodeLabel(Label SetaiCodeLabel) {
        this.SetaiCodeLabel=SetaiCodeLabel;
    }

    @JsonProperty("SetaiCodeText")
    public TextBox getSetaiCodeText() {
        return SetaiCodeText;
    }

    @JsonProperty("SetaiCodeText")
    public void setSetaiCodeText(TextBox SetaiCodeText) {
        this.SetaiCodeText=SetaiCodeText;
    }

    @JsonProperty("JuminhyoCodeLabel")
    public Label getJuminhyoCodeLabel() {
        return JuminhyoCodeLabel;
    }

    @JsonProperty("JuminhyoCodeLabel")
    public void setJuminhyoCodeLabel(Label JuminhyoCodeLabel) {
        this.JuminhyoCodeLabel=JuminhyoCodeLabel;
    }

    @JsonProperty("JuminhyoCodeText")
    public TextBox getJuminhyoCodeText() {
        return JuminhyoCodeText;
    }

    @JsonProperty("JuminhyoCodeText")
    public void setJuminhyoCodeText(TextBox JuminhyoCodeText) {
        this.JuminhyoCodeText=JuminhyoCodeText;
    }

    @JsonProperty("Renrakusaki1Label")
    public Label getRenrakusaki1Label() {
        return Renrakusaki1Label;
    }

    @JsonProperty("Renrakusaki1Label")
    public void setRenrakusaki1Label(Label Renrakusaki1Label) {
        this.Renrakusaki1Label=Renrakusaki1Label;
    }

    @JsonProperty("Renrakusaki1Text")
    public TextBox getRenrakusaki1Text() {
        return Renrakusaki1Text;
    }

    @JsonProperty("Renrakusaki1Text")
    public void setRenrakusaki1Text(TextBox Renrakusaki1Text) {
        this.Renrakusaki1Text=Renrakusaki1Text;
    }

    @JsonProperty("Renrakusaki2Label")
    public Label getRenrakusaki2Label() {
        return Renrakusaki2Label;
    }

    @JsonProperty("Renrakusaki2Label")
    public void setRenrakusaki2Label(Label Renrakusaki2Label) {
        this.Renrakusaki2Label=Renrakusaki2Label;
    }

    @JsonProperty("Renrakusaki2Text")
    public TextBox getRenrakusaki2Text() {
        return Renrakusaki2Text;
    }

    @JsonProperty("Renrakusaki2Text")
    public void setRenrakusaki2Text(TextBox Renrakusaki2Text) {
        this.Renrakusaki2Text=Renrakusaki2Text;
    }

}
