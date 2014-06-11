package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
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
 * ShujiiIkenshoDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoDetailDiv extends Panel {
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
    private TextBoxDate txtShujiiIkenshoKinyuYMD;
    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    private TextBoxDate txtShujiiIkenshoJuryoYMD;
    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    private TextBoxDate txtShujiiIkenshoKanryoYMD;

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
    public TextBoxDate getTxtShujiiIkenshoKinyuYMD() {
        return txtShujiiIkenshoKinyuYMD;
    }

    @JsonProperty("txtShujiiIkenshoKinyuYMD")
    public void setTxtShujiiIkenshoKinyuYMD(TextBoxDate txtShujiiIkenshoKinyuYMD) {
        this.txtShujiiIkenshoKinyuYMD=txtShujiiIkenshoKinyuYMD;
    }

    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    public TextBoxDate getTxtShujiiIkenshoJuryoYMD() {
        return txtShujiiIkenshoJuryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoJuryoYMD")
    public void setTxtShujiiIkenshoJuryoYMD(TextBoxDate txtShujiiIkenshoJuryoYMD) {
        this.txtShujiiIkenshoJuryoYMD=txtShujiiIkenshoJuryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    public TextBoxDate getTxtShujiiIkenshoKanryoYMD() {
        return txtShujiiIkenshoKanryoYMD;
    }

    @JsonProperty("txtShujiiIkenshoKanryoYMD")
    public void setTxtShujiiIkenshoKanryoYMD(TextBoxDate txtShujiiIkenshoKanryoYMD) {
        this.txtShujiiIkenshoKanryoYMD=txtShujiiIkenshoKanryoYMD;
    }

}
