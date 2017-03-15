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
    @JsonProperty("ChosahyoMessage")
    private ChosahyoMessageDiv ChosahyoMessage;

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
     * getChosahyoMessage
     * @return ChosahyoMessage
     */
    @JsonProperty("ChosahyoMessage")
    public ChosahyoMessageDiv getChosahyoMessage() {
        return ChosahyoMessage;
    }

    /*
     * setChosahyoMessage
     * @param ChosahyoMessage ChosahyoMessage
     */
    @JsonProperty("ChosahyoMessage")
    public void setChosahyoMessage(ChosahyoMessageDiv ChosahyoMessage) {
        this.ChosahyoMessage = ChosahyoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChosahyoMessage() {
        return this.getChosahyoMessage().getLblChosahyoMessage();
    }

    @JsonIgnore
    public void  setLblChosahyoMessage(Label lblChosahyoMessage) {
        this.getChosahyoMessage().setLblChosahyoMessage(lblChosahyoMessage);
    }

    // </editor-fold>
}
