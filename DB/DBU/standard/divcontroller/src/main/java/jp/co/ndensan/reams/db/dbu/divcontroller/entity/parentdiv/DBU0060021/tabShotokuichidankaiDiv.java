package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021;
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
 * tabShotokuichidankai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShotokuichidankaiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellShotokudanka")
    private cellShotokudankaAttabShotokuichidankai cellShotokudanka;
    @JsonProperty("cellhyojunwariai")
    private cellhyojunwariaiAttabShotokuichidankai cellhyojunwariai;
    @JsonProperty("cellhokensha")
    private cellhokenshaAttabShotokuichidankai cellhokensha;
    @JsonProperty("cellnendomatsugenzaihihokenshasu")
    private cellnendomatsugenzaihihokenshasuAttabShotokuichidankai cellnendomatsugenzaihihokenshasu;
    @JsonProperty("cellbiko")
    private cellbikoAttabShotokuichidankai cellbiko;
    @JsonProperty("cellshichoson")
    private cellshichosonAttabShotokuichidankai cellshichoson;
    @JsonProperty("celldankai")
    private celldankaiAttabShotokuichidankai celldankai;
    @JsonProperty("cellyombunnoni")
    private cellyombunnoniAttabShotokuichidankai cellyombunnoni;
    @JsonProperty("cellzerogo")
    private cellzerogoAttabShotokuichidankai cellzerogo;
    @JsonProperty("cellhokenshaVal")
    private cellhokenshaValAttabShotokuichidankai cellhokenshaVal;
    @JsonProperty("cellnendomatsugenzaihihokenshasuVal")
    private cellnendomatsugenzaihihokenshasuValAttabShotokuichidankai cellnendomatsugenzaihihokenshasuVal;
    @JsonProperty("cellbikoVal")
    private cellbikoValAttabShotokuichidankai cellbikoVal;
    @JsonProperty("cellshichosonVal")
    private cellshichosonValAttabShotokuichidankai cellshichosonVal;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShotokudanka() {
        return this.cellShotokudanka.getLblShotokudanka();
    }

    @JsonIgnore
    public Label getLbllhyojunwariai() {
        return this.cellhyojunwariai.getLbllhyojunwariai();
    }

    @JsonIgnore
    public Label getLblhokensha() {
        return this.cellhokensha.getLblhokensha();
    }

    @JsonIgnore
    public Label getLblnendomatsugenzaihihokenshasu() {
        return this.cellnendomatsugenzaihihokenshasu.getLblnendomatsugenzaihihokenshasu();
    }

    @JsonIgnore
    public Label getLblbiko() {
        return this.cellbiko.getLblbiko();
    }

    @JsonIgnore
    public Label getLblshichoson() {
        return this.cellshichoson.getLblshichoson();
    }

    @JsonIgnore
    public Label getLbldankai() {
        return this.celldankai.getLbldankai();
    }

    @JsonIgnore
    public Label getLabelyombunnoni() {
        return this.cellyombunnoni.getLabelyombunnoni();
    }

    @JsonIgnore
    public Label getLabelzerogo() {
        return this.cellzerogo.getLabelzerogo();
    }

    @JsonIgnore
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuVal() {
        return this.cellnendomatsugenzaihihokenshasuVal.getTxtnendomatsugenzaihihokenshasuVal();
    }

    @JsonIgnore
    public Label getLabelbikoVal() {
        return this.cellbikoVal.getLabelbikoVal();
    }

    @JsonIgnore
    public TextBox getTxtshichosonVal() {
        return this.cellshichosonVal.getTxtshichosonVal();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcellShotokudanka
     * @return cellShotokudanka
     */
    @JsonProperty("cellShotokudanka")
    private cellShotokudankaAttabShotokuichidankai getCellShotokudanka() {
        return cellShotokudanka;
    }

    /*
     * setcellShotokudanka
     * @param cellShotokudanka cellShotokudanka
     */
    @JsonProperty("cellShotokudanka")
    private void setCellShotokudanka(cellShotokudankaAttabShotokuichidankai cellShotokudanka) {
        this.cellShotokudanka = cellShotokudanka;
    }

    /*
     * getcellhyojunwariai
     * @return cellhyojunwariai
     */
    @JsonProperty("cellhyojunwariai")
    private cellhyojunwariaiAttabShotokuichidankai getCellhyojunwariai() {
        return cellhyojunwariai;
    }

    /*
     * setcellhyojunwariai
     * @param cellhyojunwariai cellhyojunwariai
     */
    @JsonProperty("cellhyojunwariai")
    private void setCellhyojunwariai(cellhyojunwariaiAttabShotokuichidankai cellhyojunwariai) {
        this.cellhyojunwariai = cellhyojunwariai;
    }

    /*
     * getcellhokensha
     * @return cellhokensha
     */
    @JsonProperty("cellhokensha")
    private cellhokenshaAttabShotokuichidankai getCellhokensha() {
        return cellhokensha;
    }

    /*
     * setcellhokensha
     * @param cellhokensha cellhokensha
     */
    @JsonProperty("cellhokensha")
    private void setCellhokensha(cellhokenshaAttabShotokuichidankai cellhokensha) {
        this.cellhokensha = cellhokensha;
    }

    /*
     * getcellnendomatsugenzaihihokenshasu
     * @return cellnendomatsugenzaihihokenshasu
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasu")
    private cellnendomatsugenzaihihokenshasuAttabShotokuichidankai getCellnendomatsugenzaihihokenshasu() {
        return cellnendomatsugenzaihihokenshasu;
    }

    /*
     * setcellnendomatsugenzaihihokenshasu
     * @param cellnendomatsugenzaihihokenshasu cellnendomatsugenzaihihokenshasu
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasu")
    private void setCellnendomatsugenzaihihokenshasu(cellnendomatsugenzaihihokenshasuAttabShotokuichidankai cellnendomatsugenzaihihokenshasu) {
        this.cellnendomatsugenzaihihokenshasu = cellnendomatsugenzaihihokenshasu;
    }

    /*
     * getcellbiko
     * @return cellbiko
     */
    @JsonProperty("cellbiko")
    private cellbikoAttabShotokuichidankai getCellbiko() {
        return cellbiko;
    }

    /*
     * setcellbiko
     * @param cellbiko cellbiko
     */
    @JsonProperty("cellbiko")
    private void setCellbiko(cellbikoAttabShotokuichidankai cellbiko) {
        this.cellbiko = cellbiko;
    }

    /*
     * getcellshichoson
     * @return cellshichoson
     */
    @JsonProperty("cellshichoson")
    private cellshichosonAttabShotokuichidankai getCellshichoson() {
        return cellshichoson;
    }

    /*
     * setcellshichoson
     * @param cellshichoson cellshichoson
     */
    @JsonProperty("cellshichoson")
    private void setCellshichoson(cellshichosonAttabShotokuichidankai cellshichoson) {
        this.cellshichoson = cellshichoson;
    }

    /*
     * getcelldankai
     * @return celldankai
     */
    @JsonProperty("celldankai")
    private celldankaiAttabShotokuichidankai getCelldankai() {
        return celldankai;
    }

    /*
     * setcelldankai
     * @param celldankai celldankai
     */
    @JsonProperty("celldankai")
    private void setCelldankai(celldankaiAttabShotokuichidankai celldankai) {
        this.celldankai = celldankai;
    }

    /*
     * getcellyombunnoni
     * @return cellyombunnoni
     */
    @JsonProperty("cellyombunnoni")
    private cellyombunnoniAttabShotokuichidankai getCellyombunnoni() {
        return cellyombunnoni;
    }

    /*
     * setcellyombunnoni
     * @param cellyombunnoni cellyombunnoni
     */
    @JsonProperty("cellyombunnoni")
    private void setCellyombunnoni(cellyombunnoniAttabShotokuichidankai cellyombunnoni) {
        this.cellyombunnoni = cellyombunnoni;
    }

    /*
     * getcellzerogo
     * @return cellzerogo
     */
    @JsonProperty("cellzerogo")
    private cellzerogoAttabShotokuichidankai getCellzerogo() {
        return cellzerogo;
    }

    /*
     * setcellzerogo
     * @param cellzerogo cellzerogo
     */
    @JsonProperty("cellzerogo")
    private void setCellzerogo(cellzerogoAttabShotokuichidankai cellzerogo) {
        this.cellzerogo = cellzerogo;
    }

    /*
     * getcellhokenshaVal
     * @return cellhokenshaVal
     */
    @JsonProperty("cellhokenshaVal")
    private cellhokenshaValAttabShotokuichidankai getCellhokenshaVal() {
        return cellhokenshaVal;
    }

    /*
     * setcellhokenshaVal
     * @param cellhokenshaVal cellhokenshaVal
     */
    @JsonProperty("cellhokenshaVal")
    private void setCellhokenshaVal(cellhokenshaValAttabShotokuichidankai cellhokenshaVal) {
        this.cellhokenshaVal = cellhokenshaVal;
    }

    /*
     * getcellnendomatsugenzaihihokenshasuVal
     * @return cellnendomatsugenzaihihokenshasuVal
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuVal")
    private cellnendomatsugenzaihihokenshasuValAttabShotokuichidankai getCellnendomatsugenzaihihokenshasuVal() {
        return cellnendomatsugenzaihihokenshasuVal;
    }

    /*
     * setcellnendomatsugenzaihihokenshasuVal
     * @param cellnendomatsugenzaihihokenshasuVal cellnendomatsugenzaihihokenshasuVal
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuVal")
    private void setCellnendomatsugenzaihihokenshasuVal(cellnendomatsugenzaihihokenshasuValAttabShotokuichidankai cellnendomatsugenzaihihokenshasuVal) {
        this.cellnendomatsugenzaihihokenshasuVal = cellnendomatsugenzaihihokenshasuVal;
    }

    /*
     * getcellbikoVal
     * @return cellbikoVal
     */
    @JsonProperty("cellbikoVal")
    private cellbikoValAttabShotokuichidankai getCellbikoVal() {
        return cellbikoVal;
    }

    /*
     * setcellbikoVal
     * @param cellbikoVal cellbikoVal
     */
    @JsonProperty("cellbikoVal")
    private void setCellbikoVal(cellbikoValAttabShotokuichidankai cellbikoVal) {
        this.cellbikoVal = cellbikoVal;
    }

    /*
     * getcellshichosonVal
     * @return cellshichosonVal
     */
    @JsonProperty("cellshichosonVal")
    private cellshichosonValAttabShotokuichidankai getCellshichosonVal() {
        return cellshichosonVal;
    }

    /*
     * setcellshichosonVal
     * @param cellshichosonVal cellshichosonVal
     */
    @JsonProperty("cellshichosonVal")
    private void setCellshichosonVal(cellshichosonValAttabShotokuichidankai cellshichosonVal) {
        this.cellshichosonVal = cellshichosonVal;
    }

    // </editor-fold>
}
/**
 * cellShotokudanka のクラスファイル 
 * 
 * @author 自動生成
 */
class cellShotokudankaAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblShotokudanka")
    private Label lblShotokudanka;

    /*
     * getlblShotokudanka
     * @return lblShotokudanka
     */
    @JsonProperty("lblShotokudanka")
    public Label getLblShotokudanka() {
        return lblShotokudanka;
    }

    /*
     * setlblShotokudanka
     * @param lblShotokudanka lblShotokudanka
     */
    @JsonProperty("lblShotokudanka")
    public void setLblShotokudanka(Label lblShotokudanka) {
        this.lblShotokudanka = lblShotokudanka;
    }

    // </editor-fold>
}
/**
 * cellhyojunwariai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhyojunwariaiAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbllhyojunwariai")
    private Label lbllhyojunwariai;

    /*
     * getlbllhyojunwariai
     * @return lbllhyojunwariai
     */
    @JsonProperty("lbllhyojunwariai")
    public Label getLbllhyojunwariai() {
        return lbllhyojunwariai;
    }

    /*
     * setlbllhyojunwariai
     * @param lbllhyojunwariai lbllhyojunwariai
     */
    @JsonProperty("lbllhyojunwariai")
    public void setLbllhyojunwariai(Label lbllhyojunwariai) {
        this.lbllhyojunwariai = lbllhyojunwariai;
    }

    // </editor-fold>
}
/**
 * cellhokensha のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshaAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblhokensha")
    private Label lblhokensha;

    /*
     * getlblhokensha
     * @return lblhokensha
     */
    @JsonProperty("lblhokensha")
    public Label getLblhokensha() {
        return lblhokensha;
    }

    /*
     * setlblhokensha
     * @param lblhokensha lblhokensha
     */
    @JsonProperty("lblhokensha")
    public void setLblhokensha(Label lblhokensha) {
        this.lblhokensha = lblhokensha;
    }

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasuAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblnendomatsugenzaihihokenshasu")
    private Label lblnendomatsugenzaihihokenshasu;

    /*
     * getlblnendomatsugenzaihihokenshasu
     * @return lblnendomatsugenzaihihokenshasu
     */
    @JsonProperty("lblnendomatsugenzaihihokenshasu")
    public Label getLblnendomatsugenzaihihokenshasu() {
        return lblnendomatsugenzaihihokenshasu;
    }

    /*
     * setlblnendomatsugenzaihihokenshasu
     * @param lblnendomatsugenzaihihokenshasu lblnendomatsugenzaihihokenshasu
     */
    @JsonProperty("lblnendomatsugenzaihihokenshasu")
    public void setLblnendomatsugenzaihihokenshasu(Label lblnendomatsugenzaihihokenshasu) {
        this.lblnendomatsugenzaihihokenshasu = lblnendomatsugenzaihihokenshasu;
    }

    // </editor-fold>
}
/**
 * cellbiko のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblbiko")
    private Label lblbiko;

    /*
     * getlblbiko
     * @return lblbiko
     */
    @JsonProperty("lblbiko")
    public Label getLblbiko() {
        return lblbiko;
    }

    /*
     * setlblbiko
     * @param lblbiko lblbiko
     */
    @JsonProperty("lblbiko")
    public void setLblbiko(Label lblbiko) {
        this.lblbiko = lblbiko;
    }

    // </editor-fold>
}
/**
 * cellshichoson のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshichosonAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblshichoson")
    private Label lblshichoson;

    /*
     * getlblshichoson
     * @return lblshichoson
     */
    @JsonProperty("lblshichoson")
    public Label getLblshichoson() {
        return lblshichoson;
    }

    /*
     * setlblshichoson
     * @param lblshichoson lblshichoson
     */
    @JsonProperty("lblshichoson")
    public void setLblshichoson(Label lblshichoson) {
        this.lblshichoson = lblshichoson;
    }

    // </editor-fold>
}
/**
 * celldankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celldankaiAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbldankai")
    private Label lbldankai;

    /*
     * getlbldankai
     * @return lbldankai
     */
    @JsonProperty("lbldankai")
    public Label getLbldankai() {
        return lbldankai;
    }

    /*
     * setlbldankai
     * @param lbldankai lbldankai
     */
    @JsonProperty("lbldankai")
    public void setLbldankai(Label lbldankai) {
        this.lbldankai = lbldankai;
    }

    // </editor-fold>
}
/**
 * cellyombunnoni のクラスファイル 
 * 
 * @author 自動生成
 */
class cellyombunnoniAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelyombunnoni")
    private Label labelyombunnoni;

    /*
     * getlabelyombunnoni
     * @return labelyombunnoni
     */
    @JsonProperty("labelyombunnoni")
    public Label getLabelyombunnoni() {
        return labelyombunnoni;
    }

    /*
     * setlabelyombunnoni
     * @param labelyombunnoni labelyombunnoni
     */
    @JsonProperty("labelyombunnoni")
    public void setLabelyombunnoni(Label labelyombunnoni) {
        this.labelyombunnoni = labelyombunnoni;
    }

    // </editor-fold>
}
/**
 * cellzerogo のクラスファイル 
 * 
 * @author 自動生成
 */
class cellzerogoAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelzerogo")
    private Label labelzerogo;

    /*
     * getlabelzerogo
     * @return labelzerogo
     */
    @JsonProperty("labelzerogo")
    public Label getLabelzerogo() {
        return labelzerogo;
    }

    /*
     * setlabelzerogo
     * @param labelzerogo labelzerogo
     */
    @JsonProperty("labelzerogo")
    public void setLabelzerogo(Label labelzerogo) {
        this.labelzerogo = labelzerogo;
    }

    // </editor-fold>
}
/**
 * cellhokenshaVal のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshaValAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasuVal のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasuValAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtnendomatsugenzaihihokenshasuVal")
    private TextBoxNum txtnendomatsugenzaihihokenshasuVal;

    /*
     * gettxtnendomatsugenzaihihokenshasuVal
     * @return txtnendomatsugenzaihihokenshasuVal
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuVal")
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuVal() {
        return txtnendomatsugenzaihihokenshasuVal;
    }

    /*
     * settxtnendomatsugenzaihihokenshasuVal
     * @param txtnendomatsugenzaihihokenshasuVal txtnendomatsugenzaihihokenshasuVal
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuVal")
    public void setTxtnendomatsugenzaihihokenshasuVal(TextBoxNum txtnendomatsugenzaihihokenshasuVal) {
        this.txtnendomatsugenzaihihokenshasuVal = txtnendomatsugenzaihihokenshasuVal;
    }

    // </editor-fold>
}
/**
 * cellbikoVal のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoValAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelbikoVal")
    private Label labelbikoVal;

    /*
     * getlabelbikoVal
     * @return labelbikoVal
     */
    @JsonProperty("labelbikoVal")
    public Label getLabelbikoVal() {
        return labelbikoVal;
    }

    /*
     * setlabelbikoVal
     * @param labelbikoVal labelbikoVal
     */
    @JsonProperty("labelbikoVal")
    public void setLabelbikoVal(Label labelbikoVal) {
        this.labelbikoVal = labelbikoVal;
    }

    // </editor-fold>
}
/**
 * cellshichosonVal のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshichosonValAttabShotokuichidankai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtshichosonVal")
    private TextBox txtshichosonVal;

    /*
     * gettxtshichosonVal
     * @return txtshichosonVal
     */
    @JsonProperty("txtshichosonVal")
    public TextBox getTxtshichosonVal() {
        return txtshichosonVal;
    }

    /*
     * settxtshichosonVal
     * @param txtshichosonVal txtshichosonVal
     */
    @JsonProperty("txtshichosonVal")
    public void setTxtshichosonVal(TextBox txtshichosonVal) {
        this.txtshichosonVal = txtshichosonVal;
    }

    // </editor-fold>
}
