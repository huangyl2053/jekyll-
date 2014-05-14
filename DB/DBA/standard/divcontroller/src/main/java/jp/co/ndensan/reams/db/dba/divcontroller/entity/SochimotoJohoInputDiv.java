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
    private TextBoxCode txtSochimotoHihokenshaNo;
    @JsonProperty("txtSochimotoHokenshaNo")
    private TextBoxCode txtSochimotoHokenshaNo;
    @JsonProperty("btnHokenshaSelect")
    private ButtonDialog btnHokenshaSelect;
    @JsonProperty("txtSochimotoHokenshaMeisho")
    private TextBox txtSochimotoHokenshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSochimotoHihokenshaNo")
    public TextBoxCode getTxtSochimotoHihokenshaNo() {
        return txtSochimotoHihokenshaNo;
    }

    @JsonProperty("txtSochimotoHihokenshaNo")
    public void setTxtSochimotoHihokenshaNo(TextBoxCode txtSochimotoHihokenshaNo) {
        this.txtSochimotoHihokenshaNo=txtSochimotoHihokenshaNo;
    }

    @JsonProperty("txtSochimotoHokenshaNo")
    public TextBoxCode getTxtSochimotoHokenshaNo() {
        return txtSochimotoHokenshaNo;
    }

    @JsonProperty("txtSochimotoHokenshaNo")
    public void setTxtSochimotoHokenshaNo(TextBoxCode txtSochimotoHokenshaNo) {
        this.txtSochimotoHokenshaNo=txtSochimotoHokenshaNo;
    }

    @JsonProperty("btnHokenshaSelect")
    public ButtonDialog getBtnHokenshaSelect() {
        return btnHokenshaSelect;
    }

    @JsonProperty("btnHokenshaSelect")
    public void setBtnHokenshaSelect(ButtonDialog btnHokenshaSelect) {
        this.btnHokenshaSelect=btnHokenshaSelect;
    }

    @JsonProperty("txtSochimotoHokenshaMeisho")
    public TextBox getTxtSochimotoHokenshaMeisho() {
        return txtSochimotoHokenshaMeisho;
    }

    @JsonProperty("txtSochimotoHokenshaMeisho")
    public void setTxtSochimotoHokenshaMeisho(TextBox txtSochimotoHokenshaMeisho) {
        this.txtSochimotoHokenshaMeisho=txtSochimotoHokenshaMeisho;
    }

}
