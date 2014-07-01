package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * HonTsuchiKobetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonTsuchiKobetsuJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    private Label lblTokuKaishiTsuchi;
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    private RadioButton radTokuKaishiTsuchiTaisho2;
    @JsonProperty("lblKetteTsuchi")
    private Label lblKetteTsuchi;
    @JsonProperty("txtKetteTsuchiBunshoNo2")
    private TextBox txtKetteTsuchiBunshoNo2;
    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    private Button btnKetteiTsuchiYousikiSettei2;
    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    private TextBox txtKetteiTsuchiYousikiSettei;
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("ddlNotsuShuturyokuki2")
    private DropDownList ddlNotsuShuturyokuki2;
    @JsonProperty("chkNotsuTaishosha2")
    private CheckBoxList chkNotsuTaishosha2;
    @JsonProperty("radNotsuSeikatsuHogo2")
    private RadioButton radNotsuSeikatsuHogo2;
    @JsonProperty("radNotsuYamawake2")
    private RadioButton radNotsuYamawake2;
    @JsonProperty("demoTest")
    private Button demoTest;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public Label getLblTokuKaishiTsuchi() {
        return lblTokuKaishiTsuchi;
    }

    @JsonProperty("lblTokuKaishiTsuchi")
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.lblTokuKaishiTsuchi=lblTokuKaishiTsuchi;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public RadioButton getRadTokuKaishiTsuchiTaisho2() {
        return radTokuKaishiTsuchiTaisho2;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public void setRadTokuKaishiTsuchiTaisho2(RadioButton radTokuKaishiTsuchiTaisho2) {
        this.radTokuKaishiTsuchiTaisho2=radTokuKaishiTsuchiTaisho2;
    }

    @JsonProperty("lblKetteTsuchi")
    public Label getLblKetteTsuchi() {
        return lblKetteTsuchi;
    }

    @JsonProperty("lblKetteTsuchi")
    public void setLblKetteTsuchi(Label lblKetteTsuchi) {
        this.lblKetteTsuchi=lblKetteTsuchi;
    }

    @JsonProperty("txtKetteTsuchiBunshoNo2")
    public TextBox getTxtKetteTsuchiBunshoNo2() {
        return txtKetteTsuchiBunshoNo2;
    }

    @JsonProperty("txtKetteTsuchiBunshoNo2")
    public void setTxtKetteTsuchiBunshoNo2(TextBox txtKetteTsuchiBunshoNo2) {
        this.txtKetteTsuchiBunshoNo2=txtKetteTsuchiBunshoNo2;
    }

    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    public Button getBtnKetteiTsuchiYousikiSettei2() {
        return btnKetteiTsuchiYousikiSettei2;
    }

    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    public void setBtnKetteiTsuchiYousikiSettei2(Button btnKetteiTsuchiYousikiSettei2) {
        this.btnKetteiTsuchiYousikiSettei2=btnKetteiTsuchiYousikiSettei2;
    }

    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    public TextBox getTxtKetteiTsuchiYousikiSettei() {
        return txtKetteiTsuchiYousikiSettei;
    }

    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    public void setTxtKetteiTsuchiYousikiSettei(TextBox txtKetteiTsuchiYousikiSettei) {
        this.txtKetteiTsuchiYousikiSettei=txtKetteiTsuchiYousikiSettei;
    }

    @JsonProperty("lblNotsu")
    public Label getLblNotsu() {
        return lblNotsu;
    }

    @JsonProperty("lblNotsu")
    public void setLblNotsu(Label lblNotsu) {
        this.lblNotsu=lblNotsu;
    }

    @JsonProperty("ddlNotsuShuturyokuki2")
    public DropDownList getDdlNotsuShuturyokuki2() {
        return ddlNotsuShuturyokuki2;
    }

    @JsonProperty("ddlNotsuShuturyokuki2")
    public void setDdlNotsuShuturyokuki2(DropDownList ddlNotsuShuturyokuki2) {
        this.ddlNotsuShuturyokuki2=ddlNotsuShuturyokuki2;
    }

    @JsonProperty("chkNotsuTaishosha2")
    public CheckBoxList getChkNotsuTaishosha2() {
        return chkNotsuTaishosha2;
    }

    @JsonProperty("chkNotsuTaishosha2")
    public void setChkNotsuTaishosha2(CheckBoxList chkNotsuTaishosha2) {
        this.chkNotsuTaishosha2=chkNotsuTaishosha2;
    }

    @JsonProperty("radNotsuSeikatsuHogo2")
    public RadioButton getRadNotsuSeikatsuHogo2() {
        return radNotsuSeikatsuHogo2;
    }

    @JsonProperty("radNotsuSeikatsuHogo2")
    public void setRadNotsuSeikatsuHogo2(RadioButton radNotsuSeikatsuHogo2) {
        this.radNotsuSeikatsuHogo2=radNotsuSeikatsuHogo2;
    }

    @JsonProperty("radNotsuYamawake2")
    public RadioButton getRadNotsuYamawake2() {
        return radNotsuYamawake2;
    }

    @JsonProperty("radNotsuYamawake2")
    public void setRadNotsuYamawake2(RadioButton radNotsuYamawake2) {
        this.radNotsuYamawake2=radNotsuYamawake2;
    }

    @JsonProperty("demoTest")
    public Button getDemoTest() {
        return demoTest;
    }

    @JsonProperty("demoTest")
    public void setDemoTest(Button demoTest) {
        this.demoTest=demoTest;
    }

}
