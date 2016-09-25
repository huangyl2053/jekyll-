package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenA のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenADiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RadioButtonA")
    private RadioButtonADiv RadioButtonA;
    @JsonProperty("ChushutsuShosaiA")
    private ChushutsuShosaiADiv ChushutsuShosaiA;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRadioButtonA
     * @return RadioButtonA
     */
    @JsonProperty("RadioButtonA")
    public RadioButtonADiv getRadioButtonA() {
        return RadioButtonA;
    }

    /*
     * setRadioButtonA
     * @param RadioButtonA RadioButtonA
     */
    @JsonProperty("RadioButtonA")
    public void setRadioButtonA(RadioButtonADiv RadioButtonA) {
        this.RadioButtonA = RadioButtonA;
    }

    /*
     * getChushutsuShosaiA
     * @return ChushutsuShosaiA
     */
    @JsonProperty("ChushutsuShosaiA")
    public ChushutsuShosaiADiv getChushutsuShosaiA() {
        return ChushutsuShosaiA;
    }

    /*
     * setChushutsuShosaiA
     * @param ChushutsuShosaiA ChushutsuShosaiA
     */
    @JsonProperty("ChushutsuShosaiA")
    public void setChushutsuShosaiA(ChushutsuShosaiADiv ChushutsuShosaiA) {
        this.ChushutsuShosaiA = ChushutsuShosaiA;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuJokenA1() {
        return this.getRadioButtonA().getRadChushutsuJokenA1();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenA1(RadioButton radChushutsuJokenA1) {
        this.getRadioButtonA().setRadChushutsuJokenA1(radChushutsuJokenA1);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJokenA2() {
        return this.getRadioButtonA().getRadChushutsuJokenA2();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenA2(RadioButton radChushutsuJokenA2) {
        this.getRadioButtonA().setRadChushutsuJokenA2(radChushutsuJokenA2);
    }

    @JsonIgnore
    public DropDownList getDdlKijunNendo() {
        return this.getChushutsuShosaiA().getDdlKijunNendo();
    }

    @JsonIgnore
    public void  setDdlKijunNendo(DropDownList ddlKijunNendo) {
        this.getChushutsuShosaiA().setDdlKijunNendo(ddlKijunNendo);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomiA() {
        return this.getChushutsuShosaiA().getChkChokkinNomiA();
    }

    @JsonIgnore
    public void  setChkChokkinNomiA(CheckBoxList chkChokkinNomiA) {
        this.getChushutsuShosaiA().setChkChokkinNomiA(chkChokkinNomiA);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunDateA() {
        return this.getChushutsuShosaiA().getTxtKijunDateA();
    }

    @JsonIgnore
    public void  setTxtKijunDateA(TextBoxDate txtKijunDateA) {
        this.getChushutsuShosaiA().setTxtKijunDateA(txtKijunDateA);
    }

    @JsonIgnore
    public Label getLblKijyunDateSetumeiA() {
        return this.getChushutsuShosaiA().getLblKijyunDateSetumeiA();
    }

    @JsonIgnore
    public void  setLblKijyunDateSetumeiA(Label lblKijyunDateSetumeiA) {
        this.getChushutsuShosaiA().setLblKijyunDateSetumeiA(lblKijyunDateSetumeiA);
    }

    // </editor-fold>
}
