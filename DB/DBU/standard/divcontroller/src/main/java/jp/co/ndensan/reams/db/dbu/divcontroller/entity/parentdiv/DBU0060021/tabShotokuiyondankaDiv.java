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
 * tabShotokuiyondanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShotokuiyondankaDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celldankaiyon")
    private celldankaiyonAttabShotokuiyondanka celldankaiyon;
    @JsonProperty("cell1")
    private cell1AttabShotokuiyondanka cell1;
    @JsonProperty("cell2")
    private cell2AttabShotokuiyondanka cell2;
    @JsonProperty("cellhokenshaValyon")
    private cellhokenshaValyonAttabShotokuiyondanka cellhokenshaValyon;
    @JsonProperty("cellnendomatsugenzaihihokenshasuyon")
    private cellnendomatsugenzaihihokenshasuyonAttabShotokuiyondanka cellnendomatsugenzaihihokenshasuyon;
    @JsonProperty("cellbikoValyon")
    private cellbikoValyonAttabShotokuiyondanka cellbikoValyon;
    @JsonProperty("cellshichosonyonkaidan")
    private cellshichosonyonkaidanAttabShotokuiyondanka cellshichosonyonkaidan;
    @JsonProperty("celldanyondankai")
    private celldanyondankaiAttabShotokuiyondanka celldanyondankai;
    @JsonProperty("cellyombunnoyon")
    private cellyombunnoyonAttabShotokuiyondanka cellyombunnoyon;
    @JsonProperty("cellzeroyongo")
    private cellzeroyongoAttabShotokuiyondanka cellzeroyongo;
    @JsonProperty("cellhokenshayondankai")
    private cellhokenshayondankaiAttabShotokuiyondanka cellhokenshayondankai;
    @JsonProperty("cellnendomatsugenzaihihokenshasuyondankai")
    private cellnendomatsugenzaihihokenshasuyondankaiAttabShotokuiyondanka cellnendomatsugenzaihihokenshasuyondankai;
    @JsonProperty("cellbikoValyondankai")
    private cellbikoValyondankaiAttabShotokuiyondanka cellbikoValyondankai;
    @JsonProperty("cellshichosonyondankai")
    private cellshichosonyondankaiAttabShotokuiyondanka cellshichosonyondankai;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLbldankaiyon() {
        return this.celldankaiyon.getLbldankaiyon();
    }

    @JsonIgnore
    public Label getLabelhokenshaValyon() {
        return this.cellhokenshaValyon.getLabelhokenshaValyon();
    }

    @JsonIgnore
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuyon() {
        return this.cellnendomatsugenzaihihokenshasuyon.getTxtnendomatsugenzaihihokenshasuyon();
    }

    @JsonIgnore
    public Label getTxtbikoValyon() {
        return this.cellbikoValyon.getTxtbikoValyon();
    }

    @JsonIgnore
    public TextBox getTxtshichosonyonkaidan() {
        return this.cellshichosonyonkaidan.getTxtshichosonyonkaidan();
    }

    @JsonIgnore
    public Label getLbldanyondankai() {
        return this.celldanyondankai.getLbldanyondankai();
    }

    @JsonIgnore
    public Label getLabelyombunnoyon() {
        return this.cellyombunnoyon.getLabelyombunnoyon();
    }

    @JsonIgnore
    public Label getLabelzeroyongo() {
        return this.cellzeroyongo.getLabelzeroyongo();
    }

    @JsonIgnore
    public Label getLabelhokenshayondankai() {
        return this.cellhokenshayondankai.getLabelhokenshayondankai();
    }

    @JsonIgnore
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuyondankai() {
        return this.cellnendomatsugenzaihihokenshasuyondankai.getTxtnendomatsugenzaihihokenshasuyondankai();
    }

    @JsonIgnore
    public Label getTxtbikoValyondankai() {
        return this.cellbikoValyondankai.getTxtbikoValyondankai();
    }

    @JsonIgnore
    public TextBox getTxtshichosonyondankai() {
        return this.cellshichosonyondankai.getTxtshichosonyondankai();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelldankaiyon
     * @return celldankaiyon
     */
    @JsonProperty("celldankaiyon")
    private celldankaiyonAttabShotokuiyondanka getCelldankaiyon() {
        return celldankaiyon;
    }

    /*
     * setcelldankaiyon
     * @param celldankaiyon celldankaiyon
     */
    @JsonProperty("celldankaiyon")
    private void setCelldankaiyon(celldankaiyonAttabShotokuiyondanka celldankaiyon) {
        this.celldankaiyon = celldankaiyon;
    }

    /*
     * getcell1
     * @return cell1
     */
    @JsonProperty("cell1")
    private cell1AttabShotokuiyondanka getCell1() {
        return cell1;
    }

    /*
     * setcell1
     * @param cell1 cell1
     */
    @JsonProperty("cell1")
    private void setCell1(cell1AttabShotokuiyondanka cell1) {
        this.cell1 = cell1;
    }

    /*
     * getcell2
     * @return cell2
     */
    @JsonProperty("cell2")
    private cell2AttabShotokuiyondanka getCell2() {
        return cell2;
    }

    /*
     * setcell2
     * @param cell2 cell2
     */
    @JsonProperty("cell2")
    private void setCell2(cell2AttabShotokuiyondanka cell2) {
        this.cell2 = cell2;
    }

    /*
     * getcellhokenshaValyon
     * @return cellhokenshaValyon
     */
    @JsonProperty("cellhokenshaValyon")
    private cellhokenshaValyonAttabShotokuiyondanka getCellhokenshaValyon() {
        return cellhokenshaValyon;
    }

    /*
     * setcellhokenshaValyon
     * @param cellhokenshaValyon cellhokenshaValyon
     */
    @JsonProperty("cellhokenshaValyon")
    private void setCellhokenshaValyon(cellhokenshaValyonAttabShotokuiyondanka cellhokenshaValyon) {
        this.cellhokenshaValyon = cellhokenshaValyon;
    }

    /*
     * getcellnendomatsugenzaihihokenshasuyon
     * @return cellnendomatsugenzaihihokenshasuyon
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuyon")
    private cellnendomatsugenzaihihokenshasuyonAttabShotokuiyondanka getCellnendomatsugenzaihihokenshasuyon() {
        return cellnendomatsugenzaihihokenshasuyon;
    }

    /*
     * setcellnendomatsugenzaihihokenshasuyon
     * @param cellnendomatsugenzaihihokenshasuyon cellnendomatsugenzaihihokenshasuyon
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuyon")
    private void setCellnendomatsugenzaihihokenshasuyon(cellnendomatsugenzaihihokenshasuyonAttabShotokuiyondanka cellnendomatsugenzaihihokenshasuyon) {
        this.cellnendomatsugenzaihihokenshasuyon = cellnendomatsugenzaihihokenshasuyon;
    }

    /*
     * getcellbikoValyon
     * @return cellbikoValyon
     */
    @JsonProperty("cellbikoValyon")
    private cellbikoValyonAttabShotokuiyondanka getCellbikoValyon() {
        return cellbikoValyon;
    }

    /*
     * setcellbikoValyon
     * @param cellbikoValyon cellbikoValyon
     */
    @JsonProperty("cellbikoValyon")
    private void setCellbikoValyon(cellbikoValyonAttabShotokuiyondanka cellbikoValyon) {
        this.cellbikoValyon = cellbikoValyon;
    }

    /*
     * getcellshichosonyonkaidan
     * @return cellshichosonyonkaidan
     */
    @JsonProperty("cellshichosonyonkaidan")
    private cellshichosonyonkaidanAttabShotokuiyondanka getCellshichosonyonkaidan() {
        return cellshichosonyonkaidan;
    }

    /*
     * setcellshichosonyonkaidan
     * @param cellshichosonyonkaidan cellshichosonyonkaidan
     */
    @JsonProperty("cellshichosonyonkaidan")
    private void setCellshichosonyonkaidan(cellshichosonyonkaidanAttabShotokuiyondanka cellshichosonyonkaidan) {
        this.cellshichosonyonkaidan = cellshichosonyonkaidan;
    }

    /*
     * getcelldanyondankai
     * @return celldanyondankai
     */
    @JsonProperty("celldanyondankai")
    private celldanyondankaiAttabShotokuiyondanka getCelldanyondankai() {
        return celldanyondankai;
    }

    /*
     * setcelldanyondankai
     * @param celldanyondankai celldanyondankai
     */
    @JsonProperty("celldanyondankai")
    private void setCelldanyondankai(celldanyondankaiAttabShotokuiyondanka celldanyondankai) {
        this.celldanyondankai = celldanyondankai;
    }

    /*
     * getcellyombunnoyon
     * @return cellyombunnoyon
     */
    @JsonProperty("cellyombunnoyon")
    private cellyombunnoyonAttabShotokuiyondanka getCellyombunnoyon() {
        return cellyombunnoyon;
    }

    /*
     * setcellyombunnoyon
     * @param cellyombunnoyon cellyombunnoyon
     */
    @JsonProperty("cellyombunnoyon")
    private void setCellyombunnoyon(cellyombunnoyonAttabShotokuiyondanka cellyombunnoyon) {
        this.cellyombunnoyon = cellyombunnoyon;
    }

    /*
     * getcellzeroyongo
     * @return cellzeroyongo
     */
    @JsonProperty("cellzeroyongo")
    private cellzeroyongoAttabShotokuiyondanka getCellzeroyongo() {
        return cellzeroyongo;
    }

    /*
     * setcellzeroyongo
     * @param cellzeroyongo cellzeroyongo
     */
    @JsonProperty("cellzeroyongo")
    private void setCellzeroyongo(cellzeroyongoAttabShotokuiyondanka cellzeroyongo) {
        this.cellzeroyongo = cellzeroyongo;
    }

    /*
     * getcellhokenshayondankai
     * @return cellhokenshayondankai
     */
    @JsonProperty("cellhokenshayondankai")
    private cellhokenshayondankaiAttabShotokuiyondanka getCellhokenshayondankai() {
        return cellhokenshayondankai;
    }

    /*
     * setcellhokenshayondankai
     * @param cellhokenshayondankai cellhokenshayondankai
     */
    @JsonProperty("cellhokenshayondankai")
    private void setCellhokenshayondankai(cellhokenshayondankaiAttabShotokuiyondanka cellhokenshayondankai) {
        this.cellhokenshayondankai = cellhokenshayondankai;
    }

    /*
     * getcellnendomatsugenzaihihokenshasuyondankai
     * @return cellnendomatsugenzaihihokenshasuyondankai
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuyondankai")
    private cellnendomatsugenzaihihokenshasuyondankaiAttabShotokuiyondanka getCellnendomatsugenzaihihokenshasuyondankai() {
        return cellnendomatsugenzaihihokenshasuyondankai;
    }

    /*
     * setcellnendomatsugenzaihihokenshasuyondankai
     * @param cellnendomatsugenzaihihokenshasuyondankai cellnendomatsugenzaihihokenshasuyondankai
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasuyondankai")
    private void setCellnendomatsugenzaihihokenshasuyondankai(cellnendomatsugenzaihihokenshasuyondankaiAttabShotokuiyondanka cellnendomatsugenzaihihokenshasuyondankai) {
        this.cellnendomatsugenzaihihokenshasuyondankai = cellnendomatsugenzaihihokenshasuyondankai;
    }

    /*
     * getcellbikoValyondankai
     * @return cellbikoValyondankai
     */
    @JsonProperty("cellbikoValyondankai")
    private cellbikoValyondankaiAttabShotokuiyondanka getCellbikoValyondankai() {
        return cellbikoValyondankai;
    }

    /*
     * setcellbikoValyondankai
     * @param cellbikoValyondankai cellbikoValyondankai
     */
    @JsonProperty("cellbikoValyondankai")
    private void setCellbikoValyondankai(cellbikoValyondankaiAttabShotokuiyondanka cellbikoValyondankai) {
        this.cellbikoValyondankai = cellbikoValyondankai;
    }

    /*
     * getcellshichosonyondankai
     * @return cellshichosonyondankai
     */
    @JsonProperty("cellshichosonyondankai")
    private cellshichosonyondankaiAttabShotokuiyondanka getCellshichosonyondankai() {
        return cellshichosonyondankai;
    }

    /*
     * setcellshichosonyondankai
     * @param cellshichosonyondankai cellshichosonyondankai
     */
    @JsonProperty("cellshichosonyondankai")
    private void setCellshichosonyondankai(cellshichosonyondankaiAttabShotokuiyondanka cellshichosonyondankai) {
        this.cellshichosonyondankai = cellshichosonyondankai;
    }

    // </editor-fold>
}
/**
 * celldankaiyon のクラスファイル 
 * 
 * @author 自動生成
 */
class celldankaiyonAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbldankaiyon")
    private Label lbldankaiyon;

    /*
     * getlbldankaiyon
     * @return lbldankaiyon
     */
    @JsonProperty("lbldankaiyon")
    public Label getLbldankaiyon() {
        return lbldankaiyon;
    }

    /*
     * setlbldankaiyon
     * @param lbldankaiyon lbldankaiyon
     */
    @JsonProperty("lbldankaiyon")
    public void setLbldankaiyon(Label lbldankaiyon) {
        this.lbldankaiyon = lbldankaiyon;
    }

    // </editor-fold>
}
/**
 * cell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell1AttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell2AttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellhokenshaValyon のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshaValyonAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelhokenshaValyon")
    private Label labelhokenshaValyon;

    /*
     * getlabelhokenshaValyon
     * @return labelhokenshaValyon
     */
    @JsonProperty("labelhokenshaValyon")
    public Label getLabelhokenshaValyon() {
        return labelhokenshaValyon;
    }

    /*
     * setlabelhokenshaValyon
     * @param labelhokenshaValyon labelhokenshaValyon
     */
    @JsonProperty("labelhokenshaValyon")
    public void setLabelhokenshaValyon(Label labelhokenshaValyon) {
        this.labelhokenshaValyon = labelhokenshaValyon;
    }

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasuyon のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasuyonAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtnendomatsugenzaihihokenshasuyon")
    private TextBoxNum txtnendomatsugenzaihihokenshasuyon;

    /*
     * gettxtnendomatsugenzaihihokenshasuyon
     * @return txtnendomatsugenzaihihokenshasuyon
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuyon")
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuyon() {
        return txtnendomatsugenzaihihokenshasuyon;
    }

    /*
     * settxtnendomatsugenzaihihokenshasuyon
     * @param txtnendomatsugenzaihihokenshasuyon txtnendomatsugenzaihihokenshasuyon
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuyon")
    public void setTxtnendomatsugenzaihihokenshasuyon(TextBoxNum txtnendomatsugenzaihihokenshasuyon) {
        this.txtnendomatsugenzaihihokenshasuyon = txtnendomatsugenzaihihokenshasuyon;
    }

    // </editor-fold>
}
/**
 * cellbikoValyon のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoValyonAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtbikoValyon")
    private Label txtbikoValyon;

    /*
     * gettxtbikoValyon
     * @return txtbikoValyon
     */
    @JsonProperty("txtbikoValyon")
    public Label getTxtbikoValyon() {
        return txtbikoValyon;
    }

    /*
     * settxtbikoValyon
     * @param txtbikoValyon txtbikoValyon
     */
    @JsonProperty("txtbikoValyon")
    public void setTxtbikoValyon(Label txtbikoValyon) {
        this.txtbikoValyon = txtbikoValyon;
    }

    // </editor-fold>
}
/**
 * cellshichosonyonkaidan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshichosonyonkaidanAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtshichosonyonkaidan")
    private TextBox txtshichosonyonkaidan;

    /*
     * gettxtshichosonyonkaidan
     * @return txtshichosonyonkaidan
     */
    @JsonProperty("txtshichosonyonkaidan")
    public TextBox getTxtshichosonyonkaidan() {
        return txtshichosonyonkaidan;
    }

    /*
     * settxtshichosonyonkaidan
     * @param txtshichosonyonkaidan txtshichosonyonkaidan
     */
    @JsonProperty("txtshichosonyonkaidan")
    public void setTxtshichosonyonkaidan(TextBox txtshichosonyonkaidan) {
        this.txtshichosonyonkaidan = txtshichosonyonkaidan;
    }

    // </editor-fold>
}
/**
 * celldanyondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celldanyondankaiAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbldanyondankai")
    private Label lbldanyondankai;

    /*
     * getlbldanyondankai
     * @return lbldanyondankai
     */
    @JsonProperty("lbldanyondankai")
    public Label getLbldanyondankai() {
        return lbldanyondankai;
    }

    /*
     * setlbldanyondankai
     * @param lbldanyondankai lbldanyondankai
     */
    @JsonProperty("lbldanyondankai")
    public void setLbldanyondankai(Label lbldanyondankai) {
        this.lbldanyondankai = lbldanyondankai;
    }

    // </editor-fold>
}
/**
 * cellyombunnoyon のクラスファイル 
 * 
 * @author 自動生成
 */
class cellyombunnoyonAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelyombunnoyon")
    private Label labelyombunnoyon;

    /*
     * getlabelyombunnoyon
     * @return labelyombunnoyon
     */
    @JsonProperty("labelyombunnoyon")
    public Label getLabelyombunnoyon() {
        return labelyombunnoyon;
    }

    /*
     * setlabelyombunnoyon
     * @param labelyombunnoyon labelyombunnoyon
     */
    @JsonProperty("labelyombunnoyon")
    public void setLabelyombunnoyon(Label labelyombunnoyon) {
        this.labelyombunnoyon = labelyombunnoyon;
    }

    // </editor-fold>
}
/**
 * cellzeroyongo のクラスファイル 
 * 
 * @author 自動生成
 */
class cellzeroyongoAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelzeroyongo")
    private Label labelzeroyongo;

    /*
     * getlabelzeroyongo
     * @return labelzeroyongo
     */
    @JsonProperty("labelzeroyongo")
    public Label getLabelzeroyongo() {
        return labelzeroyongo;
    }

    /*
     * setlabelzeroyongo
     * @param labelzeroyongo labelzeroyongo
     */
    @JsonProperty("labelzeroyongo")
    public void setLabelzeroyongo(Label labelzeroyongo) {
        this.labelzeroyongo = labelzeroyongo;
    }

    // </editor-fold>
}
/**
 * cellhokenshayondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshayondankaiAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelhokenshayondankai")
    private Label labelhokenshayondankai;

    /*
     * getlabelhokenshayondankai
     * @return labelhokenshayondankai
     */
    @JsonProperty("labelhokenshayondankai")
    public Label getLabelhokenshayondankai() {
        return labelhokenshayondankai;
    }

    /*
     * setlabelhokenshayondankai
     * @param labelhokenshayondankai labelhokenshayondankai
     */
    @JsonProperty("labelhokenshayondankai")
    public void setLabelhokenshayondankai(Label labelhokenshayondankai) {
        this.labelhokenshayondankai = labelhokenshayondankai;
    }

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasuyondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasuyondankaiAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtnendomatsugenzaihihokenshasuyondankai")
    private TextBoxNum txtnendomatsugenzaihihokenshasuyondankai;

    /*
     * gettxtnendomatsugenzaihihokenshasuyondankai
     * @return txtnendomatsugenzaihihokenshasuyondankai
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuyondankai")
    public TextBoxNum getTxtnendomatsugenzaihihokenshasuyondankai() {
        return txtnendomatsugenzaihihokenshasuyondankai;
    }

    /*
     * settxtnendomatsugenzaihihokenshasuyondankai
     * @param txtnendomatsugenzaihihokenshasuyondankai txtnendomatsugenzaihihokenshasuyondankai
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasuyondankai")
    public void setTxtnendomatsugenzaihihokenshasuyondankai(TextBoxNum txtnendomatsugenzaihihokenshasuyondankai) {
        this.txtnendomatsugenzaihihokenshasuyondankai = txtnendomatsugenzaihihokenshasuyondankai;
    }

    // </editor-fold>
}
/**
 * cellbikoValyondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoValyondankaiAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtbikoValyondankai")
    private Label txtbikoValyondankai;

    /*
     * gettxtbikoValyondankai
     * @return txtbikoValyondankai
     */
    @JsonProperty("txtbikoValyondankai")
    public Label getTxtbikoValyondankai() {
        return txtbikoValyondankai;
    }

    /*
     * settxtbikoValyondankai
     * @param txtbikoValyondankai txtbikoValyondankai
     */
    @JsonProperty("txtbikoValyondankai")
    public void setTxtbikoValyondankai(Label txtbikoValyondankai) {
        this.txtbikoValyondankai = txtbikoValyondankai;
    }

    // </editor-fold>
}
/**
 * cellshichosonyondankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshichosonyondankaiAttabShotokuiyondanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtshichosonyondankai")
    private TextBox txtshichosonyondankai;

    /*
     * gettxtshichosonyondankai
     * @return txtshichosonyondankai
     */
    @JsonProperty("txtshichosonyondankai")
    public TextBox getTxtshichosonyondankai() {
        return txtshichosonyondankai;
    }

    /*
     * settxtshichosonyondankai
     * @param txtshichosonyondankai txtshichosonyondankai
     */
    @JsonProperty("txtshichosonyondankai")
    public void setTxtshichosonyondankai(TextBox txtshichosonyondankai) {
        this.txtshichosonyondankai = txtshichosonyondankai;
    }

    // </editor-fold>
}
