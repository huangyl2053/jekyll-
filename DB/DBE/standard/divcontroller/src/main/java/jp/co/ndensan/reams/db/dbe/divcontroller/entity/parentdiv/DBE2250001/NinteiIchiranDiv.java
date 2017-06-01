package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinzu")
    private TextBoxNum txtNinzu;
    @JsonProperty("dgNinteiChosaData")
    private DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData;
    @JsonProperty("btnErrorListOutput")
    private ButtonDownLoad btnErrorListOutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinzu
     * @return txtNinzu
     */
    @JsonProperty("txtNinzu")
    public TextBoxNum getTxtNinzu() {
        return txtNinzu;
    }

    /*
     * settxtNinzu
     * @param txtNinzu txtNinzu
     */
    @JsonProperty("txtNinzu")
    public void setTxtNinzu(TextBoxNum txtNinzu) {
        this.txtNinzu = txtNinzu;
    }

    /*
     * getdgNinteiChosaData
     * @return dgNinteiChosaData
     */
    @JsonProperty("dgNinteiChosaData")
    public DataGrid<dgNinteiChosaData_Row> getDgNinteiChosaData() {
        return dgNinteiChosaData;
    }

    /*
     * setdgNinteiChosaData
     * @param dgNinteiChosaData dgNinteiChosaData
     */
    @JsonProperty("dgNinteiChosaData")
    public void setDgNinteiChosaData(DataGrid<dgNinteiChosaData_Row> dgNinteiChosaData) {
        this.dgNinteiChosaData = dgNinteiChosaData;
    }

    /*
     * getbtnErrorListOutput
     * @return btnErrorListOutput
     */
    @JsonProperty("btnErrorListOutput")
    public ButtonDownLoad getBtnErrorListOutput() {
        return btnErrorListOutput;
    }

    /*
     * setbtnErrorListOutput
     * @param btnErrorListOutput btnErrorListOutput
     */
    @JsonProperty("btnErrorListOutput")
    public void setBtnErrorListOutput(ButtonDownLoad btnErrorListOutput) {
        this.btnErrorListOutput = btnErrorListOutput;
    }

    // </editor-fold>
}
