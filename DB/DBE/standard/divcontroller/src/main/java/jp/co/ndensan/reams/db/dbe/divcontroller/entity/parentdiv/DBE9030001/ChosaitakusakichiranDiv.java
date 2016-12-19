package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Chosaitakusakichiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaitakusakichiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnInsert")
    private Button btnInsert;
    @JsonProperty("btnOutputCsv")
    private ButtonDownLoad btnOutputCsv;
    @JsonProperty("btnOutputCsvCheck")
    private Button btnOutputCsvCheck;
    @JsonProperty("dgChosainIchiran")
    private DataGrid<dgChosainIchiran_Row> dgChosainIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnInsert
     * @return btnInsert
     */
    @JsonProperty("btnInsert")
    public Button getBtnInsert() {
        return btnInsert;
    }

    /*
     * setbtnInsert
     * @param btnInsert btnInsert
     */
    @JsonProperty("btnInsert")
    public void setBtnInsert(Button btnInsert) {
        this.btnInsert = btnInsert;
    }

    /*
     * getbtnOutputCsv
     * @return btnOutputCsv
     */
    @JsonProperty("btnOutputCsv")
    public ButtonDownLoad getBtnOutputCsv() {
        return btnOutputCsv;
    }

    /*
     * setbtnOutputCsv
     * @param btnOutputCsv btnOutputCsv
     */
    @JsonProperty("btnOutputCsv")
    public void setBtnOutputCsv(ButtonDownLoad btnOutputCsv) {
        this.btnOutputCsv = btnOutputCsv;
    }

    /*
     * getbtnOutputCsvCheck
     * @return btnOutputCsvCheck
     */
    @JsonProperty("btnOutputCsvCheck")
    public Button getBtnOutputCsvCheck() {
        return btnOutputCsvCheck;
    }

    /*
     * setbtnOutputCsvCheck
     * @param btnOutputCsvCheck btnOutputCsvCheck
     */
    @JsonProperty("btnOutputCsvCheck")
    public void setBtnOutputCsvCheck(Button btnOutputCsvCheck) {
        this.btnOutputCsvCheck = btnOutputCsvCheck;
    }

    /*
     * getdgChosainIchiran
     * @return dgChosainIchiran
     */
    @JsonProperty("dgChosainIchiran")
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return dgChosainIchiran;
    }

    /*
     * setdgChosainIchiran
     * @param dgChosainIchiran dgChosainIchiran
     */
    @JsonProperty("dgChosainIchiran")
    public void setDgChosainIchiran(DataGrid<dgChosainIchiran_Row> dgChosainIchiran) {
        this.dgChosainIchiran = dgChosainIchiran;
    }

    // </editor-fold>
}
