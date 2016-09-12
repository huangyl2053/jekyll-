package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DeletePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DeletePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lbaImage")
    private Label lbaImage;
    @JsonProperty("chkImage")
    private CheckBoxList chkImage;
    @JsonProperty("lblDelete")
    private Label lblDelete;
    @JsonProperty("radDeleteTaisho")
    private RadioButton radDeleteTaisho;
    @JsonProperty("btnDelete")
    private Button btnDelete;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlbaImage
     * @return lbaImage
     */
    @JsonProperty("lbaImage")
    public Label getLbaImage() {
        return lbaImage;
    }

    /*
     * setlbaImage
     * @param lbaImage lbaImage
     */
    @JsonProperty("lbaImage")
    public void setLbaImage(Label lbaImage) {
        this.lbaImage = lbaImage;
    }

    /*
     * getchkImage
     * @return chkImage
     */
    @JsonProperty("chkImage")
    public CheckBoxList getChkImage() {
        return chkImage;
    }

    /*
     * setchkImage
     * @param chkImage chkImage
     */
    @JsonProperty("chkImage")
    public void setChkImage(CheckBoxList chkImage) {
        this.chkImage = chkImage;
    }

    /*
     * getlblDelete
     * @return lblDelete
     */
    @JsonProperty("lblDelete")
    public Label getLblDelete() {
        return lblDelete;
    }

    /*
     * setlblDelete
     * @param lblDelete lblDelete
     */
    @JsonProperty("lblDelete")
    public void setLblDelete(Label lblDelete) {
        this.lblDelete = lblDelete;
    }

    /*
     * getradDeleteTaisho
     * @return radDeleteTaisho
     */
    @JsonProperty("radDeleteTaisho")
    public RadioButton getRadDeleteTaisho() {
        return radDeleteTaisho;
    }

    /*
     * setradDeleteTaisho
     * @param radDeleteTaisho radDeleteTaisho
     */
    @JsonProperty("radDeleteTaisho")
    public void setRadDeleteTaisho(RadioButton radDeleteTaisho) {
        this.radDeleteTaisho = radDeleteTaisho;
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

    // </editor-fold>
}
