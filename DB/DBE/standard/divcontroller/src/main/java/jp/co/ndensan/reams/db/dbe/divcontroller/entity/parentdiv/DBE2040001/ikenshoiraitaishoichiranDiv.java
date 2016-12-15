package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ikenshoiraitaishoichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ikenshoiraitaishoichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTotalCount")
    private TextBox txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBox txtCompleteCount;
    @JsonProperty("txtNoUpdate")
    private TextBox txtNoUpdate;
    @JsonProperty("radShoriJyotai")
    private RadioButton radShoriJyotai;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTotalCount
     * @return txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public TextBox getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBox txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * gettxtCompleteCount
     * @return txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public TextBox getTxtCompleteCount() {
        return txtCompleteCount;
    }

    /*
     * settxtCompleteCount
     * @param txtCompleteCount txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public void setTxtCompleteCount(TextBox txtCompleteCount) {
        this.txtCompleteCount = txtCompleteCount;
    }

    /*
     * gettxtNoUpdate
     * @return txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public TextBox getTxtNoUpdate() {
        return txtNoUpdate;
    }

    /*
     * settxtNoUpdate
     * @param txtNoUpdate txtNoUpdate
     */
    @JsonProperty("txtNoUpdate")
    public void setTxtNoUpdate(TextBox txtNoUpdate) {
        this.txtNoUpdate = txtNoUpdate;
    }

    /*
     * getradShoriJyotai
     * @return radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public RadioButton getRadShoriJyotai() {
        return radShoriJyotai;
    }

    /*
     * setradShoriJyotai
     * @param radShoriJyotai radShoriJyotai
     */
    @JsonProperty("radShoriJyotai")
    public void setRadShoriJyotai(RadioButton radShoriJyotai) {
        this.radShoriJyotai = radShoriJyotai;
    }

    /*
     * getdgNinteiTaskList
     * @return dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return dgNinteiTaskList;
    }

    /*
     * setdgNinteiTaskList
     * @param dgNinteiTaskList dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public void setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.dgNinteiTaskList = dgNinteiTaskList;
    }

    // </editor-fold>
}
