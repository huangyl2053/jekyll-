package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiJikoNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJikoNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTokkiJikoGroup")
    private RadioButton radTokkiJikoGroup;
    @JsonProperty("ddlTokkiJikoNo")
    private DropDownList ddlTokkiJikoNo;
    @JsonProperty("btnInput")
    private Button btnInput;
    @JsonProperty("txtTokkiJiko")
    private TextBoxMultiLine txtTokkiJiko;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("btnDeleteCancel")
    private Button btnDeleteCancel;
    @JsonProperty("dgTokkiJikoJoho")
    private DataGrid<dgTokkiJikoJoho_Row> dgTokkiJikoJoho;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("btnUpdateCancel")
    private Button btnUpdateCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTokkiJikoGroup
     * @return radTokkiJikoGroup
     */
    @JsonProperty("radTokkiJikoGroup")
    public RadioButton getRadTokkiJikoGroup() {
        return radTokkiJikoGroup;
    }

    /*
     * setradTokkiJikoGroup
     * @param radTokkiJikoGroup radTokkiJikoGroup
     */
    @JsonProperty("radTokkiJikoGroup")
    public void setRadTokkiJikoGroup(RadioButton radTokkiJikoGroup) {
        this.radTokkiJikoGroup = radTokkiJikoGroup;
    }

    /*
     * getddlTokkiJikoNo
     * @return ddlTokkiJikoNo
     */
    @JsonProperty("ddlTokkiJikoNo")
    public DropDownList getDdlTokkiJikoNo() {
        return ddlTokkiJikoNo;
    }

    /*
     * setddlTokkiJikoNo
     * @param ddlTokkiJikoNo ddlTokkiJikoNo
     */
    @JsonProperty("ddlTokkiJikoNo")
    public void setDdlTokkiJikoNo(DropDownList ddlTokkiJikoNo) {
        this.ddlTokkiJikoNo = ddlTokkiJikoNo;
    }

    /*
     * getbtnInput
     * @return btnInput
     */
    @JsonProperty("btnInput")
    public Button getBtnInput() {
        return btnInput;
    }

    /*
     * setbtnInput
     * @param btnInput btnInput
     */
    @JsonProperty("btnInput")
    public void setBtnInput(Button btnInput) {
        this.btnInput = btnInput;
    }

    /*
     * gettxtTokkiJiko
     * @return txtTokkiJiko
     */
    @JsonProperty("txtTokkiJiko")
    public TextBoxMultiLine getTxtTokkiJiko() {
        return txtTokkiJiko;
    }

    /*
     * settxtTokkiJiko
     * @param txtTokkiJiko txtTokkiJiko
     */
    @JsonProperty("txtTokkiJiko")
    public void setTxtTokkiJiko(TextBoxMultiLine txtTokkiJiko) {
        this.txtTokkiJiko = txtTokkiJiko;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnDelete
     * @return btnDelete
     */
    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    /*
     * setbtnDelete
     * @param btnDelete btnDelete
     */
    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    /*
     * getbtnDeleteCancel
     * @return btnDeleteCancel
     */
    @JsonProperty("btnDeleteCancel")
    public Button getBtnDeleteCancel() {
        return btnDeleteCancel;
    }

    /*
     * setbtnDeleteCancel
     * @param btnDeleteCancel btnDeleteCancel
     */
    @JsonProperty("btnDeleteCancel")
    public void setBtnDeleteCancel(Button btnDeleteCancel) {
        this.btnDeleteCancel = btnDeleteCancel;
    }

    /*
     * getdgTokkiJikoJoho
     * @return dgTokkiJikoJoho
     */
    @JsonProperty("dgTokkiJikoJoho")
    public DataGrid<dgTokkiJikoJoho_Row> getDgTokkiJikoJoho() {
        return dgTokkiJikoJoho;
    }

    /*
     * setdgTokkiJikoJoho
     * @param dgTokkiJikoJoho dgTokkiJikoJoho
     */
    @JsonProperty("dgTokkiJikoJoho")
    public void setDgTokkiJikoJoho(DataGrid<dgTokkiJikoJoho_Row> dgTokkiJikoJoho) {
        this.dgTokkiJikoJoho = dgTokkiJikoJoho;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    /*
     * getbtnUpdateCancel
     * @return btnUpdateCancel
     */
    @JsonProperty("btnUpdateCancel")
    public Button getBtnUpdateCancel() {
        return btnUpdateCancel;
    }

    /*
     * setbtnUpdateCancel
     * @param btnUpdateCancel btnUpdateCancel
     */
    @JsonProperty("btnUpdateCancel")
    public void setBtnUpdateCancel(Button btnUpdateCancel) {
        this.btnUpdateCancel = btnUpdateCancel;
    }

    // </editor-fold>
}
