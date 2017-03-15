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
    @JsonProperty("IkenshoMessage")
    private IkenshoMessageDiv IkenshoMessage;

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
     * getIkenshoMessage
     * @return IkenshoMessage
     */
    @JsonProperty("IkenshoMessage")
    public IkenshoMessageDiv getIkenshoMessage() {
        return IkenshoMessage;
    }

    /*
     * setIkenshoMessage
     * @param IkenshoMessage IkenshoMessage
     */
    @JsonProperty("IkenshoMessage")
    public void setIkenshoMessage(IkenshoMessageDiv IkenshoMessage) {
        this.IkenshoMessage = IkenshoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblIkenshoMessage() {
        return this.getIkenshoMessage().getLblIkenshoMessage();
    }

    @JsonIgnore
    public void  setLblIkenshoMessage(Label lblIkenshoMessage) {
        this.getIkenshoMessage().setLblIkenshoMessage(lblIkenshoMessage);
    }

    // </editor-fold>
}
