package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * SochimotoJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class SochimotoJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSochimotoHihokenshaNo")
    private TextBox txtSochimotoHihokenshaNo;
    @JsonProperty("lblHokensha")
    private Label lblHokensha;
    @JsonProperty("txtSochimotoHokenshaNo")
    private TextBoxCode txtSochimotoHokenshaNo;
    @JsonProperty("txtSochimotoHokenshaMeisho")
    private TextBox txtSochimotoHokenshaMeisho;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSochimotoHihokenshaNo")
    public TextBox getTxtSochimotoHihokenshaNo() {
        return txtSochimotoHihokenshaNo;
    }

    @JsonProperty("txtSochimotoHihokenshaNo")
    public void setTxtSochimotoHihokenshaNo(TextBox txtSochimotoHihokenshaNo) {
        this.txtSochimotoHihokenshaNo=txtSochimotoHihokenshaNo;
    }

    @JsonProperty("lblHokensha")
    public Label getLblHokensha() {
        return lblHokensha;
    }

    @JsonProperty("lblHokensha")
    public void setLblHokensha(Label lblHokensha) {
        this.lblHokensha=lblHokensha;
    }

    @JsonProperty("txtSochimotoHokenshaNo")
    public TextBoxCode getTxtSochimotoHokenshaNo() {
        return txtSochimotoHokenshaNo;
    }

    @JsonProperty("txtSochimotoHokenshaNo")
    public void setTxtSochimotoHokenshaNo(TextBoxCode txtSochimotoHokenshaNo) {
        this.txtSochimotoHokenshaNo=txtSochimotoHokenshaNo;
    }

    @JsonProperty("txtSochimotoHokenshaMeisho")
    public TextBox getTxtSochimotoHokenshaMeisho() {
        return txtSochimotoHokenshaMeisho;
    }

    @JsonProperty("txtSochimotoHokenshaMeisho")
    public void setTxtSochimotoHokenshaMeisho(TextBox txtSochimotoHokenshaMeisho) {
        this.txtSochimotoHokenshaMeisho=txtSochimotoHokenshaMeisho;
    }

    @JsonProperty("btnHokenshaSelect")
    public ButtonDialog getBtnHokenshaSelect() {
        return btnHokenshaSelect;
    }

    @JsonProperty("btnHokenshaSelect")
    public void setBtnHokenshaSelect(ButtonDialog btnHokenshaSelect) {
        this.btnHokenshaSelect=btnHokenshaSelect;
    }

}
