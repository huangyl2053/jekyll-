package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celJikkoTaniTitle")
    private celJikkoTaniTitleAttblJikkoTani celJikkoTaniTitle;
    @JsonProperty("celJikkoTaniShukeiOnly")
    private celJikkoTaniShukeiOnlyAttblJikkoTani celJikkoTaniShukeiOnly;
    @JsonProperty("celHokokuYM")
    private celHokokuYMAttblJikkoTani celHokokuYM;
    @JsonProperty("celJikkoTaniShukeiAfterPrint")
    private celJikkoTaniShukeiAfterPrintAttblJikkoTani celJikkoTaniShukeiAfterPrint;
    @JsonProperty("celJikkoTaniKakoShukeiKekka")
    private celJikkoTaniKakoShukeiKekkaAttblJikkoTani celJikkoTaniKakoShukeiKekka;
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
        return this.celJikkoTaniShukeiOnly.getRadJikkoTaniShukeiOnly();
    }

    @JsonIgnore
    public TextBoxDate getTxtHokokuYM() {
        return this.celHokokuYM.getTxtHokokuYM();
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.celHokokuYM.getBtnKakutei();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniShukeiAfterPrint() {
        return this.celJikkoTaniShukeiAfterPrint.getRadJikkoTaniShukeiAfterPrint();
    }

    @JsonIgnore
    public RadioButton getRadJikkoTaniKakoShukeiKekka() {
        return this.celJikkoTaniKakoShukeiKekka.getRadJikkoTaniKakoShukeiKekka();
    }

    @JsonIgnore
    public DropDownList getDdlKakoHokokuYM() {
        return this.celKakoHokokuYM.getDdlKakoHokokuYM();
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
     * getcelJikkoTaniShukeiOnly
     * @return celJikkoTaniShukeiOnly
     */
    @JsonProperty("celJikkoTaniShukeiOnly")
    private celJikkoTaniShukeiOnlyAttblJikkoTani getCelJikkoTaniShukeiOnly() {
        return celJikkoTaniShukeiOnly;
    }

    /*
     * setcelJikkoTaniShukeiOnly
     * @param celJikkoTaniShukeiOnly celJikkoTaniShukeiOnly
     */
    @JsonProperty("celJikkoTaniShukeiOnly")
    private void setCelJikkoTaniShukeiOnly(celJikkoTaniShukeiOnlyAttblJikkoTani celJikkoTaniShukeiOnly) {
        this.celJikkoTaniShukeiOnly = celJikkoTaniShukeiOnly;
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
     * getcelJikkoTaniShukeiAfterPrint
     * @return celJikkoTaniShukeiAfterPrint
     */
    @JsonProperty("celJikkoTaniShukeiAfterPrint")
    private celJikkoTaniShukeiAfterPrintAttblJikkoTani getCelJikkoTaniShukeiAfterPrint() {
        return celJikkoTaniShukeiAfterPrint;
    }

    /*
     * setcelJikkoTaniShukeiAfterPrint
     * @param celJikkoTaniShukeiAfterPrint celJikkoTaniShukeiAfterPrint
     */
    @JsonProperty("celJikkoTaniShukeiAfterPrint")
    private void setCelJikkoTaniShukeiAfterPrint(celJikkoTaniShukeiAfterPrintAttblJikkoTani celJikkoTaniShukeiAfterPrint) {
        this.celJikkoTaniShukeiAfterPrint = celJikkoTaniShukeiAfterPrint;
    }

    /*
     * getcelJikkoTaniKakoShukeiKekka
     * @return celJikkoTaniKakoShukeiKekka
     */
    @JsonProperty("celJikkoTaniKakoShukeiKekka")
    private celJikkoTaniKakoShukeiKekkaAttblJikkoTani getCelJikkoTaniKakoShukeiKekka() {
        return celJikkoTaniKakoShukeiKekka;
    }

    /*
     * setcelJikkoTaniKakoShukeiKekka
     * @param celJikkoTaniKakoShukeiKekka celJikkoTaniKakoShukeiKekka
     */
    @JsonProperty("celJikkoTaniKakoShukeiKekka")
    private void setCelJikkoTaniKakoShukeiKekka(celJikkoTaniKakoShukeiKekkaAttblJikkoTani celJikkoTaniKakoShukeiKekka) {
        this.celJikkoTaniKakoShukeiKekka = celJikkoTaniKakoShukeiKekka;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
 * celJikkoTaniShukeiOnly のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTaniShukeiOnlyAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("txtHokokuYM")
    private TextBoxDate txtHokokuYM;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * gettxtHokokuYM
     * @return txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public TextBoxDate getTxtHokokuYM() {
        return txtHokokuYM;
    }

    /*
     * settxtHokokuYM
     * @param txtHokokuYM txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public void setTxtHokokuYM(TextBoxDate txtHokokuYM) {
        this.txtHokokuYM = txtHokokuYM;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    // </editor-fold>
}
/**
 * celJikkoTaniShukeiAfterPrint のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTaniShukeiAfterPrintAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("radJikkoTaniShukeiAfterPrint")
    private RadioButton radJikkoTaniShukeiAfterPrint;

    /*
     * getradJikkoTaniShukeiAfterPrint
     * @return radJikkoTaniShukeiAfterPrint
     */
    @JsonProperty("radJikkoTaniShukeiAfterPrint")
    public RadioButton getRadJikkoTaniShukeiAfterPrint() {
        return radJikkoTaniShukeiAfterPrint;
    }

    /*
     * setradJikkoTaniShukeiAfterPrint
     * @param radJikkoTaniShukeiAfterPrint radJikkoTaniShukeiAfterPrint
     */
    @JsonProperty("radJikkoTaniShukeiAfterPrint")
    public void setRadJikkoTaniShukeiAfterPrint(RadioButton radJikkoTaniShukeiAfterPrint) {
        this.radJikkoTaniShukeiAfterPrint = radJikkoTaniShukeiAfterPrint;
    }

    // </editor-fold>
}
/**
 * celJikkoTaniKakoShukeiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
class celJikkoTaniKakoShukeiKekkaAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("radJikkoTaniKakoShukeiKekka")
    private RadioButton radJikkoTaniKakoShukeiKekka;

    /*
     * getradJikkoTaniKakoShukeiKekka
     * @return radJikkoTaniKakoShukeiKekka
     */
    @JsonProperty("radJikkoTaniKakoShukeiKekka")
    public RadioButton getRadJikkoTaniKakoShukeiKekka() {
        return radJikkoTaniKakoShukeiKekka;
    }

    /*
     * setradJikkoTaniKakoShukeiKekka
     * @param radJikkoTaniKakoShukeiKekka radJikkoTaniKakoShukeiKekka
     */
    @JsonProperty("radJikkoTaniKakoShukeiKekka")
    public void setRadJikkoTaniKakoShukeiKekka(RadioButton radJikkoTaniKakoShukeiKekka) {
        this.radJikkoTaniKakoShukeiKekka = radJikkoTaniKakoShukeiKekka;
    }

    // </editor-fold>
}
/**
 * celKakoHokokuYM のクラスファイル 
 * 
 * @author 自動生成
 */
class celKakoHokokuYMAttblJikkoTani extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("ddlKakoHokokuYM")
    private DropDownList ddlKakoHokokuYM;
    @JsonProperty("radGappeiShichoson")
    private RadioButton radGappeiShichoson;
    @JsonProperty("radKoikiRengo")
    private RadioButton radKoikiRengo;
    @JsonProperty("btnShichosonSelect")
    private ButtonDialog btnShichosonSelect;

    /*
     * getddlKakoHokokuYM
     * @return ddlKakoHokokuYM
     */
    @JsonProperty("ddlKakoHokokuYM")
    public DropDownList getDdlKakoHokokuYM() {
        return ddlKakoHokokuYM;
    }

    /*
     * setddlKakoHokokuYM
     * @param ddlKakoHokokuYM ddlKakoHokokuYM
     */
    @JsonProperty("ddlKakoHokokuYM")
    public void setDdlKakoHokokuYM(DropDownList ddlKakoHokokuYM) {
        this.ddlKakoHokokuYM = ddlKakoHokokuYM;
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
