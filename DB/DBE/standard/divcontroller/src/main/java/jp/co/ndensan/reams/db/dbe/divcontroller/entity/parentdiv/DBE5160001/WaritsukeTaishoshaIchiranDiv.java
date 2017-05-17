package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * WaritsukeTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class WaritsukeTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-15_14-55-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTaishosha")
    private Label lblTaishosha;
    @JsonProperty("lblTaishoshaSort")
    private Label lblTaishoshaSort;
    @JsonProperty("chkTaishoshaFilter")
    private CheckBoxList chkTaishoshaFilter;
    @JsonProperty("dgTaishoshaIchiran")
    private DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTaishosha
     * @return lblTaishosha
     */
    @JsonProperty("lblTaishosha")
    public Label getLblTaishosha() {
        return lblTaishosha;
    }

    /*
     * setlblTaishosha
     * @param lblTaishosha lblTaishosha
     */
    @JsonProperty("lblTaishosha")
    public void setLblTaishosha(Label lblTaishosha) {
        this.lblTaishosha = lblTaishosha;
    }

    /*
     * getlblTaishoshaSort
     * @return lblTaishoshaSort
     */
    @JsonProperty("lblTaishoshaSort")
    public Label getLblTaishoshaSort() {
        return lblTaishoshaSort;
    }

    /*
     * setlblTaishoshaSort
     * @param lblTaishoshaSort lblTaishoshaSort
     */
    @JsonProperty("lblTaishoshaSort")
    public void setLblTaishoshaSort(Label lblTaishoshaSort) {
        this.lblTaishoshaSort = lblTaishoshaSort;
    }

    /*
     * getchkTaishoshaFilter
     * @return chkTaishoshaFilter
     */
    @JsonProperty("chkTaishoshaFilter")
    public CheckBoxList getChkTaishoshaFilter() {
        return chkTaishoshaFilter;
    }

    /*
     * setchkTaishoshaFilter
     * @param chkTaishoshaFilter chkTaishoshaFilter
     */
    @JsonProperty("chkTaishoshaFilter")
    public void setChkTaishoshaFilter(CheckBoxList chkTaishoshaFilter) {
        this.chkTaishoshaFilter = chkTaishoshaFilter;
    }

    /*
     * getdgTaishoshaIchiran
     * @return dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return dgTaishoshaIchiran;
    }

    /*
     * setdgTaishoshaIchiran
     * @param dgTaishoshaIchiran dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public void setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.dgTaishoshaIchiran = dgTaishoshaIchiran;
    }

    // </editor-fold>
}
