package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * shinsakaitorokuichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class shinsakaitorokuichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoshaJotai")
    private RadioButton radTaishoshaJotai;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBoxNum txtCompleteCount;
    @JsonProperty("txtMishoriCount")
    private TextBoxNum txtMishoriCount;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;
    @JsonProperty("txtTaishoshaMaxHyojiKensu")
    private TextBoxNum txtTaishoshaMaxHyojiKensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoshaJotai
     * @return radTaishoshaJotai
     */
    @JsonProperty("radTaishoshaJotai")
    public RadioButton getRadTaishoshaJotai() {
        return radTaishoshaJotai;
    }

    /*
     * setradTaishoshaJotai
     * @param radTaishoshaJotai radTaishoshaJotai
     */
    @JsonProperty("radTaishoshaJotai")
    public void setRadTaishoshaJotai(RadioButton radTaishoshaJotai) {
        this.radTaishoshaJotai = radTaishoshaJotai;
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
     * gettxtTaishoshaMaxHyojiKensu
     * @return txtTaishoshaMaxHyojiKensu
     */
    @JsonProperty("txtTaishoshaMaxHyojiKensu")
    public TextBoxNum getTxtTaishoshaMaxHyojiKensu() {
        return txtTaishoshaMaxHyojiKensu;
    }

    /*
     * settxtTaishoshaMaxHyojiKensu
     * @param txtTaishoshaMaxHyojiKensu txtTaishoshaMaxHyojiKensu
     */
    @JsonProperty("txtTaishoshaMaxHyojiKensu")
    public void setTxtTaishoshaMaxHyojiKensu(TextBoxNum txtTaishoshaMaxHyojiKensu) {
        this.txtTaishoshaMaxHyojiKensu = txtTaishoshaMaxHyojiKensu;
    }

    // </editor-fold>
}
