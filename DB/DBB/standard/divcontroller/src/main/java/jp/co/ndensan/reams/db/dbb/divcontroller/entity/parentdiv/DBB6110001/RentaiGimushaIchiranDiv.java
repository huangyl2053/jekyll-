package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RentaiGimushaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class RentaiGimushaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgRentaiNofuGimushaIchiran")
    private DataGrid<dgRentaiNofuGimushaIchiran_Row> dgRentaiNofuGimushaIchiran;

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
     * getdgRentaiNofuGimushaIchiran
     * @return dgRentaiNofuGimushaIchiran
     */
    @JsonProperty("dgRentaiNofuGimushaIchiran")
    public DataGrid<dgRentaiNofuGimushaIchiran_Row> getDgRentaiNofuGimushaIchiran() {
        return dgRentaiNofuGimushaIchiran;
    }

    /*
     * setdgRentaiNofuGimushaIchiran
     * @param dgRentaiNofuGimushaIchiran dgRentaiNofuGimushaIchiran
     */
    @JsonProperty("dgRentaiNofuGimushaIchiran")
    public void setDgRentaiNofuGimushaIchiran(DataGrid<dgRentaiNofuGimushaIchiran_Row> dgRentaiNofuGimushaIchiran) {
        this.dgRentaiNofuGimushaIchiran = dgRentaiNofuGimushaIchiran;
    }

    // </editor-fold>
}
