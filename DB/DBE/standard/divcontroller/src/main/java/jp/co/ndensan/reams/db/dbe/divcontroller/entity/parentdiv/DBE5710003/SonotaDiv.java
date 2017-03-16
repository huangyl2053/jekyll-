package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003;
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
 * Sonota のクラスファイル 
 * 
 * @author 自動生成
 */
public class SonotaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkSonota")
    private CheckBoxList chkSonota;
    @JsonProperty("radSonotaDeleteTarget")
    private RadioButton radSonotaDeleteTarget;
    @JsonProperty("SonotaMessage1")
    private SonotaMessage1Div SonotaMessage1;
    @JsonProperty("SonotaMessage2")
    private SonotaMessage2Div SonotaMessage2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkSonota
     * @return chkSonota
     */
    @JsonProperty("chkSonota")
    public CheckBoxList getChkSonota() {
        return chkSonota;
    }

    /*
     * setchkSonota
     * @param chkSonota chkSonota
     */
    @JsonProperty("chkSonota")
    public void setChkSonota(CheckBoxList chkSonota) {
        this.chkSonota = chkSonota;
    }

    /*
     * getradSonotaDeleteTarget
     * @return radSonotaDeleteTarget
     */
    @JsonProperty("radSonotaDeleteTarget")
    public RadioButton getRadSonotaDeleteTarget() {
        return radSonotaDeleteTarget;
    }

    /*
     * setradSonotaDeleteTarget
     * @param radSonotaDeleteTarget radSonotaDeleteTarget
     */
    @JsonProperty("radSonotaDeleteTarget")
    public void setRadSonotaDeleteTarget(RadioButton radSonotaDeleteTarget) {
        this.radSonotaDeleteTarget = radSonotaDeleteTarget;
    }

    /*
     * getSonotaMessage1
     * @return SonotaMessage1
     */
    @JsonProperty("SonotaMessage1")
    public SonotaMessage1Div getSonotaMessage1() {
        return SonotaMessage1;
    }

    /*
     * setSonotaMessage1
     * @param SonotaMessage1 SonotaMessage1
     */
    @JsonProperty("SonotaMessage1")
    public void setSonotaMessage1(SonotaMessage1Div SonotaMessage1) {
        this.SonotaMessage1 = SonotaMessage1;
    }

    /*
     * getSonotaMessage2
     * @return SonotaMessage2
     */
    @JsonProperty("SonotaMessage2")
    public SonotaMessage2Div getSonotaMessage2() {
        return SonotaMessage2;
    }

    /*
     * setSonotaMessage2
     * @param SonotaMessage2 SonotaMessage2
     */
    @JsonProperty("SonotaMessage2")
    public void setSonotaMessage2(SonotaMessage2Div SonotaMessage2) {
        this.SonotaMessage2 = SonotaMessage2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSonotaMessage1() {
        return this.getSonotaMessage1().getLblSonotaMessage1();
    }

    @JsonIgnore
    public void  setLblSonotaMessage1(Label lblSonotaMessage1) {
        this.getSonotaMessage1().setLblSonotaMessage1(lblSonotaMessage1);
    }

    @JsonIgnore
    public Label getLblSonotaMessage2() {
        return this.getSonotaMessage2().getLblSonotaMessage2();
    }

    @JsonIgnore
    public void  setLblSonotaMessage2(Label lblSonotaMessage2) {
        this.getSonotaMessage2().setLblSonotaMessage2(lblSonotaMessage2);
    }

    // </editor-fold>
}
