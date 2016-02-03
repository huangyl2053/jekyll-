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
 * ListOfJichikuMemo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ListOfJichikuMemoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddForListOfJichikuMemo")
    private Button btnAddForListOfJichikuMemo;
    @JsonProperty("dgListOfJichikuMemo")
    private DataGrid<dgListOfJichikuMemo_Row> dgListOfJichikuMemo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddForListOfJichikuMemo
     * @return btnAddForListOfJichikuMemo
     */
    @JsonProperty("btnAddForListOfJichikuMemo")
    public Button getBtnAddForListOfJichikuMemo() {
        return btnAddForListOfJichikuMemo;
    }

    /*
     * setbtnAddForListOfJichikuMemo
     * @param btnAddForListOfJichikuMemo btnAddForListOfJichikuMemo
     */
    @JsonProperty("btnAddForListOfJichikuMemo")
    public void setBtnAddForListOfJichikuMemo(Button btnAddForListOfJichikuMemo) {
        this.btnAddForListOfJichikuMemo = btnAddForListOfJichikuMemo;
    }

    /*
     * getdgListOfJichikuMemo
     * @return dgListOfJichikuMemo
     */
    @JsonProperty("dgListOfJichikuMemo")
    public DataGrid<dgListOfJichikuMemo_Row> getDgListOfJichikuMemo() {
        return dgListOfJichikuMemo;
    }

    /*
     * setdgListOfJichikuMemo
     * @param dgListOfJichikuMemo dgListOfJichikuMemo
     */
    @JsonProperty("dgListOfJichikuMemo")
    public void setDgListOfJichikuMemo(DataGrid<dgListOfJichikuMemo_Row> dgListOfJichikuMemo) {
        this.dgListOfJichikuMemo = dgListOfJichikuMemo;
    }

    // </editor-fold>
}
