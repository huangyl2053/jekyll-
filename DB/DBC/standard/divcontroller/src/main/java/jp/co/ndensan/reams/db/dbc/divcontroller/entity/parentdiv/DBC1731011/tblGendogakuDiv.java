package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblGendogaku のクラスファイル 
 * 
 * @author 自動生成
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
    public Label getLblMidashi5() {
        return this.celGendogaku1.getLblMidashi5();
    }

    @JsonIgnore
    public Label getLblMidashi1() {
        return this.celGendogaku1.getLblMidashi1();
    }

    @JsonIgnore
    public Label getLblMidashi2() {
        return this.celGendogaku2.getLblMidashi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien1() {
        return this.celGendogaku2.getTxtYoShien1();
    }

    @JsonIgnore
    public Label getLblMidashi3() {
        return this.celGendogaku3.getLblMidashi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoShien2() {
        return this.celGendogaku3.getTxtYoShien2();
    }

    @JsonIgnore
    public Label getLblMidashi4() {
        return this.celGendogaku4.getLblMidashi4();
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
    @JsonProperty("lblMidashi5")
    private Label lblMidashi5;
    @JsonProperty("lblMidashi1")
    private Label lblMidashi1;

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
    @JsonProperty("lblMidashi2")
    private Label lblMidashi2;
    @JsonProperty("txtYoShien1")
    private TextBoxNum txtYoShien1;

    /*
     * getlblMidashi2
     * @return lblMidashi2
     */
    @JsonProperty("lblMidashi2")
    public Label getLblMidashi2() {
        return lblMidashi2;
    }

    /*
     * setlblMidashi2
     * @param lblMidashi2 lblMidashi2
     */
    @JsonProperty("lblMidashi2")
    public void setLblMidashi2(Label lblMidashi2) {
        this.lblMidashi2 = lblMidashi2;
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
    @JsonProperty("lblMidashi3")
    private Label lblMidashi3;
    @JsonProperty("txtYoShien2")
    private TextBoxNum txtYoShien2;

    /*
     * getlblMidashi3
     * @return lblMidashi3
     */
    @JsonProperty("lblMidashi3")
    public Label getLblMidashi3() {
        return lblMidashi3;
    }

    /*
     * setlblMidashi3
     * @param lblMidashi3 lblMidashi3
     */
    @JsonProperty("lblMidashi3")
    public void setLblMidashi3(Label lblMidashi3) {
        this.lblMidashi3 = lblMidashi3;
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
    @JsonProperty("lblMidashi4")
    private Label lblMidashi4;
    @JsonProperty("txtNijiYobo")
    private TextBoxNum txtNijiYobo;

    /*
     * getlblMidashi4
     * @return lblMidashi4
     */
    @JsonProperty("lblMidashi4")
    public Label getLblMidashi4() {
        return lblMidashi4;
    }

    /*
     * setlblMidashi4
     * @param lblMidashi4 lblMidashi4
     */
    @JsonProperty("lblMidashi4")
    public void setLblMidashi4(Label lblMidashi4) {
        this.lblMidashi4 = lblMidashi4;
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
