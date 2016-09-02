package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011;
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
 * tblJikkoTani のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblJikkoTaniDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celJikkoTaniTitle")
    private celJikkoTaniTitleAttblJikkoTani celJikkoTaniTitle;
    @JsonProperty("celJikkoTani1")
    private celJikkoTani1AttblJikkoTani celJikkoTani1;
    @JsonProperty("celHokokuYM")
    private celHokokuYMAttblJikkoTani celHokokuYM;
    @JsonProperty("celJikkoTani2")
    private celJikkoTani2AttblJikkoTani celJikkoTani2;
    @JsonProperty("celJikkoTani3")
    private celJikkoTani3AttblJikkoTani celJikkoTani3;
    @JsonProperty("celKakoHokokuYM")
    private celKakoHokokuYMAttblJikkoTani celKakoHokokuYM;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblJikkoTaniTitle() {
        return this.celJikkoTaniTitle.getLblJikkoTaniTitle();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniShukeiOnly() {
        return this.celJikkoTani1.getRadJikkoTaniShukeiOnly();
    }

    @JsonIgnore
    public HokokuNendoDiv getHokokuNendo() {
        return this.celHokokuYM.getHokokuNendo();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTani2() {
        return this.celJikkoTani2.getRadJikkoTani2();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTani3() {
        return this.celJikkoTani3.getRadJikkoTani3();
    }

    @JsonIgnore
    public DropDownList getDdlKakoHokokuNendo() {
        return this.celKakoHokokuYM.getDdlKakoHokokuNendo();
    }

    @JsonIgnore
    public RadioButton getRadGappeiShichoson() {
        return this.celKakoHokokuYM.getRadGappeiShichoson();
    }

    @JsonIgnore
    public RadioButton getRadKoikiRengo() {
        return this.celKakoHokokuYM.getRadKoikiRengo();
    }

    @JsonIgnore
    public ButtonDialog getBtnShichosonSelect() {
        return this.celKakoHokokuYM.getBtnShichosonSelect();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelJikkoTaniTitle
     * @return celJikkoTaniTitle
     */
    @JsonProperty("celJikkoTaniTitle")
    private celJikkoTaniTitleAttblJikkoTani getCelJikkoTaniTitle() {
        return celJikkoTaniTitle;
    }

    /*
     * setcelJikkoTaniTitle
     * @param celJikkoTaniTitle celJikkoTaniTitle
     */
    @JsonProperty("celJikkoTaniTitle")
    private void setCelJikkoTaniTitle(celJikkoTaniTitleAttblJikkoTani celJikkoTaniTitle) {
        this.celJikkoTaniTitle = celJikkoTaniTitle;
    }

    /*
     * getcelJikkoTani1
     * @return celJikkoTani1
     */
    @JsonProperty("celJikkoTani1")
    private celJikkoTani1AttblJikkoTani getCelJikkoTani1() {
        return celJikkoTani1;
    }

    /*
     * setcelJikkoTani1
     * @param celJikkoTani1 celJikkoTani1
     */
    @JsonProperty("celJikkoTani1")
    private void setCelJikkoTani1(celJikkoTani1AttblJikkoTani celJikkoTani1) {
        this.celJikkoTani1 = celJikkoTani1;
    }

    /*
     * getcelHokokuYM
     * @return celHokokuYM
     */
    @JsonProperty("celHokokuYM")
    private celHokokuYMAttblJikkoTani getCelHokokuYM() {
        return celHokokuYM;
    }

    /*
     * setcelHokokuYM
     * @param celHokokuYM celHokokuYM
     */
    @JsonProperty("celHokokuYM")
    private void setCelHokokuYM(celHokokuYMAttblJikkoTani celHokokuYM) {
        this.celHokokuYM = celHokokuYM;
    }

    /*
     * getcelJikkoTani2
     * @return celJikkoTani2
     */
    @JsonProperty("celJikkoTani2")
    private celJikkoTani2AttblJikkoTani getCelJikkoTani2() {
        return celJikkoTani2;
    }

    /*
     * setcelJikkoTani2
     * @param celJikkoTani2 celJikkoTani2
     */
    @JsonProperty("celJikkoTani2")
    private void setCelJikkoTani2(celJikkoTani2AttblJikkoTani celJikkoTani2) {
        this.celJikkoTani2 = celJikkoTani2;
    }

    /*
     * getcelJikkoTani3
     * @return celJikkoTani3
     */
    @JsonProperty("celJikkoTani3")
    private celJikkoTani3AttblJikkoTani getCelJikkoTani3() {
        return celJikkoTani3;
    }

    /*
     * setcelJikkoTani3
     * @param celJikkoTani3 celJikkoTani3
     */
    @JsonProperty("celJikkoTani3")
    private void setCelJikkoTani3(celJikkoTani3AttblJikkoTani celJikkoTani3) {
        this.celJikkoTani3 = celJikkoTani3;
    }

    /*
     * getcelKakoHokokuYM
     * @return celKakoHokokuYM
     */
    @JsonProperty("celKakoHokokuYM")
    private celKakoHokokuYMAttblJikkoTani getCelKakoHokokuYM() {
        return celKakoHokokuYM;
    }

    /*
     * setcelKakoHokokuYM
     * @param celKakoHokokuYM celKakoHokokuYM
     */
    @JsonProperty("celKakoHokokuYM")
    private void setCelKakoHokokuYM(celKakoHokokuYMAttblJikkoTani celKakoHokokuYM) {
        this.celKakoHokokuYM = celKakoHokokuYM;
    }

    // </editor-fold>
}
/**
 * celJikkoTaniTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTaniTitleAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblJikkoTaniTitle")
    private Label lblJikkoTaniTitle;

    /*
     * getlblJikkoTaniTitle
     * @return lblJikkoTaniTitle
     */
    @JsonProperty("lblJikkoTaniTitle")
    public Label getLblJikkoTaniTitle() {
        return lblJikkoTaniTitle;
    }

    /*
     * setlblJikkoTaniTitle
     * @param lblJikkoTaniTitle lblJikkoTaniTitle
     */
    @JsonProperty("lblJikkoTaniTitle")
    public void setLblJikkoTaniTitle(Label lblJikkoTaniTitle) {
        this.lblJikkoTaniTitle = lblJikkoTaniTitle;
    }

    // </editor-fold>
}
/**
 * celJikkoTani1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTani1AttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("radJikkoTaniShukeiOnly")
    private RadioButton radJikkoTaniShukeiOnly;

    /*
     * getradJikkoTaniShukeiOnly
     * @return radJikkoTaniShukeiOnly
     */
    @JsonProperty("radJikkoTaniShukeiOnly")
    public RadioButton getRadJikkoTaniShukeiOnly() {
        return radJikkoTaniShukeiOnly;
    }

    /*
     * setradJikkoTaniShukeiOnly
     * @param radJikkoTaniShukeiOnly radJikkoTaniShukeiOnly
     */
    @JsonProperty("radJikkoTaniShukeiOnly")
    public void setRadJikkoTaniShukeiOnly(RadioButton radJikkoTaniShukeiOnly) {
        this.radJikkoTaniShukeiOnly = radJikkoTaniShukeiOnly;
    }

    // </editor-fold>
}
/**
 * celHokokuYM のクラスファイル 
 * 
 * @author 自動生成
 */
class celHokokuYMAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("HokokuNendo")
    private HokokuNendoDiv HokokuNendo;

    /*
     * getHokokuNendo
     * @return HokokuNendo
     */
    @JsonProperty("HokokuNendo")
    public HokokuNendoDiv getHokokuNendo() {
        return HokokuNendo;
    }

    /*
     * setHokokuNendo
     * @param HokokuNendo HokokuNendo
     */
    @JsonProperty("HokokuNendo")
    public void setHokokuNendo(HokokuNendoDiv HokokuNendo) {
        this.HokokuNendo = HokokuNendo;
    }

    // </editor-fold>
}
/**
 * celJikkoTani2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTani2AttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("radJikkoTani2")
    private RadioButton radJikkoTani2;

    /*
     * getradJikkoTani2
     * @return radJikkoTani2
     */
    @JsonProperty("radJikkoTani2")
    public RadioButton getRadJikkoTani2() {
        return radJikkoTani2;
    }

    /*
     * setradJikkoTani2
     * @param radJikkoTani2 radJikkoTani2
     */
    @JsonProperty("radJikkoTani2")
    public void setRadJikkoTani2(RadioButton radJikkoTani2) {
        this.radJikkoTani2 = radJikkoTani2;
    }

    // </editor-fold>
}
/**
 * celJikkoTani3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTani3AttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("radJikkoTani3")
    private RadioButton radJikkoTani3;

    /*
     * getradJikkoTani3
     * @return radJikkoTani3
     */
    @JsonProperty("radJikkoTani3")
    public RadioButton getRadJikkoTani3() {
        return radJikkoTani3;
    }

    /*
     * setradJikkoTani3
     * @param radJikkoTani3 radJikkoTani3
     */
    @JsonProperty("radJikkoTani3")
    public void setRadJikkoTani3(RadioButton radJikkoTani3) {
        this.radJikkoTani3 = radJikkoTani3;
    }

    // </editor-fold>
}
/**
 * celKakoHokokuYM のクラスファイル 
 * 
 * @author 自動生成
 */
class celKakoHokokuYMAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("ddlKakoHokokuNendo")
    private DropDownList ddlKakoHokokuNendo;
    @JsonProperty("radGappeiShichoson")
    private RadioButton radGappeiShichoson;
    @JsonProperty("radKoikiRengo")
    private RadioButton radKoikiRengo;
    @JsonProperty("btnShichosonSelect")
    private ButtonDialog btnShichosonSelect;

    /*
     * getddlKakoHokokuNendo
     * @return ddlKakoHokokuNendo
     */
    @JsonProperty("ddlKakoHokokuNendo")
    public DropDownList getDdlKakoHokokuNendo() {
        return ddlKakoHokokuNendo;
    }

    /*
     * setddlKakoHokokuNendo
     * @param ddlKakoHokokuNendo ddlKakoHokokuNendo
     */
    @JsonProperty("ddlKakoHokokuNendo")
    public void setDdlKakoHokokuNendo(DropDownList ddlKakoHokokuNendo) {
        this.ddlKakoHokokuNendo = ddlKakoHokokuNendo;
    }

    /*
     * getradGappeiShichoson
     * @return radGappeiShichoson
     */
    @JsonProperty("radGappeiShichoson")
    public RadioButton getRadGappeiShichoson() {
        return radGappeiShichoson;
    }

    /*
     * setradGappeiShichoson
     * @param radGappeiShichoson radGappeiShichoson
     */
    @JsonProperty("radGappeiShichoson")
    public void setRadGappeiShichoson(RadioButton radGappeiShichoson) {
        this.radGappeiShichoson = radGappeiShichoson;
    }

    /*
     * getradKoikiRengo
     * @return radKoikiRengo
     */
    @JsonProperty("radKoikiRengo")
    public RadioButton getRadKoikiRengo() {
        return radKoikiRengo;
    }

    /*
     * setradKoikiRengo
     * @param radKoikiRengo radKoikiRengo
     */
    @JsonProperty("radKoikiRengo")
    public void setRadKoikiRengo(RadioButton radKoikiRengo) {
        this.radKoikiRengo = radKoikiRengo;
    }

    /*
     * getbtnShichosonSelect
     * @return btnShichosonSelect
     */
    @JsonProperty("btnShichosonSelect")
    public ButtonDialog getBtnShichosonSelect() {
        return btnShichosonSelect;
    }

    /*
     * setbtnShichosonSelect
     * @param btnShichosonSelect btnShichosonSelect
     */
    @JsonProperty("btnShichosonSelect")
    public void setBtnShichosonSelect(ButtonDialog btnShichosonSelect) {
        this.btnShichosonSelect = btnShichosonSelect;
    }

    // </editor-fold>
}
