package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001;
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
 * JissiJyokyohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JissiJyokyohyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cyouhyouPanel")
    private cyouhyouPanelDiv cyouhyouPanel;
    @JsonProperty("syukeiPanel")
    private syukeiPanelDiv syukeiPanel;
    @JsonProperty("JokenPanel")
    private JokenPanelDiv JokenPanel;
    @JsonProperty("lblComment1")
    private Label lblComment1;
    @JsonProperty("lblComment3")
    private Label lblComment3;
    @JsonProperty("lblComment2")
    private Label lblComment2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcyouhyouPanel
     * @return cyouhyouPanel
     */
    @JsonProperty("cyouhyouPanel")
    public cyouhyouPanelDiv getCyouhyouPanel() {
        return cyouhyouPanel;
    }

    /*
     * setcyouhyouPanel
     * @param cyouhyouPanel cyouhyouPanel
     */
    @JsonProperty("cyouhyouPanel")
    public void setCyouhyouPanel(cyouhyouPanelDiv cyouhyouPanel) {
        this.cyouhyouPanel = cyouhyouPanel;
    }

    /*
     * getsyukeiPanel
     * @return syukeiPanel
     */
    @JsonProperty("syukeiPanel")
    public syukeiPanelDiv getSyukeiPanel() {
        return syukeiPanel;
    }

    /*
     * setsyukeiPanel
     * @param syukeiPanel syukeiPanel
     */
    @JsonProperty("syukeiPanel")
    public void setSyukeiPanel(syukeiPanelDiv syukeiPanel) {
        this.syukeiPanel = syukeiPanel;
    }

    /*
     * getJokenPanel
     * @return JokenPanel
     */
    @JsonProperty("JokenPanel")
    public JokenPanelDiv getJokenPanel() {
        return JokenPanel;
    }

    /*
     * setJokenPanel
     * @param JokenPanel JokenPanel
     */
    @JsonProperty("JokenPanel")
    public void setJokenPanel(JokenPanelDiv JokenPanel) {
        this.JokenPanel = JokenPanel;
    }

    /*
     * getlblComment1
     * @return lblComment1
     */
    @JsonProperty("lblComment1")
    public Label getLblComment1() {
        return lblComment1;
    }

    /*
     * setlblComment1
     * @param lblComment1 lblComment1
     */
    @JsonProperty("lblComment1")
    public void setLblComment1(Label lblComment1) {
        this.lblComment1 = lblComment1;
    }

    /*
     * getlblComment3
     * @return lblComment3
     */
    @JsonProperty("lblComment3")
    public Label getLblComment3() {
        return lblComment3;
    }

    /*
     * setlblComment3
     * @param lblComment3 lblComment3
     */
    @JsonProperty("lblComment3")
    public void setLblComment3(Label lblComment3) {
        this.lblComment3 = lblComment3;
    }

    /*
     * getlblComment2
     * @return lblComment2
     */
    @JsonProperty("lblComment2")
    public Label getLblComment2() {
        return lblComment2;
    }

    /*
     * setlblComment2
     * @param lblComment2 lblComment2
     */
    @JsonProperty("lblComment2")
    public void setLblComment2(Label lblComment2) {
        this.lblComment2 = lblComment2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public jyoukenPanelDiv getJyoukenPanel() {
        return this.getSyukeiPanel().getJyoukenPanel();
    }

    @JsonIgnore
    public void  setJyoukenPanel(jyoukenPanelDiv jyoukenPanel) {
        this.getSyukeiPanel().setJyoukenPanel(jyoukenPanel);
    }

    @JsonIgnore
    public RadioButton getRdoshinsei() {
        return this.getSyukeiPanel().getRdoshinsei();
    }

    @JsonIgnore
    public void  setRdoshinsei(RadioButton rdoshinsei) {
        this.getSyukeiPanel().setRdoshinsei(rdoshinsei);
    }

    // </editor-fold>
}
