package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * shinsakaikanryo のクラスファイル 
 * 
 * @author 自動生成
 */
public class shinsakaikanryoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishosyaJotai")
    private RadioButton radTaishosyaJotai;
    @JsonProperty("txtTotalCount")
    private TextBox txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBox txtCompleteCount;
    @JsonProperty("txtMishoriCount")
    private TextBox txtMishoriCount;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishosyaJotai
     * @return radTaishosyaJotai
     */
    @JsonProperty("radTaishosyaJotai")
    public RadioButton getRadTaishosyaJotai() {
        return radTaishosyaJotai;
    }

    /*
     * setradTaishosyaJotai
     * @param radTaishosyaJotai radTaishosyaJotai
     */
    @JsonProperty("radTaishosyaJotai")
    public void setRadTaishosyaJotai(RadioButton radTaishosyaJotai) {
        this.radTaishosyaJotai = radTaishosyaJotai;
    }

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
     * gettxtMishoriCount
     * @return txtMishoriCount
     */
    @JsonProperty("txtMishoriCount")
    public TextBox getTxtMishoriCount() {
        return txtMishoriCount;
    }

    /*
     * settxtMishoriCount
     * @param txtMishoriCount txtMishoriCount
     */
    @JsonProperty("txtMishoriCount")
    public void setTxtMishoriCount(TextBox txtMishoriCount) {
        this.txtMishoriCount = txtMishoriCount;
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
