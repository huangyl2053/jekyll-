package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * chosairaitaishoshaichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class chosairaitaishoshaichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTaishoDataKubun")
    private RadioButton radTaishoDataKubun;
    @JsonProperty("txtTotalCount")
    private TextBoxNum txtTotalCount;
    @JsonProperty("txtCompleteCount")
    private TextBoxNum txtCompleteCount;
    @JsonProperty("txtMishoriCount")
    private TextBoxNum txtMishoriCount;
    @JsonProperty("dgYokaigoNinteiTaskList")
    private DataGrid<dgYokaigoNinteiTaskList_Row> dgYokaigoNinteiTaskList;
    @JsonProperty("TxtSaidaiHyojiKensu")
    private TextBoxNum TxtSaidaiHyojiKensu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradTaishoDataKubun
     * @return radTaishoDataKubun
     */
    @JsonProperty("radTaishoDataKubun")
    public RadioButton getRadTaishoDataKubun() {
        return radTaishoDataKubun;
    }

    /*
     * setradTaishoDataKubun
     * @param radTaishoDataKubun radTaishoDataKubun
     */
    @JsonProperty("radTaishoDataKubun")
    public void setRadTaishoDataKubun(RadioButton radTaishoDataKubun) {
        this.radTaishoDataKubun = radTaishoDataKubun;
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
     * getdgYokaigoNinteiTaskList
     * @return dgYokaigoNinteiTaskList
     */
    @JsonProperty("dgYokaigoNinteiTaskList")
    public DataGrid<dgYokaigoNinteiTaskList_Row> getDgYokaigoNinteiTaskList() {
        return dgYokaigoNinteiTaskList;
    }

    /*
     * setdgYokaigoNinteiTaskList
     * @param dgYokaigoNinteiTaskList dgYokaigoNinteiTaskList
     */
    @JsonProperty("dgYokaigoNinteiTaskList")
    public void setDgYokaigoNinteiTaskList(DataGrid<dgYokaigoNinteiTaskList_Row> dgYokaigoNinteiTaskList) {
        this.dgYokaigoNinteiTaskList = dgYokaigoNinteiTaskList;
    }

    /*
     * getTxtSaidaiHyojiKensu
     * @return TxtSaidaiHyojiKensu
     */
    @JsonProperty("TxtSaidaiHyojiKensu")
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return TxtSaidaiHyojiKensu;
    }

    /*
     * setTxtSaidaiHyojiKensu
     * @param TxtSaidaiHyojiKensu TxtSaidaiHyojiKensu
     */
    @JsonProperty("TxtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBoxNum TxtSaidaiHyojiKensu) {
        this.TxtSaidaiHyojiKensu = TxtSaidaiHyojiKensu;
    }

    // </editor-fold>
}
