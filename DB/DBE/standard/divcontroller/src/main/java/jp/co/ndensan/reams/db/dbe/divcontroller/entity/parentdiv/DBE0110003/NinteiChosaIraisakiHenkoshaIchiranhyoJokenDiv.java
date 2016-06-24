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
 * NinteiChosaIraisakiHenkoshaIchiranhyoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIraisakiHenkoshaIchiranhyoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    private CheckBoxList chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    @JsonProperty("lblJoken2")
    private Label lblJoken2;
    @JsonProperty("txtIraisakiHenkoshaIchiranShinseiYMD")
    private TextBoxDateRange txtIraisakiHenkoshaIchiranShinseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     * @return chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     */
    @JsonProperty("chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    public CheckBoxList getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken() {
        return chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    }

    /*
     * setchkNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     * @param chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     */
    @JsonProperty("chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    public void setChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken(CheckBoxList chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken) {
        this.chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken = chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    }

    /*
     * getlblJoken2
     * @return lblJoken2
     */
    @JsonProperty("lblJoken2")
    public Label getLblJoken2() {
        return lblJoken2;
    }

    /*
     * setlblJoken2
     * @param lblJoken2 lblJoken2
     */
    @JsonProperty("lblJoken2")
    public void setLblJoken2(Label lblJoken2) {
        this.lblJoken2 = lblJoken2;
    }

    /*
     * gettxtIraisakiHenkoshaIchiranShinseiYMD
     * @return txtIraisakiHenkoshaIchiranShinseiYMD
     */
    @JsonProperty("txtIraisakiHenkoshaIchiranShinseiYMD")
    public TextBoxDateRange getTxtIraisakiHenkoshaIchiranShinseiYMD() {
        return txtIraisakiHenkoshaIchiranShinseiYMD;
    }

    /*
     * settxtIraisakiHenkoshaIchiranShinseiYMD
     * @param txtIraisakiHenkoshaIchiranShinseiYMD txtIraisakiHenkoshaIchiranShinseiYMD
     */
    @JsonProperty("txtIraisakiHenkoshaIchiranShinseiYMD")
    public void setTxtIraisakiHenkoshaIchiranShinseiYMD(TextBoxDateRange txtIraisakiHenkoshaIchiranShinseiYMD) {
        this.txtIraisakiHenkoshaIchiranShinseiYMD = txtIraisakiHenkoshaIchiranShinseiYMD;
    }

    // </editor-fold>
}
