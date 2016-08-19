package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0610011;
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
 * tblShikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShikakuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShikakuTitle1")
    private celShikakuTitle1AttblShikaku celShikakuTitle1;
    @JsonProperty("celShikaku1")
    private celShikaku1AttblShikaku celShikaku1;
    @JsonProperty("celTani1")
    private celTani1AttblShikaku celTani1;
    @JsonProperty("celJutoku1")
    private celJutoku1AttblShikaku celJutoku1;
    @JsonProperty("celTani2")
    private celTani2AttblShikaku celTani2;
    @JsonProperty("celShikakuTitle2")
    private celShikakuTitle2AttblShikaku celShikakuTitle2;
    @JsonProperty("celShikaku2")
    private celShikaku2AttblShikaku celShikaku2;
    @JsonProperty("celTani3")
    private celTani3AttblShikaku celTani3;
    @JsonProperty("celJutoku2")
    private celJutoku2AttblShikaku celJutoku2;
    @JsonProperty("celTani4")
    private celTani4AttblShikaku celTani4;
    @JsonProperty("celShikakuTitle3")
    private celShikakuTitle3AttblShikaku celShikakuTitle3;
    @JsonProperty("celShikaku3")
    private celShikaku3AttblShikaku celShikaku3;
    @JsonProperty("celTani5")
    private celTani5AttblShikaku celTani5;
    @JsonProperty("celJutoku3")
    private celJutoku3AttblShikaku celJutoku3;
    @JsonProperty("celTani6")
    private celTani6AttblShikaku celTani6;
    @JsonProperty("celShikakuTitle4")
    private celShikakuTitle4AttblShikaku celShikakuTitle4;
    @JsonProperty("celShikakuTitle5")
    private celShikakuTitle5AttblShikaku celShikakuTitle5;
    @JsonProperty("celJogai")
    private celJogaiAttblShikaku celJogai;
    @JsonProperty("celTani7")
    private celTani7AttblShikaku celTani7;
    @JsonProperty("celShikakuTitle6")
    private celShikakuTitle6AttblShikaku celShikakuTitle6;
    @JsonProperty("celTatoku")
    private celTatokuAttblShikaku celTatoku;
    @JsonProperty("celTani8")
    private celTani8AttblShikaku celTani8;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public ShikakuTitle1Div getShikakuTitle1() {
        return this.celShikakuTitle1.getShikakuTitle1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku1() {
        return this.celShikaku1.getTxtShikaku1();
    }

    @JsonIgnore
    public Label getLblTani1() {
        return this.celTani1.getLblTani1();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku1() {
        return this.celJutoku1.getTxtJutoku1();
    }

    @JsonIgnore
    public Label getLblTani2() {
        return this.celTani2.getLblTani2();
    }

    @JsonIgnore
    public ShikakuTitle2Div getShikakuTitle2() {
        return this.celShikakuTitle2.getShikakuTitle2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku2() {
        return this.celShikaku2.getTxtShikaku2();
    }

    @JsonIgnore
    public Label getLblTani3() {
        return this.celTani3.getLblTani3();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku2() {
        return this.celJutoku2.getTxtJutoku2();
    }

    @JsonIgnore
    public Label getLblTani4() {
        return this.celTani4.getLblTani4();
    }

    @JsonIgnore
    public ShikakuTitle3Div getShikakuTitle3() {
        return this.celShikakuTitle3.getShikakuTitle3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShikaku3() {
        return this.celShikaku3.getTxtShikaku3();
    }

    @JsonIgnore
    public Label getLblTani5() {
        return this.celTani5.getLblTani5();
    }

    @JsonIgnore
    public TextBoxNum getTxtJutoku3() {
        return this.celJutoku3.getTxtJutoku3();
    }

    @JsonIgnore
    public Label getLblTani6() {
        return this.celTani6.getLblTani6();
    }

    @JsonIgnore
    public Label getLblShikakuTitle5() {
        return this.celShikakuTitle5.getLblShikakuTitle5();
    }

    @JsonIgnore
    public TextBoxNum getTxtJogai() {
        return this.celJogai.getTxtJogai();
    }

    @JsonIgnore
    public Label getLblTani7() {
        return this.celTani7.getLblTani7();
    }

    @JsonIgnore
    public Label getLblShikakuTitle6() {
        return this.celShikakuTitle6.getLblShikakuTitle6();
    }

    @JsonIgnore
    public TextBoxNum getTxtTatoku() {
        return this.celTatoku.getTxtTatoku();
    }

    @JsonIgnore
    public Label getLblTani8() {
        return this.celTani8.getLblTani8();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelShikakuTitle1
     * @return celShikakuTitle1
     */
    @JsonProperty("celShikakuTitle1")
    private celShikakuTitle1AttblShikaku getCelShikakuTitle1() {
        return celShikakuTitle1;
    }

    /*
     * setcelShikakuTitle1
     * @param celShikakuTitle1 celShikakuTitle1
     */
    @JsonProperty("celShikakuTitle1")
    private void setCelShikakuTitle1(celShikakuTitle1AttblShikaku celShikakuTitle1) {
        this.celShikakuTitle1 = celShikakuTitle1;
    }

    /*
     * getcelShikaku1
     * @return celShikaku1
     */
    @JsonProperty("celShikaku1")
    private celShikaku1AttblShikaku getCelShikaku1() {
        return celShikaku1;
    }

    /*
     * setcelShikaku1
     * @param celShikaku1 celShikaku1
     */
    @JsonProperty("celShikaku1")
    private void setCelShikaku1(celShikaku1AttblShikaku celShikaku1) {
        this.celShikaku1 = celShikaku1;
    }

    /*
     * getcelTani1
     * @return celTani1
     */
    @JsonProperty("celTani1")
    private celTani1AttblShikaku getCelTani1() {
        return celTani1;
    }

    /*
     * setcelTani1
     * @param celTani1 celTani1
     */
    @JsonProperty("celTani1")
    private void setCelTani1(celTani1AttblShikaku celTani1) {
        this.celTani1 = celTani1;
    }

    /*
     * getcelJutoku1
     * @return celJutoku1
     */
    @JsonProperty("celJutoku1")
    private celJutoku1AttblShikaku getCelJutoku1() {
        return celJutoku1;
    }

    /*
     * setcelJutoku1
     * @param celJutoku1 celJutoku1
     */
    @JsonProperty("celJutoku1")
    private void setCelJutoku1(celJutoku1AttblShikaku celJutoku1) {
        this.celJutoku1 = celJutoku1;
    }

    /*
     * getcelTani2
     * @return celTani2
     */
    @JsonProperty("celTani2")
    private celTani2AttblShikaku getCelTani2() {
        return celTani2;
    }

    /*
     * setcelTani2
     * @param celTani2 celTani2
     */
    @JsonProperty("celTani2")
    private void setCelTani2(celTani2AttblShikaku celTani2) {
        this.celTani2 = celTani2;
    }

    /*
     * getcelShikakuTitle2
     * @return celShikakuTitle2
     */
    @JsonProperty("celShikakuTitle2")
    private celShikakuTitle2AttblShikaku getCelShikakuTitle2() {
        return celShikakuTitle2;
    }

    /*
     * setcelShikakuTitle2
     * @param celShikakuTitle2 celShikakuTitle2
     */
    @JsonProperty("celShikakuTitle2")
    private void setCelShikakuTitle2(celShikakuTitle2AttblShikaku celShikakuTitle2) {
        this.celShikakuTitle2 = celShikakuTitle2;
    }

    /*
     * getcelShikaku2
     * @return celShikaku2
     */
    @JsonProperty("celShikaku2")
    private celShikaku2AttblShikaku getCelShikaku2() {
        return celShikaku2;
    }

    /*
     * setcelShikaku2
     * @param celShikaku2 celShikaku2
     */
    @JsonProperty("celShikaku2")
    private void setCelShikaku2(celShikaku2AttblShikaku celShikaku2) {
        this.celShikaku2 = celShikaku2;
    }

    /*
     * getcelTani3
     * @return celTani3
     */
    @JsonProperty("celTani3")
    private celTani3AttblShikaku getCelTani3() {
        return celTani3;
    }

    /*
     * setcelTani3
     * @param celTani3 celTani3
     */
    @JsonProperty("celTani3")
    private void setCelTani3(celTani3AttblShikaku celTani3) {
        this.celTani3 = celTani3;
    }

    /*
     * getcelJutoku2
     * @return celJutoku2
     */
    @JsonProperty("celJutoku2")
    private celJutoku2AttblShikaku getCelJutoku2() {
        return celJutoku2;
    }

    /*
     * setcelJutoku2
     * @param celJutoku2 celJutoku2
     */
    @JsonProperty("celJutoku2")
    private void setCelJutoku2(celJutoku2AttblShikaku celJutoku2) {
        this.celJutoku2 = celJutoku2;
    }

    /*
     * getcelTani4
     * @return celTani4
     */
    @JsonProperty("celTani4")
    private celTani4AttblShikaku getCelTani4() {
        return celTani4;
    }

    /*
     * setcelTani4
     * @param celTani4 celTani4
     */
    @JsonProperty("celTani4")
    private void setCelTani4(celTani4AttblShikaku celTani4) {
        this.celTani4 = celTani4;
    }

    /*
     * getcelShikakuTitle3
     * @return celShikakuTitle3
     */
    @JsonProperty("celShikakuTitle3")
    private celShikakuTitle3AttblShikaku getCelShikakuTitle3() {
        return celShikakuTitle3;
    }

    /*
     * setcelShikakuTitle3
     * @param celShikakuTitle3 celShikakuTitle3
     */
    @JsonProperty("celShikakuTitle3")
    private void setCelShikakuTitle3(celShikakuTitle3AttblShikaku celShikakuTitle3) {
        this.celShikakuTitle3 = celShikakuTitle3;
    }

    /*
     * getcelShikaku3
     * @return celShikaku3
     */
    @JsonProperty("celShikaku3")
    private celShikaku3AttblShikaku getCelShikaku3() {
        return celShikaku3;
    }

    /*
     * setcelShikaku3
     * @param celShikaku3 celShikaku3
     */
    @JsonProperty("celShikaku3")
    private void setCelShikaku3(celShikaku3AttblShikaku celShikaku3) {
        this.celShikaku3 = celShikaku3;
    }

    /*
     * getcelTani5
     * @return celTani5
     */
    @JsonProperty("celTani5")
    private celTani5AttblShikaku getCelTani5() {
        return celTani5;
    }

    /*
     * setcelTani5
     * @param celTani5 celTani5
     */
    @JsonProperty("celTani5")
    private void setCelTani5(celTani5AttblShikaku celTani5) {
        this.celTani5 = celTani5;
    }

    /*
     * getcelJutoku3
     * @return celJutoku3
     */
    @JsonProperty("celJutoku3")
    private celJutoku3AttblShikaku getCelJutoku3() {
        return celJutoku3;
    }

    /*
     * setcelJutoku3
     * @param celJutoku3 celJutoku3
     */
    @JsonProperty("celJutoku3")
    private void setCelJutoku3(celJutoku3AttblShikaku celJutoku3) {
        this.celJutoku3 = celJutoku3;
    }

    /*
     * getcelTani6
     * @return celTani6
     */
    @JsonProperty("celTani6")
    private celTani6AttblShikaku getCelTani6() {
        return celTani6;
    }

    /*
     * setcelTani6
     * @param celTani6 celTani6
     */
    @JsonProperty("celTani6")
    private void setCelTani6(celTani6AttblShikaku celTani6) {
        this.celTani6 = celTani6;
    }

    /*
     * getcelShikakuTitle4
     * @return celShikakuTitle4
     */
    @JsonProperty("celShikakuTitle4")
    private celShikakuTitle4AttblShikaku getCelShikakuTitle4() {
        return celShikakuTitle4;
    }

    /*
     * setcelShikakuTitle4
     * @param celShikakuTitle4 celShikakuTitle4
     */
    @JsonProperty("celShikakuTitle4")
    private void setCelShikakuTitle4(celShikakuTitle4AttblShikaku celShikakuTitle4) {
        this.celShikakuTitle4 = celShikakuTitle4;
    }

    /*
     * getcelShikakuTitle5
     * @return celShikakuTitle5
     */
    @JsonProperty("celShikakuTitle5")
    private celShikakuTitle5AttblShikaku getCelShikakuTitle5() {
        return celShikakuTitle5;
    }

    /*
     * setcelShikakuTitle5
     * @param celShikakuTitle5 celShikakuTitle5
     */
    @JsonProperty("celShikakuTitle5")
    private void setCelShikakuTitle5(celShikakuTitle5AttblShikaku celShikakuTitle5) {
        this.celShikakuTitle5 = celShikakuTitle5;
    }

    /*
     * getcelJogai
     * @return celJogai
     */
    @JsonProperty("celJogai")
    private celJogaiAttblShikaku getCelJogai() {
        return celJogai;
    }

    /*
     * setcelJogai
     * @param celJogai celJogai
     */
    @JsonProperty("celJogai")
    private void setCelJogai(celJogaiAttblShikaku celJogai) {
        this.celJogai = celJogai;
    }

    /*
     * getcelTani7
     * @return celTani7
     */
    @JsonProperty("celTani7")
    private celTani7AttblShikaku getCelTani7() {
        return celTani7;
    }

    /*
     * setcelTani7
     * @param celTani7 celTani7
     */
    @JsonProperty("celTani7")
    private void setCelTani7(celTani7AttblShikaku celTani7) {
        this.celTani7 = celTani7;
    }

    /*
     * getcelShikakuTitle6
     * @return celShikakuTitle6
     */
    @JsonProperty("celShikakuTitle6")
    private celShikakuTitle6AttblShikaku getCelShikakuTitle6() {
        return celShikakuTitle6;
    }

    /*
     * setcelShikakuTitle6
     * @param celShikakuTitle6 celShikakuTitle6
     */
    @JsonProperty("celShikakuTitle6")
    private void setCelShikakuTitle6(celShikakuTitle6AttblShikaku celShikakuTitle6) {
        this.celShikakuTitle6 = celShikakuTitle6;
    }

    /*
     * getcelTatoku
     * @return celTatoku
     */
    @JsonProperty("celTatoku")
    private celTatokuAttblShikaku getCelTatoku() {
        return celTatoku;
    }

    /*
     * setcelTatoku
     * @param celTatoku celTatoku
     */
    @JsonProperty("celTatoku")
    private void setCelTatoku(celTatokuAttblShikaku celTatoku) {
        this.celTatoku = celTatoku;
    }

    /*
     * getcelTani8
     * @return celTani8
     */
    @JsonProperty("celTani8")
    private celTani8AttblShikaku getCelTani8() {
        return celTani8;
    }

    /*
     * setcelTani8
     * @param celTani8 celTani8
     */
    @JsonProperty("celTani8")
    private void setCelTani8(celTani8AttblShikaku celTani8) {
        this.celTani8 = celTani8;
    }

    // </editor-fold>
}
/**
 * celShikakuTitle1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle1AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("ShikakuTitle1")
    private ShikakuTitle1Div ShikakuTitle1;

    /*
     * getShikakuTitle1
     * @return ShikakuTitle1
     */
    @JsonProperty("ShikakuTitle1")
    public ShikakuTitle1Div getShikakuTitle1() {
        return ShikakuTitle1;
    }

    /*
     * setShikakuTitle1
     * @param ShikakuTitle1 ShikakuTitle1
     */
    @JsonProperty("ShikakuTitle1")
    public void setShikakuTitle1(ShikakuTitle1Div ShikakuTitle1) {
        this.ShikakuTitle1 = ShikakuTitle1;
    }

    // </editor-fold>
}
/**
 * celShikaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikaku1AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtShikaku1")
    private TextBoxNum txtShikaku1;

    /*
     * gettxtShikaku1
     * @return txtShikaku1
     */
    @JsonProperty("txtShikaku1")
    public TextBoxNum getTxtShikaku1() {
        return txtShikaku1;
    }

    /*
     * settxtShikaku1
     * @param txtShikaku1 txtShikaku1
     */
    @JsonProperty("txtShikaku1")
    public void setTxtShikaku1(TextBoxNum txtShikaku1) {
        this.txtShikaku1 = txtShikaku1;
    }

    // </editor-fold>
}
/**
 * celTani1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani1AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani1")
    private Label lblTani1;

    /*
     * getlblTani1
     * @return lblTani1
     */
    @JsonProperty("lblTani1")
    public Label getLblTani1() {
        return lblTani1;
    }

    /*
     * setlblTani1
     * @param lblTani1 lblTani1
     */
    @JsonProperty("lblTani1")
    public void setLblTani1(Label lblTani1) {
        this.lblTani1 = lblTani1;
    }

    // </editor-fold>
}
/**
 * celJutoku1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJutoku1AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtJutoku1")
    private TextBoxNum txtJutoku1;

    /*
     * gettxtJutoku1
     * @return txtJutoku1
     */
    @JsonProperty("txtJutoku1")
    public TextBoxNum getTxtJutoku1() {
        return txtJutoku1;
    }

    /*
     * settxtJutoku1
     * @param txtJutoku1 txtJutoku1
     */
    @JsonProperty("txtJutoku1")
    public void setTxtJutoku1(TextBoxNum txtJutoku1) {
        this.txtJutoku1 = txtJutoku1;
    }

    // </editor-fold>
}
/**
 * celTani2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani2AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani2")
    private Label lblTani2;

    /*
     * getlblTani2
     * @return lblTani2
     */
    @JsonProperty("lblTani2")
    public Label getLblTani2() {
        return lblTani2;
    }

    /*
     * setlblTani2
     * @param lblTani2 lblTani2
     */
    @JsonProperty("lblTani2")
    public void setLblTani2(Label lblTani2) {
        this.lblTani2 = lblTani2;
    }

    // </editor-fold>
}
/**
 * celShikakuTitle2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle2AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("ShikakuTitle2")
    private ShikakuTitle2Div ShikakuTitle2;

    /*
     * getShikakuTitle2
     * @return ShikakuTitle2
     */
    @JsonProperty("ShikakuTitle2")
    public ShikakuTitle2Div getShikakuTitle2() {
        return ShikakuTitle2;
    }

    /*
     * setShikakuTitle2
     * @param ShikakuTitle2 ShikakuTitle2
     */
    @JsonProperty("ShikakuTitle2")
    public void setShikakuTitle2(ShikakuTitle2Div ShikakuTitle2) {
        this.ShikakuTitle2 = ShikakuTitle2;
    }

    // </editor-fold>
}
/**
 * celShikaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikaku2AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtShikaku2")
    private TextBoxNum txtShikaku2;

    /*
     * gettxtShikaku2
     * @return txtShikaku2
     */
    @JsonProperty("txtShikaku2")
    public TextBoxNum getTxtShikaku2() {
        return txtShikaku2;
    }

    /*
     * settxtShikaku2
     * @param txtShikaku2 txtShikaku2
     */
    @JsonProperty("txtShikaku2")
    public void setTxtShikaku2(TextBoxNum txtShikaku2) {
        this.txtShikaku2 = txtShikaku2;
    }

    // </editor-fold>
}
/**
 * celTani3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani3AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani3")
    private Label lblTani3;

    /*
     * getlblTani3
     * @return lblTani3
     */
    @JsonProperty("lblTani3")
    public Label getLblTani3() {
        return lblTani3;
    }

    /*
     * setlblTani3
     * @param lblTani3 lblTani3
     */
    @JsonProperty("lblTani3")
    public void setLblTani3(Label lblTani3) {
        this.lblTani3 = lblTani3;
    }

    // </editor-fold>
}
/**
 * celJutoku2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJutoku2AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtJutoku2")
    private TextBoxNum txtJutoku2;

    /*
     * gettxtJutoku2
     * @return txtJutoku2
     */
    @JsonProperty("txtJutoku2")
    public TextBoxNum getTxtJutoku2() {
        return txtJutoku2;
    }

    /*
     * settxtJutoku2
     * @param txtJutoku2 txtJutoku2
     */
    @JsonProperty("txtJutoku2")
    public void setTxtJutoku2(TextBoxNum txtJutoku2) {
        this.txtJutoku2 = txtJutoku2;
    }

    // </editor-fold>
}
/**
 * celTani4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani4AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani4")
    private Label lblTani4;

    /*
     * getlblTani4
     * @return lblTani4
     */
    @JsonProperty("lblTani4")
    public Label getLblTani4() {
        return lblTani4;
    }

    /*
     * setlblTani4
     * @param lblTani4 lblTani4
     */
    @JsonProperty("lblTani4")
    public void setLblTani4(Label lblTani4) {
        this.lblTani4 = lblTani4;
    }

    // </editor-fold>
}
/**
 * celShikakuTitle3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle3AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("ShikakuTitle3")
    private ShikakuTitle3Div ShikakuTitle3;

    /*
     * getShikakuTitle3
     * @return ShikakuTitle3
     */
    @JsonProperty("ShikakuTitle3")
    public ShikakuTitle3Div getShikakuTitle3() {
        return ShikakuTitle3;
    }

    /*
     * setShikakuTitle3
     * @param ShikakuTitle3 ShikakuTitle3
     */
    @JsonProperty("ShikakuTitle3")
    public void setShikakuTitle3(ShikakuTitle3Div ShikakuTitle3) {
        this.ShikakuTitle3 = ShikakuTitle3;
    }

    // </editor-fold>
}
/**
 * celShikaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikaku3AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtShikaku3")
    private TextBoxNum txtShikaku3;

    /*
     * gettxtShikaku3
     * @return txtShikaku3
     */
    @JsonProperty("txtShikaku3")
    public TextBoxNum getTxtShikaku3() {
        return txtShikaku3;
    }

    /*
     * settxtShikaku3
     * @param txtShikaku3 txtShikaku3
     */
    @JsonProperty("txtShikaku3")
    public void setTxtShikaku3(TextBoxNum txtShikaku3) {
        this.txtShikaku3 = txtShikaku3;
    }

    // </editor-fold>
}
/**
 * celTani5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani5AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani5")
    private Label lblTani5;

    /*
     * getlblTani5
     * @return lblTani5
     */
    @JsonProperty("lblTani5")
    public Label getLblTani5() {
        return lblTani5;
    }

    /*
     * setlblTani5
     * @param lblTani5 lblTani5
     */
    @JsonProperty("lblTani5")
    public void setLblTani5(Label lblTani5) {
        this.lblTani5 = lblTani5;
    }

    // </editor-fold>
}
/**
 * celJutoku3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJutoku3AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtJutoku3")
    private TextBoxNum txtJutoku3;

    /*
     * gettxtJutoku3
     * @return txtJutoku3
     */
    @JsonProperty("txtJutoku3")
    public TextBoxNum getTxtJutoku3() {
        return txtJutoku3;
    }

    /*
     * settxtJutoku3
     * @param txtJutoku3 txtJutoku3
     */
    @JsonProperty("txtJutoku3")
    public void setTxtJutoku3(TextBoxNum txtJutoku3) {
        this.txtJutoku3 = txtJutoku3;
    }

    // </editor-fold>
}
/**
 * celTani6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani6AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani6")
    private Label lblTani6;

    /*
     * getlblTani6
     * @return lblTani6
     */
    @JsonProperty("lblTani6")
    public Label getLblTani6() {
        return lblTani6;
    }

    /*
     * setlblTani6
     * @param lblTani6 lblTani6
     */
    @JsonProperty("lblTani6")
    public void setLblTani6(Label lblTani6) {
        this.lblTani6 = lblTani6;
    }

    // </editor-fold>
}
/**
 * celShikakuTitle4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle4AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    // </editor-fold>
}
/**
 * celShikakuTitle5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle5AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblShikakuTitle5")
    private Label lblShikakuTitle5;

    /*
     * getlblShikakuTitle5
     * @return lblShikakuTitle5
     */
    @JsonProperty("lblShikakuTitle5")
    public Label getLblShikakuTitle5() {
        return lblShikakuTitle5;
    }

    /*
     * setlblShikakuTitle5
     * @param lblShikakuTitle5 lblShikakuTitle5
     */
    @JsonProperty("lblShikakuTitle5")
    public void setLblShikakuTitle5(Label lblShikakuTitle5) {
        this.lblShikakuTitle5 = lblShikakuTitle5;
    }

    // </editor-fold>
}
/**
 * celJogai のクラスファイル 
 * 
 * @author 自動生成
 */
class celJogaiAttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtJogai")
    private TextBoxNum txtJogai;

    /*
     * gettxtJogai
     * @return txtJogai
     */
    @JsonProperty("txtJogai")
    public TextBoxNum getTxtJogai() {
        return txtJogai;
    }

    /*
     * settxtJogai
     * @param txtJogai txtJogai
     */
    @JsonProperty("txtJogai")
    public void setTxtJogai(TextBoxNum txtJogai) {
        this.txtJogai = txtJogai;
    }

    // </editor-fold>
}
/**
 * celTani7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani7AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani7")
    private Label lblTani7;

    /*
     * getlblTani7
     * @return lblTani7
     */
    @JsonProperty("lblTani7")
    public Label getLblTani7() {
        return lblTani7;
    }

    /*
     * setlblTani7
     * @param lblTani7 lblTani7
     */
    @JsonProperty("lblTani7")
    public void setLblTani7(Label lblTani7) {
        this.lblTani7 = lblTani7;
    }

    // </editor-fold>
}
/**
 * celShikakuTitle6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celShikakuTitle6AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblShikakuTitle6")
    private Label lblShikakuTitle6;

    /*
     * getlblShikakuTitle6
     * @return lblShikakuTitle6
     */
    @JsonProperty("lblShikakuTitle6")
    public Label getLblShikakuTitle6() {
        return lblShikakuTitle6;
    }

    /*
     * setlblShikakuTitle6
     * @param lblShikakuTitle6 lblShikakuTitle6
     */
    @JsonProperty("lblShikakuTitle6")
    public void setLblShikakuTitle6(Label lblShikakuTitle6) {
        this.lblShikakuTitle6 = lblShikakuTitle6;
    }

    // </editor-fold>
}
/**
 * celTatoku のクラスファイル 
 * 
 * @author 自動生成
 */
class celTatokuAttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("txtTatoku")
    private TextBoxNum txtTatoku;

    /*
     * gettxtTatoku
     * @return txtTatoku
     */
    @JsonProperty("txtTatoku")
    public TextBoxNum getTxtTatoku() {
        return txtTatoku;
    }

    /*
     * settxtTatoku
     * @param txtTatoku txtTatoku
     */
    @JsonProperty("txtTatoku")
    public void setTxtTatoku(TextBoxNum txtTatoku) {
        this.txtTatoku = txtTatoku;
    }

    // </editor-fold>
}
/**
 * celTani8 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTani8AttblShikaku extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblTani8")
    private Label lblTani8;

    /*
     * getlblTani8
     * @return lblTani8
     */
    @JsonProperty("lblTani8")
    public Label getLblTani8() {
        return lblTani8;
    }

    /*
     * setlblTani8
     * @param lblTani8 lblTani8
     */
    @JsonProperty("lblTani8")
    public void setLblTani8(Label lblTani8) {
        this.lblTani8 = lblTani8;
    }

    // </editor-fold>
}
