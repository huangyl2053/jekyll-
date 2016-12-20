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
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBoxNum txtCompleteCount;
    @JsonProperty("txtMishoriCount")
    private TextBoxNum txtMishoriCount;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;

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
    public TextBoxNum getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBoxNum txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * gettxtCompleteCount
     * @return txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public TextBoxNum getTxtCompleteCount() {
        return txtCompleteCount;
    }

    /*
     * settxtCompleteCount
     * @param txtCompleteCount txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public void setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.txtCompleteCount = txtCompleteCount;
    }

    /*
     * gettxtMishoriCount
     * @return txtMishoriCount
     */
    @JsonProperty("txtMishoriCount")
    public TextBoxNum getTxtMishoriCount() {
        return txtMishoriCount;
    }

    /*
     * settxtMishoriCount
     * @param txtMishoriCount txtMishoriCount
     */
    @JsonProperty("txtMishoriCount")
    public void setTxtMishoriCount(TextBoxNum txtMishoriCount) {
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

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    // </editor-fold>
}
