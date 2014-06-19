package jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SetaiShotokuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SetaiShotokuIchiranDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    private TextBoxDate txtSetaiIchiranKijunYMD;
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    private TextBox txtSetaiIchiranKazeiNendo;
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    private DropDownList ddlSetaiIchiranKazeiNendo;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("txtSetaiIchiranSetaiCode")
    private TextBoxCode txtSetaiIchiranSetaiCode;
    @JsonProperty("chkSetaiIchiranAll")
    private CheckBoxList chkSetaiIchiranAll;
    @JsonProperty("lblSetaiIchiranMsg")
    private Label lblSetaiIchiranMsg;
    @JsonProperty("btnNarabeteHyoji")
    private Button btnNarabeteHyoji;
    @JsonProperty("dgSetaiShotoku")
    private DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    public TextBoxDate getTxtSetaiIchiranKijunYMD() {
        return txtSetaiIchiranKijunYMD;
    }

    @JsonProperty("txtSetaiIchiranKijunYMD")
    public void setTxtSetaiIchiranKijunYMD(TextBoxDate txtSetaiIchiranKijunYMD) {
        this.txtSetaiIchiranKijunYMD=txtSetaiIchiranKijunYMD;
    }

    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public TextBox getTxtSetaiIchiranKazeiNendo() {
        return txtSetaiIchiranKazeiNendo;
    }

    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public void setTxtSetaiIchiranKazeiNendo(TextBox txtSetaiIchiranKazeiNendo) {
        this.txtSetaiIchiranKazeiNendo=txtSetaiIchiranKazeiNendo;
    }

    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public DropDownList getDdlSetaiIchiranKazeiNendo() {
        return ddlSetaiIchiranKazeiNendo;
    }

    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public void setDdlSetaiIchiranKazeiNendo(DropDownList ddlSetaiIchiranKazeiNendo) {
        this.ddlSetaiIchiranKazeiNendo=ddlSetaiIchiranKazeiNendo;
    }

    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji=btnSaiHyoji;
    }

    @JsonProperty("txtSetaiIchiranSetaiCode")
    public TextBoxCode getTxtSetaiIchiranSetaiCode() {
        return txtSetaiIchiranSetaiCode;
    }

    @JsonProperty("txtSetaiIchiranSetaiCode")
    public void setTxtSetaiIchiranSetaiCode(TextBoxCode txtSetaiIchiranSetaiCode) {
        this.txtSetaiIchiranSetaiCode=txtSetaiIchiranSetaiCode;
    }

    @JsonProperty("chkSetaiIchiranAll")
    public CheckBoxList getChkSetaiIchiranAll() {
        return chkSetaiIchiranAll;
    }

    @JsonProperty("chkSetaiIchiranAll")
    public void setChkSetaiIchiranAll(CheckBoxList chkSetaiIchiranAll) {
        this.chkSetaiIchiranAll=chkSetaiIchiranAll;
    }

    @JsonProperty("lblSetaiIchiranMsg")
    public Label getLblSetaiIchiranMsg() {
        return lblSetaiIchiranMsg;
    }

    @JsonProperty("lblSetaiIchiranMsg")
    public void setLblSetaiIchiranMsg(Label lblSetaiIchiranMsg) {
        this.lblSetaiIchiranMsg=lblSetaiIchiranMsg;
    }

    @JsonProperty("btnNarabeteHyoji")
    public Button getBtnNarabeteHyoji() {
        return btnNarabeteHyoji;
    }

    @JsonProperty("btnNarabeteHyoji")
    public void setBtnNarabeteHyoji(Button btnNarabeteHyoji) {
        this.btnNarabeteHyoji=btnNarabeteHyoji;
    }

    @JsonProperty("dgSetaiShotoku")
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return dgSetaiShotoku;
    }

    @JsonProperty("dgSetaiShotoku")
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.dgSetaiShotoku=dgSetaiShotoku;
    }

}
