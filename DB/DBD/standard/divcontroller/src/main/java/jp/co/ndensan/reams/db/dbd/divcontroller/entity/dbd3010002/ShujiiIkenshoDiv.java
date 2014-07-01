package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002;
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
 * ShujiiIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShujiiIryokikanCode")
    private TextBoxCode txtShujiiIryokikanCode;
    @JsonProperty("txtShujiIryokikanMeisho")
    private TextBox txtShujiIryokikanMeisho;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujiiMeisho")
    private TextBox txtShujiiMeisho;
    @JsonProperty("txtShujiiIkenshoKinyuYMD")
    private TextBoxFlexibleDate txtShujiiIkenshoKinyuYMD;
    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    private TextBoxFlexibleDate txtShujiiIkenshoJuryoYMD;
    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    private TextBoxFlexibleDate txtShujiiIkenshoKanryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShujiiIryokikanCode")
    public TextBoxCode getTxtShujiiIryokikanCode() {
        return txtShujiiIryokikanCode;
    }

    @JsonProperty("txtShujiiIryokikanCode")
    public void setTxtShujiiIryokikanCode(TextBoxCode txtShujiiIryokikanCode) {
        this.txtShujiiIryokikanCode=txtShujiiIryokikanCode;
    }

    @JsonProperty("txtShujiIryokikanMeisho")
    public TextBox getTxtShujiIryokikanMeisho() {
        return txtShujiIryokikanMeisho;
    }

    @JsonProperty("txtShujiIryokikanMeisho")
    public void setTxtShujiIryokikanMeisho(TextBox txtShujiIryokikanMeisho) {
        this.txtShujiIryokikanMeisho=txtShujiIryokikanMeisho;
    }

    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode=txtShujiiCode;
    }

    @JsonProperty("txtShujiiMeisho")
    public TextBox getTxtShujiiMeisho() {
        return txtShujiiMeisho;
    }

    @JsonProperty("txtShujiiMeisho")
    public void setTxtShujiiMeisho(TextBox txtShujiiMeisho) {
        this.txtShujiiMeisho=txtShujiiMeisho;
    }

    @JsonProperty("txtShujiiIkenshoKinyuYMD")
    public TextBoxFlexibleDate getTxtShujiiIkenshoKinyuYMD() {
        return txtShujiiIkenshoKinyuYMD;
    }

    @JsonProperty("txtShujiiIkenshoKinyuYMD")
    public void setTxtShujiiIkenshoKinyuYMD(TextBoxFlexibleDate txtShujiiIkenshoKinyuYMD) {
        this.txtShujiiIkenshoKinyuYMD=txtShujiiIkenshoKinyuYMD;
    }

    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    public TextBoxFlexibleDate getTxtShujiiIkenshoJuryoYMD() {
        return txtShujiiIkenshoJuryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    public void setTxtShujiiIkenshoJuryoYMD(TextBoxFlexibleDate txtShujiiIkenshoJuryoYMD) {
        this.txtShujiiIkenshoJuryoYMD=txtShujiiIkenshoJuryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    public TextBoxFlexibleDate getTxtShujiiIkenshoKanryoYMD() {
        return txtShujiiIkenshoKanryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    public void setTxtShujiiIkenshoKanryoYMD(TextBoxFlexibleDate txtShujiiIkenshoKanryoYMD) {
        this.txtShujiiIkenshoKanryoYMD=txtShujiiIkenshoKanryoYMD;
    }

}
