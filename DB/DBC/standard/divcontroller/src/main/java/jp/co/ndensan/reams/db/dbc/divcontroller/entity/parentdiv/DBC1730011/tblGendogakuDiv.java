package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * tblGendogaku のクラスファイル
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class tblGendogakuDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celGendogaku1")
    private celGendogaku1AttblGendogaku celGendogaku1;
    @JsonProperty("celGendogaku2")
    private celGendogaku2AttblGendogaku celGendogaku2;
    @JsonProperty("celGendogaku3")
    private celGendogaku3AttblGendogaku celGendogaku3;
    @JsonProperty("celGendogaku4")
    private celGendogaku4AttblGendogaku celGendogaku4;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblMessage3() {
        return this.celGendogaku1.getLblMessage3();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.celGendogaku1.getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi9() {
        return this.celGendogaku2.getLblMidashi9();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.celGendogaku2.getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi10() {
        return this.celGendogaku3.getLblMidashi10();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.celGendogaku3.getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi5() {
        return this.celGendogaku4.getLblMidashi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtNijiYobo() {
        return this.celGendogaku4.getTxtNijiYobo();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelGendogaku1
     * @return celGendogaku1
     */
    @JsonProperty("celGendogaku1")
    private celGendogaku1AttblGendogaku getCelGendogaku1() {
        return celGendogaku1;
    }

    /*
     * setcelGendogaku1
     * @param celGendogaku1 celGendogaku1
     */
    @JsonProperty("celGendogaku1")
    private void setCelGendogaku1(celGendogaku1AttblGendogaku celGendogaku1) {
        this.celGendogaku1 = celGendogaku1;
    }

    /*
     * getcelGendogaku2
     * @return celGendogaku2
     */
    @JsonProperty("celGendogaku2")
    private celGendogaku2AttblGendogaku getCelGendogaku2() {
        return celGendogaku2;
    }

    /*
     * setcelGendogaku2
     * @param celGendogaku2 celGendogaku2
     */
    @JsonProperty("celGendogaku2")
    private void setCelGendogaku2(celGendogaku2AttblGendogaku celGendogaku2) {
        this.celGendogaku2 = celGendogaku2;
    }

    /*
     * getcelGendogaku3
     * @return celGendogaku3
     */
    @JsonProperty("celGendogaku3")
    private celGendogaku3AttblGendogaku getCelGendogaku3() {
        return celGendogaku3;
    }

    /*
     * setcelGendogaku3
     * @param celGendogaku3 celGendogaku3
     */
    @JsonProperty("celGendogaku3")
    private void setCelGendogaku3(celGendogaku3AttblGendogaku celGendogaku3) {
        this.celGendogaku3 = celGendogaku3;
    }

    /*
     * getcelGendogaku4
     * @return celGendogaku4
     */
    @JsonProperty("celGendogaku4")
    private celGendogaku4AttblGendogaku getCelGendogaku4() {
        return celGendogaku4;
    }

    /*
     * setcelGendogaku4
     * @param celGendogaku4 celGendogaku4
     */
    @JsonProperty("celGendogaku4")
    private void setCelGendogaku4(celGendogaku4AttblGendogaku celGendogaku4) {
        this.celGendogaku4 = celGendogaku4;
    }

    // </editor-fold>
}

/**
 * celGendogaku1 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku1AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblMessage3")
    private Label lblMessage3;
    @JsonProperty("lblMidashi1")
    private Label lblMidashi1;

    /*
     * getlblMessage3
     * @return lblMessage3
     */
    @JsonProperty("lblMessage3")
    public Label getLblMessage3() {
        return lblMessage3;
    }

    /*
     * setlblMessage3
     * @param lblMessage3 lblMessage3
     */
    @JsonProperty("lblMessage3")
    public void setLblMessage3(Label lblMessage3) {
        this.lblMessage3 = lblMessage3;
    }

    /*
     * getlblMidashi1
     * @return lblMidashi1
     */
    @JsonProperty("lblMidashi1")
    public Label getLblMidashi1() {
        return lblMidashi1;
    }

    /*
     * setlblMidashi1
     * @param lblMidashi1 lblMidashi1
     */
    @JsonProperty("lblMidashi1")
    public void setLblMidashi1(Label lblMidashi1) {
        this.lblMidashi1 = lblMidashi1;
    }

    // </editor-fold>
}

/**
 * celGendogaku2 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku2AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblMidashi9")
    private Label lblMidashi9;
    @JsonProperty("txtYoShien1")
    private TextBoxNum txtYoShien1;

    /*
     * getlblMidashi9
     * @return lblMidashi9
     */
    @JsonProperty("lblMidashi9")
    public Label getLblMidashi9() {
        return lblMidashi9;
    }

    /*
     * setlblMidashi9
     * @param lblMidashi9 lblMidashi9
     */
    @JsonProperty("lblMidashi9")
    public void setLblMidashi9(Label lblMidashi9) {
        this.lblMidashi9 = lblMidashi9;
    }

    /*
     * gettxtYoShien1
     * @return txtYoShien1
     */
    @JsonProperty("txtYoShien1")
    public TextBoxNum getTxtYoShien1() {
        return txtYoShien1;
    }

    /*
     * settxtYoShien1
     * @param txtYoShien1 txtYoShien1
     */
    @JsonProperty("txtYoShien1")
    public void setTxtYoShien1(TextBoxNum txtYoShien1) {
        this.txtYoShien1 = txtYoShien1;
    }

    // </editor-fold>
}

/**
 * celGendogaku3 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku3AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblMidashi10")
    private Label lblMidashi10;
    @JsonProperty("txtYoShien2")
    private TextBoxNum txtYoShien2;

    /*
     * getlblMidashi10
     * @return lblMidashi10
     */
    @JsonProperty("lblMidashi10")
    public Label getLblMidashi10() {
        return lblMidashi10;
    }

    /*
     * setlblMidashi10
     * @param lblMidashi10 lblMidashi10
     */
    @JsonProperty("lblMidashi10")
    public void setLblMidashi10(Label lblMidashi10) {
        this.lblMidashi10 = lblMidashi10;
    }

    /*
     * gettxtYoShien2
     * @return txtYoShien2
     */
    @JsonProperty("txtYoShien2")
    public TextBoxNum getTxtYoShien2() {
        return txtYoShien2;
    }

    /*
     * settxtYoShien2
     * @param txtYoShien2 txtYoShien2
     */
    @JsonProperty("txtYoShien2")
    public void setTxtYoShien2(TextBoxNum txtYoShien2) {
        this.txtYoShien2 = txtYoShien2;
    }

    // </editor-fold>
}

/**
 * celGendogaku4 のクラスファイル
 *
 * @author 自動生成
 */
class celGendogaku4AttblGendogaku extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblMidashi5")
    private Label lblMidashi5;
    @JsonProperty("txtNijiYobo")
    private TextBoxNum txtNijiYobo;

    /*
     * getlblMidashi5
     * @return lblMidashi5
     */
    @JsonProperty("lblMidashi5")
    public Label getLblMidashi5() {
        return lblMidashi5;
    }

    /*
     * setlblMidashi5
     * @param lblMidashi5 lblMidashi5
     */
    @JsonProperty("lblMidashi5")
    public void setLblMidashi5(Label lblMidashi5) {
        this.lblMidashi5 = lblMidashi5;
    }

    /*
     * gettxtNijiYobo
     * @return txtNijiYobo
     */
    @JsonProperty("txtNijiYobo")
    public TextBoxNum getTxtNijiYobo() {
        return txtNijiYobo;
    }

    /*
     * settxtNijiYobo
     * @param txtNijiYobo txtNijiYobo
     */
    @JsonProperty("txtNijiYobo")
    public void setTxtNijiYobo(TextBoxNum txtNijiYobo) {
        this.txtNijiYobo = txtNijiYobo;
    }

    // </editor-fold>
}
