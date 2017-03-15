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
    @JsonProperty("SonotaMessage")
    private SonotaMessageDiv SonotaMessage;

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
     * getSonotaMessage
     * @return SonotaMessage
     */
    @JsonProperty("SonotaMessage")
    public SonotaMessageDiv getSonotaMessage() {
        return SonotaMessage;
    }

    /*
     * setSonotaMessage
     * @param SonotaMessage SonotaMessage
     */
    @JsonProperty("SonotaMessage")
    public void setSonotaMessage(SonotaMessageDiv SonotaMessage) {
        this.SonotaMessage = SonotaMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSonotaMessage() {
        return this.getSonotaMessage().getLblSonotaMessage();
    }

    @JsonIgnore
    public void  setLblSonotaMessage(Label lblSonotaMessage) {
        this.getSonotaMessage().setLblSonotaMessage(lblSonotaMessage);
    }

    // </editor-fold>
}
