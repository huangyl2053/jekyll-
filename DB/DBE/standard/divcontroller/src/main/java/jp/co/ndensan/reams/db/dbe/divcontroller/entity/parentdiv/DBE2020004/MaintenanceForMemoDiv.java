package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MaintenanceForMemo のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaintenanceForMemoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlMemoType")
    private DropDownList ddlMemoType;
    @JsonProperty("txtMemoNumber")
    private TextBox txtMemoNumber;
    @JsonProperty("ddlShiteiChosaChiku")
    private DropDownList ddlShiteiChosaChiku;
    @JsonProperty("txtCreator")
    private TextBox txtCreator;
    @JsonProperty("ddlMemoImportance")
    private DropDownList ddlMemoImportance;
    @JsonProperty("txtMemo")
    private TextBoxMultiLine txtMemo;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("btnAbort")
    private Button btnAbort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlMemoType
     * @return ddlMemoType
     */
    @JsonProperty("ddlMemoType")
    public DropDownList getDdlMemoType() {
        return ddlMemoType;
    }

    /*
     * setddlMemoType
     * @param ddlMemoType ddlMemoType
     */
    @JsonProperty("ddlMemoType")
    public void setDdlMemoType(DropDownList ddlMemoType) {
        this.ddlMemoType = ddlMemoType;
    }

    /*
     * gettxtMemoNumber
     * @return txtMemoNumber
     */
    @JsonProperty("txtMemoNumber")
    public TextBox getTxtMemoNumber() {
        return txtMemoNumber;
    }

    /*
     * settxtMemoNumber
     * @param txtMemoNumber txtMemoNumber
     */
    @JsonProperty("txtMemoNumber")
    public void setTxtMemoNumber(TextBox txtMemoNumber) {
        this.txtMemoNumber = txtMemoNumber;
    }

    /*
     * getddlShiteiChosaChiku
     * @return ddlShiteiChosaChiku
     */
    @JsonProperty("ddlShiteiChosaChiku")
    public DropDownList getDdlShiteiChosaChiku() {
        return ddlShiteiChosaChiku;
    }

    /*
     * setddlShiteiChosaChiku
     * @param ddlShiteiChosaChiku ddlShiteiChosaChiku
     */
    @JsonProperty("ddlShiteiChosaChiku")
    public void setDdlShiteiChosaChiku(DropDownList ddlShiteiChosaChiku) {
        this.ddlShiteiChosaChiku = ddlShiteiChosaChiku;
    }

    /*
     * gettxtCreator
     * @return txtCreator
     */
    @JsonProperty("txtCreator")
    public TextBox getTxtCreator() {
        return txtCreator;
    }

    /*
     * settxtCreator
     * @param txtCreator txtCreator
     */
    @JsonProperty("txtCreator")
    public void setTxtCreator(TextBox txtCreator) {
        this.txtCreator = txtCreator;
    }

    /*
     * getddlMemoImportance
     * @return ddlMemoImportance
     */
    @JsonProperty("ddlMemoImportance")
    public DropDownList getDdlMemoImportance() {
        return ddlMemoImportance;
    }

    /*
     * setddlMemoImportance
     * @param ddlMemoImportance ddlMemoImportance
     */
    @JsonProperty("ddlMemoImportance")
    public void setDdlMemoImportance(DropDownList ddlMemoImportance) {
        this.ddlMemoImportance = ddlMemoImportance;
    }

    /*
     * gettxtMemo
     * @return txtMemo
     */
    @JsonProperty("txtMemo")
    public TextBoxMultiLine getTxtMemo() {
        return txtMemo;
    }

    /*
     * settxtMemo
     * @param txtMemo txtMemo
     */
    @JsonProperty("txtMemo")
    public void setTxtMemo(TextBoxMultiLine txtMemo) {
        this.txtMemo = txtMemo;
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
     * getbtnAbort
     * @return btnAbort
     */
    @JsonProperty("btnAbort")
    public Button getBtnAbort() {
        return btnAbort;
    }

    /*
     * setbtnAbort
     * @param btnAbort btnAbort
     */
    @JsonProperty("btnAbort")
    public void setBtnAbort(Button btnAbort) {
        this.btnAbort = btnAbort;
    }

    // </editor-fold>
}
