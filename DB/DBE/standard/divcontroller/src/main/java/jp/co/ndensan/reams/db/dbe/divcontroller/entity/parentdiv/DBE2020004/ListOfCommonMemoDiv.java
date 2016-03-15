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
 * ListOfCommonMemo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ListOfCommonMemoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddForListOfCommonMemo")
    private Button btnAddForListOfCommonMemo;
    @JsonProperty("dgListOfCommonMemo")
    private DataGrid<dgListOfCommonMemo_Row> dgListOfCommonMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddForListOfCommonMemo
     * @return btnAddForListOfCommonMemo
     */
    @JsonProperty("btnAddForListOfCommonMemo")
    public Button getBtnAddForListOfCommonMemo() {
        return btnAddForListOfCommonMemo;
    }

    /*
     * setbtnAddForListOfCommonMemo
     * @param btnAddForListOfCommonMemo btnAddForListOfCommonMemo
     */
    @JsonProperty("btnAddForListOfCommonMemo")
    public void setBtnAddForListOfCommonMemo(Button btnAddForListOfCommonMemo) {
        this.btnAddForListOfCommonMemo = btnAddForListOfCommonMemo;
    }

    /*
     * getdgListOfCommonMemo
     * @return dgListOfCommonMemo
     */
    @JsonProperty("dgListOfCommonMemo")
    public DataGrid<dgListOfCommonMemo_Row> getDgListOfCommonMemo() {
        return dgListOfCommonMemo;
    }

    /*
     * setdgListOfCommonMemo
     * @param dgListOfCommonMemo dgListOfCommonMemo
     */
    @JsonProperty("dgListOfCommonMemo")
    public void setDgListOfCommonMemo(DataGrid<dgListOfCommonMemo_Row> dgListOfCommonMemo) {
        this.dgListOfCommonMemo = dgListOfCommonMemo;
    }

    // </editor-fold>
}
