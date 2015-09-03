package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken.IShobyoIkenDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShobyoIken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShobyoIkenDiv extends Panel implements IShobyoIkenDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShindanName")
    private ShindanNameDiv ShindanName;
    @JsonProperty("ShojoAnteisei")
    private ShojoAnteiseiDiv ShojoAnteisei;
    @JsonProperty("SeikatsuKinoGenin")
    private SeikatsuKinoGeninDiv SeikatsuKinoGenin;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnCansel")
    private Button btnCansel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShindanName")
    public ShindanNameDiv getShindanName() {
        return ShindanName;
    }

    @JsonProperty("ShindanName")
    public void setShindanName(ShindanNameDiv ShindanName) {
        this.ShindanName=ShindanName;
    }

    @JsonProperty("ShojoAnteisei")
    public ShojoAnteiseiDiv getShojoAnteisei() {
        return ShojoAnteisei;
    }

    @JsonProperty("ShojoAnteisei")
    public void setShojoAnteisei(ShojoAnteiseiDiv ShojoAnteisei) {
        this.ShojoAnteisei=ShojoAnteisei;
    }

    @JsonProperty("SeikatsuKinoGenin")
    public SeikatsuKinoGeninDiv getSeikatsuKinoGenin() {
        return SeikatsuKinoGenin;
    }

    @JsonProperty("SeikatsuKinoGenin")
    public void setSeikatsuKinoGenin(SeikatsuKinoGeninDiv SeikatsuKinoGenin) {
        this.SeikatsuKinoGenin=SeikatsuKinoGenin;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnCansel")
    public Button getBtnCansel() {
        return btnCansel;
    }

    @JsonProperty("btnCansel")
    public void setBtnCansel(Button btnCansel) {
        this.btnCansel=btnCansel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShindanName1() {
        return this.getShindanName().getTxtShindanName1();
    }

    @JsonIgnore
    public void  setTxtShindanName1(TextBox txtShindanName1) {
        this.getShindanName().setTxtShindanName1(txtShindanName1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD1() {
        return this.getShindanName().getTxtShindanYMD1();
    }

    @JsonIgnore
    public void  setTxtShindanYMD1(TextBoxDate txtShindanYMD1) {
        this.getShindanName().setTxtShindanYMD1(txtShindanYMD1);
    }

    @JsonIgnore
    public TextBox getTxtShindanName2() {
        return this.getShindanName().getTxtShindanName2();
    }

    @JsonIgnore
    public void  setTxtShindanName2(TextBox txtShindanName2) {
        this.getShindanName().setTxtShindanName2(txtShindanName2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD2() {
        return this.getShindanName().getTxtShindanYMD2();
    }

    @JsonIgnore
    public void  setTxtShindanYMD2(TextBoxDate txtShindanYMD2) {
        this.getShindanName().setTxtShindanYMD2(txtShindanYMD2);
    }

    @JsonIgnore
    public TextBox getTxtShindanName() {
        return this.getShindanName().getTxtShindanName();
    }

    @JsonIgnore
    public void  setTxtShindanName(TextBox txtShindanName) {
        this.getShindanName().setTxtShindanName(txtShindanName);
    }

    @JsonIgnore
    public TextBoxDate getTxtShindanYMD3() {
        return this.getShindanName().getTxtShindanYMD3();
    }

    @JsonIgnore
    public void  setTxtShindanYMD3(TextBoxDate txtShindanYMD3) {
        this.getShindanName().setTxtShindanYMD3(txtShindanYMD3);
    }

    @JsonIgnore
    public ButtonDialog getBtnShuyoShippeiGuide() {
        return this.getShindanName().getBtnShuyoShippeiGuide();
    }

    @JsonIgnore
    public void  setBtnShuyoShippeiGuide(ButtonDialog btnShuyoShippeiGuide) {
        this.getShindanName().setBtnShuyoShippeiGuide(btnShuyoShippeiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShuyoShippeiCode() {
        return this.getShindanName().getTxtShuyoShippeiCode();
    }

    @JsonIgnore
    public void  setTxtShuyoShippeiCode(TextBox txtShuyoShippeiCode) {
        this.getShindanName().setTxtShuyoShippeiCode(txtShuyoShippeiCode);
    }

    @JsonIgnore
    public RadioButton getRadShojoAnteisei() {
        return this.getShojoAnteisei().getRadShojoAnteisei();
    }

    @JsonIgnore
    public void  setRadShojoAnteisei(RadioButton radShojoAnteisei) {
        this.getShojoAnteisei().setRadShojoAnteisei(radShojoAnteisei);
    }

    @JsonIgnore
    public TextBox getTxtFuanteiShosaiJokyo() {
        return this.getShojoAnteisei().getTxtFuanteiShosaiJokyo();
    }

    @JsonIgnore
    public void  setTxtFuanteiShosaiJokyo(TextBox txtFuanteiShosaiJokyo) {
        this.getShojoAnteisei().setTxtFuanteiShosaiJokyo(txtFuanteiShosaiJokyo);
    }

    @JsonIgnore
    public Label getLblChiryoNaiyo() {
        return this.getSeikatsuKinoGenin().getLblChiryoNaiyo();
    }

    @JsonIgnore
    public void  setLblChiryoNaiyo(Label lblChiryoNaiyo) {
        this.getSeikatsuKinoGenin().setLblChiryoNaiyo(lblChiryoNaiyo);
    }

    @JsonIgnore
    public StaticImage getImgChiryoNaiyo() {
        return this.getSeikatsuKinoGenin().getImgChiryoNaiyo();
    }

    @JsonIgnore
    public void  setImgChiryoNaiyo(StaticImage imgChiryoNaiyo) {
        this.getSeikatsuKinoGenin().setImgChiryoNaiyo(imgChiryoNaiyo);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
