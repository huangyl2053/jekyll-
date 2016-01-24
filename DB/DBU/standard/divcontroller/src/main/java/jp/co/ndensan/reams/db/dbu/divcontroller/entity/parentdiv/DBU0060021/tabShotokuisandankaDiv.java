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
 * tabShotokuisandanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShotokuisandankaDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celldankaisan")
    private celldankaisanAttabShotokuisandanka celldankaisan;
    @JsonProperty("cellyombunnonisan")
    private cellyombunnonisanAttabShotokuisandanka cellyombunnonisan;
    @JsonProperty("cellzerogosan")
    private cellzerogosanAttabShotokuisandanka cellzerogosan;
    @JsonProperty("cellhokenshaValsan")
    private cellhokenshaValsanAttabShotokuisandanka cellhokenshaValsan;
    @JsonProperty("cellnendomatsugenzaihihokenshasusan")
    private cellnendomatsugenzaihihokenshasusanAttabShotokuisandanka cellnendomatsugenzaihihokenshasusan;
    @JsonProperty("cellbikoValsan")
    private cellbikoValsanAttabShotokuisandanka cellbikoValsan;
    @JsonProperty("cellshichosonsankaidan")
    private cellshichosonsankaidanAttabShotokuisandanka cellshichosonsankaidan;
    @JsonProperty("celldansandankai")
    private celldansandankaiAttabShotokuisandanka celldansandankai;
    @JsonProperty("cellyombunnosan")
    private cellyombunnosanAttabShotokuisandanka cellyombunnosan;
    @JsonProperty("cellzerosango")
    private cellzerosangoAttabShotokuisandanka cellzerosango;
    @JsonProperty("cellhokenshadankai")
    private cellhokenshadankaiAttabShotokuisandanka cellhokenshadankai;
    @JsonProperty("cellnendomatsugenzaihihokenshasusandankai")
    private cellnendomatsugenzaihihokenshasusandankaiAttabShotokuisandanka cellnendomatsugenzaihihokenshasusandankai;
    @JsonProperty("cellbikoValsandankai")
    private cellbikoValsandankaiAttabShotokuisandanka cellbikoValsandankai;
    @JsonProperty("cellnnshichosonsandankai")
    private cellnnshichosonsandankaiAttabShotokuisandanka cellnnshichosonsandankai;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLbltokureidankaisan() {
        return this.celldankaisan.getLbltokureidankaisan();
    }

    @JsonIgnore
    public Label getLabelhokenshaValsan() {
        return this.cellhokenshaValsan.getLabelhokenshaValsan();
    }

    @JsonIgnore
    public TextBoxNum getTxtnendomatsugenzaihihokenshasusan() {
        return this.cellnendomatsugenzaihihokenshasusan.getTxtnendomatsugenzaihihokenshasusan();
    }

    @JsonIgnore
    public Label getTxtbikoValsan() {
        return this.cellbikoValsan.getTxtbikoValsan();
    }

    @JsonIgnore
    public TextBox getTxtshichosonsan() {
        return this.cellshichosonsankaidan.getTxtshichosonsan();
    }

    @JsonIgnore
    public Label getLbldansandankai() {
        return this.celldansandankai.getLbldansandankai();
    }

    @JsonIgnore
    public Label getLabelyombunnonisan() {
        return this.cellyombunnosan.getLabelyombunnonisan();
    }

    @JsonIgnore
    public Label getLabelzerosango() {
        return this.cellzerosango.getLabelzerosango();
    }

    @JsonIgnore
    public Label getLabelhokenshadankai() {
        return this.cellhokenshadankai.getLabelhokenshadankai();
    }

    @JsonIgnore
    public TextBoxNum getTxtnendomatsugenzaihihokensu() {
        return this.cellnendomatsugenzaihihokenshasusandankai.getTxtnendomatsugenzaihihokensu();
    }

    @JsonIgnore
    public Label getTxtbikoValsandankai() {
        return this.cellbikoValsandankai.getTxtbikoValsandankai();
    }

    @JsonIgnore
    public TextBox getTxtshichosonsandankai() {
        return this.cellnnshichosonsandankai.getTxtshichosonsandankai();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelldankaisan
     * @return celldankaisan
     */
    @JsonProperty("celldankaisan")
    private celldankaisanAttabShotokuisandanka getCelldankaisan() {
        return celldankaisan;
    }

    /*
     * setcelldankaisan
     * @param celldankaisan celldankaisan
     */
    @JsonProperty("celldankaisan")
    private void setCelldankaisan(celldankaisanAttabShotokuisandanka celldankaisan) {
        this.celldankaisan = celldankaisan;
    }

    /*
     * getcellyombunnonisan
     * @return cellyombunnonisan
     */
    @JsonProperty("cellyombunnonisan")
    private cellyombunnonisanAttabShotokuisandanka getCellyombunnonisan() {
        return cellyombunnonisan;
    }

    /*
     * setcellyombunnonisan
     * @param cellyombunnonisan cellyombunnonisan
     */
    @JsonProperty("cellyombunnonisan")
    private void setCellyombunnonisan(cellyombunnonisanAttabShotokuisandanka cellyombunnonisan) {
        this.cellyombunnonisan = cellyombunnonisan;
    }

    /*
     * getcellzerogosan
     * @return cellzerogosan
     */
    @JsonProperty("cellzerogosan")
    private cellzerogosanAttabShotokuisandanka getCellzerogosan() {
        return cellzerogosan;
    }

    /*
     * setcellzerogosan
     * @param cellzerogosan cellzerogosan
     */
    @JsonProperty("cellzerogosan")
    private void setCellzerogosan(cellzerogosanAttabShotokuisandanka cellzerogosan) {
        this.cellzerogosan = cellzerogosan;
    }

    /*
     * getcellhokenshaValsan
     * @return cellhokenshaValsan
     */
    @JsonProperty("cellhokenshaValsan")
    private cellhokenshaValsanAttabShotokuisandanka getCellhokenshaValsan() {
        return cellhokenshaValsan;
    }

    /*
     * setcellhokenshaValsan
     * @param cellhokenshaValsan cellhokenshaValsan
     */
    @JsonProperty("cellhokenshaValsan")
    private void setCellhokenshaValsan(cellhokenshaValsanAttabShotokuisandanka cellhokenshaValsan) {
        this.cellhokenshaValsan = cellhokenshaValsan;
    }

    /*
     * getcellnendomatsugenzaihihokenshasusan
     * @return cellnendomatsugenzaihihokenshasusan
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasusan")
    private cellnendomatsugenzaihihokenshasusanAttabShotokuisandanka getCellnendomatsugenzaihihokenshasusan() {
        return cellnendomatsugenzaihihokenshasusan;
    }

    /*
     * setcellnendomatsugenzaihihokenshasusan
     * @param cellnendomatsugenzaihihokenshasusan cellnendomatsugenzaihihokenshasusan
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasusan")
    private void setCellnendomatsugenzaihihokenshasusan(cellnendomatsugenzaihihokenshasusanAttabShotokuisandanka cellnendomatsugenzaihihokenshasusan) {
        this.cellnendomatsugenzaihihokenshasusan = cellnendomatsugenzaihihokenshasusan;
    }

    /*
     * getcellbikoValsan
     * @return cellbikoValsan
     */
    @JsonProperty("cellbikoValsan")
    private cellbikoValsanAttabShotokuisandanka getCellbikoValsan() {
        return cellbikoValsan;
    }

    /*
     * setcellbikoValsan
     * @param cellbikoValsan cellbikoValsan
     */
    @JsonProperty("cellbikoValsan")
    private void setCellbikoValsan(cellbikoValsanAttabShotokuisandanka cellbikoValsan) {
        this.cellbikoValsan = cellbikoValsan;
    }

    /*
     * getcellshichosonsankaidan
     * @return cellshichosonsankaidan
     */
    @JsonProperty("cellshichosonsankaidan")
    private cellshichosonsankaidanAttabShotokuisandanka getCellshichosonsankaidan() {
        return cellshichosonsankaidan;
    }

    /*
     * setcellshichosonsankaidan
     * @param cellshichosonsankaidan cellshichosonsankaidan
     */
    @JsonProperty("cellshichosonsankaidan")
    private void setCellshichosonsankaidan(cellshichosonsankaidanAttabShotokuisandanka cellshichosonsankaidan) {
        this.cellshichosonsankaidan = cellshichosonsankaidan;
    }

    /*
     * getcelldansandankai
     * @return celldansandankai
     */
    @JsonProperty("celldansandankai")
    private celldansandankaiAttabShotokuisandanka getCelldansandankai() {
        return celldansandankai;
    }

    /*
     * setcelldansandankai
     * @param celldansandankai celldansandankai
     */
    @JsonProperty("celldansandankai")
    private void setCelldansandankai(celldansandankaiAttabShotokuisandanka celldansandankai) {
        this.celldansandankai = celldansandankai;
    }

    /*
     * getcellyombunnosan
     * @return cellyombunnosan
     */
    @JsonProperty("cellyombunnosan")
    private cellyombunnosanAttabShotokuisandanka getCellyombunnosan() {
        return cellyombunnosan;
    }

    /*
     * setcellyombunnosan
     * @param cellyombunnosan cellyombunnosan
     */
    @JsonProperty("cellyombunnosan")
    private void setCellyombunnosan(cellyombunnosanAttabShotokuisandanka cellyombunnosan) {
        this.cellyombunnosan = cellyombunnosan;
    }

    /*
     * getcellzerosango
     * @return cellzerosango
     */
    @JsonProperty("cellzerosango")
    private cellzerosangoAttabShotokuisandanka getCellzerosango() {
        return cellzerosango;
    }

    /*
     * setcellzerosango
     * @param cellzerosango cellzerosango
     */
    @JsonProperty("cellzerosango")
    private void setCellzerosango(cellzerosangoAttabShotokuisandanka cellzerosango) {
        this.cellzerosango = cellzerosango;
    }

    /*
     * getcellhokenshadankai
     * @return cellhokenshadankai
     */
    @JsonProperty("cellhokenshadankai")
    private cellhokenshadankaiAttabShotokuisandanka getCellhokenshadankai() {
        return cellhokenshadankai;
    }

    /*
     * setcellhokenshadankai
     * @param cellhokenshadankai cellhokenshadankai
     */
    @JsonProperty("cellhokenshadankai")
    private void setCellhokenshadankai(cellhokenshadankaiAttabShotokuisandanka cellhokenshadankai) {
        this.cellhokenshadankai = cellhokenshadankai;
    }

    /*
     * getcellnendomatsugenzaihihokenshasusandankai
     * @return cellnendomatsugenzaihihokenshasusandankai
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasusandankai")
    private cellnendomatsugenzaihihokenshasusandankaiAttabShotokuisandanka getCellnendomatsugenzaihihokenshasusandankai() {
        return cellnendomatsugenzaihihokenshasusandankai;
    }

    /*
     * setcellnendomatsugenzaihihokenshasusandankai
     * @param cellnendomatsugenzaihihokenshasusandankai cellnendomatsugenzaihihokenshasusandankai
     */
    @JsonProperty("cellnendomatsugenzaihihokenshasusandankai")
    private void setCellnendomatsugenzaihihokenshasusandankai(cellnendomatsugenzaihihokenshasusandankaiAttabShotokuisandanka cellnendomatsugenzaihihokenshasusandankai) {
        this.cellnendomatsugenzaihihokenshasusandankai = cellnendomatsugenzaihihokenshasusandankai;
    }

    /*
     * getcellbikoValsandankai
     * @return cellbikoValsandankai
     */
    @JsonProperty("cellbikoValsandankai")
    private cellbikoValsandankaiAttabShotokuisandanka getCellbikoValsandankai() {
        return cellbikoValsandankai;
    }

    /*
     * setcellbikoValsandankai
     * @param cellbikoValsandankai cellbikoValsandankai
     */
    @JsonProperty("cellbikoValsandankai")
    private void setCellbikoValsandankai(cellbikoValsandankaiAttabShotokuisandanka cellbikoValsandankai) {
        this.cellbikoValsandankai = cellbikoValsandankai;
    }

    /*
     * getcellnnshichosonsandankai
     * @return cellnnshichosonsandankai
     */
    @JsonProperty("cellnnshichosonsandankai")
    private cellnnshichosonsandankaiAttabShotokuisandanka getCellnnshichosonsandankai() {
        return cellnnshichosonsandankai;
    }

    /*
     * setcellnnshichosonsandankai
     * @param cellnnshichosonsandankai cellnnshichosonsandankai
     */
    @JsonProperty("cellnnshichosonsandankai")
    private void setCellnnshichosonsandankai(cellnnshichosonsandankaiAttabShotokuisandanka cellnnshichosonsandankai) {
        this.cellnnshichosonsandankai = cellnnshichosonsandankai;
    }

    // </editor-fold>
}
/**
 * celldankaisan のクラスファイル 
 * 
 * @author 自動生成
 */
class celldankaisanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbltokureidankaisan")
    private Label lbltokureidankaisan;

    /*
     * getlbltokureidankaisan
     * @return lbltokureidankaisan
     */
    @JsonProperty("lbltokureidankaisan")
    public Label getLbltokureidankaisan() {
        return lbltokureidankaisan;
    }

    /*
     * setlbltokureidankaisan
     * @param lbltokureidankaisan lbltokureidankaisan
     */
    @JsonProperty("lbltokureidankaisan")
    public void setLbltokureidankaisan(Label lbltokureidankaisan) {
        this.lbltokureidankaisan = lbltokureidankaisan;
    }

    // </editor-fold>
}
/**
 * cellyombunnonisan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellyombunnonisanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellzerogosan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellzerogosanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    // </editor-fold>
}
/**
 * cellhokenshaValsan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshaValsanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelhokenshaValsan")
    private Label labelhokenshaValsan;

    /*
     * getlabelhokenshaValsan
     * @return labelhokenshaValsan
     */
    @JsonProperty("labelhokenshaValsan")
    public Label getLabelhokenshaValsan() {
        return labelhokenshaValsan;
    }

    /*
     * setlabelhokenshaValsan
     * @param labelhokenshaValsan labelhokenshaValsan
     */
    @JsonProperty("labelhokenshaValsan")
    public void setLabelhokenshaValsan(Label labelhokenshaValsan) {
        this.labelhokenshaValsan = labelhokenshaValsan;
    }

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasusan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasusanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtnendomatsugenzaihihokenshasusan")
    private TextBoxNum txtnendomatsugenzaihihokenshasusan;

    /*
     * gettxtnendomatsugenzaihihokenshasusan
     * @return txtnendomatsugenzaihihokenshasusan
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasusan")
    public TextBoxNum getTxtnendomatsugenzaihihokenshasusan() {
        return txtnendomatsugenzaihihokenshasusan;
    }

    /*
     * settxtnendomatsugenzaihihokenshasusan
     * @param txtnendomatsugenzaihihokenshasusan txtnendomatsugenzaihihokenshasusan
     */
    @JsonProperty("txtnendomatsugenzaihihokenshasusan")
    public void setTxtnendomatsugenzaihihokenshasusan(TextBoxNum txtnendomatsugenzaihihokenshasusan) {
        this.txtnendomatsugenzaihihokenshasusan = txtnendomatsugenzaihihokenshasusan;
    }

    // </editor-fold>
}
/**
 * cellbikoValsan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoValsanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtbikoValsan")
    private Label txtbikoValsan;

    /*
     * gettxtbikoValsan
     * @return txtbikoValsan
     */
    @JsonProperty("txtbikoValsan")
    public Label getTxtbikoValsan() {
        return txtbikoValsan;
    }

    /*
     * settxtbikoValsan
     * @param txtbikoValsan txtbikoValsan
     */
    @JsonProperty("txtbikoValsan")
    public void setTxtbikoValsan(Label txtbikoValsan) {
        this.txtbikoValsan = txtbikoValsan;
    }

    // </editor-fold>
}
/**
 * cellshichosonsankaidan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellshichosonsankaidanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtshichosonsan")
    private TextBox txtshichosonsan;

    /*
     * gettxtshichosonsan
     * @return txtshichosonsan
     */
    @JsonProperty("txtshichosonsan")
    public TextBox getTxtshichosonsan() {
        return txtshichosonsan;
    }

    /*
     * settxtshichosonsan
     * @param txtshichosonsan txtshichosonsan
     */
    @JsonProperty("txtshichosonsan")
    public void setTxtshichosonsan(TextBox txtshichosonsan) {
        this.txtshichosonsan = txtshichosonsan;
    }

    // </editor-fold>
}
/**
 * celldansandankai のクラスファイル 
 * 
 * @author 自動生成
 */
class celldansandankaiAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lbldansandankai")
    private Label lbldansandankai;

    /*
     * getlbldansandankai
     * @return lbldansandankai
     */
    @JsonProperty("lbldansandankai")
    public Label getLbldansandankai() {
        return lbldansandankai;
    }

    /*
     * setlbldansandankai
     * @param lbldansandankai lbldansandankai
     */
    @JsonProperty("lbldansandankai")
    public void setLbldansandankai(Label lbldansandankai) {
        this.lbldansandankai = lbldansandankai;
    }

    // </editor-fold>
}
/**
 * cellyombunnosan のクラスファイル 
 * 
 * @author 自動生成
 */
class cellyombunnosanAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelyombunnonisan")
    private Label labelyombunnonisan;

    /*
     * getlabelyombunnonisan
     * @return labelyombunnonisan
     */
    @JsonProperty("labelyombunnonisan")
    public Label getLabelyombunnonisan() {
        return labelyombunnonisan;
    }

    /*
     * setlabelyombunnonisan
     * @param labelyombunnonisan labelyombunnonisan
     */
    @JsonProperty("labelyombunnonisan")
    public void setLabelyombunnonisan(Label labelyombunnonisan) {
        this.labelyombunnonisan = labelyombunnonisan;
    }

    // </editor-fold>
}
/**
 * cellzerosango のクラスファイル 
 * 
 * @author 自動生成
 */
class cellzerosangoAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelzerosango")
    private Label labelzerosango;

    /*
     * getlabelzerosango
     * @return labelzerosango
     */
    @JsonProperty("labelzerosango")
    public Label getLabelzerosango() {
        return labelzerosango;
    }

    /*
     * setlabelzerosango
     * @param labelzerosango labelzerosango
     */
    @JsonProperty("labelzerosango")
    public void setLabelzerosango(Label labelzerosango) {
        this.labelzerosango = labelzerosango;
    }

    // </editor-fold>
}
/**
 * cellhokenshadankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellhokenshadankaiAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("labelhokenshadankai")
    private Label labelhokenshadankai;

    /*
     * getlabelhokenshadankai
     * @return labelhokenshadankai
     */
    @JsonProperty("labelhokenshadankai")
    public Label getLabelhokenshadankai() {
        return labelhokenshadankai;
    }

    /*
     * setlabelhokenshadankai
     * @param labelhokenshadankai labelhokenshadankai
     */
    @JsonProperty("labelhokenshadankai")
    public void setLabelhokenshadankai(Label labelhokenshadankai) {
        this.labelhokenshadankai = labelhokenshadankai;
    }

    // </editor-fold>
}
/**
 * cellnendomatsugenzaihihokenshasusandankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnendomatsugenzaihihokenshasusandankaiAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtnendomatsugenzaihihokensu")
    private TextBoxNum txtnendomatsugenzaihihokensu;

    /*
     * gettxtnendomatsugenzaihihokensu
     * @return txtnendomatsugenzaihihokensu
     */
    @JsonProperty("txtnendomatsugenzaihihokensu")
    public TextBoxNum getTxtnendomatsugenzaihihokensu() {
        return txtnendomatsugenzaihihokensu;
    }

    /*
     * settxtnendomatsugenzaihihokensu
     * @param txtnendomatsugenzaihihokensu txtnendomatsugenzaihihokensu
     */
    @JsonProperty("txtnendomatsugenzaihihokensu")
    public void setTxtnendomatsugenzaihihokensu(TextBoxNum txtnendomatsugenzaihihokensu) {
        this.txtnendomatsugenzaihihokensu = txtnendomatsugenzaihihokensu;
    }

    // </editor-fold>
}
/**
 * cellbikoValsandankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellbikoValsandankaiAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtbikoValsandankai")
    private Label txtbikoValsandankai;

    /*
     * gettxtbikoValsandankai
     * @return txtbikoValsandankai
     */
    @JsonProperty("txtbikoValsandankai")
    public Label getTxtbikoValsandankai() {
        return txtbikoValsandankai;
    }

    /*
     * settxtbikoValsandankai
     * @param txtbikoValsandankai txtbikoValsandankai
     */
    @JsonProperty("txtbikoValsandankai")
    public void setTxtbikoValsandankai(Label txtbikoValsandankai) {
        this.txtbikoValsandankai = txtbikoValsandankai;
    }

    // </editor-fold>
}
/**
 * cellnnshichosonsandankai のクラスファイル 
 * 
 * @author 自動生成
 */
class cellnnshichosonsandankaiAttabShotokuisandanka extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtshichosonsandankai")
    private TextBox txtshichosonsandankai;

    /*
     * gettxtshichosonsandankai
     * @return txtshichosonsandankai
     */
    @JsonProperty("txtshichosonsandankai")
    public TextBox getTxtshichosonsandankai() {
        return txtshichosonsandankai;
    }

    /*
     * settxtshichosonsandankai
     * @param txtshichosonsandankai txtshichosonsandankai
     */
    @JsonProperty("txtshichosonsandankai")
    public void setTxtshichosonsandankai(TextBox txtshichosonsandankai) {
        this.txtshichosonsandankai = txtshichosonsandankai;
    }

    // </editor-fold>
}
