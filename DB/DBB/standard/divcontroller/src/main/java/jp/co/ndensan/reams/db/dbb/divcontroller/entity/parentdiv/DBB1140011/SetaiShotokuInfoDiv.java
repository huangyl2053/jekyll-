package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxFlexibleYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxSetaiCode;

/**
 * SetaiShotokuInfo のクラスファイル
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public class SetaiShotokuInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    private TextBoxDate txtSetaiIchiranKijunYMD;
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    private TextBoxFlexibleYear txtSetaiIchiranKazeiNendo;
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    private DropDownList ddlSetaiIchiranKazeiNendo;
    @JsonProperty("btnSaiHyoji")
    private Button btnSaiHyoji;
    @JsonProperty("txtSetaiIchiranSetaiCode")
    private TextBoxSetaiCode txtSetaiIchiranSetaiCode;
    @JsonProperty("chkSetaiIchiranAll")
    private CheckBoxList chkSetaiIchiranAll;
    @JsonProperty("lblSetaiIchiranMsg")
    private Label lblSetaiIchiranMsg;
    @JsonProperty("dgSetaiShotoku")
    private DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiIchiranKijunYMD
     * @return txtSetaiIchiranKijunYMD
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    public TextBoxDate getTxtSetaiIchiranKijunYMD() {
        return txtSetaiIchiranKijunYMD;
    }

    /*
     * settxtSetaiIchiranKijunYMD
     * @param txtSetaiIchiranKijunYMD txtSetaiIchiranKijunYMD
     */
    @JsonProperty("txtSetaiIchiranKijunYMD")
    public void setTxtSetaiIchiranKijunYMD(TextBoxDate txtSetaiIchiranKijunYMD) {
        this.txtSetaiIchiranKijunYMD = txtSetaiIchiranKijunYMD;
    }

    /*
     * gettxtSetaiIchiranKazeiNendo
     * @return txtSetaiIchiranKazeiNendo
     */
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public TextBoxFlexibleYear getTxtSetaiIchiranKazeiNendo() {
        return txtSetaiIchiranKazeiNendo;
    }

    /*
     * settxtSetaiIchiranKazeiNendo
     * @param txtSetaiIchiranKazeiNendo txtSetaiIchiranKazeiNendo
     */
    @JsonProperty("txtSetaiIchiranKazeiNendo")
    public void setTxtSetaiIchiranKazeiNendo(TextBoxFlexibleYear txtSetaiIchiranKazeiNendo) {
        this.txtSetaiIchiranKazeiNendo = txtSetaiIchiranKazeiNendo;
    }

    /*
     * getddlSetaiIchiranKazeiNendo
     * @return ddlSetaiIchiranKazeiNendo
     */
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public DropDownList getDdlSetaiIchiranKazeiNendo() {
        return ddlSetaiIchiranKazeiNendo;
    }

    /*
     * setddlSetaiIchiranKazeiNendo
     * @param ddlSetaiIchiranKazeiNendo ddlSetaiIchiranKazeiNendo
     */
    @JsonProperty("ddlSetaiIchiranKazeiNendo")
    public void setDdlSetaiIchiranKazeiNendo(DropDownList ddlSetaiIchiranKazeiNendo) {
        this.ddlSetaiIchiranKazeiNendo = ddlSetaiIchiranKazeiNendo;
    }

    /*
     * getbtnSaiHyoji
     * @return btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public Button getBtnSaiHyoji() {
        return btnSaiHyoji;
    }

    /*
     * setbtnSaiHyoji
     * @param btnSaiHyoji btnSaiHyoji
     */
    @JsonProperty("btnSaiHyoji")
    public void setBtnSaiHyoji(Button btnSaiHyoji) {
        this.btnSaiHyoji = btnSaiHyoji;
    }

    /*
     * gettxtSetaiIchiranSetaiCode
     * @return txtSetaiIchiranSetaiCode
     */
    @JsonProperty("txtSetaiIchiranSetaiCode")
    public TextBoxSetaiCode getTxtSetaiIchiranSetaiCode() {
        return txtSetaiIchiranSetaiCode;
    }

    /*
     * settxtSetaiIchiranSetaiCode
     * @param txtSetaiIchiranSetaiCode txtSetaiIchiranSetaiCode
     */
    @JsonProperty("txtSetaiIchiranSetaiCode")
    public void setTxtSetaiIchiranSetaiCode(TextBoxSetaiCode txtSetaiIchiranSetaiCode) {
        this.txtSetaiIchiranSetaiCode = txtSetaiIchiranSetaiCode;
    }

    /*
     * getchkSetaiIchiranAll
     * @return chkSetaiIchiranAll
     */
    @JsonProperty("chkSetaiIchiranAll")
    public CheckBoxList getChkSetaiIchiranAll() {
        return chkSetaiIchiranAll;
    }

    /*
     * setchkSetaiIchiranAll
     * @param chkSetaiIchiranAll chkSetaiIchiranAll
     */
    @JsonProperty("chkSetaiIchiranAll")
    public void setChkSetaiIchiranAll(CheckBoxList chkSetaiIchiranAll) {
        this.chkSetaiIchiranAll = chkSetaiIchiranAll;
    }

    /*
     * getlblSetaiIchiranMsg
     * @return lblSetaiIchiranMsg
     */
    @JsonProperty("lblSetaiIchiranMsg")
    public Label getLblSetaiIchiranMsg() {
        return lblSetaiIchiranMsg;
    }

    /*
     * setlblSetaiIchiranMsg
     * @param lblSetaiIchiranMsg lblSetaiIchiranMsg
     */
    @JsonProperty("lblSetaiIchiranMsg")
    public void setLblSetaiIchiranMsg(Label lblSetaiIchiranMsg) {
        this.lblSetaiIchiranMsg = lblSetaiIchiranMsg;
    }

    /*
     * getdgSetaiShotoku
     * @return dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public DataGrid<dgSetaiShotoku_Row> getDgSetaiShotoku() {
        return dgSetaiShotoku;
    }

    /*
     * setdgSetaiShotoku
     * @param dgSetaiShotoku dgSetaiShotoku
     */
    @JsonProperty("dgSetaiShotoku")
    public void setDgSetaiShotoku(DataGrid<dgSetaiShotoku_Row> dgSetaiShotoku) {
        this.dgSetaiShotoku = dgSetaiShotoku;
    }

    // </editor-fold>
}
