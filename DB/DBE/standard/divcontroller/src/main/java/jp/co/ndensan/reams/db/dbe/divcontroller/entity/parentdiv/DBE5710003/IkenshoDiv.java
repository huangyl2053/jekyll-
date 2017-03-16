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
 * Ikensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkIkensho")
    private CheckBoxList chkIkensho;
    @JsonProperty("radIkenshoDeleteTarget")
    private RadioButton radIkenshoDeleteTarget;
    @JsonProperty("IkenshoMessage1")
    private IkenshoMessage1Div IkenshoMessage1;
    @JsonProperty("IkenshoMessage2")
    private IkenshoMessage2Div IkenshoMessage2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkIkensho
     * @return chkIkensho
     */
    @JsonProperty("chkIkensho")
    public CheckBoxList getChkIkensho() {
        return chkIkensho;
    }

    /*
     * setchkIkensho
     * @param chkIkensho chkIkensho
     */
    @JsonProperty("chkIkensho")
    public void setChkIkensho(CheckBoxList chkIkensho) {
        this.chkIkensho = chkIkensho;
    }

    /*
     * getradIkenshoDeleteTarget
     * @return radIkenshoDeleteTarget
     */
    @JsonProperty("radIkenshoDeleteTarget")
    public RadioButton getRadIkenshoDeleteTarget() {
        return radIkenshoDeleteTarget;
    }

    /*
     * setradIkenshoDeleteTarget
     * @param radIkenshoDeleteTarget radIkenshoDeleteTarget
     */
    @JsonProperty("radIkenshoDeleteTarget")
    public void setRadIkenshoDeleteTarget(RadioButton radIkenshoDeleteTarget) {
        this.radIkenshoDeleteTarget = radIkenshoDeleteTarget;
    }

    /*
     * getIkenshoMessage1
     * @return IkenshoMessage1
     */
    @JsonProperty("IkenshoMessage1")
    public IkenshoMessage1Div getIkenshoMessage1() {
        return IkenshoMessage1;
    }

    /*
     * setIkenshoMessage1
     * @param IkenshoMessage1 IkenshoMessage1
     */
    @JsonProperty("IkenshoMessage1")
    public void setIkenshoMessage1(IkenshoMessage1Div IkenshoMessage1) {
        this.IkenshoMessage1 = IkenshoMessage1;
    }

    /*
     * getIkenshoMessage2
     * @return IkenshoMessage2
     */
    @JsonProperty("IkenshoMessage2")
    public IkenshoMessage2Div getIkenshoMessage2() {
        return IkenshoMessage2;
    }

    /*
     * setIkenshoMessage2
     * @param IkenshoMessage2 IkenshoMessage2
     */
    @JsonProperty("IkenshoMessage2")
    public void setIkenshoMessage2(IkenshoMessage2Div IkenshoMessage2) {
        this.IkenshoMessage2 = IkenshoMessage2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblIkenshoMessage1() {
        return this.getIkenshoMessage1().getLblIkenshoMessage1();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage1(Label lblIkenshoMessage1) {
        this.getIkenshoMessage1().setLblIkenshoMessage1(lblIkenshoMessage1);
    }

    @JsonIgnore
    public Label getLblIkenshoMessage2() {
        return this.getIkenshoMessage2().getLblIkenshoMessage2();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage2(Label lblIkenshoMessage2) {
        this.getIkenshoMessage2().setLblIkenshoMessage2(lblIkenshoMessage2);
    }

    // </editor-fold>
}
