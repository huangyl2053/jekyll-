package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * SearchCriteriaOfHihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchCriteriaOfHihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHihokenshaNo")
    private Label lblHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("lblHihokenshaKubun")
    private Label lblHihokenshaKubun;
    @JsonProperty("chkHihokenshaKubun")
    private CheckBoxList chkHihokenshaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHihokenshaNo")
    public Label getLblHihokenshaNo() {
        return lblHihokenshaNo;
    }

    @JsonProperty("lblHihokenshaNo")
    public void setLblHihokenshaNo(Label lblHihokenshaNo) {
        this.lblHihokenshaNo=lblHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("lblHihokenshaKubun")
    public Label getLblHihokenshaKubun() {
        return lblHihokenshaKubun;
    }

    @JsonProperty("lblHihokenshaKubun")
    public void setLblHihokenshaKubun(Label lblHihokenshaKubun) {
        this.lblHihokenshaKubun=lblHihokenshaKubun;
    }

    @JsonProperty("chkHihokenshaKubun")
    public CheckBoxList getChkHihokenshaKubun() {
        return chkHihokenshaKubun;
    }

    @JsonProperty("chkHihokenshaKubun")
    public void setChkHihokenshaKubun(CheckBoxList chkHihokenshaKubun) {
        this.chkHihokenshaKubun=chkHihokenshaKubun;
    }

}
