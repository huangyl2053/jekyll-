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
 * Chosahyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosahyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosahyo")
    private CheckBoxList chkChosahyo;
    @JsonProperty("radChosahyoDeleteTarget")
    private RadioButton radChosahyoDeleteTarget;
    @JsonProperty("ChosahyoMessage1")
    private ChosahyoMessage1Div ChosahyoMessage1;
    @JsonProperty("ChosahyoMessage2")
    private ChosahyoMessage2Div ChosahyoMessage2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosahyo
     * @return chkChosahyo
     */
    @JsonProperty("chkChosahyo")
    public CheckBoxList getChkChosahyo() {
        return chkChosahyo;
    }

    /*
     * setchkChosahyo
     * @param chkChosahyo chkChosahyo
     */
    @JsonProperty("chkChosahyo")
    public void setChkChosahyo(CheckBoxList chkChosahyo) {
        this.chkChosahyo = chkChosahyo;
    }

    /*
     * getradChosahyoDeleteTarget
     * @return radChosahyoDeleteTarget
     */
    @JsonProperty("radChosahyoDeleteTarget")
    public RadioButton getRadChosahyoDeleteTarget() {
        return radChosahyoDeleteTarget;
    }

    /*
     * setradChosahyoDeleteTarget
     * @param radChosahyoDeleteTarget radChosahyoDeleteTarget
     */
    @JsonProperty("radChosahyoDeleteTarget")
    public void setRadChosahyoDeleteTarget(RadioButton radChosahyoDeleteTarget) {
        this.radChosahyoDeleteTarget = radChosahyoDeleteTarget;
    }

    /*
     * getChosahyoMessage1
     * @return ChosahyoMessage1
     */
    @JsonProperty("ChosahyoMessage1")
    public ChosahyoMessage1Div getChosahyoMessage1() {
        return ChosahyoMessage1;
    }

    /*
     * setChosahyoMessage1
     * @param ChosahyoMessage1 ChosahyoMessage1
     */
    @JsonProperty("ChosahyoMessage1")
    public void setChosahyoMessage1(ChosahyoMessage1Div ChosahyoMessage1) {
        this.ChosahyoMessage1 = ChosahyoMessage1;
    }

    /*
     * getChosahyoMessage2
     * @return ChosahyoMessage2
     */
    @JsonProperty("ChosahyoMessage2")
    public ChosahyoMessage2Div getChosahyoMessage2() {
        return ChosahyoMessage2;
    }

    /*
     * setChosahyoMessage2
     * @param ChosahyoMessage2 ChosahyoMessage2
     */
    @JsonProperty("ChosahyoMessage2")
    public void setChosahyoMessage2(ChosahyoMessage2Div ChosahyoMessage2) {
        this.ChosahyoMessage2 = ChosahyoMessage2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChosahyoMessage1() {
        return this.getChosahyoMessage1().getLblChosahyoMessage1();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage1(Label lblChosahyoMessage1) {
        this.getChosahyoMessage1().setLblChosahyoMessage1(lblChosahyoMessage1);
    }

    @JsonIgnore
    public Label getLblChosahyoMessage2() {
        return this.getChosahyoMessage2().getLblChosahyoMessage2();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage2(Label lblChosahyoMessage2) {
        this.getChosahyoMessage2().setLblChosahyoMessage2(lblChosahyoMessage2);
    }

    // </editor-fold>
}
