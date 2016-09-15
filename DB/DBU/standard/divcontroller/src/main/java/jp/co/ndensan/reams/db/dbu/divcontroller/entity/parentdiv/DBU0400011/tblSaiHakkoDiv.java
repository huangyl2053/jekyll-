package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0400011;
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
 * tblSaiHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSaiHakkoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTest")
    private celTestAttblSaiHakko celTest;
    @JsonProperty("celTestHosoku")
    private celTestHosokuAttblSaiHakko celTestHosoku;
    @JsonProperty("celNull4")
    private celNull4AttblSaiHakko celNull4;
    @JsonProperty("celNull5")
    private celNull5AttblSaiHakko celNull5;
    @JsonProperty("celYMD4")
    private celYMD4AttblSaiHakko celYMD4;
    @JsonProperty("celTime4")
    private celTime4AttblSaiHakko celTime4;
    @JsonProperty("celNull10")
    private celNull10AttblSaiHakko celNull10;
    @JsonProperty("celSaiHakko")
    private celSaiHakkoAttblSaiHakko celSaiHakko;
    @JsonProperty("celHakkouYMD")
    private celHakkouYMDAttblSaiHakko celHakkouYMD;
    @JsonProperty("celHakkoYMD")
    private celHakkoYMDAttblSaiHakko celHakkoYMD;
    @JsonProperty("celHakkoTime")
    private celHakkoTimeAttblSaiHakko celHakkoTime;
    @JsonProperty("celNull11")
    private celNull11AttblSaiHakko celNull11;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public CheckBoxList getChkTest() {
        return this.celTest.getChkTest();
    }

    @JsonIgnore
    public Label getLblTestHosoku() {
        return this.celTestHosoku.getLblTestHosoku();
    }

    @JsonIgnore
    public Label getLblYMD4() {
        return this.celYMD4.getLblYMD4();
    }

    @JsonIgnore
    public Label getLblTime4() {
        return this.celTime4.getLblTime4();
    }

    @JsonIgnore
    public CheckBoxList getChkSaiHakko() {
        return this.celSaiHakko.getChkSaiHakko();
    }

    @JsonIgnore
    public Label getLblHakkouYMD() {
        return this.celHakkouYMD.getLblHakkouYMD();
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkoYMD() {
        return this.celHakkoYMD.getTxtHakkoYMD();
    }

    @JsonIgnore
    public TextBoxTime getTxtHakkoTime() {
        return this.celHakkoTime.getTxtHakkoTime();
    }

    @JsonIgnore
    public Label getLblNull3() {
        return this.celNull11.getLblNull3();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTest
     * @return celTest
     */
    @JsonProperty("celTest")
    private celTestAttblSaiHakko getCelTest() {
        return celTest;
    }

    /*
     * setcelTest
     * @param celTest celTest
     */
    @JsonProperty("celTest")
    private void setCelTest(celTestAttblSaiHakko celTest) {
        this.celTest = celTest;
    }

    /*
     * getcelTestHosoku
     * @return celTestHosoku
     */
    @JsonProperty("celTestHosoku")
    private celTestHosokuAttblSaiHakko getCelTestHosoku() {
        return celTestHosoku;
    }

    /*
     * setcelTestHosoku
     * @param celTestHosoku celTestHosoku
     */
    @JsonProperty("celTestHosoku")
    private void setCelTestHosoku(celTestHosokuAttblSaiHakko celTestHosoku) {
        this.celTestHosoku = celTestHosoku;
    }

    /*
     * getcelNull4
     * @return celNull4
     */
    @JsonProperty("celNull4")
    private celNull4AttblSaiHakko getCelNull4() {
        return celNull4;
    }

    /*
     * setcelNull4
     * @param celNull4 celNull4
     */
    @JsonProperty("celNull4")
    private void setCelNull4(celNull4AttblSaiHakko celNull4) {
        this.celNull4 = celNull4;
    }

    /*
     * getcelNull5
     * @return celNull5
     */
    @JsonProperty("celNull5")
    private celNull5AttblSaiHakko getCelNull5() {
        return celNull5;
    }

    /*
     * setcelNull5
     * @param celNull5 celNull5
     */
    @JsonProperty("celNull5")
    private void setCelNull5(celNull5AttblSaiHakko celNull5) {
        this.celNull5 = celNull5;
    }

    /*
     * getcelYMD4
     * @return celYMD4
     */
    @JsonProperty("celYMD4")
    private celYMD4AttblSaiHakko getCelYMD4() {
        return celYMD4;
    }

    /*
     * setcelYMD4
     * @param celYMD4 celYMD4
     */
    @JsonProperty("celYMD4")
    private void setCelYMD4(celYMD4AttblSaiHakko celYMD4) {
        this.celYMD4 = celYMD4;
    }

    /*
     * getcelTime4
     * @return celTime4
     */
    @JsonProperty("celTime4")
    private celTime4AttblSaiHakko getCelTime4() {
        return celTime4;
    }

    /*
     * setcelTime4
     * @param celTime4 celTime4
     */
    @JsonProperty("celTime4")
    private void setCelTime4(celTime4AttblSaiHakko celTime4) {
        this.celTime4 = celTime4;
    }

    /*
     * getcelNull10
     * @return celNull10
     */
    @JsonProperty("celNull10")
    private celNull10AttblSaiHakko getCelNull10() {
        return celNull10;
    }

    /*
     * setcelNull10
     * @param celNull10 celNull10
     */
    @JsonProperty("celNull10")
    private void setCelNull10(celNull10AttblSaiHakko celNull10) {
        this.celNull10 = celNull10;
    }

    /*
     * getcelSaiHakko
     * @return celSaiHakko
     */
    @JsonProperty("celSaiHakko")
    private celSaiHakkoAttblSaiHakko getCelSaiHakko() {
        return celSaiHakko;
    }

    /*
     * setcelSaiHakko
     * @param celSaiHakko celSaiHakko
     */
    @JsonProperty("celSaiHakko")
    private void setCelSaiHakko(celSaiHakkoAttblSaiHakko celSaiHakko) {
        this.celSaiHakko = celSaiHakko;
    }

    /*
     * getcelHakkouYMD
     * @return celHakkouYMD
     */
    @JsonProperty("celHakkouYMD")
    private celHakkouYMDAttblSaiHakko getCelHakkouYMD() {
        return celHakkouYMD;
    }

    /*
     * setcelHakkouYMD
     * @param celHakkouYMD celHakkouYMD
     */
    @JsonProperty("celHakkouYMD")
    private void setCelHakkouYMD(celHakkouYMDAttblSaiHakko celHakkouYMD) {
        this.celHakkouYMD = celHakkouYMD;
    }

    /*
     * getcelHakkoYMD
     * @return celHakkoYMD
     */
    @JsonProperty("celHakkoYMD")
    private celHakkoYMDAttblSaiHakko getCelHakkoYMD() {
        return celHakkoYMD;
    }

    /*
     * setcelHakkoYMD
     * @param celHakkoYMD celHakkoYMD
     */
    @JsonProperty("celHakkoYMD")
    private void setCelHakkoYMD(celHakkoYMDAttblSaiHakko celHakkoYMD) {
        this.celHakkoYMD = celHakkoYMD;
    }

    /*
     * getcelHakkoTime
     * @return celHakkoTime
     */
    @JsonProperty("celHakkoTime")
    private celHakkoTimeAttblSaiHakko getCelHakkoTime() {
        return celHakkoTime;
    }

    /*
     * setcelHakkoTime
     * @param celHakkoTime celHakkoTime
     */
    @JsonProperty("celHakkoTime")
    private void setCelHakkoTime(celHakkoTimeAttblSaiHakko celHakkoTime) {
        this.celHakkoTime = celHakkoTime;
    }

    /*
     * getcelNull11
     * @return celNull11
     */
    @JsonProperty("celNull11")
    private celNull11AttblSaiHakko getCelNull11() {
        return celNull11;
    }

    /*
     * setcelNull11
     * @param celNull11 celNull11
     */
    @JsonProperty("celNull11")
    private void setCelNull11(celNull11AttblSaiHakko celNull11) {
        this.celNull11 = celNull11;
    }

    // </editor-fold>
}
/**
 * celTest のクラスファイル 
 * 
 * @author 自動生成
 */
class celTestAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("chkTest")
    private CheckBoxList chkTest;

    /*
     * getchkTest
     * @return chkTest
     */
    @JsonProperty("chkTest")
    public CheckBoxList getChkTest() {
        return chkTest;
    }

    /*
     * setchkTest
     * @param chkTest chkTest
     */
    @JsonProperty("chkTest")
    public void setChkTest(CheckBoxList chkTest) {
        this.chkTest = chkTest;
    }

    // </editor-fold>
}
/**
 * celTestHosoku のクラスファイル 
 * 
 * @author 自動生成
 */
class celTestHosokuAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblTestHosoku")
    private Label lblTestHosoku;

    /*
     * getlblTestHosoku
     * @return lblTestHosoku
     */
    @JsonProperty("lblTestHosoku")
    public Label getLblTestHosoku() {
        return lblTestHosoku;
    }

    /*
     * setlblTestHosoku
     * @param lblTestHosoku lblTestHosoku
     */
    @JsonProperty("lblTestHosoku")
    public void setLblTestHosoku(Label lblTestHosoku) {
        this.lblTestHosoku = lblTestHosoku;
    }

    // </editor-fold>
}
/**
 * celNull4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull4AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celNull5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull5AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celYMD4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celYMD4AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblYMD4")
    private Label lblYMD4;

    /*
     * getlblYMD4
     * @return lblYMD4
     */
    @JsonProperty("lblYMD4")
    public Label getLblYMD4() {
        return lblYMD4;
    }

    /*
     * setlblYMD4
     * @param lblYMD4 lblYMD4
     */
    @JsonProperty("lblYMD4")
    public void setLblYMD4(Label lblYMD4) {
        this.lblYMD4 = lblYMD4;
    }

    // </editor-fold>
}
/**
 * celTime4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTime4AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblTime4")
    private Label lblTime4;

    /*
     * getlblTime4
     * @return lblTime4
     */
    @JsonProperty("lblTime4")
    public Label getLblTime4() {
        return lblTime4;
    }

    /*
     * setlblTime4
     * @param lblTime4 lblTime4
     */
    @JsonProperty("lblTime4")
    public void setLblTime4(Label lblTime4) {
        this.lblTime4 = lblTime4;
    }

    // </editor-fold>
}
/**
 * celNull10 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull10AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    // </editor-fold>
}
/**
 * celSaiHakko のクラスファイル 
 * 
 * @author 自動生成
 */
class celSaiHakkoAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("chkSaiHakko")
    private CheckBoxList chkSaiHakko;

    /*
     * getchkSaiHakko
     * @return chkSaiHakko
     */
    @JsonProperty("chkSaiHakko")
    public CheckBoxList getChkSaiHakko() {
        return chkSaiHakko;
    }

    /*
     * setchkSaiHakko
     * @param chkSaiHakko chkSaiHakko
     */
    @JsonProperty("chkSaiHakko")
    public void setChkSaiHakko(CheckBoxList chkSaiHakko) {
        this.chkSaiHakko = chkSaiHakko;
    }

    // </editor-fold>
}
/**
 * celHakkouYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celHakkouYMDAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblHakkouYMD")
    private Label lblHakkouYMD;

    /*
     * getlblHakkouYMD
     * @return lblHakkouYMD
     */
    @JsonProperty("lblHakkouYMD")
    public Label getLblHakkouYMD() {
        return lblHakkouYMD;
    }

    /*
     * setlblHakkouYMD
     * @param lblHakkouYMD lblHakkouYMD
     */
    @JsonProperty("lblHakkouYMD")
    public void setLblHakkouYMD(Label lblHakkouYMD) {
        this.lblHakkouYMD = lblHakkouYMD;
    }

    // </editor-fold>
}
/**
 * celHakkoYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celHakkoYMDAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtHakkoYMD")
    private TextBoxDate txtHakkoYMD;

    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    // </editor-fold>
}
/**
 * celHakkoTime のクラスファイル 
 * 
 * @author 自動生成
 */
class celHakkoTimeAttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtHakkoTime")
    private TextBoxTime txtHakkoTime;

    /*
     * gettxtHakkoTime
     * @return txtHakkoTime
     */
    @JsonProperty("txtHakkoTime")
    public TextBoxTime getTxtHakkoTime() {
        return txtHakkoTime;
    }

    /*
     * settxtHakkoTime
     * @param txtHakkoTime txtHakkoTime
     */
    @JsonProperty("txtHakkoTime")
    public void setTxtHakkoTime(TextBoxTime txtHakkoTime) {
        this.txtHakkoTime = txtHakkoTime;
    }

    // </editor-fold>
}
/**
 * celNull11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celNull11AttblSaiHakko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("lblNull3")
    private Label lblNull3;

    /*
     * getlblNull3
     * @return lblNull3
     */
    @JsonProperty("lblNull3")
    public Label getLblNull3() {
        return lblNull3;
    }

    /*
     * setlblNull3
     * @param lblNull3 lblNull3
     */
    @JsonProperty("lblNull3")
    public void setLblNull3(Label lblNull3) {
        this.lblNull3 = lblNull3;
    }

    // </editor-fold>
}
