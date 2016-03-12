package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlKyufuhiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlKyufuhiMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgJushochiTokutei")
    private DataGrid<dgJushochiTokutei_Row> dgJushochiTokutei;
    @JsonProperty("PnlKyufuhiMeisaiTouroku")
    private PnlKyufuhiMeisaiTourokuDiv PnlKyufuhiMeisaiTouroku;
    @JsonProperty("rowId")
    private TextBoxNum rowId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgJushochiTokutei
     * @return dgJushochiTokutei
     */
    @JsonProperty("dgJushochiTokutei")
    public DataGrid<dgJushochiTokutei_Row> getDgJushochiTokutei() {
        return dgJushochiTokutei;
    }

    /*
     * setdgJushochiTokutei
     * @param dgJushochiTokutei dgJushochiTokutei
     */
    @JsonProperty("dgJushochiTokutei")
    public void setDgJushochiTokutei(DataGrid<dgJushochiTokutei_Row> dgJushochiTokutei) {
        this.dgJushochiTokutei = dgJushochiTokutei;
    }

    /*
     * getPnlKyufuhiMeisaiTouroku
     * @return PnlKyufuhiMeisaiTouroku
     */
    @JsonProperty("PnlKyufuhiMeisaiTouroku")
    public PnlKyufuhiMeisaiTourokuDiv getPnlKyufuhiMeisaiTouroku() {
        return PnlKyufuhiMeisaiTouroku;
    }

    /*
     * setPnlKyufuhiMeisaiTouroku
     * @param PnlKyufuhiMeisaiTouroku PnlKyufuhiMeisaiTouroku
     */
    @JsonProperty("PnlKyufuhiMeisaiTouroku")
    public void setPnlKyufuhiMeisaiTouroku(PnlKyufuhiMeisaiTourokuDiv PnlKyufuhiMeisaiTouroku) {
        this.PnlKyufuhiMeisaiTouroku = PnlKyufuhiMeisaiTouroku;
    }

    /*
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    // </editor-fold>
}
