package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaYoteiMiteishaIchiranJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaYoteiMiteishaIchiranJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteiChosaYoteiMiteishaIchiran")
    private CheckBoxList chkNinteiChosaYoteiMiteishaIchiran;
    @JsonProperty("lblJoken1")
    private Label lblJoken1;
    @JsonProperty("radJoken1")
    private RadioButton radJoken1;
    @JsonProperty("txtYoteiMiteishaShinseiYMD")
    private TextBoxDateRange txtYoteiMiteishaShinseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteiChosaYoteiMiteishaIchiran
     * @return chkNinteiChosaYoteiMiteishaIchiran
     */
    @JsonProperty("chkNinteiChosaYoteiMiteishaIchiran")
    public CheckBoxList getChkNinteiChosaYoteiMiteishaIchiran() {
        return chkNinteiChosaYoteiMiteishaIchiran;
    }

    /*
     * setchkNinteiChosaYoteiMiteishaIchiran
     * @param chkNinteiChosaYoteiMiteishaIchiran chkNinteiChosaYoteiMiteishaIchiran
     */
    @JsonProperty("chkNinteiChosaYoteiMiteishaIchiran")
    public void setChkNinteiChosaYoteiMiteishaIchiran(CheckBoxList chkNinteiChosaYoteiMiteishaIchiran) {
        this.chkNinteiChosaYoteiMiteishaIchiran = chkNinteiChosaYoteiMiteishaIchiran;
    }

    /*
     * getlblJoken1
     * @return lblJoken1
     */
    @JsonProperty("lblJoken1")
    public Label getLblJoken1() {
        return lblJoken1;
    }

    /*
     * setlblJoken1
     * @param lblJoken1 lblJoken1
     */
    @JsonProperty("lblJoken1")
    public void setLblJoken1(Label lblJoken1) {
        this.lblJoken1 = lblJoken1;
    }

    /*
     * getradJoken1
     * @return radJoken1
     */
    @JsonProperty("radJoken1")
    public RadioButton getRadJoken1() {
        return radJoken1;
    }

    /*
     * setradJoken1
     * @param radJoken1 radJoken1
     */
    @JsonProperty("radJoken1")
    public void setRadJoken1(RadioButton radJoken1) {
        this.radJoken1 = radJoken1;
    }

    /*
     * gettxtYoteiMiteishaShinseiYMD
     * @return txtYoteiMiteishaShinseiYMD
     */
    @JsonProperty("txtYoteiMiteishaShinseiYMD")
    public TextBoxDateRange getTxtYoteiMiteishaShinseiYMD() {
        return txtYoteiMiteishaShinseiYMD;
    }

    /*
     * settxtYoteiMiteishaShinseiYMD
     * @param txtYoteiMiteishaShinseiYMD txtYoteiMiteishaShinseiYMD
     */
    @JsonProperty("txtYoteiMiteishaShinseiYMD")
    public void setTxtYoteiMiteishaShinseiYMD(TextBoxDateRange txtYoteiMiteishaShinseiYMD) {
        this.txtYoteiMiteishaShinseiYMD = txtYoteiMiteishaShinseiYMD;
    }

    // </editor-fold>
}
